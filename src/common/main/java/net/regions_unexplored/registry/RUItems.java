package net.regions_unexplored.registry;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.regions_unexplored.item.RUItemUtils;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static net.regions_unexplored.RegionsUnexplored.id;
import static net.regions_unexplored.item.RUItemUtils.food;

public interface RUItems {
    Supplier<Item> SALMONBERRY = RUItemUtils.register("salmonberry", p -> new BlockItem(RUBlocks.SALMONBERRY_BUSH.get(), p.food(food(3, 0.3f, t -> t))));
    Supplier<Item> DUSKMELON_SLICE = RUItemUtils.register("duskmelon_slice", p -> new BlockItem(RUBlocks.DUSKMELON.get(), p.food(food(5, 1.1f, t -> t.effect(new MobEffectInstance(MobEffects.BLINDNESS, 240), 1)))));
    Supplier<Item> HANGING_EARLIGHT_FRUIT = RUItemUtils.register("hanging_earlight_fruit", p -> new BlockItem(RUBlocks.HANGING_EARLIGHT.get(), p.food(food(6, 0.4f, t -> t.effect(new MobEffectInstance(MobEffects.GLOWING, 200), 0.1F)))));
    Supplier<Item> MEADOW_SAGE = RUItemUtils.register("meadow_sage", p -> new BlockItem(RUBlocks.MEADOW_SAGE.get(), p.food(food(2, 0.15f, t -> t.effect(new MobEffectInstance(MobEffects.HEAL, 20), 0.5f)))));

    static void applyAliases(BiConsumer<Identifier, Identifier> consumer) {
        consumer.accept(id("cactus_flower"), id("saguaro_cactus_flower"));
        consumer.accept(id("maple_leaf_pile"), id("maple_leaf_litter"));
        consumer.accept(id("red_maple_leaf_pile"), id("red_maple_leaf_litter"));
        consumer.accept(id("orange_maple_leaf_pile"), id("orange_maple_leaf_litter"));
        consumer.accept(id("silver_birch_leaf_pile"), id("silver_birch_leaf_litter"));
        consumer.accept(id("enchanted_birch_leaf_pile"), id("enchanted_birch_leaf_litter"));
    }

    static void init() {

    }
}
