package net.regions_unexplored.datagen;

import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemEnchantmentsPredicate;
import net.minecraft.advancements.critereon.ItemSubPredicates;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.world.level.block.plant.food.SalmonBerryBushBlock;

import java.util.List;
import java.util.Set;

public class RuBlockLootTables extends BlockLootSubProvider {

    private final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    protected static final float[] ASPEN_LEAVES_SAPLING_CHANCES = new float[]{0.0725F, 0.0785F, 0.0875F, 0.125F};
    protected static final float[] COBALT_LEAVES_SAPLING_CHANCES = new float[]{0.083F, 0.095F, 0.105F, 0.13F};
    protected static final float[] FLOWERING_OAK_LEAVES_SAPLING_CHANCES = new float[]{0.08F, 0.091F, 0.1F, 0.12F};
    protected static final float[] JOSHUA_LEAVES_SAPLING_CHANCES = new float[]{0.13F, 0.15F, 0.17F, 0.185F};
    protected static final float[] PALM_LEAVES_SAPLING_CHANCES = new float[]{0.1F, 0.125F, 0.14F, 0.155F};
    protected static final float[] SMALL_OAK_LEAVES_SAPLING_CHANCES = new float[]{0.075F, 0.08F, 0.089F, 0.1275F};

    public RuBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {


        /*-----------------CAVE_BLOCKS-----------------*/
        //PRISMA_BLOCKS
        add(RuBlocks.PRISMOSS, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RuBlocks.DEEPSLATE_PRISMOSS, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));
        dropSelf(RuBlocks.HANGING_PRISMARITE);
        add(RuBlocks.LARGE_PRISMARITE_CLUSTER, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PRISMAGLASS, (block) -> createSilkTouchOnlyTable(block));
        dropSelf(RuBlocks.PRISMARITE_CLUSTER);
        add(RuBlocks.PRISMOSS_SPROUT, (block) -> createShearsOnlyDrop(block));
        //REDSTONE_BLOCKS
        dropSelf(RuBlocks.POINTED_REDSTONE);
        dropSelf(RuBlocks.RAW_REDSTONE_BLOCK);
        add(RuBlocks.REDSTONE_BUD, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));
        dropSelf(RuBlocks.REDSTONE_BULB);
        //OTHER_CAVE_BLOCKS
        add(RuBlocks.ARGILLITE_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.ARGILLITE));
        add(RuBlocks.STONE_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RuBlocks.DEEPSLATE_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));
        add(RuBlocks.VIRIDESCENT_NYLIUM, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));

        add(RuBlocks.CORPSE_FLOWER, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLADED_GRASS, (block) -> createGrassDrops(block));
        add(RuBlocks.BLADED_TALL_GRASS, (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.BLADED_GRASS));
        add(RuBlocks.DROPLEAF, (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.DROPLEAF_PLANT, (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.DUSKMELON, (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.DUSKMELON).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.DUSKMELON_SLICE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.DUSKMELON).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.DUSKMELON_SLICE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.FORTUNE)))));
        add(RuBlocks.DUSKTRAP, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        dropSelf(RuBlocks.DEAD_STEPPE_SHRUB);
        add(RuBlocks.ASHEN_GRASS, (block) -> createGrassDrops(block));
        add(RuBlocks.FROZEN_GRASS, (block) -> createGrassDrops(block));
        add(RuBlocks.MEDIUM_GRASS, (block) -> createGrassDrops(block));
        add(RuBlocks.SANDY_GRASS, (block) -> createGrassDrops(block));
        add(RuBlocks.SMALL_DESERT_SHRUB, (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.STEPPE_GRASS, (block) -> createGrassDrops(block));
        add(RuBlocks.STEPPE_SHRUB, (block) -> createGrassDrops(block));
        add(RuBlocks.STONE_BUD, (block) -> createGrassDrops(block));
        //TALL_GRASS_BLOCKS
        add(RuBlocks.ELEPHANT_EAR, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SANDY_TALL_GRASS, (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.SANDY_GRASS));
        add(RuBlocks.STEPPE_TALL_GRASS, (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.STEPPE_GRASS));
        add(RuBlocks.WINDSWEPT_GRASS, (block) -> createDoublePlantWithSeedDropsNoGrass(block));
        //FLOWERS
        dropSelf(RuBlocks.ALPHA_DANDELION);
        dropSelf(RuBlocks.ALPHA_ROSE);
        dropSelf(RuBlocks.ASTER);
        dropSelf(RuBlocks.BLEEDING_HEART);
        dropSelf(RuBlocks.BLUE_LUPINE);
        dropSelf(RuBlocks.DAISY);
        dropSelf(RuBlocks.DORCEL);
        dropSelf(RuBlocks.FELICIA_DAISY);
        dropSelf(RuBlocks.FIREWEED);
        dropSelf(RuBlocks.HIBISCUS);
        dropSelf(RuBlocks.HYSSOP);
        dropSelf(RuBlocks.MALLOW);
        dropSelf(RuBlocks.PINK_LUPINE);
        dropSelf(RuBlocks.POPPY_BUSH);
        dropSelf(RuBlocks.SALMON_POPPY_BUSH);
        dropSelf(RuBlocks.PURPLE_LUPINE);
        dropSelf(RuBlocks.RED_LUPINE);
        dropSelf(RuBlocks.TSUBAKI);
        dropSelf(RuBlocks.WARATAH);
        dropSelf(RuBlocks.WHITE_TRILLIUM);
        dropSelf(RuBlocks.WILTING_TRILLIUM);
        dropSelf(RuBlocks.YELLOW_LUPINE);

        add(RuBlocks.ORANGE_CONEFLOWER, (block) -> createPetalsDrops(block));
        add(RuBlocks.PURPLE_CONEFLOWER, (block) -> createPetalsDrops(block));
        add(RuBlocks.CLOVER, (block) -> createPetalsDrops(block));

        add(RuBlocks.BLUE_MAGNOLIA_FLOWERS, (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.PINK_MAGNOLIA_FLOWERS, (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.WHITE_MAGNOLIA_FLOWERS, (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        //SNOWBELLE
        dropSelf(RuBlocks.RED_SNOWBELLE);
        dropSelf(RuBlocks.ORANGE_SNOWBELLE);
        dropSelf(RuBlocks.YELLOW_SNOWBELLE);
        dropSelf(RuBlocks.LIME_SNOWBELLE);
        dropSelf(RuBlocks.GREEN_SNOWBELLE);
        dropSelf(RuBlocks.CYAN_SNOWBELLE);
        dropSelf(RuBlocks.LIGHT_BLUE_SNOWBELLE);
        dropSelf(RuBlocks.BLUE_SNOWBELLE);
        dropSelf(RuBlocks.PURPLE_SNOWBELLE);
        dropSelf(RuBlocks.MAGENTA_SNOWBELLE);
        dropSelf(RuBlocks.PINK_SNOWBELLE);
        dropSelf(RuBlocks.BROWN_SNOWBELLE);
        dropSelf(RuBlocks.WHITE_SNOWBELLE);
        dropSelf(RuBlocks.LIGHT_GRAY_SNOWBELLE);
        dropSelf(RuBlocks.GRAY_SNOWBELLE);
        dropSelf(RuBlocks.BLACK_SNOWBELLE);

        add(RuBlocks.MAPLE_LEAF_PILE, (block) -> createPetalsDrops(block));
        add(RuBlocks.RED_MAPLE_LEAF_PILE, (block) -> createPetalsDrops(block));
        add(RuBlocks.ORANGE_MAPLE_LEAF_PILE, (block) -> createPetalsDrops(block));
        add(RuBlocks.SILVER_BIRCH_LEAF_PILE, (block) -> createPetalsDrops(block));
        add(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE, (block) -> createPetalsDrops(block));
        //TALL_PLANTS
        add(RuBlocks.MEADOW_SAGE, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BARLEY, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CATTAIL, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TASSEL, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DAY_LILY, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //SAPLINGS
        dropSelf(RuBlocks.ASHEN_SAPLING);
        dropSelf(RuBlocks.ALPHA_SAPLING);
        dropSelf(RuBlocks.APPLE_OAK_SAPLING);
        dropSelf(RuBlocks.BAMBOO_SAPLING);
        dropSelf(RuBlocks.BAOBAB_SAPLING);
        dropSelf(RuBlocks.BLACKWOOD_SAPLING);
        dropSelf(RuBlocks.CACTUS_FLOWER);
        dropSelf(RuBlocks.COBALT_SAPLING);
        dropSelf(RuBlocks.MAGNOLIA_SAPLING);
        dropSelf(RuBlocks.CYPRESS_SAPLING);
        dropSelf(RuBlocks.DEAD_PINE_SAPLING);
        dropSelf(RuBlocks.DEAD_SAPLING);
        dropSelf(RuBlocks.EUCALYPTUS_SAPLING);
        dropSelf(RuBlocks.FLOWERING_SAPLING);
        dropSelf(RuBlocks.GOLDEN_LARCH_SAPLING);
        dropSelf(RuBlocks.JOSHUA_SAPLING);
        dropSelf(RuBlocks.KAPOK_SAPLING);
        dropSelf(RuBlocks.LARCH_SAPLING);
        dropSelf(RuBlocks.MAPLE_SAPLING);
        dropSelf(RuBlocks.MAUVE_SAPLING);
        dropSelf(RuBlocks.ORANGE_MAPLE_SAPLING);
        dropSelf(RuBlocks.PALM_SAPLING);
        dropSelf(RuBlocks.PINE_SAPLING);
        dropSelf(RuBlocks.BLUE_MAGNOLIA_SAPLING);
        dropSelf(RuBlocks.PINK_MAGNOLIA_SAPLING);
        dropSelf(RuBlocks.REDWOOD_SAPLING);
        dropSelf(RuBlocks.RED_MAPLE_SAPLING);
        dropSelf(RuBlocks.BRIMWOOD_SAPLING);
        dropSelf(RuBlocks.ENCHANTED_BIRCH_SAPLING);
        dropSelf(RuBlocks.SILVER_BIRCH_SAPLING);
        dropSelf(RuBlocks.SMALL_OAK_SAPLING);
        dropSelf(RuBlocks.SOCOTRA_SAPLING);
        dropSelf(RuBlocks.WHITE_MAGNOLIA_SAPLING);
        dropSelf(RuBlocks.WILLOW_SAPLING);
        //SHRUBS
        add(RuBlocks.ASHEN_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ACACIA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BAOBAB_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BIRCH_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLACKWOOD_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BRIMWOOD_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAGNOLIA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CHERRY_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CYPRESS_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DARK_OAK_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_PINE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.EUCALYPTUS_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.FLOWERING_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GOLDEN_LARCH_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JOSHUA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JUNGLE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.KAPOK_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.LARCH_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MANGROVE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAPLE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAUVE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.OAK_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ORANGE_MAPLE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PALM_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLUE_MAGNOLIA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINK_MAGNOLIA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.REDWOOD_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.RED_MAPLE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ENCHANTED_BIRCH_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SILVER_BIRCH_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SOCOTRA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SPRUCE_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WHITE_MAGNOLIA_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WILLOW_SHRUB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MUSHROOMS
        dropSelf(RuBlocks.BLUE_BIOSHROOM);
        dropSelf(RuBlocks.GREEN_BIOSHROOM);
        dropSelf(RuBlocks.PINK_BIOSHROOM);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM);
        add(RuBlocks.TALL_BLUE_BIOSHROOM, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_GREEN_BIOSHROOM, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_PINK_BIOSHROOM, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_YELLOW_BIOSHROOM, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //OTHER_PLANT_BLOCKS
        add(RuBlocks.ICICLE, (block) -> createSilkTouchOnlyTable(block));
        dropSelf(RuBlocks.BARREL_CACTUS);
        dropSelf(RuBlocks.CAVE_HYSSOP);
        dropSelf(RuBlocks.DUCKWEED);
        add(RuBlocks.SPANISH_MOSS, (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.SPANISH_MOSS_PLANT, (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.KAPOK_VINES, (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.KAPOK_VINES_PLANT, (block) -> createShearsOnlyDrop(block));
        dropSelf(RuBlocks.FLOWERING_LILY_PAD);
        add(RuBlocks.GIANT_LILY_PAD, (block) -> createSingleItemTable(RuBlocks.FLOWERING_LILY_PAD));
        //FOOD_PLANT_BLOCKS
        add(RuBlocks.SALMONBERRY_BUSH, (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.SALMONBERRY)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.SALMONBERRY)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.FORTUNE)))));

        /*-----------------POTTED_PLANTS-----------------*/
        add(RuBlocks.POTTED_ALPHA_DANDELION, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ALPHA_ROSE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ASTER, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLEEDING_HEART, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DAISY, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FELICIA_DAISY, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DORCEL, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FIREWEED, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GLISTERING_BLOOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_HIBISCUS, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_HYSSOP, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MALLOW, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_POPPY_BUSH, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SALMON_POPPY_BUSH, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TSUBAKI, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WARATAH, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_TRILLIUM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WILTING_TRILLIUM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_LUPINE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_LUPINE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_LUPINE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_LUPINE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_LUPINE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_CONEFLOWER, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_CONEFLOWER, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LIGHT_GRAY_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GRAY_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LIME_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GREEN_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CYAN_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LIGHT_BLUE_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAGENTA_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BROWN_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLACK_SNOWBELLE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DAY_LILY, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MEADOW_SAGE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CAVE_HYSSOP, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BARREL_CACTUS, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DUSKTRAP, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CORPSE_FLOWER, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_COBALT_EARLIGHT, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_COBALT_EARLIGHT, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MYCOTOXIC_DAISY, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GLISTER_SPIRE, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GREEN_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_BLUE_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_GREEN_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_PINK_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_YELLOW_BIOSHROOM, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ASHEN_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ALPHA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_APPLE_OAK_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BAMBOO_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BAOBAB_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLACKWOOD_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BRIMWOOD_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_COBALT_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CACTUS_FLOWER, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAGNOLIA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CYPRESS_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DEAD_PINE_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DEAD_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_EUCALYPTUS_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FLOWERING_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GOLDEN_LARCH_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_JOSHUA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_KAPOK_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LARCH_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAPLE_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAUVE_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_MAPLE_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PALM_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINE_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_MAGNOLIA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_MAGNOLIA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_REDWOOD_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_MAPLE_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ENCHANTED_BIRCH_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SILVER_BIRCH_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SMALL_OAK_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SOCOTRA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_MAGNOLIA_SAPLING, (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WILLOW_SAPLING, (block) -> createPotFlowerItemTable(block));

        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        add(RuBlocks.BLUE_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.BLUE_BIOSHROOM));
        add(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.BLUE_BIOSHROOM));
        add(RuBlocks.GREEN_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.GREEN_BIOSHROOM));
        add(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.GREEN_BIOSHROOM));
        add(RuBlocks.PINK_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.PINK_BIOSHROOM));
        add(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.PINK_BIOSHROOM));
        add(RuBlocks.YELLOW_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.YELLOW_BIOSHROOM));
        add(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK, (block) -> createMushroomBlockDrop(block, RuBlocks.YELLOW_BIOSHROOM));
        //BAMBOO
        dropSelf(RuBlocks.BAMBOO_LOG);
        dropSelf(RuBlocks.STRIPPED_BAMBOO_LOG);
        //OAK
        dropSelf(RuBlocks.SMALL_OAK_LOG);
        dropSelf(RuBlocks.STRIPPED_SMALL_OAK_LOG);
        //CACTUS
        dropSelf(RuBlocks.SAGUARO_CACTUS);

        /*-----------------LEAVES-----------------*/
        add(RuBlocks.ALPHA_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.APPLE_OAK_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.APPLE_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ASHEN_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.ASHEN_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAMBOO_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.BAMBOO_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAOBAB_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.BAOBAB_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLACKWOOD_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.BLACKWOOD_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.COBALT_WEBBING, (block) -> createLeavesDrops(block, RuBlocks.COBALT_SAPLING, COBALT_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAGNOLIA_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.MAGNOLIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.CYPRESS_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.CYPRESS_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.DEAD_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_PINE_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.DEAD_PINE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.EUCALYPTUS_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.EUCALYPTUS_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.FLOWERING_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.FLOWERING_SAPLING, FLOWERING_OAK_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.GOLDEN_LARCH_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.GOLDEN_LARCH_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.JOSHUA_LEAVES, (block) -> createDoublePlantWithSeedDropsNoGrass(block, RuBlocks.JOSHUA_LEAVES, RuBlocks.JOSHUA_SAPLING, JOSHUA_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.KAPOK_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.KAPOK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.LARCH_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.LARCH_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAPLE_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.MAPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAUVE_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.MAUVE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ORANGE_MAPLE_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.ORANGE_MAPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PALM_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.PALM_SAPLING, PALM_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINE_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.PINE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLUE_MAGNOLIA_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.BLUE_MAGNOLIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINK_MAGNOLIA_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.PINK_MAGNOLIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.REDWOOD_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.REDWOOD_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.RED_MAPLE_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.RED_MAPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BRIMWOOD_LEAVES, (block) -> createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(RuBlocks.BRIMWOOD_SAPLING)).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, NORMAL_LEAVES_SAPLING_CHANCES))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)));
        add(RuBlocks.SILVER_BIRCH_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.SILVER_BIRCH_SAPLING, ASPEN_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SMALL_OAK_LEAVES, (block) -> createOakLeavesDrops(block, RuBlocks.SMALL_OAK_SAPLING, SMALL_OAK_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SOCOTRA_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.SOCOTRA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ENCHANTED_BIRCH_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.ENCHANTED_BIRCH_SAPLING, ASPEN_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WHITE_MAGNOLIA_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.WHITE_MAGNOLIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WILLOW_LEAVES, (block) -> createLeavesDrops(block, RuBlocks.WILLOW_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));

        /*-----------------BRANCHES-----------------*/
        add(RuBlocks.ACACIA_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BAOBAB_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BIRCH_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BLACKWOOD_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAGNOLIA_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CYPRESS_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CHERRY_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DARK_OAK_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DEAD_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.EUCALYPTUS_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JOSHUA_BEARD, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JUNGLE_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.KAPOK_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.LARCH_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MANGROVE_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAPLE_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAUVE_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.OAK_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PALM_BEARD, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PINE_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.REDWOOD_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SILVER_BIRCH_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SOCOTRA_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SPRUCE_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.WILLOW_BRANCH, (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));

        /*-----------------DIRT_BLOCKS-----------------*/
        //FOREST_DIRT_BLOCKS
        add(RuBlocks.PEAT_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT));
        dropSelf(RuBlocks.PEAT_DIRT);
        add(RuBlocks.PEAT_DIRT_PATH, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT));
        dropSelf(RuBlocks.PEAT_COARSE_DIRT);
        dropSelf(RuBlocks.PEAT_PODZOL);
        dropSelf(RuBlocks.PEAT_MUD);
        add(RuBlocks.PEAT_FARMLAND, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT));
        //PLAINS_DIRT_BLOCKS
        add(RuBlocks.SILT_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT));
        dropSelf(RuBlocks.SILT_DIRT);
        add(RuBlocks.SILT_DIRT_PATH, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT));
        dropSelf(RuBlocks.SILT_COARSE_DIRT);
        dropSelf(RuBlocks.SILT_PODZOL);
        dropSelf(RuBlocks.SILT_MUD);
        add(RuBlocks.SILT_FARMLAND, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT));
        //OTHER_DIRT_BLOCKS
        add(RuBlocks.ALPHA_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        dropSelf(RuBlocks.ASHEN_DIRT);

        /*-----------------STONE_BLOCKS-----------------*/
        //CHALKS
        dropSelf(RuBlocks.CHALK);
        add(RuBlocks.CHALK_GRASS_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.CHALK));
        dropSelf(RuBlocks.CHALK_BRICKS);
        add(RuBlocks.CHALK_BRICK_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.CHALK_BRICK_STAIRS);
        dropSelf(RuBlocks.CHALK_PILLAR);
        add(RuBlocks.CHALK_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.CHALK_STAIRS);
        dropSelf(RuBlocks.POLISHED_CHALK);
        add(RuBlocks.POLISHED_CHALK_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.POLISHED_CHALK_STAIRS);
        //STONES
        dropSelf(RuBlocks.ARGILLITE);
        add(RuBlocks.MOSSY_STONE, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.MOSSY_COBBLESTONE));

        /*-----------------OCEAN_BLOCKS-----------------*/
        //HYACINTH_BLOCKS
        dropSelf(RuBlocks.HYACINTH_LAMP);
        dropSelf(RuBlocks.HYACINTH_BLOOM);
        add(RuBlocks.HYACINTH_FLOWERS, (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        dropSelf(RuBlocks.TALL_HYACINTH_STOCK);

        /*-----------------OTHER_BLOCKS-----------------*/
        add(RuBlocks.ASH, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.SILK_TOUCH, 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        add(RuBlocks.VOLCANIC_ASH, (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.SILK_TOUCH, 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        dropSelf(RuBlocks.ASH_VENT);

        /*-----------------WOOD_TYPES-----------------*/
        //ASHEN_BLOCKS
        dropSelf(RuBlocks.ASHEN_LOG);
        dropSelf(RuBlocks.ASHEN_WOOD);
        //SILVER_BIRCH_BLOCKS
        dropSelf(RuBlocks.SILVER_BIRCH_LOG);
        dropSelf(RuBlocks.SILVER_BIRCH_WOOD);
        //ALPHA_BLOCKS
        dropSelf(RuBlocks.ALPHA_LOG);
        dropSelf(RuBlocks.ALPHA_PLANKS);
        dropSelf(RuBlocks.ALPHA_STAIRS);
        add(RuBlocks.ALPHA_SLAB, (block) -> createSlabItemTable(block));
        //BAOBAB_BLOCKS
        dropSelf(RuBlocks.BAOBAB_LOG);
        dropSelf(RuBlocks.STRIPPED_BAOBAB_LOG);
        dropSelf(RuBlocks.BAOBAB_WOOD);
        dropSelf(RuBlocks.STRIPPED_BAOBAB_WOOD);
        dropSelf(RuBlocks.BAOBAB_PLANKS);
        dropSelf(RuBlocks.BAOBAB_STAIRS);
        add(RuBlocks.BAOBAB_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BAOBAB_FENCE);
        add(RuBlocks.BAOBAB_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BAOBAB_FENCE_GATE);
        dropSelf(RuBlocks.BAOBAB_TRAPDOOR);
        dropSelf(RuBlocks.BAOBAB_PRESSURE_PLATE);
        dropSelf(RuBlocks.BAOBAB_BUTTON);
        dropSelf(RuBlocks.BAOBAB_SIGN);
        add(RuBlocks.BAOBAB_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.BAOBAB_SIGN));
        dropSelf(RuBlocks.BAOBAB_HANGING_SIGN);
        add(RuBlocks.BAOBAB_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.BAOBAB_HANGING_SIGN));
        //BLACKWOOD_BLOCKS
        dropSelf(RuBlocks.BLACKWOOD_LOG);
        dropSelf(RuBlocks.STRIPPED_BLACKWOOD_LOG);
        dropSelf(RuBlocks.BLACKWOOD_WOOD);
        dropSelf(RuBlocks.STRIPPED_BLACKWOOD_WOOD);
        dropSelf(RuBlocks.BLACKWOOD_PLANKS);
        dropSelf(RuBlocks.BLACKWOOD_STAIRS);
        add(RuBlocks.BLACKWOOD_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BLACKWOOD_FENCE);
        add(RuBlocks.BLACKWOOD_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BLACKWOOD_FENCE_GATE);
        dropSelf(RuBlocks.BLACKWOOD_TRAPDOOR);
        dropSelf(RuBlocks.BLACKWOOD_PRESSURE_PLATE);
        dropSelf(RuBlocks.BLACKWOOD_BUTTON);
        dropSelf(RuBlocks.BLACKWOOD_SIGN);
        add(RuBlocks.BLACKWOOD_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.BLACKWOOD_SIGN));
        dropSelf(RuBlocks.BLACKWOOD_HANGING_SIGN);
        add(RuBlocks.BLACKWOOD_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.BLACKWOOD_HANGING_SIGN));
        //BLUE_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.BLUE_BIOSHROOM_STEM);
        dropSelf(RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_PLANKS);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_STAIRS);
        add(RuBlocks.BLUE_BIOSHROOM_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BLUE_BIOSHROOM_FENCE);
        add(RuBlocks.BLUE_BIOSHROOM_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BLUE_BIOSHROOM_FENCE_GATE);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_TRAPDOOR);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_BUTTON);
        dropSelf(RuBlocks.BLUE_BIOSHROOM_SIGN);
        add(RuBlocks.BLUE_BIOSHROOM_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.BLUE_BIOSHROOM_SIGN));
        dropSelf(RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN);
        add(RuBlocks.BLUE_BIOSHROOM_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN));
        //BRIMWOOD_BLOCKS
        dropSelf(RuBlocks.BRIMWOOD_LOG);
        add(RuBlocks.BRIMWOOD_LOG_MAGMA, (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.BRIMWOOD_LOG));
        dropSelf(RuBlocks.STRIPPED_BRIMWOOD_LOG);
        dropSelf(RuBlocks.BRIMWOOD_WOOD);
        dropSelf(RuBlocks.STRIPPED_BRIMWOOD_WOOD);
        dropSelf(RuBlocks.BRIMWOOD_PLANKS);
        dropSelf(RuBlocks.BRIMWOOD_STAIRS);
        add(RuBlocks.BRIMWOOD_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BRIMWOOD_FENCE);
        add(RuBlocks.BRIMWOOD_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BRIMWOOD_FENCE_GATE);
        dropSelf(RuBlocks.BRIMWOOD_TRAPDOOR);
        dropSelf(RuBlocks.BRIMWOOD_PRESSURE_PLATE);
        dropSelf(RuBlocks.BRIMWOOD_BUTTON);
        dropSelf(RuBlocks.BRIMWOOD_SIGN);
        add(RuBlocks.BRIMWOOD_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.BRIMWOOD_SIGN));
        dropSelf(RuBlocks.BRIMWOOD_HANGING_SIGN);
        add(RuBlocks.BRIMWOOD_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.BRIMWOOD_HANGING_SIGN));
        //COBALT_BLOCKS
        dropSelf(RuBlocks.COBALT_LOG);
        dropSelf(RuBlocks.STRIPPED_COBALT_LOG);
        dropSelf(RuBlocks.COBALT_WOOD);
        dropSelf(RuBlocks.STRIPPED_COBALT_WOOD);
        dropSelf(RuBlocks.COBALT_PLANKS);
        dropSelf(RuBlocks.COBALT_STAIRS);
        add(RuBlocks.COBALT_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.COBALT_FENCE);
        add(RuBlocks.COBALT_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.COBALT_FENCE_GATE);
        dropSelf(RuBlocks.COBALT_TRAPDOOR);
        dropSelf(RuBlocks.COBALT_PRESSURE_PLATE);
        dropSelf(RuBlocks.COBALT_BUTTON);
        dropSelf(RuBlocks.COBALT_SIGN);
        add(RuBlocks.COBALT_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.COBALT_SIGN));
        dropSelf(RuBlocks.COBALT_HANGING_SIGN);
        add(RuBlocks.COBALT_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.COBALT_HANGING_SIGN));
        //CYPRESS_BLOCKS
        dropSelf(RuBlocks.CYPRESS_LOG);
        dropSelf(RuBlocks.STRIPPED_CYPRESS_LOG);
        dropSelf(RuBlocks.CYPRESS_WOOD);
        dropSelf(RuBlocks.STRIPPED_CYPRESS_WOOD);
        dropSelf(RuBlocks.CYPRESS_PLANKS);
        dropSelf(RuBlocks.CYPRESS_STAIRS);
        add(RuBlocks.CYPRESS_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.CYPRESS_FENCE);
        add(RuBlocks.CYPRESS_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.CYPRESS_FENCE_GATE);
        dropSelf(RuBlocks.CYPRESS_TRAPDOOR);
        dropSelf(RuBlocks.CYPRESS_PRESSURE_PLATE);
        dropSelf(RuBlocks.CYPRESS_BUTTON);
        dropSelf(RuBlocks.CYPRESS_SIGN);
        add(RuBlocks.CYPRESS_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.CYPRESS_SIGN));
        dropSelf(RuBlocks.CYPRESS_HANGING_SIGN);
        add(RuBlocks.CYPRESS_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.CYPRESS_HANGING_SIGN));
        //DEAD_BLOCKS
        dropSelf(RuBlocks.DEAD_LOG);
        dropSelf(RuBlocks.STRIPPED_DEAD_LOG);
        dropSelf(RuBlocks.DEAD_WOOD);
        dropSelf(RuBlocks.STRIPPED_DEAD_WOOD);
        dropSelf(RuBlocks.DEAD_PLANKS);
        dropSelf(RuBlocks.DEAD_STAIRS);
        add(RuBlocks.DEAD_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.DEAD_FENCE);
        add(RuBlocks.DEAD_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.DEAD_FENCE_GATE);
        dropSelf(RuBlocks.DEAD_TRAPDOOR);
        dropSelf(RuBlocks.DEAD_PRESSURE_PLATE);
        dropSelf(RuBlocks.DEAD_BUTTON);
        dropSelf(RuBlocks.DEAD_SIGN);
        add(RuBlocks.DEAD_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.DEAD_SIGN));
        dropSelf(RuBlocks.DEAD_HANGING_SIGN);
        add(RuBlocks.DEAD_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.DEAD_HANGING_SIGN));
        //EUCALYPTUS_BLOCKS
        dropSelf(RuBlocks.EUCALYPTUS_LOG);
        dropSelf(RuBlocks.STRIPPED_EUCALYPTUS_LOG);
        dropSelf(RuBlocks.EUCALYPTUS_WOOD);
        dropSelf(RuBlocks.STRIPPED_EUCALYPTUS_WOOD);
        dropSelf(RuBlocks.EUCALYPTUS_PLANKS);
        dropSelf(RuBlocks.EUCALYPTUS_STAIRS);
        add(RuBlocks.EUCALYPTUS_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.EUCALYPTUS_FENCE);
        add(RuBlocks.EUCALYPTUS_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.EUCALYPTUS_FENCE_GATE);
        dropSelf(RuBlocks.EUCALYPTUS_TRAPDOOR);
        dropSelf(RuBlocks.EUCALYPTUS_PRESSURE_PLATE);
        dropSelf(RuBlocks.EUCALYPTUS_BUTTON);
        dropSelf(RuBlocks.EUCALYPTUS_SIGN);
        add(RuBlocks.EUCALYPTUS_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.EUCALYPTUS_SIGN));
        dropSelf(RuBlocks.EUCALYPTUS_HANGING_SIGN);
        add(RuBlocks.EUCALYPTUS_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.EUCALYPTUS_HANGING_SIGN));
        //GREEN_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.GREEN_BIOSHROOM_STEM);
        dropSelf(RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_PLANKS);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_STAIRS);
        add(RuBlocks.GREEN_BIOSHROOM_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_FENCE);
        add(RuBlocks.GREEN_BIOSHROOM_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_FENCE_GATE);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_TRAPDOOR);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_BUTTON);
        dropSelf(RuBlocks.GREEN_BIOSHROOM_SIGN);
        add(RuBlocks.GREEN_BIOSHROOM_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.GREEN_BIOSHROOM_SIGN));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN);
        add(RuBlocks.GREEN_BIOSHROOM_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN));
        //JOSHUA_BLOCKS
        dropSelf(RuBlocks.JOSHUA_LOG);
        dropSelf(RuBlocks.STRIPPED_JOSHUA_LOG);
        dropSelf(RuBlocks.JOSHUA_WOOD);
        dropSelf(RuBlocks.STRIPPED_JOSHUA_WOOD);
        dropSelf(RuBlocks.JOSHUA_PLANKS);
        dropSelf(RuBlocks.JOSHUA_STAIRS);
        add(RuBlocks.JOSHUA_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.JOSHUA_FENCE);
        add(RuBlocks.JOSHUA_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.JOSHUA_FENCE_GATE);
        dropSelf(RuBlocks.JOSHUA_TRAPDOOR);
        dropSelf(RuBlocks.JOSHUA_PRESSURE_PLATE);
        dropSelf(RuBlocks.JOSHUA_BUTTON);
        dropSelf(RuBlocks.JOSHUA_SIGN);
        add(RuBlocks.JOSHUA_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.JOSHUA_SIGN));
        dropSelf(RuBlocks.JOSHUA_HANGING_SIGN);
        add(RuBlocks.JOSHUA_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.JOSHUA_HANGING_SIGN));
        //KAPOK_BLOCKS
        dropSelf(RuBlocks.KAPOK_LOG);
        dropSelf(RuBlocks.STRIPPED_KAPOK_LOG);
        dropSelf(RuBlocks.KAPOK_WOOD);
        dropSelf(RuBlocks.STRIPPED_KAPOK_WOOD);
        dropSelf(RuBlocks.KAPOK_PLANKS);
        dropSelf(RuBlocks.KAPOK_STAIRS);
        add(RuBlocks.KAPOK_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.KAPOK_FENCE);
        add(RuBlocks.KAPOK_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.KAPOK_FENCE_GATE);
        dropSelf(RuBlocks.KAPOK_TRAPDOOR);
        dropSelf(RuBlocks.KAPOK_PRESSURE_PLATE);
        dropSelf(RuBlocks.KAPOK_BUTTON);
        dropSelf(RuBlocks.KAPOK_SIGN);
        add(RuBlocks.KAPOK_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.KAPOK_SIGN));
        dropSelf(RuBlocks.KAPOK_HANGING_SIGN);
        add(RuBlocks.KAPOK_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.KAPOK_HANGING_SIGN));
        //LARCH_BLOCKS
        dropSelf(RuBlocks.LARCH_LOG);
        dropSelf(RuBlocks.STRIPPED_LARCH_LOG);
        dropSelf(RuBlocks.LARCH_WOOD);
        dropSelf(RuBlocks.STRIPPED_LARCH_WOOD);
        dropSelf(RuBlocks.LARCH_PLANKS);
        dropSelf(RuBlocks.LARCH_STAIRS);
        add(RuBlocks.LARCH_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.LARCH_FENCE);
        add(RuBlocks.LARCH_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.LARCH_FENCE_GATE);
        dropSelf(RuBlocks.LARCH_TRAPDOOR);
        dropSelf(RuBlocks.LARCH_PRESSURE_PLATE);
        dropSelf(RuBlocks.LARCH_BUTTON);
        dropSelf(RuBlocks.LARCH_SIGN);
        add(RuBlocks.LARCH_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.LARCH_SIGN));
        dropSelf(RuBlocks.LARCH_HANGING_SIGN);
        add(RuBlocks.LARCH_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.LARCH_HANGING_SIGN));
        //MAGNOLIA_BLOCKS
        dropSelf(RuBlocks.MAGNOLIA_LOG);
        dropSelf(RuBlocks.STRIPPED_MAGNOLIA_LOG);
        dropSelf(RuBlocks.MAGNOLIA_WOOD);
        dropSelf(RuBlocks.STRIPPED_MAGNOLIA_WOOD);
        dropSelf(RuBlocks.MAGNOLIA_PLANKS);
        dropSelf(RuBlocks.MAGNOLIA_STAIRS);
        add(RuBlocks.MAGNOLIA_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.MAGNOLIA_FENCE);
        add(RuBlocks.MAGNOLIA_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.MAGNOLIA_FENCE_GATE);
        dropSelf(RuBlocks.MAGNOLIA_TRAPDOOR);
        dropSelf(RuBlocks.MAGNOLIA_PRESSURE_PLATE);
        dropSelf(RuBlocks.MAGNOLIA_BUTTON);
        dropSelf(RuBlocks.MAGNOLIA_SIGN);
        add(RuBlocks.MAGNOLIA_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.MAGNOLIA_SIGN));
        dropSelf(RuBlocks.MAGNOLIA_HANGING_SIGN);
        add(RuBlocks.MAGNOLIA_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.MAGNOLIA_HANGING_SIGN));
        //MAPLE_BLOCKS
        dropSelf(RuBlocks.MAPLE_LOG);
        dropSelf(RuBlocks.STRIPPED_MAPLE_LOG);
        dropSelf(RuBlocks.MAPLE_WOOD);
        dropSelf(RuBlocks.STRIPPED_MAPLE_WOOD);
        dropSelf(RuBlocks.MAPLE_PLANKS);
        dropSelf(RuBlocks.MAPLE_STAIRS);
        add(RuBlocks.MAPLE_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.MAPLE_FENCE);
        add(RuBlocks.MAPLE_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.MAPLE_FENCE_GATE);
        dropSelf(RuBlocks.MAPLE_TRAPDOOR);
        dropSelf(RuBlocks.MAPLE_PRESSURE_PLATE);
        dropSelf(RuBlocks.MAPLE_BUTTON);
        dropSelf(RuBlocks.MAPLE_SIGN);
        add(RuBlocks.MAPLE_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.MAPLE_SIGN));
        dropSelf(RuBlocks.MAPLE_HANGING_SIGN);
        add(RuBlocks.MAPLE_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.MAPLE_HANGING_SIGN));
        //MAUVE_BLOCKS
        dropSelf(RuBlocks.MAUVE_LOG);
        dropSelf(RuBlocks.STRIPPED_MAUVE_LOG);
        dropSelf(RuBlocks.MAUVE_WOOD);
        dropSelf(RuBlocks.STRIPPED_MAUVE_WOOD);
        dropSelf(RuBlocks.MAUVE_PLANKS);
        dropSelf(RuBlocks.MAUVE_STAIRS);
        add(RuBlocks.MAUVE_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.MAUVE_FENCE);
        add(RuBlocks.MAUVE_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.MAUVE_FENCE_GATE);
        dropSelf(RuBlocks.MAUVE_TRAPDOOR);
        dropSelf(RuBlocks.MAUVE_PRESSURE_PLATE);
        dropSelf(RuBlocks.MAUVE_BUTTON);
        dropSelf(RuBlocks.MAUVE_SIGN);
        add(RuBlocks.MAUVE_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.MAUVE_SIGN));
        dropSelf(RuBlocks.MAUVE_HANGING_SIGN);
        add(RuBlocks.MAUVE_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.MAUVE_HANGING_SIGN));
        //PALM_BLOCKS
        dropSelf(RuBlocks.PALM_LOG);
        dropSelf(RuBlocks.STRIPPED_PALM_LOG);
        dropSelf(RuBlocks.PALM_WOOD);
        dropSelf(RuBlocks.STRIPPED_PALM_WOOD);
        dropSelf(RuBlocks.PALM_PLANKS);
        dropSelf(RuBlocks.PALM_STAIRS);
        add(RuBlocks.PALM_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.PALM_FENCE);
        add(RuBlocks.PALM_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.PALM_FENCE_GATE);
        dropSelf(RuBlocks.PALM_TRAPDOOR);
        dropSelf(RuBlocks.PALM_PRESSURE_PLATE);
        dropSelf(RuBlocks.PALM_BUTTON);
        dropSelf(RuBlocks.PALM_SIGN);
        add(RuBlocks.PALM_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.PALM_SIGN));
        dropSelf(RuBlocks.PALM_HANGING_SIGN);
        add(RuBlocks.PALM_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.PALM_HANGING_SIGN));
        //PINE_BLOCKS
        dropSelf(RuBlocks.PINE_LOG);
        dropSelf(RuBlocks.STRIPPED_PINE_LOG);
        dropSelf(RuBlocks.PINE_WOOD);
        dropSelf(RuBlocks.STRIPPED_PINE_WOOD);
        dropSelf(RuBlocks.PINE_PLANKS);
        dropSelf(RuBlocks.PINE_STAIRS);
        add(RuBlocks.PINE_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.PINE_FENCE);
        add(RuBlocks.PINE_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.PINE_FENCE_GATE);
        dropSelf(RuBlocks.PINE_TRAPDOOR);
        dropSelf(RuBlocks.PINE_PRESSURE_PLATE);
        dropSelf(RuBlocks.PINE_BUTTON);
        dropSelf(RuBlocks.PINE_SIGN);
        add(RuBlocks.PINE_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.PINE_SIGN));
        dropSelf(RuBlocks.PINE_HANGING_SIGN);
        add(RuBlocks.PINE_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.PINE_HANGING_SIGN));
        //PINK_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.PINK_BIOSHROOM_STEM);
        dropSelf(RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM);
        dropSelf(RuBlocks.PINK_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.PINK_BIOSHROOM_PLANKS);
        dropSelf(RuBlocks.PINK_BIOSHROOM_STAIRS);
        add(RuBlocks.PINK_BIOSHROOM_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.PINK_BIOSHROOM_FENCE);
        add(RuBlocks.PINK_BIOSHROOM_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.PINK_BIOSHROOM_FENCE_GATE);
        dropSelf(RuBlocks.PINK_BIOSHROOM_TRAPDOOR);
        dropSelf(RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE);
        dropSelf(RuBlocks.PINK_BIOSHROOM_BUTTON);
        dropSelf(RuBlocks.PINK_BIOSHROOM_SIGN);
        add(RuBlocks.PINK_BIOSHROOM_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.PINK_BIOSHROOM_SIGN));
        dropSelf(RuBlocks.PINK_BIOSHROOM_HANGING_SIGN);
        add(RuBlocks.PINK_BIOSHROOM_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.PINK_BIOSHROOM_HANGING_SIGN));
        //REDWOOD_BLOCKS
        dropSelf(RuBlocks.REDWOOD_LOG);
        dropSelf(RuBlocks.STRIPPED_REDWOOD_LOG);
        dropSelf(RuBlocks.REDWOOD_WOOD);
        dropSelf(RuBlocks.STRIPPED_REDWOOD_WOOD);
        dropSelf(RuBlocks.REDWOOD_PLANKS);
        dropSelf(RuBlocks.REDWOOD_STAIRS);
        add(RuBlocks.REDWOOD_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.REDWOOD_FENCE);
        add(RuBlocks.REDWOOD_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.REDWOOD_FENCE_GATE);
        dropSelf(RuBlocks.REDWOOD_TRAPDOOR);
        dropSelf(RuBlocks.REDWOOD_PRESSURE_PLATE);
        dropSelf(RuBlocks.REDWOOD_BUTTON);
        dropSelf(RuBlocks.REDWOOD_SIGN);
        add(RuBlocks.REDWOOD_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.REDWOOD_SIGN));
        dropSelf(RuBlocks.REDWOOD_HANGING_SIGN);
        add(RuBlocks.REDWOOD_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.REDWOOD_HANGING_SIGN));
        //SOCOTRA_BLOCKS
        dropSelf(RuBlocks.SOCOTRA_LOG);
        dropSelf(RuBlocks.STRIPPED_SOCOTRA_LOG);
        dropSelf(RuBlocks.SOCOTRA_WOOD);
        dropSelf(RuBlocks.STRIPPED_SOCOTRA_WOOD);
        dropSelf(RuBlocks.SOCOTRA_PLANKS);
        dropSelf(RuBlocks.SOCOTRA_STAIRS);
        add(RuBlocks.SOCOTRA_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.SOCOTRA_FENCE);
        add(RuBlocks.SOCOTRA_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.SOCOTRA_FENCE_GATE);
        dropSelf(RuBlocks.SOCOTRA_TRAPDOOR);
        dropSelf(RuBlocks.SOCOTRA_PRESSURE_PLATE);
        dropSelf(RuBlocks.SOCOTRA_BUTTON);
        dropSelf(RuBlocks.SOCOTRA_SIGN);
        add(RuBlocks.SOCOTRA_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.SOCOTRA_SIGN));
        dropSelf(RuBlocks.SOCOTRA_HANGING_SIGN);
        add(RuBlocks.SOCOTRA_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.SOCOTRA_HANGING_SIGN));
        //WILLOW_BLOCKS
        dropSelf(RuBlocks.WILLOW_LOG);
        dropSelf(RuBlocks.STRIPPED_WILLOW_LOG);
        dropSelf(RuBlocks.WILLOW_WOOD);
        dropSelf(RuBlocks.STRIPPED_WILLOW_WOOD);
        dropSelf(RuBlocks.WILLOW_PLANKS);
        dropSelf(RuBlocks.WILLOW_STAIRS);
        add(RuBlocks.WILLOW_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.WILLOW_FENCE);
        add(RuBlocks.WILLOW_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.WILLOW_FENCE_GATE);
        dropSelf(RuBlocks.WILLOW_TRAPDOOR);
        dropSelf(RuBlocks.WILLOW_PRESSURE_PLATE);
        dropSelf(RuBlocks.WILLOW_BUTTON);
        dropSelf(RuBlocks.WILLOW_SIGN);
        add(RuBlocks.WILLOW_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.WILLOW_SIGN));
        dropSelf(RuBlocks.WILLOW_HANGING_SIGN);
        add(RuBlocks.WILLOW_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.WILLOW_HANGING_SIGN));
        //YELLOW_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_STEM);
        dropSelf(RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.STRIPPED_YELLOW_BIOSHROOM_HYPHAE);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_PLANKS);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_STAIRS);
        add(RuBlocks.YELLOW_BIOSHROOM_SLAB, (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_FENCE);
        add(RuBlocks.YELLOW_BIOSHROOM_DOOR, (block) -> createDoorTable(block));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_FENCE_GATE);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_TRAPDOOR);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_PRESSURE_PLATE);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_BUTTON);
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_SIGN);
        add(RuBlocks.YELLOW_BIOSHROOM_WALL_SIGN, (block) -> createSingleItemTable(RuBlocks.YELLOW_BIOSHROOM_SIGN));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN);
        add(RuBlocks.YELLOW_BIOSHROOM_WALL_HANGING_SIGN, (block) -> createSingleItemTable(RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN));

        /*-----------------PAINTED PLANKS-----------------*/
        //PLANKS
        dropSelf(RuBlocks.RED_PAINTED_PLANKS);
        dropSelf(RuBlocks.ORANGE_PAINTED_PLANKS);
        dropSelf(RuBlocks.YELLOW_PAINTED_PLANKS);
        dropSelf(RuBlocks.LIME_PAINTED_PLANKS);
        dropSelf(RuBlocks.GREEN_PAINTED_PLANKS);
        dropSelf(RuBlocks.CYAN_PAINTED_PLANKS);
        dropSelf(RuBlocks.LIGHT_BLUE_PAINTED_PLANKS);
        dropSelf(RuBlocks.BLUE_PAINTED_PLANKS);
        dropSelf(RuBlocks.PURPLE_PAINTED_PLANKS);
        dropSelf(RuBlocks.MAGENTA_PAINTED_PLANKS);
        dropSelf(RuBlocks.PINK_PAINTED_PLANKS);
        dropSelf(RuBlocks.BROWN_PAINTED_PLANKS);
        dropSelf(RuBlocks.WHITE_PAINTED_PLANKS);
        dropSelf(RuBlocks.LIGHT_GRAY_PAINTED_PLANKS);
        dropSelf(RuBlocks.GRAY_PAINTED_PLANKS);
        dropSelf(RuBlocks.BLACK_PAINTED_PLANKS);
        //STAIRS
        dropSelf(RuBlocks.RED_PAINTED_STAIRS);
        dropSelf(RuBlocks.ORANGE_PAINTED_STAIRS);
        dropSelf(RuBlocks.YELLOW_PAINTED_STAIRS);
        dropSelf(RuBlocks.LIME_PAINTED_STAIRS);
        dropSelf(RuBlocks.GREEN_PAINTED_STAIRS);
        dropSelf(RuBlocks.CYAN_PAINTED_STAIRS);
        dropSelf(RuBlocks.LIGHT_BLUE_PAINTED_STAIRS);
        dropSelf(RuBlocks.BLUE_PAINTED_STAIRS);
        dropSelf(RuBlocks.PURPLE_PAINTED_STAIRS);
        dropSelf(RuBlocks.MAGENTA_PAINTED_STAIRS);
        dropSelf(RuBlocks.PINK_PAINTED_STAIRS);
        dropSelf(RuBlocks.BROWN_PAINTED_STAIRS);
        dropSelf(RuBlocks.WHITE_PAINTED_STAIRS);
        dropSelf(RuBlocks.LIGHT_GRAY_PAINTED_STAIRS);
        dropSelf(RuBlocks.GRAY_PAINTED_STAIRS);
        dropSelf(RuBlocks.BLACK_PAINTED_STAIRS);
        //SLABS
        add(RuBlocks.RED_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.ORANGE_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.YELLOW_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.LIME_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.GREEN_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.CYAN_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.LIGHT_BLUE_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.BLUE_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.PURPLE_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.MAGENTA_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.PINK_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.BROWN_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.WHITE_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.LIGHT_GRAY_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.GRAY_PAINTED_SLAB, (block) -> createSlabItemTable(block));
        add(RuBlocks.BLACK_PAINTED_SLAB, (block) -> createSlabItemTable(block));

        /*-----------------NETHER_BLOCKS-----------------*/
        //NETHER_STONES
        dropSelf(RuBlocks.BLACKSTONE_CLUSTER);
        add(RuBlocks.OVERGROWN_BONE_BLOCK, (block) -> createSingleItemTableWithSilkTouch(block, Items.BONE_BLOCK));
        //BRIMSPROUT_BLOCKS
        add(RuBlocks.BRIMSPROUT_NYLIUM, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.BRIMSPROUT);
        //COBALT_BLOCKS
        dropSelf(RuBlocks.COBALT_EARLIGHT);
        add(RuBlocks.TALL_COBALT_EARLIGHT, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.COBALT_NYLIUM, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.BLACKSTONE));
        dropSelf(RuBlocks.COBALT_OBSIDIAN);
        dropSelf(RuBlocks.COBALT_ROOTS);
        add(RuBlocks.HANGING_EARLIGHT, (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, 0.66F, 0.78F, 0.9F, 1.0F))));
        add(RuBlocks.HANGING_EARLIGHT_PLANT, (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, 0.66F, 0.78F, 0.9F, 1.0F))));
        //GLISTERING_BLOCKS
        add(RuBlocks.GLISTERING_IVY, (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_IVY_PLANT, (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_NYLIUM, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.GLISTERING_SPROUT);
        dropSelf(RuBlocks.GLISTERING_BLOOM);
        dropSelf(RuBlocks.GLISTERING_FERN);
        dropSelf(RuBlocks.GLISTERING_WART);
        add(RuBlocks.GLISTER_BULB, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GLISTER_SPIRE, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MYCOTOXIC_BLOCKS
        add(RuBlocks.MYCOTOXIC_MUSHROOMS, (block) -> createPetalsDrops(block));
        add(RuBlocks.MYCOTOXIC_DAISY, (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(RuBlocks.MYCOTOXIC_GRASS);
        add(RuBlocks.MYCOTOXIC_NYLIUM, (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
    }

    protected LootTable.Builder createMushroomBlockDrop(Block block, ItemLike item) {
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LimitCount.limitCount(IntRange.lowerBound(0)))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDropsNoGrass(Block block, Block block1, ItemLike item,  float... chances) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(block1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(item)).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.FORTUNE, chances)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDropsNoGrass(Block block) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.WHEAT_SEEDS)).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }
}
