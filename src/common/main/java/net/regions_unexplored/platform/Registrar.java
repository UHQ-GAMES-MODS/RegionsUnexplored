package net.regions_unexplored.platform;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.msrandom.multiplatform.annotations.Expect;

import java.util.function.Supplier;

public class Registrar {
    @Expect
    public static <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value);

    public static Supplier<Block> registerBlock(String name, Supplier<Block> value) {
        return register(BuiltInRegistries.BLOCK, name, value);
    }

    @Expect
    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, Supplier<EntityType<T>> type);

    @Expect
    public static <FC extends FeatureConfiguration> Supplier<Feature<FC>> registerFeature(String name, Supplier<Feature<FC>> feature);

    @Expect
    public static Supplier<CreativeModeTab> registerCreativeModeTab(String name, Supplier<ItemStack> icon, Supplier<CreativeModeTab.DisplayItemsGenerator> items);
}
