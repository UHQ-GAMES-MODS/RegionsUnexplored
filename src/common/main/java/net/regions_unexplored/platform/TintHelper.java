package net.regions_unexplored.platform;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Expect;

public class TintHelper {
    @Expect
    public static void tintBlocks(BlockColor blockColor, Block... blocks);
    @Expect
    public static void tintItems(ItemColor itemColor, Block... items);
}
