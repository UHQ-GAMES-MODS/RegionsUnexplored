package net.regions_unexplored.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.block.entity.RuBlockEntities;
import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.client.particle.RuParticles;
import net.regions_unexplored.client.renderer.RuBlockRenderer;
import net.regions_unexplored.client.renderer.RuEntityRenderer;

public class RegionsUnexploredClient  {
    public static void clientInit() {
        RuEntityRenderer.renderBoat();
        RuBlockRenderer.init();
        BlockEntityRenderers.register(RuBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
        BlockEntityRenderers.register(RuBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get(), HangingSignRenderer::new);
    }
}
