package net.regions_unexplored.client.color;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.platform.TintHelper;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class RuColors {
    public static void tintBlocks() {
        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos) : GrassColor.get(0.5D, 1.0D),
                RUBlocks.PEAT_GRASS_BLOCK.get(),
                RUBlocks.SILT_GRASS_BLOCK.get(),
                RUBlocks.STONE_GRASS_BLOCK.get(),
                RUBlocks.ARGILLITE_GRASS_BLOCK.get(),
                RUBlocks.DEEPSLATE_GRASS_BLOCK.get(),
                RUBlocks.CHALK_GRASS_BLOCK.get(),
                RUBlocks.MEDIUM_GRASS.get(),
                RUBlocks.STEPPE_GRASS.get(),
                RUBlocks.STONE_BUD.get(),
                RUBlocks.ORANGE_CONEFLOWER.get(),
                RUBlocks.PURPLE_CONEFLOWER.get(),
                RUBlocks.POTTED_ORANGE_CONEFLOWER.get(),
                RUBlocks.POTTED_PURPLE_CONEFLOWER.get(),
                RUBlocks.TASSEL.get(),
                RUBlocks.CLOVER.get(),
                RUBlocks.BLADED_GRASS.get(),
                RUBlocks.BLADED_TALL_GRASS.get()
        );
        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.get(0.5D, 1.0D),
                RUBlocks.STEPPE_SHRUB.get(),
                RUBlocks.STEPPE_TALL_GRASS.get(),
                RUBlocks.ELEPHANT_EAR.get(),
                RUBlocks.BAOBAB_NATURAL_SET.getLeaves(),
                RUBlocks.MAGNOLIA_NATURAL_SET.getLeaves(),
                RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves(),
                RUBlocks.FLOWERING_NATURAL_SET.getLeaves(),
                RUBlocks.CYPRESS_NATURAL_SET.getLeaves(),
                RUBlocks.EUCALYPTUS_NATURAL_SET.getLeaves(),
                RUBlocks.PALM_NATURAL_SET.getLeaves(),
                RUBlocks.JOSHUA_NATURAL_SET.getLeaves(),
                RUBlocks.PINE_NATURAL_SET.getLeaves(),
                RUBlocks.REDWOOD_NATURAL_SET.getLeaves(),
                RUBlocks.WILLOW_NATURAL_SET.getLeaves(),
                RUBlocks.MAPLE_NATURAL_SET.getLeaves(),
                RUBlocks.MAPLE_LEAF_PILE.get(),
                RUBlocks.WINDSWEPT_GRASS.get(),
                RUBlocks.SOCOTRA_NATURAL_SET.getLeaves(),
                RUBlocks.KAPOK_NATURAL_SET.getLeaves(),
                RUBlocks.KAPOK_VINES.get(),
                RUBlocks.KAPOK_VINES_PLANT.get(),
                RUBlocks.SMALL_OAK_NATURAL_SET.getLeaves()
        );
        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowColor(blockPos) : FoliageColor.getDefaultColor(),
                RUBlocks.HANGING_PRISMARITE.get(),
                RUBlocks.PRISMARITE_CLUSTER.get(),
                RUBlocks.LARGE_PRISMARITE_CLUSTER.get(),
                RUBlocks.PRISMOSS.get(),
                RUBlocks.DEEPSLATE_PRISMOSS.get(),
                RUBlocks.PRISMOSS_SPROUT.get()
        );

        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowGlassColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RUBlocks.PRISMAGLASS.get()
        );

        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getRainbowEucalyptusColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RUBlocks.EUCALYPTUS_WOOD_SET.getLog(),
                RUBlocks.EUCALYPTUS_WOOD_SET.getWood()
        );

        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getAspenColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RUBlocks.SILVER_BIRCH_NATURAL_SET.getLeaves(),
                RUBlocks.SILVER_BIRCH_LEAF_PILE.get()
        );

        TintHelper.tintBlocks((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? getEnchantedAspenColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getLeaves(),
                RUBlocks.ENCHANTED_BIRCH_LEAF_PILE.get()
        );
    }


    public static void tintItems() {
        TintHelper.tintItems((itemStack, i) -> GrassColor.get(0.5D, 1.0D),
                RUBlocks.PEAT_GRASS_BLOCK.get(),
                RUBlocks.SILT_GRASS_BLOCK.get(),
                RUBlocks.STONE_GRASS_BLOCK.get(),
                RUBlocks.ARGILLITE_GRASS_BLOCK.get(),
                RUBlocks.DEEPSLATE_GRASS_BLOCK.get(),
                RUBlocks.CHALK_GRASS_BLOCK.get(),
                RUBlocks.MEDIUM_GRASS.get(),
                RUBlocks.STEPPE_GRASS.get(),
                RUBlocks.STONE_BUD.get(),
                RUBlocks.BLADED_GRASS.get(),
                RUBlocks.CLOVER.get(),
                RUBlocks.BLADED_TALL_GRASS.get()
        );

        TintHelper.tintItems((itemStack, i) -> FoliageColor.get(0.5D, 1.0D),
                RUBlocks.STEPPE_SHRUB.get(),
                RUBlocks.STEPPE_TALL_GRASS.get(),
                RUBlocks.ELEPHANT_EAR.get(),
                RUBlocks.BAOBAB_NATURAL_SET.getLeaves(),
                RUBlocks.MAGNOLIA_NATURAL_SET.getLeaves(),
                RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves(),
                RUBlocks.FLOWERING_NATURAL_SET.getLeaves(),
                RUBlocks.JOSHUA_NATURAL_SET.getLeaves(),
                RUBlocks.CYPRESS_NATURAL_SET.getLeaves(),
                RUBlocks.EUCALYPTUS_NATURAL_SET.getLeaves(),
                RUBlocks.PALM_NATURAL_SET.getLeaves(),
                RUBlocks.PINE_NATURAL_SET.getLeaves(),
                RUBlocks.REDWOOD_NATURAL_SET.getLeaves(),
                RUBlocks.WILLOW_NATURAL_SET.getLeaves(),
                RUBlocks.MAPLE_NATURAL_SET.getLeaves(),
                RUBlocks.MAPLE_LEAF_PILE.get(),
                RUBlocks.WINDSWEPT_GRASS.get(),
                RUBlocks.SOCOTRA_NATURAL_SET.getLeaves(),
                RUBlocks.KAPOK_NATURAL_SET.getLeaves(),
                RUBlocks.KAPOK_VINES.get(),
                RUBlocks.KAPOK_VINES_PLANT.get(),
                RUBlocks.SMALL_OAK_NATURAL_SET.getLeaves()
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

    public static int getRainbowColor(BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getZ()) / 50.0F, 0.9F, 1.0F);
        return rainbow.getRGB();
    }

    private static int getRainbowEucalyptusColor(BlockAndTintGetter world, @NotNull BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) /
                        RuClientConfig.EUCALYPTUS_TRANSITION_SIZE.get(),
                RuClientConfig.EUCALYPTUS_SATURATION.get(),
                RuClientConfig.EUCALYPTUS_BRIGHTNESS.get());
        return rainbow.getRGB();
    }

    private static int getRainbowGlassColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) / 35.0F, 1.0F, 1.0F);
        return rainbow.getRGB();
    }
}
