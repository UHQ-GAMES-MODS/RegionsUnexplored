package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RuBlocks;

import static net.regions_unexplored.util.BlockCompatUtil.*;

public class BlockToolCompat {
    public static void setup() {
        //StripBlocks

        registerStrippableBlock(RuBlocks.ASHEN_LOG, RuBlocks.STRIPPED_DEAD_LOG);
        registerStrippableBlock(RuBlocks.ASHEN_WOOD, RuBlocks.STRIPPED_DEAD_WOOD);

        registerStrippableBlock(RuBlocks.SILVER_BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG);
        registerStrippableBlock(RuBlocks.SILVER_BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD);

        registerStrippableBlock(RuBlocks.BAOBAB_LOG, RuBlocks.STRIPPED_BAOBAB_LOG);
        registerStrippableBlock(RuBlocks.BAOBAB_WOOD, RuBlocks.STRIPPED_BAOBAB_WOOD);

        registerStrippableBlock(RuBlocks.BLACKWOOD_LOG, RuBlocks.STRIPPED_BLACKWOOD_LOG);
        registerStrippableBlock(RuBlocks.BLACKWOOD_WOOD, RuBlocks.STRIPPED_BLACKWOOD_WOOD);

        registerStrippableBlock(RuBlocks.BLUE_BIOSHROOM_STEM, RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM);
        registerStrippableBlock(RuBlocks.BLUE_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE);

        registerStrippableBlock(RuBlocks.BRIMWOOD_LOG, RuBlocks.STRIPPED_BRIMWOOD_LOG);
        registerStrippableBlock(RuBlocks.BRIMWOOD_LOG_MAGMA, RuBlocks.STRIPPED_BRIMWOOD_LOG);
        registerStrippableBlock(RuBlocks.BRIMWOOD_WOOD, RuBlocks.STRIPPED_BRIMWOOD_WOOD);

        registerStrippableBlock(RuBlocks.COBALT_LOG, RuBlocks.STRIPPED_COBALT_LOG);
        registerStrippableBlock(RuBlocks.COBALT_WOOD, RuBlocks.STRIPPED_COBALT_WOOD);

        registerStrippableBlock(RuBlocks.CYPRESS_LOG, RuBlocks.STRIPPED_CYPRESS_LOG);
        registerStrippableBlock(RuBlocks.CYPRESS_WOOD, RuBlocks.STRIPPED_CYPRESS_WOOD);

        registerStrippableBlock(RuBlocks.DEAD_LOG, RuBlocks.STRIPPED_DEAD_LOG);
        registerStrippableBlock(RuBlocks.DEAD_WOOD, RuBlocks.STRIPPED_DEAD_WOOD);

        registerStrippableBlock(RuBlocks.EUCALYPTUS_LOG, RuBlocks.STRIPPED_EUCALYPTUS_LOG);
        registerStrippableBlock(RuBlocks.EUCALYPTUS_WOOD, RuBlocks.STRIPPED_EUCALYPTUS_WOOD);

        registerStrippableBlock(RuBlocks.GREEN_BIOSHROOM_STEM, RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM);
        registerStrippableBlock(RuBlocks.GREEN_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE);

        registerStrippableBlock(RuBlocks.JOSHUA_LOG, RuBlocks.STRIPPED_JOSHUA_LOG);
        registerStrippableBlock(RuBlocks.JOSHUA_WOOD, RuBlocks.STRIPPED_JOSHUA_WOOD);

        registerStrippableBlock(RuBlocks.KAPOK_LOG, RuBlocks.STRIPPED_KAPOK_LOG);
        registerStrippableBlock(RuBlocks.KAPOK_WOOD, RuBlocks.STRIPPED_KAPOK_WOOD);

        registerStrippableBlock(RuBlocks.LARCH_LOG, RuBlocks.STRIPPED_LARCH_LOG);
        registerStrippableBlock(RuBlocks.LARCH_WOOD, RuBlocks.STRIPPED_LARCH_WOOD);

        registerStrippableBlock(RuBlocks.MAPLE_LOG, RuBlocks.STRIPPED_MAPLE_LOG);
        registerStrippableBlock(RuBlocks.MAPLE_WOOD, RuBlocks.STRIPPED_MAPLE_WOOD);

        registerStrippableBlock(RuBlocks.MAGNOLIA_LOG, RuBlocks.STRIPPED_MAGNOLIA_LOG);
        registerStrippableBlock(RuBlocks.MAGNOLIA_WOOD, RuBlocks.STRIPPED_MAGNOLIA_WOOD);

        registerStrippableBlock(RuBlocks.MAUVE_LOG, RuBlocks.STRIPPED_MAUVE_LOG);
        registerStrippableBlock(RuBlocks.MAUVE_WOOD, RuBlocks.STRIPPED_MAUVE_WOOD);

        registerStrippableBlock(RuBlocks.PALM_LOG, RuBlocks.STRIPPED_PALM_LOG);
        registerStrippableBlock(RuBlocks.PALM_WOOD, RuBlocks.STRIPPED_PALM_WOOD);

        registerStrippableBlock(RuBlocks.PINE_LOG, RuBlocks.STRIPPED_PINE_LOG);
        registerStrippableBlock(RuBlocks.PINE_WOOD, RuBlocks.STRIPPED_PINE_WOOD);

        registerStrippableBlock(RuBlocks.PINK_BIOSHROOM_STEM, RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM);
        registerStrippableBlock(RuBlocks.PINK_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE);

        registerStrippableBlock(RuBlocks.REDWOOD_LOG, RuBlocks.STRIPPED_REDWOOD_LOG);
        registerStrippableBlock(RuBlocks.REDWOOD_WOOD, RuBlocks.STRIPPED_REDWOOD_WOOD);

        registerStrippableBlock(RuBlocks.SOCOTRA_LOG, RuBlocks.STRIPPED_SOCOTRA_LOG);
        registerStrippableBlock(RuBlocks.SOCOTRA_WOOD, RuBlocks.STRIPPED_SOCOTRA_WOOD);

        registerStrippableBlock(RuBlocks.WILLOW_LOG, RuBlocks.STRIPPED_WILLOW_LOG);
        registerStrippableBlock(RuBlocks.WILLOW_WOOD, RuBlocks.STRIPPED_WILLOW_WOOD);

        registerStrippableBlock(RuBlocks.YELLOW_BIOSHROOM_STEM, RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM);
        registerStrippableBlock(RuBlocks.YELLOW_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_YELLOW_BIOSHROOM_HYPHAE);

        //ShovelBlocks
        registerShovelled(RuBlocks.PEAT_PODZOL, RuBlocks.PEAT_DIRT_PATH.defaultBlockState());
        registerShovelled(RuBlocks.SILT_PODZOL, RuBlocks.SILT_DIRT_PATH.defaultBlockState());

        registerShovelled(RuBlocks.CHALK_GRASS_BLOCK, RuBlocks.CHALK.defaultBlockState());
        registerShovelled(RuBlocks.ARGILLITE_GRASS_BLOCK, RuBlocks.ARGILLITE.defaultBlockState());

        registerShovelled(RuBlocks.STONE_GRASS_BLOCK, Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.VIRIDESCENT_NYLIUM, Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.PRISMOSS, Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.MOSSY_STONE, Blocks.STONE.defaultBlockState());

        registerShovelled(RuBlocks.DEEPSLATE_GRASS_BLOCK, Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM, Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RuBlocks.DEEPSLATE_PRISMOSS, Blocks.DEEPSLATE.defaultBlockState());
    }
}
