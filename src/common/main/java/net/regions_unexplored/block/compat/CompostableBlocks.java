package net.regions_unexplored.block.compat;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.NaturalSet;

import java.util.HashMap;
import java.util.Map;

public class CompostableBlocks {
    public static final Map<ItemLike, Float> COMPOSTABLES = new HashMap<>();

    static {
        // Saplings (0.3F)
        for (Block block : RUBlocks.NATURAL_SETS.stream().map(NaturalSet::getSapling).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.3f);
        }

        // Leaves (0.3F)
        for (Block block : RUBlocks.NATURAL_SETS.stream().map(NaturalSet::getLeaves).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.3f);
        }

        // Branches (0.3F)
        for (Block block : RUBlocks.NATURAL_SETS.stream().map(NaturalSet::getBranch).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.3f);
        }

        // Shrubs (0.65F)
        for (Block block : RUBlocks.NATURAL_SETS.stream().map(NaturalSet::getShrub).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.65f);
        }

        // Bioshrooms (0.35F)
        COMPOSTABLES.put(RUBlocks.GREEN_BIOSHROOM.get(), 0.35F);
        COMPOSTABLES.put(RUBlocks.BLUE_BIOSHROOM.get(), 0.35F);
        COMPOSTABLES.put(RUBlocks.PINK_BIOSHROOM.get(), 0.35F);
        COMPOSTABLES.put(RUBlocks.YELLOW_BIOSHROOM.get(), 0.35F);

        // Tall Bioshrooms (0.65F)
        COMPOSTABLES.put(RUBlocks.TALL_GREEN_BIOSHROOM.get(), 0.65F);
        COMPOSTABLES.put(RUBlocks.TALL_BLUE_BIOSHROOM.get(), 0.65F);
        COMPOSTABLES.put(RUBlocks.TALL_PINK_BIOSHROOM.get(), 0.65F);
        COMPOSTABLES.put(RUBlocks.TALL_YELLOW_BIOSHROOM.get(), 0.65F);

        // Small grass/shrubs (0.3F)
        COMPOSTABLES.put(RUBlocks.DEAD_STEPPE_SHRUB.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.FROZEN_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.MEDIUM_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.SANDY_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.SMALL_DESERT_SHRUB.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.STEPPE_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.STEPPE_SHRUB.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.STONE_BUD.get(), 0.3F);

        // Tall grass (0.5F)
        COMPOSTABLES.put(RUBlocks.ELEPHANT_EAR.get(), 0.5F);
        COMPOSTABLES.put(RUBlocks.SANDY_TALL_GRASS.get(), 0.5F);
        COMPOSTABLES.put(RUBlocks.STEPPE_TALL_GRASS.get(), 0.5F);
        COMPOSTABLES.put(RUBlocks.WINDSWEPT_GRASS.get(), 0.5F);

        // Flowers (0.4F)
        COMPOSTABLES.put(RUBlocks.ALPHA_DANDELION.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.ALPHA_ROSE.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.ASTER.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.BLEEDING_HEART.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.BLUE_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.DAISY.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.DORCEL.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.FELICIA_DAISY.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.FIREWEED.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.HIBISCUS.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.HYSSOP.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.MALLOW.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.PINK_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.POPPY_BUSH.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.SALMON_POPPY_BUSH.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.PURPLE_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.RED_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.WARATAH.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.WHITE_TRILLIUM.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.WILTING_TRILLIUM.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.YELLOW_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.TSUBAKI.get(), 0.4F);

        // Coneflowers (0.25F)
        COMPOSTABLES.put(RUBlocks.ORANGE_CONEFLOWER.get(), 0.25F);
        COMPOSTABLES.put(RUBlocks.PURPLE_CONEFLOWER.get(), 0.25F);
        COMPOSTABLES.put(RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 0.25F);
        COMPOSTABLES.put(RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), 0.25F);
        COMPOSTABLES.put(RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 0.25F);

        // Clover (0.2F)
        COMPOSTABLES.put(RUBlocks.CLOVER.get(), 0.2F);

        // Snowbelles (0.4F)
        for (Block snowbelle : RUBlocks.SNOWBELLES.getAll()) {
            COMPOSTABLES.put(snowbelle, 0.4f);
        }

        // Leaf piles (0.1F)
        COMPOSTABLES.put(RUBlocks.MAPLE_LEAF_LITTER.get(), 0.1F);
        COMPOSTABLES.put(RUBlocks.RED_MAPLE_LEAF_LITTER.get(), 0.1F);
        COMPOSTABLES.put(RUBlocks.ORANGE_MAPLE_LEAF_LITTER.get(), 0.1F);
        COMPOSTABLES.put(RUBlocks.SILVER_BIRCH_LEAF_LITTER.get(), 0.1F);
        COMPOSTABLES.put(RUBlocks.ENCHANTED_BIRCH_LEAF_LITTER.get(), 0.1F);

        // Tall plants (0.6F)
        COMPOSTABLES.put(RUBlocks.MEADOW_SAGE.get(), 0.6F);
        COMPOSTABLES.put(RUBlocks.BARLEY.get(), 0.6F);
        COMPOSTABLES.put(RUBlocks.CATTAIL.get(), 0.6F);
        COMPOSTABLES.put(RUBlocks.TASSEL.get(), 0.6F);
        COMPOSTABLES.put(RUBlocks.DAY_LILY.get(), 0.6F);

        // Cacti and vines (varied)
        COMPOSTABLES.put(RUBlocks.BARREL_CACTUS.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.CAVE_HYSSOP.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.DUCKWEED.get(), 0.15F);
        COMPOSTABLES.put(RUBlocks.SPANISH_MOSS.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.KAPOK_VINES.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.FLOWERING_LILY_PAD.get(), 0.3F);

        // Berries (0.25F)
        COMPOSTABLES.put(RUBlocks.SALMONBERRY_BUSH.get(), 0.25F);

        // Misc plants (varied)
        COMPOSTABLES.put(RUBlocks.PRISMOSS_SPROUT.get(), 0.2F);
        COMPOSTABLES.put(RUBlocks.CORPSE_FLOWER.get(), 0.6F);
        COMPOSTABLES.put(RUBlocks.BLADED_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.BLADED_TALL_GRASS.get(), 0.5F);
        COMPOSTABLES.put(RUBlocks.DROPLEAF.get(), 0.15F);
        COMPOSTABLES.put(RUBlocks.DUSKMELON.get(), 0.5F);
        COMPOSTABLES.put(RUBlocks.DUSKTRAP.get(), 0.3F);

        // Brimsprout (0.1F)
        COMPOSTABLES.put(RUBlocks.BRIMSPROUT.get(), 0.1F);

        // Cobalt plants (varied)
        COMPOSTABLES.put(RUBlocks.COBALT_EARLIGHT.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.TALL_COBALT_EARLIGHT.get(), 0.35F);
        COMPOSTABLES.put(RUBlocks.COBALT_ROOTS.get(), 0.2F);
        COMPOSTABLES.put(RUBlocks.HANGING_EARLIGHT.get(), 0.1F);

        // Glistering plants (varied)
        COMPOSTABLES.put(RUBlocks.GLISTERING_IVY.get(), 0.1F);
        COMPOSTABLES.put(RUBlocks.GLISTERING_SPROUT.get(), 0.2F);
        COMPOSTABLES.put(RUBlocks.GLISTER_BULB.get(), 0.4F);
        COMPOSTABLES.put(RUBlocks.GLISTER_SPIRE.get(), 0.3F);

        // Mycotoxic plants (varied)
        COMPOSTABLES.put(RUBlocks.MYCOTOXIC_MUSHROOMS.get(), 0.1F);
        COMPOSTABLES.put(RUBlocks.MYCOTOXIC_DAISY.get(), 0.3F);
        COMPOSTABLES.put(RUBlocks.MYCOTOXIC_GRASS.get(), 0.2F);
    }
}