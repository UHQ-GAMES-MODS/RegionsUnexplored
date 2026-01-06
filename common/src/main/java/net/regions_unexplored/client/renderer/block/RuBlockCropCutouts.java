package net.regions_unexplored.client.renderer.block;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.client.util.RenderUtil;
import net.regions_unexplored.platform.Services;

public class RuBlockCropCutouts {
    public static void init() {
        RenderUtil.putBlocks(Services.RENDER_HELPER, RenderType.cutout(),
                /*-----------------CAVE_BLOCKS-----------------*/
                //temp fix
                RuBlocks.FLOWERING_NATURAL_SET.getLeaves(),
                RuBlocks.CHALK_GRASS_BLOCK.get(),
                //PRISMA_BLOCKS
                RuBlocks.PRISMOSS.get(),
                RuBlocks.DEEPSLATE_PRISMOSS.get(),
                RuBlocks.PRISMOSS_SPROUT.get(),
                //REDSTONE_BLOCKS
                RuBlocks.POINTED_REDSTONE.get(),
                RuBlocks.REDSTONE_BUD.get(),
                RuBlocks.REDSTONE_BULB.get(),
                //OTHER_CAVE_BLOCKS
                RuBlocks.ARGILLITE_GRASS_BLOCK.get(),
                RuBlocks.STONE_GRASS_BLOCK.get(),
                RuBlocks.DEEPSLATE_GRASS_BLOCK.get(),

                RuBlocks.CORPSE_FLOWER.get(),
                RuBlocks.BLADED_GRASS.get(),
                RuBlocks.BLADED_TALL_GRASS.get(),
                RuBlocks.DROPLEAF.get(),
                RuBlocks.DROPLEAF_PLANT.get(),
                RuBlocks.DUSKMELON.get(),
                RuBlocks.DUSKTRAP.get(),
                /*-----------------PLANTS-----------------*/
                //GRASS_BLOCKS
                RuBlocks.DEAD_STEPPE_SHRUB.get(),
                RuBlocks.FROZEN_GRASS.get(),
                RuBlocks.MEDIUM_GRASS.get(),
                RuBlocks.SANDY_GRASS.get(),
                RuBlocks.SMALL_DESERT_SHRUB.get(),
                RuBlocks.STEPPE_GRASS.get(),
                RuBlocks.STEPPE_SHRUB.get(),
                RuBlocks.STONE_BUD.get(),
                //TALL_GRASS_BLOCKS
                RuBlocks.ELEPHANT_EAR.get(),
                RuBlocks.SANDY_TALL_GRASS.get(),
                RuBlocks.STEPPE_TALL_GRASS.get(),
                RuBlocks.WINDSWEPT_GRASS.get(),
                //FLOWERS
                RuBlocks.ALPHA_DANDELION.get(),
                RuBlocks.ALPHA_ROSE.get(),
                RuBlocks.ASTER.get(),
                RuBlocks.BLEEDING_HEART.get(),
                RuBlocks.BLUE_LUPINE.get(),
                RuBlocks.DAISY.get(),
                RuBlocks.DORCEL.get(),
                RuBlocks.FELICIA_DAISY.get(),
                RuBlocks.FIREWEED.get(),
                RuBlocks.HIBISCUS.get(),
                RuBlocks.HYSSOP.get(),
                RuBlocks.MALLOW.get(),
                RuBlocks.PINK_LUPINE.get(),
                RuBlocks.POPPY_BUSH.get(),
                RuBlocks.SALMON_POPPY_BUSH.get(),
                RuBlocks.PURPLE_LUPINE.get(),
                RuBlocks.RED_LUPINE.get(),
                RuBlocks.WARATAH.get(),
                RuBlocks.WHITE_TRILLIUM.get(),
                RuBlocks.WILTING_TRILLIUM.get(),
                RuBlocks.YELLOW_LUPINE.get(),

                RuBlocks.ORANGE_CONEFLOWER.get(),
                RuBlocks.PURPLE_CONEFLOWER.get(),
                RuBlocks.CLOVER.get(),

                RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(),
                RuBlocks.PINK_MAGNOLIA_FLOWERS.get(),
                RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(),

                RuBlocks.MAPLE_LEAF_PILE.get(),
                RuBlocks.RED_MAPLE_LEAF_PILE.get(),
                RuBlocks.ORANGE_MAPLE_LEAF_PILE.get(),
                RuBlocks.SILVER_BIRCH_LEAF_PILE.get(),
                RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(),
                //TALL_PLANTS
                RuBlocks.MEADOW_SAGE.get(),
                RuBlocks.BARLEY.get(),
                RuBlocks.CATTAIL.get(),
                RuBlocks.TASSEL.get(),
                RuBlocks.TSUBAKI.get(),
                RuBlocks.DAY_LILY.get(),
                //MUSHROOMS
                RuBlocks.BLUE_BIOSHROOM.get(),
                RuBlocks.GREEN_BIOSHROOM.get(),
                RuBlocks.PINK_BIOSHROOM.get(),
                RuBlocks.YELLOW_BIOSHROOM.get(),
                RuBlocks.TALL_BLUE_BIOSHROOM.get(),
                RuBlocks.TALL_GREEN_BIOSHROOM.get(),
                RuBlocks.TALL_PINK_BIOSHROOM.get(),
                RuBlocks.TALL_YELLOW_BIOSHROOM.get(),
                //OTHER_PLANT_BLOCKS
                RuBlocks.ICICLE.get(),
                RuBlocks.BARREL_CACTUS.get(),
                RuBlocks.CAVE_HYSSOP.get(),
                RuBlocks.DUCKWEED.get(),
                RuBlocks.SPANISH_MOSS.get(),
                RuBlocks.SPANISH_MOSS_PLANT.get(),
                RuBlocks.KAPOK_VINES.get(),
                RuBlocks.KAPOK_VINES_PLANT.get(),
                RuBlocks.FLOWERING_LILY_PAD.get(),
                RuBlocks.GIANT_LILY_PAD.get(),
                //FOOD_PLANT_BLOCKS
                RuBlocks.SALMONBERRY_BUSH.get(),

                /*-----------------POTTED_PLANTS-----------------*/
                //POTTED_FLOWERS
                RuBlocks.POTTED_ALPHA_DANDELION.get(),
                RuBlocks.POTTED_ALPHA_ROSE.get(),
                RuBlocks.POTTED_ASTER.get(),
                RuBlocks.POTTED_BLEEDING_HEART.get(),
                RuBlocks.POTTED_BLUE_LUPINE.get(),
                RuBlocks.POTTED_DAISY.get(),
                RuBlocks.POTTED_DORCEL.get(),
                RuBlocks.POTTED_FELICIA_DAISY.get(),
                RuBlocks.POTTED_FIREWEED.get(),
                RuBlocks.POTTED_HIBISCUS.get(),
                RuBlocks.POTTED_HYSSOP.get(),
                RuBlocks.POTTED_MALLOW.get(),
                RuBlocks.POTTED_PINK_LUPINE.get(),
                RuBlocks.POTTED_POPPY_BUSH.get(),
                RuBlocks.POTTED_SALMON_POPPY_BUSH.get(),
                RuBlocks.POTTED_PURPLE_LUPINE.get(),
                RuBlocks.POTTED_RED_LUPINE.get(),
                RuBlocks.POTTED_TSUBAKI.get(),
                RuBlocks.POTTED_ORANGE_CONEFLOWER.get(),
                RuBlocks.POTTED_PURPLE_CONEFLOWER.get(),
                RuBlocks.POTTED_WARATAH.get(),
                RuBlocks.POTTED_WHITE_TRILLIUM.get(),
                RuBlocks.POTTED_WILTING_TRILLIUM.get(),
                RuBlocks.POTTED_YELLOW_LUPINE.get(),
                //OTHER_POTS
                RuBlocks.POTTED_DAY_LILY.get(),
                RuBlocks.POTTED_MEADOW_SAGE.get(),
                RuBlocks.POTTED_DUSKTRAP.get(),
                RuBlocks.POTTED_CORPSE_FLOWER.get(),
                RuBlocks.POTTED_COBALT_EARLIGHT.get(),
                RuBlocks.POTTED_TALL_COBALT_EARLIGHT.get(),
                RuBlocks.POTTED_MYCOTOXIC_DAISY.get(),
                RuBlocks.POTTED_GLISTER_SPIRE.get(),
                //POTTED_MUSHROOMS
                RuBlocks.POTTED_BLUE_BIOSHROOM.get(),
                RuBlocks.POTTED_GREEN_BIOSHROOM.get(),
                RuBlocks.POTTED_PINK_BIOSHROOM.get(),
                RuBlocks.POTTED_YELLOW_BIOSHROOM.get(),
                RuBlocks.POTTED_TALL_BLUE_BIOSHROOM.get(),
                RuBlocks.POTTED_TALL_GREEN_BIOSHROOM.get(),
                RuBlocks.POTTED_TALL_PINK_BIOSHROOM.get(),
                RuBlocks.POTTED_TALL_YELLOW_BIOSHROOM.get(),
                //OTHER_POTTED_PLANTS
                RuBlocks.POTTED_BARREL_CACTUS.get(),
                RuBlocks.POTTED_CAVE_HYSSOP.get(),
                RuBlocks.POTTED_GLISTERING_BLOOM.get(),
                /*-----------------PLANT_BLOCKS-----------------*/
                //MUSHROOMS
                RuBlocks.BLUE_BIOSHROOM_BLOCK.get(),
                RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(),
                RuBlocks.GREEN_BIOSHROOM_BLOCK.get(),
                RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(),
                RuBlocks.PINK_BIOSHROOM_BLOCK.get(),
                RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(),
                RuBlocks.YELLOW_BIOSHROOM_BLOCK.get(),
                RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(),
                //BAMBOO
                RuBlocks.BAMBOO_LOG.get(),
                RuBlocks.STRIPPED_BAMBOO_LOG.get(),
                //OAK_LOG
                RuBlocks.SMALL_OAK_LOG.get(),
                RuBlocks.STRIPPED_SMALL_OAK_LOG.get(),
                //CACTUS
                RuBlocks.SAGUARO_CACTUS.get(),

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
                RuBlocks.JOSHUA_NATURAL_SET.getLeaves(),
                /*-----------------BRANCHES-----------------*/
                RuBlocks.ACACIA_NATURAL_SET.getBranch(),
                RuBlocks.BAOBAB_NATURAL_SET.getBranch(),
                RuBlocks.BIRCH_NATURAL_SET.getBranch(),
                RuBlocks.BLACKWOOD_NATURAL_SET.getBranch(),
                RuBlocks.MAGNOLIA_NATURAL_SET.getBranch(),
                RuBlocks.CYPRESS_NATURAL_SET.getBranch(),
                RuBlocks.CHERRY_NATURAL_SET.getBranch(),
                RuBlocks.DARK_OAK_NATURAL_SET.getBranch(),
                RuBlocks.DEAD_NATURAL_SET.getBranch(),
                RuBlocks.EUCALYPTUS_NATURAL_SET.getBranch(),
                RuBlocks.JOSHUA_NATURAL_SET.getBranch(),
                RuBlocks.JUNGLE_NATURAL_SET.getBranch(),
                RuBlocks.KAPOK_NATURAL_SET.getBranch(),
                RuBlocks.LARCH_NATURAL_SET.getBranch(),
                RuBlocks.MANGROVE_NATURAL_SET.getBranch(),
                RuBlocks.MAPLE_NATURAL_SET.getBranch(),
                RuBlocks.MAUVE_NATURAL_SET.getBranch(),
                RuBlocks.OAK_NATURAL_SET.getBranch(),
                RuBlocks.PALM_NATURAL_SET.getBranch(),
                RuBlocks.PINE_NATURAL_SET.getBranch(),
                RuBlocks.REDWOOD_NATURAL_SET.getBranch(),
                RuBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(),
                RuBlocks.SOCOTRA_NATURAL_SET.getBranch(),
                RuBlocks.SPRUCE_NATURAL_SET.getBranch(),
                RuBlocks.WILLOW_NATURAL_SET.getBranch(),

                /*-----------------DIRT_BLOCKS-----------------*/
                //FOREST_DIRT_BLOCKS
                RuBlocks.PEAT_GRASS_BLOCK.get(),
                //PLAINS_DIRT_BLOCKS
                RuBlocks.SILT_GRASS_BLOCK.get(),
                //OTHER_DIRT_BLOCKS
                RuBlocks.ALPHA_GRASS_BLOCK.get(),

                /*-----------------OCEAN_BLOCKS-----------------*/
                //HYACINTH_BLOCKS
                RuBlocks.HYACINTH_LAMP.get(),
                RuBlocks.HYACINTH_BLOOM.get(),
                RuBlocks.HYACINTH_FLOWERS.get(),
                RuBlocks.TALL_HYACINTH_STOCK.get(),
                //ASHEN_BLOCKS
                RuBlocks.ASHEN_GRASS.get(),

                //EUCALYPTUS_BLOCKS
                RuBlocks.EUCALYPTUS_WOOD_SET.getLog(),
                RuBlocks.EUCALYPTUS_WOOD_SET.getWood(),

                /*-----------------NETHER_BLOCKS-----------------*/
                //BRIMSPROUT_BLOCKS
                RuBlocks.BRIMSPROUT.get(),
                //COBALT_BLOCKS
                RuBlocks.COBALT_EARLIGHT.get(),
                RuBlocks.TALL_COBALT_EARLIGHT.get(),
                RuBlocks.COBALT_ROOTS.get(),
                RuBlocks.HANGING_EARLIGHT.get(),
                RuBlocks.HANGING_EARLIGHT_PLANT.get(),
                //GLISTERING_BLOCKS
                RuBlocks.GLISTERING_IVY.get(),
                RuBlocks.GLISTERING_IVY_PLANT.get(),
                RuBlocks.GLISTERING_SPROUT.get(),
                RuBlocks.GLISTERING_FERN.get(),
                RuBlocks.GLISTERING_BLOOM.get(),
                RuBlocks.GLISTER_BULB.get(),
                RuBlocks.GLISTER_SPIRE.get(),
                //MYCOTOXIC_BLOCKS
                RuBlocks.MYCOTOXIC_MUSHROOMS.get(),
                RuBlocks.MYCOTOXIC_DAISY.get(),
                RuBlocks.MYCOTOXIC_GRASS.get()
        );
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            RenderUtil.putBlocks(Services.RENDER_HELPER, RenderType.cutout(), set.getShrub(), set.getSapling(), set.getPottedSapling());
        }
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            RenderUtil.putBlocks(Services.RENDER_HELPER, RenderType.cutout(), set.getDoor(), set.getTrapdoor());
        }
        for (Block snowbelle : RuBlocks.SNOWBELLES.getAll()) {
            RenderUtil.putBlocks(Services.RENDER_HELPER, RenderType.cutout(), snowbelle);
        }
        for (Block pottedSnowbelle : RuBlocks.POTTED_SNOWBELLES.getAll()) {
            RenderUtil.putBlocks(Services.RENDER_HELPER, RenderType.cutout(), pottedSnowbelle);
        }
    }
}
