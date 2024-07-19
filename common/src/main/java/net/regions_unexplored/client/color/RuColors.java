package net.regions_unexplored.client.color;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.platform.Services;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class RuColors {
    public static void init () {
        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos) : GrassColor.get(0.5D, 1.0D),
                RuBlocks.PEAT_GRASS_BLOCK.get(),
                RuBlocks.SILT_GRASS_BLOCK.get(),
                RuBlocks.STONE_GRASS_BLOCK.get(),
                RuBlocks.ARGILLITE_GRASS_BLOCK.get(),
                RuBlocks.DEEPSLATE_GRASS_BLOCK.get(),
                RuBlocks.CHALK_GRASS_BLOCK.get(),
                RuBlocks.MEDIUM_GRASS.get(),
                RuBlocks.STEPPE_GRASS.get(),
                RuBlocks.STONE_BUD.get(),
                RuBlocks.ORANGE_CONEFLOWER.get(),
                RuBlocks.PURPLE_CONEFLOWER.get(),
                RuBlocks.POTTED_ORANGE_CONEFLOWER.get(),
                RuBlocks.POTTED_PURPLE_CONEFLOWER.get(),
                RuBlocks.TASSEL.get(),
                RuBlocks.CLOVER.get(),
                RuBlocks.BLADED_GRASS.get(),
                RuBlocks.BLADED_TALL_GRASS.get()
        );

        Services.TINT_HELPER.tintItems((itemStack, i) -> GrassColor.get(0.5D, 1.0D),
                RuBlocks.PEAT_GRASS_BLOCK.get(),
                RuBlocks.SILT_GRASS_BLOCK.get(),
                RuBlocks.STONE_GRASS_BLOCK.get(),
                RuBlocks.ARGILLITE_GRASS_BLOCK.get(),
                RuBlocks.DEEPSLATE_GRASS_BLOCK.get(),
                RuBlocks.CHALK_GRASS_BLOCK.get(),
                RuBlocks.MEDIUM_GRASS.get(),
                RuBlocks.STEPPE_GRASS.get(),
                RuBlocks.STONE_BUD.get(),
                RuBlocks.BLADED_GRASS.get(),
                RuBlocks.CLOVER.get(),
                RuBlocks.BLADED_TALL_GRASS.get()
        );

        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.get(0.5D, 1.0D),
                RuBlocks.STEPPE_SHRUB.get(),
                RuBlocks.STEPPE_TALL_GRASS.get(),
                RuBlocks.ELEPHANT_EAR.get(),
                RuBlocks.BAOBAB_LEAVES.get(),
                RuBlocks.MAGNOLIA_LEAVES.get(),
                RuBlocks.APPLE_OAK_LEAVES.get(),
                RuBlocks.FLOWERING_LEAVES.get(),
                RuBlocks.CYPRESS_LEAVES.get(),
                RuBlocks.EUCALYPTUS_LEAVES.get(),
                RuBlocks.PALM_LEAVES.get(),
                RuBlocks.JOSHUA_LEAVES.get(),
                RuBlocks.PINE_LEAVES.get(),
                RuBlocks.REDWOOD_LEAVES.get(),
                RuBlocks.WILLOW_LEAVES.get(),
                RuBlocks.MAPLE_LEAVES.get(),
                RuBlocks.MAPLE_LEAF_PILE.get(),
                RuBlocks.WINDSWEPT_GRASS.get(),
                RuBlocks.SOCOTRA_LEAVES.get(),
                RuBlocks.KAPOK_LEAVES.get(),
                RuBlocks.KAPOK_VINES.get(),
                RuBlocks.KAPOK_VINES_PLANT.get(),
                RuBlocks.SMALL_OAK_LEAVES.get()
        );

        Services.TINT_HELPER.tintItems((itemStack, i) -> FoliageColor.get(0.5D, 1.0D),
                RuBlocks.STEPPE_SHRUB.get(),
                RuBlocks.STEPPE_TALL_GRASS.get(),
                RuBlocks.ELEPHANT_EAR.get(),
                RuBlocks.BAOBAB_LEAVES.get(),
                RuBlocks.MAGNOLIA_LEAVES.get(),
                RuBlocks.APPLE_OAK_LEAVES.get(),
                RuBlocks.FLOWERING_LEAVES.get(),
                RuBlocks.JOSHUA_LEAVES.get(),
                RuBlocks.CYPRESS_LEAVES.get(),
                RuBlocks.EUCALYPTUS_LEAVES.get(),
                RuBlocks.PALM_LEAVES.get(),
                RuBlocks.PINE_LEAVES.get(),
                RuBlocks.REDWOOD_LEAVES.get(),
                RuBlocks.WILLOW_LEAVES.get(),
                RuBlocks.MAPLE_LEAVES.get(),
                RuBlocks.MAPLE_LEAF_PILE.get(),
                RuBlocks.WINDSWEPT_GRASS.get(),
                RuBlocks.SOCOTRA_LEAVES.get(),
                RuBlocks.KAPOK_LEAVES.get(),
                RuBlocks.KAPOK_VINES.get(),
                RuBlocks.KAPOK_VINES_PLANT.get(),
                RuBlocks.SMALL_OAK_LEAVES.get()
        );

        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.HANGING_PRISMARITE.get(),
                RuBlocks.PRISMARITE_CLUSTER.get(),
                RuBlocks.LARGE_PRISMARITE_CLUSTER.get(),
                RuBlocks.PRISMOSS.get(),
                RuBlocks.DEEPSLATE_PRISMOSS.get(),
                RuBlocks.PRISMOSS_SPROUT.get()
        );

        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowGlassColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.PRISMAGLASS.get()
        );

        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowEucalyptusColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.EUCALYPTUS_WOOD.get(),
                RuBlocks.EUCALYPTUS_LOG.get()
        );

        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getAspenColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.SILVER_BIRCH_LEAVES.get(),
                RuBlocks.SILVER_BIRCH_LEAF_PILE.get()
        );

        Services.TINT_HELPER.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getEnchantedAspenColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RuBlocks.ENCHANTED_BIRCH_LEAVES.get(),
                RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get()
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
                        RuCommonConfig.EUCALYPTUS_TRANSITION_SIZE.get().floatValue(),
                RuCommonConfig.EUCALYPTUS_SATURATION.get().floatValue(),
                RuCommonConfig.EUCALYPTUS_BRIGHTNESS.get().floatValue());
        return rainbow.getRGB();
    }

    private static int getRainbowGlassColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) / 35.0F, 1.0F, 1.0F);
        return rainbow.getRGB();
    }
}
