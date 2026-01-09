package net.regions_unexplored.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ItemRegistry;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RuItems {
    public static final Supplier<Item> SALMONBERRY = ItemRegistry.registerItem("salmonberry", () -> new BlockItem(RuBlocks.SALMONBERRY_BUSH.get(), new Item.Properties().food(food(3, 0.3f, t -> t))));
    public static final Supplier<Item> DUSKMELON_SLICE = ItemRegistry.registerItem("duskmelon_slice", () -> new BlockItem(RuBlocks.DUSKMELON.get(), new Item.Properties().food(food(5, 1.1f, t -> t.effect(new MobEffectInstance(MobEffects.BLINDNESS, 240), 1)))));
    public static final Supplier<Item> HANGING_EARLIGHT_FRUIT = ItemRegistry.registerItem("hanging_earlight_fruit", () -> new BlockItem(RuBlocks.HANGING_EARLIGHT.get(), new Item.Properties().food(food(6, 0.4f, t -> t.effect(new MobEffectInstance(MobEffects.GLOWING, 200), 0.1F)))));
    public static final Supplier<Item> MEADOW_SAGE = ItemRegistry.registerItem("meadow_sage", () -> new BlockItem(RuBlocks.MEADOW_SAGE.get(), new Item.Properties().food(food(2, 0.15f, t -> t.effect(new MobEffectInstance(MobEffects.HEAL, 20), 0.5f)))));

    private static FoodProperties food(int nutrition, float saturation, UnaryOperator<FoodProperties.Builder> operator) {
        return operator.apply(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)).build();
    }

    public static void addItems() {

    }
}
