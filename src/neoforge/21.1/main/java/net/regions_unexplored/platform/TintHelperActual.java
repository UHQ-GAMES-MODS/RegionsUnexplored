package net.regions_unexplored.platform;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Actual;
import net.regions_unexplored.client.TintRegistration;

public class TintHelperActual {
    @Actual
    public static void tintBlocks(BlockColor blockColor, Block... blocks) {
        TintRegistration.BLOCK_TINTS.computeIfAbsent(blockColor, b -> blocks);
    }

    @Actual
    public static void tintItems(ItemColor itemColor, Block... items) {
        TintRegistration.ITEM_TINTS.computeIfAbsent(itemColor, i -> items);
    }
}
