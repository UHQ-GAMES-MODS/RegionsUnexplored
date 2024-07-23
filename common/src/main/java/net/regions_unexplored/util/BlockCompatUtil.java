package net.regions_unexplored.util;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlockCompatUtil {
    public static void registerStrippableBlock(Block log, Block strippedLog) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(log, strippedLog);
    }

    public static void registerShovelled(Block block, BlockState shovelledBlock) {
        ShovelItem.FLATTENABLES = Maps.newHashMap(ShovelItem.FLATTENABLES);
        ShovelItem.FLATTENABLES.put(block, shovelledBlock);
    }


    public static void registerCompostableItems(float possibility, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), possibility);
    }

    public static void registerFlammableBlock(Block block, int spreadSpeed, int flammability) {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(block, spreadSpeed, flammability);
    }
}
