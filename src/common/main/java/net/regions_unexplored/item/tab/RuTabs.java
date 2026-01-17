package net.regions_unexplored.item.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.platform.Registar;

import java.util.function.Supplier;

public class RuTabs {
    public static final Supplier<CreativeModeTab.DisplayItemsGenerator> TAB_ORDER = () -> (params, output) -> {
        output.accept(RuBlocks.PRISMOSS.get().asItem());
        output.accept(RuBlocks.DEEPSLATE_PRISMOSS.get().asItem());
        output.accept(RuBlocks.PRISMARITE_CLUSTER.get().asItem());
        output.accept(RuBlocks.LARGE_PRISMARITE_CLUSTER.get().asItem());
        output.accept(RuBlocks.HANGING_PRISMARITE.get().asItem());
        output.accept(RuBlocks.PRISMOSS_SPROUT.get().asItem());
        output.accept(RuBlocks.PRISMAGLASS.get().asItem());
        //REDSTONE_BLOCKS
        output.accept(RuBlocks.REDSTONE_BUD.get().asItem());
        output.accept(RuBlocks.REDSTONE_BULB.get().asItem());
        output.accept(RuBlocks.POINTED_REDSTONE.get().asItem());
        output.accept(RuBlocks.RAW_REDSTONE_BLOCK.get().asItem());
        //ANCIENT_DELTA
        output.accept(RuBlocks.CORPSE_FLOWER.get().asItem());
        output.accept(RuBlocks.DROPLEAF.get().asItem());
        output.accept(RuBlocks.DUSKMELON.get().asItem());
        output.accept(RuBlocks.DUSKTRAP.get().asItem());
        //OTHER_CAVE_BLOCKS
        output.accept(RuBlocks.STONE_GRASS_BLOCK.get().asItem());
        output.accept(RuBlocks.DEEPSLATE_GRASS_BLOCK.get().asItem());
        output.accept(RuBlocks.VIRIDESCENT_NYLIUM.get().asItem());
        output.accept(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get().asItem());
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        output.accept(RuBlocks.ASHEN_GRASS.get().asItem());
        output.accept(RuBlocks.BLADED_GRASS.get().asItem());
        output.accept(RuBlocks.DEAD_STEPPE_SHRUB.get().asItem());
        output.accept(RuBlocks.FROZEN_GRASS.get().asItem());
        output.accept(RuBlocks.MEDIUM_GRASS.get().asItem());
        output.accept(RuBlocks.SANDY_GRASS.get().asItem());
        output.accept(RuBlocks.SMALL_DESERT_SHRUB.get().asItem());
        output.accept(RuBlocks.STEPPE_GRASS.get().asItem());
        output.accept(RuBlocks.STEPPE_SHRUB.get().asItem());
        output.accept(RuBlocks.STONE_BUD.get().asItem());

        output.accept(RuBlocks.BRIMSPROUT.get().asItem());
        output.accept(RuBlocks.COBALT_ROOTS.get().asItem());
        output.accept(RuBlocks.GLISTERING_SPROUT.get().asItem());
        output.accept(RuBlocks.GLISTERING_FERN.get().asItem());
        output.accept(RuBlocks.MYCOTOXIC_GRASS.get().asItem());

        output.accept(RuBlocks.BLADED_TALL_GRASS.get().asItem());
        output.accept(RuBlocks.ELEPHANT_EAR.get().asItem());
        output.accept(RuBlocks.SANDY_TALL_GRASS.get().asItem());
        output.accept(RuBlocks.STEPPE_TALL_GRASS.get().asItem());
        output.accept(RuBlocks.WINDSWEPT_GRASS.get().asItem());

        output.accept(RuBlocks.CLOVER.get().asItem());
        //FLOWERS
        output.accept(RuBlocks.ALPHA_DANDELION.get().asItem());
        output.accept(RuBlocks.ALPHA_ROSE.get().asItem());
        output.accept(RuBlocks.ASTER.get().asItem());
        output.accept(RuBlocks.BLEEDING_HEART.get().asItem());
        output.accept(RuBlocks.DAISY.get().asItem());
        output.accept(RuBlocks.DORCEL.get().asItem());
        output.accept(RuBlocks.FELICIA_DAISY.get().asItem());
        output.accept(RuBlocks.FIREWEED.get().asItem());
        output.accept(RuBlocks.GLISTERING_BLOOM.get().asItem());
        output.accept(RuBlocks.HIBISCUS.get().asItem());
        output.accept(RuBlocks.HYSSOP.get().asItem());
        output.accept(RuBlocks.MALLOW.get().asItem());
        output.accept(RuBlocks.POPPY_BUSH.get().asItem());
        output.accept(RuBlocks.SALMON_POPPY_BUSH.get().asItem());
        output.accept(RuBlocks.TSUBAKI.get().asItem());
        output.accept(RuBlocks.WARATAH.get().asItem());
        output.accept(RuBlocks.WHITE_TRILLIUM.get().asItem());
        output.accept(RuBlocks.WILTING_TRILLIUM.get().asItem());
        output.accept(RuBlocks.BLUE_LUPINE.get().asItem());
        output.accept(RuBlocks.PINK_LUPINE.get().asItem());
        output.accept(RuBlocks.PURPLE_LUPINE.get().asItem());
        output.accept(RuBlocks.RED_LUPINE.get().asItem());
        output.accept(RuBlocks.YELLOW_LUPINE.get().asItem());
        output.accept(RuBlocks.COBALT_EARLIGHT.get().asItem());

        output.accept(RuBlocks.ORANGE_CONEFLOWER.get().asItem());
        output.accept(RuBlocks.PURPLE_CONEFLOWER.get().asItem());
        //SNOWBELLE
        for (Block snowbelle : RuBlocks.SNOWBELLES.getAll()) {
            output.accept(snowbelle);
        }

        output.accept(RuBlocks.HYACINTH_FLOWERS.get().asItem());
        output.accept(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get().asItem());
        output.accept(RuBlocks.PINK_MAGNOLIA_FLOWERS.get().asItem());
        output.accept(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get().asItem());

        output.accept(RuBlocks.MAPLE_LEAF_PILE.get().asItem());
        output.accept(RuBlocks.RED_MAPLE_LEAF_PILE.get().asItem());
        output.accept(RuBlocks.ORANGE_MAPLE_LEAF_PILE.get().asItem());
        output.accept(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get().asItem());
        output.accept(RuBlocks.SILVER_BIRCH_LEAF_PILE.get().asItem());

        //TALL_PLANTS
        output.accept(RuBlocks.BARLEY.get().asItem());
        output.accept(RuBlocks.CATTAIL.get().asItem());
        output.accept(RuBlocks.DAY_LILY.get().asItem());
        output.accept(RuBlocks.MEADOW_SAGE.get().asItem());
        output.accept(RuBlocks.TASSEL.get().asItem());
        output.accept(RuBlocks.GLISTER_BULB.get().asItem());
        output.accept(RuBlocks.GLISTER_SPIRE.get().asItem());
        output.accept(RuBlocks.MYCOTOXIC_DAISY.get().asItem());
        output.accept(RuBlocks.TALL_COBALT_EARLIGHT.get().asItem());
        //HYACINTH_BLOCKS
        output.accept(RuBlocks.HYACINTH_BLOOM.get().asItem());
        output.accept(RuBlocks.TALL_HYACINTH_STOCK.get().asItem());
        output.accept(RuBlocks.HYACINTH_LAMP.get().asItem());
        //SAPLINGS
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.getSapling() == null) continue;
            output.accept(set.getSapling());
        }
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.getShrub() == null) continue;
            output.accept(set.getShrub());
        }
        //MUSHROOMS
        output.accept(RuBlocks.BLUE_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.GREEN_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.PINK_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.YELLOW_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.TALL_BLUE_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.TALL_GREEN_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.TALL_PINK_BIOSHROOM.get().asItem());
        output.accept(RuBlocks.TALL_YELLOW_BIOSHROOM.get().asItem());
        //OTHER_PLANT_BLOCKS
        output.accept(RuBlocks.BARREL_CACTUS.get().asItem());
        output.accept(RuBlocks.CAVE_HYSSOP.get().asItem());
        output.accept(RuBlocks.DUCKWEED.get().asItem());
        output.accept(RuBlocks.FLOWERING_LILY_PAD.get().asItem());
        output.accept(RuBlocks.KAPOK_VINES.get().asItem());
        output.accept(RuBlocks.SPANISH_MOSS.get().asItem());
        output.accept(RuBlocks.GLISTERING_IVY.get().asItem());
        //FOOD_PLANT_BLOCKS
        output.accept(RuItems.SALMONBERRY.get().asItem());
        output.accept(RuBlocks.HANGING_EARLIGHT.get().asItem());
        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        output.accept(RuBlocks.BLUE_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.GREEN_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.PINK_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get().asItem());
        output.accept(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get().asItem());
        //CACTUS
        output.accept(RuBlocks.SAGUARO_CACTUS.get().asItem());

        /*-----------------LEAVES-----------------*/
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.getLeaves() == null) continue;
            output.accept(set.getLeaves());
        }

        /*-----------------BRANCHES-----------------*/
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.getBranch() == null) continue;
            output.accept(set.getBranch());
        }

        /*-----------------DIRT_BLOCKS-----------------*/
        //OTHER_DIRT_BLOCKS
        output.accept(RuBlocks.ALPHA_GRASS_BLOCK.get().asItem());
        //ASHEN_BLOCKS
        output.accept(RuBlocks.ASHEN_DIRT.get().asItem());
        //FOREST_DIRT_BLOCKS
        output.accept(RuBlocks.PEAT_GRASS_BLOCK.get().asItem());
        output.accept(RuBlocks.PEAT_DIRT.get().asItem());
        output.accept(RuBlocks.PEAT_DIRT_PATH.get().asItem());
        output.accept(RuBlocks.PEAT_COARSE_DIRT.get().asItem());
        output.accept(RuBlocks.PEAT_PODZOL.get().asItem());
        output.accept(RuBlocks.PEAT_MUD.get().asItem());
        output.accept(RuBlocks.PEAT_FARMLAND.get().asItem());
        //PLAINS_DIRT_BLOCKS
        output.accept(RuBlocks.SILT_GRASS_BLOCK.get().asItem());
        output.accept(RuBlocks.SILT_DIRT.get().asItem());
        output.accept(RuBlocks.SILT_DIRT_PATH.get().asItem());
        output.accept(RuBlocks.SILT_COARSE_DIRT.get().asItem());
        output.accept(RuBlocks.SILT_PODZOL.get().asItem());
        output.accept(RuBlocks.SILT_MUD.get().asItem());
        output.accept(RuBlocks.SILT_FARMLAND.get().asItem());
        //NETHER
        output.accept(RuBlocks.BRIMSPROUT_NYLIUM.get().asItem());
        output.accept(RuBlocks.COBALT_NYLIUM.get().asItem());
        output.accept(RuBlocks.GLISTERING_NYLIUM.get().asItem());
        output.accept(RuBlocks.GLISTERING_WART.get().asItem());
        output.accept(RuBlocks.OVERGROWN_BONE_BLOCK.get().asItem());
        output.accept(RuBlocks.MYCOTOXIC_NYLIUM.get().asItem());
        /*-----------------STONE_BLOCKS-----------------*/
        //CHALKS
        output.accept(RuBlocks.CHALK_GRASS_BLOCK.get().asItem());
        output.accept(RuBlocks.CHALK.get().asItem());
        output.accept(RuBlocks.CHALK_BRICKS.get().asItem());
        output.accept(RuBlocks.CHALK_BRICK_SLAB.get().asItem());
        output.accept(RuBlocks.CHALK_BRICK_STAIRS.get().asItem());
        output.accept(RuBlocks.CHALK_PILLAR.get().asItem());
        output.accept(RuBlocks.CHALK_SLAB.get().asItem());
        output.accept(RuBlocks.CHALK_STAIRS.get().asItem());
        output.accept(RuBlocks.POLISHED_CHALK.get().asItem());
        output.accept(RuBlocks.POLISHED_CHALK_SLAB.get().asItem());
        output.accept(RuBlocks.POLISHED_CHALK_STAIRS.get().asItem());
        //STONES
        output.accept(RuBlocks.ARGILLITE_GRASS_BLOCK.get().asItem());
        output.accept(RuBlocks.ARGILLITE.get().asItem());

        output.accept(RuBlocks.BLACKSTONE_CLUSTER.get().asItem());

        output.accept(RuBlocks.COBALT_OBSIDIAN.get().asItem());

        output.accept(RuBlocks.MOSSY_STONE.get().asItem());

        /*-----------------OTHER_BLOCKS-----------------*/
        output.accept(RuBlocks.ASH.get().asItem());
        output.accept(RuBlocks.VOLCANIC_ASH.get().asItem());
        output.accept(RuBlocks.ASH_VENT.get().asItem());
        output.accept(RuBlocks.ICICLE.get().asItem());

        /*-----------------WOOD_TYPES-----------------*/
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            for (Item item : set.getBuildingBlocksTabItems()) {
                output.accept(item);
            }
            for (Item item : set.getFunctionalBlocksTabItems()) {
                output.accept(item);
            }
            for (Item item : set.getToolsAndUtilitiesTabItems()) {
                output.accept(item);
            }
        }
        //BAMBOO
        output.accept(RuBlocks.BAMBOO_LOG.get().asItem());
        output.accept(RuBlocks.STRIPPED_BAMBOO_LOG.get().asItem());
        //OAK
        output.accept(RuBlocks.SMALL_OAK_LOG.get().asItem());
        output.accept(RuBlocks.STRIPPED_SMALL_OAK_LOG.get().asItem());

        /*-----------------PAINTED PLANKS-----------------*/
        //PLANKS
        for (Block block : RuBlocks.PAINTED_PLANKS.getAll()) {
            output.accept(block);
        }
        for (Block block : RuBlocks.PAINTED_STAIRS.getAll()) {
            output.accept(block);
        }
        for (Block block : RuBlocks.PAINTED_SLABS.getAll()) {
            output.accept(block);
        }
    };


    public static final Supplier<CreativeModeTab> TAB = registerTab("main", () -> RuBlocks.BAOBAB_WOOD_SET.getBoat().getDefaultInstance(), TAB_ORDER);
            //comment out Corgi's solution for future use
            //() -> BuiltInRegistries.ITEM.stream().filter(item -> BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(Constants.MOD_ID)).map(item -> Suppliers.memoize(() -> item)).collect(Collectors.toUnmodifiableList()));

    public static Supplier<CreativeModeTab> registerTab(String path, Supplier<ItemStack> icon, Supplier<CreativeModeTab.DisplayItemsGenerator> items) {
        return Registar.registerCreativeModeTab(path, icon, items);
    }

    public static void init(){}
}
