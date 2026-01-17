package net.regions_unexplored.block.compat;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FurnaceBurnTimes {
    public static final List<Item> BURN_TIME_300 = new ArrayList<>();
    public static final List<Item> BURN_TIME_200 = RuBlocks.WOOD_SETS.stream().map(WoodSet::getDoor).filter(Objects::nonNull).map(Block::asItem).toList();
    public static final List<Item> BURN_TIME_150 = new ArrayList<>();
    public static final List<Item> BURN_TIME_100 = new ArrayList<>();

    static {
        // 300
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.fireproof) continue;
            if (set.getLog() != null) BURN_TIME_300.add(set.getLog().asItem());
            if (set.getStrippedLog() != null) BURN_TIME_300.add(set.getStrippedLog().asItem());
            if (set.getWood() != null) BURN_TIME_300.add(set.getWood().asItem());
            if (set.getStrippedWood() != null) BURN_TIME_300.add(set.getStrippedWood().asItem());
            if (set.getPlanks() != null) BURN_TIME_300.add(set.getPlanks().asItem());
            if (set.getStairs() != null) BURN_TIME_300.add(set.getStairs().asItem());
            if (set.getFence() != null) BURN_TIME_300.add(set.getFence().asItem());
            if (set.getFenceGate() != null) BURN_TIME_300.add(set.getFenceGate().asItem());
            if (set.getTrapdoor() != null) BURN_TIME_300.add(set.getTrapdoor().asItem());
            if (set.getPressurePlate() != null) BURN_TIME_300.add(set.getPressurePlate().asItem());
        }

        // 150
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.fireproof) continue;
            if (set.getSlab() != null) {
                BURN_TIME_150.add(set.getSlab().asItem());
            }
        }
        for (Block block : RuBlocks.PAINTED_SLABS.getAll()) {
            BURN_TIME_150.add(block.asItem());
        }

        // 100
        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.fireproof) continue;
            if (set.getShrub() != null) {
                BURN_TIME_100.add(set.getShrub().asItem());
            }
            if (set.getSapling() != null) {
                BURN_TIME_100.add(set.getSapling().asItem());
            }
        }
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.fireproof) continue;
            if (set.getButton() != null) {
                BURN_TIME_100.add(set.getButton().asItem());
            }
        }
    }
}