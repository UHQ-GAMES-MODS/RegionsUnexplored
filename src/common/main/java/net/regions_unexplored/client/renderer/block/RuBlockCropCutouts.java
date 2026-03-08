package net.regions_unexplored.client.renderer.block;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.client.util.RenderUtil;

public class RuBlockCropCutouts {
    public static void init() {
        RenderUtil.putBlocks(
                RenderType.cutout(),
                /*-----------------CAVE_BLOCKS-----------------*/
                //temp fix
                RUBlocks.FLOWERING_NATURAL_SET.getLeaves(),
                RUBlocks.CHALK_GRASS_BLOCK.get(),
                //PRISMA_BLOCKS
                RUBlocks.PRISMOSS.get(),
                RUBlocks.DEEPSLATE_PRISMOSS.get(),
                RUBlocks.PRISMOSS_SPROUT.get(),
                //REDSTONE_BLOCKS
                RUBlocks.POINTED_REDSTONE.get(),
                RUBlocks.REDSTONE_BUD.get(),
                RUBlocks.REDSTONE_BULB.get(),
                //OTHER_CAVE_BLOCKS
                RUBlocks.ARGILLITE_GRASS_BLOCK.get(),
                RUBlocks.STONE_GRASS_BLOCK.get(),
                RUBlocks.DEEPSLATE_GRASS_BLOCK.get(),

                RUBlocks.CORPSE_FLOWER.get(),
                RUBlocks.BLADED_GRASS.get(),
                RUBlocks.BLADED_TALL_GRASS.get(),
                RUBlocks.DROPLEAF.get(),
                RUBlocks.DROPLEAF_PLANT.get(),
                RUBlocks.DUSKMELON.get(),
                RUBlocks.DUSKTRAP.get(),
                /*-----------------PLANTS-----------------*/
                //GRASS_BLOCKS
                RUBlocks.DEAD_STEPPE_SHRUB.get(),
                RUBlocks.FROZEN_GRASS.get(),
                RUBlocks.SANDY_GRASS.get(),
                RUBlocks.SMALL_DESERT_SHRUB.get(),
                RUBlocks.STEPPE_GRASS.get(),
                RUBlocks.STEPPE_SHRUB.get(),
                RUBlocks.GRASS_SPROUTS.get(),
                //TALL_GRASS_BLOCKS
                RUBlocks.ELEPHANT_EAR.get(),
                RUBlocks.SANDY_TALL_GRASS.get(),
                RUBlocks.STEPPE_TALL_GRASS.get(),
                RUBlocks.WINDSWEPT_GRASS.get(),
                //FLOWERS
                RUBlocks.ALPHA_DANDELION.get(),
                RUBlocks.ALPHA_ROSE.get(),
                RUBlocks.ASTER.get(),
                RUBlocks.BLEEDING_HEART.get(),
                RUBlocks.BLUE_LUPINE.get(),
                RUBlocks.DAISY.get(),
                RUBlocks.DORCEL.get(),
                RUBlocks.FELICIA_DAISY.get(),
                RUBlocks.FIREWEED.get(),
                RUBlocks.HIBISCUS.get(),
                RUBlocks.HYSSOP.get(),
                RUBlocks.MALLOW.get(),
                RUBlocks.PINK_LUPINE.get(),
                RUBlocks.POPPY_BUSH.get(),
                RUBlocks.SALMON_POPPY_BUSH.get(),
                RUBlocks.PURPLE_LUPINE.get(),
                RUBlocks.RED_LUPINE.get(),
                RUBlocks.WARATAH.get(),
                RUBlocks.WHITE_TRILLIUM.get(),
                RUBlocks.WILTING_TRILLIUM.get(),
                RUBlocks.YELLOW_LUPINE.get(),

                RUBlocks.ORANGE_CONEFLOWER.get(),
                RUBlocks.PURPLE_CONEFLOWER.get(),
                RUBlocks.CLOVER.get(),

                RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(),
                RUBlocks.PINK_MAGNOLIA_FLOWERS.get(),
                RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(),

                RUBlocks.MAPLE_LEAF_LITTER.get(),
                RUBlocks.RED_MAPLE_LEAF_LITTER.get(),
                RUBlocks.ORANGE_MAPLE_LEAF_LITTER.get(),
                RUBlocks.SILVER_BIRCH_LEAF_LITTER.get(),
                RUBlocks.ENCHANTED_BIRCH_LEAF_LITTER.get(),
                //TALL_PLANTS
                RUBlocks.MEADOW_SAGE.get(),
                RUBlocks.BARLEY.get(),
                RUBlocks.CATTAIL.get(),
                RUBlocks.TASSEL.get(),
                RUBlocks.TSUBAKI.get(),
                RUBlocks.DAY_LILY.get(),
                //MUSHROOMS
                RUBlocks.BLUE_BIOSHROOM.get(),
                RUBlocks.GREEN_BIOSHROOM.get(),
                RUBlocks.PINK_BIOSHROOM.get(),
                RUBlocks.YELLOW_BIOSHROOM.get(),
                RUBlocks.TALL_BLUE_BIOSHROOM.get(),
                RUBlocks.TALL_GREEN_BIOSHROOM.get(),
                RUBlocks.TALL_PINK_BIOSHROOM.get(),
                RUBlocks.TALL_YELLOW_BIOSHROOM.get(),
                //OTHER_PLANT_BLOCKS
                RUBlocks.ICICLE.get(),
                RUBlocks.BARREL_CACTUS.get(),
                RUBlocks.CAVE_HYSSOP.get(),
                RUBlocks.DUCKWEED.get(),
                RUBlocks.SPANISH_MOSS.get(),
                RUBlocks.SPANISH_MOSS_PLANT.get(),
                RUBlocks.KAPOK_VINES.get(),
                RUBlocks.KAPOK_VINES_PLANT.get(),
                RUBlocks.FLOWERING_LILY_PAD.get(),
                RUBlocks.GIANT_LILY_PAD.get(),
                //FOOD_PLANT_BLOCKS
                RUBlocks.SALMONBERRY_BUSH.get(),

                /*-----------------POTTED_PLANTS-----------------*/
                //POTTED_FLOWERS
                RUBlocks.POTTED_ALPHA_DANDELION.get(),
                RUBlocks.POTTED_ALPHA_ROSE.get(),
                RUBlocks.POTTED_ASTER.get(),
                RUBlocks.POTTED_BLEEDING_HEART.get(),
                RUBlocks.POTTED_BLUE_LUPINE.get(),
                RUBlocks.POTTED_DAISY.get(),
                RUBlocks.POTTED_DORCEL.get(),
                RUBlocks.POTTED_FELICIA_DAISY.get(),
                RUBlocks.POTTED_FIREWEED.get(),
                RUBlocks.POTTED_HIBISCUS.get(),
                RUBlocks.POTTED_HYSSOP.get(),
                RUBlocks.POTTED_MALLOW.get(),
                RUBlocks.POTTED_PINK_LUPINE.get(),
                RUBlocks.POTTED_POPPY_BUSH.get(),
                RUBlocks.POTTED_SALMON_POPPY_BUSH.get(),
                RUBlocks.POTTED_PURPLE_LUPINE.get(),
                RUBlocks.POTTED_RED_LUPINE.get(),
                RUBlocks.POTTED_TSUBAKI.get(),
                RUBlocks.POTTED_ORANGE_CONEFLOWER.get(),
                RUBlocks.POTTED_PURPLE_CONEFLOWER.get(),
                RUBlocks.POTTED_WARATAH.get(),
                RUBlocks.POTTED_WHITE_TRILLIUM.get(),
                RUBlocks.POTTED_WILTING_TRILLIUM.get(),
                RUBlocks.POTTED_YELLOW_LUPINE.get(),
                //OTHER_POTS
                RUBlocks.POTTED_DAY_LILY.get(),
                RUBlocks.POTTED_MEADOW_SAGE.get(),
                RUBlocks.POTTED_DUSKTRAP.get(),
                RUBlocks.POTTED_CORPSE_FLOWER.get(),
                RUBlocks.POTTED_COBALT_EARLIGHT.get(),
                RUBlocks.POTTED_TALL_COBALT_EARLIGHT.get(),
                RUBlocks.POTTED_MYCOTOXIC_DAISY.get(),
                RUBlocks.POTTED_GLISTER_SPIRE.get(),
                //POTTED_MUSHROOMS
                RUBlocks.POTTED_BLUE_BIOSHROOM.get(),
                RUBlocks.POTTED_GREEN_BIOSHROOM.get(),
                RUBlocks.POTTED_PINK_BIOSHROOM.get(),
                RUBlocks.POTTED_YELLOW_BIOSHROOM.get(),
                RUBlocks.POTTED_TALL_BLUE_BIOSHROOM.get(),
                RUBlocks.POTTED_TALL_GREEN_BIOSHROOM.get(),
                RUBlocks.POTTED_TALL_PINK_BIOSHROOM.get(),
                RUBlocks.POTTED_TALL_YELLOW_BIOSHROOM.get(),
                //OTHER_POTTED_PLANTS
                RUBlocks.POTTED_BARREL_CACTUS.get(),
                RUBlocks.POTTED_CAVE_HYSSOP.get(),
                RUBlocks.POTTED_GLISTERING_BLOOM.get(),
                /*-----------------PLANT_BLOCKS-----------------*/
                //MUSHROOMS
                RUBlocks.BLUE_BIOSHROOM_BLOCK.get(),
                RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(),
                RUBlocks.GREEN_BIOSHROOM_BLOCK.get(),
                RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(),
                RUBlocks.PINK_BIOSHROOM_BLOCK.get(),
                RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(),
                RUBlocks.YELLOW_BIOSHROOM_BLOCK.get(),
                RUBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(),
                //BAMBOO
                RUBlocks.BAMBOO_LOG.get(),
                RUBlocks.STRIPPED_BAMBOO_LOG.get(),
                //OAK_LOG
                RUBlocks.SMALL_OAK_LOG.get(),
                RUBlocks.STRIPPED_SMALL_OAK_LOG.get(),
                //CACTUS
                RUBlocks.SAGUARO_CACTUS.get(),

        /*-----------------LEAVES-----------------
        COMMENT-OUT: uses internal render type
        RuBlocks.ALPHA_NATURAL_SET.getLeaves(),
        RuBlocks.APPLE_OAK_NATURAL_SET.getLeaves(),
        RuBlocks.BAMBOO_NATURAL_SET.getLeaves(),
        RuBlocks.BAOBAB_NATURAL_SET.getLeaves(),
        RuBlocks.BLACKWOOD_NATURAL_SET.getLeaves(),
        RuBlocks.BRIMWOOD_NATURAL_SET.getLeaves(),
        RuBlocks.COBALT_WEBBING.get(),
        RuBlocks.MAGNOLIA_NATURAL_SET.getLeaves(),
        RuBlocks.CYPRESS_NATURAL_SET.getLeaves(),
        RuBlocks.DEAD_NATURAL_SET.getLeaves(),
        RuBlocks.DEAD_PINE_NATURAL_SET.getLeaves(),
        RuBlocks.EUCALYPTUS_NATURAL_SET.getLeaves(),
        RuBlocks.FLOWERING_NATURAL_SET.getLeaves(),
        RuBlocks.GOLDEN_LARCH_NATURAL_SET.getLeaves(),
        RuBlocks.JOSHUA_NATURAL_SET.getLeaves(),
        RuBlocks.KAPOK_NATURAL_SET.getLeaves(),
        RuBlocks.LARCH_NATURAL_SET.getLeaves(),
        RuBlocks.MAPLE_NATURAL_SET.getLeaves(),
        RuBlocks.MAUVE_NATURAL_SET.getLeaves(),
        RuBlocks.ORANGE_MAPLE_NATURAL_SET.getLeaves(),
        RuBlocks.PALM_NATURAL_SET.getLeaves(),
        RuBlocks.PINE_NATURAL_SET.getLeaves(),
        RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves(),
        RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves(),
        RuBlocks.REDWOOD_NATURAL_SET.getLeaves(),
        RuBlocks.RED_MAPLE_NATURAL_SET.getLeaves(),
        RuBlocks.SMALL_OAK_NATURAL_SET.getLeaves(),
        RuBlocks.SILVER_BIRCH_NATURAL_SET.getLeaves(),
        RuBlocks.SOCOTRA_NATURAL_SET.getLeaves(),
        RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getLeaves(),
        RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves(),
        RuBlocks.WILLOW_NATURAL_SET.getLeaves(),
        except this one\/    */
                RUBlocks.JOSHUA_NATURAL_SET.getLeaves(),
                /*-----------------BRANCHES-----------------*/
                RUBlocks.ACACIA_NATURAL_SET.getBranch(),
                RUBlocks.BAOBAB_NATURAL_SET.getBranch(),
                RUBlocks.BIRCH_NATURAL_SET.getBranch(),
                RUBlocks.BLACKWOOD_NATURAL_SET.getBranch(),
                RUBlocks.MAGNOLIA_NATURAL_SET.getBranch(),
                RUBlocks.CYPRESS_NATURAL_SET.getBranch(),
                RUBlocks.CHERRY_NATURAL_SET.getBranch(),
                RUBlocks.DARK_OAK_NATURAL_SET.getBranch(),
                RUBlocks.DEAD_NATURAL_SET.getBranch(),
                RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch(),
                RUBlocks.JOSHUA_NATURAL_SET.getBranch(),
                RUBlocks.JUNGLE_NATURAL_SET.getBranch(),
                RUBlocks.KAPOK_NATURAL_SET.getBranch(),
                RUBlocks.LARCH_NATURAL_SET.getBranch(),
                RUBlocks.MANGROVE_NATURAL_SET.getBranch(),
                RUBlocks.MAPLE_NATURAL_SET.getBranch(),
                RUBlocks.MAUVE_NATURAL_SET.getBranch(),
                RUBlocks.OAK_NATURAL_SET.getBranch(),
                RUBlocks.PALM_NATURAL_SET.getBranch(),
                RUBlocks.PINE_NATURAL_SET.getBranch(),
                RUBlocks.REDWOOD_NATURAL_SET.getBranch(),
                RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(),
                RUBlocks.SOCOTRA_NATURAL_SET.getBranch(),
                RUBlocks.SPRUCE_NATURAL_SET.getBranch(),
                RUBlocks.WILLOW_NATURAL_SET.getBranch(),

                /*-----------------DIRT_BLOCKS-----------------*/
                //FOREST_DIRT_BLOCKS
                RUBlocks.PEAT_GRASS_BLOCK.get(),
                //PLAINS_DIRT_BLOCKS
                RUBlocks.SILT_GRASS_BLOCK.get(),
                //OTHER_DIRT_BLOCKS
                RUBlocks.ALPHA_GRASS_BLOCK.get(),

                /*-----------------OCEAN_BLOCKS-----------------*/
                //HYACINTH_BLOCKS
                RUBlocks.HYACINTH_LAMP.get(),
                RUBlocks.HYACINTH_BLOOM.get(),
                RUBlocks.HYACINTH_FLOWERS.get(),
                RUBlocks.TALL_HYACINTH_STOCK.get(),
                //ASHEN_BLOCKS
                RUBlocks.ASHEN_GRASS.get(),

                //EUCALYPTUS_BLOCKS
                RUBlocks.EUCALYPTUS_WOOD_SET.getLog(),
                RUBlocks.EUCALYPTUS_WOOD_SET.getWood(),

                /*-----------------NETHER_BLOCKS-----------------*/
                //BRIMSPROUT_BLOCKS
                RUBlocks.BRIMSPROUT.get(),
                //COBALT_BLOCKS
                RUBlocks.COBALT_EARLIGHT.get(),
                RUBlocks.TALL_COBALT_EARLIGHT.get(),
                RUBlocks.COBALT_ROOTS.get(),
                RUBlocks.HANGING_EARLIGHT.get(),
                RUBlocks.HANGING_EARLIGHT_PLANT.get(),
                //GLISTERING_BLOCKS
                RUBlocks.GLISTERING_IVY.get(),
                RUBlocks.GLISTERING_IVY_PLANT.get(),
                RUBlocks.GLISTERING_SPROUT.get(),
                RUBlocks.GLISTERING_FERN.get(),
                RUBlocks.GLISTERING_BLOOM.get(),
                RUBlocks.GLISTER_BULB.get(),
                RUBlocks.GLISTER_SPIRE.get(),
                //MYCOTOXIC_BLOCKS
                RUBlocks.MYCOTOXIC_MUSHROOMS.get(),
                RUBlocks.MYCOTOXIC_DAISY.get(),
                RUBlocks.MYCOTOXIC_GRASS.get()
        );
        for (NaturalSet set : RUBlocks.NATURAL_SETS) {
            RenderUtil.putBlocks(RenderType.cutout(), set.getShrub(), set.getSapling(), set.getPottedSapling());
        }
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            RenderUtil.putBlocks(RenderType.cutout(), set.getDoor(), set.getTrapdoor());
        }
        for (Block snowbelle : RUBlocks.SNOWBELLES.getAll()) {
            RenderUtil.putBlocks(RenderType.cutout(), snowbelle);
        }
        for (Block pottedSnowbelle : RUBlocks.POTTED_SNOWBELLES.getAll()) {
            RenderUtil.putBlocks(RenderType.cutout(), pottedSnowbelle);
        }
    }
}
