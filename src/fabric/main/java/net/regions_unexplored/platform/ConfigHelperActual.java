package net.regions_unexplored.platform;

import net.fabricmc.loader.api.FabricLoader;
import net.msrandom.multiplatform.annotations.Actual;

import java.nio.file.Path;

public class ConfigHelperActual {
    @Actual
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
