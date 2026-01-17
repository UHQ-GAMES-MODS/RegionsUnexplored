package net.regions_unexplored.client.renderer.block;

import net.minecraft.client.renderer.RenderType;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.client.util.RenderUtil;

public class RuBlockTranslucency {
    public static void init() {
        RenderUtil.putBlocks(RenderType.translucent(),
                RuBlocks.PRISMARITE_CLUSTER.get(),
                RuBlocks.LARGE_PRISMARITE_CLUSTER.get(),
                RuBlocks.HANGING_PRISMARITE.get(),
                RuBlocks.PRISMAGLASS.get()
        );
    }
}
