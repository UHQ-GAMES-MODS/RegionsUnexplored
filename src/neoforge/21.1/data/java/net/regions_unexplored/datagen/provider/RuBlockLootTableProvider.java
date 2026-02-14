package net.regions_unexplored.datagen.provider;

import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
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
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.Tags;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.registry.RUItems;
import net.regions_unexplored.world.level.block.plant.food.SalmonBerryBushBlock;

import java.util.Map;
import java.util.Set;

public class RuBlockLootTableProvider extends BlockLootSubProvider {

    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.TOOLS_SHEAR));
    private final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(this.hasSilkTouch());
    private final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    protected static final float[] ASPEN_LEAVES_SAPLING_CHANCES = new float[]{0.0725F, 0.0785F, 0.0875F, 0.125F};
    protected static final float[] COBALT_LEAVES_SAPLING_CHANCES = new float[]{0.083F, 0.095F, 0.105F, 0.13F};
    protected static final float[] FLOWERING_OAK_LEAVES_SAPLING_CHANCES = new float[]{0.08F, 0.091F, 0.1F, 0.12F};
    protected static final float[] JOSHUA_LEAVES_SAPLING_CHANCES = new float[]{0.13F, 0.15F, 0.17F, 0.185F};
    protected static final float[] PALM_LEAVES_SAPLING_CHANCES = new float[]{0.1F, 0.125F, 0.14F, 0.155F};
    protected static final float[] SMALL_OAK_LEAVES_SAPLING_CHANCES = new float[]{0.075F, 0.08F, 0.089F, 0.1275F};

    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    public RuBlockLootTableProvider(HolderLookup.Provider holder) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), holder);
    }

    @Override
    protected void generate() {
        /*-----------------CAVE_BLOCKS-----------------*/
        //PRISMA_BLOCKS
        add(RUBlocks.PRISMOSS.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RUBlocks.DEEPSLATE_PRISMOSS.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));
        dropSelf(RUBlocks.HANGING_PRISMARITE.get());
        add(RUBlocks.LARGE_PRISMARITE_CLUSTER.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.PRISMAGLASS.get(), this::createSilkTouchOnlyTable);
        dropSelf(RUBlocks.PRISMARITE_CLUSTER.get());
        add(RUBlocks.PRISMOSS_SPROUT.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        //REDSTONE_BLOCKS
        dropSelf(RUBlocks.POINTED_REDSTONE.get());
        dropSelf(RUBlocks.RAW_REDSTONE_BLOCK.get());
        add(RUBlocks.REDSTONE_BUD.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));
        dropSelf(RUBlocks.REDSTONE_BULB.get());
        //OTHER_CAVE_BLOCKS
        add(RUBlocks.ARGILLITE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.ARGILLITE.get()));
        add(RUBlocks.STONE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RUBlocks.DEEPSLATE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));
        add(RUBlocks.VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));

        add(RUBlocks.CORPSE_FLOWER.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BLADED_GRASS.get(), this::createGrassDrops);
        add(RUBlocks.BLADED_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RUBlocks.BLADED_GRASS.get()));
        add(RUBlocks.DROPLEAF.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RUBlocks.DROPLEAF_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RUBlocks.DUSKMELON.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RUBlocks.DUSKMELON.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RUItems.DUSKMELON_SLICE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE)))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RUBlocks.DUSKMELON.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RUItems.DUSKMELON_SLICE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE))))));
        add(RUBlocks.DUSKTRAP.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        dropSelf(RUBlocks.DEAD_STEPPE_SHRUB.get());
        add(RUBlocks.ASHEN_GRASS.get(), this::createGrassDrops);
        add(RUBlocks.FROZEN_GRASS.get(), this::createGrassDrops);
        add(RUBlocks.SANDY_GRASS.get(), this::createGrassDrops);
        add(RUBlocks.SMALL_DESERT_SHRUB.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RUBlocks.STEPPE_GRASS.get(), this::createGrassDrops);
        add(RUBlocks.STEPPE_SHRUB.get(), this::createGrassDrops);
        add(RUBlocks.GRASS_SPROUTS.get(), this::createGrassDrops);
        //TALL_GRASS_BLOCKS
        add(RUBlocks.ELEPHANT_EAR.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.SANDY_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RUBlocks.SANDY_GRASS.get()));
        add(RUBlocks.STEPPE_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RUBlocks.STEPPE_GRASS.get()));
        add(RUBlocks.WINDSWEPT_GRASS.get(), this::createDoublePlantWithSeedDropsNoGrass);
        //FLOWERS
        dropSelf(RUBlocks.ALPHA_DANDELION.get());
        dropSelf(RUBlocks.ALPHA_ROSE.get());
        dropSelf(RUBlocks.ASTER.get());
        dropSelf(RUBlocks.BLEEDING_HEART.get());
        dropSelf(RUBlocks.BLUE_LUPINE.get());
        dropSelf(RUBlocks.DAISY.get());
        dropSelf(RUBlocks.DORCEL.get());
        dropSelf(RUBlocks.FELICIA_DAISY.get());
        dropSelf(RUBlocks.FIREWEED.get());
        dropSelf(RUBlocks.HIBISCUS.get());
        dropSelf(RUBlocks.HYSSOP.get());
        dropSelf(RUBlocks.MALLOW.get());
        dropSelf(RUBlocks.PINK_LUPINE.get());
        dropSelf(RUBlocks.POPPY_BUSH.get());
        dropSelf(RUBlocks.SALMON_POPPY_BUSH.get());
        dropSelf(RUBlocks.PURPLE_LUPINE.get());
        dropSelf(RUBlocks.RED_LUPINE.get());
        dropSelf(RUBlocks.TSUBAKI.get());
        dropSelf(RUBlocks.WARATAH.get());
        dropSelf(RUBlocks.WHITE_TRILLIUM.get());
        dropSelf(RUBlocks.WILTING_TRILLIUM.get());
        dropSelf(RUBlocks.YELLOW_LUPINE.get());

        add(RUBlocks.ORANGE_CONEFLOWER.get(), this::createPetalsDrops);
        add(RUBlocks.PURPLE_CONEFLOWER.get(), this::createPetalsDrops);
        add(RUBlocks.CLOVER.get(), this::createPetalsDrops);

        add(RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        //SNOWBELLE
        for (Block snowbelle : RUBlocks.SNOWBELLES.getAll()) {
            dropSelf(snowbelle);
        }

        add(RUBlocks.MAPLE_LEAF_LITTER.get(), this::createPetalsDrops);
        add(RUBlocks.RED_MAPLE_LEAF_LITTER.get(), this::createPetalsDrops);
        add(RUBlocks.ORANGE_MAPLE_LEAF_LITTER.get(), this::createPetalsDrops);
        add(RUBlocks.SILVER_BIRCH_LEAF_LITTER.get(), this::createPetalsDrops);
        add(RUBlocks.ENCHANTED_BIRCH_LEAF_LITTER.get(), this::createPetalsDrops);
        //TALL_PLANTS
        add(RUBlocks.MEADOW_SAGE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BARLEY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.CATTAIL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.TASSEL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.DAY_LILY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //SAPLINGS
        dropSelf(RUBlocks.ASHEN_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.ALPHA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.APPLE_OAK_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.BAMBOO_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.BAOBAB_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.BLACKWOOD_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.SAGUARO_CACTUS_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.COBALT_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.CYPRESS_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.DEAD_PINE_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.DEAD_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.EUCALYPTUS_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.FLOWERING_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.JOSHUA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.KAPOK_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.LARCH_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.MAPLE_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.MAUVE_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.PALM_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.PINE_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.REDWOOD_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.RED_MAPLE_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.BRIMWOOD_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.SILVER_BIRCH_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.SMALL_OAK_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.SOCOTRA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RUBlocks.WILLOW_NATURAL_SET.getSapling());
        //SHRUBS
        add(RUBlocks.ASHEN_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.ACACIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BAOBAB_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BIRCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BLACKWOOD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BRIMWOOD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.CHERRY_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.CYPRESS_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.DARK_OAK_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.DEAD_PINE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.DEAD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.EUCALYPTUS_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.FLOWERING_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.JOSHUA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.JUNGLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.KAPOK_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.LARCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.MANGROVE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.MAPLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.MAUVE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.OAK_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.PALM_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.PINE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.REDWOOD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.RED_MAPLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.SOCOTRA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.SPRUCE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.WILLOW_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MUSHROOMS
        dropSelf(RUBlocks.BLUE_BIOSHROOM.get());
        dropSelf(RUBlocks.GREEN_BIOSHROOM.get());
        dropSelf(RUBlocks.PINK_BIOSHROOM.get());
        dropSelf(RUBlocks.YELLOW_BIOSHROOM.get());
        add(RUBlocks.TALL_BLUE_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.TALL_GREEN_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.TALL_PINK_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.TALL_YELLOW_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //OTHER_PLANT_BLOCKS
        add(RUBlocks.ICICLE.get(), this::createSilkTouchOnlyTable);
        dropSelf(RUBlocks.BARREL_CACTUS.get());
        dropSelf(RUBlocks.CAVE_HYSSOP.get());
        dropSelf(RUBlocks.DUCKWEED.get());
        add(RUBlocks.SPANISH_MOSS.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RUBlocks.SPANISH_MOSS_PLANT.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RUBlocks.KAPOK_VINES.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RUBlocks.KAPOK_VINES_PLANT.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        dropSelf(RUBlocks.FLOWERING_LILY_PAD.get());
        add(RUBlocks.GIANT_LILY_PAD.get(), (block) -> createSingleItemTable(RUBlocks.FLOWERING_LILY_PAD.get()));
        //FOOD_PLANT_BLOCKS
        add(RUBlocks.SALMONBERRY_BUSH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RUBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RUItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE)))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RUBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RUItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE))))));

        /*-----------------POTTED_PLANTS-----------------*/
        add(RUBlocks.POTTED_ALPHA_DANDELION.get(), createPotFlowerItemTable(RUBlocks.ALPHA_DANDELION.get()));
        add(RUBlocks.POTTED_ALPHA_ROSE.get(), createPotFlowerItemTable(RUBlocks.ALPHA_ROSE.get()));
        add(RUBlocks.POTTED_ASTER.get(), createPotFlowerItemTable(RUBlocks.ASTER.get()));
        add(RUBlocks.POTTED_BLEEDING_HEART.get(), createPotFlowerItemTable(RUBlocks.BLEEDING_HEART.get()));
        add(RUBlocks.POTTED_DAISY.get(), createPotFlowerItemTable(RUBlocks.DAISY.get()));
        add(RUBlocks.POTTED_FELICIA_DAISY.get(), createPotFlowerItemTable(RUBlocks.FELICIA_DAISY.get()));
        add(RUBlocks.POTTED_DORCEL.get(), createPotFlowerItemTable(RUBlocks.DORCEL.get()));
        add(RUBlocks.POTTED_FIREWEED.get(), createPotFlowerItemTable(RUBlocks.FIREWEED.get()));
        add(RUBlocks.POTTED_GLISTERING_BLOOM.get(), createPotFlowerItemTable(RUBlocks.GLISTERING_BLOOM.get()));
        add(RUBlocks.POTTED_HIBISCUS.get(), createPotFlowerItemTable(RUBlocks.HIBISCUS.get()));
        add(RUBlocks.POTTED_HYSSOP.get(), createPotFlowerItemTable(RUBlocks.HYSSOP.get()));
        add(RUBlocks.POTTED_MALLOW.get(), createPotFlowerItemTable(RUBlocks.MALLOW.get()));
        add(RUBlocks.POTTED_POPPY_BUSH.get(), createPotFlowerItemTable(RUBlocks.POPPY_BUSH.get()));
        add(RUBlocks.POTTED_SALMON_POPPY_BUSH.get(), createPotFlowerItemTable(RUBlocks.SALMON_POPPY_BUSH.get()));
        add(RUBlocks.POTTED_TSUBAKI.get(), createPotFlowerItemTable(RUBlocks.TSUBAKI.get()));
        add(RUBlocks.POTTED_WARATAH.get(), createPotFlowerItemTable(RUBlocks.WARATAH.get()));
        add(RUBlocks.POTTED_WHITE_TRILLIUM.get(), createPotFlowerItemTable(RUBlocks.WHITE_TRILLIUM.get()));
        add(RUBlocks.POTTED_WILTING_TRILLIUM.get(), createPotFlowerItemTable(RUBlocks.WILTING_TRILLIUM.get()));
        add(RUBlocks.POTTED_BLUE_LUPINE.get(), createPotFlowerItemTable(RUBlocks.BLUE_LUPINE.get()));
        add(RUBlocks.POTTED_PINK_LUPINE.get(), createPotFlowerItemTable(RUBlocks.PINK_LUPINE.get()));
        add(RUBlocks.POTTED_PURPLE_LUPINE.get(), createPotFlowerItemTable(RUBlocks.PURPLE_LUPINE.get()));
        add(RUBlocks.POTTED_RED_LUPINE.get(), createPotFlowerItemTable(RUBlocks.RED_LUPINE.get()));
        add(RUBlocks.POTTED_YELLOW_LUPINE.get(), createPotFlowerItemTable(RUBlocks.YELLOW_LUPINE.get()));
        add(RUBlocks.POTTED_ORANGE_CONEFLOWER.get(), createPotFlowerItemTable(RUBlocks.ORANGE_CONEFLOWER.get()));
        add(RUBlocks.POTTED_PURPLE_CONEFLOWER.get(), createPotFlowerItemTable(RUBlocks.PURPLE_CONEFLOWER.get()));
        for (Map.Entry<DyeColor, Block> entry : RUBlocks.POTTED_SNOWBELLES.getMap().entrySet()) {
            add(entry.getValue(), createPotFlowerItemTable(RUBlocks.SNOWBELLES.getMap().get(entry.getKey())));
        }
        add(RUBlocks.POTTED_DAY_LILY.get(), createPotFlowerItemTable(RUBlocks.DAY_LILY.get()));
        add(RUBlocks.POTTED_MEADOW_SAGE.get(), createPotFlowerItemTable(RUBlocks.MEADOW_SAGE.get()));
        add(RUBlocks.POTTED_CAVE_HYSSOP.get(), createPotFlowerItemTable(RUBlocks.CAVE_HYSSOP.get()));
        add(RUBlocks.POTTED_BARREL_CACTUS.get(), createPotFlowerItemTable(RUBlocks.BARREL_CACTUS.get()));
        add(RUBlocks.POTTED_DUSKTRAP.get(), createPotFlowerItemTable(RUBlocks.DUSKTRAP.get()));
        add(RUBlocks.POTTED_CORPSE_FLOWER.get(), createPotFlowerItemTable(RUBlocks.CORPSE_FLOWER.get()));
        add(RUBlocks.POTTED_COBALT_EARLIGHT.get(), createPotFlowerItemTable(RUBlocks.COBALT_EARLIGHT.get()));
        add(RUBlocks.POTTED_TALL_COBALT_EARLIGHT.get(), createPotFlowerItemTable(RUBlocks.TALL_COBALT_EARLIGHT.get()));
        add(RUBlocks.POTTED_MYCOTOXIC_DAISY.get(), createPotFlowerItemTable(RUBlocks.MYCOTOXIC_DAISY.get()));
        add(RUBlocks.POTTED_GLISTER_SPIRE.get(), createPotFlowerItemTable(RUBlocks.GLISTER_SPIRE.get()));
        add(RUBlocks.POTTED_BLUE_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.BLUE_BIOSHROOM.get()));
        add(RUBlocks.POTTED_GREEN_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.GREEN_BIOSHROOM.get()));
        add(RUBlocks.POTTED_PINK_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.PINK_BIOSHROOM.get()));
        add(RUBlocks.POTTED_YELLOW_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.YELLOW_BIOSHROOM.get()));
        add(RUBlocks.POTTED_TALL_BLUE_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.TALL_BLUE_BIOSHROOM.get()));
        add(RUBlocks.POTTED_TALL_GREEN_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.TALL_GREEN_BIOSHROOM.get()));
        add(RUBlocks.POTTED_TALL_PINK_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.TALL_PINK_BIOSHROOM.get()));
        add(RUBlocks.POTTED_TALL_YELLOW_BIOSHROOM.get(), createPotFlowerItemTable(RUBlocks.TALL_YELLOW_BIOSHROOM.get()));
        add(RUBlocks.ASHEN_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.ASHEN_NATURAL_SET.getSapling()));
        add(RUBlocks.ALPHA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.ALPHA_NATURAL_SET.getSapling()));
        add(RUBlocks.APPLE_OAK_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.APPLE_OAK_NATURAL_SET.getSapling()));
        add(RUBlocks.BAMBOO_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.BAMBOO_NATURAL_SET.getSapling()));
        add(RUBlocks.BAOBAB_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.BAOBAB_NATURAL_SET.getSapling()));
        add(RUBlocks.BLACKWOOD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.BLACKWOOD_NATURAL_SET.getSapling()));
        add(RUBlocks.BRIMWOOD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.BRIMWOOD_NATURAL_SET.getSapling()));
        add(RUBlocks.COBALT_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.COBALT_NATURAL_SET.getSapling()));
        add(RUBlocks.SAGUARO_CACTUS_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.SAGUARO_CACTUS_NATURAL_SET.getSapling()));
        add(RUBlocks.MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.MAGNOLIA_NATURAL_SET.getSapling()));
        add(RUBlocks.CYPRESS_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.CYPRESS_NATURAL_SET.getSapling()));
        add(RUBlocks.DEAD_PINE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.DEAD_PINE_NATURAL_SET.getSapling()));
        add(RUBlocks.DEAD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.DEAD_NATURAL_SET.getSapling()));
        add(RUBlocks.EUCALYPTUS_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.EUCALYPTUS_NATURAL_SET.getSapling()));
        add(RUBlocks.FLOWERING_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.FLOWERING_NATURAL_SET.getSapling()));
        add(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling()));
        add(RUBlocks.JOSHUA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.JOSHUA_NATURAL_SET.getSapling()));
        add(RUBlocks.KAPOK_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.KAPOK_NATURAL_SET.getSapling()));
        add(RUBlocks.LARCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.LARCH_NATURAL_SET.getSapling()));
        add(RUBlocks.MAPLE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.MAPLE_NATURAL_SET.getSapling()));
        add(RUBlocks.MAUVE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.MAUVE_NATURAL_SET.getSapling()));
        add(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling()));
        add(RUBlocks.PALM_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.PALM_NATURAL_SET.getSapling()));
        add(RUBlocks.PINE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.PINE_NATURAL_SET.getSapling()));
        add(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling()));
        add(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling()));
        add(RUBlocks.REDWOOD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.REDWOOD_NATURAL_SET.getSapling()));
        add(RUBlocks.RED_MAPLE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.RED_MAPLE_NATURAL_SET.getSapling()));
        add(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling()));
        add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.SILVER_BIRCH_NATURAL_SET.getSapling()));
        add(RUBlocks.SMALL_OAK_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.SMALL_OAK_NATURAL_SET.getSapling()));
        add(RUBlocks.SOCOTRA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.SOCOTRA_NATURAL_SET.getSapling()));
        add(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling()));
        add(RUBlocks.WILLOW_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RUBlocks.WILLOW_NATURAL_SET.getSapling()));

        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        add(RUBlocks.BLUE_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.BLUE_BIOSHROOM.get()));
        add(RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.BLUE_BIOSHROOM.get()));
        add(RUBlocks.GREEN_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.GREEN_BIOSHROOM.get()));
        add(RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.GREEN_BIOSHROOM.get()));
        add(RUBlocks.PINK_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.PINK_BIOSHROOM.get()));
        add(RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.PINK_BIOSHROOM.get()));
        add(RUBlocks.YELLOW_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.YELLOW_BIOSHROOM.get()));
        add(RUBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RUBlocks.YELLOW_BIOSHROOM.get()));
        //BAMBOO
        dropSelf(RUBlocks.BAMBOO_LOG.get());
        dropSelf(RUBlocks.STRIPPED_BAMBOO_LOG.get());
        //OAK
        dropSelf(RUBlocks.SMALL_OAK_LOG.get());
        dropSelf(RUBlocks.STRIPPED_SMALL_OAK_LOG.get());
        //CACTUS
        dropSelf(RUBlocks.SAGUARO_CACTUS.get());

        /*-----------------LEAVES-----------------*/
        add(RUBlocks.ALPHA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.ALPHA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.APPLE_OAK_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.ASHEN_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.ASHEN_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.BAMBOO_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.BAMBOO_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.BAOBAB_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.BAOBAB_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.BLACKWOOD_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.BLACKWOOD_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.COBALT_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.COBALT_NATURAL_SET.getSapling(), COBALT_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.CYPRESS_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.CYPRESS_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.DEAD_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.DEAD_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.DEAD_PINE_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.DEAD_PINE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.EUCALYPTUS_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.EUCALYPTUS_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.FLOWERING_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.FLOWERING_NATURAL_SET.getSapling(), FLOWERING_OAK_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.JOSHUA_NATURAL_SET.getLeaves(), (block) -> createDoublePlantWithSeedDropsNoGrass(block, RUBlocks.JOSHUA_NATURAL_SET.getLeaves(), RUBlocks.JOSHUA_NATURAL_SET.getSapling(), JOSHUA_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.KAPOK_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.KAPOK_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.LARCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.LARCH_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.MAPLE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.MAPLE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.MAUVE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.MAUVE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.PALM_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.PALM_NATURAL_SET.getSapling(), PALM_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.PINE_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.PINE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.REDWOOD_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.REDWOOD_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.RED_MAPLE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.RED_MAPLE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.BRIMWOOD_NATURAL_SET.getLeaves(), (block) -> createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(RUBlocks.BRIMWOOD_NATURAL_SET.getSapling())).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_SAPLING_CHANCES))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)));
        add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.SILVER_BIRCH_NATURAL_SET.getSapling(), ASPEN_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.SMALL_OAK_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RUBlocks.SMALL_OAK_NATURAL_SET.getSapling(), SMALL_OAK_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.SOCOTRA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.SOCOTRA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling(), ASPEN_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RUBlocks.WILLOW_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RUBlocks.WILLOW_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));

        /*-----------------BRANCHES-----------------*/
        add(RUBlocks.ACACIA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.BAOBAB_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.BIRCH_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.BLACKWOOD_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.MAGNOLIA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.CYPRESS_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.CHERRY_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.DARK_OAK_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.DEAD_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.JOSHUA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.JUNGLE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.KAPOK_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.LARCH_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.MANGROVE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.MAPLE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.MAUVE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.OAK_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.PALM_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.PINE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.REDWOOD_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.SOCOTRA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.SPRUCE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RUBlocks.WILLOW_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));

        /*-----------------DIRT_BLOCKS-----------------*/
        //FOREST_DIRT_BLOCKS
        add(RUBlocks.PEAT_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.PEAT_DIRT.get()));
        dropSelf(RUBlocks.PEAT_DIRT.get());
        add(RUBlocks.PEAT_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.PEAT_DIRT.get()));
        dropSelf(RUBlocks.PEAT_COARSE_DIRT.get());
        dropSelf(RUBlocks.PEAT_PODZOL.get());
        dropSelf(RUBlocks.PEAT_MUD.get());
        add(RUBlocks.PEAT_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.PEAT_DIRT.get()));
        //PLAINS_DIRT_BLOCKS
        add(RUBlocks.SILT_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.SILT_DIRT.get()));
        dropSelf(RUBlocks.SILT_DIRT.get());
        add(RUBlocks.SILT_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.SILT_DIRT.get()));
        dropSelf(RUBlocks.SILT_COARSE_DIRT.get());
        dropSelf(RUBlocks.SILT_PODZOL.get());
        dropSelf(RUBlocks.SILT_MUD.get());
        add(RUBlocks.SILT_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.SILT_DIRT.get()));
        //OTHER_DIRT_BLOCKS
        add(RUBlocks.ALPHA_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        dropSelf(RUBlocks.ASHEN_DIRT.get());

        /*-----------------STONE_BLOCKS-----------------*/
        //CHALKS
        dropSelf(RUBlocks.CHALK.get());
        add(RUBlocks.CHALK_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.CHALK.get()));
        dropSelf(RUBlocks.CHALK_BRICKS.get());
        add(RUBlocks.CHALK_BRICK_SLAB.get(), this::createSlabItemTable);
        dropSelf(RUBlocks.CHALK_BRICK_STAIRS.get());
        dropSelf(RUBlocks.CHALK_PILLAR.get());
        add(RUBlocks.CHALK_SLAB.get(), this::createSlabItemTable);
        dropSelf(RUBlocks.CHALK_STAIRS.get());
        dropSelf(RUBlocks.POLISHED_CHALK.get());
        add(RUBlocks.POLISHED_CHALK_SLAB.get(), this::createSlabItemTable);
        dropSelf(RUBlocks.POLISHED_CHALK_STAIRS.get());
        //STONES
        dropSelf(RUBlocks.ARGILLITE.get());
        add(RUBlocks.MOSSY_STONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.MOSSY_COBBLESTONE));

        /*-----------------OCEAN_BLOCKS-----------------*/
        //HYACINTH_BLOCKS
        dropSelf(RUBlocks.HYACINTH_LAMP.get());
        dropSelf(RUBlocks.HYACINTH_BLOOM.get());
        add(RUBlocks.HYACINTH_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        dropSelf(RUBlocks.TALL_HYACINTH_STOCK.get());

        /*-----------------OTHER_BLOCKS-----------------*/
        add(RUBlocks.ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.SILK_TOUCH), 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        add(RUBlocks.VOLCANIC_ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.SILK_TOUCH), 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        dropSelf(RUBlocks.ASH_VENT.get());

        /*-----------------WOOD_TYPES-----------------*/
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            if (set.getLog() != null) dropSelf(set.getLog());
            if (set.getStrippedLog() != null) dropSelf(set.getStrippedLog());
            if (set.getWood() != null) dropSelf(set.getWood());
            if (set.getStrippedWood() != null) dropSelf(set.getStrippedWood());
            if (set.getPlanks() != null) dropSelf(set.getPlanks());
            if (set.getStairs() != null) dropSelf(set.getStairs());
            if (set.getSlab() != null) add(set.getSlab(), createSlabItemTable(set.getSlab()));
            if (set.getFence() != null) dropSelf(set.getFence());
            if (set.getDoor() != null) add(set.getDoor(), createDoorTable(set.getDoor()));
            if (set.getFenceGate() != null) dropSelf(set.getFenceGate());
            if (set.getTrapdoor() != null) dropSelf(set.getTrapdoor());
            if (set.getPressurePlate() != null) dropSelf(set.getPressurePlate());
            if (set.getButton() != null) dropSelf(set.getButton());
            if (set.getSign() != null) dropSelf(set.getSign());
            if (set.getWallSign() != null) add(set.getWallSign(), createSingleItemTable(set.getSign()));
            if (set.getHangingSign() != null) dropSelf(set.getHangingSign());
            if (set.getWallHangingSign() != null) add(set.getWallHangingSign(), createSingleItemTable(set.getHangingSign()));
        }
        add(RUBlocks.BRIMWOOD_WOOD_SET.getLogMagma(), (block) -> createSingleItemTableWithSilkTouch(block, RUBlocks.BRIMWOOD_WOOD_SET.getLog()));

        /*-----------------PAINTED PLANKS-----------------*/
        for (Block block : RUBlocks.PAINTED_PLANKS.getAll()) {
            dropSelf(block);
        }
        for (Block block : RUBlocks.PAINTED_STAIRS.getAll()) {
            dropSelf(block);
        }
        for (Block block : RUBlocks.PAINTED_SLABS.getAll()) {
            add(block, this::createSlabItemTable);
        }

        /*-----------------NETHER_BLOCKS-----------------*/
        //NETHER_STONES
        dropSelf(RUBlocks.BLACKSTONE_CLUSTER.get());
        add(RUBlocks.OVERGROWN_BONE_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BONE_BLOCK));
        //BRIMSPROUT_BLOCKS
        add(RUBlocks.BRIMSPROUT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RUBlocks.BRIMSPROUT.get());
        //COBALT_BLOCKS
        dropSelf(RUBlocks.COBALT_EARLIGHT.get());
        add(RUBlocks.TALL_COBALT_EARLIGHT.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.COBALT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.BLACKSTONE));
        dropSelf(RUBlocks.COBALT_OBSIDIAN.get());
        dropSelf(RUBlocks.COBALT_ROOTS.get());
        add(RUBlocks.HANGING_EARLIGHT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.66F, 0.78F, 0.9F, 1.0F))));
        add(RUBlocks.HANGING_EARLIGHT_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.66F, 0.78F, 0.9F, 1.0F))));
        //GLISTERING_BLOCKS
        add(RUBlocks.GLISTERING_IVY.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RUBlocks.GLISTERING_IVY_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RUBlocks.GLISTERING_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RUBlocks.GLISTERING_SPROUT.get());
        dropSelf(RUBlocks.GLISTERING_BLOOM.get());
        dropSelf(RUBlocks.GLISTERING_FERN.get());
        dropSelf(RUBlocks.GLISTERING_WART.get());
        add(RUBlocks.GLISTER_BULB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RUBlocks.GLISTER_SPIRE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MYCOTOXIC_BLOCKS
        add(RUBlocks.MYCOTOXIC_MUSHROOMS.get(), this::createPetalsDrops);
        add(RUBlocks.MYCOTOXIC_DAISY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(RUBlocks.MYCOTOXIC_GRASS.get());
        add(RUBlocks.MYCOTOXIC_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.entrySet().stream().filter(entry -> entry.getKey().identifier().getNamespace().contains(RegionsUnexplored.MOD_ID)).map(Map.Entry::getValue).toList();
    }

    @Override
    protected LootTable.Builder createMushroomBlockDrop(Block block, ItemLike item) {
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LimitCount.limitCount(IntRange.lowerBound(0)))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDropsNoGrass(Block block, Block block1, ItemLike item,  float... chances) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(block1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(item)).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), chances)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDropsNoGrass(Block block) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.WHEAT_SEEDS)).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }

    @Override
    protected LootTable.Builder createShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_SHEARS, builder);
    }

    protected static LootTable.Builder createShearsOnlyDrop(ItemLike item) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_SHEARS).add(LootItem.lootTableItem(item)));
    }

    @Override
    protected LootTable.Builder createSilkTouchOrShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, HAS_SHEARS_OR_SILK_TOUCH, builder);
    }

    @Override
    protected LootTable.Builder createLeavesDrops(Block block, Block block1, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(block, ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(block, LootItem.lootTableItem(block1))).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), chances))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(((LootPoolSingletonContainer.Builder)this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))));
    }

    @Override
    protected LootTable.Builder createOakLeavesDrops(Block block, Block block1, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(block, block1, chances).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(block, LootItem.lootTableItem(Items.APPLE))).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F}))));
    }

    @Override
    protected LootTable.Builder createDoublePlantWithSeedDrops(Block block, Block block1) {
        LootPoolEntryContainer.Builder<?> builder = ((LootPoolSingletonContainer.Builder)LootItem.lootTableItem(block1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(HAS_SHEARS)).otherwise(((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(block, LootItem.lootTableItem(Items.WHEAT_SEEDS))).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(net.minecraft.advancements.critereon.LocationPredicate.Builder.location().setBlock(net.minecraft.advancements.critereon.BlockPredicate.Builder.block().of(new Block[]{block}).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(net.minecraft.advancements.critereon.LocationPredicate.Builder.location().setBlock(net.minecraft.advancements.critereon.BlockPredicate.Builder.block().of(new Block[]{block}).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }
}
