package net.regions_unexplored.block.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.regions_unexplored.Constants;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.entity.custom.RuHangingSignBlockEntity;
import net.regions_unexplored.block.entity.custom.RuSignBlockEntity;

import java.util.HashMap;
import java.util.Map;

public class RegionsUnexploredBlockEntities {
    public static Map<String, BlockEntityType<?>> BLOCK_ENTITY = new HashMap<>();

    public static final BlockEntityType<RuSignBlockEntity> SIGN_BLOCK_ENTITIES = registerBlockEntity("sign_block_entity",
            BlockEntityType.Builder.of(RuSignBlockEntity::new,
                    RuBlocks.BAOBAB_WALL_SIGN, RuBlocks.BAOBAB_SIGN,
                    RuBlocks.BLACKWOOD_WALL_SIGN, RuBlocks.BLACKWOOD_SIGN,
                    RuBlocks.BLUE_BIOSHROOM_WALL_SIGN, RuBlocks.BLUE_BIOSHROOM_SIGN,
                    RuBlocks.BRIMWOOD_WALL_SIGN, RuBlocks.BRIMWOOD_SIGN,
                    RuBlocks.COBALT_WALL_SIGN, RuBlocks.COBALT_SIGN,
                    RuBlocks.CYPRESS_WALL_SIGN, RuBlocks.CYPRESS_SIGN,
                    RuBlocks.DEAD_WALL_SIGN, RuBlocks.DEAD_SIGN,
                    RuBlocks.EUCALYPTUS_WALL_SIGN, RuBlocks.EUCALYPTUS_SIGN,
                    RuBlocks.GREEN_BIOSHROOM_WALL_SIGN, RuBlocks.GREEN_BIOSHROOM_SIGN,
                    RuBlocks.JOSHUA_WALL_SIGN, RuBlocks.JOSHUA_SIGN,
                    RuBlocks.KAPOK_WALL_SIGN, RuBlocks.KAPOK_SIGN,
                    RuBlocks.LARCH_WALL_SIGN, RuBlocks.LARCH_SIGN,
                    RuBlocks.MAGNOLIA_WALL_SIGN, RuBlocks.MAGNOLIA_SIGN,
                    RuBlocks.MAPLE_WALL_SIGN, RuBlocks.MAPLE_SIGN,
                    RuBlocks.MAUVE_WALL_SIGN, RuBlocks.MAUVE_SIGN,
                    RuBlocks.PALM_WALL_SIGN, RuBlocks.PALM_SIGN,
                    RuBlocks.PINE_WALL_SIGN, RuBlocks.PINE_SIGN,
                    RuBlocks.PINK_BIOSHROOM_WALL_SIGN, RuBlocks.PINK_BIOSHROOM_SIGN,
                    RuBlocks.REDWOOD_WALL_SIGN, RuBlocks.REDWOOD_SIGN,
                    RuBlocks.SOCOTRA_WALL_SIGN, RuBlocks.SOCOTRA_SIGN,
                    RuBlocks.WILLOW_WALL_SIGN, RuBlocks.WILLOW_SIGN,
                    RuBlocks.YELLOW_BIOSHROOM_WALL_SIGN, RuBlocks.YELLOW_BIOSHROOM_SIGN
            ).build(null));

    public static final BlockEntityType<RuSignBlockEntity> HANGING_SIGN_BLOCK_ENTITIES = registerBlockEntity("hanging_sign_block_entity",

            BlockEntityType.Builder.of(RuHangingSignBlockEntity::new,

            RuBlocks.BAOBAB_WALL_HANGING_SIGN, RuBlocks.BAOBAB_HANGING_SIGN,
            RuBlocks.BLACKWOOD_WALL_HANGING_SIGN, RuBlocks.BLACKWOOD_HANGING_SIGN,
            RuBlocks.BLUE_BIOSHROOM_WALL_HANGING_SIGN, RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN,
            RuBlocks.BRIMWOOD_WALL_HANGING_SIGN, RuBlocks.BRIMWOOD_HANGING_SIGN,
            RuBlocks.COBALT_WALL_HANGING_SIGN, RuBlocks.COBALT_HANGING_SIGN,
            RuBlocks.CYPRESS_WALL_HANGING_SIGN, RuBlocks.CYPRESS_HANGING_SIGN,
            RuBlocks.DEAD_WALL_HANGING_SIGN, RuBlocks.DEAD_HANGING_SIGN,
            RuBlocks.EUCALYPTUS_WALL_HANGING_SIGN, RuBlocks.EUCALYPTUS_HANGING_SIGN,
            RuBlocks.GREEN_BIOSHROOM_WALL_HANGING_SIGN, RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN,
            RuBlocks.JOSHUA_WALL_HANGING_SIGN, RuBlocks.JOSHUA_HANGING_SIGN,
            RuBlocks.KAPOK_WALL_HANGING_SIGN, RuBlocks.KAPOK_HANGING_SIGN,
            RuBlocks.LARCH_WALL_HANGING_SIGN, RuBlocks.LARCH_HANGING_SIGN,
            RuBlocks.MAGNOLIA_WALL_HANGING_SIGN, RuBlocks.MAGNOLIA_HANGING_SIGN,
            RuBlocks.MAPLE_WALL_HANGING_SIGN, RuBlocks.MAPLE_HANGING_SIGN,
            RuBlocks.MAUVE_WALL_HANGING_SIGN, RuBlocks.MAUVE_HANGING_SIGN,
            RuBlocks.PALM_WALL_HANGING_SIGN, RuBlocks.PALM_HANGING_SIGN,
            RuBlocks.PINE_WALL_HANGING_SIGN, RuBlocks.PINE_HANGING_SIGN,
            RuBlocks.PINK_BIOSHROOM_WALL_HANGING_SIGN, RuBlocks.PINK_BIOSHROOM_HANGING_SIGN,
            RuBlocks.REDWOOD_WALL_HANGING_SIGN, RuBlocks.REDWOOD_HANGING_SIGN,
            RuBlocks.SOCOTRA_WALL_HANGING_SIGN, RuBlocks.SOCOTRA_HANGING_SIGN,
            RuBlocks.WILLOW_WALL_HANGING_SIGN, RuBlocks.WILLOW_HANGING_SIGN,
            RuBlocks.YELLOW_BIOSHROOM_WALL_HANGING_SIGN, RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN

            ).build(null));

    public static void addBlockEntities() {
        if (BLOCK_ENTITY.isEmpty()) return;
        BLOCK_ENTITY.forEach(RegionsUnexploredBlockEntities::registerBlockEntity);
    }

    private static BlockEntityType registerBlockEntity(String path, BlockEntityType type) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.id(path), type);
    }
}
