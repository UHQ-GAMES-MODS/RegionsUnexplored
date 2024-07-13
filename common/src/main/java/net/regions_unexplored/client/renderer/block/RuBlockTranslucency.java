package net.regions_unexplored.client.renderer.block;

import net.minecraft.client.renderer.RenderType;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.client.util.RenderUtil;
import net.regions_unexplored.platform.Services;

public class RuBlockTranslucency {
    public static void init() {
        RenderUtil.putBlocks(Services.RENDER_HELPER, RenderType.translucent(),
                RuBlocks.PRISMARITE_CLUSTER,
                RuBlocks.LARGE_PRISMARITE_CLUSTER,
                RuBlocks.HANGING_PRISMARITE,
                RuBlocks.PRISMAGLASS
        );
    }
}
