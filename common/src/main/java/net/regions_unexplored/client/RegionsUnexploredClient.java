package net.regions_unexplored.client;

import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.client.particle.RuParticles;
import net.regions_unexplored.client.render.RuSheets;

public class RegionsUnexploredClient  {
    public static void clientInit() {
        RuEntityRenderer.RenderBoat();
        RuSheets.registerSheets();
        RuParticles.init();
        RuBlockRenders.init();
        RuColors.init();
    }
}
