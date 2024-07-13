package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.platform.services.ITintHelper;

@AutoService(ITintHelper.class)
public class FabricTintHelper implements ITintHelper {
    @Override
    public void tintBlocks(BlockColor blockColor, Block... blocks) {
        ColorProviderRegistry.BLOCK.register(blockColor, blocks);
    }

    @Override
    public void tintItems(ItemColor itemColor, Block... items) {
        ColorProviderRegistry.ITEM.register(itemColor, items);
    }
}
