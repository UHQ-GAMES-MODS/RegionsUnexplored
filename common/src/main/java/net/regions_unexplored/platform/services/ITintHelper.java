package net.regions_unexplored.platform.services;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;

public interface ITintHelper {
    void tintBlocks(BlockColor blockColor, Block... blocks);
    void tintItems(ItemColor itemColor, Block... items);
}
