package net.regions_unexplored.world.surface;

import com.google.common.collect.ImmutableList;
import dev.worldgen.lithostitched.worldgen.surface.condition.SlopeCondition;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.registry.data.RUNoises;
import net.regions_unexplored.registry.data.RUBiomes;
import net.regions_unexplored.world.level.block.other_dirt.AshenDirtBlock;

import java.util.function.Supplier;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class RUSurfaceRuleBuilder {
    //FILL_BLOCKS
    private static final RuleSource AIR = makeStateRule(Blocks.CAVE_AIR);
    private static final RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final RuleSource LAVA = makeStateRule(Blocks.LAVA);

    //PEAT_BLOCKS
    private static final RuleSource PEAT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final RuleSource PEAT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final RuleSource PEAT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_PODZOL.get() : Blocks.PODZOL);
    private static final RuleSource PEAT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_DIRT.get() : Blocks.DIRT);
    private static final RuleSource PEAT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.PEAT_MUD.get() : Blocks.MUD);

    //SILT_BLOCKS
    private static final RuleSource SILT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final RuleSource SILT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final RuleSource SILT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_PODZOL.get() : Blocks.PODZOL);
    private static final RuleSource SILT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_DIRT.get() : Blocks.DIRT);
    private static final RuleSource SILT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RUBlocks.SILT_MUD.get() : Blocks.MUD);

    //DIRT_BLOCKS
    private static final RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final RuleSource MOSS_BLOCK = makeStateRule(Blocks.MOSS_BLOCK);
    private static final RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final RuleSource MUD = makeStateRule(Blocks.MUD);

    //ASHEN_BLOCKS
    private static final RuleSource ASHEN_DIRT = makeStateRule(RUBlocks.ASHEN_DIRT.get());
    private static final RuleSource ASH_VENT = makeStateRule(RUBlocks.ASH_VENT.get());

    //ALPHA_BLOCKS
    private static final RuleSource ALPHA_GRASS = makeStateRule(RUBlocks.ALPHA_GRASS_BLOCK.get());

    //STONE_BLOCKS
    private static final RuleSource ARGILLITE_GRASS_BLOCK = makeStateRule(RUBlocks.ARGILLITE_GRASS_BLOCK.get());
    private static final RuleSource CHALK_GRASS_BLOCK = makeStateRule(RUBlocks.CHALK_GRASS_BLOCK.get());
    private static final RuleSource PRISMOSS = makeStateRule(RUBlocks.PRISMOSS.get());
    private static final RuleSource VIRIDESCENT_NYLIUM = makeStateRule(RUBlocks.VIRIDESCENT_NYLIUM.get());
    private static final RuleSource DEEPSLATE_PRISMOSS = makeStateRule(RUBlocks.DEEPSLATE_PRISMOSS.get());
    private static final RuleSource DEEPSLATE_VIRIDESCENT_NYLIUM = makeStateRule(RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    private static final RuleSource ARGILLITE = makeStateRule(RUBlocks.ARGILLITE.get());
    private static final RuleSource CHALK = makeStateRule(RUBlocks.CHALK.get());
    private static final RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final RuleSource CALCITE = makeStateRule(Blocks.STONE);
    private static final RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final RuleSource END_STONE = makeStateRule(Blocks.END_STONE);
    private static final RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);

    //OTHER_STONE_BLOCKS
    private static final RuleSource RAW_REDSTONE = makeStateRule(RUBlocks.RAW_REDSTONE_BLOCK.get());
    private static final RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final RuleSource MOSSY_STONE = makeStateRule(RUBlocks.MOSSY_STONE.get());
    private static final RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);

    //GRAVITY_BLOCKS
    private static final RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final RuleSource ASH = makeStateRule(RUBlocks.ASH.get());

    //COLD_BLOCKS
    private static final RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final RuleSource ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);

    //NETHER_BLOCKS
    private static final RuleSource BRIMSPROUT_NYLIUM = makeStateRule(RUBlocks.BRIMSPROUT_NYLIUM.get());
    private static final RuleSource MYCOTOXIC_NYLIUM = makeStateRule(RUBlocks.MYCOTOXIC_NYLIUM.get());
    private static final RuleSource GLISTERING_NYLIUM = makeStateRule(RUBlocks.GLISTERING_NYLIUM.get());
    private static final RuleSource GLISTERING_WART = makeStateRule(RUBlocks.GLISTERING_WART.get());
    private static final RuleSource COBALT_NYLIUM = makeStateRule(RUBlocks.COBALT_NYLIUM.get());
    private static final RuleSource SOUL_SAND = makeStateRule(Blocks.SOUL_SAND);
    private static final RuleSource SOUL_SOIL = makeStateRule(Blocks.SOUL_SOIL);
    private static final RuleSource BASALT = makeStateRule(Blocks.BASALT);
    private static final RuleSource WARPED_WART_BLOCK = makeStateRule(Blocks.WARPED_WART_BLOCK);
    private static final RuleSource WARPED_NYLIUM = makeStateRule(Blocks.WARPED_NYLIUM);
    private static final RuleSource NETHER_WART_BLOCK = makeStateRule(Blocks.NETHER_WART_BLOCK);
    private static final RuleSource CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);

    //stateRule Method
    private static RuleSource makeStateRule(Block block) {
        return state(block.defaultBlockState());
    }

    public static RuleSource cave() {
        return overworldLike(false, false, true);
    }

    public static RuleSource overworld() {
        return overworldLike(true, false, true);
    }

    public static RuleSource overworldLike(boolean isSurface, boolean bedrockRoof, boolean bedrockFloor) {
        ConditionSource deepslateLevel = verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8));

        ConditionSource yStart63 = yStartCheck(VerticalAnchor.absolute(63), -1);
        ConditionSource yStart74 = yStartCheck(VerticalAnchor.absolute(74), 1);

        ConditionSource y60 = yBlockCheck(VerticalAnchor.absolute(60), 0);
        ConditionSource y62 = yBlockCheck(VerticalAnchor.absolute(62), 0);
        ConditionSource y63 = yBlockCheck(VerticalAnchor.absolute(63), 0);
        ConditionSource y97 = yBlockCheck(VerticalAnchor.absolute(97), 2);
        ConditionSource y256 = yBlockCheck(VerticalAnchor.absolute(256), 0);

        ConditionSource surfaceNoise1 = noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
        ConditionSource surfaceNoise2 = noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
        ConditionSource surfaceNoise3 = noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

        ConditionSource waterBlockCheck = waterBlockCheck(0, 0);
        ConditionSource waterBlockCheck1 = waterBlockCheck(-1, 0);

        ConditionSource oceanGravelCheck = waterStartCheck(-6, -1);

        ConditionSource holeCondition = hole();
        ConditionSource steepCondition = steep();

        ConditionSource isSandBiome = isBiome(RUBiomes.ROCKY_REEF, RUBiomes.TROPICAL_RIVER, RUBiomes.GRASSY_BEACH);
        ConditionSource isPeatBiome = isBiome(RUBiomes.BAYOU, RUBiomes.FEN, RUBiomes.PINE_TAIGA, RUBiomes.BLACKWOOD_TAIGA, RUBiomes.BOREAL_TAIGA, RUBiomes.COLD_BOREAL_TAIGA, RUBiomes.GOLDEN_BOREAL_TAIGA);
        ConditionSource isSiltBiome = isBiome(RUBiomes.PUMPKIN_FIELDS, RUBiomes.POPPY_FIELDS, RUBiomes.AUTUMNAL_MAPLE_FOREST, RUBiomes.SILVER_BIRCH_FOREST, RUBiomes.TROPICS, RUBiomes.DRY_BUSHLAND, RUBiomes.JOSHUA_DESERT, RUBiomes.BARLEY_FIELDS, RUBiomes.PRAIRIE, RUBiomes.ORCHARD, RUBiomes.STEPPE);
        ConditionSource isGrassBiome = isBiome(RUBiomes.ANCIENT_DELTA, RUBiomes.BAOBAB_SAVANNA, RUBiomes.BIOSHROOM_CAVES, RUBiomes.DECIDUOUS_FOREST, RUBiomes.FROZEN_TUNDRA, RUBiomes.FUNGAL_FEN, RUBiomes.PRISMACHASM, RUBiomes.REDSTONE_CAVES, RUBiomes.SCORCHING_CAVES);

        RuleSource AlphaGrassSurface = sequence(ifTrue(waterBlockCheck, ALPHA_GRASS), DIRT);
        RuleSource GrassSurface = sequence(ifTrue(waterBlockCheck, GRASS_BLOCK), DIRT);
        RuleSource PeatGrassSurface = sequence(ifTrue(waterBlockCheck, PEAT_GRASS_BLOCK), PEAT_DIRT);
        RuleSource SiltGrassSurface = sequence(ifTrue(waterBlockCheck, SILT_GRASS_BLOCK), SILT_DIRT);
        RuleSource ChalkSurface = sequence(ifTrue(waterBlockCheck, CHALK_GRASS_BLOCK), CHALK);
        RuleSource ArgilliteSurface = sequence(ifTrue(waterBlockCheck, ARGILLITE_GRASS_BLOCK), ARGILLITE);
        RuleSource ViridescentSurface = sequence(ifTrue(waterBlockCheck, VIRIDESCENT_NYLIUM), STONE);
        RuleSource DeepslateViridescentSurface = sequence(ifTrue(waterBlockCheck, DEEPSLATE_VIRIDESCENT_NYLIUM), DEEPSLATE);
        RuleSource PrismossSurface = sequence(ifTrue(waterBlockCheck, PRISMOSS), STONE);
        RuleSource DeepslatePrismossSurface = sequence(ifTrue(waterBlockCheck, DEEPSLATE_PRISMOSS), DEEPSLATE);

        RuleSource sandWithSandstoneOverhang = sequence(ifTrue(ON_CEILING, SANDSTONE), SAND);
        RuleSource redSandWithSandstoneOverhang = sequence(ifTrue(ON_CEILING, RED_SANDSTONE), RED_SAND);
        RuleSource gravelWithStoneOverhang = sequence(ifTrue(ON_CEILING, STONE), GRAVEL);

        RuleSource powderSnowPatch1 = ifTrue(noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), ifTrue(waterBlockCheck, POWDER_SNOW));
        RuleSource powderSnowPatch2 = ifTrue(noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D), ifTrue(waterBlockCheck, POWDER_SNOW));


        RuleSource deepSurfaceBlocks = sequence(
                ifTrue(isBiome(RUBiomes.CHALK_CLIFFS), CHALK),

                ifTrue(isBiome(RUBiomes.ARID_MOUNTAINS, RUBiomes.BAOBAB_SAVANNA), TERRACOTTA)
        );

        RuleSource CaveRules = sequence(
                ifTrue(UNDER_FLOOR, sequence(
                        ifTrue(isBiome(RUBiomes.REDSTONE_CAVES), ifTrue(noiseCondition(Noises.SWAMP, 0.0D), ifTrue(noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(40)), RAW_REDSTONE))),

                        ifTrue(isBiome(RUBiomes.BIOSHROOM_CAVES), ifTrue(ON_FLOOR, sequence(ifTrue(deepslateLevel, DeepslateViridescentSurface), ViridescentSurface))),

                        ifTrue(isBiome(RUBiomes.ANCIENT_DELTA), sequence(ifTrue(ON_FLOOR, ifTrue(noiseCondition(RUNoises.SHIELD, -0.95D), ArgilliteSurface)), ARGILLITE)),

                        ifTrue(isBiome(RUBiomes.PRISMACHASM),
                                ifTrue(ON_FLOOR, sequence(
                                        ifTrue(deepslateLevel, sequence(ifTrue(surfaceNoiseAbove(0.5D), DeepslatePrismossSurface), ifTrue(noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), DeepslatePrismossSurface))),
                                        sequence(ifTrue(surfaceNoiseAbove(0.5D), PrismossSurface), ifTrue(noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), PrismossSurface))))))),

                ifTrue(UNDER_CEILING, ifTrue(isBiome(RUBiomes.ANCIENT_DELTA), ARGILLITE))
        );

        RuleSource underSurfaceNoTop = sequence(
                ifTrue(isBiome(RUBiomes.MOUNTAINS),
                        sequence(
                                ifTrue(not(yStartCheck(VerticalAnchor.absolute(138), 0)), DIRT),
                                ifTrue(yStartCheck(VerticalAnchor.absolute(186), 0), SNOW_BLOCK),
                                ifTrue(noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), CALCITE), STONE)),


                ifTrue(isBiome(RUBiomes.ICY_HEIGHTS, RUBiomes.SPIRES), ifTrue(waterBlockCheck(-1, 0), SNOW_BLOCK)),

                ifTrue(isBiome(RUBiomes.ARID_MOUNTAINS), TERRACOTTA),

                ifTrue(isBiome(RUBiomes.BAOBAB_SAVANNA),
                        ifTrue(surfaceNoiseAbove(1.9D), TERRACOTTA)),

                ifTrue(isBiome(RUBiomes.JOSHUA_DESERT), ifTrue(shieldNoise(0.0D), sandWithSandstoneOverhang)),
                ifTrue(isBiome(RUBiomes.SAGUARO_DESERT), sandWithSandstoneOverhang),
                ifTrue(isBiome(RUBiomes.OUTBACK), sequence(
                    ifTrue(
                        shieldNoise(-0.2d, 0.2d), TERRACOTTA
                    ),
                    ifTrue(
                        shieldNoise(-0.5d, 0.5d), ifTrue(noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(50)), TERRACOTTA)
                    ),
                    ifTrue(
                        shieldNoise(0.2d), redSandWithSandstoneOverhang
                    )
                )),

                ifTrue(isBiome(RUBiomes.ALPHA_GROVE),
                        sequence(ifTrue(not(yStartCheck(VerticalAnchor.absolute(66), 0)), gravelWithStoneOverhang), ifTrue(ON_FLOOR, AlphaGrassSurface), DIRT)),

                ifTrue(isBiome(RUBiomes.TROPICS), ifTrue(not(yStartCheck(VerticalAnchor.absolute(64), 0)), sandWithSandstoneOverhang)),

                ifTrue(isBiome(RUBiomes.MUDDY_RIVER), PEAT_MUD),

                ifTrue(isBiome(RUBiomes.COLD_RIVER, RUBiomes.GRAVEL_BEACH), gravelWithStoneOverhang),

                ifTrue(isSandBiome, sandWithSandstoneOverhang)
        );

        RuleSource underSurface = sequence(

                ifTrue(isBiome(RUBiomes.ICY_HEIGHTS, RUBiomes.SPIRES, RUBiomes.FROZEN_PINE_TAIGA), powderSnowPatch1),

                underSurfaceNoTop,

                ifTrue(isBiome(RUBiomes.TOWERING_CLIFFS), ifTrue(surfaceNoiseAbove(1.75D), STONE)),

                ifTrue(isBiome(RUBiomes.MAPLE_FOREST), ifTrue(shieldNoise(1.65D), STONE)),

                ifTrue(isBiome(RUBiomes.HYACINTH_DEEPS), STONE),

                ifTrue(isBiome(RUBiomes.ASHEN_WOODLAND), ASHEN_DIRT),

                ifTrue(isBiome(RUBiomes.OLD_GROWTH_BAYOU), sequence(
                        ifTrue(surfaceNoiseAbove(-0.95D), MUD),
                        ifTrue(not(yStartCheck(VerticalAnchor.absolute(64), 0)),
                                ifTrue(noiseCondition(Noises.SWAMP, 0.0D), MUD)))),

                ifTrue(isPeatBiome, PEAT_DIRT),
                ifTrue(isSiltBiome, SILT_DIRT),
                ifTrue(isGrassBiome, DIRT)
        );

        RuleSource onSurface = sequence(

                ifTrue(isBiome(RUBiomes.FROZEN_PINE_TAIGA),
                        sequence(powderSnowPatch2,
                                ifTrue(waterBlockCheck, SNOW_BLOCK))),

                ifTrue(isBiome(RUBiomes.FROZEN_TUNDRA),
                        ifTrue(noiseCondition(Noises.SWAMP, 0.0D), SNOW_BLOCK)),

                underSurfaceNoTop,

                ifTrue(isBiome(RUBiomes.TOWERING_CLIFFS),
                        sequence(
                                ifTrue(surfaceNoiseAbove(1.75D), sequence(ifTrue(noiseCondition(Noises.SWAMP, 0.25D), COBBLESTONE),
                                        ifTrue(noiseCondition(Noises.SWAMP, 0.0D), GRAVEL), STONE)),
                                ifTrue(surfaceNoiseAbove(-0.5D), sequence(ifTrue(noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),
                                        ifTrue(noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),
                                        COBBLESTONE)))),

                ifTrue(isBiome(RUBiomes.MAPLE_FOREST),
                        sequence(
                                ifTrue(shieldNoise(1.65D), sequence(ifTrue(noiseCondition(Noises.SWAMP, 0.25D), STONE),
                                        ifTrue(noiseCondition(Noises.SWAMP, 0.0D), MOSSY_STONE), STONE)),
                                ifTrue(shieldNoise(0.0D), sequence(ifTrue(noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),
                                        ifTrue(noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT), MOSSY_STONE)))),

                ifTrue(isBiome(RUBiomes.DECIDUOUS_FOREST),
                        sequence(ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT),
                                ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))),

                ifTrue(isBiome(RUBiomes.PINE_TAIGA),
                        sequence(ifTrue(surfaceNoiseAbove(1.75D), PEAT_COARSE_DIRT),
                                ifTrue(surfaceNoiseAbove(-0.95D), PEAT_PODZOL))),

                ifTrue(isBiome(RUBiomes.PUMPKIN_FIELDS), ifTrue(surfaceNoiseAbove(-1.75D), SILT_PODZOL)),

                ifTrue(isBiome(RUBiomes.POPPY_FIELDS),
                        ifTrue(noiseCondition(RUNoises.WEIGHTED, RuleWeight.getPercent(50)), SILT_COARSE_DIRT)),

                ifTrue(isBiome(RUBiomes.DRY_BUSHLAND),
                        ifTrue(noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), SILT_COARSE_DIRT)),

                ifTrue(isBiome(RUBiomes.FEN),
                        sequence(ifTrue(surfaceNoiseAbove(1.1D), PEAT_COARSE_DIRT))),

                ifTrue(isBiome(RUBiomes.FUNGAL_FEN),
                        sequence(ifTrue(surfaceNoiseAbove(1.75D), MYCELIUM),
                                ifTrue(surfaceNoiseAbove(-0.5D), ifTrue(noiseCondition(RUNoises.WEIGHTED, 0.1D), MYCELIUM)))),

                ifTrue(isBiome(RUBiomes.ASHEN_WOODLAND), sequence(
                    ifTrue(noiseBetween(RUNoises.SURFACE_MEDIUM, 1.5, 3.5), ifTrue(noiseAbove(RUNoises.WEIGHTED, 1), sequence(
                        ifTrue(noiseAbove(RUNoises.WEIGHTED, 3), state(AshenDirtBlock.getSmouldering())),
                        block(RUBlocks.ASHEN_DIRT)
                    ))),
                    ifTrue(noiseAbove(RUNoises.SURFACE_MEDIUM, 2.5), block(RUBlocks.ASH)),
                    block(RUBlocks.ASHEN_DIRT))
                ),//BA

                ifTrue(isBiome(RUBiomes.BAYOU),
                        ifTrue(not(yStartCheck(VerticalAnchor.absolute(64), 0)), ifTrue(noiseCondition(Noises.SWAMP, 0.0D), PEAT_MUD))),

                ifTrue(isBiome(RUBiomes.OLD_GROWTH_BAYOU),
                        sequence(ifTrue(surfaceNoiseAbove(-0.95D), MUD), ifTrue(noiseCondition(Noises.SWAMP, 0.0D), MUD))),

                ifTrue(isBiome(RUBiomes.TROPICS),
                        ifTrue(not(yStartCheck(VerticalAnchor.absolute(65), 0)),
                                ifTrue(noiseCondition(Noises.SWAMP, 0.0D), sandWithSandstoneOverhang))),

                ifTrue(isBiome(RUBiomes.BAOBAB_SAVANNA), ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT)),

                ifTrue(isBiome(RUBiomes.PINE_SLOPES), COARSE_DIRT),

                ifTrue(isBiome(RUBiomes.REDWOODS), PODZOL),

                ifTrue(isBiome(RUBiomes.CHALK_CLIFFS), ifTrue(not(new SlopeCondition(new InclusiveRange<>(3, Integer.MAX_VALUE))), ChalkSurface)),
                ifTrue(isPeatBiome, PeatGrassSurface),
                ifTrue(isSiltBiome, SiltGrassSurface),
                ifTrue(isGrassBiome, GrassSurface)
        );

        RuleSource buildSurface = sequence(
                ifTrue(ON_FLOOR, sequence(

                        ifTrue(isBiome(RUBiomes.FEN),
                                ifTrue(y62,
                                        ifTrue(not(y63), ifTrue(noiseCondition(RUNoises.WEIGHTED, 0.0D), WATER))))

                )),

                ifTrue(ON_FLOOR, sequence(
                        ifTrue(waterBlockCheck1, onSurface),

                        ifTrue(isBiome(RUBiomes.HYACINTH_DEEPS),
                                sequence(ifTrue(noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), MOSSY_STONE), GRAVEL))
                )),

                ifTrue(oceanGravelCheck, sequence(
                        //Comment Out for future Use
                        /*SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(*ocean biome here*, SurfaceRules.ifTrue(holeCondition, WATER))),*/

                        ifTrue(VERY_DEEP_UNDER_FLOOR, deepSurfaceBlocks),

                        ifTrue(UNDER_FLOOR, underSurface),

                        ifTrue(DEEP_UNDER_FLOOR, ifTrue(isSandBiome, SANDSTONE)),

                        ifTrue(VERY_DEEP_UNDER_FLOOR, sequence(
                                ifTrue(isBiome(RUBiomes.SAGUARO_DESERT), SANDSTONE),
                                ifTrue(isBiome(RUBiomes.ICY_HEIGHTS, RUBiomes.SPIRES), PACKED_ICE))))),

                ifTrue(ON_FLOOR, sequence(

                        ifTrue(isBiome(RUBiomes.ROCKY_REEF), sandWithSandstoneOverhang)))
        );

        ImmutableList.Builder<RuleSource> builder = ImmutableList.builder();

        if (bedrockRoof) {
            builder.add(ifTrue(not(verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK));
        }

        if (bedrockFloor) {
            builder.add(ifTrue(verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        }

        RuleSource surfaceBlocks = ifTrue(abovePreliminarySurface(), buildSurface);

        builder.add(isSurface ? surfaceBlocks : buildSurface);
        builder.add(CaveRules);
        builder.add(ifTrue(deepslateLevel, DEEPSLATE));

        return sequence(builder.build().toArray((rules) -> {
            return new RuleSource[rules];
        }));
    }

    public static RuleSource nether() {
        ConditionSource above31 = yBlockCheck(VerticalAnchor.absolute(31), 0);
        ConditionSource above32 = yBlockCheck(VerticalAnchor.absolute(32), 0);
        ConditionSource start30 = yStartCheck(VerticalAnchor.absolute(30), 0);
        ConditionSource end35 = not(yStartCheck(VerticalAnchor.absolute(35), 0));
        ConditionSource belowTop5 = yBlockCheck(VerticalAnchor.belowTop(5), 0);
        ConditionSource hole = hole();
        ConditionSource soulSandLayerNoise = noiseCondition(Noises.SOUL_SAND_LAYER, -0.012D);
        ConditionSource gravelLayerNoise = noiseCondition(Noises.GRAVEL_LAYER, -0.012D);
        ConditionSource patchNoise = noiseCondition(Noises.PATCH, -0.012D);
        ConditionSource netherrackNoise = noiseCondition(Noises.NETHERRACK, 0.54D);
        ConditionSource wartNoise = noiseCondition(Noises.NETHER_WART, 1.17D);
        ConditionSource stateSelectorNoise = noiseCondition(Noises.NETHER_STATE_SELECTOR, 0.0D);
        RuleSource gravelPatch =
                ifTrue(patchNoise,
                        ifTrue(start30,
                                ifTrue(end35, GRAVEL)));

        return sequence(
                //Nether Roof/Floor
                ifTrue(verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                ifTrue(not(verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),
                ifTrue(belowTop5, NETHERRACK),

                ifTrue(isBiome(RUBiomes.INFERNAL_HOLT), sequence(ifTrue(UNDER_CEILING, ifTrue(stateSelectorNoise, ifTrue(not(UNDER_FLOOR), BLACKSTONE))), ifTrue(UNDER_FLOOR, ifTrue(netherrackNoise, BLACKSTONE)))),

                ifTrue(ON_FLOOR,
                        sequence(
                                ifTrue(not(above32), ifTrue(hole, LAVA)),
                                ifTrue(isBiome(RUBiomes.BLACKSTONE_BASIN), sequence(ifTrue(netherrackNoise, BLACKSTONE), ifTrue(above31, COBALT_NYLIUM))),
                                ifTrue(isBiome(RUBiomes.GLISTERING_MEADOW), ifTrue(not(noiseCondition(Noises.NETHERRACK, 0.45D)), ifTrue(above31, sequence(ifTrue(wartNoise, GLISTERING_WART), GLISTERING_NYLIUM)))),
                                ifTrue(isBiome(RUBiomes.MYCOTOXIC_UNDERGROWTH), ifTrue(not(netherrackNoise), ifTrue(above31, sequence(ifTrue(wartNoise, NETHERRACK), MYCOTOXIC_NYLIUM)))),
                                ifTrue(isBiome(RUBiomes.INFERNAL_HOLT), sequence(ifTrue(netherrackNoise, BLACKSTONE), ifTrue(above31, BRIMSPROUT_NYLIUM)))
                        )
                ),
                ifTrue(isBiome(RUBiomes.BLACKSTONE_BASIN), sequence(ifTrue(UNDER_CEILING, ifTrue(stateSelectorNoise, BLACKSTONE)), ifTrue(UNDER_FLOOR, BLACKSTONE))),
                ifTrue(isBiome(RUBiomes.REDSTONE_ABYSS), sequence(ifTrue(UNDER_FLOOR, ifTrue(soulSandLayerNoise, sequence(ifTrue(not(hole), ifTrue(start30, ifTrue(end35, SOUL_SAND))), NETHERRACK))), ifTrue(ON_FLOOR, ifTrue(above31, ifTrue(end35, ifTrue(gravelLayerNoise, sequence(ifTrue(above32, GRAVEL), ifTrue(not(hole), GRAVEL))))))))
        );
    }

    private static RuleSource block(Supplier<Block> block) {
        return SurfaceRules.state(block.get().defaultBlockState());
    }

    public static RuleSource end() {
        return END_STONE;
    }

    public static RuleSource air() {
        return AIR;
    }

    private static ConditionSource noiseAbove(ResourceKey<NormalNoise.NoiseParameters> noise, double min) {
        return noiseCondition(noise, min / 8.25D, Double.MAX_VALUE);
    }
    private static ConditionSource noiseBetween(ResourceKey<NormalNoise.NoiseParameters> noise, double min, double max) {
        return noiseCondition(noise, min / 8.25D, max / 8.25D);
    }

    private static ConditionSource surfaceNoiseAbove(double noise) {
        return noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }

    private static ConditionSource shieldNoise(double min, double max) {
        return noiseCondition(RUNoises.SHIELD, min / 8.25D, max / 8.25D);
    }

    private static ConditionSource shieldNoise(double noise) {
        return noiseCondition(RUNoises.SHIELD, noise / 8.25D, Double.MAX_VALUE);
    }

}