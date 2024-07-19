package net.regions_unexplored.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.entity.custom.RuHangingSignBlockEntity;
import net.regions_unexplored.block.entity.custom.RuSignBlockEntity;
import net.regions_unexplored.platform.Services;

import java.util.function.Supplier;

public class RegionsUnexploredBlockEntities {

    public static final Supplier<BlockEntityType<?>> SIGN_BLOCK_ENTITIES = registerBlockEntity("sign_block_entity",
            () -> BlockEntityType.Builder.of(RuSignBlockEntity::new,
                    RuBlocks.BAOBAB_WALL_SIGN.get(), RuBlocks.BAOBAB_SIGN.get(),
                    RuBlocks.BLACKWOOD_WALL_SIGN.get(), RuBlocks.BLACKWOOD_SIGN.get(),
                    RuBlocks.BLUE_BIOSHROOM_WALL_SIGN.get(), RuBlocks.BLUE_BIOSHROOM_SIGN.get(),
                    RuBlocks.BRIMWOOD_WALL_SIGN.get(), RuBlocks.BRIMWOOD_SIGN.get(),
                    RuBlocks.COBALT_WALL_SIGN.get(), RuBlocks.COBALT_SIGN.get(),
                    RuBlocks.CYPRESS_WALL_SIGN.get(), RuBlocks.CYPRESS_SIGN.get(),
                    RuBlocks.DEAD_WALL_SIGN.get(), RuBlocks.DEAD_SIGN.get(),
                    RuBlocks.EUCALYPTUS_WALL_SIGN.get(), RuBlocks.EUCALYPTUS_SIGN.get(),
                    RuBlocks.GREEN_BIOSHROOM_WALL_SIGN.get(), RuBlocks.GREEN_BIOSHROOM_SIGN.get(),
                    RuBlocks.JOSHUA_WALL_SIGN.get(), RuBlocks.JOSHUA_SIGN.get(),
                    RuBlocks.KAPOK_WALL_SIGN.get(), RuBlocks.KAPOK_SIGN.get(),
                    RuBlocks.LARCH_WALL_SIGN.get(), RuBlocks.LARCH_SIGN.get(),
                    RuBlocks.MAGNOLIA_WALL_SIGN.get(), RuBlocks.MAGNOLIA_SIGN.get(),
                    RuBlocks.MAPLE_WALL_SIGN.get(), RuBlocks.MAPLE_SIGN.get(),
                    RuBlocks.MAUVE_WALL_SIGN.get(), RuBlocks.MAUVE_SIGN.get(),
                    RuBlocks.PALM_WALL_SIGN.get(), RuBlocks.PALM_SIGN.get(),
                    RuBlocks.PINE_WALL_SIGN.get(), RuBlocks.PINE_SIGN.get(),
                    RuBlocks.PINK_BIOSHROOM_WALL_SIGN.get(), RuBlocks.PINK_BIOSHROOM_SIGN.get(),
                    RuBlocks.REDWOOD_WALL_SIGN.get(), RuBlocks.REDWOOD_SIGN.get(),
                    RuBlocks.SOCOTRA_WALL_SIGN.get(), RuBlocks.SOCOTRA_SIGN.get(),
                    RuBlocks.WILLOW_WALL_SIGN.get(), RuBlocks.WILLOW_SIGN.get(),
                    RuBlocks.YELLOW_BIOSHROOM_WALL_SIGN.get(), RuBlocks.YELLOW_BIOSHROOM_SIGN.get()
            ).build(null));

    public static final Supplier<BlockEntityType<?>> HANGING_SIGN_BLOCK_ENTITIES = registerBlockEntity("hanging_sign_block_entity",
            () -> BlockEntityType.Builder.of(RuHangingSignBlockEntity::new,

                    RuBlocks.BAOBAB_WALL_HANGING_SIGN.get(), RuBlocks.BAOBAB_HANGING_SIGN.get(),
                    RuBlocks.BLACKWOOD_WALL_HANGING_SIGN.get(), RuBlocks.BLACKWOOD_HANGING_SIGN.get(),
                    RuBlocks.BLUE_BIOSHROOM_WALL_HANGING_SIGN.get(), RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN.get(),
                    RuBlocks.BRIMWOOD_WALL_HANGING_SIGN.get(), RuBlocks.BRIMWOOD_HANGING_SIGN.get(),
                    RuBlocks.COBALT_WALL_HANGING_SIGN.get(), RuBlocks.COBALT_HANGING_SIGN.get(),
                    RuBlocks.CYPRESS_WALL_HANGING_SIGN.get(), RuBlocks.CYPRESS_HANGING_SIGN.get(),
                    RuBlocks.DEAD_WALL_HANGING_SIGN.get(), RuBlocks.DEAD_HANGING_SIGN.get(),
                    RuBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), RuBlocks.EUCALYPTUS_HANGING_SIGN.get(),
                    RuBlocks.GREEN_BIOSHROOM_WALL_HANGING_SIGN.get(), RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN.get(),
                    RuBlocks.JOSHUA_WALL_HANGING_SIGN.get(), RuBlocks.JOSHUA_HANGING_SIGN.get(),
                    RuBlocks.KAPOK_WALL_HANGING_SIGN.get(), RuBlocks.KAPOK_HANGING_SIGN.get(),
                    RuBlocks.LARCH_WALL_HANGING_SIGN.get(), RuBlocks.LARCH_HANGING_SIGN.get(),
                    RuBlocks.MAGNOLIA_WALL_HANGING_SIGN.get(), RuBlocks.MAGNOLIA_HANGING_SIGN.get(),
                    RuBlocks.MAPLE_WALL_HANGING_SIGN.get(), RuBlocks.MAPLE_HANGING_SIGN.get(),
                    RuBlocks.MAUVE_WALL_HANGING_SIGN.get(), RuBlocks.MAUVE_HANGING_SIGN.get(),
                    RuBlocks.PALM_WALL_HANGING_SIGN.get(), RuBlocks.PALM_HANGING_SIGN.get(),
                    RuBlocks.PINE_WALL_HANGING_SIGN.get(), RuBlocks.PINE_HANGING_SIGN.get(),
                    RuBlocks.PINK_BIOSHROOM_WALL_HANGING_SIGN.get(), RuBlocks.PINK_BIOSHROOM_HANGING_SIGN.get(),
                    RuBlocks.REDWOOD_WALL_HANGING_SIGN.get(), RuBlocks.REDWOOD_HANGING_SIGN.get(),
                    RuBlocks.SOCOTRA_WALL_HANGING_SIGN.get(), RuBlocks.SOCOTRA_HANGING_SIGN.get(),
                    RuBlocks.WILLOW_WALL_HANGING_SIGN.get(), RuBlocks.WILLOW_HANGING_SIGN.get(),
                    RuBlocks.YELLOW_BIOSHROOM_WALL_HANGING_SIGN.get(), RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN.get()

            ).build(null));

    public static void addBlockEntities() {

    }

    private static Supplier<BlockEntityType<?>> registerBlockEntity(String path, Supplier<BlockEntityType<?>> type) {
        return Services.REGISTAR.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, path, type);
    }
}
