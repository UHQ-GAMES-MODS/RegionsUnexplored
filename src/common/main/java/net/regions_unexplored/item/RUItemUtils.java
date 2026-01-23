package net.regions_unexplored.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.platform.Registar;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RUItemUtils {
    public static Supplier<Item> register(String name, Function<Item.Properties, Item> factory) {
        return Registar.register(BuiltInRegistries.ITEM, name, () -> factory.apply(new Item.Properties()));
    }

    public static Supplier<Item> registerBlock(String name, Supplier<Block> block) {
        return register(name, p -> new BlockItem(block.get(), p));
    }

    public static Supplier<Item> registerPlaceOnWaterBlock(String name, Supplier<Block> block) {
        return register(name, p -> new PlaceOnWaterBlockItem(block.get(), p));
    }

    public static FoodProperties food(int nutrition, float saturation, UnaryOperator<FoodProperties.Builder> operator) {
        return operator.apply(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)).build();
    }
}
