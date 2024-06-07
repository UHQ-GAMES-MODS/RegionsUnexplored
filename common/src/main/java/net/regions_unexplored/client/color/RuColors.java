package net.regions_unexplored.client.color;

import io.github.uhq_games.regions_unexplored.block.RuBlocks;
import io.github.uhq_games.regions_unexplored.config.RegionsUnexploredConfig;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class RuColors {

    public static void init () {
        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos) : GrassColor.get(0.5D, 1.0D),
                RuBlocks.PEAT_GRASS_BLOCK,
                RuBlocks.SILT_GRASS_BLOCK,
                RuBlocks.STONE_GRASS_BLOCK,
                RuBlocks.ARGILLITE_GRASS_BLOCK,
                RuBlocks.DEEPSLATE_GRASS_BLOCK,
                RuBlocks.CHALK_GRASS_BLOCK,
                RuBlocks.MEDIUM_GRASS,
                RuBlocks.STEPPE_GRASS,
                RuBlocks.STONE_BUD,
                RuBlocks.ORANGE_CONEFLOWER,
                RuBlocks.PURPLE_CONEFLOWER,
                RuBlocks.POTTED_ORANGE_CONEFLOWER,
                RuBlocks.POTTED_PURPLE_CONEFLOWER,
                RuBlocks.TASSEL,
                RuBlocks.CLOVER,
                RuBlocks.BLADED_GRASS,
                RuBlocks.BLADED_TALL_GRASS
        );

        ColorProviderRegistry.ITEM.register((itemStack, i) -> GrassColor.get(0.5D, 1.0D),
                RuBlocks.PEAT_GRASS_BLOCK,
                RuBlocks.SILT_GRASS_BLOCK,
                RuBlocks.STONE_GRASS_BLOCK,
                RuBlocks.ARGILLITE_GRASS_BLOCK,
                RuBlocks.DEEPSLATE_GRASS_BLOCK,
                RuBlocks.CHALK_GRASS_BLOCK,
                RuBlocks.MEDIUM_GRASS,
                RuBlocks.STEPPE_GRASS,
                RuBlocks.STONE_BUD,
                RuBlocks.BLADED_GRASS,
                RuBlocks.CLOVER,
                RuBlocks.BLADED_TALL_GRASS
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.get(0.5D, 1.0D),
                RuBlocks.STEPPE_SHRUB,
                RuBlocks.STEPPE_TALL_GRASS,
                RuBlocks.ELEPHANT_EAR,
                RuBlocks.BAOBAB_LEAVES,
                RuBlocks.MAGNOLIA_LEAVES,
                RuBlocks.APPLE_OAK_LEAVES,
                RuBlocks.FLOWERING_LEAVES,
                RuBlocks.CYPRESS_LEAVES,
                RuBlocks.EUCALYPTUS_LEAVES,
                RuBlocks.PALM_LEAVES,
                RuBlocks.JOSHUA_LEAVES,
                RuBlocks.PINE_LEAVES,
                RuBlocks.REDWOOD_LEAVES,
                RuBlocks.WILLOW_LEAVES,
                RuBlocks.MAPLE_LEAVES,
                RuBlocks.MAPLE_LEAF_PILE,
                RuBlocks.WINDSWEPT_GRASS,
                RuBlocks.SOCOTRA_LEAVES,
                RuBlocks.KAPOK_LEAVES,
                RuBlocks.KAPOK_VINES,
                RuBlocks.KAPOK_VINES_PLANT,
                RuBlocks.SMALL_OAK_LEAVES
        );

        ColorProviderRegistry.ITEM.register((itemStack, i) -> FoliageColor.get(0.5D, 1.0D),
                RuBlocks.STEPPE_SHRUB,
                RuBlocks.STEPPE_TALL_GRASS,
                RuBlocks.ELEPHANT_EAR,
                RuBlocks.BAOBAB_LEAVES,
                RuBlocks.MAGNOLIA_LEAVES,
                RuBlocks.APPLE_OAK_LEAVES,
                RuBlocks.FLOWERING_LEAVES,
                RuBlocks.JOSHUA_LEAVES,
                RuBlocks.CYPRESS_LEAVES,
                RuBlocks.EUCALYPTUS_LEAVES,
                RuBlocks.PALM_LEAVES,
                RuBlocks.PINE_LEAVES,
                RuBlocks.REDWOOD_LEAVES,
                RuBlocks.WILLOW_LEAVES,
                RuBlocks.MAPLE_LEAVES,
                RuBlocks.MAPLE_LEAF_PILE,
                RuBlocks.WINDSWEPT_GRASS,
                RuBlocks.SOCOTRA_LEAVES,
                RuBlocks.KAPOK_LEAVES,
                RuBlocks.KAPOK_VINES,
                RuBlocks.KAPOK_VINES_PLANT,
                RuBlocks.SMALL_OAK_LEAVES
        );


        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> FoliageColor.getBirchColor(),
                RuBlocks.BIRCH_SHRUB
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> FoliageColor.getEvergreenColor(),
                RuBlocks.SPRUCE_SHRUB
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.HANGING_PRISMARITE,
                RuBlocks.PRISMARITE_CLUSTER,
                RuBlocks.LARGE_PRISMARITE_CLUSTER,
                RuBlocks.PRISMOSS,
                RuBlocks.DEEPSLATE_PRISMOSS,
                RuBlocks.PRISMOSS_SPROUT
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowGlassColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.PRISMAGLASS
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowEucalyptusColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.EUCALYPTUS_WOOD,
                RuBlocks.EUCALYPTUS_LOG
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getAspenColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.SILVER_BIRCH_LEAVES,
                RuBlocks.SILVER_BIRCH_LEAF_PILE
        );

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getEnchantedAspenColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.ENCHANTED_BIRCH_LEAVES,
                RuBlocks.ENCHANTED_BIRCH_LEAF_PILE
        );
    }

    public static int getAspenColor(BlockAndTintGetter world, BlockPos pos) {
        Color aspen = Color.getHSBColor(((Mth.sin(((float)pos.getX()/10) + Mth.sin(((float)pos.getZ() + (float)pos.getX()) / 50) * 3)) / 75)+0.15F, 0.8F, 1.0F);
        return aspen.getRGB();
    }

    public static int getEnchantedAspenColor(BlockAndTintGetter world, BlockPos pos) {
        Color aspen = Color.getHSBColor(((Mth.sin(((float)pos.getX()/10) + Mth.sin(((float)pos.getZ() + (float)pos.getX()) / 50) * 3)) / 50)+0.58F, 0.8F, 1.0F);
        return aspen.getRGB();
    }

    private static int getRainbowColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getZ()) / 50.0F, 0.9F, 1.0F);
        return rainbow.getRGB();
    }

    private static int getRainbowEucalyptusColor(BlockAndTintGetter world, @NotNull BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) /
                        RegionsUnexploredConfig.WorldGenOptions.BlockColorOptions.EUCALYPTUS_TRANSITION_SIZE.floatValue(),
                RegionsUnexploredConfig.WorldGenOptions.BlockColorOptions.EUCALYPTUS_SATURATION.floatValue(),
                RegionsUnexploredConfig.WorldGenOptions.BlockColorOptions.EUCALYPTUS_BRIGHTNESS.floatValue());
        return rainbow.getRGB();
    }

    private static int getRainbowGlassColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) / 35.0F, 1.0F, 1.0F);
        return rainbow.getRGB();
    }
}
