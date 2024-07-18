package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.platform.services.ITintHelper;

import java.util.HashMap;
import java.util.Map;

//TODO: FIX this and event it up
@AutoService(ITintHelper.class)
public class NeoForgeTintHelper implements ITintHelper {
    public static Map<BlockColor, Block[]> BLOCK_TINTS = new HashMap<>();
    public static Map<ItemColor, Block[]> ITEM_TINTS = new HashMap<>();

    @Override
    public void tintBlocks(BlockColor blockColor, Block... blocks) {
        BLOCK_TINTS.computeIfAbsent(blockColor, b -> blocks);
    }

    @Override
    public void tintItems(ItemColor itemColor, Block... items) {
        ITEM_TINTS.computeIfAbsent(itemColor, i -> items);
    }
}
