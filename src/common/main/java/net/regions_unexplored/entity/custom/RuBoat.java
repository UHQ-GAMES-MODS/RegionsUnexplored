package net.regions_unexplored.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.entity.RuEntities;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.Supplier;

public class RuBoat extends Boat {
    public RuBoat(EntityType<? extends RuBoat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public RuBoat(Level level, double x, double y, double z) {
        this(RuEntities.BOAT.get(), level);
        this.setPos(x, y, z); this.xo = x; this.yo = y; this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return this.getModel().getWoodSet().getBoat();
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("model", getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("model", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_TYPE, ModelType.byName(tag.getString("model")).ordinal());
        }
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

    public void setModel(ModelType model) {
        this.entityData.set(DATA_ID_TYPE, model.ordinal());
    }

    public ModelType getModel() {
        return ModelType.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public enum ModelType {
        BAOBAB("baobab", () -> RuBlocks.BAOBAB_WOOD_SET),
        BLACKWOOD("blackwood", () -> RuBlocks.BLACKWOOD_WOOD_SET),
        CYPRESS("cypress", () -> RuBlocks.CYPRESS_WOOD_SET),
        DEAD("dead", () -> RuBlocks.DEAD_WOOD_SET),
        EUCALYPTUS("eucalyptus", () -> RuBlocks.EUCALYPTUS_WOOD_SET),
        JOSHUA("joshua", () -> RuBlocks.JOSHUA_WOOD_SET),
        KAPOK("kapok", () -> RuBlocks.KAPOK_WOOD_SET),
        LARCH("larch", () -> RuBlocks.LARCH_WOOD_SET),
        MAGNOLIA("magnolia", () -> RuBlocks.MAGNOLIA_WOOD_SET),
        MAPLE("maple", () -> RuBlocks.MAPLE_WOOD_SET),
        MAUVE("mauve", () -> RuBlocks.MAUVE_WOOD_SET),
        PALM("palm", () -> RuBlocks.PALM_WOOD_SET),
        PINE("pine", () -> RuBlocks.PINE_WOOD_SET),
        REDWOOD("redwood", () -> RuBlocks.REDWOOD_WOOD_SET),
        SOCOTRA("socotra", () -> RuBlocks.SOCOTRA_WOOD_SET),
        WILLOW("willow", () -> RuBlocks.WILLOW_WOOD_SET);

        private final String name;
        private final Supplier<WoodSet> woodSet;

        ModelType(String name, Supplier<WoodSet> woodSet) {
            this.name = name;
            this.woodSet = woodSet;
        }

        public String getName() {
            return this.name;
        }

        public WoodSet getWoodSet() {
            return this.woodSet.get();
        }

        public String toString() {
            return this.name;
        }

        public static ModelType byId(int id) {
            ModelType[] model = values();
            return model[id < 0 || id >= model.length ? 0 : id];
        }

        public static ModelType byName(String name) {
            ModelType[] model = values();
            return Arrays.stream(model).filter(t -> t.getName().equals(name)).findFirst().orElse(model[0]);
        }
    }
}