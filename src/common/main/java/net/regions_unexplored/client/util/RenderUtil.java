package net.regions_unexplored.client.util;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.platform.RenderHelper;

public class RenderUtil {

    public static void putBlocks(RenderType type, Block... blocks) {
        for (Block block : blocks) {
            if (block == null) continue;
            RenderHelper.setRenderType(block, type);
        }
    }
}
