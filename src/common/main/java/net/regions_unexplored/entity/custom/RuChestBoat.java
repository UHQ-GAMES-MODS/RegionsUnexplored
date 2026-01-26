package net.regions_unexplored.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.registry.RUEntityTypes;
import org.jetbrains.annotations.NotNull;

public class RuChestBoat extends ChestBoat
{
    public RuChestBoat(EntityType<? extends RuChestBoat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public RuChestBoat(Level level, double x, double y, double z) {
        this(RUEntityTypes.CHEST_BOAT.get(), level);
        this.setPos(x, y, z); this.xo = x; this.yo = y; this.zo = z;
    }

    @Override
    public Item getDropItem() {
        RuBoat.ModelType modelType = RuBoat.ModelType.byId(this.entityData.get(DATA_ID_TYPE));
        return modelType.getWoodSet().getChestBoat();
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("model", getModel().getName());
        this.addChestVehicleSaveData(tag, this.registryAccess());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("model", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_TYPE, RuBoat.ModelType.byName(tag.getString("model")).ordinal());
        }
        this.readChestVehicleSaveData(tag, this.registryAccess());
    }

    @Override
    protected @NotNull Vec3 getPassengerAttachmentPoint(@NotNull Entity entity, @NotNull EntityDimensions entityDimensions, float isBamboo) {
        float f = this.getSinglePassengerXOffset();
        if (this.getPassengers().size() > 1) {
            int i = this.getPassengers().indexOf(entity);
            if (i == 0) {
                f = 0.2F;
            } else {
                f = -0.6F;
            }

            if (entity instanceof Animal) {
                f += 0.2F;
            }
        }

        return new Vec3(0.0F, entityDimensions.height() / 3.0F, f);
    }

    @Override
    protected void checkFallDamage(double distance, boolean bool, BlockState state, BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;
        if (!this.isPassenger()) {
            if (bool) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());
                    if (!this.level().isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for(int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getVariant().getPlanks());
                            }

                            for(int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }
                        }
                    }
                }

                this.resetFallDistance();
            } else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && distance < 0.0) {
                this.fallDistance -= (float)distance;
            }

        }
    }

    public void setModel(RuBoat.ModelType model) {
        this.entityData.set(DATA_ID_TYPE, model.ordinal());
    }

    public RuBoat.ModelType getModel() {
        return RuBoat.ModelType.byId(this.entityData.get(DATA_ID_TYPE));
    }
}