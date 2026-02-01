package net.regions_unexplored;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.regions_unexplored.client.ParticleRegistration;
import net.regions_unexplored.client.TintRegistration;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.registry.RUCreativeModeTabs;

import java.util.function.BiConsumer;

@Mod(value = RegionsUnexplored.MOD_ID, dist = Dist.CLIENT)
public class RegionsUnexploredNeoClient {

    public static void regionsUnexploredNeoClient(IEventBus bus) {
        bus.addListener(TintRegistration::registerBlockColorHandlers);
        bus.addListener(TintRegistration::registerItemColorHandlers);
        bus.addListener(ParticleRegistration::registerParticleProviders);
        bus.addListener(RegionsUnexploredNeoClient::addToVanillaCreativeModeTabs);
    }

    private static void addToVanillaCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        if (!RuClientConfig.CUSTOM_ITEMS_IN_VANILLA_CREATIVE_TABS.get()) return;

        var consumer = getVanillaCreativeModeTabAdder(event);
        if (event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            RUCreativeModeTabs.addToBuildingBlocks(consumer);
        } else if (event.getTabKey().equals(CreativeModeTabs.COLORED_BLOCKS)) {
            RUCreativeModeTabs.addToColoredBlocks(consumer);
        } else if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            RUCreativeModeTabs.addToFunctionalBlocks(consumer);
        } else if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            RUCreativeModeTabs.addToToolsAndUtilities(consumer);
        } else if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
            RUCreativeModeTabs.addToFoodAndDrinks(consumer);
        }
    }

    private static BiConsumer<ItemLike, ItemLike> getVanillaCreativeModeTabAdder(BuildCreativeModeTabContentsEvent event) {
        return (a, b) -> event.insertAfter(
            a.asItem().getDefaultInstance(),
            b.asItem().getDefaultInstance(),
            CreativeModeTab.TabVisibility.PARENT_TAB_ONLY
        );
    }
}
