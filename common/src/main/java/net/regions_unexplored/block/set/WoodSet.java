package net.regions_unexplored.block.set;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.item.items.RuBoatItem;
import net.regions_unexplored.registry.BlockRegistry;
import net.regions_unexplored.registry.ItemRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class WoodSet {
    public final boolean fireproof;
    protected Supplier<Block> log;
    protected Supplier<Block> wood;
    protected Supplier<Block> strippedLog;
    protected Supplier<Block> strippedWood;
    protected Supplier<Block> planks;
    protected Supplier<Block> stairs;
    protected Supplier<Block> slab;
    protected Supplier<Block> fence;
    protected Supplier<Block> fenceGate;
    protected Supplier<Block> door;
    protected Supplier<Block> trapdoor;
    protected Supplier<Block> pressurePlate;
    protected Supplier<Block> button;
    protected Supplier<Block> sign;
    protected Supplier<Block> wallSign;
    protected Supplier<Block> hangingSign;
    protected Supplier<Block> wallHangingSign;

    protected Supplier<Item> itemSign;
    protected Supplier<Item> itemHangingSign;
    protected Supplier<Item> itemBoat;
    protected Supplier<Item> itemChestBoat;

    public WoodSet(boolean fireproof) {
        this.fireproof = fireproof;
    }

    public static WoodSet simple(String name, WoodType woodType, SoundType sound, MapColor colour, boolean fireproof) {
        return simple(name, woodType, sound, colour, colour, fireproof);
    }

    public static WoodSet simple(String name, WoodType woodType, SoundType sound, MapColor plankColour, MapColor logColour, boolean fireproof) {
        WoodSet set = new WoodSet(fireproof);
        set.log = BlockRegistry.registerDefaultBlock(name + "_log", () -> BlockRegistry.log(plankColour, logColour, sound, fireproof));
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
        if (!name.equals("cobalt")) {
            set.itemBoat = ItemRegistry.registerItem(name + "_boat", () -> new RuBoatItem(false, RuBoat.ModelType.byName(name), new Item.Properties().stacksTo(1)));
            set.itemChestBoat = ItemRegistry.registerItem(name + "_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.byName(name), new Item.Properties().stacksTo(1)));
        }
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public static WoodSet bioshroom(String name, WoodType woodType, SoundType sound, MapColor colour, boolean fireproof) {
        WoodSet set = new WoodSet(fireproof);
        set.log = BlockRegistry.registerDefaultBlock(name + "_stem", () -> BlockRegistry.log(colour, colour, sound, fireproof));
        set.wood = BlockRegistry.registerDefaultBlock(name + "_hyphae", () -> BlockRegistry.log(colour, colour, sound, fireproof));
        set.strippedLog = BlockRegistry.registerDefaultBlock("stripped_" + name + "_stem", () -> BlockRegistry.wood(colour, sound, fireproof));
        set.strippedWood = BlockRegistry.registerDefaultBlock("stripped_" + name + "_hyphae", () -> BlockRegistry.wood(colour, sound, fireproof));
        set.planks = BlockRegistry.registerDefaultBlock(name + "_planks", () -> BlockRegistry.planks(colour, sound, fireproof));
        set.stairs = BlockRegistry.registerDefaultBlock(name + "_stairs", () -> BlockRegistry.stairs(colour, sound, fireproof));
        set.slab = BlockRegistry.registerDefaultBlock(name + "_slab", () -> BlockRegistry.slab(colour, sound, fireproof));
        set.fence = BlockRegistry.registerDefaultBlock(name + "_fence", () -> BlockRegistry.fence(colour, sound, fireproof));
        set.fenceGate = BlockRegistry.registerDefaultBlock(name + "_fence_gate", () -> BlockRegistry.fenceGate(colour, woodType, sound, fireproof));
        set.door = BlockRegistry.registerDefaultBlock(name + "_door", () -> BlockRegistry.door(colour, sound, woodType.setType(), fireproof));
        set.trapdoor = BlockRegistry.registerDefaultBlock(name + "_trapdoor", () -> BlockRegistry.trapdoor(colour, sound, woodType.setType(), fireproof));
        set.pressurePlate = BlockRegistry.registerDefaultBlock(name + "_pressure_plate", () -> BlockRegistry.pressurePlate(colour, sound, woodType.setType(), fireproof));
        set.button = BlockRegistry.registerDefaultBlock(name + "_button", () -> BlockRegistry.button(sound, woodType.setType()));
        set.sign = BlockRegistry.registerDefaultBlockNoItem(name + "_sign", () -> BlockRegistry.sign(sound, woodType, fireproof));
        set.wallSign = BlockRegistry.registerDefaultBlockNoItem(name + "_wall_sign", () -> BlockRegistry.wallSign(sound, set.sign.get(), woodType, fireproof));
        set.hangingSign = BlockRegistry.registerDefaultBlockNoItem(name + "_hanging_sign", () -> BlockRegistry.hangingSign(colour, sound, woodType, fireproof));
        set.wallHangingSign = BlockRegistry.registerDefaultBlockNoItem(name + "_wall_hanging_sign", () -> BlockRegistry.wallHangingSign(colour, sound, set.hangingSign.get(), woodType, fireproof));

        set.itemSign = ItemRegistry.registerItem(name + "_sign", () -> new SignItem(new Item.Properties().stacksTo(16), set.sign.get(), set.wallSign.get()));
        set.itemHangingSign = ItemRegistry.registerItem(name + "_hanging_sign", () -> new HangingSignItem(set.hangingSign.get(), set.wallHangingSign.get(), new Item.Properties().stacksTo(16)));
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public static WoodSet alpha() {
        WoodSet set = new WoodSet(false);
        set.log = BlockRegistry.registerDefaultBlock("alpha_log", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).ignitedByLava().sound(SoundType.WOOD)));
        set.planks = BlockRegistry.registerDefaultBlock("alpha_planks", () -> BlockRegistry.planks(MapColor.WOOD, SoundType.WOOD, false));
        set.stairs = BlockRegistry.registerDefaultBlock("alpha_stairs", () -> BlockRegistry.stairs(MapColor.WOOD, SoundType.WOOD, false));
        set.slab = BlockRegistry.registerDefaultBlock("alpha_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.5F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public static WoodSet silverBirch() {
        WoodSet set = new WoodSet(false);
        set.log = BlockRegistry.registerDefaultBlock("silver_birch_log", () -> BlockRegistry.aspenLogBlock(MapColor.SAND, MapColor.QUARTZ, SoundType.BAMBOO_WOOD));
        set.wood = BlockRegistry.registerDefaultBlock("silver_birch_wood", () -> BlockRegistry.log(MapColor.QUARTZ, MapColor.QUARTZ, SoundType.BAMBOO_WOOD, false));
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public static WoodSet ashen() {
        WoodSet set = new WoodSet(true);
        set.log = BlockRegistry.registerDefaultBlock("ashen_log", () -> BlockRegistry.log(MapColor.COLOR_LIGHT_GRAY, MapColor.COLOR_GRAY, SoundType.NETHER_WOOD, true));
        set.wood = BlockRegistry.registerDefaultBlock("ashen_wood", () -> BlockRegistry.log(MapColor.COLOR_LIGHT_GRAY, MapColor.COLOR_LIGHT_GRAY, SoundType.NETHER_WOOD, true));
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public static WoodSet pine(String name, WoodType woodType, SoundType sound, MapColor colour, boolean fireproof) {
        WoodSet set = new WoodSet(fireproof);
        set.log = BlockRegistry.registerDefaultBlock(name + "_log", () -> BlockRegistry.pineLog(colour, colour, sound));
        set.wood = BlockRegistry.registerDefaultBlock(name + "_wood", () -> BlockRegistry.log(colour, colour, sound, fireproof));
        set.strippedLog = BlockRegistry.registerDefaultBlock("stripped_" + name + "_log", () -> BlockRegistry.wood(colour, sound, fireproof));
        set.strippedWood = BlockRegistry.registerDefaultBlock("stripped_" + name + "_wood", () -> BlockRegistry.wood(colour, sound, fireproof));
        set.planks = BlockRegistry.registerDefaultBlock(name + "_planks", () -> BlockRegistry.planks(colour, sound, fireproof));
        set.stairs = BlockRegistry.registerDefaultBlock(name + "_stairs", () -> BlockRegistry.stairs(colour, sound, fireproof));
        set.slab = BlockRegistry.registerDefaultBlock(name + "_slab", () -> BlockRegistry.slab(colour, sound, fireproof));
        set.fence = BlockRegistry.registerDefaultBlock(name + "_fence", () -> BlockRegistry.fence(colour, sound, fireproof));
        set.fenceGate = BlockRegistry.registerDefaultBlock(name + "_fence_gate", () -> BlockRegistry.fenceGate(colour, woodType, sound, fireproof));
        set.door = BlockRegistry.registerDefaultBlock(name + "_door", () -> BlockRegistry.door(colour, sound, woodType.setType(), fireproof));
        set.trapdoor = BlockRegistry.registerDefaultBlock(name + "_trapdoor", () -> BlockRegistry.trapdoor(colour, sound, woodType.setType(), fireproof));
        set.pressurePlate = BlockRegistry.registerDefaultBlock(name + "_pressure_plate", () -> BlockRegistry.pressurePlate(colour, sound, woodType.setType(), fireproof));
        set.button = BlockRegistry.registerDefaultBlock(name + "_button", () -> BlockRegistry.button(sound, woodType.setType()));
        set.sign = BlockRegistry.registerDefaultBlockNoItem(name + "_sign", () -> BlockRegistry.sign(sound, woodType, fireproof));
        set.wallSign = BlockRegistry.registerDefaultBlockNoItem(name + "_wall_sign", () -> BlockRegistry.wallSign(sound, set.sign.get(), woodType, fireproof));
        set.hangingSign = BlockRegistry.registerDefaultBlockNoItem(name + "_hanging_sign", () -> BlockRegistry.hangingSign(colour, sound, woodType, fireproof));
        set.wallHangingSign = BlockRegistry.registerDefaultBlockNoItem(name + "_wall_hanging_sign", () -> BlockRegistry.wallHangingSign(colour, sound, set.hangingSign.get(), woodType, fireproof));
        set.itemSign = ItemRegistry.registerItem(name + "_sign", () -> new SignItem(new Item.Properties().stacksTo(16), set.sign.get(), set.wallSign.get()));
        set.itemHangingSign = ItemRegistry.registerItem(name + "_hanging_sign", () -> new HangingSignItem(set.hangingSign.get(), set.wallHangingSign.get(), new Item.Properties().stacksTo(16)));
        set.itemBoat = ItemRegistry.registerItem(name + "_boat", () -> new RuBoatItem(false, RuBoat.ModelType.byName(name), new Item.Properties().stacksTo(1)));
        set.itemChestBoat = ItemRegistry.registerItem(name + "_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.byName(name), new Item.Properties().stacksTo(1)));
        RuBlocks.WOOD_SETS.add(set);
        return set;
    }

    public Block getLog() {
        return log != null ? log.get() : null;
    }

    public Block getWood() {
        return wood != null ? wood.get() : null;
    }

    public Block getStrippedLog() {
        return strippedLog != null ? strippedLog.get() : null;
    }

    public Block getStrippedWood() {
        return strippedWood != null ? strippedWood.get() : null;
    }

    public Block getPlanks() {
        return planks != null ? planks.get() : null;
    }

    public Block getStairs() {
        return stairs != null ? stairs.get() : null;
    }

    public Block getSlab() {
        return slab != null ? slab.get() : null;
    }

    public Block getFence() {
        return fence != null ? fence.get() : null;
    }

    public Block getFenceGate() {
        return fenceGate != null ? fenceGate.get() : null;
    }

    public Block getDoor() {
        return door != null ? door.get() : null;
    }

    public Block getTrapdoor() {
        return trapdoor != null ? trapdoor.get() : null;
    }

    public Block getPressurePlate() {
        return pressurePlate != null ? pressurePlate.get() : null;
    }

    public Block getButton() {
        return button != null ? button.get() : null;
    }

    public Block getSign() {
        return sign != null ? sign.get() : null;
    }

    public Block getWallSign() {
        return wallSign != null ? wallSign.get() : null;
    }

    public Block getHangingSign() {
        return hangingSign != null ? hangingSign.get() : null;
    }

    public Block getWallHangingSign() {
        return wallHangingSign != null ? wallHangingSign.get() : null;
    }

    public Item getBoat() {
        return itemBoat != null ? itemBoat.get() : null;
    }

    public Item getChestBoat() {
        return itemChestBoat != null ? itemChestBoat.get() : null;
    }

    public List<Item> getAllBlocks() {
        ArrayList<Item> items = new ArrayList<>();
        addItemToList(WoodSet::getLog, items);
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
        addItemToList(WoodSet::getSign, items);
        addItemToList(WoodSet::getHangingSign, items);
        return items;
    }

    public List<Item> getBuildingBlocksTabItems() {
        ArrayList<Item> items = new ArrayList<>();
        addItemToList(WoodSet::getLog, items);
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

    public List<Item> getFunctionalBlocksTabItems() {
        ArrayList<Item> items = new ArrayList<>();
        addItemToList(WoodSet::getSign, items);
        addItemToList(WoodSet::getHangingSign, items);
        return items;
    }

    public List<Item> getToolsAndUtilitiesTabItems() {
        ArrayList<Item> items = new ArrayList<>();
        addItemToList(WoodSet::getBoat, items);
        addItemToList(WoodSet::getChestBoat, items);
        return items;

    }

    protected <T extends WoodSet> void addItemToList(Function<T, ItemLike> getter, ArrayList<Item> items) {
        if (getter.apply((T) this) != null) {
            items.add(getter.apply((T) this).asItem());
        }
    }
}
