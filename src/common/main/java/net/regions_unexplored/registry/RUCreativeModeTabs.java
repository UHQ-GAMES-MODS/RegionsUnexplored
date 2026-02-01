package net.regions_unexplored.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Expect;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.platform.Registrar;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public interface RUCreativeModeTabs {
    Supplier<CreativeModeTab> MAIN = Registrar.register(BuiltInRegistries.CREATIVE_MODE_TAB, "main", () ->
        builder()
        .title(Component.translatable("item_group.regions_unexplored.main"))
        .hideTitle()
        .backgroundTexture(RegionsUnexplored.id("textures/gui/container/creative_inventory/tab_regions_unexplored.png"))
        .icon(() -> RUBlocks.PRISMARITE_CLUSTER.get().asItem().getDefaultInstance())
        .displayItems((params, output) -> {
            output.accept(RUBlocks.PRISMOSS.get().asItem());
            output.accept(RUBlocks.DEEPSLATE_PRISMOSS.get().asItem());
            output.accept(RUBlocks.PRISMARITE_CLUSTER.get().asItem());
            output.accept(RUBlocks.LARGE_PRISMARITE_CLUSTER.get().asItem());
            output.accept(RUBlocks.HANGING_PRISMARITE.get().asItem());
            output.accept(RUBlocks.PRISMOSS_SPROUT.get().asItem());
            output.accept(RUBlocks.PRISMAGLASS.get().asItem());
            //REDSTONE_BLOCKS
            output.accept(RUBlocks.REDSTONE_BUD.get().asItem());
            output.accept(RUBlocks.REDSTONE_BULB.get().asItem());
            output.accept(RUBlocks.POINTED_REDSTONE.get().asItem());
            output.accept(RUBlocks.RAW_REDSTONE_BLOCK.get().asItem());
            //ANCIENT_DELTA
            output.accept(RUBlocks.CORPSE_FLOWER.get().asItem());
            output.accept(RUBlocks.DROPLEAF.get().asItem());
            output.accept(RUBlocks.DUSKMELON.get().asItem());
            output.accept(RUBlocks.DUSKTRAP.get().asItem());
            //OTHER_CAVE_BLOCKS
            output.accept(RUBlocks.STONE_GRASS_BLOCK.get().asItem());
            output.accept(RUBlocks.DEEPSLATE_GRASS_BLOCK.get().asItem());
            output.accept(RUBlocks.VIRIDESCENT_NYLIUM.get().asItem());
            output.accept(RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get().asItem());
            /*-----------------PLANTS-----------------*/
            //GRASS_BLOCKS
            output.accept(RUBlocks.ASHEN_GRASS.get().asItem());
            output.accept(RUBlocks.BLADED_GRASS.get().asItem());
            output.accept(RUBlocks.DEAD_STEPPE_SHRUB.get().asItem());
            output.accept(RUBlocks.FROZEN_GRASS.get().asItem());
            output.accept(RUBlocks.MEDIUM_GRASS.get().asItem());
            output.accept(RUBlocks.SANDY_GRASS.get().asItem());
            output.accept(RUBlocks.SMALL_DESERT_SHRUB.get().asItem());
            output.accept(RUBlocks.STEPPE_GRASS.get().asItem());
            output.accept(RUBlocks.STEPPE_SHRUB.get().asItem());
            output.accept(RUBlocks.STONE_BUD.get().asItem());

            output.accept(RUBlocks.BRIMSPROUT.get().asItem());
            output.accept(RUBlocks.COBALT_ROOTS.get().asItem());
            output.accept(RUBlocks.GLISTERING_SPROUT.get().asItem());
            output.accept(RUBlocks.GLISTERING_FERN.get().asItem());
            output.accept(RUBlocks.MYCOTOXIC_GRASS.get().asItem());

            output.accept(RUBlocks.BLADED_TALL_GRASS.get().asItem());
            output.accept(RUBlocks.ELEPHANT_EAR.get().asItem());
            output.accept(RUBlocks.SANDY_TALL_GRASS.get().asItem());
            output.accept(RUBlocks.STEPPE_TALL_GRASS.get().asItem());
            output.accept(RUBlocks.WINDSWEPT_GRASS.get().asItem());

            output.accept(RUBlocks.CLOVER.get().asItem());
            //FLOWERS
            output.accept(RUBlocks.ALPHA_DANDELION.get().asItem());
            output.accept(RUBlocks.ALPHA_ROSE.get().asItem());
            output.accept(RUBlocks.ASTER.get().asItem());
            output.accept(RUBlocks.BLEEDING_HEART.get().asItem());
            output.accept(RUBlocks.DAISY.get().asItem());
            output.accept(RUBlocks.DORCEL.get().asItem());
            output.accept(RUBlocks.FELICIA_DAISY.get().asItem());
            output.accept(RUBlocks.FIREWEED.get().asItem());
            output.accept(RUBlocks.GLISTERING_BLOOM.get().asItem());
            output.accept(RUBlocks.HIBISCUS.get().asItem());
            output.accept(RUBlocks.HYSSOP.get().asItem());
            output.accept(RUBlocks.MALLOW.get().asItem());
            output.accept(RUBlocks.POPPY_BUSH.get().asItem());
            output.accept(RUBlocks.SALMON_POPPY_BUSH.get().asItem());
            output.accept(RUBlocks.TSUBAKI.get().asItem());
            output.accept(RUBlocks.WARATAH.get().asItem());
            output.accept(RUBlocks.WHITE_TRILLIUM.get().asItem());
            output.accept(RUBlocks.WILTING_TRILLIUM.get().asItem());
            output.accept(RUBlocks.BLUE_LUPINE.get().asItem());
            output.accept(RUBlocks.PINK_LUPINE.get().asItem());
            output.accept(RUBlocks.PURPLE_LUPINE.get().asItem());
            output.accept(RUBlocks.RED_LUPINE.get().asItem());
            output.accept(RUBlocks.YELLOW_LUPINE.get().asItem());
            output.accept(RUBlocks.COBALT_EARLIGHT.get().asItem());

            output.accept(RUBlocks.ORANGE_CONEFLOWER.get().asItem());
            output.accept(RUBlocks.PURPLE_CONEFLOWER.get().asItem());
            //SNOWBELLE
            for (Block snowbelle : RUBlocks.SNOWBELLES.getAll()) {
                output.accept(snowbelle);
            }

            output.accept(RUBlocks.HYACINTH_FLOWERS.get().asItem());
            output.accept(RUBlocks.BLUE_MAGNOLIA_FLOWERS.get().asItem());
            output.accept(RUBlocks.PINK_MAGNOLIA_FLOWERS.get().asItem());
            output.accept(RUBlocks.WHITE_MAGNOLIA_FLOWERS.get().asItem());

            output.accept(RUBlocks.MAPLE_LEAF_PILE.get().asItem());
            output.accept(RUBlocks.RED_MAPLE_LEAF_PILE.get().asItem());
            output.accept(RUBlocks.ORANGE_MAPLE_LEAF_PILE.get().asItem());
            output.accept(RUBlocks.ENCHANTED_BIRCH_LEAF_PILE.get().asItem());
            output.accept(RUBlocks.SILVER_BIRCH_LEAF_PILE.get().asItem());

            //TALL_PLANTS
            output.accept(RUBlocks.BARLEY.get().asItem());
            output.accept(RUBlocks.CATTAIL.get().asItem());
            output.accept(RUBlocks.DAY_LILY.get().asItem());
            output.accept(RUBlocks.MEADOW_SAGE.get().asItem());
            output.accept(RUBlocks.TASSEL.get().asItem());
            output.accept(RUBlocks.GLISTER_BULB.get().asItem());
            output.accept(RUBlocks.GLISTER_SPIRE.get().asItem());
            output.accept(RUBlocks.MYCOTOXIC_DAISY.get().asItem());
            output.accept(RUBlocks.TALL_COBALT_EARLIGHT.get().asItem());
            //HYACINTH_BLOCKS
            output.accept(RUBlocks.HYACINTH_BLOOM.get().asItem());
            output.accept(RUBlocks.TALL_HYACINTH_STOCK.get().asItem());
            output.accept(RUBlocks.HYACINTH_LAMP.get().asItem());
            //SAPLINGS
            for (NaturalSet set : RUBlocks.NATURAL_SETS) {
                if (set.getSapling() == null) continue;
                output.accept(set.getSapling());
            }
            for (NaturalSet set : RUBlocks.NATURAL_SETS) {
                if (set.getShrub() == null) continue;
                output.accept(set.getShrub());
            }
            //MUSHROOMS
            output.accept(RUBlocks.BLUE_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.GREEN_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.PINK_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.YELLOW_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.TALL_BLUE_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.TALL_GREEN_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.TALL_PINK_BIOSHROOM.get().asItem());
            output.accept(RUBlocks.TALL_YELLOW_BIOSHROOM.get().asItem());
            //OTHER_PLANT_BLOCKS
            output.accept(RUBlocks.BARREL_CACTUS.get().asItem());
            output.accept(RUBlocks.CAVE_HYSSOP.get().asItem());
            output.accept(RUBlocks.DUCKWEED.get().asItem());
            output.accept(RUBlocks.FLOWERING_LILY_PAD.get().asItem());
            output.accept(RUBlocks.KAPOK_VINES.get().asItem());
            output.accept(RUBlocks.SPANISH_MOSS.get().asItem());
            output.accept(RUBlocks.GLISTERING_IVY.get().asItem());
            //FOOD_PLANT_BLOCKS
            output.accept(RUItems.SALMONBERRY.get().asItem());
            output.accept(RUBlocks.HANGING_EARLIGHT.get().asItem());
            /*-----------------PLANT_BLOCKS-----------------*/
            //MUSHROOMS
            output.accept(RUBlocks.BLUE_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.GREEN_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.PINK_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.YELLOW_BIOSHROOM_BLOCK.get().asItem());
            output.accept(RUBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get().asItem());
            //CACTUS
            output.accept(RUBlocks.SAGUARO_CACTUS.get().asItem());

            /*-----------------LEAVES-----------------*/
            for (NaturalSet set : RUBlocks.NATURAL_SETS) {
                if (set.getLeaves() == null) continue;
                output.accept(set.getLeaves());
            }

            /*-----------------BRANCHES-----------------*/
            for (NaturalSet set : RUBlocks.NATURAL_SETS) {
                if (set.getBranch() == null) continue;
                output.accept(set.getBranch());
            }

            /*-----------------DIRT_BLOCKS-----------------*/
            //OTHER_DIRT_BLOCKS
            output.accept(RUBlocks.ALPHA_GRASS_BLOCK.get().asItem());
            //ASHEN_BLOCKS
            output.accept(RUBlocks.ASHEN_DIRT.get().asItem());
            //FOREST_DIRT_BLOCKS
            output.accept(RUBlocks.PEAT_GRASS_BLOCK.get().asItem());
            output.accept(RUBlocks.PEAT_DIRT.get().asItem());
            output.accept(RUBlocks.PEAT_DIRT_PATH.get().asItem());
            output.accept(RUBlocks.PEAT_COARSE_DIRT.get().asItem());
            output.accept(RUBlocks.PEAT_PODZOL.get().asItem());
            output.accept(RUBlocks.PEAT_MUD.get().asItem());
            output.accept(RUBlocks.PEAT_FARMLAND.get().asItem());
            //PLAINS_DIRT_BLOCKS
            output.accept(RUBlocks.SILT_GRASS_BLOCK.get().asItem());
            output.accept(RUBlocks.SILT_DIRT.get().asItem());
            output.accept(RUBlocks.SILT_DIRT_PATH.get().asItem());
            output.accept(RUBlocks.SILT_COARSE_DIRT.get().asItem());
            output.accept(RUBlocks.SILT_PODZOL.get().asItem());
            output.accept(RUBlocks.SILT_MUD.get().asItem());
            output.accept(RUBlocks.SILT_FARMLAND.get().asItem());
            //NETHER
            output.accept(RUBlocks.BRIMSPROUT_NYLIUM.get().asItem());
            output.accept(RUBlocks.COBALT_NYLIUM.get().asItem());
            output.accept(RUBlocks.GLISTERING_NYLIUM.get().asItem());
            output.accept(RUBlocks.GLISTERING_WART.get().asItem());
            output.accept(RUBlocks.OVERGROWN_BONE_BLOCK.get().asItem());
            output.accept(RUBlocks.MYCOTOXIC_NYLIUM.get().asItem());
            /*-----------------STONE_BLOCKS-----------------*/
            //CHALKS
            output.accept(RUBlocks.CHALK_GRASS_BLOCK.get().asItem());
            output.accept(RUBlocks.CHALK.get().asItem());
            output.accept(RUBlocks.CHALK_BRICKS.get().asItem());
            output.accept(RUBlocks.CHALK_BRICK_SLAB.get().asItem());
            output.accept(RUBlocks.CHALK_BRICK_STAIRS.get().asItem());
            output.accept(RUBlocks.CHALK_PILLAR.get().asItem());
            output.accept(RUBlocks.CHALK_SLAB.get().asItem());
            output.accept(RUBlocks.CHALK_STAIRS.get().asItem());
            output.accept(RUBlocks.POLISHED_CHALK.get().asItem());
            output.accept(RUBlocks.POLISHED_CHALK_SLAB.get().asItem());
            output.accept(RUBlocks.POLISHED_CHALK_STAIRS.get().asItem());
            //STONES
            output.accept(RUBlocks.ARGILLITE_GRASS_BLOCK.get().asItem());
            output.accept(RUBlocks.ARGILLITE.get().asItem());

            output.accept(RUBlocks.BLACKSTONE_CLUSTER.get().asItem());

            output.accept(RUBlocks.COBALT_OBSIDIAN.get().asItem());

            output.accept(RUBlocks.MOSSY_STONE.get().asItem());

            /*-----------------OTHER_BLOCKS-----------------*/
            output.accept(RUBlocks.ASH.get().asItem());
            output.accept(RUBlocks.VOLCANIC_ASH.get().asItem());
            output.accept(RUBlocks.ASH_VENT.get().asItem());
            output.accept(RUBlocks.ICICLE.get().asItem());

            /*-----------------WOOD_TYPES-----------------*/
            for (WoodSet set : RUBlocks.WOOD_SETS) {
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
            output.accept(RUBlocks.BAMBOO_LOG.get().asItem());
            output.accept(RUBlocks.STRIPPED_BAMBOO_LOG.get().asItem());
            //OAK
            output.accept(RUBlocks.SMALL_OAK_LOG.get().asItem());
            output.accept(RUBlocks.STRIPPED_SMALL_OAK_LOG.get().asItem());

            /*-----------------PAINTED PLANKS-----------------*/
            //PLANKS
            for (Block block : RUBlocks.PAINTED_PLANKS.getAll()) {
                output.accept(block);
            }
            for (Block block : RUBlocks.PAINTED_STAIRS.getAll()) {
                output.accept(block);
            }
            for (Block block : RUBlocks.PAINTED_SLABS.getAll()) {
                output.accept(block);
            }
        })
        .build()
    );

    static void init() {
    }

    static void addToBuildingBlocks(BiConsumer<ItemLike, ItemLike> consumer) {
        ItemLike anchor = Items.BAMBOO_BUTTON;
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            for (Item item : set.getBuildingBlocksTabItems()) {
                consumer.accept(anchor, item);
                anchor = item;
            }
        }
    }

    static void addToColoredBlocks(BiConsumer<ItemLike, ItemLike> consumer) {
        ItemLike anchor = Items.PINK_GLAZED_TERRACOTTA;
        for (Block block : RUBlocks.PAINTED_PLANKS.getAll()) {
            consumer.accept(anchor, block);
            anchor = block;
        }
        for (Block block : RUBlocks.PAINTED_STAIRS.getAll()) {
            consumer.accept(anchor, block);
            anchor = block;
        }
        for (Block block : RUBlocks.PAINTED_SLABS.getAll()) {
            consumer.accept(anchor, block);
            anchor = block;
        }
    }

    static void addToFunctionalBlocks(BiConsumer<ItemLike, ItemLike> consumer) {
        ItemLike anchor = Items.BAMBOO_HANGING_SIGN;
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            for (Item item : set.getFunctionalBlocksTabItems()) {
                consumer.accept(anchor, item);
                anchor = item;
            }
        }
    }

    static void addToToolsAndUtilities(BiConsumer<ItemLike, ItemLike> consumer) {
        ItemLike anchor = Items.BAMBOO_CHEST_RAFT;
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            for (Item item : set.getToolsAndUtilitiesTabItems()) {
                consumer.accept(anchor, item);
                anchor = item;
            }
        }
    }

    static void addToFoodAndDrinks(BiConsumer<ItemLike, ItemLike> consumer) {
        consumer.accept(Items.MELON_SLICE, RUItems.DUSKMELON_SLICE.get());
        consumer.accept(Items.SWEET_BERRIES, RUItems.SALMONBERRY.get());
        consumer.accept(Items.GLOW_BERRIES, RUItems.HANGING_EARLIGHT_FRUIT.get());
        consumer.accept(Items.BEETROOT, RUItems.MEADOW_SAGE.get());
    }

    @Expect
    static CreativeModeTab.Builder builder();
}
