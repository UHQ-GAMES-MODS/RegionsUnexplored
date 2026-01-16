package net.regions_unexplored.block.compat;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.NaturalSet;

import java.util.HashMap;
import java.util.Map;

public class CompostableBlocks {
    public static final Map<ItemLike, Float> COMPOSTABLES = new HashMap<>();

    static {
        // Saplings (0.3F)
        for (Block block : RuBlocks.NATURAL_SETS.stream().map(NaturalSet::getSapling).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.3f);
        }

        // Leaves (0.3F)
        for (Block block : RuBlocks.NATURAL_SETS.stream().map(NaturalSet::getLeaves).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.3f);
        }

        // Branches (0.3F)
        for (Block block : RuBlocks.NATURAL_SETS.stream().map(NaturalSet::getBranch).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.3f);
        }

        // Shrubs (0.65F)
        for (Block block : RuBlocks.NATURAL_SETS.stream().map(NaturalSet::getShrub).toList()) {
            if (block == null) continue;
            COMPOSTABLES.put(block, 0.65f);
        }

        // Bioshrooms (0.35F)
        COMPOSTABLES.put(RuBlocks.GREEN_BIOSHROOM.get(), 0.35F);
        COMPOSTABLES.put(RuBlocks.BLUE_BIOSHROOM.get(), 0.35F);
        COMPOSTABLES.put(RuBlocks.PINK_BIOSHROOM.get(), 0.35F);
        COMPOSTABLES.put(RuBlocks.YELLOW_BIOSHROOM.get(), 0.35F);

        // Tall Bioshrooms (0.65F)
        COMPOSTABLES.put(RuBlocks.TALL_GREEN_BIOSHROOM.get(), 0.65F);
        COMPOSTABLES.put(RuBlocks.TALL_BLUE_BIOSHROOM.get(), 0.65F);
        COMPOSTABLES.put(RuBlocks.TALL_PINK_BIOSHROOM.get(), 0.65F);
        COMPOSTABLES.put(RuBlocks.TALL_YELLOW_BIOSHROOM.get(), 0.65F);

        // Small grass/shrubs (0.3F)
        COMPOSTABLES.put(RuBlocks.DEAD_STEPPE_SHRUB.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.FROZEN_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.MEDIUM_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.SANDY_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.SMALL_DESERT_SHRUB.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.STEPPE_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.STEPPE_SHRUB.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.STONE_BUD.get(), 0.3F);

        // Tall grass (0.5F)
        COMPOSTABLES.put(RuBlocks.ELEPHANT_EAR.get(), 0.5F);
        COMPOSTABLES.put(RuBlocks.SANDY_TALL_GRASS.get(), 0.5F);
        COMPOSTABLES.put(RuBlocks.STEPPE_TALL_GRASS.get(), 0.5F);
        COMPOSTABLES.put(RuBlocks.WINDSWEPT_GRASS.get(), 0.5F);

        // Flowers (0.4F)
        COMPOSTABLES.put(RuBlocks.ALPHA_DANDELION.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.ALPHA_ROSE.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.ASTER.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.BLEEDING_HEART.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.BLUE_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.DAISY.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.DORCEL.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.FELICIA_DAISY.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.FIREWEED.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.HIBISCUS.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.HYSSOP.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.MALLOW.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.PINK_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.POPPY_BUSH.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.SALMON_POPPY_BUSH.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.PURPLE_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.RED_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.WARATAH.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.WHITE_TRILLIUM.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.WILTING_TRILLIUM.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.YELLOW_LUPINE.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.TSUBAKI.get(), 0.4F);

        // Coneflowers (0.25F)
        COMPOSTABLES.put(RuBlocks.ORANGE_CONEFLOWER.get(), 0.25F);
        COMPOSTABLES.put(RuBlocks.PURPLE_CONEFLOWER.get(), 0.25F);
        COMPOSTABLES.put(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 0.25F);
        COMPOSTABLES.put(RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), 0.25F);
        COMPOSTABLES.put(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 0.25F);

        // Clover (0.2F)
        COMPOSTABLES.put(RuBlocks.CLOVER.get(), 0.2F);

        // Snowbelles (0.4F)
        for (Block snowbelle : RuBlocks.SNOWBELLES.getAll()) {
            COMPOSTABLES.put(snowbelle, 0.4f);
        }

        // Leaf piles (0.1F)
        COMPOSTABLES.put(RuBlocks.MAPLE_LEAF_PILE.get(), 0.1F);
        COMPOSTABLES.put(RuBlocks.RED_MAPLE_LEAF_PILE.get(), 0.1F);
        COMPOSTABLES.put(RuBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 0.1F);
        COMPOSTABLES.put(RuBlocks.SILVER_BIRCH_LEAF_PILE.get(), 0.1F);
        COMPOSTABLES.put(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), 0.1F);

        // Tall plants (0.6F)
        COMPOSTABLES.put(RuBlocks.MEADOW_SAGE.get(), 0.6F);
        COMPOSTABLES.put(RuBlocks.BARLEY.get(), 0.6F);
        COMPOSTABLES.put(RuBlocks.CATTAIL.get(), 0.6F);
        COMPOSTABLES.put(RuBlocks.TASSEL.get(), 0.6F);
        COMPOSTABLES.put(RuBlocks.DAY_LILY.get(), 0.6F);

        // Cacti and vines (varied)
        COMPOSTABLES.put(RuBlocks.BARREL_CACTUS.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.CAVE_HYSSOP.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.DUCKWEED.get(), 0.15F);
        COMPOSTABLES.put(RuBlocks.SPANISH_MOSS.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.KAPOK_VINES.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.FLOWERING_LILY_PAD.get(), 0.3F);

        // Berries (0.25F)
        COMPOSTABLES.put(RuBlocks.SALMONBERRY_BUSH.get(), 0.25F);

        // Misc plants (varied)
        COMPOSTABLES.put(RuBlocks.PRISMOSS_SPROUT.get(), 0.2F);
        COMPOSTABLES.put(RuBlocks.CORPSE_FLOWER.get(), 0.6F);
        COMPOSTABLES.put(RuBlocks.BLADED_GRASS.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.BLADED_TALL_GRASS.get(), 0.5F);
        COMPOSTABLES.put(RuBlocks.DROPLEAF.get(), 0.15F);
        COMPOSTABLES.put(RuBlocks.DUSKMELON.get(), 0.5F);
        COMPOSTABLES.put(RuBlocks.DUSKTRAP.get(), 0.3F);

        // Brimsprout (0.1F)
        COMPOSTABLES.put(RuBlocks.BRIMSPROUT.get(), 0.1F);

        // Cobalt plants (varied)
        COMPOSTABLES.put(RuBlocks.COBALT_EARLIGHT.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.TALL_COBALT_EARLIGHT.get(), 0.35F);
        COMPOSTABLES.put(RuBlocks.COBALT_ROOTS.get(), 0.2F);
        COMPOSTABLES.put(RuBlocks.HANGING_EARLIGHT.get(), 0.1F);

        // Glistering plants (varied)
        COMPOSTABLES.put(RuBlocks.GLISTERING_IVY.get(), 0.1F);
        COMPOSTABLES.put(RuBlocks.GLISTERING_SPROUT.get(), 0.2F);
        COMPOSTABLES.put(RuBlocks.GLISTER_BULB.get(), 0.4F);
        COMPOSTABLES.put(RuBlocks.GLISTER_SPIRE.get(), 0.3F);

        // Mycotoxic plants (varied)
        COMPOSTABLES.put(RuBlocks.MYCOTOXIC_MUSHROOMS.get(), 0.1F);
        COMPOSTABLES.put(RuBlocks.MYCOTOXIC_DAISY.get(), 0.3F);
        COMPOSTABLES.put(RuBlocks.MYCOTOXIC_GRASS.get(), 0.2F);
    }
}