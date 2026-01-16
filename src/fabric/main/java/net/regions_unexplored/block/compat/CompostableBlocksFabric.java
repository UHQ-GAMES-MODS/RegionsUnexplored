package net.regions_unexplored.block.compat;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class CompostableBlocksFabric {
    public static void setup() {
        CompostableBlocks.COMPOSTABLES.forEach(CompostingChanceRegistry.INSTANCE::add);
    }
}
