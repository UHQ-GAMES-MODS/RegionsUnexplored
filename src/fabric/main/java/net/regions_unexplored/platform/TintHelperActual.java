package net.regions_unexplored.platform;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Actual;

public class TintHelperActual {
    @Actual
    public static void tintBlocks(BlockColor blockColor, Block... blocks) {
        ColorProviderRegistry.BLOCK.register(blockColor, blocks);
    }

    @Actual
    public static void tintItems(ItemColor itemColor, Block... items) {
        ColorProviderRegistry.ITEM.register(itemColor, items);
    }
}
