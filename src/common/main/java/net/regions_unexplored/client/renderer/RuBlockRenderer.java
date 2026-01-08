package net.regions_unexplored.client.renderer;

import net.regions_unexplored.client.renderer.block.RuBlockCropCutouts;
import net.regions_unexplored.client.renderer.block.RuBlockTranslucency;

public class RuBlockRenderer {
    public static void init() {
        RuBlockCropCutouts.init();
        RuBlockTranslucency.init();
    }
}
