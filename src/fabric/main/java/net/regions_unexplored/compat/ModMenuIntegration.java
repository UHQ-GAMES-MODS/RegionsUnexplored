package net.regions_unexplored.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.regions_unexplored.internal.config.gui.ConfigScreenRegistry;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigScreenRegistry::createConfigScreen;
    }
}