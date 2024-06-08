package net.regions_unexplored.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
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
import net.regions_unexplored.entity.RegionsUnexploredEntities;
import net.regions_unexplored.item.RuItems;
import org.jetbrains.annotations.NotNull;

public class RuChestBoat extends ChestBoat
{
    public RuChestBoat(EntityType<? extends RuChestBoat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public RuChestBoat(Level level, double x, double y, double z) {
        this((EntityType<RuChestBoat>) RegionsUnexploredEntities.CHEST_BOAT, level);
        this.setPos(x, y, z); this.xo = x; this.yo = y; this.zo = z;
    }

    @Override
    public Item getDropItem()
    {
        return switch (RuBoat.ModelType.byId(this.entityData.get(DATA_ID_TYPE))) {
            case BAOBAB -> RuItems.BAOBAB_CHEST_BOAT;
            case BLACKWOOD -> RuItems.BLACKWOOD_CHEST_BOAT;
            case CYPRESS -> RuItems.CYPRESS_CHEST_BOAT;
            case DEAD -> RuItems.DEAD_CHEST_BOAT;
            case EUCALYPTUS -> RuItems.EUCALYPTUS_CHEST_BOAT;
            case JOSHUA -> RuItems.JOSHUA_CHEST_BOAT;
            case KAPOK -> RuItems.KAPOK_CHEST_BOAT;
            case LARCH -> RuItems.LARCH_CHEST_BOAT;
            case MAGNOLIA -> RuItems.MAGNOLIA_CHEST_BOAT;
            case MAPLE -> RuItems.MAPLE_CHEST_BOAT;
            case MAUVE -> RuItems.MAUVE_CHEST_BOAT;
            case PALM -> RuItems.PALM_CHEST_BOAT;
            case PINE -> RuItems.PINE_CHEST_BOAT;
            case REDWOOD -> RuItems.REDWOOD_CHEST_BOAT;
            case SOCOTRA -> RuItems.SOCOTRA_CHEST_BOAT;
            case WILLOW -> RuItems.WILLOW_CHEST_BOAT;
        };
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
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