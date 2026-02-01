package net.regions_unexplored.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.msrandom.multiplatform.annotations.Actual;

public interface RUCreativeModeTabsActual {
    @Actual
    static CreativeModeTab.Builder builder() {
        return CreativeModeTab.builder();
    }
}
