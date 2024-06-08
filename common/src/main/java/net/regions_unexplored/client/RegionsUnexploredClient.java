package net.regions_unexplored.client;

import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.client.particle.RuParticles;

public class RegionsUnexploredClient  {
    public static void clientInit() {
//        RuEntityRenderer.RenderBoat();
        RuParticles.init();
//        RuBlockRenders.init();
        RuColors.init();
    }
}
