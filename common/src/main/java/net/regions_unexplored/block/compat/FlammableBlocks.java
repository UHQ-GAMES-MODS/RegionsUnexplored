package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Block;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.WoodSet;

import static net.regions_unexplored.util.BlockCompatUtil.registerFlammableBlock;

public class FlammableBlocks {
    public static void setup() {
        /*-----------------CAVE_BLOCKS-----------------*/
        //PRISMA_BLOCKS
        registerFlammableBlock(RuBlocks.PRISMOSS_SPROUT.get(), 60, 100);

        registerFlammableBlock(RuBlocks.CORPSE_FLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLADED_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLADED_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DROPLEAF.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DROPLEAF_PLANT.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DUSKMELON.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DUSKTRAP.get(), 60, 100);
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        registerFlammableBlock(RuBlocks.DEAD_STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FROZEN_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MEDIUM_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SANDY_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SMALL_DESERT_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STEPPE_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STONE_BUD.get(), 60, 100);
        //TALL_GRASS_BLOCKS
        registerFlammableBlock(RuBlocks.ELEPHANT_EAR.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SANDY_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STEPPE_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WINDSWEPT_GRASS.get(), 60, 100);
        //FLOWERS
        registerFlammableBlock(RuBlocks.ALPHA_DANDELION.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ALPHA_ROSE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ASTER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLEEDING_HEART.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DAISY.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FELICIA_DAISY.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FIREWEED.get(), 60, 100);
        registerFlammableBlock(RuBlocks.HIBISCUS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.HYSSOP.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MALLOW.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SALMON_POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PURPLE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WARATAH.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WILTING_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RuBlocks.YELLOW_LUPINE.get(), 60, 100);

        registerFlammableBlock(RuBlocks.ORANGE_CONEFLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PURPLE_CONEFLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CLOVER.get(), 60, 100);

        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 60, 100);
        //SNOWBELLE
        for (Block snowbelle : RuBlocks.SNOWBELLES.getAll()) {
            registerFlammableBlock(snowbelle, 60, 100);
        }

        registerFlammableBlock(RuBlocks.MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), 60, 100);
        //TALL_PLANTS
        registerFlammableBlock(RuBlocks.MEADOW_SAGE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BARLEY.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CATTAIL.get(), 60, 100);
        registerFlammableBlock(RuBlocks.TASSEL.get(), 60, 100);
        registerFlammableBlock(RuBlocks.TSUBAKI.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DAY_LILY.get(), 60, 100);
        //SAPLINGS
        registerFlammableBlock(RuBlocks.ALPHA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.APPLE_OAK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BAMBOO_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BAOBAB_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLACKWOOD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CACTUS_FLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CYPRESS_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FLOWERING_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.GOLDEN_LARCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.JOSHUA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.KAPOK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LARCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAUVE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PALM_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.REDWOOD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SMALL_OAK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SOCOTRA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WILLOW_SAPLING.get(), 60, 100);
        //SHRUBS
        registerFlammableBlock(RuBlocks.ACACIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BAOBAB_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BIRCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLACKWOOD_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CHERRY_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CYPRESS_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DARK_OAK_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FLOWERING_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.GOLDEN_LARCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.JOSHUA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.JUNGLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.KAPOK_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LARCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MANGROVE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAPLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAUVE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.OAK_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PALM_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.REDWOOD_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_MAPLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SOCOTRA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SPRUCE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WILLOW_SHRUB.get(), 60, 100);
        //MUSHROOMS
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.TALL_BLUE_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.TALL_GREEN_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.TALL_PINK_BIOSHROOM.get(), 30, 60);

        registerFlammableBlock(RuBlocks.BARREL_CACTUS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CAVE_HYSSOP.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DUCKWEED.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SPANISH_MOSS.get(), 15, 100);
        registerFlammableBlock(RuBlocks.SPANISH_MOSS_PLANT.get(), 15, 100);
        registerFlammableBlock(RuBlocks.KAPOK_VINES.get(), 15, 100);
        registerFlammableBlock(RuBlocks.KAPOK_VINES_PLANT.get(), 15, 100);
        registerFlammableBlock(RuBlocks.FLOWERING_LILY_PAD.get(), 15, 100);
        registerFlammableBlock(RuBlocks.GIANT_LILY_PAD.get(), 15, 100);
        //FOOD_PLANT_BLOCKS
        registerFlammableBlock(RuBlocks.SALMONBERRY_BUSH.get(), 60, 100);
        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), 30, 60);
        //BAMBOO
        registerFlammableBlock(RuBlocks.BAMBOO_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BAMBOO_LOG.get(), 5, 5);
        //OAK_LOG
        registerFlammableBlock(RuBlocks.SMALL_OAK_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_SMALL_OAK_LOG.get(), 5, 5);
        //CACTUS
        registerFlammableBlock(RuBlocks.SAGUARO_CACTUS.get(), 5, 5);

        /*-----------------LEAVES-----------------*/
        registerFlammableBlock(RuBlocks.ALPHA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.APPLE_OAK_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BAMBOO_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BAOBAB_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BLACKWOOD_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.CYPRESS_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.FLOWERING_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GOLDEN_LARCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.JOSHUA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.KAPOK_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.LARCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.MAUVE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PALM_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.REDWOOD_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.RED_MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.SMALL_OAK_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.SOCOTRA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.WILLOW_LEAVES.get(), 30, 60);

        /*-----------------BRANCHES-----------------*/
        registerFlammableBlock(RuBlocks.ACACIA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.BAOBAB_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.BIRCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.BLACKWOOD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MAGNOLIA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.CYPRESS_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.CHERRY_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.DARK_OAK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.JOSHUA_BEARD.get(), 30, 100);
        registerFlammableBlock(RuBlocks.JUNGLE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.KAPOK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.LARCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MANGROVE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MAPLE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MAUVE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.OAK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.PALM_BEARD.get(), 30, 100);
        registerFlammableBlock(RuBlocks.PINE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.REDWOOD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.SOCOTRA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.SPRUCE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.WILLOW_BRANCH.get(), 30, 100);
        /*-----------------WOOD_TYPES-----------------*/
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.fireproof) continue;
            registerFlammableBlock(set.getLog(), 5, 5);
            registerFlammableBlock(set.getStrippedLog(), 5, 5);
            registerFlammableBlock(set.getWood(), 5, 5);
            registerFlammableBlock(set.getStrippedWood(), 5, 5);
            registerFlammableBlock(set.getPlanks(), 5, 20);
            registerFlammableBlock(set.getStairs(), 5, 20);
            registerFlammableBlock(set.getSlab(), 5, 20);
            registerFlammableBlock(set.getFence(), 5, 20);
            registerFlammableBlock(set.getFenceGate(), 5, 20);
            registerFlammableBlock(set.getDoor(), 5, 20);
            registerFlammableBlock(set.getTrapdoor(), 5, 20);
            registerFlammableBlock(set.getPressurePlate(), 5, 20);
            registerFlammableBlock(set.getButton(), 5, 20);
            registerFlammableBlock(set.getSign(), 5, 20);
            registerFlammableBlock(set.getWallSign(), 5, 20);
            registerFlammableBlock(set.getHangingSign(), 5, 20);
            registerFlammableBlock(set.getWallHangingSign(), 5, 20);
        }

        /*-----------------PAINTED PLANKS-----------------*/
        for (Block block : RuBlocks.PAINTED_PLANKS.getAll()) {
            registerFlammableBlock(block, 5, 20);
        }
        for (Block block : RuBlocks.PAINTED_STAIRS.getAll()) {
            registerFlammableBlock(block, 5, 20);
        }
        for (Block block : RuBlocks.PAINTED_SLABS.getAll()) {
            registerFlammableBlock(block, 5, 20);
        }
    }
}
