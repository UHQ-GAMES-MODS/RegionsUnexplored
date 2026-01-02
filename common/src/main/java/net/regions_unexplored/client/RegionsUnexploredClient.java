package net.regions_unexplored.client;

import net.regions_unexplored.client.renderer.RuBlockRenderer;
import net.regions_unexplored.client.renderer.RuEntityRenderer;

public class RegionsUnexploredClient  {
    public static void clientInit() {
        RuEntityRenderer.renderBoat();
        RuBlockRenderer.init();
    }
}
