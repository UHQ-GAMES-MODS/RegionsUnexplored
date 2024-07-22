package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.services.IRegistar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@AutoService(IRegistar.class)
public class FabricRegistar implements IRegistar {

    @Override
    public <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value) {
        T registered = Registry.register(registry, Constants.id(name), value.get());
        return () -> registered;
    }

    @Override
    public Supplier<Block> registerBlock(String name, Supplier<Block> value) {
        Block registered = Registry.register(BuiltInRegistries.BLOCK, Constants.id(name), value.get());
        return () -> registered;
    }

    @Override
    public <FC extends FeatureConfiguration> Supplier<Feature> registerFeature(String name, Supplier<Feature> value) {
        Feature registered = Registry.register(BuiltInRegistries.FEATURE, Constants.id(name), value.get());
        return () -> registered;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType> registerBlockEntity(String path, Supplier<BlockEntityType> type) {
        BlockEntityType<T> registered = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.id(path), type.get());
        return () -> registered;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String path, Supplier<EntityType<T>> type) {
        EntityType<T> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, Constants.id(path), type.get());
        return () -> registered;
    }

    public Supplier<CreativeModeTab> registerCreativeModeTab(String name, Supplier<ItemStack> icon, Supplier<List<Item>> items) {
        CreativeModeTab registered = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.id(name), FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID + "." + name))
                .icon(icon)
                .displayItems((entry, context) -> {
                        items.get().forEach(context::accept);
                })
                .build());
        return () -> registered;
    }
}
