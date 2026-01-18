package net.regions_unexplored;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.FabricRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.block.RuBlockEntitiesFabric;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.compat.FurnaceBurnTimesFabric;
import net.regions_unexplored.mixin.invoke.FoliagePlacerTypeInvoker;
import net.regions_unexplored.mixin.invoke.TreeDecoratorTypeInvoker;
import net.regions_unexplored.world.features.foliageplacers.SakuraFoliagePlacer;
import net.regions_unexplored.world.features.foliageplacers.WillowFoliagePlacer;
import net.regions_unexplored.world.features.treedecorators.*;

public class RegionsUnexploredFabric implements ModInitializer {
    public static final FoliagePlacerType<SakuraFoliagePlacer> SAKURA_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("regions_unexplored:sakura_foliage_placer", SakuraFoliagePlacer.CODEC);
    public static final FoliagePlacerType<WillowFoliagePlacer> WILLOW_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("regions_unexplored:willow_foliage_placer", WillowFoliagePlacer.CODEC);
    public static final TreeDecoratorType<BlackwoodBioshroom> BLACKWOOD_BIOSHROOM = TreeDecoratorTypeInvoker.callRegister("regions_unexplored:blackwood_bioshrooms", BlackwoodBioshroom.CODEC);
    public static final TreeDecoratorType<ChanceWillowTrunkDecorator> CHANCE_WILLOW_TRUNK_DECORATOR = TreeDecoratorTypeInvoker.callRegister("regions_unexplored:chance_willow_trunk_decorator", ChanceWillowTrunkDecorator.CODEC);
    public static final TreeDecoratorType<WillowTrunkDecorator> WILLOW_TRUNK_DECORATOR = TreeDecoratorTypeInvoker.callRegister("regions_unexplored:willow_trunk_decorator", WillowTrunkDecorator.CODEC);
    public static final TreeDecoratorType<BranchDecorator> BRANCH_DECORATOR = TreeDecoratorTypeInvoker.callRegister("regions_unexplored:branch", BranchDecorator.CODEC);
    public static final TreeDecoratorType<PlaceOnGroundDecorator> PLACE_ON_GROUND_DECORATOR = TreeDecoratorTypeInvoker.callRegister("regions_unexplored:place_on_ground", PlaceOnGroundDecorator.CODEC);

    @Override
    public void onInitialize() {
        RegionsUnexplored.init();
        RuBlockEntitiesFabric.addBlockEntities();
        RegionsUnexploredFabric.afterRegistriesFreeze();
        for (var entry : RuBlocks.BLOCK_ALIASES.entrySet()) {
            ((FabricRegistry)Registries.BLOCK).addAlias(entry.getKey(), entry.getValue());
        }
    }

    public static void afterRegistriesFreeze() {
        RegionsUnexplored.afterRegistriesFreeze();
        FurnaceBurnTimesFabric.setup();
    }
}
