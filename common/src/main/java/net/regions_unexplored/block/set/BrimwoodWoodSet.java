package net.regions_unexplored.block.set;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.item.items.RuBoatItem;
import net.regions_unexplored.registry.BlockRegistry;
import net.regions_unexplored.registry.ItemRegistry;
import net.regions_unexplored.world.level.block.wood.MagmaLogBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BrimwoodWoodSet extends WoodSet {
    protected Supplier<Block> logMagma;

    public BrimwoodWoodSet(boolean fireproof) {
        super(fireproof);
    }

    public static BrimwoodWoodSet brimwood(String name, WoodType woodType, SoundType sound, MapColor plankColour, MapColor logColour, boolean fireproof) {
        BrimwoodWoodSet set = new BrimwoodWoodSet(fireproof);
        set.log = BlockRegistry.registerDefaultBlock(name + "_log", () -> BlockRegistry.log(plankColour, logColour, sound, fireproof));
        set.logMagma = BlockRegistry.registerDefaultBlock(name + "_log_magma", () -> BlockRegistry.block(2, 2, plankColour, sound, fireproof, MagmaLogBlock::new));
        set.wood = BlockRegistry.registerDefaultBlock(name + "_wood", () -> BlockRegistry.log(plankColour, logColour, sound, fireproof));
        set.strippedLog = BlockRegistry.registerDefaultBlock("stripped_" + name + "_log", () -> BlockRegistry.wood(plankColour, sound, fireproof));
        set.strippedWood = BlockRegistry.registerDefaultBlock("stripped_" + name + "_wood", () -> BlockRegistry.wood(plankColour, sound, fireproof));
        set.planks = BlockRegistry.registerDefaultBlock(name + "_planks", () -> BlockRegistry.planks(plankColour, sound, fireproof));
        set.stairs = BlockRegistry.registerDefaultBlock(name + "_stairs", () -> BlockRegistry.stairs(plankColour, sound, fireproof));
        set.slab = BlockRegistry.registerDefaultBlock(name + "_slab", () -> BlockRegistry.slab(plankColour, sound, fireproof));
        set.fence = BlockRegistry.registerDefaultBlock(name + "_fence", () -> BlockRegistry.fence(plankColour, sound, fireproof));
        set.fenceGate = BlockRegistry.registerDefaultBlock(name + "_fence_gate", () -> BlockRegistry.fenceGate(plankColour, woodType, sound, fireproof));
        set.door = BlockRegistry.registerDefaultBlock(name + "_door", () -> BlockRegistry.door(plankColour, sound, woodType.setType(), fireproof));
        set.trapdoor = BlockRegistry.registerDefaultBlock(name + "_trapdoor", () -> BlockRegistry.trapdoor(plankColour, sound, woodType.setType(), fireproof));
        set.pressurePlate = BlockRegistry.registerDefaultBlock(name + "_pressure_plate", () -> BlockRegistry.pressurePlate(plankColour, sound, woodType.setType(), fireproof));
        set.button = BlockRegistry.registerDefaultBlock(name + "_button", () -> BlockRegistry.button(sound, woodType.setType()));
        set.sign = BlockRegistry.registerDefaultBlockNoItem(name + "_sign", () -> BlockRegistry.sign(sound, woodType, fireproof));
        set.wallSign = BlockRegistry.registerDefaultBlockNoItem(name + "_wall_sign", () -> BlockRegistry.wallSign(sound, set.sign.get(), woodType, fireproof));
        set.hangingSign = BlockRegistry.registerDefaultBlockNoItem(name + "_hanging_sign", () -> BlockRegistry.hangingSign(plankColour, sound, woodType, fireproof));
        set.wallHangingSign = BlockRegistry.registerDefaultBlockNoItem(name + "_wall_hanging_sign", () -> BlockRegistry.wallHangingSign(plankColour, sound, set.hangingSign.get(), woodType, fireproof));

        set.itemSign = ItemRegistry.registerItem(name + "_sign", () -> new SignItem(new Item.Properties().stacksTo(16), set.sign.get(), set.wallSign.get()));
        set.itemHangingSign = ItemRegistry.registerItem(name + "_hanging_sign", () -> new HangingSignItem(set.hangingSign.get(), set.wallHangingSign.get(), new Item.Properties().stacksTo(16)));
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public Block getLogMagma() {
        return logMagma != null ? logMagma.get() : null;
    }

    public List<Item> getBuildingBlocksTabItems() {
        ArrayList<Item> items = new ArrayList<>();
        addCreativeModeTabItem(WoodSet::getLog, items);
        addCreativeModeTabItem(BrimwoodWoodSet::getLogMagma, items);
        addCreativeModeTabItem(WoodSet::getWood, items);
        addCreativeModeTabItem(WoodSet::getStrippedLog, items);
        addCreativeModeTabItem(WoodSet::getStrippedWood, items);
        addCreativeModeTabItem(WoodSet::getPlanks, items);
        addCreativeModeTabItem(WoodSet::getStairs, items);
        addCreativeModeTabItem(WoodSet::getSlab, items);
        addCreativeModeTabItem(WoodSet::getFence, items);
        addCreativeModeTabItem(WoodSet::getFenceGate, items);
        addCreativeModeTabItem(WoodSet::getDoor, items);
        addCreativeModeTabItem(WoodSet::getTrapdoor, items);
        addCreativeModeTabItem(WoodSet::getPressurePlate, items);
        addCreativeModeTabItem(WoodSet::getButton, items);
        return items;
    }
}
