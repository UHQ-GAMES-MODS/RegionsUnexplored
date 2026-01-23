package net.regions_unexplored.block;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.block.sapling.RuTreeGrowers;
import net.regions_unexplored.block.set.BrimwoodWoodSet;
import net.regions_unexplored.block.set.ColoredSet;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.data.block.RuWoodTypes;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;
import net.regions_unexplored.registry.BlockRegistry;
import net.regions_unexplored.world.level.block.alpha.*;
import net.regions_unexplored.world.level.block.cave.*;
import net.regions_unexplored.world.level.block.forest_dirt.*;
import net.regions_unexplored.world.level.block.leaves.*;
import net.regions_unexplored.world.level.block.nether.*;
import net.regions_unexplored.world.level.block.other.*;
import net.regions_unexplored.world.level.block.other_dirt.*;
import net.regions_unexplored.world.level.block.plains_dirt.*;
import net.regions_unexplored.world.level.block.plant.aquatic.*;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock.BranchType;
import net.regions_unexplored.world.level.block.plant.flower.*;
import net.regions_unexplored.world.level.block.plant.food.*;
import net.regions_unexplored.world.level.block.plant.grass.*;
import net.regions_unexplored.world.level.block.plant.nether.*;
import net.regions_unexplored.world.level.block.plant.other.*;
import net.regions_unexplored.world.level.block.plant.sapling.*;
import net.regions_unexplored.world.level.block.plant.tall.*;
import net.regions_unexplored.world.level.block.wood.*;
import net.regions_unexplored.world.level.block.plant.dusktrap.DuskTrapBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class RuBlocks {
    public static final Supplier<Block> PRISMOSS = BlockRegistry.registerDefaultBlock("prismoss", () -> new PrismossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).randomTicks().strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> DEEPSLATE_PRISMOSS = BlockRegistry.registerDefaultBlock("deepslate_prismoss", () -> new PrismossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.DEEPSLATE).randomTicks().strength(3f, 6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> HANGING_PRISMARITE = BlockRegistry.registerDefaultBlock("hanging_prismarite", () -> new HangingPrismariteBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).sound(SoundType.AMETHYST).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    public static final Supplier<Block> LARGE_PRISMARITE_CLUSTER = BlockRegistry.registerDefaultBlock("large_prismarite_cluster", () -> new PrismariteDoubleBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().sound(SoundType.AMETHYST).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    public static final Supplier<Block> PRISMAGLASS = BlockRegistry.registerDefaultBlock("prismaglass", () -> new GrassBlock(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never)));
    public static final Supplier<Block> PRISMARITE_CLUSTER = BlockRegistry.registerDefaultBlock("prismarite_cluster", () -> new PrismariteBlock(BlockBehaviour.Properties.of().noCollission().noOcclusion().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    public static final Supplier<Block> PRISMOSS_SPROUT = BlockRegistry.registerDefaultBlock("prismoss_sprout", () -> new PrismossSproutBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    //REDSTONE_BLOCKS
    public static final Supplier<Block> POINTED_REDSTONE = BlockRegistry.registerDefaultBlock("pointed_redstone", () -> new PointedRedstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noOcclusion().sound(SoundType.POINTED_DRIPSTONE).randomTicks().strength(1.5F, 3.0F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(s -> 1).isRedstoneConductor(BlockRegistry::always)));
    public static final Supplier<Block> RAW_REDSTONE_BLOCK = BlockRegistry.registerDefaultBlock("raw_redstone_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(1.5f).requiresCorrectToolForDrops().isRedstoneConductor(BlockRegistry::always)));
    public static final Supplier<Block> REDSTONE_BUD = BlockRegistry.registerDefaultBlock("redstone_bud", () -> new RedstoneBudBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().mapColor(MapColor.COLOR_RED).noCollission().sound(SoundType.TUFF).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> REDSTONE_BULB = BlockRegistry.registerDefaultBlock("redstone_bulb", () -> new RedstoneBulbBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().sound(SoundType.AMETHYST).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 12).isRedstoneConductor(BlockRegistry::never)));
    //OTHER_CAVE_BLOCKS
    public static final Supplier<Block> ARGILLITE_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("argillite_grass_block", () -> new ArgilliteGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.STONE).randomTicks().strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> STONE_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("stone_grass_block", () -> new StoneGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.STONE).randomTicks().strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> DEEPSLATE_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("deepslate_grass_block", () -> new DeepslateGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.DEEPSLATE).randomTicks().strength(3f, 6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> VIRIDESCENT_NYLIUM = BlockRegistry.registerDefaultBlock("viridescent_nylium", () -> new ViridescentNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.NYLIUM).strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> DEEPSLATE_VIRIDESCENT_NYLIUM = BlockRegistry.registerDefaultBlock("deepslate_viridescent_nylium", () -> new ViridescentNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.NYLIUM).strength(3f, 6f).requiresCorrectToolForDrops()));

    public static final Supplier<Block> CORPSE_FLOWER = BlockRegistry.registerDefaultBlock("corpse_flower", () -> new CorpseFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER).sound(SoundType.FLOWERING_AZALEA)));
    public static final Supplier<Block> BLADED_GRASS = BlockRegistry.registerDefaultBlock("bladed_grass", () -> new RuPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).sound(SoundType.AZALEA)));
    public static final Supplier<Block> BLADED_TALL_GRASS = BlockRegistry.registerDefaultBlock("bladed_tall_grass", () -> new RuDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).sound(SoundType.AZALEA)));
    public static final Supplier<Block> DROPLEAF = BlockRegistry.registerDefaultBlock("dropleaf", () -> new DropleafBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 14)));
    public static final Supplier<Block> DROPLEAF_PLANT = BlockRegistry.registerDefaultBlockNoItem("dropleaf_plant", () -> new DropleafPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.WEEPING_VINES).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> DUSKMELON = BlockRegistry.registerDefaultBlockNoItem("duskmelon", () -> new DuskmelonBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.AZALEA)));
    public static final Supplier<Block> DUSKTRAP = BlockRegistry.registerDefaultBlock("dusktrap", () -> new DuskTrapBlock(DuskTrapBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.TWISTING_VINES)));
    /*-----------------PLANTS-----------------*/
    //GRASS_BLOCKS
    public static final Supplier<Block> DEAD_STEPPE_SHRUB = BlockRegistry.registerDefaultBlock("dead_steppe_shrub", () -> new DeadShrubBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().replaceable().mapColor(MapColor.WOOD).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> FROZEN_GRASS = BlockRegistry.registerDefaultBlock("frozen_grass", () -> new RuSnowyPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    public static final Supplier<Block> MEDIUM_GRASS = BlockRegistry.registerDefaultBlock("medium_grass", () -> new RuPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    public static final Supplier<Block> SANDY_GRASS = BlockRegistry.registerDefaultBlock("sandy_grass", () -> new RuSandyPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    public static final Supplier<Block> SMALL_DESERT_SHRUB = BlockRegistry.registerDefaultBlock("small_desert_shrub", () -> new DeadShrubBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH)));
    public static final Supplier<Block> STEPPE_GRASS = BlockRegistry.registerDefaultBlock("steppe_grass", () -> new RuPlantBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> STEPPE_SHRUB = BlockRegistry.registerDefaultBlock("steppe_shrub", () -> new RuPlantBlock(BlockBehaviour.Properties.ofFullCopy(STEPPE_GRASS.get())));
    public static final Supplier<Block> STONE_BUD = BlockRegistry.registerDefaultBlock("stone_bud", () -> new RuStonePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    //TALL_GRASS_BLOCKS
    public static final Supplier<Block> ELEPHANT_EAR = BlockRegistry.registerDefaultBlock("elephant_ear", () -> new ElephantEarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> SANDY_TALL_GRASS = BlockRegistry.registerDefaultBlock("sandy_tall_grass", () -> new RuSandyDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> STEPPE_TALL_GRASS = BlockRegistry.registerDefaultBlock("steppe_tall_grass", () -> new RuDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WINDSWEPT_GRASS = BlockRegistry.registerDefaultBlock("windswept_grass", () -> new RuDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    //FLOWERS
    public static final Supplier<Block> ALPHA_DANDELION = BlockRegistry.registerDefaultBlock("alpha_dandelion", () -> new RuFlowerBlock(MobEffects.JUMP, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> ALPHA_ROSE = BlockRegistry.registerDefaultBlock("alpha_rose", () -> new RuFlowerBlock(MobEffects.JUMP, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> ASTER = BlockRegistry.registerDefaultBlock("aster", () -> new RuFlowerBlock(MobEffects.CONFUSION, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 13)));
    public static final Supplier<Block> BLEEDING_HEART = BlockRegistry.registerDefaultBlock("bleeding_heart", () -> new RuSnowFlowerBlock(MobEffects.POISON, 9, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> BLUE_LUPINE = BlockRegistry.registerDefaultBlock("blue_lupine", () -> new RuFlowerBlock(MobEffects.SATURATION, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> DAISY = BlockRegistry.registerDefaultBlock("daisy", () -> new RuFlowerBlock(MobEffects.MOVEMENT_SPEED, 8, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> DORCEL = BlockRegistry.registerDefaultBlock("dorcel", () -> new DorcelPlantBlock(MobEffects.WITHER, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).speedFactor(0.5F)));
    public static final Supplier<Block> FELICIA_DAISY = BlockRegistry.registerDefaultBlock("felicia_daisy", () -> new RuFlowerBlock(MobEffects.MOVEMENT_SPEED, 8, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> FIREWEED = BlockRegistry.registerDefaultBlock("fireweed", () -> new RuFlowerBlock(MobEffects.GLOWING, 2, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> HIBISCUS = BlockRegistry.registerDefaultBlock("hibiscus", () -> new RuFlowerBlock(MobEffects.JUMP, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> HYSSOP = BlockRegistry.registerDefaultBlock("hyssop", () -> new RuFlowerBlock(MobEffects.LUCK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> MALLOW = BlockRegistry.registerDefaultBlock("mallow", () -> new RuFlowerBlock(MobEffects.DIG_SLOWDOWN, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> PINK_LUPINE = BlockRegistry.registerDefaultBlock("pink_lupine", () -> new RuFlowerBlock(MobEffects.SATURATION, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> POPPY_BUSH = BlockRegistry.registerDefaultBlock("poppy_bush", () -> new RuFlowerBlock(MobEffects.WEAKNESS, 3, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> SALMON_POPPY_BUSH = BlockRegistry.registerDefaultBlock("salmon_poppy_bush", () -> new RuFlowerBlock(MobEffects.WEAKNESS, 3, BlockBehaviour.Properties.ofFullCopy(POPPY_BUSH.get())));
    public static final Supplier<Block> PURPLE_LUPINE = BlockRegistry.registerDefaultBlock("purple_lupine", () -> new RuFlowerBlock(MobEffects.SATURATION, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> RED_LUPINE = BlockRegistry.registerDefaultBlock("red_lupine", () -> new RuFlowerBlock(MobEffects.SATURATION, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> WARATAH = BlockRegistry.registerDefaultBlock("waratah", () -> new RuFlowerBlock(MobEffects.JUMP, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> TSUBAKI = BlockRegistry.registerDefaultBlock("tsubaki", () -> new RuFlowerBlock(MobEffects.HEAL, 3, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> WHITE_TRILLIUM = BlockRegistry.registerDefaultBlock("white_trillium", () -> new RuFlowerBlock(MobEffects.DIG_SPEED, 7, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> WILTING_TRILLIUM = BlockRegistry.registerDefaultBlock("wilting_trillium", () -> new RuFlowerBlock(MobEffects.DIG_SLOWDOWN, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final Supplier<Block> YELLOW_LUPINE = BlockRegistry.registerDefaultBlock("yellow_lupine", () -> new RuFlowerBlock(MobEffects.SATURATION, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));

    public static final Supplier<Block> ORANGE_CONEFLOWER = BlockRegistry.registerDefaultBlock("orange_coneflower", () -> new GroundCoverBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().sound(SoundType.PINK_PETALS)));
    public static final Supplier<Block> PURPLE_CONEFLOWER = BlockRegistry.registerDefaultBlock("purple_coneflower", () -> new GroundCoverBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().sound(SoundType.PINK_PETALS)));
    public static final Supplier<Block> CLOVER = BlockRegistry.registerDefaultBlock("clover", () -> new GroundCoverBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.PINK_PETALS)));

    public static final Supplier<Block> BLUE_MAGNOLIA_FLOWERS = BlockRegistry.registerDefaultBlock("blue_magnolia_flowers", () -> new GlowLichenBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().replaceable().noCollission().strength(0.1F).sound(SoundType.GLOW_LICHEN)));
    public static final Supplier<Block> PINK_MAGNOLIA_FLOWERS = BlockRegistry.registerDefaultBlock("pink_magnolia_flowers", () -> new GlowLichenBlock(BlockBehaviour.Properties.ofFullCopy(BLUE_MAGNOLIA_FLOWERS.get())));
    public static final Supplier<Block> WHITE_MAGNOLIA_FLOWERS = BlockRegistry.registerDefaultBlock("white_magnolia_flowers", () -> new GlowLichenBlock(BlockBehaviour.Properties.ofFullCopy(BLUE_MAGNOLIA_FLOWERS.get())));
    //SNOWBELLE

    public static final Supplier<Block> MAPLE_LEAF_PILE = BlockRegistry.registerDefaultBlock("maple_leaf_pile", () -> new RULeafLitterBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    public static final Supplier<Block> RED_MAPLE_LEAF_PILE = BlockRegistry.registerDefaultBlock("red_maple_leaf_pile", () -> new RULeafLitterBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    public static final Supplier<Block> ORANGE_MAPLE_LEAF_PILE = BlockRegistry.registerDefaultBlock("orange_maple_leaf_pile", () -> new RULeafLitterBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    public static final Supplier<Block> SILVER_BIRCH_LEAF_PILE = BlockRegistry.registerDefaultBlock("silver_birch_leaf_pile", () -> new RULeafLitterBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    public static final Supplier<Block> ENCHANTED_BIRCH_LEAF_PILE = BlockRegistry.registerDefaultBlock("enchanted_birch_leaf_pile", () -> new RULeafLitterBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    //TALL_PLANTS
    public static final Supplier<Block> MEADOW_SAGE = BlockRegistry.registerDefaultBlockNoItem("meadow_sage", () -> new RuDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH)));
    public static final Supplier<Block> BARLEY = BlockRegistry.registerDefaultBlock("barley", () -> new RuDoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER)));
    public static final Supplier<Block> CATTAIL = BlockRegistry.registerDefaultBlock("cattail", () -> new CattailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER)));
    public static final Supplier<Block> TASSEL = BlockRegistry.registerDefaultBlock("tassel", () -> new RuDoubleFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER)));
    public static final Supplier<Block> DAY_LILY = BlockRegistry.registerDefaultBlock("day_lily", () -> new RuDoubleFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER)));
    //SAPLINGS

    // NATURAL SETS
    public static final List<NaturalSet> NATURAL_SETS = new ArrayList<>();
    /* VANILLA */
    public static final NaturalSet ACACIA_NATURAL_SET = NaturalSet.vanilla("acacia");
    public static final NaturalSet BIRCH_NATURAL_SET = NaturalSet.vanilla("birch");
    public static final NaturalSet CHERRY_NATURAL_SET = NaturalSet.vanilla("cherry");
    public static final NaturalSet DARK_OAK_NATURAL_SET = NaturalSet.vanilla("dark_oak");
    public static final NaturalSet JUNGLE_NATURAL_SET = NaturalSet.vanilla("jungle");
    public static final NaturalSet MANGROVE_NATURAL_SET = NaturalSet.vanilla("mangrove");
    public static final NaturalSet OAK_NATURAL_SET = NaturalSet.vanilla("oak");
    //public static final NaturalSet PALE_OAK_NATURAL_SET = NaturalSet.vanilla("pale_oak");
    public static final NaturalSet SPRUCE_NATURAL_SET = NaturalSet.vanilla("spruce");
    /* MODDED */
    public static final NaturalSet ALPHA_NATURAL_SET = NaturalSet.leavesAndSaplings("alpha", LeavesBlock::new, RuTreeGrowers.ALPHA_OAK);
    public static final NaturalSet APPLE_OAK_NATURAL_SET = NaturalSet.leavesAndSaplings("apple_oak", AppleLeavesBlock::new, RuTreeGrowers.APPLE_OAK);
    public static final NaturalSet ASHEN_NATURAL_SET = NaturalSet.ashen();
    public static final NaturalSet BAMBOO_NATURAL_SET = NaturalSet.leavesAndSaplings("bamboo", LeavesBlock::new, RuTreeGrowers.BAMBOO);
    public static final NaturalSet BAOBAB_NATURAL_SET = NaturalSet.full("baobab", MapColor.PLANT, BranchType.BRANCH, false, properties -> new RuUltraFromMegaSaplingBlock(RuTreeGrowers.BAOBAB, properties));
    public static final NaturalSet BLACKWOOD_NATURAL_SET = NaturalSet.full("blackwood", MapColor.TERRACOTTA_GREEN, BranchType.BRANCH, false, RuTreeGrowers.BLACKWOOD);
    public static final NaturalSet BLUE_MAGNOLIA_NATURAL_SET = NaturalSet.fullWithoutBranch("blue_magnolia", false, () -> BlockRegistry.leaves(MapColor.COLOR_LIGHT_BLUE, false, BlueMagnoliaLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.BLUE_MAGNOLIA, properties));
    public static final NaturalSet BRIMWOOD_NATURAL_SET = NaturalSet.fullWithoutBranch("brimwood", false, () -> BlockRegistry.leaves(MapColor.COLOR_BROWN, false, p -> new BrimwoodLeavesBlock()), properties -> new RuBrimSaplingBlock(RuTreeGrowers.BRIMWOOD, properties));
    public static final NaturalSet CACTUS_NATURAL_SET = NaturalSet.onlySapling("cactus_flower", () -> new RuCactusSaplingBlock(RuTreeGrowers.SAGUARO_CACTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final NaturalSet COBALT_NATURAL_SET = NaturalSet.cobalt();
    public static final NaturalSet CYPRESS_NATURAL_SET = NaturalSet.full("cypress", RuTreeGrowers.CYPRESS);
    public static final NaturalSet DEAD_PINE_NATURAL_SET = NaturalSet.fullWithoutBranch("dead_pine", MapColor.TERRACOTTA_GRAY, true, RuTreeGrowers.DEAD_PINE);
    public static final NaturalSet DEAD_NATURAL_SET = NaturalSet.full("dead", MapColor.TERRACOTTA_GRAY, BranchType.BRANCH, true, RuTreeGrowers.DEAD);
    public static final NaturalSet ENCHANTED_BIRCH_NATURAL_SET = NaturalSet.fullWithoutBranch("enchanted_birch", MapColor.COLOR_LIGHT_BLUE, false, RuTreeGrowers.ENCHANTED_BIRCH);
    public static final NaturalSet EUCALYPTUS_NATURAL_SET = NaturalSet.full("eucalyptus", RuTreeGrowers.EUCALYPTUS);
    public static final NaturalSet FLOWERING_NATURAL_SET = NaturalSet.fullWithoutBranch("flowering", MapColor.PLANT, false, RuTreeGrowers.FLOWERING_OAK);
    public static final NaturalSet GOLDEN_LARCH_NATURAL_SET = NaturalSet.fullWithoutBranch("golden_larch", MapColor.PLANT, false, RuTreeGrowers.GOLDEN_LARCH);
    public static final NaturalSet JOSHUA_NATURAL_SET = NaturalSet.full("joshua", BranchType.BEARD, false, () -> BlockRegistry.leaves(MapColor.PLANT, false, JoshuaLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.JOSHUA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final NaturalSet KAPOK_NATURAL_SET = NaturalSet.full("kapok", MapColor.PLANT, BranchType.BRANCH, false, properties -> new RuUltraFromSuperSaplingBlock(RuTreeGrowers.KAPOK, properties));
    public static final NaturalSet LARCH_NATURAL_SET = NaturalSet.full("larch", RuTreeGrowers.LARCH);
    public static final NaturalSet MAGNOLIA_NATURAL_SET = NaturalSet.full("magnolia", RuTreeGrowers.MAGNOLIA);
    public static final NaturalSet MAPLE_NATURAL_SET = NaturalSet.full("maple", RuTreeGrowers.MAPLE);
    public static final NaturalSet MAUVE_NATURAL_SET = NaturalSet.full("mauve", BranchType.BRANCH, false, () -> BlockRegistry.leaves(MapColor.COLOR_PURPLE, false, MauveLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.MAUVE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final NaturalSet ORANGE_MAPLE_NATURAL_SET = NaturalSet.fullWithoutBranch("orange_maple", false, () -> BlockRegistry.leaves(MapColor.COLOR_ORANGE, false, OrangeMapleLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.ORANGE_MAPLE, properties));
    public static final NaturalSet PALM_NATURAL_SET = NaturalSet.full("palm", MapColor.PLANT, BranchType.BEARD, false, RuTreeGrowers.PALM);
    public static final NaturalSet PINE_NATURAL_SET = NaturalSet.full("pine", RuTreeGrowers.PINE);
    public static final NaturalSet PINK_MAGNOLIA_NATURAL_SET = NaturalSet.fullWithoutBranch("pink_magnolia", false, () -> BlockRegistry.leaves(MapColor.COLOR_PINK, false, PinkMagnoliaLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.PINK_MAGNOLIA, properties));
    public static final NaturalSet RED_MAPLE_NATURAL_SET = NaturalSet.fullWithoutBranch("red_maple", false, () -> BlockRegistry.leaves(MapColor.COLOR_RED, false, RedMapleLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.RED_MAPLE, properties));
    public static final NaturalSet REDWOOD_NATURAL_SET = NaturalSet.full("redwood", MapColor.PLANT, BranchType.BRANCH, false, properties -> new RuUltraFromSuperSaplingBlock(RuTreeGrowers.REDWOOD, properties));
    public static final NaturalSet SILVER_BIRCH_NATURAL_SET = NaturalSet.full("silver_birch", BranchType.BRANCH, false, () -> BlockRegistry.leaves(MapColor.COLOR_YELLOW, false, SilverBirchLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.SILVER_BIRCH, properties));
    public static final NaturalSet SMALL_OAK_NATURAL_SET = NaturalSet.leavesAndSaplings("small_oak", LeavesBlock::new, RuTreeGrowers.SMALL_OAK);
    public static final NaturalSet SOCOTRA_NATURAL_SET = NaturalSet.full("socotra", RuTreeGrowers.SOCOTRA);
    public static final NaturalSet WHITE_MAGNOLIA_NATURAL_SET = NaturalSet.fullWithoutBranch("white_magnolia", false, () -> BlockRegistry.leaves(MapColor.TERRACOTTA_WHITE, false, WhiteMagnoliaLeavesBlock::new), properties -> new SaplingBlock(RuTreeGrowers.WHITE_MAGNOLIA, properties));
    public static final NaturalSet WILLOW_NATURAL_SET = NaturalSet.full("willow", RuTreeGrowers.WILLOW);

    //MUSHROOMS
    public static final Supplier<Block> BLUE_BIOSHROOM = BlockRegistry.registerDefaultBlock("blue_bioshroom", () -> new BioshroomBlock(RuTreeGrowers.BLUE_BIOSHROOM, MobEffects.POISON, 10, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    public static final Supplier<Block> GREEN_BIOSHROOM = BlockRegistry.registerDefaultBlock("green_bioshroom", () -> new BioshroomBlock(RuTreeGrowers.GREEN_BIOSHROOM, MobEffects.POISON, 10, BlockBehaviour.Properties.ofFullCopy(BLUE_BIOSHROOM.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final Supplier<Block> PINK_BIOSHROOM = BlockRegistry.registerDefaultBlock("pink_bioshroom", () -> new BioshroomBlock(RuTreeGrowers.PINK_BIOSHROOM, MobEffects.POISON, 10, BlockBehaviour.Properties.ofFullCopy(BLUE_BIOSHROOM.get()).mapColor(MapColor.COLOR_PINK)));
    public static final Supplier<Block> YELLOW_BIOSHROOM = BlockRegistry.registerDefaultBlock("yellow_bioshroom", () -> new BioshroomBlock(RuTreeGrowers.YELLOW_BIOSHROOM, MobEffects.POISON, 10, BlockBehaviour.Properties.ofFullCopy(BLUE_BIOSHROOM.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final Supplier<Block> TALL_BLUE_BIOSHROOM = BlockRegistry.registerDefaultBlock("tall_blue_bioshroom", () -> new DoubleBioshroomBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    public static final Supplier<Block> TALL_GREEN_BIOSHROOM = BlockRegistry.registerDefaultBlock("tall_green_bioshroom", () -> new DoubleBioshroomBlock(BlockBehaviour.Properties.ofFullCopy(TALL_BLUE_BIOSHROOM.get())));
    public static final Supplier<Block> TALL_PINK_BIOSHROOM = BlockRegistry.registerDefaultBlock("tall_pink_bioshroom", () -> new DoubleBioshroomBlock(BlockBehaviour.Properties.ofFullCopy(TALL_BLUE_BIOSHROOM.get())));
    public static final Supplier<Block> TALL_YELLOW_BIOSHROOM = BlockRegistry.registerDefaultBlock("tall_yellow_bioshroom", () -> new DoubleBioshroomBlock(BlockBehaviour.Properties.ofFullCopy(TALL_BLUE_BIOSHROOM.get())));
    //OTHER_PLANT_BLOCKS
    public static final Supplier<Block> ICICLE = BlockRegistry.registerDefaultBlock("icicle", () -> new IcicleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noOcclusion().sound(SoundType.GLASS).strength(1F, 0.6F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> BARREL_CACTUS = BlockRegistry.registerDefaultBlock("barrel_cactus", () -> new BarrelCactusBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> CAVE_HYSSOP = BlockRegistry.registerDefaultBlock("cave_hyssop", () -> new CaveFlowerBlock(MobEffects.LUCK, 10, BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> DUCKWEED = BlockRegistry.registerPlaceOnWaterBlock("duckweed", DuckweedBlock::new);
    public static final Supplier<Block> SPANISH_MOSS = BlockRegistry.registerDefaultBlock("spanish_moss", () -> new SpanishMossBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().randomTicks().noCollission().instabreak().sound(SoundType.LILY_PAD)));
    public static final Supplier<Block> SPANISH_MOSS_PLANT = BlockRegistry.registerDefaultBlockNoItem("spanish_moss_plant", () -> new SpanishMossPlantBlock(BlockBehaviour.Properties.ofFullCopy(SPANISH_MOSS.get())));
    public static final Supplier<Block> KAPOK_VINES = BlockRegistry.registerDefaultBlock("kapok_vines", () -> new KapokVinesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).ignitedByLava().randomTicks().noCollission().instabreak().sound(SoundType.LILY_PAD)));
    public static final Supplier<Block> KAPOK_VINES_PLANT = BlockRegistry.registerDefaultBlockNoItem("kapok_vines_plant", () -> new KapokVinesPlantBlock(BlockBehaviour.Properties.ofFullCopy(KAPOK_VINES.get())));

    public static final Supplier<Block> FLOWERING_LILY_PAD = BlockRegistry.registerPlaceOnWaterBlock("flowering_lily_pad", () -> new FloweringLilyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD)));
    public static final Supplier<Block> GIANT_LILY_PAD = BlockRegistry.registerDefaultBlockNoItem("giant_lily_pad", () -> new GiantLilyBlock(BlockBehaviour.Properties.ofFullCopy(FLOWERING_LILY_PAD.get())));

    //FOOD_PLANT_BLOCKS
    public static final Supplier<Block> SALMONBERRY_BUSH = BlockRegistry.registerDefaultBlockNoItem("salmonberry_bush", () -> new SalmonBerryBushBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.BLOCK).ignitedByLava().randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)));
    /*-----------------PLANT_BLOCKS-----------------*/
    //MUSHROOMS
    public static final Supplier<Block> BLUE_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("blue_bioshroom_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WART_BLOCK).strength(0.6f)));
    public static final Supplier<Block> GREEN_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("green_bioshroom_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(BLUE_BIOSHROOM_BLOCK.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final Supplier<Block> PINK_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("pink_bioshroom_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(BLUE_BIOSHROOM_BLOCK.get()).mapColor(MapColor.COLOR_PINK)));
    public static final Supplier<Block> YELLOW_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("yellow_bioshroom_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(BLUE_BIOSHROOM_BLOCK.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final Supplier<Block> GLOWING_BLUE_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("glowing_blue_bioshroom_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.WART_BLOCK).instrument(NoteBlockInstrument.BASS).strength(0.6f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15)));
    public static final Supplier<Block> GLOWING_GREEN_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("glowing_green_bioshroom_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(GLOWING_BLUE_BIOSHROOM_BLOCK.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final Supplier<Block> GLOWING_PINK_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("glowing_pink_bioshroom_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(GLOWING_BLUE_BIOSHROOM_BLOCK.get()).mapColor(MapColor.COLOR_PINK)));
    public static final Supplier<Block> GLOWING_YELLOW_BIOSHROOM_BLOCK = BlockRegistry.registerDefaultBlock("glowing_yellow_bioshroom_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(GLOWING_BLUE_BIOSHROOM_BLOCK.get()).mapColor(MapColor.COLOR_YELLOW)));
    //BAMBOO
    public static final Supplier<Block> BAMBOO_LOG = BlockRegistry.registerDefaultBlock("bamboo_log", BambooLogBlock::new);
    public static final Supplier<Block> STRIPPED_BAMBOO_LOG = BlockRegistry.registerDefaultBlock("stripped_bamboo_log", StrippedBambooLogBlock::new);
    //OAK
    public static final Supplier<Block> SMALL_OAK_LOG = BlockRegistry.registerDefaultBlock("small_oak_log", SmallOakLogBlock::new);
    public static final Supplier<Block> STRIPPED_SMALL_OAK_LOG = BlockRegistry.registerDefaultBlock("stripped_small_oak_log", SmallOakLogBlock::new);
    //CACTUS
    public static final Supplier<Block> SAGUARO_CACTUS = BlockRegistry.registerDefaultBlock("saguaro_cactus", () -> new SaguaroCactusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.GUITAR).sound(SoundType.WOOL).strength(2f)));

    /*-----------------DIRT_BLOCKS-----------------*/
    //FOREST_DIRT_BLOCKS
    public static final Supplier<Block> PEAT_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("peat_grass_block", () -> new PeatGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final Supplier<Block> PEAT_DIRT = BlockRegistry.registerDefaultBlock("peat_dirt", () -> new TillableDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final Supplier<Block> PEAT_DIRT_PATH = BlockRegistry.registerDefaultBlock("peat_dirt_path", () -> new PeatDirtPathBlock(BlockBehaviour.Properties.of().strength(0.65F).sound(SoundType.GRASS).isViewBlocking(BlockRegistry::always).isSuffocating(BlockRegistry::always)));
    public static final Supplier<Block> PEAT_COARSE_DIRT = BlockRegistry.registerDefaultBlock("peat_coarse_dirt", () -> new TillableDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)));
    public static final Supplier<Block> PEAT_PODZOL = BlockRegistry.registerDefaultBlock("peat_podzol", () -> new SnowyDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL)));
    public static final Supplier<Block> PEAT_MUD = BlockRegistry.registerDefaultBlock("peat_mud", () -> new RuMudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_BROWN).randomTicks().isValidSpawn(BlockRegistry::always).isRedstoneConductor(BlockRegistry::always).isViewBlocking(BlockRegistry::always).isSuffocating(BlockRegistry::always).sound(SoundType.MUD)));
    public static final Supplier<Block> PEAT_FARMLAND = BlockRegistry.registerDefaultBlock("peat_farmland", () -> new PeatFarmBlock(BlockBehaviour.Properties.of().randomTicks().strength(0.6F).sound(SoundType.GRAVEL).isViewBlocking(BlockRegistry::always).isSuffocating(BlockRegistry::always)));
    //PLAINS_DIRT_BLOCKS
    public static final Supplier<Block> SILT_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("silt_grass_block", () -> new SiltGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final Supplier<Block> SILT_DIRT = BlockRegistry.registerDefaultBlock("silt_dirt", () -> new TillableDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final Supplier<Block> SILT_DIRT_PATH = BlockRegistry.registerDefaultBlock("silt_dirt_path", () -> new SiltDirtPathBlock(BlockBehaviour.Properties.of().strength(0.65F).sound(SoundType.GRASS).isViewBlocking(BlockRegistry::always).isSuffocating(BlockRegistry::always)));
    public static final Supplier<Block> SILT_COARSE_DIRT = BlockRegistry.registerDefaultBlock("silt_coarse_dirt", () -> new TillableDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT)));
    public static final Supplier<Block> SILT_PODZOL = BlockRegistry.registerDefaultBlock("silt_podzol", () -> new SnowyDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL)));
    public static final Supplier<Block> SILT_MUD = BlockRegistry.registerDefaultBlock("silt_mud", () -> new RuMudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_YELLOW).randomTicks().isValidSpawn(BlockRegistry::always).isRedstoneConductor(BlockRegistry::always).isViewBlocking(BlockRegistry::always).isSuffocating(BlockRegistry::always).sound(SoundType.MUD)));
    public static final Supplier<Block> SILT_FARMLAND = BlockRegistry.registerDefaultBlock("silt_farmland", () -> new SiltFarmBlock(BlockBehaviour.Properties.of().randomTicks().strength(0.6F).sound(SoundType.GRAVEL).isViewBlocking(BlockRegistry::always).isSuffocating(BlockRegistry::always)));
    //OTHER_DIRT_BLOCKS
    public static final Supplier<Block> ALPHA_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("alpha_grass_block", () -> new AlphaGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRAVEL)));

    /*-----------------STONE_BLOCKS-----------------*/
    //CHALKS
    public static final Supplier<Block> CHALK = BlockRegistry.registerDefaultBlock("chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CHALK_GRASS_BLOCK = BlockRegistry.registerDefaultBlock("chalk_grass_block", () -> new ChalkGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).randomTicks().strength(0.6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CHALK_BRICKS = BlockRegistry.registerDefaultBlock("chalk_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CHALK_BRICK_SLAB = BlockRegistry.registerDefaultBlock("chalk_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CHALK_BRICK_STAIRS = BlockRegistry.registerDefaultBlock("chalk_brick_stairs", () -> new StairBlock(CHALK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CHALK_BRICKS.get())));
    public static final Supplier<Block> CHALK_PILLAR = BlockRegistry.registerDefaultBlock("chalk_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.6f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CHALK_SLAB = BlockRegistry.registerDefaultBlock("chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CHALK_STAIRS = BlockRegistry.registerDefaultBlock("chalk_stairs", () -> new StairBlock(CHALK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CHALK.get())));
    public static final Supplier<Block> POLISHED_CHALK = BlockRegistry.registerDefaultBlock("polished_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> POLISHED_CHALK_SLAB = BlockRegistry.registerDefaultBlock("polished_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    public static final Supplier<Block> POLISHED_CHALK_STAIRS = BlockRegistry.registerDefaultBlock("polished_chalk_stairs", () -> new StairBlock(CHALK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_CHALK.get())));
    //STONES
    public static final Supplier<Block> ARGILLITE = BlockRegistry.registerDefaultBlock("argillite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.CALCITE)));
    public static final Supplier<Block> MOSSY_STONE = BlockRegistry.registerDefaultBlock("mossy_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    /*-----------------OCEAN_BLOCKS-----------------*/
    //HYACINTH_BLOCKS
    public static final Supplier<Block> HYACINTH_LAMP = BlockRegistry.registerDefaultBlock("hyacinth_lamp", () -> new HyacinthLampBlock(BlockBehaviour.Properties.of().noOcclusion().instabreak().sound(SoundType.DECORATED_POT).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 14)));
    public static final Supplier<Block> HYACINTH_BLOOM = BlockRegistry.registerDefaultBlock("hyacinth_bloom", () -> new SeagrassBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.WET_GRASS).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 9)));
    public static final Supplier<Block> HYACINTH_FLOWERS = BlockRegistry.registerDefaultBlock("hyacinth_flowers", () -> new GlowLichenBlock(BlockBehaviour.Properties.of().replaceable().mapColor(MapColor.GLOW_LICHEN).noCollission().strength(0.2F).sound(SoundType.GLOW_LICHEN).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 8)));
    public static final Supplier<Block> TALL_HYACINTH_STOCK = BlockRegistry.registerDefaultBlock("tall_hyacinth_stock", () -> new TallHyacinthStockBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WET_GRASS).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 12)));
    //SMOULDERING_WOODLAND_BLOCKS
    public static final Supplier<Block> ASHEN_DIRT = BlockRegistry.registerDefaultBlock("ashen_dirt", () -> new AshenDirtBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(0.5F).sound(SoundType.GRAVEL).randomTicks().lightLevel((bs) -> AshenDirtBlock.isSmouldering(bs) ? 7 : 0)));
    public static final Supplier<Block> ASHEN_GRASS = BlockRegistry.registerDefaultBlock("ashen_grass", () -> new AshenGrassBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> AshenGrassBlock.isSmouldering(bs)).emissiveRendering((bs, br, bp) -> AshenGrassBlock.isSmouldering(bs)).lightLevel((bs) -> AshenGrassBlock.isSmouldering(bs) ? 5 : 0)));

    /*-----------------OTHER_BLOCKS-----------------*/
    public static final Supplier<Block> ASH = BlockRegistry.registerDefaultBlock("ash", () -> new AshBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.GRAVEL).randomTicks()));
    public static final Supplier<Block> ASH_VENT = BlockRegistry.registerDefaultBlock("ash_vent", () -> new AshVentBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).strength(1.6F).sound(SoundType.BASALT).randomTicks().requiresCorrectToolForDrops()));
    public static final Supplier<Block> VOLCANIC_ASH = BlockRegistry.registerDefaultBlock("volcanic_ash", () -> new AshBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.GRAVEL).randomTicks()));

    /*-----------------WOOD_TYPES-----------------*/
    public static final List<WoodSet> WOOD_SETS = new ArrayList<>();

    public static final WoodSet ALPHA_WOOD_SET = WoodSet.alpha();
    public static final WoodSet ASHEN_WOOD_SET = WoodSet.ashen();
    public static final WoodSet BAOBAB_WOOD_SET = WoodSet.simple("baobab", RuWoodTypes.BAOBAB, SoundType.CHERRY_WOOD, MapColor.WOOD, MapColor.TERRACOTTA_LIGHT_GRAY, false);
    public static final WoodSet BLACKWOOD_WOOD_SET = WoodSet.simple("blackwood", RuWoodTypes.BLACKWOOD, SoundType.NETHER_WOOD, MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BROWN, false);
    public static final BrimwoodWoodSet BRIMWOOD_WOOD_SET = BrimwoodWoodSet.brimwood("brimwood", RuWoodTypes.BRIMWOOD, SoundType.NETHER_WOOD, MapColor.COLOR_BROWN, MapColor.COLOR_ORANGE, true);
    public static final WoodSet COBALT_WOOD_SET = WoodSet.simple("cobalt", RuWoodTypes.COBALT, SoundType.NETHER_WOOD, MapColor.COLOR_BLUE, MapColor.COLOR_BLACK, true);
    public static final WoodSet CYPRESS_WOOD_SET = WoodSet.simple("cypress", RuWoodTypes.CYPRESS, SoundType.BAMBOO_WOOD, MapColor.WOOD, false);
    public static final WoodSet DEAD_WOOD_SET = WoodSet.simple("dead", RuWoodTypes.DEAD, SoundType.WOOD, MapColor.WOOD, true);
    public static final WoodSet EUCALYPTUS_WOOD_SET = WoodSet.simple("eucalyptus", RuWoodTypes.EUCALYPTUS, SoundType.WOOD, MapColor.WOOD, false);
    public static final WoodSet JOSHUA_WOOD_SET = WoodSet.simple("joshua", RuWoodTypes.JOSHUA, SoundType.WOOD, MapColor.WOOD, false);
    public static final WoodSet KAPOK_WOOD_SET = WoodSet.simple("kapok", RuWoodTypes.KAPOK, SoundType.WOOD, MapColor.TERRACOTTA_GREEN, MapColor.WOOD, false);
    public static final WoodSet LARCH_WOOD_SET = WoodSet.simple("larch", RuWoodTypes.LARCH, SoundType.WOOD, MapColor.WOOD, false);
    public static final WoodSet MAGNOLIA_WOOD_SET = WoodSet.simple("magnolia", RuWoodTypes.MAGNOLIA, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_PINK, MapColor.STONE, false);
    public static final WoodSet MAPLE_WOOD_SET = WoodSet.simple("maple", RuWoodTypes.MAPLE, SoundType.WOOD, MapColor.WOOD, false);
    public static final WoodSet MAUVE_WOOD_SET = WoodSet.simple("mauve", RuWoodTypes.MAUVE, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_PURPLE, MapColor.PODZOL, false);
    public static final WoodSet PALM_WOOD_SET = WoodSet.simple("palm", RuWoodTypes.PALM, SoundType.BAMBOO_WOOD, MapColor.WOOD, false);
    public static final WoodSet PINE_WOOD_SET = WoodSet.pine("pine", RuWoodTypes.PINE, SoundType.BAMBOO_WOOD, MapColor.WOOD, false);
    public static final WoodSet REDWOOD_WOOD_SET = WoodSet.simple("redwood", RuWoodTypes.REDWOOD, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_RED, false);
    public static final WoodSet SILVER_BIRCH_WOOD_SET = WoodSet.silverBirch();
    public static final WoodSet SOCOTRA_WOOD_SET = WoodSet.simple("socotra", RuWoodTypes.SOCOTRA, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_ORANGE, false);
    public static final WoodSet WILLOW_WOOD_SET = WoodSet.simple("willow", RuWoodTypes.WILLOW, SoundType.WOOD, MapColor.WOOD, false);

    public static final WoodSet PINK_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("pink_bioshroom", RuWoodTypes.PINK_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_PINK, false);
    public static final WoodSet YELLOW_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("yellow_bioshroom", RuWoodTypes.YELLOW_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_YELLOW, true);
    public static final WoodSet BLUE_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("blue_bioshroom", RuWoodTypes.BLUE_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_LIGHT_BLUE, false);
    public static final WoodSet GREEN_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("green_bioshroom", RuWoodTypes.GREEN_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_LIGHT_GREEN, false);


    /*-----------------PAINTED PLANKS-----------------*/
    //PLANKS
    public static final ColoredSet PAINTED_PLANKS = new ColoredSet(color -> BlockRegistry.registerDefaultBlock(color.getName() + "_painted_planks", () -> BlockRegistry.planks(color.getMapColor(), SoundType.WOOD, false)));
    public static final ColoredSet PAINTED_STAIRS = new ColoredSet(color -> BlockRegistry.registerDefaultBlock(color.getName() + "_painted_stairs", () -> BlockRegistry.stairs(color.getMapColor(), SoundType.WOOD, false)));
    public static final ColoredSet PAINTED_SLABS = new ColoredSet(color -> BlockRegistry.registerDefaultBlock(color.getName() + "_painted_slab", () -> BlockRegistry.slab(color.getMapColor(), SoundType.WOOD, false)));

    /*-----------------NETHER_BLOCKS-----------------*/
    //NETHER_STONES
    public static final Supplier<Block> BLACKSTONE_CLUSTER = BlockRegistry.registerDefaultBlock("blackstone_cluster", () -> new RockPileBlock(BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.NETHERRACK)));
    public static final Supplier<Block> OVERGROWN_BONE_BLOCK = BlockRegistry.registerDefaultBlock("overgrown_bone_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));
    //BRIMSPROUT_BLOCKS
    public static final Supplier<Block> BRIMSPROUT_NYLIUM = BlockRegistry.registerDefaultBlock("brimsprout_nylium", () -> new RuNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.SCULK_SENSOR), RuNetherFeatures.BRIMSPROUT_NYLIUM_BONEMEAL));
    public static final Supplier<Block> BRIMSPROUT = BlockRegistry.registerDefaultBlock("brimsprout", () -> new BrimPlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.SCULK).offsetType(BlockBehaviour.OffsetType.XYZ)));
    //COBALT_BLOCKS
    public static final Supplier<Block> COBALT_EARLIGHT = BlockRegistry.registerDefaultBlock("cobalt_earlight", () -> new RuNetherPlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 9)));
    public static final Supplier<Block> TALL_COBALT_EARLIGHT = BlockRegistry.registerDefaultBlock("tall_cobalt_earlight", () -> new RuNetherDoublePlantBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 13)));
    public static final Supplier<Block> COBALT_NYLIUM = BlockRegistry.registerDefaultBlock("cobalt_nylium", () -> new RuBlackstoneNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM), RuNetherFeatures.COBALT_NYLIUM_BONEMEAL));
    public static final Supplier<Block> COBALT_OBSIDIAN = BlockRegistry.registerDefaultBlock("cobalt_obsidian", () -> new CobaltObsidianBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    public static final Supplier<Block> COBALT_ROOTS = BlockRegistry.registerDefaultBlock("cobalt_roots", () -> new RuCobaltPlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    public static final Supplier<Block> HANGING_EARLIGHT = BlockRegistry.registerDefaultBlockNoItem("hanging_earlight", () -> new HangingEarlightBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 14)));
    public static final Supplier<Block> HANGING_EARLIGHT_PLANT = BlockRegistry.registerDefaultBlockNoItem("hanging_earlight_plant", () -> new HangingEarlightPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    //GLISTERING_BLOCKS
    public static final Supplier<Block> GLISTERING_IVY = BlockRegistry.registerDefaultBlock("glistering_ivy", () -> new GlisteringIvyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15)));
    public static final Supplier<Block> GLISTERING_IVY_PLANT = BlockRegistry.registerDefaultBlockNoItem("glistering_ivy_plant", () -> new GlisteringIvyPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final Supplier<Block> GLISTERING_NYLIUM = BlockRegistry.registerDefaultBlock("glistering_nylium", () -> new RuNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM), RuNetherFeatures.GLISTERING_NYLIUM_BONEMEAL));
    public static final Supplier<Block> GLISTERING_SPROUT = BlockRegistry.registerDefaultBlock("glistering_sprout", () -> new RuNetherPlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.TWISTING_VINES).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> GLISTERING_FERN = BlockRegistry.registerDefaultBlock("glistering_fern", () -> new RuNetherPlantBlock(BlockBehaviour.Properties.ofFullCopy(GLISTERING_SPROUT.get())));
    public static final Supplier<Block> GLISTERING_BLOOM = BlockRegistry.registerDefaultBlock("glistering_bloom", () -> new RuNetherPlantBlock(BlockBehaviour.Properties.ofFullCopy(GLISTERING_SPROUT.get())));
    public static final Supplier<Block> GLISTERING_WART = BlockRegistry.registerDefaultBlock("glistering_wart", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM)));
    public static final Supplier<Block> GLISTER_BULB = BlockRegistry.registerDefaultBlock("glister_bulb", () -> new RuNetherDoublePlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.NETHER_WART).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 13)));
    public static final Supplier<Block> GLISTER_SPIRE = BlockRegistry.registerDefaultBlock("glister_spire", () -> new RuNetherDoublePlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 5)));
    //MYCOTOXIC_BLOCKS
    public static final Supplier<Block> MYCOTOXIC_MUSHROOMS = BlockRegistry.registerDefaultBlock("mycotoxic_mushrooms", () -> new NetherGroundCoverBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().sound(SoundType.SHROOMLIGHT).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel((state) -> 3 + 3 * state.getValue(NetherGroundCoverBlock.AMOUNT))));
    public static final Supplier<Block> MYCOTOXIC_DAISY = BlockRegistry.registerDefaultBlock("mycotoxic_daisy", () -> new RuNetherDoublePlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 4)));
    public static final Supplier<Block> MYCOTOXIC_GRASS = BlockRegistry.registerDefaultBlock("mycotoxic_grass", () -> new RuNetherPlantBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    public static final Supplier<Block> MYCOTOXIC_NYLIUM = BlockRegistry.registerDefaultBlock("mycotoxic_moss", () -> new RuNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM), RuNetherFeatures.MYCOTOXIC_NYLIUM_BONEMEAL));
    /*-----------------POTTED_PLANTS-----------------*/
    //POTTED_FLOWERS
    public static final Supplier<Block> POTTED_ALPHA_DANDELION = BlockRegistry.registerDefaultBlockNoItem("potted_alpha_dandelion", () -> new FlowerPotBlock(ALPHA_DANDELION.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_ALPHA_ROSE = BlockRegistry.registerDefaultBlockNoItem("potted_alpha_rose", () -> new FlowerPotBlock(ALPHA_ROSE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_ASTER = BlockRegistry.registerDefaultBlockNoItem("potted_aster", () -> new FlowerPotBlock(ASTER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_BLEEDING_HEART = BlockRegistry.registerDefaultBlockNoItem("potted_bleeding_heart", () -> new FlowerPotBlock(BLEEDING_HEART.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_BLUE_LUPINE = BlockRegistry.registerDefaultBlockNoItem("potted_blue_lupine", () -> new FlowerPotBlock(BLUE_LUPINE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_DAISY = BlockRegistry.registerDefaultBlockNoItem("potted_daisy", () -> new FlowerPotBlock(DAISY.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_DORCEL = BlockRegistry.registerDefaultBlockNoItem("potted_dorcel", () -> new FlowerPotBlock(DORCEL.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_FELICIA_DAISY = BlockRegistry.registerDefaultBlockNoItem("potted_felicia_daisy", () -> new FlowerPotBlock(FELICIA_DAISY.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_FIREWEED = BlockRegistry.registerDefaultBlockNoItem("potted_fireweed", () -> new FlowerPotBlock(FIREWEED.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_HIBISCUS = BlockRegistry.registerDefaultBlockNoItem("potted_hibiscus", () -> new FlowerPotBlock(HIBISCUS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_HYSSOP = BlockRegistry.registerDefaultBlockNoItem("potted_hyssop", () -> new FlowerPotBlock(HYSSOP.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_MALLOW = BlockRegistry.registerDefaultBlockNoItem("potted_mallow", () -> new FlowerPotBlock(MALLOW.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_PINK_LUPINE = BlockRegistry.registerDefaultBlockNoItem("potted_pink_lupine", () -> new FlowerPotBlock(PINK_LUPINE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_POPPY_BUSH = BlockRegistry.registerDefaultBlockNoItem("potted_poppy_bush", () -> new FlowerPotBlock(POPPY_BUSH.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_SALMON_POPPY_BUSH = BlockRegistry.registerDefaultBlockNoItem("potted_salmon_poppy_bush", () -> new FlowerPotBlock(SALMON_POPPY_BUSH.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_PURPLE_LUPINE = BlockRegistry.registerDefaultBlockNoItem("potted_purple_lupine", () -> new FlowerPotBlock(PURPLE_LUPINE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_RED_LUPINE = BlockRegistry.registerDefaultBlockNoItem("potted_red_lupine", () -> new FlowerPotBlock(RED_LUPINE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_TSUBAKI = BlockRegistry.registerDefaultBlockNoItem("potted_tsubaki", () -> new FlowerPotBlock(TSUBAKI.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_ORANGE_CONEFLOWER = BlockRegistry.registerDefaultBlockNoItem("potted_orange_coneflower", () -> new FlowerPotBlock(ORANGE_CONEFLOWER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_PURPLE_CONEFLOWER = BlockRegistry.registerDefaultBlockNoItem("potted_purple_coneflower", () -> new FlowerPotBlock(PURPLE_CONEFLOWER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_WARATAH = BlockRegistry.registerDefaultBlockNoItem("potted_waratah", () -> new FlowerPotBlock(WARATAH.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_WHITE_TRILLIUM = BlockRegistry.registerDefaultBlockNoItem("potted_white_trillium", () -> new FlowerPotBlock(WHITE_TRILLIUM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_WILTING_TRILLIUM = BlockRegistry.registerDefaultBlockNoItem("potted_wilting_trillium", () -> new FlowerPotBlock(WILTING_TRILLIUM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_YELLOW_LUPINE = BlockRegistry.registerDefaultBlockNoItem("potted_yellow_lupine", () -> new FlowerPotBlock(YELLOW_LUPINE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_GLISTERING_BLOOM = BlockRegistry.registerDefaultBlockNoItem("potted_glistering_bloom", () -> new FlowerPotBlock(GLISTERING_BLOOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    //OTHER_POTS
    public static final Supplier<Block> POTTED_DAY_LILY = BlockRegistry.registerDefaultBlockNoItem("potted_day_lily", () -> new FlowerPotBlock(DAY_LILY.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_MEADOW_SAGE = BlockRegistry.registerDefaultBlockNoItem("potted_meadow_sage", () -> new FlowerPotBlock(MEADOW_SAGE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_DUSKTRAP = BlockRegistry.registerDefaultBlockNoItem("potted_dusktrap", () -> new FlowerPotBlock(DUSKTRAP.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_CORPSE_FLOWER = BlockRegistry.registerDefaultBlockNoItem("potted_corpse_flower", () -> new FlowerPotBlock(CORPSE_FLOWER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    public static final Supplier<Block> POTTED_COBALT_EARLIGHT = BlockRegistry.registerDefaultBlockNoItem("potted_cobalt_earlight", () -> new FlowerPotBlock(COBALT_EARLIGHT.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).lightLevel(s -> 8)));
    public static final Supplier<Block> POTTED_TALL_COBALT_EARLIGHT = BlockRegistry.registerDefaultBlockNoItem("potted_tall_cobalt_earlight", () -> new FlowerPotBlock(TALL_COBALT_EARLIGHT.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).lightLevel(s -> 8)));
    public static final Supplier<Block> POTTED_MYCOTOXIC_DAISY = BlockRegistry.registerDefaultBlockNoItem("potted_mycotoxic_daisy", () -> new FlowerPotBlock(MYCOTOXIC_DAISY.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).lightLevel(s -> 8)));
    public static final Supplier<Block> POTTED_GLISTER_SPIRE = BlockRegistry.registerDefaultBlockNoItem("potted_glister_spire", () -> new FlowerPotBlock(GLISTER_SPIRE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    //POTTED_MUSHROOMS
    public static final Supplier<Block> POTTED_BLUE_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_blue_bioshroom", () -> new FlowerPotBlock(BLUE_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_GREEN_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_green_bioshroom", () -> new FlowerPotBlock(GREEN_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_PINK_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_pink_bioshroom", () -> new FlowerPotBlock(PINK_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_YELLOW_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_yellow_bioshroom", () -> new FlowerPotBlock(YELLOW_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_TALL_BLUE_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_tall_blue_bioshroom", () -> new FlowerPotBlock(TALL_BLUE_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_TALL_GREEN_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_tall_green_bioshroom", () -> new FlowerPotBlock(TALL_GREEN_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_TALL_PINK_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_tall_pink_bioshroom", () -> new FlowerPotBlock(TALL_PINK_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    public static final Supplier<Block> POTTED_TALL_YELLOW_BIOSHROOM = BlockRegistry.registerDefaultBlockNoItem("potted_tall_yellow_bioshroom", () -> new FlowerPotBlock(TALL_YELLOW_BIOSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM).lightLevel(s -> 10)));
    //OTHER_POTTED_PLANTS
    public static final Supplier<Block> POTTED_BARREL_CACTUS = BlockRegistry.registerDefaultBlockNoItem("potted_barrel_cactus", () -> new FlowerPotBlock(BARREL_CACTUS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CACTUS)));
    public static final Supplier<Block> POTTED_CAVE_HYSSOP = BlockRegistry.registerDefaultBlockNoItem("potted_cave_hyssop", () -> new FlowerPotBlock(CAVE_HYSSOP.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));
    //SNOWBELLES
    public static final ColoredSet SNOWBELLES = new ColoredSet(color -> BlockRegistry.registerDefaultBlock(color.getName() + "_snowbelle", () -> new RuFlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION))));
    public static final ColoredSet POTTED_SNOWBELLES = new ColoredSet(color -> BlockRegistry.registerDefaultBlockNoItem("potted_" + color.getName() + "_snowbelle", () -> new FlowerPotBlock(SNOWBELLES.getMap().get(color), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM))));

    // TODO: Enable this
    public static final Map<Identifier, Identifier> BLOCK_ALIASES = Map.of(
        //id("maple_leaf_pile"), id("maple_leaf_litter"),
        //id("red_maple_leaf_pile"), id("red_maple_leaf_litter"),
        //id("orange_maple_leaf_pile"), id("orange_maple_leaf_litter"),
        //id("silver_birch_leaf_pile"), id("silver_birch_leaf_litter"),
        //id("enchanted_birch_leaf_pile"), id("enchanted_birch_leaf_litter"),
        //id("cactus_flower"), id("saguaro_cactus_flower"),
        //id("potted_cactus_flower"), id("potted_saguaro_cactus_flower")
    );

    public static void addBlocks() {
    }
}
