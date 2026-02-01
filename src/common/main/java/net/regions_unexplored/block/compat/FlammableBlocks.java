package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Block;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;

import static net.regions_unexplored.util.BlockCompatUtil.registerFlammableBlock;

public class FlammableBlocks {
    public static void setup() {
        /*-----------------CAVE_BLOCKS-----------------*/
        //PRISMA_BLOCKS
        registerFlammableBlock(RUBlocks.PRISMOSS_SPROUT.get(), 60, 100);

        registerFlammableBlock(RUBlocks.CORPSE_FLOWER.get(), 60, 100);
        registerFlammableBlock(RUBlocks.BLADED_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.BLADED_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DROPLEAF.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DROPLEAF_PLANT.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DUSKMELON.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DUSKTRAP.get(), 60, 100);
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        registerFlammableBlock(RUBlocks.DEAD_STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RUBlocks.FROZEN_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.MEDIUM_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.SANDY_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.SMALL_DESERT_SHRUB.get(), 60, 100);
        registerFlammableBlock(RUBlocks.STEPPE_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RUBlocks.STONE_BUD.get(), 60, 100);
        //TALL_GRASS_BLOCKS
        registerFlammableBlock(RUBlocks.ELEPHANT_EAR.get(), 60, 100);
        registerFlammableBlock(RUBlocks.SANDY_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.STEPPE_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.WINDSWEPT_GRASS.get(), 60, 100);
        //FLOWERS
        registerFlammableBlock(RUBlocks.ALPHA_DANDELION.get(), 60, 100);
        registerFlammableBlock(RUBlocks.ALPHA_ROSE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.ASTER.get(), 60, 100);
        registerFlammableBlock(RUBlocks.BLEEDING_HEART.get(), 60, 100);
        registerFlammableBlock(RUBlocks.BLUE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DAISY.get(), 60, 100);
        registerFlammableBlock(RUBlocks.FELICIA_DAISY.get(), 60, 100);
        registerFlammableBlock(RUBlocks.FIREWEED.get(), 60, 100);
        registerFlammableBlock(RUBlocks.HIBISCUS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.HYSSOP.get(), 60, 100);
        registerFlammableBlock(RUBlocks.MALLOW.get(), 60, 100);
        registerFlammableBlock(RUBlocks.PINK_LUPINE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RUBlocks.SALMON_POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RUBlocks.PURPLE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.RED_LUPINE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.WARATAH.get(), 60, 100);
        registerFlammableBlock(RUBlocks.WHITE_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RUBlocks.WILTING_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RUBlocks.YELLOW_LUPINE.get(), 60, 100);

        registerFlammableBlock(RUBlocks.ORANGE_CONEFLOWER.get(), 60, 100);
        registerFlammableBlock(RUBlocks.PURPLE_CONEFLOWER.get(), 60, 100);
        registerFlammableBlock(RUBlocks.CLOVER.get(), 60, 100);

        registerFlammableBlock(RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 60, 100);
        //SNOWBELLE
        for (Block snowbelle : RUBlocks.SNOWBELLES.getAll()) {
            registerFlammableBlock(snowbelle, 60, 100);
        }

        registerFlammableBlock(RUBlocks.MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.RED_MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.SILVER_BIRCH_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), 60, 100);
        //TALL_PLANTS
        registerFlammableBlock(RUBlocks.MEADOW_SAGE.get(), 60, 100);
        registerFlammableBlock(RUBlocks.BARLEY.get(), 60, 100);
        registerFlammableBlock(RUBlocks.CATTAIL.get(), 60, 100);
        registerFlammableBlock(RUBlocks.TASSEL.get(), 60, 100);
        registerFlammableBlock(RUBlocks.TSUBAKI.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DAY_LILY.get(), 60, 100);
        //SAPLINGS
        for (NaturalSet set : RUBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getSapling() == null) continue;
            registerFlammableBlock(set.getSapling(), 60, 100);
        }
        //SHRUBS
        for (NaturalSet set : RUBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getShrub() == null) continue;
            registerFlammableBlock(set.getShrub(), 60, 100);
        }
        //MUSHROOMS
        registerFlammableBlock(RUBlocks.BLUE_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RUBlocks.GREEN_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RUBlocks.PINK_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RUBlocks.TALL_BLUE_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RUBlocks.TALL_GREEN_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RUBlocks.TALL_PINK_BIOSHROOM.get(), 30, 60);

        registerFlammableBlock(RUBlocks.BARREL_CACTUS.get(), 60, 100);
        registerFlammableBlock(RUBlocks.CAVE_HYSSOP.get(), 60, 100);
        registerFlammableBlock(RUBlocks.DUCKWEED.get(), 60, 100);
        registerFlammableBlock(RUBlocks.SPANISH_MOSS.get(), 15, 100);
        registerFlammableBlock(RUBlocks.SPANISH_MOSS_PLANT.get(), 15, 100);
        registerFlammableBlock(RUBlocks.KAPOK_VINES.get(), 15, 100);
        registerFlammableBlock(RUBlocks.KAPOK_VINES_PLANT.get(), 15, 100);
        registerFlammableBlock(RUBlocks.FLOWERING_LILY_PAD.get(), 15, 100);
        registerFlammableBlock(RUBlocks.GIANT_LILY_PAD.get(), 15, 100);
        //FOOD_PLANT_BLOCKS
        registerFlammableBlock(RUBlocks.SALMONBERRY_BUSH.get(), 60, 100);
        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        registerFlammableBlock(RUBlocks.BLUE_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RUBlocks.GREEN_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RUBlocks.PINK_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), 30, 60);
        //BAMBOO
        registerFlammableBlock(RUBlocks.BAMBOO_LOG.get(), 5, 5);
        registerFlammableBlock(RUBlocks.STRIPPED_BAMBOO_LOG.get(), 5, 5);
        //OAK_LOG
        registerFlammableBlock(RUBlocks.SMALL_OAK_LOG.get(), 5, 5);
        registerFlammableBlock(RUBlocks.STRIPPED_SMALL_OAK_LOG.get(), 5, 5);
        //CACTUS
        registerFlammableBlock(RUBlocks.SAGUARO_CACTUS.get(), 5, 5);

        /*-----------------LEAVES-----------------*/
        for (NaturalSet set : RUBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getLeaves() == null) continue;
            registerFlammableBlock(set.getLeaves(), 30, 60);
        }

        /*-----------------BRANCHES-----------------*/
        for (NaturalSet set : RUBlocks.NATURAL_SETS) {
            if (set.fireproof || set.getBranch() == null) continue;
            registerFlammableBlock(set.getBranch(), 30, 100);
        }
        /*-----------------WOOD_TYPES-----------------*/
        for (WoodSet set : RUBlocks.WOOD_SETS) {
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
        for (Block block : RUBlocks.PAINTED_PLANKS.getAll()) {
            registerFlammableBlock(block, 5, 20);
        }
        for (Block block : RUBlocks.PAINTED_STAIRS.getAll()) {
            registerFlammableBlock(block, 5, 20);
        }
        for (Block block : RUBlocks.PAINTED_SLABS.getAll()) {
            registerFlammableBlock(block, 5, 20);
        }
    }
}
