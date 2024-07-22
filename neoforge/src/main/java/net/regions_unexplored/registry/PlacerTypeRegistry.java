package net.regions_unexplored.registry;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.regions_unexplored.Constants;
import net.regions_unexplored.world.features.foliageplacers.SakuraFoliagePlacer;
import net.regions_unexplored.world.features.foliageplacers.WillowFoliagePlacer;
import net.regions_unexplored.world.features.treedecorators.BlackwoodBioshroom;
import net.regions_unexplored.world.features.treedecorators.ChanceWillowTrunkDecorator;
import net.regions_unexplored.world.features.treedecorators.WillowTrunkDecorator;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PlacerTypeRegistry {
    @SubscribeEvent
    private static void registerFoliagePlacers(RegisterEvent event){
        event.register(Registries.FOLIAGE_PLACER_TYPE, Constants.id("willow_foliage_placer"), () -> WillowFoliagePlacer.WILLOW_FOLIAGE_PLACER);
        event.register(Registries.FOLIAGE_PLACER_TYPE, Constants.id("sakura_foliage_placer"), () -> SakuraFoliagePlacer.SAKURA_FOLIAGE_PLACER);
    }

    @SubscribeEvent
    private static void registerTreeDecorators(RegisterEvent event){
        event.register(Registries.TREE_DECORATOR_TYPE, Constants.id("blackwood_bioshrooms"), () -> BlackwoodBioshroom.BLACKWOOD_BIOSHROOM);
        event.register(Registries.TREE_DECORATOR_TYPE, Constants.id("chance_willow_trunk_decorator"), () -> ChanceWillowTrunkDecorator.CHANCE_WILLOW_TRUNK_DECORATOR);
        event.register(Registries.TREE_DECORATOR_TYPE, Constants.id("willow_trunk_decorator"), () -> WillowTrunkDecorator.WILLOW_TRUNK_DECORATOR);
    }
}
