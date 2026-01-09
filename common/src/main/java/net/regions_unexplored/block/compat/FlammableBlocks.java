package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Block;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.NaturalSet;
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
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getSapling() == null) continue;
            registerFlammableBlock(set.getSapling(), 60, 100);
        }
        //SHRUBS
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getShrub() == null) continue;
            registerFlammableBlock(set.getShrub(), 60, 100);
        }
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
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getLeaves() == null) continue;
            registerFlammableBlock(set.getLeaves(), 30, 60);
        }

        /*-----------------BRANCHES-----------------*/
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getBranch() == null) continue;
            registerFlammableBlock(set.getBranch(), 30, 100);
        }
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
