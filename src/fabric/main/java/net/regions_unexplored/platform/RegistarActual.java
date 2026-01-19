package net.regions_unexplored.platform;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.msrandom.multiplatform.annotations.Actual;
import net.regions_unexplored.RegionsUnexplored;

import java.util.function.Supplier;

public class RegistarActual {
    @Actual
    public static <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value) {
        T registered = Registry.register(registry, RegionsUnexplored.id(name), value.get());
        return () -> registered;
    }

    @Actual
    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, Supplier<EntityType<T>> type) {
        EntityType <T> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, RegionsUnexplored.id(name), type.get());
        return () -> registered;
    }

    @Actual
    public static <FC extends FeatureConfiguration> Supplier<Feature<FC>> registerFeature(String name, Supplier<Feature<FC>> feature) {
        Registry.register(BuiltInRegistries.FEATURE, RegionsUnexplored.id(name), feature.get());
        return feature;
    }

    @Actual
    public static Supplier<CreativeModeTab> registerCreativeModeTab(String name, Supplier<ItemStack> icon, Supplier<CreativeModeTab.DisplayItemsGenerator> items) {
        CreativeModeTab registered = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, RegionsUnexplored.id(name), FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + RegionsUnexplored.MOD_ID + "." + name))
                .hideTitle()
                .backgroundTexture(ResourceLocation.fromNamespaceAndPath(RegionsUnexplored.MOD_ID, "textures/gui/container/creative_inventory/tab_regions_unexplored.png"))
                .icon(icon)
                .displayItems(items.get())
                .build());
        return () -> registered;
    }
}
