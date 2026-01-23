package net.regions_unexplored.block.set;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.RUBlockUtils;
import net.regions_unexplored.world.level.block.wood.MagmaLogBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BrimwoodWoodSet extends WoodSet {
    protected Supplier<Block> logMagma;

    public BrimwoodWoodSet(String name, boolean fireproof) {
        super(name, fireproof);
    }

    public static BrimwoodWoodSet brimwood(String name, WoodType woodType, SoundType sound, MapColor plankColour, MapColor logColour, boolean fireproof) {
        BrimwoodWoodSet set = new BrimwoodWoodSet(name, fireproof);
        set.addLogs(name, "log", "wood", sound, plankColour, logColour, fireproof, RotatedPillarBlock::new, true);
        set.logMagma = RUBlockUtils.register(name + "_log_magma", p -> RUBlockUtils.block(p, 2, 2, plankColour, sound, fireproof, MagmaLogBlock::new));
        set.addCommonWoodBlocks(name, woodType, plankColour, sound, fireproof);
        RUBlocks.WOOD_SETS.add(set);
        return set;
    }

    public Block getLogMagma() {
        return logMagma != null ? logMagma.get() : null;
    }

    public List<Item> getBuildingBlocksTabItems() {
        ArrayList<Item> items = new ArrayList<>();
        addItemToList(WoodSet::getLog, items);
        addItemToList(BrimwoodWoodSet::getLogMagma, items);
        addItemToList(WoodSet::getWood, items);
        addItemToList(WoodSet::getStrippedLog, items);
        addItemToList(WoodSet::getStrippedWood, items);
        addItemToList(WoodSet::getPlanks, items);
        addItemToList(WoodSet::getStairs, items);
        addItemToList(WoodSet::getSlab, items);
        addItemToList(WoodSet::getFence, items);
        addItemToList(WoodSet::getFenceGate, items);
        addItemToList(WoodSet::getDoor, items);
        addItemToList(WoodSet::getTrapdoor, items);
        addItemToList(WoodSet::getPressurePlate, items);
        addItemToList(WoodSet::getButton, items);
        return items;
    }
}
