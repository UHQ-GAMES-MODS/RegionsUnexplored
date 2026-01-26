package net.regions_unexplored.data.worldgen.biome.surface;

import com.google.common.collect.ImmutableList;
import dev.worldgen.lithostitched.worldgen.surface.condition.SlopeCondition;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.registry.data.RUNoises;
import net.regions_unexplored.data.noise.RuleWeight;
import net.regions_unexplored.registry.data.RUBiomes;

public class RuSurfaceRuleData {
    //FILL_BLOCKS
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.CAVE_AIR);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource LAVA = makeStateRule(Blocks.LAVA);

    //PEAT_BLOCKS
    private static final SurfaceRules.RuleSource PEAT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PEAT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PEAT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_PODZOL.get() : Blocks.PODZOL);
    private static final SurfaceRules.RuleSource PEAT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_DIRT.get() : Blocks.DIRT);
    private static final SurfaceRules.RuleSource PEAT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_MUD.get() : Blocks.MUD);

    //SILT_BLOCKS
    private static final SurfaceRules.RuleSource SILT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SILT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SILT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_PODZOL.get() : Blocks.PODZOL);
    private static final SurfaceRules.RuleSource SILT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_DIRT.get() : Blocks.DIRT);
    private static final SurfaceRules.RuleSource SILT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_MUD.get() : Blocks.MUD);

    //DIRT_BLOCKS
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource MOSS_BLOCK = makeStateRule(Blocks.MOSS_BLOCK);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);

    //ASHEN_BLOCKS
    private static final SurfaceRules.RuleSource ASHEN_DIRT = makeStateRule(RUBlocks.ASHEN_DIRT.get());
    private static final SurfaceRules.RuleSource ASH_VENT = makeStateRule(RUBlocks.ASH_VENT.get());

    //ALPHA_BLOCKS
    private static final SurfaceRules.RuleSource ALPHA_GRASS = makeStateRule(RUBlocks.ALPHA_GRASS_BLOCK.get());

    //STONE_BLOCKS
    private static final SurfaceRules.RuleSource ARGILLITE_GRASS_BLOCK = makeStateRule(RUBlocks.ARGILLITE_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource CHALK_GRASS_BLOCK = makeStateRule(RUBlocks.CHALK_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource PRISMOSS = makeStateRule(RUBlocks.PRISMOSS.get());
    private static final SurfaceRules.RuleSource VIRIDESCENT_NYLIUM = makeStateRule(RUBlocks.VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_PRISMOSS = makeStateRule(RUBlocks.DEEPSLATE_PRISMOSS.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_VIRIDESCENT_NYLIUM = makeStateRule(RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource ARGILLITE = makeStateRule(RUBlocks.ARGILLITE.get());
    private static final SurfaceRules.RuleSource CHALK = makeStateRule(RUBlocks.CHALK.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);

    //OTHER_STONE_BLOCKS
    private static final SurfaceRules.RuleSource RAW_REDSTONE = makeStateRule(RUBlocks.RAW_REDSTONE_BLOCK.get());
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final SurfaceRules.RuleSource MOSSY_STONE = makeStateRule(RUBlocks.MOSSY_STONE.get());
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);

    //GRAVITY_BLOCKS
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource ASH = makeStateRule(RUBlocks.ASH.get());

    //COLD_BLOCKS
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);

    //NETHER_BLOCKS
    private static final SurfaceRules.RuleSource BRIMSPROUT_NYLIUM = makeStateRule(RUBlocks.BRIMSPROUT_NYLIUM.get());
    private static final SurfaceRules.RuleSource MYCOTOXIC_NYLIUM = makeStateRule(RUBlocks.MYCOTOXIC_NYLIUM.get());
    private static final SurfaceRules.RuleSource GLISTERING_NYLIUM = makeStateRule(RUBlocks.GLISTERING_NYLIUM.get());
    private static final SurfaceRules.RuleSource GLISTERING_WART = makeStateRule(RUBlocks.GLISTERING_WART.get());
    private static final SurfaceRules.RuleSource COBALT_NYLIUM = makeStateRule(RUBlocks.COBALT_NYLIUM.get());
    private static final SurfaceRules.RuleSource SOUL_SAND = makeStateRule(Blocks.SOUL_SAND);
    private static final SurfaceRules.RuleSource SOUL_SOIL = makeStateRule(Blocks.SOUL_SOIL);
    private static final SurfaceRules.RuleSource BASALT = makeStateRule(Blocks.BASALT);
    private static final SurfaceRules.RuleSource WARPED_WART_BLOCK = makeStateRule(Blocks.WARPED_WART_BLOCK);
    private static final SurfaceRules.RuleSource WARPED_NYLIUM = makeStateRule(Blocks.WARPED_NYLIUM);
    private static final SurfaceRules.RuleSource NETHER_WART_BLOCK = makeStateRule(Blocks.NETHER_WART_BLOCK);
    private static final SurfaceRules.RuleSource CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);

    //stateRule Method
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource cave() {
        return overworldLike(false, false, true);
    }

    public static SurfaceRules.RuleSource overworld() {
        return overworldLike(true, false, true);
    }

    public static SurfaceRules.RuleSource overworldLike(boolean isSurface, boolean bedrockRoof, boolean bedrockFloor) {
        SurfaceRules.ConditionSource deepslateLevel = SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8));

        SurfaceRules.ConditionSource yStart63 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource yStart74 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);

        SurfaceRules.ConditionSource y60 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource y97 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.ConditionSource y256 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);

        SurfaceRules.ConditionSource surfaceNoise1 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
        SurfaceRules.ConditionSource surfaceNoise2 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
        SurfaceRules.ConditionSource surfaceNoise3 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

        SurfaceRules.ConditionSource waterBlockCheck = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource waterBlockCheck1 = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.ConditionSource oceanGravelCheck = SurfaceRules.waterStartCheck(-6, -1);

        SurfaceRules.ConditionSource holeCondition = SurfaceRules.hole();
        SurfaceRules.ConditionSource steepCondition = SurfaceRules.steep();

        SurfaceRules.ConditionSource isSandBiome = SurfaceRules.isBiome(RUBiomes.ROCKY_REEF, RUBiomes.TROPICAL_RIVER, RUBiomes.GRASSY_BEACH);
        SurfaceRules.ConditionSource isPeatBiome = SurfaceRules.isBiome(RUBiomes.BAYOU, RUBiomes.FEN, RUBiomes.PINE_TAIGA, RUBiomes.BLACKWOOD_TAIGA, RUBiomes.BOREAL_TAIGA, RUBiomes.COLD_BOREAL_TAIGA, RUBiomes.GOLDEN_BOREAL_TAIGA);
        SurfaceRules.ConditionSource isSiltBiome = SurfaceRules.isBiome(RUBiomes.PUMPKIN_FIELDS, RUBiomes.POPPY_FIELDS, RUBiomes.AUTUMNAL_MAPLE_FOREST, RUBiomes.SILVER_BIRCH_FOREST, RUBiomes.TROPICS, RUBiomes.DRY_BUSHLAND, RUBiomes.JOSHUA_DESERT, RUBiomes.BARLEY_FIELDS, RUBiomes.PRAIRIE, RUBiomes.ORCHARD, RUBiomes.STEPPE);
        SurfaceRules.ConditionSource isGrassBiome = SurfaceRules.isBiome(RUBiomes.ANCIENT_DELTA, RUBiomes.BAOBAB_SAVANNA, RUBiomes.BIOSHROOM_CAVES, RUBiomes.DECIDUOUS_FOREST, RUBiomes.FROZEN_TUNDRA, RUBiomes.FUNGAL_FEN, RUBiomes.PRISMACHASM, RUBiomes.REDSTONE_CAVES, RUBiomes.SCORCHING_CAVES);

        SurfaceRules.RuleSource AlphaGrassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, ALPHA_GRASS), DIRT);
        SurfaceRules.RuleSource GrassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource PeatGrassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, PEAT_GRASS_BLOCK), PEAT_DIRT);
        SurfaceRules.RuleSource SiltGrassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, SILT_GRASS_BLOCK), SILT_DIRT);
        SurfaceRules.RuleSource ChalkSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, CHALK_GRASS_BLOCK), CHALK);
        SurfaceRules.RuleSource ArgilliteSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, ARGILLITE_GRASS_BLOCK), ARGILLITE);
        SurfaceRules.RuleSource ViridescentSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, VIRIDESCENT_NYLIUM), STONE);
        SurfaceRules.RuleSource DeepslateViridescentSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, DEEPSLATE_VIRIDESCENT_NYLIUM), DEEPSLATE);
        SurfaceRules.RuleSource PrismossSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, PRISMOSS), STONE);
        SurfaceRules.RuleSource DeepslatePrismossSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(waterBlockCheck, DEEPSLATE_PRISMOSS), DEEPSLATE);

        SurfaceRules.RuleSource sandWithSandstoneOverhang = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource redSandWithSandstoneOverhang = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND);
        SurfaceRules.RuleSource gravelWithStoneOverhang = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);

        SurfaceRules.RuleSource powderSnowPatch1 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), SurfaceRules.ifTrue(waterBlockCheck, POWDER_SNOW));
        SurfaceRules.RuleSource powderSnowPatch2 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D), SurfaceRules.ifTrue(waterBlockCheck, POWDER_SNOW));


        SurfaceRules.RuleSource deepSurfaceBlocks = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.CHALK_CLIFFS), CHALK),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ARID_MOUNTAINS, RUBiomes.BAOBAB_SAVANNA), TERRACOTTA)
        );

        SurfaceRules.RuleSource CaveRules = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.REDSTONE_CAVES), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(40)), RAW_REDSTONE))),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.BIOSHROOM_CAVES), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(deepslateLevel, DeepslateViridescentSurface), ViridescentSurface))),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ANCIENT_DELTA), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.SHIELD, -0.95D), ArgilliteSurface)), ARGILLITE)),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.PRISMACHASM),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(deepslateLevel, SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), DeepslatePrismossSurface), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), DeepslatePrismossSurface))),
                                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), PrismossSurface), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), PrismossSurface))))))),

                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ANCIENT_DELTA), ARGILLITE))
        );

        SurfaceRules.RuleSource underSurfaceNoTop = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.MOUNTAINS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)), DIRT),
                                SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(186), 0), SNOW_BLOCK),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), CALCITE), STONE)),


                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ICY_HEIGHTS, RUBiomes.SPIRES), SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SNOW_BLOCK)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ARID_MOUNTAINS), TERRACOTTA),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.BAOBAB_SAVANNA),
                        SurfaceRules.ifTrue(surfaceNoiseAbove(1.9D), TERRACOTTA)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.JOSHUA_DESERT), SurfaceRules.ifTrue(shieldNoise(0.0D), sandWithSandstoneOverhang)),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.SAGUARO_DESERT), sandWithSandstoneOverhang),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.OUTBACK), SurfaceRules.sequence(
                    SurfaceRules.ifTrue(
                        shieldNoise(-0.2d, 0.2d), TERRACOTTA
                    ),
                    SurfaceRules.ifTrue(
                        shieldNoise(-0.5d, 0.5d), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(50)), TERRACOTTA)
                    ),
                    SurfaceRules.ifTrue(
                        shieldNoise(0.2d), redSandWithSandstoneOverhang
                    )
                )),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ALPHA_GROVE),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0)), gravelWithStoneOverhang), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, AlphaGrassSurface), DIRT)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.TROPICS), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), sandWithSandstoneOverhang)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.MUDDY_RIVER), PEAT_MUD),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.COLD_RIVER, RUBiomes.GRAVEL_BEACH), gravelWithStoneOverhang),

                SurfaceRules.ifTrue(isSandBiome, sandWithSandstoneOverhang)
        );

        SurfaceRules.RuleSource underSurface = SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ICY_HEIGHTS, RUBiomes.SPIRES, RUBiomes.FROZEN_PINE_TAIGA), powderSnowPatch1),

                underSurfaceNoTop,

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.TOWERING_CLIFFS), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.MAPLE_FOREST), SurfaceRules.ifTrue(shieldNoise(1.65D), STONE)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.HYACINTH_DEEPS), STONE),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ASHEN_WOODLAND), ASHEN_DIRT),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.OLD_GROWTH_BAYOU), SurfaceRules.sequence(
                        SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), MUD),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MUD)))),

                SurfaceRules.ifTrue(isPeatBiome, PEAT_DIRT),
                SurfaceRules.ifTrue(isSiltBiome, SILT_DIRT),
                SurfaceRules.ifTrue(isGrassBiome, DIRT)
        );

        SurfaceRules.RuleSource onSurface = SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.FROZEN_PINE_TAIGA),
                        SurfaceRules.sequence(powderSnowPatch2,
                                SurfaceRules.ifTrue(waterBlockCheck, SNOW_BLOCK))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.FROZEN_TUNDRA),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SNOW_BLOCK)),

                underSurfaceNoTop,

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.TOWERING_CLIFFS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), COBBLESTONE),
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), GRAVEL), STONE)),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),
                                        COBBLESTONE)))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.MAPLE_FOREST),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), STONE),
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MOSSY_STONE), STONE)),
                                SurfaceRules.ifTrue(shieldNoise(0.0D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT), MOSSY_STONE)))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.DECIDUOUS_FOREST),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.PINE_TAIGA),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), PEAT_COARSE_DIRT),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PEAT_PODZOL))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.PUMPKIN_FIELDS), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.75D), SILT_PODZOL)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.POPPY_FIELDS),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(50)), SILT_COARSE_DIRT)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.DRY_BUSHLAND),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), SILT_COARSE_DIRT)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.FEN),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.1D), PEAT_COARSE_DIRT))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.FUNGAL_FEN),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), MYCELIUM),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.WEIGHTED, 0.1D), MYCELIUM)))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ASHEN_WOODLAND),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), ASHEN_DIRT),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(4)), ASH_VENT), ASH)),//BA

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.BAYOU),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), PEAT_MUD))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.OLD_GROWTH_BAYOU),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), MUD), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MUD))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.TROPICS),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), sandWithSandstoneOverhang))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.BAOBAB_SAVANNA), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.PINE_SLOPES), COARSE_DIRT),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.REDWOODS), PODZOL),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.CHALK_CLIFFS), SurfaceRules.ifTrue(SurfaceRules.not(new SlopeCondition(new InclusiveRange<>(3, Integer.MAX_VALUE))), ChalkSurface)),
                SurfaceRules.ifTrue(isPeatBiome, PeatGrassSurface),
                SurfaceRules.ifTrue(isSiltBiome, SiltGrassSurface),
                SurfaceRules.ifTrue(isGrassBiome, GrassSurface)
        );

        SurfaceRules.RuleSource buildSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.FEN),
                                SurfaceRules.ifTrue(y62,
                                        SurfaceRules.ifTrue(SurfaceRules.not(y63), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RUNoises.WEIGHTED, 0.0D), WATER))))

                )),

                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                        SurfaceRules.ifTrue(waterBlockCheck1, onSurface),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.HYACINTH_DEEPS),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), MOSSY_STONE), GRAVEL))
                )),

                SurfaceRules.ifTrue(oceanGravelCheck, SurfaceRules.sequence(
                        //Comment Out for future Use
                        /*SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(*ocean biome here*, SurfaceRules.ifTrue(holeCondition, WATER))),*/

                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, deepSurfaceBlocks),

                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, underSurface),

                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.ifTrue(isSandBiome, SANDSTONE)),

                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.SAGUARO_DESERT), SANDSTONE),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ICY_HEIGHTS, RUBiomes.SPIRES), PACKED_ICE))))),

                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.ROCKY_REEF), sandWithSandstoneOverhang)))
        );

        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        if (bedrockRoof) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK));
        }

        if (bedrockFloor) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        }

        SurfaceRules.RuleSource surfaceBlocks = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), buildSurface);

        builder.add(isSurface ? surfaceBlocks : buildSurface);
        builder.add(CaveRules);
        builder.add(SurfaceRules.ifTrue(deepslateLevel, DEEPSLATE));

        return SurfaceRules.sequence(builder.build().toArray((rules) -> {
            return new SurfaceRules.RuleSource[rules];
        }));
    }

    public static SurfaceRules.RuleSource nether() {
        SurfaceRules.ConditionSource above31 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0);
        SurfaceRules.ConditionSource above32 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 0);
        SurfaceRules.ConditionSource start30 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(30), 0);
        SurfaceRules.ConditionSource end35 = SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(35), 0));
        SurfaceRules.ConditionSource belowTop5 = SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0);
        SurfaceRules.ConditionSource hole = SurfaceRules.hole();
        SurfaceRules.ConditionSource soulSandLayerNoise = SurfaceRules.noiseCondition(Noises.SOUL_SAND_LAYER, -0.012D);
        SurfaceRules.ConditionSource gravelLayerNoise = SurfaceRules.noiseCondition(Noises.GRAVEL_LAYER, -0.012D);
        SurfaceRules.ConditionSource patchNoise = SurfaceRules.noiseCondition(Noises.PATCH, -0.012D);
        SurfaceRules.ConditionSource netherrackNoise = SurfaceRules.noiseCondition(Noises.NETHERRACK, 0.54D);
        SurfaceRules.ConditionSource wartNoise = SurfaceRules.noiseCondition(Noises.NETHER_WART, 1.17D);
        SurfaceRules.ConditionSource stateSelectorNoise = SurfaceRules.noiseCondition(Noises.NETHER_STATE_SELECTOR, 0.0D);
        SurfaceRules.RuleSource gravelPatch =
                SurfaceRules.ifTrue(patchNoise,
                        SurfaceRules.ifTrue(start30,
                                SurfaceRules.ifTrue(end35, GRAVEL)));

        return SurfaceRules.sequence(
                //Nether Roof/Floor
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),
                SurfaceRules.ifTrue(belowTop5, NETHERRACK),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.INFERNAL_HOLT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.ifTrue(stateSelectorNoise, SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.UNDER_FLOOR), BLACKSTONE))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(netherrackNoise, BLACKSTONE)))),

                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.not(above32), SurfaceRules.ifTrue(hole, LAVA)),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.BLACKSTONE_BASIN), SurfaceRules.sequence(SurfaceRules.ifTrue(netherrackNoise, BLACKSTONE), SurfaceRules.ifTrue(above31, COBALT_NYLIUM))),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.GLISTERING_MEADOW), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(Noises.NETHERRACK, 0.45D)), SurfaceRules.ifTrue(above31, SurfaceRules.sequence(SurfaceRules.ifTrue(wartNoise, GLISTERING_WART), GLISTERING_NYLIUM)))),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.MYCOTOXIC_UNDERGROWTH), SurfaceRules.ifTrue(SurfaceRules.not(netherrackNoise), SurfaceRules.ifTrue(above31, SurfaceRules.sequence(SurfaceRules.ifTrue(wartNoise, NETHERRACK), MYCOTOXIC_NYLIUM)))),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.INFERNAL_HOLT), SurfaceRules.sequence(SurfaceRules.ifTrue(netherrackNoise, BLACKSTONE), SurfaceRules.ifTrue(above31, BRIMSPROUT_NYLIUM)))
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.BLACKSTONE_BASIN), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.ifTrue(stateSelectorNoise, BLACKSTONE)), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, BLACKSTONE))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RUBiomes.REDSTONE_ABYSS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(soulSandLayerNoise, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(hole), SurfaceRules.ifTrue(start30, SurfaceRules.ifTrue(end35, SOUL_SAND))), NETHERRACK))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(above31, SurfaceRules.ifTrue(end35, SurfaceRules.ifTrue(gravelLayerNoise, SurfaceRules.sequence(SurfaceRules.ifTrue(above32, GRAVEL), SurfaceRules.ifTrue(SurfaceRules.not(hole), GRAVEL))))))))
        );
    }

    public static SurfaceRules.RuleSource end() {
        return END_STONE;
    }

    public static SurfaceRules.RuleSource air() {
        return AIR;
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource shieldNoise(double min, double max) {
        return SurfaceRules.noiseCondition(RUNoises.SHIELD, min / 8.25D, max / 8.25D);
    }

    private static SurfaceRules.ConditionSource shieldNoise(double noise) {
        return SurfaceRules.noiseCondition(RUNoises.SHIELD, noise / 8.25D, Double.MAX_VALUE);
    }

}