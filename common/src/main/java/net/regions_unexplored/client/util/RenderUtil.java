package net.regions_unexplored.client.util;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.platform.services.IRenderHelper;

public class RenderUtil {

    public static void putBlocks(IRenderHelper renderHelper, RenderType type, Block... blocks) {
        for (Block block : blocks) {
            renderHelper.setRenderType(block, type);
        }
    }
}
