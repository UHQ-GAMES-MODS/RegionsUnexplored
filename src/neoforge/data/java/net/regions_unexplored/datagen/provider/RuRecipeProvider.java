package net.regions_unexplored.datagen.provider;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.item.RuItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class RuRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final Supplier<ImmutableList<ItemLike>> REDSTONE_SMELTABLES = Suppliers.memoize(() -> ImmutableList.of(RuBlocks.RAW_REDSTONE_BLOCK.get(), RuBlocks.REDSTONE_BULB.get()));
    public static final Supplier<ImmutableList<ItemLike>> MOSSY_STONE_SMELTABLES = Suppliers.memoize(() ->ImmutableList.of(Blocks.MOSSY_COBBLESTONE));

    public RuRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> holder) {
        super(output, holder);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        /*-----------------CAVE_BLOCKS_DONE-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PRISMOSS.get(), 1).define('#', Blocks.STONE).define('X', RuBlocks.PRISMOSS_SPROUT.get()).pattern("X").pattern("#").group("prismoss").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_PRISMOSS.get(), 1).define('#', Blocks.DEEPSLATE).define('X', RuBlocks.PRISMOSS_SPROUT.get()).pattern("X").pattern("#").group("prismoss").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.HANGING_PRISMARITE.get(), 1).define('#', RuBlocks.PRISMARITE_CLUSTER.get()).pattern("#").pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RuBlocks.PRISMARITE_CLUSTER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.LARGE_PRISMARITE_CLUSTER.get(), 1).define('#', RuBlocks.PRISMARITE_CLUSTER.get()).pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RuBlocks.PRISMARITE_CLUSTER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PRISMAGLASS.get(), 2).define('#', TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "glass"))).define('X', RuTags.PRISMARITE_CRYSTALS_ITEM).pattern(" X ").pattern("X#X").pattern(" X ").group("stained_glass").unlockedBy("has_glass", has(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "glass")))).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RuBlocks.RAW_REDSTONE_BLOCK.get(), 1).define('#', Items.REDSTONE).pattern("##").pattern("##").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);
        oreSmelting(consumer, REDSTONE_SMELTABLES.get(), RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 200, "redstone");
        oreBlasting(consumer, REDSTONE_SMELTABLES.get(), RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 100, "redstone");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RuBlocks.REDSTONE_BUD.get(), 2).define('#', Items.REDSTONE).pattern("###").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.STONE_GRASS_BLOCK.get(), 1).define('#', Blocks.STONE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), 1).define('#', Blocks.DEEPSLATE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.VIRIDESCENT_NYLIUM.get(), 1).define('#', Blocks.STONE).define('X', TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "mushrooms")))).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), 1).define('#', Blocks.DEEPSLATE).define('X', TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "mushrooms")))).save(consumer);

        /*-----------------PLANTS-----------------*/
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.DEAD_STEPPE_SHRUB.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.SMALL_DESERT_SHRUB.get(), "brown_dye");


        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.ALPHA_DANDELION.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.ALPHA_ROSE.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.BLEEDING_HEART.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_LUPINE.get(), "blue_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.DAISY.get(), "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.BLACK_DYE, RuBlocks.DORCEL.get(), "black_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.FELICIA_DAISY.get(), "light_blue_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.FIREWEED.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.GLISTERING_BLOOM.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.HIBISCUS.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.MALLOW.get(), "orange_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.HYSSOP.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_LUPINE.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.POPPY_BUSH.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.SALMON_POPPY_BUSH.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.PURPLE_LUPINE.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.RED_LUPINE.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.WARATAH.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_TRILLIUM.get(), "white_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.WILTING_TRILLIUM.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.YELLOW_LUPINE.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.TSUBAKI.get(), "red_dye");

        //SNOWBELLE
        for (Map.Entry<DyeColor, Block> entry : RuBlocks.SNOWBELLES.getMap().entrySet()) {
            oneToOneConversionRecipe(consumer, DyeItem.byColor(entry.getKey()), entry.getValue(), entry.getKey().getName() + "_dye");
            snowbelle(consumer, entry.getValue(), TagKey.create(Registries.ITEM, cId("dyes/" + entry.getKey().getName())));
        }

        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.ORANGE_CONEFLOWER.get(), "orange_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.PURPLE_CONEFLOWER.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.ASTER.get(), "light_blue_dye");

        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), "light_blue_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 6).define('#', RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves()).pattern("###").group("multiface_flowers").unlockedBy("has_blue_magnolia_leaves", has(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves())).save(consumer);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), "pink_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), 6).define('#', RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves()).pattern("###").group("multiface_flowers").unlockedBy("has_pink_magnolia_leaves", has(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves())).save(consumer);
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), "white_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 6).define('#', RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves()).pattern("###").group("multiface_flowers").unlockedBy("has_white_magnolia_leaves", has(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves())).save(consumer);

        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuItems.MEADOW_SAGE.get(), "blue_dye");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.BARLEY.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 200).unlockedBy("has_barley", has(RuBlocks.BARLEY.get())).save(consumer, RegionsUnexplored.id("barley_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(RuBlocks.BARLEY.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 100).unlockedBy("has_barley", has(RuBlocks.BARLEY.get())).save(consumer, RegionsUnexplored.id("barley_smoking"));
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.CATTAIL.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.TASSEL.get(), "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.DAY_LILY.get(), "orange_dye");

        oneToOneConversionRecipe(consumer, RuBlocks.ASHEN_NATURAL_SET.getSapling(), RuBlocks.ASHEN_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.ACACIA_SAPLING, RuBlocks.ACACIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.BIRCH_SAPLING, RuBlocks.BIRCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BAOBAB_NATURAL_SET.getSapling(), RuBlocks.BAOBAB_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BLACKWOOD_NATURAL_SET.getSapling(), RuBlocks.BLACKWOOD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BRIMWOOD_NATURAL_SET.getSapling(), RuBlocks.BRIMWOOD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.CHERRY_SAPLING, RuBlocks.CHERRY_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.CACTUS_NATURAL_SET.getSapling(), "magenta_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.MAGNOLIA_NATURAL_SET.getSapling(), RuBlocks.MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.CYPRESS_NATURAL_SET.getSapling(), RuBlocks.CYPRESS_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.DARK_OAK_SAPLING, RuBlocks.DARK_OAK_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.DEAD_PINE_NATURAL_SET.getSapling(), RuBlocks.DEAD_PINE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.DEAD_NATURAL_SET.getSapling(), RuBlocks.DEAD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.EUCALYPTUS_NATURAL_SET.getSapling(), RuBlocks.EUCALYPTUS_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.FLOWERING_NATURAL_SET.getSapling(), RuBlocks.FLOWERING_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling(), RuBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.JOSHUA_NATURAL_SET.getSapling(), RuBlocks.JOSHUA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.KAPOK_NATURAL_SET.getSapling(), RuBlocks.KAPOK_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.JUNGLE_SAPLING, RuBlocks.JUNGLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.LARCH_NATURAL_SET.getSapling(), RuBlocks.LARCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.MANGROVE_PROPAGULE, RuBlocks.MANGROVE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.MAPLE_NATURAL_SET.getSapling(), RuBlocks.MAPLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.MAUVE_NATURAL_SET.getSapling(), RuBlocks.MAUVE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.OAK_SAPLING, RuBlocks.OAK_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling(), RuBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PALM_NATURAL_SET.getSapling(), RuBlocks.PALM_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PINE_NATURAL_SET.getSapling(), RuBlocks.PINE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling(), RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling(), RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.REDWOOD_NATURAL_SET.getSapling(), RuBlocks.REDWOOD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.RED_MAPLE_NATURAL_SET.getSapling(), RuBlocks.RED_MAPLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling(), RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.SILVER_BIRCH_NATURAL_SET.getSapling(), RuBlocks.SILVER_BIRCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.SOCOTRA_NATURAL_SET.getSapling(), RuBlocks.SOCOTRA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.SPRUCE_SAPLING, RuBlocks.SPRUCE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling(), RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.WILLOW_NATURAL_SET.getSapling(), RuBlocks.WILLOW_NATURAL_SET.getShrub(), "saplings", 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ASHEN_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.ASHEN_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_ashen_sapling", has(RuBlocks.ASHEN_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ACACIA_NATURAL_SET.getShrub(), 1).define('#', Blocks.ACACIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_acacia_sapling", has(Blocks.ACACIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BAOBAB_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.BAOBAB_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_baobab_sapling", has(RuBlocks.BAOBAB_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BIRCH_NATURAL_SET.getShrub(), 1).define('#', Blocks.BIRCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_birch_sapling", has(Blocks.BIRCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLACKWOOD_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.BLACKWOOD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blackwood_sapling", has(RuBlocks.BLACKWOOD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BRIMWOOD_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.BRIMWOOD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_brimwood_sapling", has(RuBlocks.BRIMWOOD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.CHERRY_NATURAL_SET.getShrub(), 1).define('#', Blocks.CHERRY_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cherry_sapling", has(Blocks.CHERRY_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_magnolia_sapling", has(RuBlocks.MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.CYPRESS_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.CYPRESS_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cypress_sapling", has(RuBlocks.CYPRESS_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DARK_OAK_NATURAL_SET.getShrub(), 1).define('#', Blocks.DARK_OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dark_oak_sapling", has(Blocks.DARK_OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DEAD_PINE_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.DEAD_PINE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_pine_sapling", has(RuBlocks.DEAD_PINE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DEAD_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.DEAD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_sapling", has(RuBlocks.DEAD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.EUCALYPTUS_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.EUCALYPTUS_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_eucalyptus_sapling", has(RuBlocks.EUCALYPTUS_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.FLOWERING_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.FLOWERING_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_flowering_sapling", has(RuBlocks.FLOWERING_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_golden_larch_sapling", has(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.JOSHUA_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.JOSHUA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_joshua_sapling", has(RuBlocks.JOSHUA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.KAPOK_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.KAPOK_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_kapok_sapling", has(RuBlocks.KAPOK_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.JUNGLE_NATURAL_SET.getShrub(), 1).define('#', Blocks.JUNGLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_jungle_sapling", has(Blocks.JUNGLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.LARCH_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.LARCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_larch_sapling", has(RuBlocks.LARCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MANGROVE_NATURAL_SET.getShrub(), 1).define('#', Blocks.MANGROVE_PROPAGULE).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mangrove_propagule", has(Blocks.MANGROVE_PROPAGULE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAPLE_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.MAPLE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_maple_sapling", has(RuBlocks.MAPLE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAUVE_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.MAUVE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mauve_sapling", has(RuBlocks.MAUVE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.OAK_NATURAL_SET.getShrub(), 1).define('#', Blocks.OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_oak_sapling", has(Blocks.OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_orange_maple_sapling", has(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PALM_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.PALM_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_palm_sapling", has(RuBlocks.PALM_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINE_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.PINE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pine_sapling", has(RuBlocks.PINE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blue_magnolia_sapling", has(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pink_magnolia_sapling", has(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.REDWOOD_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.REDWOOD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_redwood_sapling", has(RuBlocks.REDWOOD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.RED_MAPLE_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.RED_MAPLE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_red_maple_sapling", has(RuBlocks.RED_MAPLE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_enchanted_birch_sapling", has(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SILVER_BIRCH_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.SILVER_BIRCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_silver_birch_sapling", has(RuBlocks.SILVER_BIRCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SOCOTRA_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.SOCOTRA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_socotra_sapling", has(RuBlocks.SOCOTRA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SPRUCE_NATURAL_SET.getShrub(), 1).define('#', Blocks.SPRUCE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_spruce_sapling", has(Blocks.SPRUCE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_white_magnolia_sapling", has(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WILLOW_NATURAL_SET.getShrub(), 1).define('#', RuBlocks.WILLOW_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_willow_sapling", has(RuBlocks.WILLOW_NATURAL_SET.getSapling())).save(consumer);

        oneToOneConversionRecipe(consumer, RuBlocks.BLUE_BIOSHROOM.get(), RuBlocks.TALL_BLUE_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_BIOSHROOM.get(), "blue_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.GREEN_BIOSHROOM.get(), RuBlocks.TALL_GREEN_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.LIME_DYE, RuBlocks.GREEN_BIOSHROOM.get(), "lime_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.PINK_BIOSHROOM.get(), RuBlocks.TALL_PINK_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_BIOSHROOM.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.YELLOW_BIOSHROOM.get(), RuBlocks.TALL_YELLOW_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.TALL_YELLOW_BIOSHROOM.get(), "yellow_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_BLUE_BIOSHROOM.get(), 1).define('#', RuBlocks.BLUE_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_blue_bioshroom", has(RuBlocks.BLUE_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_GREEN_BIOSHROOM.get(), 1).define('#', RuBlocks.GREEN_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_green_bioshroom", has(RuBlocks.GREEN_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_PINK_BIOSHROOM.get(), 1).define('#', RuBlocks.PINK_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_pink_bioshroom", has(RuBlocks.PINK_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_YELLOW_BIOSHROOM.get(), 1).define('#', RuBlocks.YELLOW_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_yellow_bioshroom", has(RuBlocks.YELLOW_BIOSHROOM.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.ICE).define('#', RuBlocks.ICICLE.get()).pattern("##").pattern("##").group("ice").unlockedBy("has_icicle", has(RuBlocks.ICICLE.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Blocks.ICE,RuBlocks.ICICLE.get())));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.BARREL_CACTUS.get()), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_barrel_cactus", has(RuBlocks.BARREL_CACTUS.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Items.GREEN_DYE, RuBlocks.BARREL_CACTUS.get())));
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.CAVE_HYSSOP.get(), "orange_dye");

        /*-----------------PLANT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.BLUE_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.BLUE_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom", has(RuBlocks.BLUE_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), 4).define('#', RuBlocks.BLUE_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom_block", has(RuBlocks.BLUE_BIOSHROOM_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GREEN_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.GREEN_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_green_bioshroom", has(RuBlocks.GREEN_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), 4).define('#', RuBlocks.GREEN_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_green_bioshroom_block", has(RuBlocks.GREEN_BIOSHROOM_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PINK_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.PINK_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom", has(RuBlocks.PINK_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), 4).define('#', RuBlocks.PINK_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom_block", has(RuBlocks.PINK_BIOSHROOM_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.YELLOW_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.YELLOW_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom", has(RuBlocks.YELLOW_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(), 4).define('#', RuBlocks.YELLOW_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom_block", has(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get())).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.SAGUARO_CACTUS.get()), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_saguaro_cactus", has(RuBlocks.SAGUARO_CACTUS.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Items.GREEN_DYE, RuBlocks.SAGUARO_CACTUS.get())));

        /*-----------------BRANCHES-----------------*/
        branchFromLog(consumer, RuBlocks.ACACIA_NATURAL_SET.getBranch(), Blocks.ACACIA_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.ACACIA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.BAOBAB_NATURAL_SET.getBranch(), RuBlocks.BAOBAB_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BAOBAB_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.BIRCH_NATURAL_SET.getBranch(), Blocks.BIRCH_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BIRCH_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.BLACKWOOD_NATURAL_SET.getBranch(), RuBlocks.BLACKWOOD_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BLACKWOOD_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.MAGNOLIA_NATURAL_SET.getBranch(), RuBlocks.MAGNOLIA_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAGNOLIA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.CYPRESS_NATURAL_SET.getBranch(), RuBlocks.CYPRESS_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.CYPRESS_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.CHERRY_NATURAL_SET.getBranch(), Blocks.CHERRY_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.CHERRY_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.DARK_OAK_NATURAL_SET.getBranch(), Blocks.DARK_OAK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.DARK_OAK_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.DEAD_NATURAL_SET.getBranch(), RuBlocks.DEAD_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.DEAD_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.EUCALYPTUS_NATURAL_SET.getBranch(), RuBlocks.EUCALYPTUS_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.EUCALYPTUS_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.JOSHUA_NATURAL_SET.getBranch(), RuBlocks.JOSHUA_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.JOSHUA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.KAPOK_NATURAL_SET.getBranch(), RuBlocks.KAPOK_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.KAPOK_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.JUNGLE_NATURAL_SET.getBranch(), Blocks.JUNGLE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.JUNGLE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.LARCH_NATURAL_SET.getBranch(), RuBlocks.LARCH_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.LARCH_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.MANGROVE_NATURAL_SET.getBranch(), Blocks.MANGROVE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MANGROVE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.MAPLE_NATURAL_SET.getBranch(), RuBlocks.MAPLE_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAPLE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.MAUVE_NATURAL_SET.getBranch(), RuBlocks.MAUVE_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAUVE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.OAK_NATURAL_SET.getBranch(), Blocks.OAK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.OAK_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.PALM_NATURAL_SET.getBranch(), RuBlocks.PALM_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.PALM_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.PINE_NATURAL_SET.getBranch(), RuBlocks.PINE_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.PINE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.REDWOOD_NATURAL_SET.getBranch(), RuBlocks.REDWOOD_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.REDWOOD_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(), RuBlocks.SILVER_BIRCH_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.SOCOTRA_NATURAL_SET.getBranch(), RuBlocks.SOCOTRA_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SOCOTRA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.SPRUCE_NATURAL_SET.getBranch(), Blocks.SPRUCE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SPRUCE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RuBlocks.WILLOW_NATURAL_SET.getBranch(), RuBlocks.WILLOW_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.WILLOW_NATURAL_SET.getBranch(), "stick", 4);

        /*-----------------DIRT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PEAT_COARSE_DIRT.get(), 4).define('D', RuBlocks.PEAT_DIRT.get()).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.SILT_COARSE_DIRT.get(), 4).define('D', RuBlocks.SILT_DIRT.get()).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT.get(), 4).define('D', Blocks.DIRT).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(RuBlocks.ASHEN_DIRT.get(), Blocks.DIRT)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT.get(), 4).define('D', RuBlocks.PEAT_DIRT.get()).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(RuBlocks.ASHEN_DIRT.get(), RuBlocks.PEAT_DIRT.get())));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT.get(), 4).define('D', RuBlocks.SILT_DIRT.get()).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(RuBlocks.ASHEN_DIRT.get(), RuBlocks.SILT_DIRT.get())));

        /*-----------------STONE_BLOCKS-----------------*/

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_SLAB.get(), Ingredient.of(RuBlocks.CHALK.get())).group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_SLAB.get(), RuBlocks.CHALK.get(), 2);

        stairBuilder(RuBlocks.CHALK_STAIRS.get(), Ingredient.of(RuBlocks.CHALK.get())).group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_STAIRS.get(), RuBlocks.CHALK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_GRASS_BLOCK.get(), 1).define('#', RuBlocks.CHALK.get()).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_chalk", has(RuBlocks.CHALK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS.get(), 4).define('#', RuBlocks.POLISHED_CHALK.get()).pattern("##").pattern("##").group("chalk").unlockedBy("has_polished_chalk", has(RuBlocks.POLISHED_CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS.get(), RuBlocks.CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS.get(), RuBlocks.CHALK_GRASS_BLOCK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS.get(), RuBlocks.POLISHED_CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS.get(), RuBlocks.CHALK_PILLAR.get());

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICK_SLAB.get(), Ingredient.of(RuBlocks.CHALK_BRICKS.get())).group("chalk").unlockedBy("has_chalk_bricks", has(RuBlocks.CHALK_BRICKS.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICK_SLAB.get(), RuBlocks.CHALK_BRICKS.get(), 2);

        stairBuilder(RuBlocks.CHALK_BRICK_STAIRS.get(), Ingredient.of(RuBlocks.CHALK_BRICKS.get())).group("chalk").unlockedBy("has_chalk_bricks", has(RuBlocks.CHALK_BRICKS.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICK_STAIRS.get(), RuBlocks.CHALK_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR.get(), 2).define('#', RuBlocks.CHALK.get()).pattern("#").pattern("#").group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR.get(), RuBlocks.CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR.get(), RuBlocks.CHALK_GRASS_BLOCK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR.get(), RuBlocks.POLISHED_CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR.get(), RuBlocks.CHALK_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK.get(), 4).define('#', RuBlocks.CHALK.get()).pattern("##").pattern("##").group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK.get(), RuBlocks.CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK.get(), RuBlocks.CHALK_GRASS_BLOCK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK.get(), RuBlocks.CHALK_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK.get(), RuBlocks.CHALK_PILLAR.get());

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK_SLAB.get(), Ingredient.of(RuBlocks.POLISHED_CHALK.get())).group("chalk").unlockedBy("has_polished_chalk", has(RuBlocks.POLISHED_CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK_SLAB.get(), RuBlocks.POLISHED_CHALK.get(), 2);

        stairBuilder(RuBlocks.POLISHED_CHALK_STAIRS.get(), Ingredient.of(RuBlocks.POLISHED_CHALK.get())).group("chalk").unlockedBy("has_polished_chalk", has(RuBlocks.POLISHED_CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK_STAIRS.get(), RuBlocks.POLISHED_CHALK.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RuBlocks.MOSSY_STONE.get(), 1).requires(Blocks.STONE).requires(Blocks.VINE).group("mossy").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_vine", has(Blocks.VINE)).save(consumer);
        oreSmelting(consumer, MOSSY_STONE_SMELTABLES.get(), RecipeCategory.BUILDING_BLOCKS, RuBlocks.MOSSY_STONE.get(), 0.1F, 200, "mossy");
        oreBlasting(consumer, MOSSY_STONE_SMELTABLES.get(), RecipeCategory.BUILDING_BLOCKS, RuBlocks.MOSSY_STONE.get(), 0.1F, 100, "mossy");

        /*-----------------OCEAN_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.HYACINTH_LAMP.get()).define('#', Items.PRISMARINE_SLAB).define('X', RuTags.HYACINTH_BLOOMS_ITEM).pattern("X").pattern("#").group("hyacinth").unlockedBy("has_prismarine_slab", has(Items.PRISMARINE_SLAB)).unlockedBy("has_hyacinth", has(RuTags.HYACINTH_BLOOMS_ITEM)).save(consumer);

        /*-----------------OTHER_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASH.get(), 1).define('#', Items.GUNPOWDER).pattern("##").pattern("##").group("ash").unlockedBy("has_gunpowder", has(Items.GUNPOWDER)).save(consumer);

        /*-----------------WOOD_TYPES-----------------*/
        planksFromLogs(consumer, Blocks.BAMBOO_PLANKS, RuTags.BAMBOO_LOGS_ITEM, 4);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO, 1).define('#', RuTags.BAMBOO_LOGS_ITEM).pattern("#").pattern("#").group("bamboo").unlockedBy("has_bamboo_log", has(RuTags.BAMBOO_LOGS_ITEM)).save(consumer);
        //ALPHA_BLOCKS
        woodenFence(consumer, Items.OAK_FENCE, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenDoor(consumer, Items.OAK_DOOR, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenFenceGate(consumer, Items.OAK_FENCE_GATE, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenTrapdoor(consumer, Items.OAK_TRAPDOOR, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        pressurePlate(consumer, Items.OAK_PRESSURE_PLATE, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenButton(consumer, Items.OAK_BUTTON, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenSign(consumer, Items.OAK_SIGN, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        hangingSign(consumer, Items.OAK_HANGING_SIGN, RuBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenBoat(consumer, Items.OAK_BOAT, RuBlocks.ALPHA_WOOD_SET.getPlanks());

        woodFromOtherItem(consumer, RuBlocks.BRIMWOOD_WOOD_SET.getWood(), RuBlocks.BRIMWOOD_WOOD_SET.getLogMagma());

        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.getWood() != null && set.getLog() != null) woodFromLogs(consumer, set.getWood(), set.getLog());
            if (set.getStrippedWood() != null && set.getStrippedLog() != null) woodFromLogs(consumer, set.getStrippedWood(), set.getStrippedLog());
            if (set.getPlanks() != null) planksFromLogs(consumer, set.getPlanks(), RuTags.createItem(RegionsUnexplored.id(set.getPlanks().builtInRegistryHolder().key().location().getPath().replace("_planks", "_logs"))), 4);
            woodenStairs(consumer, set.getStairs(), set.getPlanks());
            woodenSlab(consumer, set.getSlab(), set.getPlanks());
            woodenFence(consumer, set.getFence(), set.getPlanks());
            woodenDoor(consumer, set.getDoor(), set.getPlanks());
            woodenFenceGate(consumer, set.getFenceGate(), set.getPlanks());
            woodenTrapdoor(consumer, set.getTrapdoor(), set.getPlanks());
            pressurePlate(consumer, set.getPressurePlate(), set.getPlanks());
            woodenButton(consumer, set.getButton(), set.getPlanks());
            woodenSign(consumer, set.getSign(), set.getPlanks());
            hangingSign(consumer, set.getHangingSign(), set.getStrippedLog());
            woodenBoat(consumer, set.getBoat(), set.getPlanks());
            if (set.getChestBoat() != null && set.getBoat() != null) chestBoat(consumer, set.getChestBoat(), set.getBoat());
        }

        /*-----------------PAINTED PLANKS-----------------*/
        for (Map.Entry<DyeColor, Block> entry : RuBlocks.PAINTED_PLANKS.getMap().entrySet()) {
            paintedPlanks(consumer, entry.getValue(), TagKey.create(Registries.ITEM, cId("dyes/" + entry.getKey().getName())));
        }
        for (Map.Entry<DyeColor, Block> entry : RuBlocks.PAINTED_STAIRS.getMap().entrySet()) {
            paintedStairs(consumer, entry.getValue(), RuBlocks.PAINTED_PLANKS.getMap().get(entry.getKey()));
        }
        for (Map.Entry<DyeColor, Block> entry : RuBlocks.PAINTED_SLABS.getMap().entrySet()) {
            paintedSlab(consumer, entry.getValue(), RuBlocks.PAINTED_PLANKS.getMap().get(entry.getKey()));
        }

        /*-----------------NETHER_BLOCKS-----------------*/

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.BLACKSTONE_CLUSTER.get(), 2).define('#', Blocks.BLACKSTONE).pattern("##").pattern("##").group("blackstone").unlockedBy("has_blackstone", has(Blocks.BLACKSTONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE, 1).define('#', RuBlocks.BLACKSTONE_CLUSTER.get()).pattern("##").group("blackstone").unlockedBy("has_blackstone_cluster", has(RuBlocks.BLACKSTONE_CLUSTER.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Blocks.BLACKSTONE,RuBlocks.BLACKSTONE_CLUSTER.get())));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RuBlocks.OVERGROWN_BONE_BLOCK.get(), 1).requires(Blocks.BONE_BLOCK).requires(RuBlocks.GLISTERING_NYLIUM.get()).group("overgrown_bone_block").unlockedBy("has_glistering_nylium", has(RuBlocks.GLISTERING_NYLIUM.get())).unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 9).requires(RuBlocks.OVERGROWN_BONE_BLOCK.get()).group("bone_meal").unlockedBy("has_overgrown_bone_block", has(RuBlocks.OVERGROWN_BONE_BLOCK.get())).save(consumer , RegionsUnexplored.id(getConversionRecipeName(Items.BONE_MEAL, RuBlocks.OVERGROWN_BONE_BLOCK.get())));
    }

    private static ResourceLocation cId(String name) {
        return ResourceLocation.fromNamespaceAndPath("c", name);
    }

    public static Criterion<EnterBlockTrigger.TriggerInstance> insideOf(Block p_125980_) {
        return CriteriaTriggers.ENTER_BLOCK.createCriterion(new EnterBlockTrigger.TriggerInstance(Optional.empty(), Optional.of(p_125980_.builtInRegistryHolder()), Optional.empty()));
    }

    protected static void branchFromLog(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, item, 2).define('#', item2).define('X', Items.STICK).pattern("#X").group("branches").unlockedBy("has_log", has(item2)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(item,item2)));
    }

    protected static void woodFromOtherItem(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item, 3).define('#', item2).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(item2)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(item,item2)));
    }

    protected static void paintedSlab(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(item2)).group("painted_slab").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void paintedStairs(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        stairBuilder(item, Ingredient.of(item2)).group("painted_stairs").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void paintedPlanks(RecipeOutput consumer, ItemLike result, TagKey<Item> dye) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8).define('X', dye).define('#', ItemTags.PLANKS).pattern("###").pattern("#X#").pattern("###").group("painted_planks").unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
    }

    protected static void snowbelle(RecipeOutput consumer, ItemLike result, TagKey<Item> dye) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result).requires(dye).requires(RuTags.SNOWBELLE_ITEM).group("snowbelle").unlockedBy("has_snowbelle", has(RuTags.SNOWBELLE_ITEM)).save(consumer);
    }

    protected static void planksFromOneLog(RecipeOutput p_259712_, ItemLike p_259052_, ItemLike p_259045_, int i) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, p_259052_, i).requires(p_259045_).group("planks").unlockedBy("has_log", has(p_259045_)).save(p_259712_);
    }
    protected static void woodenButton(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        buttonBuilder(item, Ingredient.of(item2)).group("wooden_button").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenSign(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        signBuilder(item, Ingredient.of(item2)).group("wooden_sign").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void hangingSign(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, item, 6).group("hanging_sign").define('#', item2).define('X', Items.CHAIN).pattern("X X").pattern("###").pattern("###").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenBoat(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, item).define('#', item2).pattern("# #").pattern("###").group("boat").unlockedBy("in_water", insideOf(Blocks.WATER)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenDoor(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        doorBuilder(item, Ingredient.of(item2)).group("wooden_door").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenFenceGate(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        fenceGateBuilder(item, Ingredient.of(item2)).group("wooden_fence_gate").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenFence(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        fenceBuilder(item, Ingredient.of(item2)).group("wooden_fence").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenSlab(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(item2)).group("wooden_slab").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenStairs(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        stairBuilder(item, Ingredient.of(item2)).group("wooden_stairs").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void woodenTrapdoor(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, item, 2).define('#', item2).pattern("###").pattern("###").group("wooden_trapdoor").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void pressurePlate(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        if (item == null || item2 == null) return;
        pressurePlateBuilder(RecipeCategory.REDSTONE, item, Ingredient.of(item2)).group("wooden_pressure_plate").unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getItemName(item)));
    }

    protected static void stonecutterResultFromBase(RecipeOutput consumer, RecipeCategory category, ItemLike item, ItemLike item2) {
        stonecutterResultFromBase(consumer, category, item, item2, 1);
    }

    protected static void stonecutterResultFromBase(RecipeOutput consumer, RecipeCategory category, ItemLike item, ItemLike item2, int i) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item2), category, item, i).unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(item, item2) + "_stonecutting"));
    }

    protected static void oreSmelting(RecipeOutput consumer, List<ItemLike> itemLikes, RecipeCategory category, ItemLike item, float f, int i, String s) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, itemLikes, category, item, f, i, s, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput consumer, List<ItemLike> itemLikes, RecipeCategory category, ItemLike item, float f, int i, String s) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, itemLikes, category, item, f, i, s, "_from_blasting");
    }

    public static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput consumer, RecipeSerializer<T> serializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> itemLikes, RecipeCategory category, ItemLike item, float f, int i, String s, String t) {
        for(ItemLike itemlike : itemLikes) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, item, f, i, serializer, factory).group(s).unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, RegionsUnexplored.id(getItemName(item) + t + "_" + getItemName(itemlike)));
        }

    }

    protected static void oneToOneConversionRecipe(RecipeOutput consumer, ItemLike item, ItemLike item2, @Nullable String group) {
        oneToOneConversionRecipe(consumer, item, item2, group, 1);
    }

    protected static void oneToOneConversionRecipe(RecipeOutput consumer, ItemLike item, ItemLike item2, @Nullable String group, int ammount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item, ammount).requires(item2).group(group).unlockedBy(getHasName(item2), has(item2)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(item, item2)));
    }
}