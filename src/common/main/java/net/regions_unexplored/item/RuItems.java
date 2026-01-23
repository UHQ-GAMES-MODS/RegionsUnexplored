package net.regions_unexplored.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.ItemRegistry;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RuItems {
    public static final Supplier<Item> SALMONBERRY = ItemRegistry.registerItem("salmonberry", p -> new BlockItem(RUBlocks.SALMONBERRY_BUSH.get(), p.food(food(3, 0.3f, t -> t))));
    public static final Supplier<Item> DUSKMELON_SLICE = ItemRegistry.registerItem("duskmelon_slice", p -> new BlockItem(RUBlocks.DUSKMELON.get(), p.food(food(5, 1.1f, t -> t.effect(new MobEffectInstance(MobEffects.BLINDNESS, 240), 1)))));
    public static final Supplier<Item> HANGING_EARLIGHT_FRUIT = ItemRegistry.registerItem("hanging_earlight_fruit", p -> new BlockItem(RUBlocks.HANGING_EARLIGHT.get(), p.food(food(6, 0.4f, t -> t.effect(new MobEffectInstance(MobEffects.GLOWING, 200), 0.1F)))));
    public static final Supplier<Item> MEADOW_SAGE = ItemRegistry.registerItem("meadow_sage", p -> new BlockItem(RUBlocks.MEADOW_SAGE.get(), p.food(food(2, 0.15f, t -> t.effect(new MobEffectInstance(MobEffects.HEAL, 20), 0.5f)))));

    private static FoodProperties food(int nutrition, float saturation, UnaryOperator<FoodProperties.Builder> operator) {
        return operator.apply(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)).build();
    }

    public static void addItems() {

    }
}
