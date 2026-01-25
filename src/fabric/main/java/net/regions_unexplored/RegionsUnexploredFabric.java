package net.regions_unexplored;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.FabricRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.regions_unexplored.block.RuBlockEntitiesFabric;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.compat.FurnaceBurnTimesFabric;
import net.regions_unexplored.registry.RUCreativeModeTabs;

public class RegionsUnexploredFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        RegionsUnexplored.init();
        RuBlockEntitiesFabric.addBlockEntities();
        RegionsUnexploredFabric.afterRegistriesFreeze();
        for (var entry : RUBlocks.BLOCK_ALIASES.entrySet()) {
            ((FabricRegistry) BuiltInRegistries.ITEM).addAlias(entry.getKey(), entry.getValue());
            ((FabricRegistry) BuiltInRegistries.BLOCK).addAlias(entry.getKey(), entry.getValue());
        }
    }

    public static void afterRegistriesFreeze() {
        RegionsUnexplored.afterRegistriesFreeze();
        FurnaceBurnTimesFabric.setup();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            RUCreativeModeTabs.addToBuildingBlocks(entries::addAfter);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {
            RUCreativeModeTabs.addToColoredBlocks(entries::addAfter);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            RUCreativeModeTabs.addToFunctionalBlocks(entries::addAfter);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            RUCreativeModeTabs.addToToolsAndUtilities(entries::addAfter);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
            RUCreativeModeTabs.addToFoodAndDrinks(entries::addAfter);
        });
    }
}
