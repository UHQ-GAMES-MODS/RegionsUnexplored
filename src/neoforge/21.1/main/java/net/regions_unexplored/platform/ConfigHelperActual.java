package net.regions_unexplored.platform;

import net.msrandom.multiplatform.annotations.Actual;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ConfigHelperActual {
    @Actual
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
