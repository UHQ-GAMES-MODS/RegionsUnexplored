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
import net.minecraft.resources.Identifier;
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
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.registry.RUItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class RuRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final Supplier<ImmutableList<ItemLike>> REDSTONE_SMELTABLES = Suppliers.memoize(() -> ImmutableList.of(RUBlocks.RAW_REDSTONE_BLOCK.get(), RUBlocks.REDSTONE_BULB.get()));
    public static final Supplier<ImmutableList<ItemLike>> MOSSY_STONE_SMELTABLES = Suppliers.memoize(() ->ImmutableList.of(Blocks.MOSSY_COBBLESTONE));

    public RuRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> holder) {
        super(output, holder);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        /*-----------------CAVE_BLOCKS_DONE-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.PRISMOSS.get(), 1).define('#', Blocks.STONE).define('X', RUBlocks.PRISMOSS_SPROUT.get()).pattern("X").pattern("#").group("prismoss").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.DEEPSLATE_PRISMOSS.get(), 1).define('#', Blocks.DEEPSLATE).define('X', RUBlocks.PRISMOSS_SPROUT.get()).pattern("X").pattern("#").group("prismoss").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.HANGING_PRISMARITE.get(), 1).define('#', RUBlocks.PRISMARITE_CLUSTER.get()).pattern("#").pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RUBlocks.PRISMARITE_CLUSTER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.LARGE_PRISMARITE_CLUSTER.get(), 1).define('#', RUBlocks.PRISMARITE_CLUSTER.get()).pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RUBlocks.PRISMARITE_CLUSTER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.PRISMAGLASS.get(), 2).define('#', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "glass"))).define('X', RuTags.PRISMARITE_CRYSTALS_ITEM).pattern(" X ").pattern("X#X").pattern(" X ").group("stained_glass").unlockedBy("has_glass", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "glass")))).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RUBlocks.RAW_REDSTONE_BLOCK.get(), 1).define('#', Items.REDSTONE).pattern("##").pattern("##").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);
        oreSmelting(consumer, REDSTONE_SMELTABLES.get(), RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 200, "redstone");
        oreBlasting(consumer, REDSTONE_SMELTABLES.get(), RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 100, "redstone");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RUBlocks.REDSTONE_BUD.get(), 2).define('#', Items.REDSTONE).pattern("###").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.STONE_GRASS_BLOCK.get(), 1).define('#', Blocks.STONE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.DEEPSLATE_GRASS_BLOCK.get(), 1).define('#', Blocks.DEEPSLATE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.VIRIDESCENT_NYLIUM.get(), 1).define('#', Blocks.STONE).define('X', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "mushrooms")))).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), 1).define('#', Blocks.DEEPSLATE).define('X', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "mushrooms")))).save(consumer);

        /*-----------------PLANTS-----------------*/
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RUBlocks.DEAD_STEPPE_SHRUB.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RUBlocks.SMALL_DESERT_SHRUB.get(), "brown_dye");


        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RUBlocks.ALPHA_DANDELION.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RUBlocks.ALPHA_ROSE.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RUBlocks.BLEEDING_HEART.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RUBlocks.BLUE_LUPINE.get(), "blue_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RUBlocks.DAISY.get(), "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.BLACK_DYE, RUBlocks.DORCEL.get(), "black_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RUBlocks.FELICIA_DAISY.get(), "light_blue_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RUBlocks.FIREWEED.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RUBlocks.GLISTERING_BLOOM.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RUBlocks.HIBISCUS.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RUBlocks.MALLOW.get(), "orange_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RUBlocks.HYSSOP.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RUBlocks.PINK_LUPINE.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RUBlocks.POPPY_BUSH.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RUBlocks.SALMON_POPPY_BUSH.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RUBlocks.PURPLE_LUPINE.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RUBlocks.RED_LUPINE.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RUBlocks.WARATAH.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RUBlocks.WHITE_TRILLIUM.get(), "white_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RUBlocks.WILTING_TRILLIUM.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RUBlocks.YELLOW_LUPINE.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RUBlocks.TSUBAKI.get(), "red_dye");

        //SNOWBELLE
        for (Map.Entry<DyeColor, Block> entry : RUBlocks.SNOWBELLES.getMap().entrySet()) {
            oneToOneConversionRecipe(consumer, DyeItem.byColor(entry.getKey()), entry.getValue(), entry.getKey().getName() + "_dye");
            snowbelle(consumer, entry.getValue(), TagKey.create(Registries.ITEM, cId("dyes/" + entry.getKey().getName())));
        }

        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RUBlocks.ORANGE_CONEFLOWER.get(), "orange_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RUBlocks.PURPLE_CONEFLOWER.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RUBlocks.ASTER.get(), "light_blue_dye");

        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(), "light_blue_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 6).define('#', RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves()).pattern("###").group("multiface_flowers").unlockedBy("has_blue_magnolia_leaves", has(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves())).save(consumer);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), "pink_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), 6).define('#', RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves()).pattern("###").group("multiface_flowers").unlockedBy("has_pink_magnolia_leaves", has(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves())).save(consumer);
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), "white_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 6).define('#', RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves()).pattern("###").group("multiface_flowers").unlockedBy("has_white_magnolia_leaves", has(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves())).save(consumer);

        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RUItems.MEADOW_SAGE.get(), "blue_dye");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RUBlocks.BARLEY.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 200).unlockedBy("has_barley", has(RUBlocks.BARLEY.get())).save(consumer, RegionsUnexplored.id("barley_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(RUBlocks.BARLEY.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 100).unlockedBy("has_barley", has(RUBlocks.BARLEY.get())).save(consumer, RegionsUnexplored.id("barley_smoking"));
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RUBlocks.CATTAIL.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RUBlocks.TASSEL.get(), "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RUBlocks.DAY_LILY.get(), "orange_dye");

        oneToOneConversionRecipe(consumer, RUBlocks.ASHEN_NATURAL_SET.getSapling(), RUBlocks.ASHEN_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.ACACIA_SAPLING, RUBlocks.ACACIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.BIRCH_SAPLING, RUBlocks.BIRCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.BAOBAB_NATURAL_SET.getSapling(), RUBlocks.BAOBAB_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.BLACKWOOD_NATURAL_SET.getSapling(), RUBlocks.BLACKWOOD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.BRIMWOOD_NATURAL_SET.getSapling(), RUBlocks.BRIMWOOD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.CHERRY_SAPLING, RUBlocks.CHERRY_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RUBlocks.SAGUARO_CACTUS_NATURAL_SET.getSapling(), "magenta_dye");
        oneToOneConversionRecipe(consumer, RUBlocks.MAGNOLIA_NATURAL_SET.getSapling(), RUBlocks.MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.CYPRESS_NATURAL_SET.getSapling(), RUBlocks.CYPRESS_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.DARK_OAK_SAPLING, RUBlocks.DARK_OAK_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.DEAD_PINE_NATURAL_SET.getSapling(), RUBlocks.DEAD_PINE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.DEAD_NATURAL_SET.getSapling(), RUBlocks.DEAD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.EUCALYPTUS_NATURAL_SET.getSapling(), RUBlocks.EUCALYPTUS_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.FLOWERING_NATURAL_SET.getSapling(), RUBlocks.FLOWERING_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling(), RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.JOSHUA_NATURAL_SET.getSapling(), RUBlocks.JOSHUA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.KAPOK_NATURAL_SET.getSapling(), RUBlocks.KAPOK_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.JUNGLE_SAPLING, RUBlocks.JUNGLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.LARCH_NATURAL_SET.getSapling(), RUBlocks.LARCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.MANGROVE_PROPAGULE, RUBlocks.MANGROVE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.MAPLE_NATURAL_SET.getSapling(), RUBlocks.MAPLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.MAUVE_NATURAL_SET.getSapling(), RUBlocks.MAUVE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.OAK_SAPLING, RUBlocks.OAK_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling(), RUBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.PALM_NATURAL_SET.getSapling(), RUBlocks.PALM_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.PINE_NATURAL_SET.getSapling(), RUBlocks.PINE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling(), RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling(), RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.REDWOOD_NATURAL_SET.getSapling(), RUBlocks.REDWOOD_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.RED_MAPLE_NATURAL_SET.getSapling(), RUBlocks.RED_MAPLE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling(), RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.SILVER_BIRCH_NATURAL_SET.getSapling(), RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.SOCOTRA_NATURAL_SET.getSapling(), RUBlocks.SOCOTRA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.SPRUCE_SAPLING, RUBlocks.SPRUCE_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling(), RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RUBlocks.WILLOW_NATURAL_SET.getSapling(), RUBlocks.WILLOW_NATURAL_SET.getShrub(), "saplings", 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.ASHEN_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.ASHEN_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_ashen_sapling", has(RUBlocks.ASHEN_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.ACACIA_NATURAL_SET.getShrub(), 1).define('#', Blocks.ACACIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_acacia_sapling", has(Blocks.ACACIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.BAOBAB_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.BAOBAB_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_baobab_sapling", has(RUBlocks.BAOBAB_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.BIRCH_NATURAL_SET.getShrub(), 1).define('#', Blocks.BIRCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_birch_sapling", has(Blocks.BIRCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.BLACKWOOD_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.BLACKWOOD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blackwood_sapling", has(RUBlocks.BLACKWOOD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.BRIMWOOD_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.BRIMWOOD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_brimwood_sapling", has(RUBlocks.BRIMWOOD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.CHERRY_NATURAL_SET.getShrub(), 1).define('#', Blocks.CHERRY_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cherry_sapling", has(Blocks.CHERRY_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_magnolia_sapling", has(RUBlocks.MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.CYPRESS_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.CYPRESS_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cypress_sapling", has(RUBlocks.CYPRESS_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.DARK_OAK_NATURAL_SET.getShrub(), 1).define('#', Blocks.DARK_OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dark_oak_sapling", has(Blocks.DARK_OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.DEAD_PINE_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.DEAD_PINE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_pine_sapling", has(RUBlocks.DEAD_PINE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.DEAD_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.DEAD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_sapling", has(RUBlocks.DEAD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.EUCALYPTUS_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.EUCALYPTUS_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_eucalyptus_sapling", has(RUBlocks.EUCALYPTUS_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.FLOWERING_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.FLOWERING_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_flowering_sapling", has(RUBlocks.FLOWERING_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_golden_larch_sapling", has(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.JOSHUA_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.JOSHUA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_joshua_sapling", has(RUBlocks.JOSHUA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.KAPOK_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.KAPOK_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_kapok_sapling", has(RUBlocks.KAPOK_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.JUNGLE_NATURAL_SET.getShrub(), 1).define('#', Blocks.JUNGLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_jungle_sapling", has(Blocks.JUNGLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.LARCH_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.LARCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_larch_sapling", has(RUBlocks.LARCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.MANGROVE_NATURAL_SET.getShrub(), 1).define('#', Blocks.MANGROVE_PROPAGULE).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mangrove_propagule", has(Blocks.MANGROVE_PROPAGULE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.MAPLE_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.MAPLE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_maple_sapling", has(RUBlocks.MAPLE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.MAUVE_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.MAUVE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mauve_sapling", has(RUBlocks.MAUVE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.OAK_NATURAL_SET.getShrub(), 1).define('#', Blocks.OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_oak_sapling", has(Blocks.OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_orange_maple_sapling", has(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.PALM_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.PALM_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_palm_sapling", has(RUBlocks.PALM_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.PINE_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.PINE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pine_sapling", has(RUBlocks.PINE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blue_magnolia_sapling", has(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pink_magnolia_sapling", has(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.REDWOOD_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.REDWOOD_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_redwood_sapling", has(RUBlocks.REDWOOD_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.RED_MAPLE_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.RED_MAPLE_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_red_maple_sapling", has(RUBlocks.RED_MAPLE_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_enchanted_birch_sapling", has(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.SILVER_BIRCH_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_silver_birch_sapling", has(RUBlocks.SILVER_BIRCH_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.SOCOTRA_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.SOCOTRA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_socotra_sapling", has(RUBlocks.SOCOTRA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.SPRUCE_NATURAL_SET.getShrub(), 1).define('#', Blocks.SPRUCE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_spruce_sapling", has(Blocks.SPRUCE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_white_magnolia_sapling", has(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.WILLOW_NATURAL_SET.getShrub(), 1).define('#', RUBlocks.WILLOW_NATURAL_SET.getSapling()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_willow_sapling", has(RUBlocks.WILLOW_NATURAL_SET.getSapling())).save(consumer);

        oneToOneConversionRecipe(consumer, RUBlocks.BLUE_BIOSHROOM.get(), RUBlocks.TALL_BLUE_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RUBlocks.BLUE_BIOSHROOM.get(), "blue_dye");
        oneToOneConversionRecipe(consumer, RUBlocks.GREEN_BIOSHROOM.get(), RUBlocks.TALL_GREEN_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.LIME_DYE, RUBlocks.GREEN_BIOSHROOM.get(), "lime_dye");
        oneToOneConversionRecipe(consumer, RUBlocks.PINK_BIOSHROOM.get(), RUBlocks.TALL_PINK_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RUBlocks.PINK_BIOSHROOM.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, RUBlocks.YELLOW_BIOSHROOM.get(), RUBlocks.TALL_YELLOW_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RUBlocks.TALL_YELLOW_BIOSHROOM.get(), "yellow_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.TALL_BLUE_BIOSHROOM.get(), 1).define('#', RUBlocks.BLUE_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_blue_bioshroom", has(RUBlocks.BLUE_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.TALL_GREEN_BIOSHROOM.get(), 1).define('#', RUBlocks.GREEN_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_green_bioshroom", has(RUBlocks.GREEN_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.TALL_PINK_BIOSHROOM.get(), 1).define('#', RUBlocks.PINK_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_pink_bioshroom", has(RUBlocks.PINK_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.TALL_YELLOW_BIOSHROOM.get(), 1).define('#', RUBlocks.YELLOW_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_yellow_bioshroom", has(RUBlocks.YELLOW_BIOSHROOM.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.ICE).define('#', RUBlocks.ICICLE.get()).pattern("##").pattern("##").group("ice").unlockedBy("has_icicle", has(RUBlocks.ICICLE.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Blocks.ICE, RUBlocks.ICICLE.get())));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RUBlocks.BARREL_CACTUS.get()), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_barrel_cactus", has(RUBlocks.BARREL_CACTUS.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Items.GREEN_DYE, RUBlocks.BARREL_CACTUS.get())));
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RUBlocks.CAVE_HYSSOP.get(), "orange_dye");

        /*-----------------PLANT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.BLUE_BIOSHROOM_BLOCK.get(), 1).define('#', RUBlocks.BLUE_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom", has(RUBlocks.BLUE_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), 4).define('#', RUBlocks.BLUE_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom_block", has(RUBlocks.BLUE_BIOSHROOM_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.GREEN_BIOSHROOM_BLOCK.get(), 1).define('#', RUBlocks.GREEN_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_green_bioshroom", has(RUBlocks.GREEN_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), 4).define('#', RUBlocks.GREEN_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_green_bioshroom_block", has(RUBlocks.GREEN_BIOSHROOM_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.PINK_BIOSHROOM_BLOCK.get(), 1).define('#', RUBlocks.PINK_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom", has(RUBlocks.PINK_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), 4).define('#', RUBlocks.PINK_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom_block", has(RUBlocks.PINK_BIOSHROOM_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.YELLOW_BIOSHROOM_BLOCK.get(), 1).define('#', RUBlocks.YELLOW_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom", has(RUBlocks.YELLOW_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(), 4).define('#', RUBlocks.YELLOW_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom_block", has(RUBlocks.YELLOW_BIOSHROOM_BLOCK.get())).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RUBlocks.SAGUARO_CACTUS.get()), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_saguaro_cactus", has(RUBlocks.SAGUARO_CACTUS.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Items.GREEN_DYE, RUBlocks.SAGUARO_CACTUS.get())));

        /*-----------------BRANCHES-----------------*/
        branchFromLog(consumer, RUBlocks.ACACIA_NATURAL_SET.getBranch(), Blocks.ACACIA_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.ACACIA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.BAOBAB_NATURAL_SET.getBranch(), RUBlocks.BAOBAB_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.BAOBAB_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.BIRCH_NATURAL_SET.getBranch(), Blocks.BIRCH_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.BIRCH_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.BLACKWOOD_NATURAL_SET.getBranch(), RUBlocks.BLACKWOOD_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.BLACKWOOD_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.MAGNOLIA_NATURAL_SET.getBranch(), RUBlocks.MAGNOLIA_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.MAGNOLIA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.CYPRESS_NATURAL_SET.getBranch(), RUBlocks.CYPRESS_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.CYPRESS_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.CHERRY_NATURAL_SET.getBranch(), Blocks.CHERRY_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.CHERRY_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.DARK_OAK_NATURAL_SET.getBranch(), Blocks.DARK_OAK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.DARK_OAK_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.DEAD_NATURAL_SET.getBranch(), RUBlocks.DEAD_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.DEAD_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch(), RUBlocks.EUCALYPTUS_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.JOSHUA_NATURAL_SET.getBranch(), RUBlocks.JOSHUA_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.JOSHUA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.KAPOK_NATURAL_SET.getBranch(), RUBlocks.KAPOK_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.KAPOK_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.JUNGLE_NATURAL_SET.getBranch(), Blocks.JUNGLE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.JUNGLE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.LARCH_NATURAL_SET.getBranch(), RUBlocks.LARCH_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.LARCH_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.MANGROVE_NATURAL_SET.getBranch(), Blocks.MANGROVE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.MANGROVE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.MAPLE_NATURAL_SET.getBranch(), RUBlocks.MAPLE_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.MAPLE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.MAUVE_NATURAL_SET.getBranch(), RUBlocks.MAUVE_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.MAUVE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.OAK_NATURAL_SET.getBranch(), Blocks.OAK_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.OAK_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.PALM_NATURAL_SET.getBranch(), RUBlocks.PALM_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.PALM_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.PINE_NATURAL_SET.getBranch(), RUBlocks.PINE_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.PINE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.REDWOOD_NATURAL_SET.getBranch(), RUBlocks.REDWOOD_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.REDWOOD_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(), RUBlocks.SILVER_BIRCH_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.SOCOTRA_NATURAL_SET.getBranch(), RUBlocks.SOCOTRA_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.SOCOTRA_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.SPRUCE_NATURAL_SET.getBranch(), Blocks.SPRUCE_LOG);
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.SPRUCE_NATURAL_SET.getBranch(), "stick", 4);

        branchFromLog(consumer, RUBlocks.WILLOW_NATURAL_SET.getBranch(), RUBlocks.WILLOW_WOOD_SET.getLog());
        oneToOneConversionRecipe(consumer, Items.STICK, RUBlocks.WILLOW_NATURAL_SET.getBranch(), "stick", 4);

        /*-----------------DIRT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.PEAT_COARSE_DIRT.get(), 4).define('D', RUBlocks.PEAT_DIRT.get()).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.SILT_COARSE_DIRT.get(), 4).define('D', RUBlocks.SILT_DIRT.get()).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.ASHEN_DIRT.get(), 4).define('D', Blocks.DIRT).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(RUBlocks.ASHEN_DIRT.get(), Blocks.DIRT)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.ASHEN_DIRT.get(), 4).define('D', RUBlocks.PEAT_DIRT.get()).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(RUBlocks.ASHEN_DIRT.get(), RUBlocks.PEAT_DIRT.get())));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.ASHEN_DIRT.get(), 4).define('D', RUBlocks.SILT_DIRT.get()).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, RegionsUnexplored.id(getConversionRecipeName(RUBlocks.ASHEN_DIRT.get(), RUBlocks.SILT_DIRT.get())));

        /*-----------------STONE_BLOCKS-----------------*/

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_SLAB.get(), Ingredient.of(RUBlocks.CHALK.get())).group("chalk").unlockedBy("has_chalk", has(RUBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_SLAB.get(), RUBlocks.CHALK.get(), 2);

        stairBuilder(RUBlocks.CHALK_STAIRS.get(), Ingredient.of(RUBlocks.CHALK.get())).group("chalk").unlockedBy("has_chalk", has(RUBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_STAIRS.get(), RUBlocks.CHALK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_GRASS_BLOCK.get(), 1).define('#', RUBlocks.CHALK.get()).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_chalk", has(RUBlocks.CHALK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICKS.get(), 4).define('#', RUBlocks.POLISHED_CHALK.get()).pattern("##").pattern("##").group("chalk").unlockedBy("has_polished_chalk", has(RUBlocks.POLISHED_CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICKS.get(), RUBlocks.CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICKS.get(), RUBlocks.CHALK_GRASS_BLOCK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICKS.get(), RUBlocks.POLISHED_CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICKS.get(), RUBlocks.CHALK_PILLAR.get());

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICK_SLAB.get(), Ingredient.of(RUBlocks.CHALK_BRICKS.get())).group("chalk").unlockedBy("has_chalk_bricks", has(RUBlocks.CHALK_BRICKS.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICK_SLAB.get(), RUBlocks.CHALK_BRICKS.get(), 2);

        stairBuilder(RUBlocks.CHALK_BRICK_STAIRS.get(), Ingredient.of(RUBlocks.CHALK_BRICKS.get())).group("chalk").unlockedBy("has_chalk_bricks", has(RUBlocks.CHALK_BRICKS.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_BRICK_STAIRS.get(), RUBlocks.CHALK_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_PILLAR.get(), 2).define('#', RUBlocks.CHALK.get()).pattern("#").pattern("#").group("chalk").unlockedBy("has_chalk", has(RUBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_PILLAR.get(), RUBlocks.CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_PILLAR.get(), RUBlocks.CHALK_GRASS_BLOCK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_PILLAR.get(), RUBlocks.POLISHED_CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.CHALK_PILLAR.get(), RUBlocks.CHALK_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK.get(), 4).define('#', RUBlocks.CHALK.get()).pattern("##").pattern("##").group("chalk").unlockedBy("has_chalk", has(RUBlocks.CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK.get(), RUBlocks.CHALK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK.get(), RUBlocks.CHALK_GRASS_BLOCK.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK.get(), RUBlocks.CHALK_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK.get(), RUBlocks.CHALK_PILLAR.get());

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK_SLAB.get(), Ingredient.of(RUBlocks.POLISHED_CHALK.get())).group("chalk").unlockedBy("has_polished_chalk", has(RUBlocks.POLISHED_CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK_SLAB.get(), RUBlocks.POLISHED_CHALK.get(), 2);

        stairBuilder(RUBlocks.POLISHED_CHALK_STAIRS.get(), Ingredient.of(RUBlocks.POLISHED_CHALK.get())).group("chalk").unlockedBy("has_polished_chalk", has(RUBlocks.POLISHED_CHALK.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, RUBlocks.POLISHED_CHALK_STAIRS.get(), RUBlocks.POLISHED_CHALK.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RUBlocks.MOSSY_STONE.get(), 1).requires(Blocks.STONE).requires(Blocks.VINE).group("mossy").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_vine", has(Blocks.VINE)).save(consumer);
        oreSmelting(consumer, MOSSY_STONE_SMELTABLES.get(), RecipeCategory.BUILDING_BLOCKS, RUBlocks.MOSSY_STONE.get(), 0.1F, 200, "mossy");
        oreBlasting(consumer, MOSSY_STONE_SMELTABLES.get(), RecipeCategory.BUILDING_BLOCKS, RUBlocks.MOSSY_STONE.get(), 0.1F, 100, "mossy");

        /*-----------------OCEAN_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RUBlocks.HYACINTH_LAMP.get()).define('#', Items.PRISMARINE_SLAB).define('X', RuTags.HYACINTH_BLOOMS_ITEM).pattern("X").pattern("#").group("hyacinth").unlockedBy("has_prismarine_slab", has(Items.PRISMARINE_SLAB)).unlockedBy("has_hyacinth", has(RuTags.HYACINTH_BLOOMS_ITEM)).save(consumer);

        /*-----------------OTHER_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.ASH.get(), 1).define('#', Items.GUNPOWDER).pattern("##").pattern("##").group("ash").unlockedBy("has_gunpowder", has(Items.GUNPOWDER)).save(consumer);

        /*-----------------WOOD_TYPES-----------------*/
        planksFromLogs(consumer, Blocks.BAMBOO_PLANKS, RuTags.BAMBOO_LOGS_ITEM, 4);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BAMBOO, 1).define('#', RuTags.BAMBOO_LOGS_ITEM).pattern("#").pattern("#").group("bamboo").unlockedBy("has_bamboo_log", has(RuTags.BAMBOO_LOGS_ITEM)).save(consumer);
        //ALPHA_BLOCKS
        woodenFence(consumer, Items.OAK_FENCE, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenDoor(consumer, Items.OAK_DOOR, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenFenceGate(consumer, Items.OAK_FENCE_GATE, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenTrapdoor(consumer, Items.OAK_TRAPDOOR, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        pressurePlate(consumer, Items.OAK_PRESSURE_PLATE, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenButton(consumer, Items.OAK_BUTTON, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenSign(consumer, Items.OAK_SIGN, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        hangingSign(consumer, Items.OAK_HANGING_SIGN, RUBlocks.ALPHA_WOOD_SET.getPlanks());
        woodenBoat(consumer, Items.OAK_BOAT, RUBlocks.ALPHA_WOOD_SET.getPlanks());

        woodFromOtherItem(consumer, RUBlocks.BRIMWOOD_WOOD_SET.getWood(), RUBlocks.BRIMWOOD_WOOD_SET.getLogMagma());

        for (WoodSet set : RUBlocks.WOOD_SETS) {
            if (set.getWood() != null && set.getLog() != null) woodFromLogs(consumer, set.getWood(), set.getLog());
            if (set.getStrippedWood() != null && set.getStrippedLog() != null) woodFromLogs(consumer, set.getStrippedWood(), set.getStrippedLog());
            if (set.getPlanks() != null) planksFromLogs(consumer, set.getPlanks(), RuTags.createItem(RegionsUnexplored.id(set.getPlanks().builtInRegistryHolder().key().identifier().getPath().replace("_planks", "_logs"))), 4);
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
        for (Map.Entry<DyeColor, Block> entry : RUBlocks.PAINTED_PLANKS.getMap().entrySet()) {
            paintedPlanks(consumer, entry.getValue(), TagKey.create(Registries.ITEM, cId("dyes/" + entry.getKey().getName())));
        }
        for (Map.Entry<DyeColor, Block> entry : RUBlocks.PAINTED_STAIRS.getMap().entrySet()) {
            paintedStairs(consumer, entry.getValue(), RUBlocks.PAINTED_PLANKS.getMap().get(entry.getKey()));
        }
        for (Map.Entry<DyeColor, Block> entry : RUBlocks.PAINTED_SLABS.getMap().entrySet()) {
            paintedSlab(consumer, entry.getValue(), RUBlocks.PAINTED_PLANKS.getMap().get(entry.getKey()));
        }

        /*-----------------NETHER_BLOCKS-----------------*/

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RUBlocks.BLACKSTONE_CLUSTER.get(), 2).define('#', Blocks.BLACKSTONE).pattern("##").pattern("##").group("blackstone").unlockedBy("has_blackstone", has(Blocks.BLACKSTONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE, 1).define('#', RUBlocks.BLACKSTONE_CLUSTER.get()).pattern("##").group("blackstone").unlockedBy("has_blackstone_cluster", has(RUBlocks.BLACKSTONE_CLUSTER.get())).save(consumer, RegionsUnexplored.id(getConversionRecipeName(Blocks.BLACKSTONE, RUBlocks.BLACKSTONE_CLUSTER.get())));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RUBlocks.OVERGROWN_BONE_BLOCK.get(), 1).requires(Blocks.BONE_BLOCK).requires(RUBlocks.GLISTERING_NYLIUM.get()).group("overgrown_bone_block").unlockedBy("has_glistering_nylium", has(RUBlocks.GLISTERING_NYLIUM.get())).unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 9).requires(RUBlocks.OVERGROWN_BONE_BLOCK.get()).group("bone_meal").unlockedBy("has_overgrown_bone_block", has(RUBlocks.OVERGROWN_BONE_BLOCK.get())).save(consumer , RegionsUnexplored.id(getConversionRecipeName(Items.BONE_MEAL, RUBlocks.OVERGROWN_BONE_BLOCK.get())));
    }

    private static Identifier cId(String name) {
        return Identifier.fromNamespaceAndPath("c", name);
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