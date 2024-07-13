package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.platform.services.ITintHelper;

//TODO: FIX this and event it up
@AutoService(ITintHelper.class)
public class NeoForgeTintHelper implements ITintHelper {

    @Override
    public void tintBlocks(BlockColor blockColor, Block... blocks) {

    }

    @Override
    public void tintItems(ItemColor itemColor, Block... items) {

    }
}
