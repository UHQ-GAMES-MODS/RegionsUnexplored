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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.item.RuItems;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

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
        return switch (getModel()) {
            case BAOBAB -> RuItems.BAOBAB_BOAT.get();
            case BLACKWOOD -> RuItems.BLACKWOOD_BOAT.get();
            case CYPRESS -> RuItems.CYPRESS_BOAT.get();
            case DEAD -> RuItems.DEAD_BOAT.get();
            case EUCALYPTUS -> RuItems.EUCALYPTUS_BOAT.get();
            case JOSHUA -> RuItems.JOSHUA_BOAT.get();
            case KAPOK -> RuItems.KAPOK_BOAT.get();
            case LARCH -> RuItems.LARCH_BOAT.get();
            case MAGNOLIA -> RuItems.MAGNOLIA_BOAT.get();
            case MAPLE -> RuItems.MAPLE_BOAT.get();
            case MAUVE -> RuItems.MAUVE_BOAT.get();
            case PALM -> RuItems.PALM_BOAT.get();
            case PINE -> RuItems.PINE_BOAT.get();
            case REDWOOD -> RuItems.REDWOOD_BOAT.get();
            case SOCOTRA -> RuItems.SOCOTRA_BOAT.get();
            case WILLOW -> RuItems.WILLOW_BOAT.get();
        };
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
        BAOBAB("baobab", RuBlocks.BAOBAB_WOOD_SET.getPlanks()),
        BLACKWOOD("blackwood", RuBlocks.BLACKWOOD_WOOD_SET.getPlanks()),
        CYPRESS("cypress", RuBlocks.CYPRESS_WOOD_SET.getPlanks()),
        DEAD("dead", RuBlocks.DEAD_WOOD_SET.getPlanks()),
        EUCALYPTUS("eucalyptus", RuBlocks.EUCALYPTUS_WOOD_SET.getPlanks()),
        JOSHUA("joshua", RuBlocks.JOSHUA_WOOD_SET.getPlanks()),
        KAPOK("kapok", RuBlocks.KAPOK_WOOD_SET.getPlanks()),
        LARCH("larch", RuBlocks.LARCH_WOOD_SET.getPlanks()),
        MAGNOLIA("magnolia", RuBlocks.MAGNOLIA_WOOD_SET.getPlanks()),
        MAPLE("maple", RuBlocks.MAPLE_WOOD_SET.getPlanks()),
        MAUVE("mauve", RuBlocks.MAUVE_WOOD_SET.getPlanks()),
        PALM("palm", RuBlocks.PALM_WOOD_SET.getPlanks()),
        PINE("pine", RuBlocks.PINE_WOOD_SET.getPlanks()),
        REDWOOD("redwood", RuBlocks.REDWOOD_WOOD_SET.getPlanks()),
        SOCOTRA("socotra", RuBlocks.SOCOTRA_WOOD_SET.getPlanks()),
        WILLOW("willow", RuBlocks.WILLOW_WOOD_SET.getPlanks());

        private final String name;
        private final Block planks;

        ModelType(String name, Block planks) {
            this.name = name;
            this.planks = planks;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
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