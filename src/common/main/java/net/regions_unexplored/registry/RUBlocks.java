package net.regions_unexplored.registry;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.block.RUBlockUtils;
import net.regions_unexplored.block.sapling.RuTreeGrowers;
import net.regions_unexplored.block.set.BrimwoodWoodSet;
import net.regions_unexplored.block.set.ColoredSet;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.block.RuWoodTypes;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;
import net.regions_unexplored.item.RUItemUtils;
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

import static net.regions_unexplored.RegionsUnexplored.id;
import static net.regions_unexplored.block.RUBlockUtils.*;


public interface RUBlocks {
    Supplier<Block> PRISMOSS = register("prismoss", p -> new PrismossBlock(p.mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).randomTicks().strength(1.5f, 6f).requiresCorrectToolForDrops()));
    Supplier<Block> DEEPSLATE_PRISMOSS = register("deepslate_prismoss", p -> new PrismossBlock(p.mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.DEEPSLATE).randomTicks().strength(3f, 6f).requiresCorrectToolForDrops()));
    Supplier<Block> HANGING_PRISMARITE = register("hanging_prismarite", p -> new HangingPrismariteBlock(p.pushReaction(PushReaction.DESTROY).sound(SoundType.AMETHYST).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    Supplier<Block> LARGE_PRISMARITE_CLUSTER = register("large_prismarite_cluster", p -> new PrismariteDoubleBlock(p.pushReaction(PushReaction.DESTROY).noCollission().sound(SoundType.AMETHYST).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    Supplier<Block> PRISMAGLASS = register("prismaglass", p -> new GrassBlock(p.strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(RUBlockUtils::never).isRedstoneConductor(RUBlockUtils::never).isSuffocating(RUBlockUtils::never).isViewBlocking(RUBlockUtils::never)));
    Supplier<Block> PRISMARITE_CLUSTER = register("prismarite_cluster", p -> new PrismariteBlock(p.noCollission().noOcclusion().instabreak().sound(SoundType.AMETHYST_CLUSTER).pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    Supplier<Block> PRISMOSS_SPROUT = register("prismoss_sprout", p -> new PrismossSproutBlock(p.pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    //REDSTONE_BLOCKS
    Supplier<Block> POINTED_REDSTONE = register("pointed_redstone", p -> new PointedRedstoneBlock(p.mapColor(MapColor.COLOR_RED).noOcclusion().sound(SoundType.POINTED_DRIPSTONE).randomTicks().strength(1.5F, 3.0F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).lightLevel(s -> 1).isRedstoneConductor(RUBlockUtils::always)));
    Supplier<Block> RAW_REDSTONE_BLOCK = register("raw_redstone_block", p -> new Block(p.mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(1.5f).requiresCorrectToolForDrops().isRedstoneConductor(RUBlockUtils::always)));
    Supplier<Block> REDSTONE_BUD = register("redstone_bud", p -> new RedstoneBudBlock(p.pushReaction(PushReaction.DESTROY).replaceable().mapColor(MapColor.COLOR_RED).noCollission().sound(SoundType.TUFF).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> REDSTONE_BULB = register("redstone_bulb", p -> new RedstoneBulbBlock(p.pushReaction(PushReaction.DESTROY).noCollission().sound(SoundType.AMETHYST).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 12).isRedstoneConductor(RUBlockUtils::never)));
    //OTHER_CAVE_BLOCKS
    Supplier<Block> ARGILLITE_GRASS_BLOCK = register("argillite_grass_block", p -> new ArgilliteGrassBlock(p.mapColor(MapColor.GRASS).sound(SoundType.STONE).randomTicks().strength(1.5f, 6f).requiresCorrectToolForDrops()));
    Supplier<Block> STONE_GRASS_BLOCK = register("stone_grass_block", p -> new StoneGrassBlock(p.mapColor(MapColor.GRASS).sound(SoundType.STONE).randomTicks().strength(1.5f, 6f).requiresCorrectToolForDrops()));
    Supplier<Block> DEEPSLATE_GRASS_BLOCK = register("deepslate_grass_block", p -> new DeepslateGrassBlock(p.mapColor(MapColor.GRASS).sound(SoundType.DEEPSLATE).randomTicks().strength(3f, 6f).requiresCorrectToolForDrops()));
    Supplier<Block> VIRIDESCENT_NYLIUM = register("viridescent_nylium", p -> new ViridescentNyliumBlock(p.mapColor(MapColor.GRASS).sound(SoundType.NYLIUM).strength(1.5f, 6f).requiresCorrectToolForDrops()));
    Supplier<Block> DEEPSLATE_VIRIDESCENT_NYLIUM = register("deepslate_viridescent_nylium", p -> new ViridescentNyliumBlock(p.mapColor(MapColor.GRASS).sound(SoundType.NYLIUM).strength(3f, 6f).requiresCorrectToolForDrops()));

    Supplier<Block> CORPSE_FLOWER = register("corpse_flower", p -> new CorpseFlowerBlock(p.sound(SoundType.FLOWERING_AZALEA)), Blocks.SUNFLOWER);
    Supplier<Block> BLADED_GRASS = register("bladed_grass", p -> new RuPlantBlock(p.sound(SoundType.AZALEA)), Blocks.SHORT_GRASS);
    Supplier<Block> BLADED_TALL_GRASS = register("bladed_tall_grass", p -> new RuDoublePlantBlock(p.sound(SoundType.AZALEA)), Blocks.TALL_GRASS);
    Supplier<Block> DROPLEAF = register("dropleaf", p -> new DropleafBlock(p.mapColor(MapColor.COLOR_CYAN).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 14)));
    Supplier<Block> DROPLEAF_PLANT = RUBlockUtils.registerNoItem("dropleaf_plant", p -> new DropleafPlantBlock(p.mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.WEEPING_VINES).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> DUSKMELON = RUBlockUtils.registerNoItem("duskmelon", p -> new DuskmelonBlock(p.noCollission().instabreak().sound(SoundType.AZALEA)));
    Supplier<Block> DUSKTRAP = register("dusktrap", p -> new DuskTrapBlock(DuskTrapBlock.Sensitivity.EVERYTHING, p.mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.TWISTING_VINES)));
    /*-----------------PLANTS-----------------*/
    //GRASS_BLOCKS
    Supplier<Block> DEAD_STEPPE_SHRUB = register("dead_steppe_shrub", p -> new DeadShrubBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().replaceable().mapColor(MapColor.WOOD).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> FROZEN_GRASS = register("frozen_grass", RuSnowyPlantBlock::new, Blocks.SHORT_GRASS);
    Supplier<Block> MEDIUM_GRASS = register("medium_grass", RuPlantBlock::new, Blocks.SHORT_GRASS);
    Supplier<Block> SANDY_GRASS = register("sandy_grass", RuSandyPlantBlock::new, Blocks.SHORT_GRASS);
    Supplier<Block> SMALL_DESERT_SHRUB = register("small_desert_shrub", DeadShrubBlock::new, Blocks.DEAD_BUSH);
    Supplier<Block> STEPPE_GRASS = register("steppe_grass", p -> new RuPlantBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> STEPPE_SHRUB = register("steppe_shrub", RuPlantBlock::new, STEPPE_GRASS);
    Supplier<Block> STONE_BUD = register("stone_bud", RuStonePlantBlock::new, Blocks.SHORT_GRASS);
    //TALL_GRASS_BLOCKS
    Supplier<Block> ELEPHANT_EAR = register("elephant_ear", ElephantEarBlock::new, Blocks.TALL_GRASS);
    Supplier<Block> SANDY_TALL_GRASS = register("sandy_tall_grass", RuSandyDoublePlantBlock::new, Blocks.TALL_GRASS);
    Supplier<Block> STEPPE_TALL_GRASS = register("steppe_tall_grass", RuDoublePlantBlock::new, Blocks.TALL_GRASS);
    Supplier<Block> WINDSWEPT_GRASS = register("windswept_grass", RuDoublePlantBlock::new, Blocks.TALL_GRASS);
    //FLOWERS
    Supplier<Block> ALPHA_DANDELION = register("alpha_dandelion", p -> new RuFlowerBlock(MobEffects.JUMP, 5, p), Blocks.DANDELION);
    Supplier<Block> ALPHA_ROSE = register("alpha_rose", p -> new RuFlowerBlock(MobEffects.JUMP, 5, p), Blocks.DANDELION);
    Supplier<Block> ASTER = register("aster", p -> new RuFlowerBlock(MobEffects.CONFUSION, 10, p.hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 13)), Blocks.DANDELION);
    Supplier<Block> BLEEDING_HEART = register("bleeding_heart", p -> new RuSnowFlowerBlock(MobEffects.POISON, 9, p), Blocks.DANDELION);
    Supplier<Block> BLUE_LUPINE = register("blue_lupine", p -> new RuFlowerBlock(MobEffects.SATURATION, 4, p), Blocks.DANDELION);
    Supplier<Block> DAISY = register("daisy", p -> new RuFlowerBlock(MobEffects.MOVEMENT_SPEED, 8, p), Blocks.DANDELION);
    Supplier<Block> DORCEL = register("dorcel", p -> new DorcelPlantBlock(MobEffects.WITHER, 20, p.speedFactor(0.5F)), Blocks.DANDELION);
    Supplier<Block> FELICIA_DAISY = register("felicia_daisy", p -> new RuFlowerBlock(MobEffects.MOVEMENT_SPEED, 8, p), Blocks.DANDELION);
    Supplier<Block> FIREWEED = register("fireweed", p -> new RuFlowerBlock(MobEffects.GLOWING, 2, p), Blocks.DANDELION);
    Supplier<Block> HIBISCUS = register("hibiscus", p -> new RuFlowerBlock(MobEffects.JUMP, 6, p), Blocks.DANDELION);
    Supplier<Block> HYSSOP = register("hyssop", p -> new RuFlowerBlock(MobEffects.LUCK, 10, p), Blocks.DANDELION);
    Supplier<Block> MALLOW = register("mallow", p -> new RuFlowerBlock(MobEffects.DIG_SLOWDOWN, 4, p), Blocks.DANDELION);
    Supplier<Block> PINK_LUPINE = register("pink_lupine", p -> new RuFlowerBlock(MobEffects.SATURATION, 4, p), Blocks.DANDELION);
    Supplier<Block> POPPY_BUSH = register("poppy_bush", p -> new RuFlowerBlock(MobEffects.WEAKNESS, 3, p.mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY)), Blocks.DANDELION);
    Supplier<Block> SALMON_POPPY_BUSH = register("salmon_poppy_bush", p -> new RuFlowerBlock(MobEffects.WEAKNESS, 3, p), POPPY_BUSH);
    Supplier<Block> PURPLE_LUPINE = register("purple_lupine", p -> new RuFlowerBlock(MobEffects.SATURATION, 4, p), Blocks.DANDELION);
    Supplier<Block> RED_LUPINE = register("red_lupine", p -> new RuFlowerBlock(MobEffects.SATURATION, 4, p), Blocks.DANDELION);
    Supplier<Block> WARATAH = register("waratah", p -> new RuFlowerBlock(MobEffects.JUMP, 5, p), Blocks.DANDELION);
    Supplier<Block> TSUBAKI = register("tsubaki", p -> new RuFlowerBlock(MobEffects.HEAL, 3, p), Blocks.DANDELION);
    Supplier<Block> WHITE_TRILLIUM = register("white_trillium", p -> new RuFlowerBlock(MobEffects.DIG_SPEED, 7, p), Blocks.DANDELION);
    Supplier<Block> WILTING_TRILLIUM = register("wilting_trillium", p -> new RuFlowerBlock(MobEffects.DIG_SLOWDOWN, 10, p), Blocks.DANDELION);
    Supplier<Block> YELLOW_LUPINE = register("yellow_lupine", p -> new RuFlowerBlock(MobEffects.SATURATION, 4, p), Blocks.DANDELION);

    Supplier<Block> ORANGE_CONEFLOWER = register("orange_coneflower", p -> new GroundCoverBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().sound(SoundType.PINK_PETALS)));
    Supplier<Block> PURPLE_CONEFLOWER = register("purple_coneflower", p -> new GroundCoverBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().sound(SoundType.PINK_PETALS)));
    Supplier<Block> CLOVER = register("clover", p -> new GroundCoverBlock(p.pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.PINK_PETALS)));

    Supplier<Block> BLUE_MAGNOLIA_FLOWERS = register("blue_magnolia_flowers", p -> new GlowLichenBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().replaceable().noCollission().strength(0.1F).sound(SoundType.GLOW_LICHEN)));
    Supplier<Block> PINK_MAGNOLIA_FLOWERS = register("pink_magnolia_flowers", GlowLichenBlock::new, BLUE_MAGNOLIA_FLOWERS);
    Supplier<Block> WHITE_MAGNOLIA_FLOWERS = register("white_magnolia_flowers", GlowLichenBlock::new, BLUE_MAGNOLIA_FLOWERS);
    //SNOWBELLE

    Supplier<Block> MAPLE_LEAF_PILE = register("maple_leaf_pile", p -> new RULeafLitterBlock(p.pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    Supplier<Block> RED_MAPLE_LEAF_PILE = register("red_maple_leaf_pile", p -> new RULeafLitterBlock(p.pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    Supplier<Block> ORANGE_MAPLE_LEAF_PILE = register("orange_maple_leaf_pile", p -> new RULeafLitterBlock(p.pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    Supplier<Block> SILVER_BIRCH_LEAF_PILE = register("silver_birch_leaf_pile", p -> new RULeafLitterBlock(p.pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    Supplier<Block> ENCHANTED_BIRCH_LEAF_PILE = register("enchanted_birch_leaf_pile", p -> new RULeafLitterBlock(p.pushReaction(PushReaction.DESTROY).replaceable().ignitedByLava().noCollission().sound(SoundType.AZALEA)));
    //TALL_PLANTS
    Supplier<Block> MEADOW_SAGE = RUBlockUtils.registerNoItem("meadow_sage", RuDoublePlantBlock::new, Blocks.ROSE_BUSH);
    Supplier<Block> BARLEY = register("barley", RuDoublePlantBlock::new, Blocks.SUNFLOWER);
    Supplier<Block> CATTAIL = register("cattail", CattailBlock::new, Blocks.SUNFLOWER);
    Supplier<Block> TASSEL = register("tassel", RuDoubleFlowerBlock::new, Blocks.SUNFLOWER);
    Supplier<Block> DAY_LILY = register("day_lily", RuDoubleFlowerBlock::new, Blocks.SUNFLOWER);
    //SAPLINGS

    // NATURAL SETS
    List<NaturalSet> NATURAL_SETS = new ArrayList<>();
    /* VANILLA */
    NaturalSet ACACIA_NATURAL_SET = NaturalSet.vanilla("acacia");
    NaturalSet BIRCH_NATURAL_SET = NaturalSet.vanilla("birch");
    NaturalSet CHERRY_NATURAL_SET = NaturalSet.vanilla("cherry");
    NaturalSet DARK_OAK_NATURAL_SET = NaturalSet.vanilla("dark_oak");
    NaturalSet JUNGLE_NATURAL_SET = NaturalSet.vanilla("jungle");
    NaturalSet MANGROVE_NATURAL_SET = NaturalSet.vanilla("mangrove");
    NaturalSet OAK_NATURAL_SET = NaturalSet.vanilla("oak");
    //public static final NaturalSet PALE_OAK_NATURAL_SET = NaturalSet.vanilla("pale_oak");
    NaturalSet SPRUCE_NATURAL_SET = NaturalSet.vanilla("spruce");
    /* MODDED */
    NaturalSet ALPHA_NATURAL_SET = NaturalSet.leavesAndSaplings("alpha", LeavesBlock::new, RuTreeGrowers.ALPHA_OAK);
    NaturalSet APPLE_OAK_NATURAL_SET = NaturalSet.leavesAndSaplings("apple_oak", AppleLeavesBlock::new, RuTreeGrowers.APPLE_OAK);
    NaturalSet ASHEN_NATURAL_SET = NaturalSet.ashen();
    NaturalSet BAMBOO_NATURAL_SET = NaturalSet.leavesAndSaplings("bamboo", LeavesBlock::new, RuTreeGrowers.BAMBOO);
    NaturalSet BAOBAB_NATURAL_SET = NaturalSet.full("baobab", MapColor.PLANT, BranchType.BRANCH, false, p -> new RuUltraFromMegaSaplingBlock(RuTreeGrowers.BAOBAB, p));
    NaturalSet BLACKWOOD_NATURAL_SET = NaturalSet.full("blackwood", MapColor.TERRACOTTA_GREEN, BranchType.BRANCH, false, RuTreeGrowers.BLACKWOOD);
    NaturalSet BLUE_MAGNOLIA_NATURAL_SET = NaturalSet.fullWithoutBranch("blue_magnolia", false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_LIGHT_BLUE, false, BlueMagnoliaLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.BLUE_MAGNOLIA, p));
    NaturalSet BRIMWOOD_NATURAL_SET = NaturalSet.fullWithoutBranch("brimwood", false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_BROWN, false, BrimwoodLeavesBlock::new), p -> new RuBrimSaplingBlock(RuTreeGrowers.BRIMWOOD, p));
    NaturalSet COBALT_NATURAL_SET = NaturalSet.cobalt();
    NaturalSet CYPRESS_NATURAL_SET = NaturalSet.full("cypress", RuTreeGrowers.CYPRESS);
    NaturalSet DEAD_PINE_NATURAL_SET = NaturalSet.fullWithoutBranch("dead_pine", MapColor.TERRACOTTA_GRAY, true, RuTreeGrowers.DEAD_PINE);
    NaturalSet DEAD_NATURAL_SET = NaturalSet.full("dead", MapColor.TERRACOTTA_GRAY, BranchType.BRANCH, true, RuTreeGrowers.DEAD);
    NaturalSet ENCHANTED_BIRCH_NATURAL_SET = NaturalSet.fullWithoutBranch("enchanted_birch", MapColor.COLOR_LIGHT_BLUE, false, RuTreeGrowers.ENCHANTED_BIRCH);
    NaturalSet EUCALYPTUS_NATURAL_SET = NaturalSet.full("eucalyptus", RuTreeGrowers.EUCALYPTUS);
    NaturalSet FLOWERING_NATURAL_SET = NaturalSet.fullWithoutBranch("flowering", MapColor.PLANT, false, RuTreeGrowers.FLOWERING_OAK);
    NaturalSet GOLDEN_LARCH_NATURAL_SET = NaturalSet.fullWithoutBranch("golden_larch", MapColor.PLANT, false, RuTreeGrowers.GOLDEN_LARCH);
    NaturalSet JOSHUA_NATURAL_SET = NaturalSet.full("joshua", BranchType.BEARD, false, p -> RUBlockUtils.leaves(p, MapColor.PLANT, false, JoshuaLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.JOSHUA, p));
    NaturalSet KAPOK_NATURAL_SET = NaturalSet.full("kapok", MapColor.PLANT, BranchType.BRANCH, false, p -> new RuUltraFromSuperSaplingBlock(RuTreeGrowers.KAPOK, p));
    NaturalSet LARCH_NATURAL_SET = NaturalSet.full("larch", RuTreeGrowers.LARCH);
    NaturalSet MAGNOLIA_NATURAL_SET = NaturalSet.full("magnolia", RuTreeGrowers.MAGNOLIA);
    NaturalSet MAPLE_NATURAL_SET = NaturalSet.full("maple", RuTreeGrowers.MAPLE);
    NaturalSet MAUVE_NATURAL_SET = NaturalSet.full("mauve", BranchType.BRANCH, false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_PURPLE, false, MauveLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.MAUVE, p));
    NaturalSet ORANGE_MAPLE_NATURAL_SET = NaturalSet.fullWithoutBranch("orange_maple", false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_ORANGE, false, OrangeMapleLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.ORANGE_MAPLE, p));
    NaturalSet PALM_NATURAL_SET = NaturalSet.full("palm", MapColor.PLANT, BranchType.BEARD, false, RuTreeGrowers.PALM);
    NaturalSet PINE_NATURAL_SET = NaturalSet.full("pine", RuTreeGrowers.PINE);
    NaturalSet PINK_MAGNOLIA_NATURAL_SET = NaturalSet.fullWithoutBranch("pink_magnolia", false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_PINK, false, PinkMagnoliaLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.PINK_MAGNOLIA, p));
    NaturalSet RED_MAPLE_NATURAL_SET = NaturalSet.fullWithoutBranch("red_maple", false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_RED, false, RedMapleLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.RED_MAPLE, p));
    NaturalSet REDWOOD_NATURAL_SET = NaturalSet.full("redwood", MapColor.PLANT, BranchType.BRANCH, false, p -> new RuUltraFromSuperSaplingBlock(RuTreeGrowers.REDWOOD, p));
    NaturalSet SAGUARO_CACTUS_NATURAL_SET = NaturalSet.saguaroCactus();
    NaturalSet SILVER_BIRCH_NATURAL_SET = NaturalSet.full("silver_birch", BranchType.BRANCH, false, p -> RUBlockUtils.leaves(p, MapColor.COLOR_YELLOW, false, SilverBirchLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.SILVER_BIRCH, p));
    NaturalSet SMALL_OAK_NATURAL_SET = NaturalSet.leavesAndSaplings("small_oak", LeavesBlock::new, RuTreeGrowers.SMALL_OAK);
    NaturalSet SOCOTRA_NATURAL_SET = NaturalSet.full("socotra", RuTreeGrowers.SOCOTRA);
    NaturalSet WHITE_MAGNOLIA_NATURAL_SET = NaturalSet.fullWithoutBranch("white_magnolia", false, p -> RUBlockUtils.leaves(p, MapColor.TERRACOTTA_WHITE, false, WhiteMagnoliaLeavesBlock::new), p -> new SaplingBlock(RuTreeGrowers.WHITE_MAGNOLIA, p));
    NaturalSet WILLOW_NATURAL_SET = NaturalSet.full("willow", RuTreeGrowers.WILLOW);

    //MUSHROOMS
    Supplier<Block> BLUE_BIOSHROOM = register("blue_bioshroom", p -> new BioshroomBlock(RuTreeGrowers.BLUE_BIOSHROOM, MobEffects.POISON, 10, p.mapColor(MapColor.COLOR_LIGHT_BLUE).pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    Supplier<Block> GREEN_BIOSHROOM = register("green_bioshroom", p -> new BioshroomBlock(RuTreeGrowers.GREEN_BIOSHROOM, MobEffects.POISON, 10, p.mapColor(MapColor.COLOR_LIGHT_GREEN)), BLUE_BIOSHROOM);
    Supplier<Block> PINK_BIOSHROOM = register("pink_bioshroom", p -> new BioshroomBlock(RuTreeGrowers.PINK_BIOSHROOM, MobEffects.POISON, 10, p.mapColor(MapColor.COLOR_PINK)), BLUE_BIOSHROOM);
    Supplier<Block> YELLOW_BIOSHROOM = register("yellow_bioshroom", p -> new BioshroomBlock(RuTreeGrowers.YELLOW_BIOSHROOM, MobEffects.POISON, 10, p.mapColor(MapColor.COLOR_YELLOW)), BLUE_BIOSHROOM);
    Supplier<Block> TALL_BLUE_BIOSHROOM = register("tall_blue_bioshroom", p -> new DoubleBioshroomBlock(p.pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 10)));
    Supplier<Block> TALL_GREEN_BIOSHROOM = register("tall_green_bioshroom", DoubleBioshroomBlock::new, TALL_BLUE_BIOSHROOM);
    Supplier<Block> TALL_PINK_BIOSHROOM = register("tall_pink_bioshroom", DoubleBioshroomBlock::new, TALL_BLUE_BIOSHROOM);
    Supplier<Block> TALL_YELLOW_BIOSHROOM = register("tall_yellow_bioshroom", DoubleBioshroomBlock::new, TALL_BLUE_BIOSHROOM);
    //OTHER_PLANT_BLOCKS
    Supplier<Block> ICICLE = register("icicle", p -> new IcicleBlock(p.mapColor(MapColor.COLOR_LIGHT_BLUE).noOcclusion().sound(SoundType.GLASS).strength(1F, 0.6F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> BARREL_CACTUS = register("barrel_cactus", p -> new BarrelCactusBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> CAVE_HYSSOP = register("cave_hyssop", p -> new CaveFlowerBlock(MobEffects.LUCK, 10, p.pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> DUCKWEED = register("duckweed", p -> new DuckweedBlock(p.sound(SoundType.CORAL_BLOCK).instabreak().noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava().isRedstoneConductor((bs, br, bp) -> false)), RUItemUtils::registerPlaceOnWaterBlock, null);
    Supplier<Block> SPANISH_MOSS = register("spanish_moss", p -> new SpanishMossBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().randomTicks().noCollission().instabreak().sound(SoundType.LILY_PAD)));
    Supplier<Block> SPANISH_MOSS_PLANT = RUBlockUtils.registerNoItem("spanish_moss_plant", SpanishMossPlantBlock::new, SPANISH_MOSS);
    Supplier<Block> KAPOK_VINES = register("kapok_vines", p -> new KapokVinesBlock(p.pushReaction(PushReaction.DESTROY).ignitedByLava().randomTicks().noCollission().instabreak().sound(SoundType.LILY_PAD)));
    Supplier<Block> KAPOK_VINES_PLANT = RUBlockUtils.registerNoItem("kapok_vines_plant", KapokVinesPlantBlock::new, KAPOK_VINES);

    Supplier<Block> FLOWERING_LILY_PAD = register("flowering_lily_pad", FloweringLilyBlock::new, RUItemUtils::registerPlaceOnWaterBlock, () -> Blocks.LILY_PAD);
    Supplier<Block> GIANT_LILY_PAD = RUBlockUtils.registerNoItem("giant_lily_pad", GiantLilyBlock::new, FLOWERING_LILY_PAD);

    //FOOD_PLANT_BLOCKS
    Supplier<Block> SALMONBERRY_BUSH = RUBlockUtils.registerNoItem("salmonberry_bush", p -> new SalmonBerryBushBlock(p.pushReaction(PushReaction.BLOCK).ignitedByLava().randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)));
    /*-----------------PLANT_BLOCKS-----------------*/
    //MUSHROOMS
    Supplier<Block> BLUE_BIOSHROOM_BLOCK = register("blue_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASS).sound(SoundType.WART_BLOCK).strength(0.6f)));
    Supplier<Block> GREEN_BIOSHROOM_BLOCK = register("green_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_GREEN)), BLUE_BIOSHROOM_BLOCK);
    Supplier<Block> PINK_BIOSHROOM_BLOCK = register("pink_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_PINK)), BLUE_BIOSHROOM_BLOCK);
    Supplier<Block> YELLOW_BIOSHROOM_BLOCK = register("yellow_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_YELLOW)), BLUE_BIOSHROOM_BLOCK);
    Supplier<Block> GLOWING_BLUE_BIOSHROOM_BLOCK = register("glowing_blue_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_BLUE).sound(SoundType.WART_BLOCK).instrument(NoteBlockInstrument.BASS).strength(0.6f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15)));
    Supplier<Block> GLOWING_GREEN_BIOSHROOM_BLOCK = register("glowing_green_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_GREEN)), GLOWING_BLUE_BIOSHROOM_BLOCK);
    Supplier<Block> GLOWING_PINK_BIOSHROOM_BLOCK = register("glowing_pink_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_PINK)), GLOWING_BLUE_BIOSHROOM_BLOCK);
    Supplier<Block> GLOWING_YELLOW_BIOSHROOM_BLOCK = register("glowing_yellow_bioshroom_block", p -> new Block(p.mapColor(MapColor.COLOR_YELLOW)), GLOWING_BLUE_BIOSHROOM_BLOCK);
    //BAMBOO
    Supplier<Block> BAMBOO_LOG = register("bamboo_log", p -> new BambooLogBlock(p.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).sound(SoundType.BAMBOO).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
    Supplier<Block> STRIPPED_BAMBOO_LOG = register("stripped_bamboo_log", p -> new StrippedBambooLogBlock(p.mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).sound(SoundType.BAMBOO).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
    //OAK
    Supplier<Block> SMALL_OAK_LOG = register("small_oak_log", p -> new SmallOakLogBlock(p.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
    Supplier<Block> STRIPPED_SMALL_OAK_LOG = register("stripped_small_oak_log", p -> new SmallOakLogBlock(p.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
    //CACTUS
    Supplier<Block> SAGUARO_CACTUS = register("saguaro_cactus", p -> new SaguaroCactusBlock(p.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.GUITAR).sound(SoundType.WOOL).strength(2f)));

    /*-----------------DIRT_BLOCKS-----------------*/
    //FOREST_DIRT_BLOCKS
    Supplier<Block> PEAT_GRASS_BLOCK = register("peat_grass_block", PeatGrassBlock::new, Blocks.GRASS_BLOCK);
    Supplier<Block> PEAT_DIRT = register("peat_dirt", TillableDirtBlock::new, Blocks.DIRT);
    Supplier<Block> PEAT_DIRT_PATH = register("peat_dirt_path", p -> new PeatDirtPathBlock(p.strength(0.65F).sound(SoundType.GRASS).isViewBlocking(RUBlockUtils::always).isSuffocating(RUBlockUtils::always)));
    Supplier<Block> PEAT_COARSE_DIRT = register("peat_coarse_dirt", TillableDirtBlock::new, Blocks.COARSE_DIRT);
    Supplier<Block> PEAT_PODZOL = register("peat_podzol", SnowyDirtBlock::new, Blocks.PODZOL);
    Supplier<Block> PEAT_MUD = register("peat_mud", p -> new RuMudBlock(p.mapColor(MapColor.TERRACOTTA_BROWN).randomTicks().isValidSpawn(RUBlockUtils::always).isRedstoneConductor(RUBlockUtils::always).isViewBlocking(RUBlockUtils::always).isSuffocating(RUBlockUtils::always).sound(SoundType.MUD)), Blocks.DIRT);
    Supplier<Block> PEAT_FARMLAND = register("peat_farmland", p -> new PeatFarmBlock(p.randomTicks().strength(0.6F).sound(SoundType.GRAVEL).isViewBlocking(RUBlockUtils::always).isSuffocating(RUBlockUtils::always)));
    //PLAINS_DIRT_BLOCKS
    Supplier<Block> SILT_GRASS_BLOCK = register("silt_grass_block", SiltGrassBlock::new, Blocks.GRASS_BLOCK);
    Supplier<Block> SILT_DIRT = register("silt_dirt", TillableDirtBlock::new, Blocks.DIRT);
    Supplier<Block> SILT_DIRT_PATH = register("silt_dirt_path", p -> new SiltDirtPathBlock(p.strength(0.65F).sound(SoundType.GRASS).isViewBlocking(RUBlockUtils::always).isSuffocating(RUBlockUtils::always)));
    Supplier<Block> SILT_COARSE_DIRT = register("silt_coarse_dirt", TillableDirtBlock::new, Blocks.COARSE_DIRT);
    Supplier<Block> SILT_PODZOL = register("silt_podzol", SnowyDirtBlock::new, Blocks.PODZOL);
    Supplier<Block> SILT_MUD = register("silt_mud", p -> new RuMudBlock(p.mapColor(MapColor.TERRACOTTA_YELLOW).randomTicks().isValidSpawn(RUBlockUtils::always).isRedstoneConductor(RUBlockUtils::always).isViewBlocking(RUBlockUtils::always).isSuffocating(RUBlockUtils::always).sound(SoundType.MUD)), Blocks.DIRT);
    Supplier<Block> SILT_FARMLAND = register("silt_farmland", p -> new SiltFarmBlock(p.randomTicks().strength(0.6F).sound(SoundType.GRAVEL).isViewBlocking(RUBlockUtils::always).isSuffocating(RUBlockUtils::always)));
    //OTHER_DIRT_BLOCKS
    Supplier<Block> ALPHA_GRASS_BLOCK = register("alpha_grass_block", p -> new AlphaGrassBlock(p.mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRAVEL)));

    /*-----------------STONE_BLOCKS-----------------*/
    //CHALKS
    Supplier<Block> CHALK = register("chalk", p -> new Block(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    Supplier<Block> CHALK_GRASS_BLOCK = register("chalk_grass_block", p -> new ChalkGrassBlock(p.mapColor(MapColor.GRASS).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).randomTicks().strength(0.6f).requiresCorrectToolForDrops()));
    Supplier<Block> CHALK_BRICKS = register("chalk_bricks", p -> new Block(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.6f).requiresCorrectToolForDrops()));
    Supplier<Block> CHALK_BRICK_SLAB = register("chalk_brick_slab", p -> new SlabBlock(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.6f).requiresCorrectToolForDrops()));
    Supplier<Block> CHALK_BRICK_STAIRS = register("chalk_brick_stairs", p -> new StairBlock(CHALK.get().defaultBlockState(), p), CHALK_BRICKS);
    Supplier<Block> CHALK_PILLAR = register("chalk_pillar", p -> new RotatedPillarBlock(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.6f).requiresCorrectToolForDrops()));
    Supplier<Block> CHALK_SLAB = register("chalk_slab", p -> new SlabBlock(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    Supplier<Block> CHALK_STAIRS = register("chalk_stairs", p -> new StairBlock(CHALK.get().defaultBlockState(), p), CHALK);
    Supplier<Block> POLISHED_CHALK = register("polished_chalk", p -> new Block(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    Supplier<Block> POLISHED_CHALK_SLAB = register("polished_chalk_slab", p -> new SlabBlock(p.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).strength(0.5f).requiresCorrectToolForDrops()));
    Supplier<Block> POLISHED_CHALK_STAIRS = register("polished_chalk_stairs", p -> new StairBlock(CHALK.get().defaultBlockState(), p), POLISHED_CHALK);
    //STONES
    Supplier<Block> ARGILLITE = register("argillite", p -> new Block(p.mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.CALCITE)), Blocks.STONE);
    Supplier<Block> MOSSY_STONE = register("mossy_stone", Block::new, Blocks.STONE);

    /*-----------------OCEAN_BLOCKS-----------------*/
    //HYACINTH_BLOCKS
    Supplier<Block> HYACINTH_LAMP = register("hyacinth_lamp", p -> new HyacinthLampBlock(p.noOcclusion().instabreak().sound(SoundType.DECORATED_POT).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 14)));
    Supplier<Block> HYACINTH_BLOOM = register("hyacinth_bloom", p -> new SeagrassBlock(p.replaceable().noCollission().instabreak().sound(SoundType.WET_GRASS).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 9)));
    Supplier<Block> HYACINTH_FLOWERS = register("hyacinth_flowers", p -> new GlowLichenBlock(p.replaceable().mapColor(MapColor.GLOW_LICHEN).noCollission().strength(0.2F).sound(SoundType.GLOW_LICHEN).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 8)));
    Supplier<Block> TALL_HYACINTH_STOCK = register("tall_hyacinth_stock", p -> new TallHyacinthStockBlock(p.noCollission().instabreak().sound(SoundType.WET_GRASS).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 12)));
    //SMOULDERING_WOODLAND_BLOCKS
    Supplier<Block> ASHEN_DIRT = register("ashen_dirt", p -> new AshenDirtBlock(p.mapColor(MapColor.COLOR_GRAY).strength(0.5F).sound(SoundType.GRAVEL).randomTicks().lightLevel((bs) -> AshenDirtBlock.isSmouldering(bs) ? 7 : 0)));
    Supplier<Block> ASHEN_GRASS = register("ashen_grass", p -> new AshenGrassBlock(p.pushReaction(PushReaction.DESTROY).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> AshenGrassBlock.isSmouldering(bs)).emissiveRendering((bs, br, bp) -> AshenGrassBlock.isSmouldering(bs)).lightLevel((bs) -> AshenGrassBlock.isSmouldering(bs) ? 5 : 0)));

    /*-----------------OTHER_BLOCKS-----------------*/
    Supplier<Block> ASH = register("ash", p -> new AshBlock(p.mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.GRAVEL).randomTicks()));
    Supplier<Block> ASH_VENT = register("ash_vent", p -> new AshVentBlock(p.mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).strength(1.6F).sound(SoundType.BASALT).randomTicks().requiresCorrectToolForDrops()));
    Supplier<Block> VOLCANIC_ASH = register("volcanic_ash", p -> new AshBlock(p.mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.GRAVEL).randomTicks()));

    /*-----------------WOOD_TYPES-----------------*/
    List<WoodSet> WOOD_SETS = new ArrayList<>();

    WoodSet ALPHA_WOOD_SET = WoodSet.alpha();
    WoodSet ASHEN_WOOD_SET = WoodSet.onlyLogs("ashen", SoundType.NETHER_WOOD, MapColor.COLOR_LIGHT_GRAY, MapColor.COLOR_GRAY, true, RotatedPillarBlock::new);
    WoodSet BAOBAB_WOOD_SET = WoodSet.simple("baobab", RuWoodTypes.BAOBAB, SoundType.CHERRY_WOOD, MapColor.WOOD, MapColor.TERRACOTTA_LIGHT_GRAY, false);
    WoodSet BLACKWOOD_WOOD_SET = WoodSet.simple("blackwood", RuWoodTypes.BLACKWOOD, SoundType.NETHER_WOOD, MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BROWN, false);
    BrimwoodWoodSet BRIMWOOD_WOOD_SET = BrimwoodWoodSet.brimwood("brimwood", RuWoodTypes.BRIMWOOD, SoundType.NETHER_WOOD, MapColor.COLOR_BROWN, MapColor.COLOR_ORANGE, true);
    WoodSet COBALT_WOOD_SET = WoodSet.simple("cobalt", RuWoodTypes.COBALT, SoundType.NETHER_WOOD, MapColor.COLOR_BLUE, MapColor.COLOR_BLACK, true, RotatedPillarBlock::new, false);
    WoodSet CYPRESS_WOOD_SET = WoodSet.simple("cypress", RuWoodTypes.CYPRESS, SoundType.BAMBOO_WOOD, MapColor.WOOD, MapColor.WOOD, false);
    WoodSet DEAD_WOOD_SET = WoodSet.simple("dead", RuWoodTypes.DEAD, SoundType.WOOD, MapColor.WOOD, MapColor.WOOD, true);
    WoodSet EUCALYPTUS_WOOD_SET = WoodSet.simple("eucalyptus", RuWoodTypes.EUCALYPTUS, SoundType.WOOD, MapColor.WOOD, MapColor.WOOD, false);
    WoodSet JOSHUA_WOOD_SET = WoodSet.simple("joshua", RuWoodTypes.JOSHUA, SoundType.WOOD, MapColor.WOOD, MapColor.WOOD, false);
    WoodSet KAPOK_WOOD_SET = WoodSet.simple("kapok", RuWoodTypes.KAPOK, SoundType.WOOD, MapColor.TERRACOTTA_GREEN, MapColor.WOOD, false);
    WoodSet LARCH_WOOD_SET = WoodSet.simple("larch", RuWoodTypes.LARCH, SoundType.WOOD, MapColor.WOOD, MapColor.WOOD, false);
    WoodSet MAGNOLIA_WOOD_SET = WoodSet.simple("magnolia", RuWoodTypes.MAGNOLIA, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_PINK, MapColor.STONE, false);
    WoodSet MAPLE_WOOD_SET = WoodSet.simple("maple", RuWoodTypes.MAPLE, SoundType.WOOD, MapColor.WOOD, MapColor.WOOD, false);
    WoodSet MAUVE_WOOD_SET = WoodSet.simple("mauve", RuWoodTypes.MAUVE, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_PURPLE, MapColor.PODZOL, false);
    WoodSet PALM_WOOD_SET = WoodSet.simple("palm", RuWoodTypes.PALM, SoundType.BAMBOO_WOOD, MapColor.WOOD, MapColor.WOOD, false);
    WoodSet PINE_WOOD_SET = WoodSet.simple("pine", RuWoodTypes.PINE, SoundType.BAMBOO_WOOD, MapColor.WOOD, MapColor.WOOD, false, PineLogBlock::new, true);
    WoodSet REDWOOD_WOOD_SET = WoodSet.simple("redwood", RuWoodTypes.REDWOOD, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_RED, MapColor.TERRACOTTA_RED, false);
    WoodSet SILVER_BIRCH_WOOD_SET = WoodSet.onlyLogs("silver_birch", SoundType.WOOD, MapColor.SAND, MapColor.QUARTZ, false, AspenLogBlock::new);
    WoodSet SOCOTRA_WOOD_SET = WoodSet.simple("socotra", RuWoodTypes.SOCOTRA, SoundType.CHERRY_WOOD, MapColor.TERRACOTTA_ORANGE, MapColor.TERRACOTTA_ORANGE, false);
    WoodSet WILLOW_WOOD_SET = WoodSet.simple("willow", RuWoodTypes.WILLOW, SoundType.WOOD, MapColor.WOOD, MapColor.WOOD, false);

    WoodSet PINK_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("pink_bioshroom", RuWoodTypes.PINK_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_PINK, false);
    WoodSet YELLOW_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("yellow_bioshroom", RuWoodTypes.YELLOW_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_YELLOW, true);
    WoodSet BLUE_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("blue_bioshroom", RuWoodTypes.BLUE_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_LIGHT_BLUE, false);
    WoodSet GREEN_BIOSHROOM_WOOD_SET = WoodSet.bioshroom("green_bioshroom", RuWoodTypes.GREEN_BIOSHROOM, SoundType.NETHER_WOOD, MapColor.COLOR_LIGHT_GREEN, false);


    /*-----------------PAINTED PLANKS-----------------*/
    //PLANKS
    ColoredSet PAINTED_PLANKS = new ColoredSet(color -> register(color.getName() + "_painted_planks", p -> RUBlockUtils.planks(p, color.getMapColor(), SoundType.WOOD, false)));
    ColoredSet PAINTED_STAIRS = new ColoredSet(color -> register(color.getName() + "_painted_stairs", p -> RUBlockUtils.stairs(p, color.getMapColor(), SoundType.WOOD, false)));
    ColoredSet PAINTED_SLABS = new ColoredSet(color -> register(color.getName() + "_painted_slab", p -> RUBlockUtils.slab(p, color.getMapColor(), SoundType.WOOD, false)));

    /*-----------------NETHER_BLOCKS-----------------*/
    //NETHER_STONES
    Supplier<Block> BLACKSTONE_CLUSTER = register("blackstone_cluster", p -> new RockPileBlock(p.strength(0.6F).sound(SoundType.NETHERRACK)));
    Supplier<Block> OVERGROWN_BONE_BLOCK = register("overgrown_bone_block", Block::new, Blocks.BONE_BLOCK);
    //BRIMSPROUT_BLOCKS
    Supplier<Block> BRIMSPROUT_NYLIUM = register("brimsprout_nylium", p -> new RuNyliumBlock(p.mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.SCULK_SENSOR), RuNetherFeatures.BRIMSPROUT_NYLIUM_BONEMEAL));
    Supplier<Block> BRIMSPROUT = register("brimsprout", p -> new BrimPlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.SCULK).offsetType(BlockBehaviour.OffsetType.XYZ)));
    //COBALT_BLOCKS
    Supplier<Block> COBALT_EARLIGHT = register("cobalt_earlight", p -> new RuNetherPlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 9)));
    Supplier<Block> TALL_COBALT_EARLIGHT = register("tall_cobalt_earlight", p -> new RuNetherDoublePlantBlock(p.noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 13)));
    Supplier<Block> COBALT_NYLIUM = register("cobalt_nylium", p -> new RuBlackstoneNyliumBlock(p.mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM), RuNetherFeatures.COBALT_NYLIUM_BONEMEAL));
    Supplier<Block> COBALT_OBSIDIAN = register("cobalt_obsidian", p -> new CobaltObsidianBlock(p.mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    Supplier<Block> COBALT_ROOTS = register("cobalt_roots", p -> new RuCobaltPlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    Supplier<Block> HANGING_EARLIGHT = RUBlockUtils.registerNoItem("hanging_earlight", p -> new HangingEarlightBlock(p.mapColor(MapColor.COLOR_BLUE).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 14)));
    Supplier<Block> HANGING_EARLIGHT_PLANT = RUBlockUtils.registerNoItem("hanging_earlight_plant", p -> new HangingEarlightPlantBlock(p.mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    //GLISTERING_BLOCKS
    Supplier<Block> GLISTERING_IVY = register("glistering_ivy", p -> new GlisteringIvyBlock(p.mapColor(MapColor.COLOR_LIGHT_BLUE).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15)));
    Supplier<Block> GLISTERING_IVY_PLANT = RUBlockUtils.registerNoItem("glistering_ivy_plant", p -> new GlisteringIvyPlantBlock(p.mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    Supplier<Block> GLISTERING_NYLIUM = register("glistering_nylium", p -> new RuNyliumBlock(p.mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM), RuNetherFeatures.GLISTERING_NYLIUM_BONEMEAL));
    Supplier<Block> GLISTERING_SPROUT = register("glistering_sprout", p -> new RuNetherPlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.TWISTING_VINES).offsetType(BlockBehaviour.OffsetType.XZ)));
    Supplier<Block> GLISTERING_FERN = register("glistering_fern", RuNetherPlantBlock::new, GLISTERING_SPROUT);
    Supplier<Block> GLISTERING_BLOOM = register("glistering_bloom", RuNetherPlantBlock::new, GLISTERING_SPROUT);
    Supplier<Block> GLISTERING_WART = register("glistering_wart", p -> new Block(p.mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM)));
    Supplier<Block> GLISTER_BULB = register("glister_bulb", p -> new RuNetherDoublePlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.NETHER_WART).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 13)));
    Supplier<Block> GLISTER_SPIRE = register("glister_spire", p -> new RuNetherDoublePlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 5)));
    //MYCOTOXIC_BLOCKS
    Supplier<Block> MYCOTOXIC_MUSHROOMS = register("mycotoxic_mushrooms", p -> new NetherGroundCoverBlock(p.pushReaction(PushReaction.DESTROY).noCollission().sound(SoundType.SHROOMLIGHT).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel((state) -> 3 + 3 * state.getValue(NetherGroundCoverBlock.AMOUNT))));
    Supplier<Block> MYCOTOXIC_DAISY = register("mycotoxic_daisy", p -> new RuNetherDoublePlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XYZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 4)));
    Supplier<Block> MYCOTOXIC_GRASS = register("mycotoxic_grass", p -> new RuNetherPlantBlock(p.replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    Supplier<Block> MYCOTOXIC_NYLIUM = register("mycotoxic_moss", p -> new RuNyliumBlock(p.mapColor(MapColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM), RuNetherFeatures.MYCOTOXIC_NYLIUM_BONEMEAL));
    /*-----------------POTTED_PLANTS-----------------*/
    //POTTED_FLOWERS
    Supplier<Block> POTTED_ALPHA_DANDELION = RUBlockUtils.registerNoItem("potted_alpha_dandelion", p -> new FlowerPotBlock(ALPHA_DANDELION.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_ALPHA_ROSE = RUBlockUtils.registerNoItem("potted_alpha_rose", p -> new FlowerPotBlock(ALPHA_ROSE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_ASTER = RUBlockUtils.registerNoItem("potted_aster", p -> new FlowerPotBlock(ASTER.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_BLEEDING_HEART = RUBlockUtils.registerNoItem("potted_bleeding_heart", p -> new FlowerPotBlock(BLEEDING_HEART.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_BLUE_LUPINE = RUBlockUtils.registerNoItem("potted_blue_lupine", p -> new FlowerPotBlock(BLUE_LUPINE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_DAISY = RUBlockUtils.registerNoItem("potted_daisy", p -> new FlowerPotBlock(DAISY.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_DORCEL = RUBlockUtils.registerNoItem("potted_dorcel", p -> new FlowerPotBlock(DORCEL.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_FELICIA_DAISY = RUBlockUtils.registerNoItem("potted_felicia_daisy", p -> new FlowerPotBlock(FELICIA_DAISY.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_FIREWEED = RUBlockUtils.registerNoItem("potted_fireweed", p -> new FlowerPotBlock(FIREWEED.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_HIBISCUS = RUBlockUtils.registerNoItem("potted_hibiscus", p -> new FlowerPotBlock(HIBISCUS.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_HYSSOP = RUBlockUtils.registerNoItem("potted_hyssop", p -> new FlowerPotBlock(HYSSOP.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_MALLOW = RUBlockUtils.registerNoItem("potted_mallow", p -> new FlowerPotBlock(MALLOW.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_PINK_LUPINE = RUBlockUtils.registerNoItem("potted_pink_lupine", p -> new FlowerPotBlock(PINK_LUPINE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_POPPY_BUSH = RUBlockUtils.registerNoItem("potted_poppy_bush", p -> new FlowerPotBlock(POPPY_BUSH.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_SALMON_POPPY_BUSH = RUBlockUtils.registerNoItem("potted_salmon_poppy_bush", p -> new FlowerPotBlock(SALMON_POPPY_BUSH.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_PURPLE_LUPINE = RUBlockUtils.registerNoItem("potted_purple_lupine", p -> new FlowerPotBlock(PURPLE_LUPINE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_RED_LUPINE = RUBlockUtils.registerNoItem("potted_red_lupine", p -> new FlowerPotBlock(RED_LUPINE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_TSUBAKI = RUBlockUtils.registerNoItem("potted_tsubaki", p -> new FlowerPotBlock(TSUBAKI.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_ORANGE_CONEFLOWER = RUBlockUtils.registerNoItem("potted_orange_coneflower", p -> new FlowerPotBlock(ORANGE_CONEFLOWER.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_PURPLE_CONEFLOWER = RUBlockUtils.registerNoItem("potted_purple_coneflower", p -> new FlowerPotBlock(PURPLE_CONEFLOWER.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_WARATAH = RUBlockUtils.registerNoItem("potted_waratah", p -> new FlowerPotBlock(WARATAH.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_WHITE_TRILLIUM = RUBlockUtils.registerNoItem("potted_white_trillium", p -> new FlowerPotBlock(WHITE_TRILLIUM.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_WILTING_TRILLIUM = RUBlockUtils.registerNoItem("potted_wilting_trillium", p -> new FlowerPotBlock(WILTING_TRILLIUM.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_YELLOW_LUPINE = RUBlockUtils.registerNoItem("potted_yellow_lupine", p -> new FlowerPotBlock(YELLOW_LUPINE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_GLISTERING_BLOOM = RUBlockUtils.registerNoItem("potted_glistering_bloom", p -> new FlowerPotBlock(GLISTERING_BLOOM.get(), p), Blocks.POTTED_ALLIUM);
    //OTHER_POTS
    Supplier<Block> POTTED_DAY_LILY = RUBlockUtils.registerNoItem("potted_day_lily", p -> new FlowerPotBlock(DAY_LILY.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_MEADOW_SAGE = RUBlockUtils.registerNoItem("potted_meadow_sage", p -> new FlowerPotBlock(MEADOW_SAGE.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_DUSKTRAP = RUBlockUtils.registerNoItem("potted_dusktrap", p -> new FlowerPotBlock(DUSKTRAP.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_CORPSE_FLOWER = RUBlockUtils.registerNoItem("potted_corpse_flower", p -> new FlowerPotBlock(CORPSE_FLOWER.get(), p), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_COBALT_EARLIGHT = RUBlockUtils.registerNoItem("potted_cobalt_earlight", p -> new FlowerPotBlock(COBALT_EARLIGHT.get(), p.lightLevel(s -> 8)), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_TALL_COBALT_EARLIGHT = RUBlockUtils.registerNoItem("potted_tall_cobalt_earlight", p -> new FlowerPotBlock(TALL_COBALT_EARLIGHT.get(), p.lightLevel(s -> 8)), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_MYCOTOXIC_DAISY = RUBlockUtils.registerNoItem("potted_mycotoxic_daisy", p -> new FlowerPotBlock(MYCOTOXIC_DAISY.get(), p.lightLevel(s -> 8)), Blocks.POTTED_ALLIUM);
    Supplier<Block> POTTED_GLISTER_SPIRE = RUBlockUtils.registerNoItem("potted_glister_spire", p -> new FlowerPotBlock(GLISTER_SPIRE.get(), p), Blocks.POTTED_ALLIUM);
    //POTTED_MUSHROOMS
    Supplier<Block> POTTED_BLUE_BIOSHROOM = RUBlockUtils.registerNoItem("potted_blue_bioshroom", p -> new FlowerPotBlock(BLUE_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_GREEN_BIOSHROOM = RUBlockUtils.registerNoItem("potted_green_bioshroom", p -> new FlowerPotBlock(GREEN_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_PINK_BIOSHROOM = RUBlockUtils.registerNoItem("potted_pink_bioshroom", p -> new FlowerPotBlock(PINK_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_YELLOW_BIOSHROOM = RUBlockUtils.registerNoItem("potted_yellow_bioshroom", p -> new FlowerPotBlock(YELLOW_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_TALL_BLUE_BIOSHROOM = RUBlockUtils.registerNoItem("potted_tall_blue_bioshroom", p -> new FlowerPotBlock(TALL_BLUE_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_TALL_GREEN_BIOSHROOM = RUBlockUtils.registerNoItem("potted_tall_green_bioshroom", p -> new FlowerPotBlock(TALL_GREEN_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_TALL_PINK_BIOSHROOM = RUBlockUtils.registerNoItem("potted_tall_pink_bioshroom", p -> new FlowerPotBlock(TALL_PINK_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    Supplier<Block> POTTED_TALL_YELLOW_BIOSHROOM = RUBlockUtils.registerNoItem("potted_tall_yellow_bioshroom", p -> new FlowerPotBlock(TALL_YELLOW_BIOSHROOM.get(), p.lightLevel(s -> 10)), Blocks.POTTED_BROWN_MUSHROOM);
    //OTHER_POTTED_PLANTS
    Supplier<Block> POTTED_BARREL_CACTUS = RUBlockUtils.registerNoItem("potted_barrel_cactus", p -> new FlowerPotBlock(BARREL_CACTUS.get(), p), Blocks.POTTED_CACTUS);
    Supplier<Block> POTTED_CAVE_HYSSOP = RUBlockUtils.registerNoItem("potted_cave_hyssop", p -> new FlowerPotBlock(CAVE_HYSSOP.get(), p), Blocks.POTTED_ALLIUM);
    //SNOWBELLES
    ColoredSet SNOWBELLES = new ColoredSet(color -> register(color.getName() + "_snowbelle", p -> new RuFlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 10, p), Blocks.DANDELION));
    ColoredSet POTTED_SNOWBELLES = new ColoredSet(color -> RUBlockUtils.registerNoItem("potted_" + color.getName() + "_snowbelle", p -> new FlowerPotBlock(SNOWBELLES.getMap().get(color), p), Blocks.POTTED_ALLIUM));

    Map<Identifier, Identifier> BLOCK_ALIASES = Map.of(
        id("cactus_flower"), id("saguaro_cactus_flower"),
        id("potted_cactus_flower"), id("potted_saguaro_cactus_flower")
        //id("maple_leaf_pile"), id("maple_leaf_litter"),
        //id("red_maple_leaf_pile"), id("red_maple_leaf_litter"),
        //id("orange_maple_leaf_pile"), id("orange_maple_leaf_litter"),
        //id("silver_birch_leaf_pile"), id("silver_birch_leaf_litter"),
        //id("enchanted_birch_leaf_pile"), id("enchanted_birch_leaf_litter"),
    );

    static void init() {
    }
}
