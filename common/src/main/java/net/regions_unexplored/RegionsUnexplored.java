package net.regions_unexplored;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.entity.RegionsUnexploredBlockEntities;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.mixin.invoke.*;
import net.regions_unexplored.registry.BiomeRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.features.foliageplacers.*;
import net.regions_unexplored.world.features.treedecorators.*;
import terrablender.api.SurfaceRuleManager;

public class RegionsUnexplored {

    public static SurfaceRules.RuleSource getSurfaceRules(SurfaceRules.RuleSource fallBack) {
        return SurfaceRuleManager.getNamespacedRules(SurfaceRuleManager.RuleCategory.NETHER, fallBack);
    }
    public static void init() {
        FeatureRegistry.addFeatures();
        RuParticleTypes.addParticles();
        BiomeRegistry.addBiomes();
        RuBlocks.addBlocks();
        RuItems.addItems();
        RegionsUnexploredBlockEntities.addBlockEntities();
        RuEntities.addEntities();

    }

}