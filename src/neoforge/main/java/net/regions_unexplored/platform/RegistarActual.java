package net.regions_unexplored.platform;

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
import net.neoforged.neoforge.registries.DeferredRegister;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.RegionsUnexploredNeo;

import java.util.function.Supplier;

public class RegistarActual {

    @Actual
    public static <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value) {
        return RegionsUnexploredNeo.REGISTER_CACHE.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), RegionsUnexplored.MOD_ID)).register(name, value);
    }

    @Actual
    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, Supplier<EntityType<T>> type) {
        return RegionsUnexploredNeo.REGISTER_CACHE.computeIfAbsent(BuiltInRegistries.ENTITY_TYPE.key(), resourceKey -> DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, RegionsUnexplored.MOD_ID)).register(name, type);
    }

    @Actual
    public static <FC extends FeatureConfiguration> Supplier<Feature<FC>> registerFeature(String name, Supplier<Feature<FC>> feature) {
        return RegionsUnexploredNeo.REGISTER_CACHE.computeIfAbsent(BuiltInRegistries.FEATURE.key(), resourceKey -> DeferredRegister.create(BuiltInRegistries.FEATURE, RegionsUnexplored.MOD_ID)).register(name, feature);
    }

    @Actual
    public static Supplier<CreativeModeTab> registerCreativeModeTab(String name, Supplier<ItemStack> icon, Supplier<CreativeModeTab.DisplayItemsGenerator> items) {
        return RegionsUnexploredNeo.REGISTER_CACHE.computeIfAbsent(BuiltInRegistries.CREATIVE_MODE_TAB.key(), resourceKey -> DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, RegionsUnexplored.MOD_ID)).register(name, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + RegionsUnexplored.MOD_ID + "." + name))
                .hideTitle()
                .backgroundTexture(ResourceLocation.fromNamespaceAndPath(RegionsUnexplored.MOD_ID, "textures/gui/container/creative_inventory/tab_regions_unexplored_search.png"))
                .withSearchBar(58)
                .icon(icon)
                .displayItems(items.get())
                .withSearchBar()
                .build()
        );
    }
}
