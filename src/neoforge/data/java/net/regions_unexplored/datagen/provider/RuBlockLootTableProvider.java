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
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.item.RuItems;
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
        add(RuBlocks.PRISMOSS.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RuBlocks.DEEPSLATE_PRISMOSS.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));
        dropSelf(RuBlocks.HANGING_PRISMARITE.get());
        add(RuBlocks.LARGE_PRISMARITE_CLUSTER.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PRISMAGLASS.get(), this::createSilkTouchOnlyTable);
        dropSelf(RuBlocks.PRISMARITE_CLUSTER.get());
        add(RuBlocks.PRISMOSS_SPROUT.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        //REDSTONE_BLOCKS
        dropSelf(RuBlocks.POINTED_REDSTONE.get());
        dropSelf(RuBlocks.RAW_REDSTONE_BLOCK.get());
        add(RuBlocks.REDSTONE_BUD.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));
        dropSelf(RuBlocks.REDSTONE_BULB.get());
        //OTHER_CAVE_BLOCKS
        add(RuBlocks.ARGILLITE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.ARGILLITE.get()));
        add(RuBlocks.STONE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));
        add(RuBlocks.VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));

        add(RuBlocks.CORPSE_FLOWER.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLADED_GRASS.get(), this::createGrassDrops);
        add(RuBlocks.BLADED_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.BLADED_GRASS.get()));
        add(RuBlocks.DROPLEAF.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.DROPLEAF_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.DUSKMELON.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.DUSKMELON.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.DUSKMELON_SLICE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE)))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.DUSKMELON.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.DUSKMELON_SLICE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE))))));
        add(RuBlocks.DUSKTRAP.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        dropSelf(RuBlocks.DEAD_STEPPE_SHRUB.get());
        add(RuBlocks.ASHEN_GRASS.get(), this::createGrassDrops);
        add(RuBlocks.FROZEN_GRASS.get(), this::createGrassDrops);
        add(RuBlocks.MEDIUM_GRASS.get(), this::createGrassDrops);
        add(RuBlocks.SANDY_GRASS.get(), this::createGrassDrops);
        add(RuBlocks.SMALL_DESERT_SHRUB.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RuBlocks.STEPPE_GRASS.get(), this::createGrassDrops);
        add(RuBlocks.STEPPE_SHRUB.get(), this::createGrassDrops);
        add(RuBlocks.STONE_BUD.get(), this::createGrassDrops);
        //TALL_GRASS_BLOCKS
        add(RuBlocks.ELEPHANT_EAR.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SANDY_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.SANDY_GRASS.get()));
        add(RuBlocks.STEPPE_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.STEPPE_GRASS.get()));
        add(RuBlocks.WINDSWEPT_GRASS.get(), this::createDoublePlantWithSeedDropsNoGrass);
        //FLOWERS
        dropSelf(RuBlocks.ALPHA_DANDELION.get());
        dropSelf(RuBlocks.ALPHA_ROSE.get());
        dropSelf(RuBlocks.ASTER.get());
        dropSelf(RuBlocks.BLEEDING_HEART.get());
        dropSelf(RuBlocks.BLUE_LUPINE.get());
        dropSelf(RuBlocks.DAISY.get());
        dropSelf(RuBlocks.DORCEL.get());
        dropSelf(RuBlocks.FELICIA_DAISY.get());
        dropSelf(RuBlocks.FIREWEED.get());
        dropSelf(RuBlocks.HIBISCUS.get());
        dropSelf(RuBlocks.HYSSOP.get());
        dropSelf(RuBlocks.MALLOW.get());
        dropSelf(RuBlocks.PINK_LUPINE.get());
        dropSelf(RuBlocks.POPPY_BUSH.get());
        dropSelf(RuBlocks.SALMON_POPPY_BUSH.get());
        dropSelf(RuBlocks.PURPLE_LUPINE.get());
        dropSelf(RuBlocks.RED_LUPINE.get());
        dropSelf(RuBlocks.TSUBAKI.get());
        dropSelf(RuBlocks.WARATAH.get());
        dropSelf(RuBlocks.WHITE_TRILLIUM.get());
        dropSelf(RuBlocks.WILTING_TRILLIUM.get());
        dropSelf(RuBlocks.YELLOW_LUPINE.get());

        add(RuBlocks.ORANGE_CONEFLOWER.get(), this::createPetalsDrops);
        add(RuBlocks.PURPLE_CONEFLOWER.get(), this::createPetalsDrops);
        add(RuBlocks.CLOVER.get(), this::createPetalsDrops);

        add(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        //SNOWBELLE
        for (Block snowbelle : RuBlocks.SNOWBELLES.getAll()) {
            dropSelf(snowbelle);
        }

        add(RuBlocks.MAPLE_LEAF_PILE.get(), this::createPetalsDrops);
        add(RuBlocks.RED_MAPLE_LEAF_PILE.get(), this::createPetalsDrops);
        add(RuBlocks.ORANGE_MAPLE_LEAF_PILE.get(), this::createPetalsDrops);
        add(RuBlocks.SILVER_BIRCH_LEAF_PILE.get(), this::createPetalsDrops);
        add(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), this::createPetalsDrops);
        //TALL_PLANTS
        add(RuBlocks.MEADOW_SAGE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BARLEY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CATTAIL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TASSEL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DAY_LILY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //SAPLINGS
        dropSelf(RuBlocks.ASHEN_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.ALPHA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.APPLE_OAK_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.BAMBOO_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.BAOBAB_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.BLACKWOOD_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.CACTUS_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.COBALT_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.CYPRESS_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.DEAD_PINE_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.DEAD_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.EUCALYPTUS_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.FLOWERING_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.JOSHUA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.KAPOK_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.LARCH_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.MAPLE_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.MAUVE_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.PALM_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.PINE_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.REDWOOD_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.RED_MAPLE_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.BRIMWOOD_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.SILVER_BIRCH_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.SMALL_OAK_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.SOCOTRA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling());
        dropSelf(RuBlocks.WILLOW_NATURAL_SET.getSapling());
        //SHRUBS
        add(RuBlocks.ASHEN_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ACACIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BAOBAB_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BIRCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLACKWOOD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BRIMWOOD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CHERRY_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CYPRESS_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DARK_OAK_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_PINE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.EUCALYPTUS_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.FLOWERING_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JOSHUA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JUNGLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.KAPOK_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.LARCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MANGROVE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAPLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAUVE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.OAK_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PALM_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.REDWOOD_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.RED_MAPLE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SILVER_BIRCH_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SOCOTRA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SPRUCE_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WILLOW_NATURAL_SET.getShrub(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MUSHROOMS
        dropSelf(RuBlocks.BLUE_BIOSHROOM.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM.get());
        add(RuBlocks.TALL_BLUE_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_GREEN_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_PINK_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_YELLOW_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //OTHER_PLANT_BLOCKS
        add(RuBlocks.ICICLE.get(), this::createSilkTouchOnlyTable);
        dropSelf(RuBlocks.BARREL_CACTUS.get());
        dropSelf(RuBlocks.CAVE_HYSSOP.get());
        dropSelf(RuBlocks.DUCKWEED.get());
        add(RuBlocks.SPANISH_MOSS.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RuBlocks.SPANISH_MOSS_PLANT.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RuBlocks.KAPOK_VINES.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        add(RuBlocks.KAPOK_VINES_PLANT.get(), RuBlockLootTableProvider::createShearsOnlyDrop);
        dropSelf(RuBlocks.FLOWERING_LILY_PAD.get());
        add(RuBlocks.GIANT_LILY_PAD.get(), (block) -> createSingleItemTable(RuBlocks.FLOWERING_LILY_PAD.get()));
        //FOOD_PLANT_BLOCKS
        add(RuBlocks.SALMONBERRY_BUSH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE)))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE))))));

        /*-----------------POTTED_PLANTS-----------------*/
        add(RuBlocks.POTTED_ALPHA_DANDELION.get(), createPotFlowerItemTable(RuBlocks.ALPHA_DANDELION.get()));
        add(RuBlocks.POTTED_ALPHA_ROSE.get(), createPotFlowerItemTable(RuBlocks.ALPHA_ROSE.get()));
        add(RuBlocks.POTTED_ASTER.get(), createPotFlowerItemTable(RuBlocks.ASTER.get()));
        add(RuBlocks.POTTED_BLEEDING_HEART.get(), createPotFlowerItemTable(RuBlocks.BLEEDING_HEART.get()));
        add(RuBlocks.POTTED_DAISY.get(), createPotFlowerItemTable(RuBlocks.DAISY.get()));
        add(RuBlocks.POTTED_FELICIA_DAISY.get(), createPotFlowerItemTable(RuBlocks.FELICIA_DAISY.get()));
        add(RuBlocks.POTTED_DORCEL.get(), createPotFlowerItemTable(RuBlocks.DORCEL.get()));
        add(RuBlocks.POTTED_FIREWEED.get(), createPotFlowerItemTable(RuBlocks.FIREWEED.get()));
        add(RuBlocks.POTTED_GLISTERING_BLOOM.get(), createPotFlowerItemTable(RuBlocks.GLISTERING_BLOOM.get()));
        add(RuBlocks.POTTED_HIBISCUS.get(), createPotFlowerItemTable(RuBlocks.HIBISCUS.get()));
        add(RuBlocks.POTTED_HYSSOP.get(), createPotFlowerItemTable(RuBlocks.HYSSOP.get()));
        add(RuBlocks.POTTED_MALLOW.get(), createPotFlowerItemTable(RuBlocks.MALLOW.get()));
        add(RuBlocks.POTTED_POPPY_BUSH.get(), createPotFlowerItemTable(RuBlocks.POPPY_BUSH.get()));
        add(RuBlocks.POTTED_SALMON_POPPY_BUSH.get(), createPotFlowerItemTable(RuBlocks.SALMON_POPPY_BUSH.get()));
        add(RuBlocks.POTTED_TSUBAKI.get(), createPotFlowerItemTable(RuBlocks.TSUBAKI.get()));
        add(RuBlocks.POTTED_WARATAH.get(), createPotFlowerItemTable(RuBlocks.WARATAH.get()));
        add(RuBlocks.POTTED_WHITE_TRILLIUM.get(), createPotFlowerItemTable(RuBlocks.WHITE_TRILLIUM.get()));
        add(RuBlocks.POTTED_WILTING_TRILLIUM.get(), createPotFlowerItemTable(RuBlocks.WILTING_TRILLIUM.get()));
        add(RuBlocks.POTTED_BLUE_LUPINE.get(), createPotFlowerItemTable(RuBlocks.BLUE_LUPINE.get()));
        add(RuBlocks.POTTED_PINK_LUPINE.get(), createPotFlowerItemTable(RuBlocks.PINK_LUPINE.get()));
        add(RuBlocks.POTTED_PURPLE_LUPINE.get(), createPotFlowerItemTable(RuBlocks.PURPLE_LUPINE.get()));
        add(RuBlocks.POTTED_RED_LUPINE.get(), createPotFlowerItemTable(RuBlocks.RED_LUPINE.get()));
        add(RuBlocks.POTTED_YELLOW_LUPINE.get(), createPotFlowerItemTable(RuBlocks.YELLOW_LUPINE.get()));
        add(RuBlocks.POTTED_ORANGE_CONEFLOWER.get(), createPotFlowerItemTable(RuBlocks.ORANGE_CONEFLOWER.get()));
        add(RuBlocks.POTTED_PURPLE_CONEFLOWER.get(), createPotFlowerItemTable(RuBlocks.PURPLE_CONEFLOWER.get()));
        for (Map.Entry<DyeColor, Block> entry : RuBlocks.POTTED_SNOWBELLES.getMap().entrySet()) {
            add(entry.getValue(), createPotFlowerItemTable(RuBlocks.SNOWBELLES.getMap().get(entry.getKey())));
        }
        add(RuBlocks.POTTED_DAY_LILY.get(), createPotFlowerItemTable(RuBlocks.DAY_LILY.get()));
        add(RuBlocks.POTTED_MEADOW_SAGE.get(), createPotFlowerItemTable(RuBlocks.MEADOW_SAGE.get()));
        add(RuBlocks.POTTED_CAVE_HYSSOP.get(), createPotFlowerItemTable(RuBlocks.CAVE_HYSSOP.get()));
        add(RuBlocks.POTTED_BARREL_CACTUS.get(), createPotFlowerItemTable(RuBlocks.BARREL_CACTUS.get()));
        add(RuBlocks.POTTED_DUSKTRAP.get(), createPotFlowerItemTable(RuBlocks.DUSKTRAP.get()));
        add(RuBlocks.POTTED_CORPSE_FLOWER.get(), createPotFlowerItemTable(RuBlocks.CORPSE_FLOWER.get()));
        add(RuBlocks.POTTED_COBALT_EARLIGHT.get(), createPotFlowerItemTable(RuBlocks.COBALT_EARLIGHT.get()));
        add(RuBlocks.POTTED_TALL_COBALT_EARLIGHT.get(), createPotFlowerItemTable(RuBlocks.TALL_COBALT_EARLIGHT.get()));
        add(RuBlocks.POTTED_MYCOTOXIC_DAISY.get(), createPotFlowerItemTable(RuBlocks.MYCOTOXIC_DAISY.get()));
        add(RuBlocks.POTTED_GLISTER_SPIRE.get(), createPotFlowerItemTable(RuBlocks.GLISTER_SPIRE.get()));
        add(RuBlocks.POTTED_BLUE_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.BLUE_BIOSHROOM.get()));
        add(RuBlocks.POTTED_GREEN_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.GREEN_BIOSHROOM.get()));
        add(RuBlocks.POTTED_PINK_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.PINK_BIOSHROOM.get()));
        add(RuBlocks.POTTED_YELLOW_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.YELLOW_BIOSHROOM.get()));
        add(RuBlocks.POTTED_TALL_BLUE_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.TALL_BLUE_BIOSHROOM.get()));
        add(RuBlocks.POTTED_TALL_GREEN_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.TALL_GREEN_BIOSHROOM.get()));
        add(RuBlocks.POTTED_TALL_PINK_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.TALL_PINK_BIOSHROOM.get()));
        add(RuBlocks.POTTED_TALL_YELLOW_BIOSHROOM.get(), createPotFlowerItemTable(RuBlocks.TALL_YELLOW_BIOSHROOM.get()));
        add(RuBlocks.ASHEN_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.ASHEN_NATURAL_SET.getSapling()));
        add(RuBlocks.ALPHA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.ALPHA_NATURAL_SET.getSapling()));
        add(RuBlocks.APPLE_OAK_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.APPLE_OAK_NATURAL_SET.getSapling()));
        add(RuBlocks.BAMBOO_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.BAMBOO_NATURAL_SET.getSapling()));
        add(RuBlocks.BAOBAB_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.BAOBAB_NATURAL_SET.getSapling()));
        add(RuBlocks.BLACKWOOD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.BLACKWOOD_NATURAL_SET.getSapling()));
        add(RuBlocks.BRIMWOOD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.BRIMWOOD_NATURAL_SET.getSapling()));
        add(RuBlocks.COBALT_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.COBALT_NATURAL_SET.getSapling()));
        add(RuBlocks.CACTUS_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.CACTUS_NATURAL_SET.getSapling()));
        add(RuBlocks.MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.MAGNOLIA_NATURAL_SET.getSapling()));
        add(RuBlocks.CYPRESS_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.CYPRESS_NATURAL_SET.getSapling()));
        add(RuBlocks.DEAD_PINE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.DEAD_PINE_NATURAL_SET.getSapling()));
        add(RuBlocks.DEAD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.DEAD_NATURAL_SET.getSapling()));
        add(RuBlocks.EUCALYPTUS_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.EUCALYPTUS_NATURAL_SET.getSapling()));
        add(RuBlocks.FLOWERING_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.FLOWERING_NATURAL_SET.getSapling()));
        add(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling()));
        add(RuBlocks.JOSHUA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.JOSHUA_NATURAL_SET.getSapling()));
        add(RuBlocks.KAPOK_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.KAPOK_NATURAL_SET.getSapling()));
        add(RuBlocks.LARCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.LARCH_NATURAL_SET.getSapling()));
        add(RuBlocks.MAPLE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.MAPLE_NATURAL_SET.getSapling()));
        add(RuBlocks.MAUVE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.MAUVE_NATURAL_SET.getSapling()));
        add(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling()));
        add(RuBlocks.PALM_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.PALM_NATURAL_SET.getSapling()));
        add(RuBlocks.PINE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.PINE_NATURAL_SET.getSapling()));
        add(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling()));
        add(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling()));
        add(RuBlocks.REDWOOD_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.REDWOOD_NATURAL_SET.getSapling()));
        add(RuBlocks.RED_MAPLE_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.RED_MAPLE_NATURAL_SET.getSapling()));
        add(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling()));
        add(RuBlocks.SILVER_BIRCH_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.SILVER_BIRCH_NATURAL_SET.getSapling()));
        add(RuBlocks.SMALL_OAK_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.SMALL_OAK_NATURAL_SET.getSapling()));
        add(RuBlocks.SOCOTRA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.SOCOTRA_NATURAL_SET.getSapling()));
        add(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling()));
        add(RuBlocks.WILLOW_NATURAL_SET.getPottedSapling(), createPotFlowerItemTable(RuBlocks.WILLOW_NATURAL_SET.getSapling()));

        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        add(RuBlocks.BLUE_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.BLUE_BIOSHROOM.get()));
        add(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.BLUE_BIOSHROOM.get()));
        add(RuBlocks.GREEN_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.GREEN_BIOSHROOM.get()));
        add(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.GREEN_BIOSHROOM.get()));
        add(RuBlocks.PINK_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.PINK_BIOSHROOM.get()));
        add(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.PINK_BIOSHROOM.get()));
        add(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.YELLOW_BIOSHROOM.get()));
        add(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(), (block) -> createMushroomBlockDrop(block, RuBlocks.YELLOW_BIOSHROOM.get()));
        //BAMBOO
        dropSelf(RuBlocks.BAMBOO_LOG.get());
        dropSelf(RuBlocks.STRIPPED_BAMBOO_LOG.get());
        //OAK
        dropSelf(RuBlocks.SMALL_OAK_LOG.get());
        dropSelf(RuBlocks.STRIPPED_SMALL_OAK_LOG.get());
        //CACTUS
        dropSelf(RuBlocks.SAGUARO_CACTUS.get());

        /*-----------------LEAVES-----------------*/
        add(RuBlocks.ALPHA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.APPLE_OAK_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.APPLE_OAK_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ASHEN_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.ASHEN_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAMBOO_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.BAMBOO_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAOBAB_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.BAOBAB_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLACKWOOD_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.BLACKWOOD_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.COBALT_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.COBALT_NATURAL_SET.getSapling(), COBALT_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.CYPRESS_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.CYPRESS_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.DEAD_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_PINE_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.DEAD_PINE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.EUCALYPTUS_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.EUCALYPTUS_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.FLOWERING_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.FLOWERING_NATURAL_SET.getSapling(), FLOWERING_OAK_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.GOLDEN_LARCH_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.JOSHUA_NATURAL_SET.getLeaves(), (block) -> createDoublePlantWithSeedDropsNoGrass(block, RuBlocks.JOSHUA_NATURAL_SET.getLeaves(), RuBlocks.JOSHUA_NATURAL_SET.getSapling(), JOSHUA_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.KAPOK_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.KAPOK_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.LARCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.LARCH_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAPLE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.MAPLE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAUVE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.MAUVE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.ORANGE_MAPLE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PALM_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.PALM_NATURAL_SET.getSapling(), PALM_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINE_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.PINE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.REDWOOD_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.REDWOOD_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.RED_MAPLE_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.RED_MAPLE_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BRIMWOOD_NATURAL_SET.getLeaves(), (block) -> createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(RuBlocks.BRIMWOOD_NATURAL_SET.getSapling())).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_SAPLING_CHANCES))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)));
        add(RuBlocks.SILVER_BIRCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.SILVER_BIRCH_NATURAL_SET.getSapling(), ASPEN_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SMALL_OAK_NATURAL_SET.getLeaves(), (block) -> createOakLeavesDrops(block, RuBlocks.SMALL_OAK_NATURAL_SET.getSapling(), SMALL_OAK_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SOCOTRA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.SOCOTRA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getSapling(), ASPEN_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WILLOW_NATURAL_SET.getLeaves(), (block) -> createLeavesDrops(block, RuBlocks.WILLOW_NATURAL_SET.getSapling(), NORMAL_LEAVES_SAPLING_CHANCES));

        /*-----------------BRANCHES-----------------*/
        add(RuBlocks.ACACIA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BAOBAB_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BIRCH_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BLACKWOOD_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAGNOLIA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CYPRESS_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CHERRY_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DARK_OAK_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DEAD_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.EUCALYPTUS_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JOSHUA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JUNGLE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.KAPOK_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.LARCH_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MANGROVE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAPLE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAUVE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.OAK_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PALM_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PINE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.REDWOOD_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SILVER_BIRCH_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SOCOTRA_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SPRUCE_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.WILLOW_NATURAL_SET.getBranch(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));

        /*-----------------DIRT_BLOCKS-----------------*/
        //FOREST_DIRT_BLOCKS
        add(RuBlocks.PEAT_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT.get()));
        dropSelf(RuBlocks.PEAT_DIRT.get());
        add(RuBlocks.PEAT_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT.get()));
        dropSelf(RuBlocks.PEAT_COARSE_DIRT.get());
        dropSelf(RuBlocks.PEAT_PODZOL.get());
        dropSelf(RuBlocks.PEAT_MUD.get());
        add(RuBlocks.PEAT_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT.get()));
        //PLAINS_DIRT_BLOCKS
        add(RuBlocks.SILT_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT.get()));
        dropSelf(RuBlocks.SILT_DIRT.get());
        add(RuBlocks.SILT_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT.get()));
        dropSelf(RuBlocks.SILT_COARSE_DIRT.get());
        dropSelf(RuBlocks.SILT_PODZOL.get());
        dropSelf(RuBlocks.SILT_MUD.get());
        add(RuBlocks.SILT_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT.get()));
        //OTHER_DIRT_BLOCKS
        add(RuBlocks.ALPHA_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        dropSelf(RuBlocks.ASHEN_DIRT.get());

        /*-----------------STONE_BLOCKS-----------------*/
        //CHALKS
        dropSelf(RuBlocks.CHALK.get());
        add(RuBlocks.CHALK_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.CHALK.get()));
        dropSelf(RuBlocks.CHALK_BRICKS.get());
        add(RuBlocks.CHALK_BRICK_SLAB.get(), this::createSlabItemTable);
        dropSelf(RuBlocks.CHALK_BRICK_STAIRS.get());
        dropSelf(RuBlocks.CHALK_PILLAR.get());
        add(RuBlocks.CHALK_SLAB.get(), this::createSlabItemTable);
        dropSelf(RuBlocks.CHALK_STAIRS.get());
        dropSelf(RuBlocks.POLISHED_CHALK.get());
        add(RuBlocks.POLISHED_CHALK_SLAB.get(), this::createSlabItemTable);
        dropSelf(RuBlocks.POLISHED_CHALK_STAIRS.get());
        //STONES
        dropSelf(RuBlocks.ARGILLITE.get());
        add(RuBlocks.MOSSY_STONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.MOSSY_COBBLESTONE));

        /*-----------------OCEAN_BLOCKS-----------------*/
        //HYACINTH_BLOCKS
        dropSelf(RuBlocks.HYACINTH_LAMP.get());
        dropSelf(RuBlocks.HYACINTH_BLOOM.get());
        add(RuBlocks.HYACINTH_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        dropSelf(RuBlocks.TALL_HYACINTH_STOCK.get());

        /*-----------------OTHER_BLOCKS-----------------*/
        add(RuBlocks.ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.SILK_TOUCH), 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        add(RuBlocks.VOLCANIC_ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.SILK_TOUCH), 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        dropSelf(RuBlocks.ASH_VENT.get());

        /*-----------------WOOD_TYPES-----------------*/
        for (WoodSet set : RuBlocks.WOOD_SETS) {
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
        add(RuBlocks.BRIMWOOD_WOOD_SET.getLogMagma(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.BRIMWOOD_WOOD_SET.getLog()));

        /*-----------------PAINTED PLANKS-----------------*/
        for (Block block : RuBlocks.PAINTED_PLANKS.getAll()) {
            dropSelf(block);
        }
        for (Block block : RuBlocks.PAINTED_STAIRS.getAll()) {
            dropSelf(block);
        }
        for (Block block : RuBlocks.PAINTED_SLABS.getAll()) {
            add(block, this::createSlabItemTable);
        }

        /*-----------------NETHER_BLOCKS-----------------*/
        //NETHER_STONES
        dropSelf(RuBlocks.BLACKSTONE_CLUSTER.get());
        add(RuBlocks.OVERGROWN_BONE_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BONE_BLOCK));
        //BRIMSPROUT_BLOCKS
        add(RuBlocks.BRIMSPROUT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.BRIMSPROUT.get());
        //COBALT_BLOCKS
        dropSelf(RuBlocks.COBALT_EARLIGHT.get());
        add(RuBlocks.TALL_COBALT_EARLIGHT.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.COBALT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.BLACKSTONE));
        dropSelf(RuBlocks.COBALT_OBSIDIAN.get());
        dropSelf(RuBlocks.COBALT_ROOTS.get());
        add(RuBlocks.HANGING_EARLIGHT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.66F, 0.78F, 0.9F, 1.0F))));
        add(RuBlocks.HANGING_EARLIGHT_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.66F, 0.78F, 0.9F, 1.0F))));
        //GLISTERING_BLOCKS
        add(RuBlocks.GLISTERING_IVY.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_IVY_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(registries.holderOrThrow(Enchantments.FORTUNE), 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.GLISTERING_SPROUT.get());
        dropSelf(RuBlocks.GLISTERING_BLOOM.get());
        dropSelf(RuBlocks.GLISTERING_FERN.get());
        dropSelf(RuBlocks.GLISTERING_WART.get());
        add(RuBlocks.GLISTER_BULB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GLISTER_SPIRE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MYCOTOXIC_BLOCKS
        add(RuBlocks.MYCOTOXIC_MUSHROOMS.get(), this::createPetalsDrops);
        add(RuBlocks.MYCOTOXIC_DAISY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(RuBlocks.MYCOTOXIC_GRASS.get());
        add(RuBlocks.MYCOTOXIC_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.entrySet().stream().filter(entry -> entry.getKey().location().getNamespace().contains(RegionsUnexplored.MOD_ID)).map(Map.Entry::getValue).toList();
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
