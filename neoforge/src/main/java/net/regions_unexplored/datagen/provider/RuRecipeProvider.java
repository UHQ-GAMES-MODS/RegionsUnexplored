package net.regions_unexplored.datagen.provider;

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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.regions_unexplored.Constants;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.item.RuItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RuRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final ImmutableList<ItemLike> REDSTONE_SMELTABLES = ImmutableList.of(RuBlocks.RAW_REDSTONE_BLOCK, RuBlocks.REDSTONE_BULB);
    public static final ImmutableList<ItemLike> MOSSY_STONE_SMELTABLES = ImmutableList.of(Blocks.MOSSY_COBBLESTONE);

    public RuRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> holder) {
        super(output, holder);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        /*-----------------CAVE_BLOCKS_DONE-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PRISMOSS, 1).define('#', Blocks.STONE).define('X', RuBlocks.PRISMOSS_SPROUT).pattern("X").pattern("#").group("prismoss").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_PRISMOSS, 1).define('#', Blocks.DEEPSLATE).define('X', RuBlocks.PRISMOSS_SPROUT).pattern("X").pattern("#").group("prismoss").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.HANGING_PRISMARITE, 1).define('#', RuBlocks.PRISMARITE_CLUSTER).pattern("#").pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RuBlocks.PRISMARITE_CLUSTER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.LARGE_PRISMARITE_CLUSTER, 1).define('#', RuBlocks.PRISMARITE_CLUSTER).pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RuBlocks.PRISMARITE_CLUSTER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PRISMAGLASS, 2).define('#', TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass"))).define('X', RuTags.PRISMARITE_CRYSTALS_ITEM).pattern(" X ").pattern("X#X").pattern(" X ").group("stained_glass").unlockedBy("has_glass", has(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass")))).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RuBlocks.RAW_REDSTONE_BLOCK, 1).define('#', Items.REDSTONE).pattern("##").pattern("##").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);
        oreSmelting(consumer, REDSTONE_SMELTABLES, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 200, "redstone");
        oreBlasting(consumer, REDSTONE_SMELTABLES, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 100, "redstone");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RuBlocks.REDSTONE_BUD, 2).define('#', Items.REDSTONE).pattern("###").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.STONE_GRASS_BLOCK, 1).define('#', Blocks.STONE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_GRASS_BLOCK, 1).define('#', Blocks.DEEPSLATE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.VIRIDESCENT_NYLIUM, 1).define('#', Blocks.STONE).define('X', TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms")))).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM, 1).define('#', Blocks.DEEPSLATE).define('X', TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms")))).save(consumer);

        /*-----------------PLANTS-----------------*/
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.DEAD_STEPPE_SHRUB, "brown_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.SMALL_DESERT_SHRUB, "brown_dye");


        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.ALPHA_DANDELION, "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.ALPHA_ROSE, "red_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.BLEEDING_HEART, "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_LUPINE, "blue_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.DAISY, "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.BLACK_DYE, RuBlocks.DORCEL, "black_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.FELICIA_DAISY, "light_blue_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.FIREWEED, "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.GLISTERING_BLOOM, "pink_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.HIBISCUS, "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.MALLOW, "orange_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.HYSSOP, "purple_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_LUPINE, "pink_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.POPPY_BUSH, "red_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.SALMON_POPPY_BUSH, "pink_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.PURPLE_LUPINE, "purple_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.RED_LUPINE, "red_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.WARATAH, "red_dye");
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_TRILLIUM, "white_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.WILTING_TRILLIUM, "brown_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.YELLOW_LUPINE, "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.TSUBAKI, "red_dye");

        //SNOWBELLE
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.RED_SNOWBELLE, "red_dye");
        snowbelle(consumer, RuBlocks.RED_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/red")));
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.ORANGE_SNOWBELLE, "orange_dye");
        snowbelle(consumer, RuBlocks.ORANGE_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/orange")));
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.YELLOW_SNOWBELLE, "yellow_dye");
        snowbelle(consumer, RuBlocks.YELLOW_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/yellow")));
        oneToOneConversionRecipe(consumer, Items.LIME_DYE, RuBlocks.LIME_SNOWBELLE, "lime_dye");
        snowbelle(consumer, RuBlocks.LIME_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/lime")));
        oneToOneConversionRecipe(consumer, Items.GREEN_DYE, RuBlocks.GREEN_SNOWBELLE, "green_dye");
        snowbelle(consumer, RuBlocks.GREEN_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/green")));
        oneToOneConversionRecipe(consumer, Items.CYAN_DYE, RuBlocks.CYAN_SNOWBELLE, "cyan_dye");
        snowbelle(consumer, RuBlocks.CYAN_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/cyan")));
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.LIGHT_BLUE_SNOWBELLE, "light_blue_dye");
        snowbelle(consumer, RuBlocks.LIGHT_BLUE_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/light_blue")));
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_SNOWBELLE, "blue_dye");
        snowbelle(consumer, RuBlocks.BLUE_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/blue")));
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.PURPLE_SNOWBELLE, "purple_dye");
        snowbelle(consumer, RuBlocks.PURPLE_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/purple")));
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.MAGENTA_SNOWBELLE, "magenta_dye");
        snowbelle(consumer, RuBlocks.MAGENTA_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/magenta")));
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_SNOWBELLE, "pink_dye");
        snowbelle(consumer, RuBlocks.PINK_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/pink")));
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.BROWN_SNOWBELLE, "brown_dye");
        snowbelle(consumer, RuBlocks.BROWN_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/brown")));
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_SNOWBELLE, "white_dye");
        snowbelle(consumer, RuBlocks.WHITE_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/white")));
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.LIGHT_GRAY_SNOWBELLE, "light_gray_dye");
        snowbelle(consumer, RuBlocks.LIGHT_GRAY_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/light_gray")));
        oneToOneConversionRecipe(consumer, Items.GRAY_DYE, RuBlocks.GRAY_SNOWBELLE, "gray_dye");
        snowbelle(consumer, RuBlocks.GRAY_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/gray")));
        oneToOneConversionRecipe(consumer, Items.BLACK_DYE, RuBlocks.BLACK_SNOWBELLE, "black_dye");
        snowbelle(consumer, RuBlocks.BLACK_SNOWBELLE, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/black")));

        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.ORANGE_CONEFLOWER, "orange_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.PURPLE_CONEFLOWER, "purple_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.ASTER, "light_blue_dye");

        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.BLUE_MAGNOLIA_FLOWERS, "light_blue_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLUE_MAGNOLIA_FLOWERS, 6).define('#', RuBlocks.BLUE_MAGNOLIA_LEAVES).pattern("###").group("multiface_flowers").unlockedBy("has_blue_magnolia_leaves", has(RuBlocks.BLUE_MAGNOLIA_LEAVES)).save(consumer);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_MAGNOLIA_FLOWERS, "pink_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINK_MAGNOLIA_FLOWERS, 6).define('#', RuBlocks.PINK_MAGNOLIA_LEAVES).pattern("###").group("multiface_flowers").unlockedBy("has_pink_magnolia_leaves", has(RuBlocks.PINK_MAGNOLIA_LEAVES)).save(consumer);
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_MAGNOLIA_FLOWERS, "white_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WHITE_MAGNOLIA_FLOWERS, 6).define('#', RuBlocks.WHITE_MAGNOLIA_LEAVES).pattern("###").group("multiface_flowers").unlockedBy("has_white_magnolia_leaves", has(RuBlocks.WHITE_MAGNOLIA_LEAVES)).save(consumer);

        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuItems.MEADOW_SAGE, "blue_dye");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.BARLEY), RecipeCategory.FOOD, Items.BREAD, 0.35F, 200).unlockedBy("has_barley", has(RuBlocks.BARLEY)).save(consumer, new ResourceLocation(Constants.MOD_ID, "barley_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(RuBlocks.BARLEY), RecipeCategory.FOOD, Items.BREAD, 0.35F, 100).unlockedBy("has_barley", has(RuBlocks.BARLEY)).save(consumer, new ResourceLocation(Constants.MOD_ID, "barley_smoking"));
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.CATTAIL, "brown_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.TASSEL, "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.DAY_LILY, "orange_dye");

        oneToOneConversionRecipe(consumer, RuBlocks.ASHEN_SAPLING, RuBlocks.ASHEN_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.ACACIA_SAPLING, RuBlocks.ACACIA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.BIRCH_SAPLING, RuBlocks.BIRCH_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BAOBAB_SAPLING, RuBlocks.BAOBAB_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BLACKWOOD_SAPLING, RuBlocks.BLACKWOOD_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BRIMWOOD_SAPLING, RuBlocks.BRIMWOOD_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.CHERRY_SAPLING, RuBlocks.CHERRY_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.CACTUS_FLOWER, "magenta_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.MAGNOLIA_SAPLING, RuBlocks.MAGNOLIA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.CYPRESS_SAPLING, RuBlocks.CYPRESS_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.DARK_OAK_SAPLING, RuBlocks.DARK_OAK_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.DEAD_PINE_SAPLING, RuBlocks.DEAD_PINE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.DEAD_SAPLING, RuBlocks.DEAD_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.EUCALYPTUS_SAPLING, RuBlocks.EUCALYPTUS_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.FLOWERING_SAPLING, RuBlocks.FLOWERING_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.GOLDEN_LARCH_SAPLING, RuBlocks.GOLDEN_LARCH_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.JOSHUA_SAPLING, RuBlocks.JOSHUA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.KAPOK_SAPLING, RuBlocks.KAPOK_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.JUNGLE_SAPLING, RuBlocks.JUNGLE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.LARCH_SAPLING, RuBlocks.LARCH_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.MANGROVE_PROPAGULE, RuBlocks.MANGROVE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.MAPLE_SAPLING, RuBlocks.MAPLE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.MAUVE_SAPLING, RuBlocks.MAUVE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.OAK_SAPLING, RuBlocks.OAK_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.ORANGE_MAPLE_SAPLING, RuBlocks.ORANGE_MAPLE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PALM_SAPLING, RuBlocks.PALM_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PINE_SAPLING, RuBlocks.PINE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BLUE_MAGNOLIA_SAPLING, RuBlocks.BLUE_MAGNOLIA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PINK_MAGNOLIA_SAPLING, RuBlocks.PINK_MAGNOLIA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.REDWOOD_SAPLING, RuBlocks.REDWOOD_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.RED_MAPLE_SAPLING, RuBlocks.RED_MAPLE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.ENCHANTED_BIRCH_SAPLING, RuBlocks.ENCHANTED_BIRCH_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.SILVER_BIRCH_SAPLING, RuBlocks.SILVER_BIRCH_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.SOCOTRA_SAPLING, RuBlocks.SOCOTRA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.SPRUCE_SAPLING, RuBlocks.SPRUCE_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.WHITE_MAGNOLIA_SAPLING, RuBlocks.WHITE_MAGNOLIA_SHRUB, "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.WILLOW_SAPLING, RuBlocks.WILLOW_SHRUB, "saplings", 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ASHEN_SHRUB, 1).define('#', RuBlocks.ASHEN_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_ashen_sapling", has(RuBlocks.ASHEN_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ACACIA_SHRUB, 1).define('#', Blocks.ACACIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_acacia_sapling", has(Blocks.ACACIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BAOBAB_SHRUB, 1).define('#', RuBlocks.BAOBAB_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_baobab_sapling", has(RuBlocks.BAOBAB_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BIRCH_SHRUB, 1).define('#', Blocks.BIRCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_birch_sapling", has(Blocks.BIRCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLACKWOOD_SHRUB, 1).define('#', RuBlocks.BLACKWOOD_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blackwood_sapling", has(RuBlocks.BLACKWOOD_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BRIMWOOD_SHRUB, 1).define('#', RuBlocks.BRIMWOOD_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_brimwood_sapling", has(RuBlocks.BRIMWOOD_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.CHERRY_SHRUB, 1).define('#', Blocks.CHERRY_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cherry_sapling", has(Blocks.CHERRY_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAGNOLIA_SHRUB, 1).define('#', RuBlocks.MAGNOLIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_magnolia_sapling", has(RuBlocks.MAGNOLIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.CYPRESS_SHRUB, 1).define('#', RuBlocks.CYPRESS_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cypress_sapling", has(RuBlocks.CYPRESS_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DARK_OAK_SHRUB, 1).define('#', Blocks.DARK_OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dark_oak_sapling", has(Blocks.DARK_OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DEAD_PINE_SHRUB, 1).define('#', RuBlocks.DEAD_PINE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_pine_sapling", has(RuBlocks.DEAD_PINE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DEAD_SHRUB, 1).define('#', RuBlocks.DEAD_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_sapling", has(RuBlocks.DEAD_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.EUCALYPTUS_SHRUB, 1).define('#', RuBlocks.EUCALYPTUS_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_eucalyptus_sapling", has(RuBlocks.EUCALYPTUS_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.FLOWERING_SHRUB, 1).define('#', RuBlocks.FLOWERING_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_flowering_sapling", has(RuBlocks.FLOWERING_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.GOLDEN_LARCH_SHRUB, 1).define('#', RuBlocks.GOLDEN_LARCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_golden_larch_sapling", has(RuBlocks.GOLDEN_LARCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.JOSHUA_SHRUB, 1).define('#', RuBlocks.JOSHUA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_joshua_sapling", has(RuBlocks.JOSHUA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.KAPOK_SHRUB, 1).define('#', RuBlocks.KAPOK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_kapok_sapling", has(RuBlocks.KAPOK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.JUNGLE_SHRUB, 1).define('#', Blocks.JUNGLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_jungle_sapling", has(Blocks.JUNGLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.LARCH_SHRUB, 1).define('#', RuBlocks.LARCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_larch_sapling", has(RuBlocks.LARCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MANGROVE_SHRUB, 1).define('#', Blocks.MANGROVE_PROPAGULE).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mangrove_propagule", has(Blocks.MANGROVE_PROPAGULE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAPLE_SHRUB, 1).define('#', RuBlocks.MAPLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_maple_sapling", has(RuBlocks.MAPLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAUVE_SHRUB, 1).define('#', RuBlocks.MAUVE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mauve_sapling", has(RuBlocks.MAUVE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.OAK_SHRUB, 1).define('#', Blocks.OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_oak_sapling", has(Blocks.OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ORANGE_MAPLE_SHRUB, 1).define('#', RuBlocks.ORANGE_MAPLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_orange_maple_sapling", has(RuBlocks.ORANGE_MAPLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PALM_SHRUB, 1).define('#', RuBlocks.PALM_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_palm_sapling", has(RuBlocks.PALM_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINE_SHRUB, 1).define('#', RuBlocks.PINE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pine_sapling", has(RuBlocks.PINE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLUE_MAGNOLIA_SHRUB, 1).define('#', RuBlocks.BLUE_MAGNOLIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blue_magnolia_sapling", has(RuBlocks.BLUE_MAGNOLIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINK_MAGNOLIA_SHRUB, 1).define('#', RuBlocks.PINK_MAGNOLIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pink_magnolia_sapling", has(RuBlocks.PINK_MAGNOLIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.REDWOOD_SHRUB, 1).define('#', RuBlocks.REDWOOD_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_redwood_sapling", has(RuBlocks.REDWOOD_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.RED_MAPLE_SHRUB, 1).define('#', RuBlocks.RED_MAPLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_red_maple_sapling", has(RuBlocks.RED_MAPLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ENCHANTED_BIRCH_SHRUB, 1).define('#', RuBlocks.ENCHANTED_BIRCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_enchanted_birch_sapling", has(RuBlocks.ENCHANTED_BIRCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SILVER_BIRCH_SHRUB, 1).define('#', RuBlocks.SILVER_BIRCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_silver_birch_sapling", has(RuBlocks.SILVER_BIRCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SOCOTRA_SHRUB, 1).define('#', RuBlocks.SOCOTRA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_socotra_sapling", has(RuBlocks.SOCOTRA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SPRUCE_SHRUB, 1).define('#', Blocks.SPRUCE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_spruce_sapling", has(Blocks.SPRUCE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WHITE_MAGNOLIA_SHRUB, 1).define('#', RuBlocks.WHITE_MAGNOLIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_white_magnolia_sapling", has(RuBlocks.WHITE_MAGNOLIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WILLOW_SHRUB, 1).define('#', RuBlocks.WILLOW_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_willow_sapling", has(RuBlocks.WILLOW_SAPLING)).save(consumer);

        oneToOneConversionRecipe(consumer, RuBlocks.BLUE_BIOSHROOM, RuBlocks.TALL_BLUE_BIOSHROOM, "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_BIOSHROOM, "blue_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.GREEN_BIOSHROOM, RuBlocks.TALL_GREEN_BIOSHROOM, "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.LIME_DYE, RuBlocks.GREEN_BIOSHROOM, "lime_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.PINK_BIOSHROOM, RuBlocks.TALL_PINK_BIOSHROOM, "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_BIOSHROOM, "pink_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.YELLOW_BIOSHROOM, RuBlocks.TALL_YELLOW_BIOSHROOM, "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.TALL_YELLOW_BIOSHROOM, "yellow_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_BLUE_BIOSHROOM, 1).define('#', RuBlocks.BLUE_BIOSHROOM).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_blue_bioshroom", has(RuBlocks.BLUE_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_GREEN_BIOSHROOM, 1).define('#', RuBlocks.GREEN_BIOSHROOM).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_green_bioshroom", has(RuBlocks.GREEN_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_PINK_BIOSHROOM, 1).define('#', RuBlocks.PINK_BIOSHROOM).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_pink_bioshroom", has(RuBlocks.PINK_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_YELLOW_BIOSHROOM, 1).define('#', RuBlocks.YELLOW_BIOSHROOM).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_yellow_bioshroom", has(RuBlocks.YELLOW_BIOSHROOM)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.ICE).define('#', RuBlocks.ICICLE).pattern("##").pattern("##").group("ice").unlockedBy("has_icicle", has(RuBlocks.ICICLE)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(Blocks.ICE,RuBlocks.ICICLE)));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.BARREL_CACTUS), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_barrel_cactus", has(RuBlocks.BARREL_CACTUS)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(Items.GREEN_DYE, RuBlocks.BARREL_CACTUS)));
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.CAVE_HYSSOP, "orange_dye");

        /*-----------------PLANT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.BLUE_BIOSHROOM_BLOCK, 1).define('#', RuBlocks.BLUE_BIOSHROOM).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom", has(RuBlocks.BLUE_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK, 4).define('#', RuBlocks.BLUE_BIOSHROOM_BLOCK).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom_block", has(RuBlocks.BLUE_BIOSHROOM_BLOCK)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GREEN_BIOSHROOM_BLOCK, 1).define('#', RuBlocks.GREEN_BIOSHROOM).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_green_bioshroom", has(RuBlocks.GREEN_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK, 4).define('#', RuBlocks.GREEN_BIOSHROOM_BLOCK).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_green_bioshroom_block", has(RuBlocks.GREEN_BIOSHROOM_BLOCK)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PINK_BIOSHROOM_BLOCK, 1).define('#', RuBlocks.PINK_BIOSHROOM).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom", has(RuBlocks.PINK_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK, 4).define('#', RuBlocks.PINK_BIOSHROOM_BLOCK).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom_block", has(RuBlocks.PINK_BIOSHROOM_BLOCK)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.YELLOW_BIOSHROOM_BLOCK, 1).define('#', RuBlocks.YELLOW_BIOSHROOM).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom", has(RuBlocks.YELLOW_BIOSHROOM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK, 4).define('#', RuBlocks.YELLOW_BIOSHROOM_BLOCK).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom_block", has(RuBlocks.YELLOW_BIOSHROOM_BLOCK)).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.SAGUARO_CACTUS), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_saguaro_cactus", has(RuBlocks.SAGUARO_CACTUS)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(Items.GREEN_DYE, RuBlocks.SAGUARO_CACTUS)));

        /*-----------------BRANCHES-----------------*/
        branchFromLog(consumer, RuBlocks.ACACIA_BRANCH, Blocks.ACACIA_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.ACACIA_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.BAOBAB_BRANCH, RuBlocks.BAOBAB_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BAOBAB_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.BIRCH_BRANCH, Blocks.BIRCH_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BIRCH_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.BLACKWOOD_BRANCH, RuBlocks.BLACKWOOD_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BLACKWOOD_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.MAGNOLIA_BRANCH, RuBlocks.MAGNOLIA_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAGNOLIA_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.CYPRESS_BRANCH, RuBlocks.CYPRESS_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.CYPRESS_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.CHERRY_BRANCH, Blocks.CHERRY_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.CHERRY_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.DARK_OAK_BRANCH, Blocks.DARK_OAK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.DARK_OAK_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.DEAD_BRANCH, RuBlocks.DEAD_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.DEAD_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.EUCALYPTUS_BRANCH, RuBlocks.EUCALYPTUS_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.EUCALYPTUS_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.JOSHUA_BEARD, RuBlocks.JOSHUA_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.JOSHUA_BEARD, "stick", 4);

        branchFromLog(consumer, RuBlocks.KAPOK_BRANCH, RuBlocks.KAPOK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.KAPOK_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.JUNGLE_BRANCH, Blocks.JUNGLE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.JUNGLE_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.LARCH_BRANCH, RuBlocks.LARCH_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.LARCH_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.MANGROVE_BRANCH, Blocks.MANGROVE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MANGROVE_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.MAPLE_BRANCH, RuBlocks.MAPLE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAPLE_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.MAUVE_BRANCH, RuBlocks.MAUVE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAUVE_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.OAK_BRANCH, Blocks.OAK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.OAK_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.PALM_BEARD, RuBlocks.PALM_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.PALM_BEARD, "stick", 4);

        branchFromLog(consumer, RuBlocks.PINE_BRANCH, RuBlocks.PINE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.PINE_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.REDWOOD_BRANCH, RuBlocks.REDWOOD_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.REDWOOD_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.SILVER_BIRCH_BRANCH, RuBlocks.SILVER_BIRCH_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SILVER_BIRCH_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.SOCOTRA_BRANCH, RuBlocks.SOCOTRA_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SOCOTRA_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.SPRUCE_BRANCH, Blocks.SPRUCE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SPRUCE_BRANCH, "stick", 4);

        branchFromLog(consumer, RuBlocks.WILLOW_BRANCH, RuBlocks.WILLOW_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.WILLOW_BRANCH, "stick", 4);

        /*-----------------DIRT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PEAT_COARSE_DIRT, 4).define('D', RuBlocks.PEAT_DIRT).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.SILT_COARSE_DIRT, 4).define('D', RuBlocks.SILT_DIRT).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT, 4).define('D', Blocks.DIRT).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(RuBlocks.ASHEN_DIRT, Blocks.DIRT)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT, 4).define('D', RuBlocks.PEAT_DIRT).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(RuBlocks.ASHEN_DIRT, RuBlocks.PEAT_DIRT)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT, 4).define('D', RuBlocks.SILT_DIRT).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(RuBlocks.ASHEN_DIRT, RuBlocks.SILT_DIRT)));

        /*-----------------STONE_BLOCKS-----------------*/

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_SLAB, Ingredient.of(RuBlocks.CHALK)).group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_SLAB, RuBlocks.CHALK, 2);

        stairBuilder(RuBlocks.CHALK_STAIRS, Ingredient.of(RuBlocks.CHALK)).group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_STAIRS, RuBlocks.CHALK);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_GRASS_BLOCK, 1).define('#', RuBlocks.CHALK).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_chalk", has(RuBlocks.CHALK)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS, 4).define('#', RuBlocks.POLISHED_CHALK).pattern("##").pattern("##").group("chalk").unlockedBy("has_polished_chalk", has(RuBlocks.POLISHED_CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS, RuBlocks.CHALK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS, RuBlocks.CHALK_GRASS_BLOCK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS, RuBlocks.POLISHED_CHALK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICKS, RuBlocks.CHALK_PILLAR);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICK_SLAB, Ingredient.of(RuBlocks.CHALK_BRICKS)).group("chalk").unlockedBy("has_chalk_bricks", has(RuBlocks.CHALK_BRICKS)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICK_SLAB, RuBlocks.CHALK_BRICKS, 2);

        stairBuilder(RuBlocks.CHALK_BRICK_STAIRS, Ingredient.of(RuBlocks.CHALK_BRICKS)).group("chalk").unlockedBy("has_chalk_bricks", has(RuBlocks.CHALK_BRICKS)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_BRICK_STAIRS, RuBlocks.CHALK_BRICKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR, 2).define('#', RuBlocks.CHALK).pattern("#").pattern("#").group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR, RuBlocks.CHALK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR, RuBlocks.CHALK_GRASS_BLOCK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR, RuBlocks.POLISHED_CHALK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_PILLAR, RuBlocks.CHALK_BRICKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK, 4).define('#', RuBlocks.CHALK).pattern("##").pattern("##").group("chalk").unlockedBy("has_chalk", has(RuBlocks.CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK, RuBlocks.CHALK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK, RuBlocks.CHALK_GRASS_BLOCK);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK, RuBlocks.CHALK_BRICKS);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK, RuBlocks.CHALK_PILLAR);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK_SLAB, Ingredient.of(RuBlocks.POLISHED_CHALK)).group("chalk").unlockedBy("has_polished_chalk", has(RuBlocks.POLISHED_CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK_SLAB, RuBlocks.POLISHED_CHALK, 2);

        stairBuilder(RuBlocks.POLISHED_CHALK_STAIRS, Ingredient.of(RuBlocks.POLISHED_CHALK)).group("chalk").unlockedBy("has_polished_chalk", has(RuBlocks.POLISHED_CHALK)).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RuBlocks.POLISHED_CHALK_STAIRS, RuBlocks.POLISHED_CHALK);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RuBlocks.MOSSY_STONE, 1).requires(Blocks.STONE).requires(Blocks.VINE).group("mossy").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_vine", has(Blocks.VINE)).save(consumer);
        oreSmelting(consumer, MOSSY_STONE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, RuBlocks.MOSSY_STONE, 0.1F, 200, "mossy");
        oreBlasting(consumer, MOSSY_STONE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, RuBlocks.MOSSY_STONE, 0.1F, 100, "mossy");

        /*-----------------OCEAN_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.HYACINTH_LAMP).define('#', Items.PRISMARINE_SLAB).define('X', RuTags.HYACINTH_BLOOMS_ITEM).pattern("X").pattern("#").group("hyacinth").unlockedBy("has_prismarine_slab", has(Items.PRISMARINE_SLAB)).unlockedBy("has_hyacinth", has(RuTags.HYACINTH_BLOOMS_ITEM)).save(consumer);

        /*-----------------OTHER_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASH, 1).define('#', Items.GUNPOWDER).pattern("##").pattern("##").group("ash").unlockedBy("has_gunpowder", has(Items.GUNPOWDER)).save(consumer);

        /*-----------------WOOD_TYPES-----------------*/
        //planksFromLogs(consumer, Blocks.BAMBOO_PLANKS, RuTags.BAMBOO_LOGS_ITEM, 4);
        //ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO, 1).define('#', RuTags.BAMBOO_LOGS_ITEM).pattern("#").pattern("#").group("bamboo").unlockedBy("has_bamboo_log", has(RuTags.BAMBOO_LOGS_ITEM)).save(consumer);
        //ASHEN_BLOCKS
        woodFromLogs(consumer, RuBlocks.ASHEN_WOOD, RuBlocks.ASHEN_LOG);
        //SILVER_BIRCH_BLOCKS
        woodFromLogs(consumer, RuBlocks.SILVER_BIRCH_WOOD, RuBlocks.SILVER_BIRCH_LOG);
        //ALPHA_BLOCKS
        planksFromOneLog(consumer, RuBlocks.ALPHA_PLANKS, RuBlocks.ALPHA_LOG, 4);
        woodenStairs(consumer, RuBlocks.ALPHA_STAIRS, RuBlocks.ALPHA_PLANKS);
        woodenSlab(consumer, RuBlocks.ALPHA_SLAB, RuBlocks.ALPHA_PLANKS);
        woodenFence(consumer, Items.OAK_FENCE, RuBlocks.ALPHA_PLANKS);
        woodenDoor(consumer, Items.OAK_DOOR, RuBlocks.ALPHA_PLANKS);
        woodenFenceGate(consumer, Items.OAK_FENCE_GATE, RuBlocks.ALPHA_PLANKS);
        woodenTrapdoor(consumer, Items.OAK_TRAPDOOR, RuBlocks.ALPHA_PLANKS);
        pressurePlate(consumer, Items.OAK_PRESSURE_PLATE, RuBlocks.ALPHA_PLANKS);
        woodenButton(consumer, Items.OAK_BUTTON, RuBlocks.ALPHA_PLANKS);
        woodenSign(consumer, Items.OAK_SIGN, RuBlocks.ALPHA_PLANKS);
        hangingSign(consumer, Items.OAK_HANGING_SIGN, RuBlocks.ALPHA_PLANKS);
        woodenBoat(consumer, Items.OAK_BOAT, RuBlocks.ALPHA_PLANKS);
        //BAOBAB_BLOCKS
        woodFromLogs(consumer, RuBlocks.BAOBAB_WOOD, RuBlocks.BAOBAB_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_BAOBAB_WOOD, RuBlocks.STRIPPED_BAOBAB_LOG);
        planksFromLogs(consumer, RuBlocks.BAOBAB_PLANKS, RuTags.BAOBAB_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.BAOBAB_STAIRS, RuBlocks.BAOBAB_PLANKS);
        woodenSlab(consumer, RuBlocks.BAOBAB_SLAB, RuBlocks.BAOBAB_PLANKS);
        woodenFence(consumer, RuBlocks.BAOBAB_FENCE, RuBlocks.BAOBAB_PLANKS);
        woodenDoor(consumer, RuBlocks.BAOBAB_DOOR, RuBlocks.BAOBAB_PLANKS);
        woodenFenceGate(consumer, RuBlocks.BAOBAB_FENCE_GATE, RuBlocks.BAOBAB_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.BAOBAB_TRAPDOOR, RuBlocks.BAOBAB_PLANKS);
        pressurePlate(consumer, RuBlocks.BAOBAB_PRESSURE_PLATE, RuBlocks.BAOBAB_PLANKS);
        woodenButton(consumer, RuBlocks.BAOBAB_BUTTON, RuBlocks.BAOBAB_PLANKS);
        woodenSign(consumer, RuBlocks.BAOBAB_SIGN, RuBlocks.BAOBAB_PLANKS);
        hangingSign(consumer, RuBlocks.BAOBAB_HANGING_SIGN, RuBlocks.STRIPPED_BAOBAB_LOG);
        woodenBoat(consumer, RuItems.BAOBAB_BOAT, RuBlocks.BAOBAB_PLANKS);
        chestBoat(consumer, RuItems.BAOBAB_CHEST_BOAT, RuItems.BAOBAB_BOAT);
        //BRIMWOOD_BLOCKS
        woodFromLogs(consumer, RuBlocks.BRIMWOOD_WOOD, RuBlocks.BRIMWOOD_LOG);
        woodFromOtherItem(consumer, RuBlocks.BRIMWOOD_WOOD, RuBlocks.BRIMWOOD_LOG_MAGMA);
        woodFromLogs(consumer, RuBlocks.STRIPPED_BRIMWOOD_WOOD, RuBlocks.STRIPPED_BRIMWOOD_LOG);
        planksFromLogs(consumer, RuBlocks.BRIMWOOD_PLANKS, RuTags.BRIMWOOD_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.BRIMWOOD_STAIRS, RuBlocks.BRIMWOOD_PLANKS);
        woodenSlab(consumer, RuBlocks.BRIMWOOD_SLAB, RuBlocks.BRIMWOOD_PLANKS);
        woodenFence(consumer, RuBlocks.BRIMWOOD_FENCE, RuBlocks.BRIMWOOD_PLANKS);
        woodenDoor(consumer, RuBlocks.BRIMWOOD_DOOR, RuBlocks.BRIMWOOD_PLANKS);
        woodenFenceGate(consumer, RuBlocks.BRIMWOOD_FENCE_GATE, RuBlocks.BRIMWOOD_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.BRIMWOOD_TRAPDOOR, RuBlocks.BRIMWOOD_PLANKS);
        pressurePlate(consumer, RuBlocks.BRIMWOOD_PRESSURE_PLATE, RuBlocks.BRIMWOOD_PLANKS);
        woodenButton(consumer, RuBlocks.BRIMWOOD_BUTTON, RuBlocks.BRIMWOOD_PLANKS);
        woodenSign(consumer, RuBlocks.BRIMWOOD_SIGN, RuBlocks.BRIMWOOD_PLANKS);
        hangingSign(consumer, RuBlocks.BRIMWOOD_HANGING_SIGN, RuBlocks.STRIPPED_BRIMWOOD_LOG);
        //BLUE_BIOSHROOM_BLOCKS
        woodFromLogs(consumer, RuBlocks.BLUE_BIOSHROOM_HYPHAE, RuBlocks.BLUE_BIOSHROOM_STEM);
        woodFromLogs(consumer, RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM);
        planksFromLogs(consumer, RuBlocks.BLUE_BIOSHROOM_PLANKS, RuTags.BLUE_BIOSHROOM_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.BLUE_BIOSHROOM_STAIRS, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenSlab(consumer, RuBlocks.BLUE_BIOSHROOM_SLAB, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenFence(consumer, RuBlocks.BLUE_BIOSHROOM_FENCE, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenDoor(consumer, RuBlocks.BLUE_BIOSHROOM_DOOR, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenFenceGate(consumer, RuBlocks.BLUE_BIOSHROOM_FENCE_GATE, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.BLUE_BIOSHROOM_TRAPDOOR, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        pressurePlate(consumer, RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenButton(consumer, RuBlocks.BLUE_BIOSHROOM_BUTTON, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        woodenSign(consumer, RuBlocks.BLUE_BIOSHROOM_SIGN, RuBlocks.BLUE_BIOSHROOM_PLANKS);
        hangingSign(consumer, RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN, RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM);
        //BLACKWOOD_BLOCKS
        woodFromLogs(consumer, RuBlocks.BLACKWOOD_WOOD, RuBlocks.BLACKWOOD_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_BLACKWOOD_WOOD, RuBlocks.STRIPPED_BLACKWOOD_LOG);
        planksFromLogs(consumer, RuBlocks.BLACKWOOD_PLANKS, RuTags.BLACKWOOD_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.BLACKWOOD_STAIRS, RuBlocks.BLACKWOOD_PLANKS);
        woodenSlab(consumer, RuBlocks.BLACKWOOD_SLAB, RuBlocks.BLACKWOOD_PLANKS);
        woodenFence(consumer, RuBlocks.BLACKWOOD_FENCE, RuBlocks.BLACKWOOD_PLANKS);
        woodenDoor(consumer, RuBlocks.BLACKWOOD_DOOR, RuBlocks.BLACKWOOD_PLANKS);
        woodenFenceGate(consumer, RuBlocks.BLACKWOOD_FENCE_GATE, RuBlocks.BLACKWOOD_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.BLACKWOOD_TRAPDOOR, RuBlocks.BLACKWOOD_PLANKS);
        pressurePlate(consumer, RuBlocks.BLACKWOOD_PRESSURE_PLATE, RuBlocks.BLACKWOOD_PLANKS);
        woodenButton(consumer, RuBlocks.BLACKWOOD_BUTTON, RuBlocks.BLACKWOOD_PLANKS);
        woodenSign(consumer, RuBlocks.BLACKWOOD_SIGN, RuBlocks.BLACKWOOD_PLANKS);
        hangingSign(consumer, RuBlocks.BLACKWOOD_HANGING_SIGN, RuBlocks.STRIPPED_BLACKWOOD_LOG);
        woodenBoat(consumer, RuItems.BLACKWOOD_BOAT, RuBlocks.BLACKWOOD_PLANKS);
        chestBoat(consumer, RuItems.BLACKWOOD_CHEST_BOAT, RuItems.BLACKWOOD_BOAT);
        //COBALT_BLOCKS
        woodFromLogs(consumer, RuBlocks.COBALT_WOOD, RuBlocks.COBALT_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_COBALT_WOOD, RuBlocks.STRIPPED_COBALT_LOG);
        planksFromLogs(consumer, RuBlocks.COBALT_PLANKS, RuTags.COBALT_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.COBALT_STAIRS, RuBlocks.COBALT_PLANKS);
        woodenSlab(consumer, RuBlocks.COBALT_SLAB, RuBlocks.COBALT_PLANKS);
        woodenFence(consumer, RuBlocks.COBALT_FENCE, RuBlocks.COBALT_PLANKS);
        woodenDoor(consumer, RuBlocks.COBALT_DOOR, RuBlocks.COBALT_PLANKS);
        woodenFenceGate(consumer, RuBlocks.COBALT_FENCE_GATE, RuBlocks.COBALT_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.COBALT_TRAPDOOR, RuBlocks.COBALT_PLANKS);
        pressurePlate(consumer, RuBlocks.COBALT_PRESSURE_PLATE, RuBlocks.COBALT_PLANKS);
        woodenButton(consumer, RuBlocks.COBALT_BUTTON, RuBlocks.COBALT_PLANKS);
        woodenSign(consumer, RuBlocks.COBALT_SIGN, RuBlocks.COBALT_PLANKS);
        hangingSign(consumer, RuBlocks.COBALT_HANGING_SIGN, RuBlocks.STRIPPED_COBALT_LOG);
        //CYPRESS_BLOCKS
        woodFromLogs(consumer, RuBlocks.CYPRESS_WOOD, RuBlocks.CYPRESS_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_CYPRESS_WOOD, RuBlocks.STRIPPED_CYPRESS_LOG);
        planksFromLogs(consumer, RuBlocks.CYPRESS_PLANKS, RuTags.CYPRESS_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.CYPRESS_STAIRS, RuBlocks.CYPRESS_PLANKS);
        woodenSlab(consumer, RuBlocks.CYPRESS_SLAB, RuBlocks.CYPRESS_PLANKS);
        woodenFence(consumer, RuBlocks.CYPRESS_FENCE, RuBlocks.CYPRESS_PLANKS);
        woodenDoor(consumer, RuBlocks.CYPRESS_DOOR, RuBlocks.CYPRESS_PLANKS);
        woodenFenceGate(consumer, RuBlocks.CYPRESS_FENCE_GATE, RuBlocks.CYPRESS_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.CYPRESS_TRAPDOOR, RuBlocks.CYPRESS_PLANKS);
        pressurePlate(consumer, RuBlocks.CYPRESS_PRESSURE_PLATE, RuBlocks.CYPRESS_PLANKS);
        woodenButton(consumer, RuBlocks.CYPRESS_BUTTON, RuBlocks.CYPRESS_PLANKS);
        woodenSign(consumer, RuBlocks.CYPRESS_SIGN, RuBlocks.CYPRESS_PLANKS);
        hangingSign(consumer, RuBlocks.CYPRESS_HANGING_SIGN, RuBlocks.STRIPPED_CYPRESS_LOG);
        woodenBoat(consumer, RuItems.CYPRESS_BOAT, RuBlocks.CYPRESS_PLANKS);
        chestBoat(consumer, RuItems.CYPRESS_CHEST_BOAT, RuItems.CYPRESS_BOAT);
        //DEAD_BLOCKS
        woodFromLogs(consumer, RuBlocks.DEAD_WOOD, RuBlocks.DEAD_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_DEAD_WOOD, RuBlocks.STRIPPED_DEAD_LOG);
        planksFromLogs(consumer, RuBlocks.DEAD_PLANKS, RuTags.DEAD_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.DEAD_STAIRS, RuBlocks.DEAD_PLANKS);
        woodenSlab(consumer, RuBlocks.DEAD_SLAB, RuBlocks.DEAD_PLANKS);
        woodenFence(consumer, RuBlocks.DEAD_FENCE, RuBlocks.DEAD_PLANKS);
        woodenDoor(consumer, RuBlocks.DEAD_DOOR, RuBlocks.DEAD_PLANKS);
        woodenFenceGate(consumer, RuBlocks.DEAD_FENCE_GATE, RuBlocks.DEAD_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.DEAD_TRAPDOOR, RuBlocks.DEAD_PLANKS);
        pressurePlate(consumer, RuBlocks.DEAD_PRESSURE_PLATE, RuBlocks.DEAD_PLANKS);
        woodenButton(consumer, RuBlocks.DEAD_BUTTON, RuBlocks.DEAD_PLANKS);
        woodenSign(consumer, RuBlocks.DEAD_SIGN, RuBlocks.DEAD_PLANKS);
        hangingSign(consumer, RuBlocks.DEAD_HANGING_SIGN, RuBlocks.STRIPPED_DEAD_LOG);
        woodenBoat(consumer, RuItems.DEAD_BOAT, RuBlocks.DEAD_PLANKS);
        chestBoat(consumer, RuItems.DEAD_CHEST_BOAT, RuItems.DEAD_BOAT);
        //EUCALYPTUS_BLOCKS
        woodFromLogs(consumer, RuBlocks.EUCALYPTUS_WOOD, RuBlocks.EUCALYPTUS_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_EUCALYPTUS_WOOD, RuBlocks.STRIPPED_EUCALYPTUS_LOG);
        planksFromLogs(consumer, RuBlocks.EUCALYPTUS_PLANKS, RuTags.EUCALYPTUS_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.EUCALYPTUS_STAIRS, RuBlocks.EUCALYPTUS_PLANKS);
        woodenSlab(consumer, RuBlocks.EUCALYPTUS_SLAB, RuBlocks.EUCALYPTUS_PLANKS);
        woodenFence(consumer, RuBlocks.EUCALYPTUS_FENCE, RuBlocks.EUCALYPTUS_PLANKS);
        woodenDoor(consumer, RuBlocks.EUCALYPTUS_DOOR, RuBlocks.EUCALYPTUS_PLANKS);
        woodenFenceGate(consumer, RuBlocks.EUCALYPTUS_FENCE_GATE, RuBlocks.EUCALYPTUS_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.EUCALYPTUS_TRAPDOOR, RuBlocks.EUCALYPTUS_PLANKS);
        pressurePlate(consumer, RuBlocks.EUCALYPTUS_PRESSURE_PLATE, RuBlocks.EUCALYPTUS_PLANKS);
        woodenButton(consumer, RuBlocks.EUCALYPTUS_BUTTON, RuBlocks.EUCALYPTUS_PLANKS);
        woodenSign(consumer, RuBlocks.EUCALYPTUS_SIGN, RuBlocks.EUCALYPTUS_PLANKS);
        hangingSign(consumer, RuBlocks.EUCALYPTUS_HANGING_SIGN, RuBlocks.STRIPPED_EUCALYPTUS_LOG);
        woodenBoat(consumer, RuItems.EUCALYPTUS_BOAT, RuBlocks.EUCALYPTUS_PLANKS);
        chestBoat(consumer, RuItems.EUCALYPTUS_CHEST_BOAT, RuItems.EUCALYPTUS_BOAT);
        //GREEN_BIOSHROOM_BLOCKS
        woodFromLogs(consumer, RuBlocks.GREEN_BIOSHROOM_HYPHAE, RuBlocks.GREEN_BIOSHROOM_STEM);
        woodFromLogs(consumer, RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM);
        planksFromLogs(consumer, RuBlocks.GREEN_BIOSHROOM_PLANKS, RuTags.GREEN_BIOSHROOM_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.GREEN_BIOSHROOM_STAIRS, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenSlab(consumer, RuBlocks.GREEN_BIOSHROOM_SLAB, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenFence(consumer, RuBlocks.GREEN_BIOSHROOM_FENCE, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenDoor(consumer, RuBlocks.GREEN_BIOSHROOM_DOOR, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenFenceGate(consumer, RuBlocks.GREEN_BIOSHROOM_FENCE_GATE, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.GREEN_BIOSHROOM_TRAPDOOR, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        pressurePlate(consumer, RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenButton(consumer, RuBlocks.GREEN_BIOSHROOM_BUTTON, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        woodenSign(consumer, RuBlocks.GREEN_BIOSHROOM_SIGN, RuBlocks.GREEN_BIOSHROOM_PLANKS);
        hangingSign(consumer, RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN, RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM);
        //JOSHUA_BLOCKS
        woodFromLogs(consumer, RuBlocks.JOSHUA_WOOD, RuBlocks.JOSHUA_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_JOSHUA_WOOD, RuBlocks.STRIPPED_JOSHUA_LOG);
        planksFromLogs(consumer, RuBlocks.JOSHUA_PLANKS, RuTags.JOSHUA_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.JOSHUA_STAIRS, RuBlocks.JOSHUA_PLANKS);
        woodenSlab(consumer, RuBlocks.JOSHUA_SLAB, RuBlocks.JOSHUA_PLANKS);
        woodenFence(consumer, RuBlocks.JOSHUA_FENCE, RuBlocks.JOSHUA_PLANKS);
        woodenDoor(consumer, RuBlocks.JOSHUA_DOOR, RuBlocks.JOSHUA_PLANKS);
        woodenFenceGate(consumer, RuBlocks.JOSHUA_FENCE_GATE, RuBlocks.JOSHUA_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.JOSHUA_TRAPDOOR, RuBlocks.JOSHUA_PLANKS);
        pressurePlate(consumer, RuBlocks.JOSHUA_PRESSURE_PLATE, RuBlocks.JOSHUA_PLANKS);
        woodenButton(consumer, RuBlocks.JOSHUA_BUTTON, RuBlocks.JOSHUA_PLANKS);
        woodenSign(consumer, RuBlocks.JOSHUA_SIGN, RuBlocks.JOSHUA_PLANKS);
        hangingSign(consumer, RuBlocks.JOSHUA_HANGING_SIGN, RuBlocks.STRIPPED_JOSHUA_LOG);
        woodenBoat(consumer, RuItems.JOSHUA_BOAT, RuBlocks.JOSHUA_PLANKS);
        chestBoat(consumer, RuItems.JOSHUA_CHEST_BOAT, RuItems.JOSHUA_BOAT);
        //KAPOK_BLOCKS
        woodFromLogs(consumer, RuBlocks.KAPOK_WOOD, RuBlocks.KAPOK_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_KAPOK_WOOD, RuBlocks.STRIPPED_KAPOK_LOG);
        planksFromLogs(consumer, RuBlocks.KAPOK_PLANKS, RuTags.KAPOK_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.KAPOK_STAIRS, RuBlocks.KAPOK_PLANKS);
        woodenSlab(consumer, RuBlocks.KAPOK_SLAB, RuBlocks.KAPOK_PLANKS);
        woodenFence(consumer, RuBlocks.KAPOK_FENCE, RuBlocks.KAPOK_PLANKS);
        woodenDoor(consumer, RuBlocks.KAPOK_DOOR, RuBlocks.KAPOK_PLANKS);
        woodenFenceGate(consumer, RuBlocks.KAPOK_FENCE_GATE, RuBlocks.KAPOK_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.KAPOK_TRAPDOOR, RuBlocks.KAPOK_PLANKS);
        pressurePlate(consumer, RuBlocks.KAPOK_PRESSURE_PLATE, RuBlocks.KAPOK_PLANKS);
        woodenButton(consumer, RuBlocks.KAPOK_BUTTON, RuBlocks.KAPOK_PLANKS);
        woodenSign(consumer, RuBlocks.KAPOK_SIGN, RuBlocks.KAPOK_PLANKS);
        hangingSign(consumer, RuBlocks.KAPOK_HANGING_SIGN, RuBlocks.STRIPPED_KAPOK_LOG);
        woodenBoat(consumer, RuItems.KAPOK_BOAT, RuBlocks.KAPOK_PLANKS);
        chestBoat(consumer, RuItems.KAPOK_CHEST_BOAT, RuItems.KAPOK_BOAT);
        //LARCH_BLOCKS
        woodFromLogs(consumer, RuBlocks.LARCH_WOOD, RuBlocks.LARCH_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_LARCH_WOOD, RuBlocks.STRIPPED_LARCH_LOG);
        planksFromLogs(consumer, RuBlocks.LARCH_PLANKS, RuTags.LARCH_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.LARCH_STAIRS, RuBlocks.LARCH_PLANKS);
        woodenSlab(consumer, RuBlocks.LARCH_SLAB, RuBlocks.LARCH_PLANKS);
        woodenFence(consumer, RuBlocks.LARCH_FENCE, RuBlocks.LARCH_PLANKS);
        woodenDoor(consumer, RuBlocks.LARCH_DOOR, RuBlocks.LARCH_PLANKS);
        woodenFenceGate(consumer, RuBlocks.LARCH_FENCE_GATE, RuBlocks.LARCH_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.LARCH_TRAPDOOR, RuBlocks.LARCH_PLANKS);
        pressurePlate(consumer, RuBlocks.LARCH_PRESSURE_PLATE, RuBlocks.LARCH_PLANKS);
        woodenButton(consumer, RuBlocks.LARCH_BUTTON, RuBlocks.LARCH_PLANKS);
        woodenSign(consumer, RuBlocks.LARCH_SIGN, RuBlocks.LARCH_PLANKS);
        hangingSign(consumer, RuBlocks.LARCH_HANGING_SIGN, RuBlocks.STRIPPED_LARCH_LOG);
        woodenBoat(consumer, RuItems.LARCH_BOAT, RuBlocks.LARCH_PLANKS);
        chestBoat(consumer, RuItems.LARCH_CHEST_BOAT, RuItems.LARCH_BOAT);
        //MAGNOLIA_BLOCKS
        woodFromLogs(consumer, RuBlocks.MAGNOLIA_WOOD, RuBlocks.MAGNOLIA_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_MAGNOLIA_WOOD, RuBlocks.STRIPPED_MAGNOLIA_LOG);
        planksFromLogs(consumer, RuBlocks.MAGNOLIA_PLANKS, RuTags.MAGNOLIA_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.MAGNOLIA_STAIRS, RuBlocks.MAGNOLIA_PLANKS);
        woodenSlab(consumer, RuBlocks.MAGNOLIA_SLAB, RuBlocks.MAGNOLIA_PLANKS);
        woodenFence(consumer, RuBlocks.MAGNOLIA_FENCE, RuBlocks.MAGNOLIA_PLANKS);
        woodenDoor(consumer, RuBlocks.MAGNOLIA_DOOR, RuBlocks.MAGNOLIA_PLANKS);
        woodenFenceGate(consumer, RuBlocks.MAGNOLIA_FENCE_GATE, RuBlocks.MAGNOLIA_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.MAGNOLIA_TRAPDOOR, RuBlocks.MAGNOLIA_PLANKS);
        pressurePlate(consumer, RuBlocks.MAGNOLIA_PRESSURE_PLATE, RuBlocks.MAGNOLIA_PLANKS);
        woodenButton(consumer, RuBlocks.MAGNOLIA_BUTTON, RuBlocks.MAGNOLIA_PLANKS);
        woodenSign(consumer, RuBlocks.MAGNOLIA_SIGN, RuBlocks.MAGNOLIA_PLANKS);
        hangingSign(consumer, RuBlocks.MAGNOLIA_HANGING_SIGN, RuBlocks.STRIPPED_MAGNOLIA_LOG);
        woodenBoat(consumer, RuItems.MAGNOLIA_BOAT, RuBlocks.MAGNOLIA_PLANKS);
        chestBoat(consumer, RuItems.MAGNOLIA_CHEST_BOAT, RuItems.MAGNOLIA_BOAT);
        //MAPLE_BLOCKS
        woodFromLogs(consumer, RuBlocks.MAPLE_WOOD, RuBlocks.MAPLE_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_MAPLE_WOOD, RuBlocks.STRIPPED_MAPLE_LOG);
        planksFromLogs(consumer, RuBlocks.MAPLE_PLANKS, RuTags.MAPLE_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.MAPLE_STAIRS, RuBlocks.MAPLE_PLANKS);
        woodenSlab(consumer, RuBlocks.MAPLE_SLAB, RuBlocks.MAPLE_PLANKS);
        woodenFence(consumer, RuBlocks.MAPLE_FENCE, RuBlocks.MAPLE_PLANKS);
        woodenDoor(consumer, RuBlocks.MAPLE_DOOR, RuBlocks.MAPLE_PLANKS);
        woodenFenceGate(consumer, RuBlocks.MAPLE_FENCE_GATE, RuBlocks.MAPLE_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.MAPLE_TRAPDOOR, RuBlocks.MAPLE_PLANKS);
        pressurePlate(consumer, RuBlocks.MAPLE_PRESSURE_PLATE, RuBlocks.MAPLE_PLANKS);
        woodenButton(consumer, RuBlocks.MAPLE_BUTTON, RuBlocks.MAPLE_PLANKS);
        woodenSign(consumer, RuBlocks.MAPLE_SIGN, RuBlocks.MAPLE_PLANKS);
        hangingSign(consumer, RuBlocks.MAPLE_HANGING_SIGN, RuBlocks.STRIPPED_MAPLE_LOG);
        woodenBoat(consumer, RuItems.MAPLE_BOAT, RuBlocks.MAPLE_PLANKS);
        chestBoat(consumer, RuItems.MAPLE_CHEST_BOAT, RuItems.MAPLE_BOAT);
        //MAUVE_BLOCKS
        woodFromLogs(consumer, RuBlocks.MAUVE_WOOD, RuBlocks.MAUVE_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_MAUVE_WOOD, RuBlocks.STRIPPED_MAUVE_LOG);
        planksFromLogs(consumer, RuBlocks.MAUVE_PLANKS, RuTags.MAUVE_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.MAUVE_STAIRS, RuBlocks.MAUVE_PLANKS);
        woodenSlab(consumer, RuBlocks.MAUVE_SLAB, RuBlocks.MAUVE_PLANKS);
        woodenFence(consumer, RuBlocks.MAUVE_FENCE, RuBlocks.MAUVE_PLANKS);
        woodenDoor(consumer, RuBlocks.MAUVE_DOOR, RuBlocks.MAUVE_PLANKS);
        woodenFenceGate(consumer, RuBlocks.MAUVE_FENCE_GATE, RuBlocks.MAUVE_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.MAUVE_TRAPDOOR, RuBlocks.MAUVE_PLANKS);
        pressurePlate(consumer, RuBlocks.MAUVE_PRESSURE_PLATE, RuBlocks.MAUVE_PLANKS);
        woodenButton(consumer, RuBlocks.MAUVE_BUTTON, RuBlocks.MAUVE_PLANKS);
        woodenSign(consumer, RuBlocks.MAUVE_SIGN, RuBlocks.MAUVE_PLANKS);
        hangingSign(consumer, RuBlocks.MAUVE_HANGING_SIGN, RuBlocks.STRIPPED_MAUVE_LOG);
        woodenBoat(consumer, RuItems.MAUVE_BOAT, RuBlocks.MAUVE_PLANKS);
        chestBoat(consumer, RuItems.MAUVE_CHEST_BOAT, RuItems.MAUVE_BOAT);
        //PALM_BLOCKS
        woodFromLogs(consumer, RuBlocks.PALM_WOOD, RuBlocks.PALM_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_PALM_WOOD, RuBlocks.STRIPPED_PALM_LOG);
        planksFromLogs(consumer, RuBlocks.PALM_PLANKS, RuTags.PALM_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.PALM_STAIRS, RuBlocks.PALM_PLANKS);
        woodenSlab(consumer, RuBlocks.PALM_SLAB, RuBlocks.PALM_PLANKS);
        woodenFence(consumer, RuBlocks.PALM_FENCE, RuBlocks.PALM_PLANKS);
        woodenDoor(consumer, RuBlocks.PALM_DOOR, RuBlocks.PALM_PLANKS);
        woodenFenceGate(consumer, RuBlocks.PALM_FENCE_GATE, RuBlocks.PALM_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.PALM_TRAPDOOR, RuBlocks.PALM_PLANKS);
        pressurePlate(consumer, RuBlocks.PALM_PRESSURE_PLATE, RuBlocks.PALM_PLANKS);
        woodenButton(consumer, RuBlocks.PALM_BUTTON, RuBlocks.PALM_PLANKS);
        woodenSign(consumer, RuBlocks.PALM_SIGN, RuBlocks.PALM_PLANKS);
        hangingSign(consumer, RuBlocks.PALM_HANGING_SIGN, RuBlocks.STRIPPED_PALM_LOG);
        woodenBoat(consumer, RuItems.PALM_BOAT, RuBlocks.PALM_PLANKS);
        chestBoat(consumer, RuItems.PALM_CHEST_BOAT, RuItems.PALM_BOAT);
        //PINE_BLOCKS
        woodFromLogs(consumer, RuBlocks.PINE_WOOD, RuBlocks.PINE_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_PINE_WOOD, RuBlocks.STRIPPED_PINE_LOG);
        planksFromLogs(consumer, RuBlocks.PINE_PLANKS, RuTags.PINE_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.PINE_STAIRS, RuBlocks.PINE_PLANKS);
        woodenSlab(consumer, RuBlocks.PINE_SLAB, RuBlocks.PINE_PLANKS);
        woodenFence(consumer, RuBlocks.PINE_FENCE, RuBlocks.PINE_PLANKS);
        woodenDoor(consumer, RuBlocks.PINE_DOOR, RuBlocks.PINE_PLANKS);
        woodenFenceGate(consumer, RuBlocks.PINE_FENCE_GATE, RuBlocks.PINE_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.PINE_TRAPDOOR, RuBlocks.PINE_PLANKS);
        pressurePlate(consumer, RuBlocks.PINE_PRESSURE_PLATE, RuBlocks.PINE_PLANKS);
        woodenButton(consumer, RuBlocks.PINE_BUTTON, RuBlocks.PINE_PLANKS);
        woodenSign(consumer, RuBlocks.PINE_SIGN, RuBlocks.PINE_PLANKS);
        hangingSign(consumer, RuBlocks.PINE_HANGING_SIGN, RuBlocks.STRIPPED_PINE_LOG);
        woodenBoat(consumer, RuItems.PINE_BOAT, RuBlocks.PINE_PLANKS);
        chestBoat(consumer, RuItems.PINE_CHEST_BOAT, RuItems.PINE_BOAT);
        //PINK_BIOSHROOM_BLOCKS
        woodFromLogs(consumer, RuBlocks.PINK_BIOSHROOM_HYPHAE, RuBlocks.PINK_BIOSHROOM_STEM);
        woodFromLogs(consumer, RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM);
        planksFromLogs(consumer, RuBlocks.PINK_BIOSHROOM_PLANKS, RuTags.PINK_BIOSHROOM_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.PINK_BIOSHROOM_STAIRS, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenSlab(consumer, RuBlocks.PINK_BIOSHROOM_SLAB, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenFence(consumer, RuBlocks.PINK_BIOSHROOM_FENCE, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenDoor(consumer, RuBlocks.PINK_BIOSHROOM_DOOR, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenFenceGate(consumer, RuBlocks.PINK_BIOSHROOM_FENCE_GATE, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.PINK_BIOSHROOM_TRAPDOOR, RuBlocks.PINK_BIOSHROOM_PLANKS);
        pressurePlate(consumer, RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenButton(consumer, RuBlocks.PINK_BIOSHROOM_BUTTON, RuBlocks.PINK_BIOSHROOM_PLANKS);
        woodenSign(consumer, RuBlocks.PINK_BIOSHROOM_SIGN, RuBlocks.PINK_BIOSHROOM_PLANKS);
        hangingSign(consumer, RuBlocks.PINK_BIOSHROOM_HANGING_SIGN, RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM);
        //REDWOOD_BLOCKS
        woodFromLogs(consumer, RuBlocks.REDWOOD_WOOD, RuBlocks.REDWOOD_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_REDWOOD_WOOD, RuBlocks.STRIPPED_REDWOOD_LOG);
        planksFromLogs(consumer, RuBlocks.REDWOOD_PLANKS, RuTags.REDWOOD_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.REDWOOD_STAIRS, RuBlocks.REDWOOD_PLANKS);
        woodenSlab(consumer, RuBlocks.REDWOOD_SLAB, RuBlocks.REDWOOD_PLANKS);
        woodenFence(consumer, RuBlocks.REDWOOD_FENCE, RuBlocks.REDWOOD_PLANKS);
        woodenDoor(consumer, RuBlocks.REDWOOD_DOOR, RuBlocks.REDWOOD_PLANKS);
        woodenFenceGate(consumer, RuBlocks.REDWOOD_FENCE_GATE, RuBlocks.REDWOOD_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.REDWOOD_TRAPDOOR, RuBlocks.REDWOOD_PLANKS);
        pressurePlate(consumer, RuBlocks.REDWOOD_PRESSURE_PLATE, RuBlocks.REDWOOD_PLANKS);
        woodenButton(consumer, RuBlocks.REDWOOD_BUTTON, RuBlocks.REDWOOD_PLANKS);
        woodenSign(consumer, RuBlocks.REDWOOD_SIGN, RuBlocks.REDWOOD_PLANKS);
        hangingSign(consumer, RuBlocks.REDWOOD_HANGING_SIGN, RuBlocks.STRIPPED_REDWOOD_LOG);
        woodenBoat(consumer, RuItems.REDWOOD_BOAT, RuBlocks.REDWOOD_PLANKS);
        chestBoat(consumer, RuItems.REDWOOD_CHEST_BOAT, RuItems.REDWOOD_BOAT);
        //SOCOTRA_BLOCKS
        woodFromLogs(consumer, RuBlocks.SOCOTRA_WOOD, RuBlocks.SOCOTRA_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_SOCOTRA_WOOD, RuBlocks.STRIPPED_SOCOTRA_LOG);
        planksFromLogs(consumer, RuBlocks.SOCOTRA_PLANKS, RuTags.SOCOTRA_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.SOCOTRA_STAIRS, RuBlocks.SOCOTRA_PLANKS);
        woodenSlab(consumer, RuBlocks.SOCOTRA_SLAB, RuBlocks.SOCOTRA_PLANKS);
        woodenFence(consumer, RuBlocks.SOCOTRA_FENCE, RuBlocks.SOCOTRA_PLANKS);
        woodenDoor(consumer, RuBlocks.SOCOTRA_DOOR, RuBlocks.SOCOTRA_PLANKS);
        woodenFenceGate(consumer, RuBlocks.SOCOTRA_FENCE_GATE, RuBlocks.SOCOTRA_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.SOCOTRA_TRAPDOOR, RuBlocks.SOCOTRA_PLANKS);
        pressurePlate(consumer, RuBlocks.SOCOTRA_PRESSURE_PLATE, RuBlocks.SOCOTRA_PLANKS);
        woodenButton(consumer, RuBlocks.SOCOTRA_BUTTON, RuBlocks.SOCOTRA_PLANKS);
        woodenSign(consumer, RuBlocks.SOCOTRA_SIGN, RuBlocks.SOCOTRA_PLANKS);
        hangingSign(consumer, RuBlocks.SOCOTRA_HANGING_SIGN, RuBlocks.STRIPPED_SOCOTRA_LOG);
        woodenBoat(consumer, RuItems.SOCOTRA_BOAT, RuBlocks.SOCOTRA_PLANKS);
        chestBoat(consumer, RuItems.SOCOTRA_CHEST_BOAT, RuItems.SOCOTRA_BOAT);
        //WILLOW_BLOCKS
        woodFromLogs(consumer, RuBlocks.WILLOW_WOOD, RuBlocks.WILLOW_LOG);
        woodFromLogs(consumer, RuBlocks.STRIPPED_WILLOW_WOOD, RuBlocks.STRIPPED_WILLOW_LOG);
        planksFromLogs(consumer, RuBlocks.WILLOW_PLANKS, RuTags.WILLOW_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.WILLOW_STAIRS, RuBlocks.WILLOW_PLANKS);
        woodenSlab(consumer, RuBlocks.WILLOW_SLAB, RuBlocks.WILLOW_PLANKS);
        woodenFence(consumer, RuBlocks.WILLOW_FENCE, RuBlocks.WILLOW_PLANKS);
        woodenDoor(consumer, RuBlocks.WILLOW_DOOR, RuBlocks.WILLOW_PLANKS);
        woodenFenceGate(consumer, RuBlocks.WILLOW_FENCE_GATE, RuBlocks.WILLOW_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.WILLOW_TRAPDOOR, RuBlocks.WILLOW_PLANKS);
        pressurePlate(consumer, RuBlocks.WILLOW_PRESSURE_PLATE, RuBlocks.WILLOW_PLANKS);
        woodenButton(consumer, RuBlocks.WILLOW_BUTTON, RuBlocks.WILLOW_PLANKS);
        woodenSign(consumer, RuBlocks.WILLOW_SIGN, RuBlocks.WILLOW_PLANKS);
        hangingSign(consumer, RuBlocks.WILLOW_HANGING_SIGN, RuBlocks.STRIPPED_WILLOW_LOG);
        woodenBoat(consumer, RuItems.WILLOW_BOAT, RuBlocks.WILLOW_PLANKS);
        chestBoat(consumer, RuItems.WILLOW_CHEST_BOAT, RuItems.WILLOW_BOAT);
        //YELLOW_BIOSHROOM_BLOCKS
        woodFromLogs(consumer, RuBlocks.YELLOW_BIOSHROOM_HYPHAE, RuBlocks.YELLOW_BIOSHROOM_STEM);
        woodFromLogs(consumer, RuBlocks.STRIPPED_YELLOW_BIOSHROOM_HYPHAE, RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM);
        planksFromLogs(consumer, RuBlocks.YELLOW_BIOSHROOM_PLANKS, RuTags.YELLOW_BIOSHROOM_LOGS_ITEM, 4);
        woodenStairs(consumer, RuBlocks.YELLOW_BIOSHROOM_STAIRS, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenSlab(consumer, RuBlocks.YELLOW_BIOSHROOM_SLAB, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenFence(consumer, RuBlocks.YELLOW_BIOSHROOM_FENCE, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenDoor(consumer, RuBlocks.YELLOW_BIOSHROOM_DOOR, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenFenceGate(consumer, RuBlocks.YELLOW_BIOSHROOM_FENCE_GATE, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenTrapdoor(consumer, RuBlocks.YELLOW_BIOSHROOM_TRAPDOOR, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        pressurePlate(consumer, RuBlocks.YELLOW_BIOSHROOM_PRESSURE_PLATE, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenButton(consumer, RuBlocks.YELLOW_BIOSHROOM_BUTTON, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        woodenSign(consumer, RuBlocks.YELLOW_BIOSHROOM_SIGN, RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        hangingSign(consumer, RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN, RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM);

        /*-----------------PAINTED PLANKS-----------------*/
        paintedPlanks(consumer, RuBlocks.RED_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/red")));
        paintedPlanks(consumer, RuBlocks.ORANGE_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/orange")));
        paintedPlanks(consumer, RuBlocks.YELLOW_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/yellow")));
        paintedPlanks(consumer, RuBlocks.LIME_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/lime")));
        paintedPlanks(consumer, RuBlocks.GREEN_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/green")));
        paintedPlanks(consumer, RuBlocks.CYAN_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/cyan")));
        paintedPlanks(consumer, RuBlocks.LIGHT_BLUE_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/light_blue")));
        paintedPlanks(consumer, RuBlocks.BLUE_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/blue")));
        paintedPlanks(consumer, RuBlocks.PURPLE_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/purple")));
        paintedPlanks(consumer, RuBlocks.MAGENTA_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/magenta")));
        paintedPlanks(consumer, RuBlocks.PINK_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/pink")));
        paintedPlanks(consumer, RuBlocks.BROWN_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/brown")));
        paintedPlanks(consumer, RuBlocks.WHITE_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/white")));
        paintedPlanks(consumer, RuBlocks.LIGHT_GRAY_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/light_gray")));
        paintedPlanks(consumer, RuBlocks.GRAY_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/gray")));
        paintedPlanks(consumer, RuBlocks.BLACK_PAINTED_PLANKS, TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes/black")));
        //STAIRS
        paintedStairs(consumer, RuBlocks.RED_PAINTED_STAIRS, RuBlocks.RED_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.ORANGE_PAINTED_STAIRS, RuBlocks.ORANGE_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.YELLOW_PAINTED_STAIRS, RuBlocks.YELLOW_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.LIME_PAINTED_STAIRS, RuBlocks.LIME_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.GREEN_PAINTED_STAIRS, RuBlocks.GREEN_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.CYAN_PAINTED_STAIRS, RuBlocks.CYAN_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.LIGHT_BLUE_PAINTED_STAIRS, RuBlocks.LIGHT_BLUE_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.BLUE_PAINTED_STAIRS, RuBlocks.BLUE_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.PURPLE_PAINTED_STAIRS, RuBlocks.PURPLE_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.MAGENTA_PAINTED_STAIRS, RuBlocks.MAGENTA_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.PINK_PAINTED_STAIRS, RuBlocks.PINK_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.BROWN_PAINTED_STAIRS, RuBlocks.BROWN_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.WHITE_PAINTED_STAIRS, RuBlocks.WHITE_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.LIGHT_GRAY_PAINTED_STAIRS, RuBlocks.LIGHT_GRAY_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.GRAY_PAINTED_STAIRS, RuBlocks.GRAY_PAINTED_PLANKS);
        paintedStairs(consumer, RuBlocks.BLACK_PAINTED_STAIRS, RuBlocks.BLACK_PAINTED_PLANKS);
        //SLABS
        paintedSlab(consumer, RuBlocks.RED_PAINTED_SLAB, RuBlocks.RED_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.ORANGE_PAINTED_SLAB, RuBlocks.ORANGE_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.YELLOW_PAINTED_SLAB, RuBlocks.YELLOW_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.LIME_PAINTED_SLAB, RuBlocks.LIME_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.GREEN_PAINTED_SLAB, RuBlocks.GREEN_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.CYAN_PAINTED_SLAB, RuBlocks.CYAN_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.LIGHT_BLUE_PAINTED_SLAB, RuBlocks.LIGHT_BLUE_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.BLUE_PAINTED_SLAB, RuBlocks.BLUE_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.PURPLE_PAINTED_SLAB, RuBlocks.PURPLE_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.MAGENTA_PAINTED_SLAB, RuBlocks.MAGENTA_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.PINK_PAINTED_SLAB, RuBlocks.PINK_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.BROWN_PAINTED_SLAB, RuBlocks.BROWN_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.WHITE_PAINTED_SLAB, RuBlocks.WHITE_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.LIGHT_GRAY_PAINTED_SLAB, RuBlocks.LIGHT_GRAY_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.GRAY_PAINTED_SLAB, RuBlocks.GRAY_PAINTED_PLANKS);
        paintedSlab(consumer, RuBlocks.BLACK_PAINTED_SLAB, RuBlocks.BLACK_PAINTED_PLANKS);

        /*-----------------NETHER_BLOCKS-----------------*/

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.BLACKSTONE_CLUSTER, 2).define('#', Blocks.BLACKSTONE).pattern("##").pattern("##").group("blackstone").unlockedBy("has_blackstone", has(Blocks.BLACKSTONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE, 1).define('#', RuBlocks.BLACKSTONE_CLUSTER).pattern("##").group("blackstone").unlockedBy("has_blackstone_cluster", has(RuBlocks.BLACKSTONE_CLUSTER)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(Blocks.BLACKSTONE,RuBlocks.BLACKSTONE_CLUSTER)));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RuBlocks.OVERGROWN_BONE_BLOCK, 1).requires(Blocks.BONE_BLOCK).requires(RuBlocks.GLISTERING_NYLIUM).group("overgrown_bone_block").unlockedBy("has_glistering_nylium", has(RuBlocks.GLISTERING_NYLIUM)).unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 9).requires(RuBlocks.OVERGROWN_BONE_BLOCK).group("bone_meal").unlockedBy("has_overgrown_bone_block", has(RuBlocks.OVERGROWN_BONE_BLOCK)).save(consumer , new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(Items.BONE_MEAL, RuBlocks.OVERGROWN_BONE_BLOCK)));
    }

    public static Criterion<EnterBlockTrigger.TriggerInstance> insideOf(Block p_125980_) {
        return CriteriaTriggers.ENTER_BLOCK.createCriterion(new EnterBlockTrigger.TriggerInstance(Optional.empty(), Optional.of(p_125980_.builtInRegistryHolder()), Optional.empty()));
    }

    protected static void branchFromLog(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, item, 2).define('#', item2).define('X', Items.STICK).pattern("#X").group("branches").unlockedBy("has_log", has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(item,item2)));
    }

    protected static void woodFromOtherItem(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item, 3).define('#', item2).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(item,item2)));
    }
    
    protected static void paintedSlab(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(item2)).group("painted_slab").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void paintedStairs(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        stairBuilder(item, Ingredient.of(item2)).group("painted_stairs").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
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
        buttonBuilder(item, Ingredient.of(item2)).group("wooden_button").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenSign(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        signBuilder(item, Ingredient.of(item2)).group("wooden_sign").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void hangingSign(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, item, 6).group("hanging_sign").define('#', item2).define('X', Items.CHAIN).pattern("X X").pattern("###").pattern("###").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenBoat(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, item).define('#', item2).pattern("# #").pattern("###").group("boat").unlockedBy("in_water", insideOf(Blocks.WATER)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenDoor(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        doorBuilder(item, Ingredient.of(item2)).group("wooden_door").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenFenceGate(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        fenceGateBuilder(item, Ingredient.of(item2)).group("wooden_fence_gate").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenFence(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        fenceBuilder(item, Ingredient.of(item2)).group("wooden_fence").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenSlab(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, Ingredient.of(item2)).group("wooden_slab").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenStairs(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        stairBuilder(item, Ingredient.of(item2)).group("wooden_stairs").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void woodenTrapdoor(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, item, 2).define('#', item2).pattern("###").pattern("###").group("wooden_trapdoor").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void pressurePlate(RecipeOutput consumer, ItemLike item, ItemLike item2) {
        pressurePlateBuilder(RecipeCategory.REDSTONE, item, Ingredient.of(item2)).group("wooden_pressure_plate").unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item)));
    }

    protected static void stonecutterResultFromBase(RecipeOutput consumer, RecipeCategory category, ItemLike item, ItemLike item2) {
        stonecutterResultFromBase(consumer, category, item, item2, 1);
    }

    protected static void stonecutterResultFromBase(RecipeOutput consumer, RecipeCategory category, ItemLike item, ItemLike item2, int i) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item2), category, item, i).unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(item, item2) + "_stonecutting"));
    }

    protected static void oreSmelting(RecipeOutput consumer, List<ItemLike> itemLikes, RecipeCategory category, ItemLike item, float f, int i, String s) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, itemLikes, category, item, f, i, s, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput consumer, List<ItemLike> itemLikes, RecipeCategory category, ItemLike item, float f, int i, String s) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, itemLikes, category, item, f, i, s, "_from_blasting");
    }

    public static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput consumer, RecipeSerializer<T> serializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> itemLikes, RecipeCategory category, ItemLike item, float f, int i, String s, String t) {
        for(ItemLike itemlike : itemLikes) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, item, f, i, serializer, factory).group(s).unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, new ResourceLocation(Constants.MOD_ID, getItemName(item) + t + "_" + getItemName(itemlike)));
        }

    }

    protected static void oneToOneConversionRecipe(RecipeOutput consumer, ItemLike item, ItemLike item2, @Nullable String group) {
        oneToOneConversionRecipe(consumer, item, item2, group, 1);
    }

    protected static void oneToOneConversionRecipe(RecipeOutput consumer, ItemLike item, ItemLike item2, @Nullable String group, int ammount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item, ammount).requires(item2).group(group).unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(Constants.MOD_ID, getConversionRecipeName(item, item2)));
    }
}
