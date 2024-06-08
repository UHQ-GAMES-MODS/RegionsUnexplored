package net.regions_unexplored.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
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
import net.regions_unexplored.entity.RegionsUnexploredEntities;
import net.regions_unexplored.item.RuItems;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RuBoat extends Boat {
    public RuBoat(EntityType<? extends RuBoat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public RuBoat(Level level, double x, double y, double z) {
        this((EntityType<RuBoat>) RegionsUnexploredEntities.BOAT, level);
        this.setPos(x, y, z); this.xo = x; this.yo = y; this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return switch (getModel()) {
            case BAOBAB -> RuItems.BAOBAB_BOAT;
            case BLACKWOOD -> RuItems.BLACKWOOD_BOAT;
            case CYPRESS -> RuItems.CYPRESS_BOAT;
            case DEAD -> RuItems.DEAD_BOAT;
            case EUCALYPTUS -> RuItems.EUCALYPTUS_BOAT;
            case JOSHUA -> RuItems.JOSHUA_BOAT;
            case KAPOK -> RuItems.KAPOK_BOAT;
            case LARCH -> RuItems.LARCH_BOAT;
            case MAGNOLIA -> RuItems.MAGNOLIA_BOAT;
            case MAPLE -> RuItems.MAPLE_BOAT;
            case MAUVE -> RuItems.MAUVE_BOAT;
            case PALM -> RuItems.PALM_BOAT;
            case PINE -> RuItems.PINE_BOAT;
            case REDWOOD -> RuItems.REDWOOD_BOAT;
            case SOCOTRA -> RuItems.SOCOTRA_BOAT;
            case WILLOW -> RuItems.WILLOW_BOAT;
        };
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
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
        BAOBAB("baobab", RuBlocks.BAOBAB_PLANKS),
        BLACKWOOD("blackwood", RuBlocks.BLACKWOOD_PLANKS),
        CYPRESS("cypress", RuBlocks.CYPRESS_PLANKS),
        DEAD("dead", RuBlocks.DEAD_PLANKS),
        EUCALYPTUS("eucalyptus", RuBlocks.EUCALYPTUS_PLANKS),
        JOSHUA("joshua", RuBlocks.JOSHUA_PLANKS),
        KAPOK("kapok", RuBlocks.KAPOK_PLANKS),
        LARCH("larch", RuBlocks.LARCH_PLANKS),
        MAGNOLIA("magnolia", RuBlocks.MAGNOLIA_PLANKS),
        MAPLE("maple", RuBlocks.MAPLE_PLANKS),
        MAUVE("mauve", RuBlocks.MAUVE_PLANKS),
        PALM("palm", RuBlocks.PALM_PLANKS),
        PINE("pine", RuBlocks.PINE_PLANKS),
        REDWOOD("redwood", RuBlocks.REDWOOD_PLANKS),
        SOCOTRA("socotra", RuBlocks.SOCOTRA_PLANKS),
        WILLOW("willow", RuBlocks.WILLOW_PLANKS);

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