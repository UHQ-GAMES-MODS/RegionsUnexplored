package net.regions_unexplored.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.item.items.RuBoatItem;
import net.regions_unexplored.platform.Services;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RuItems {

    public static final Supplier<Item> BAOBAB_HANGING_SIGN = registerItem("baobab_hanging_sign", () -> new HangingSignItem(RuBlocks.BAOBAB_WOOD_SET.getHangingSign(), RuBlocks.BAOBAB_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> BLACKWOOD_HANGING_SIGN = registerItem("blackwood_hanging_sign", () -> new HangingSignItem(RuBlocks.BLACKWOOD_WOOD_SET.getHangingSign(), RuBlocks.BLACKWOOD_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> BLUE_BIOSHROOM_HANGING_SIGN = registerItem("blue_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getHangingSign(), RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> BRIMWOOD_HANGING_SIGN = registerItem("brimwood_hanging_sign", () -> new HangingSignItem(RuBlocks.BRIMWOOD_WOOD_SET.getHangingSign(), RuBlocks.BRIMWOOD_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> COBALT_HANGING_SIGN = registerItem("cobalt_hanging_sign", () -> new HangingSignItem(RuBlocks.COBALT_WOOD_SET.getHangingSign(), RuBlocks.COBALT_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> CYPRESS_HANGING_SIGN = registerItem("cypress_hanging_sign", () -> new HangingSignItem(RuBlocks.CYPRESS_WOOD_SET.getHangingSign(), RuBlocks.CYPRESS_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> DEAD_HANGING_SIGN = registerItem("dead_hanging_sign", () -> new HangingSignItem(RuBlocks.DEAD_WOOD_SET.getHangingSign(), RuBlocks.DEAD_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> EUCALYPTUS_HANGING_SIGN = registerItem("eucalyptus_hanging_sign", () -> new HangingSignItem(RuBlocks.EUCALYPTUS_WOOD_SET.getHangingSign(), RuBlocks.EUCALYPTUS_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> GREEN_BIOSHROOM_HANGING_SIGN = registerItem("green_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getHangingSign(), RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> JOSHUA_HANGING_SIGN = registerItem("joshua_hanging_sign", () -> new HangingSignItem(RuBlocks.JOSHUA_WOOD_SET.getHangingSign(), RuBlocks.JOSHUA_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> KAPOK_HANGING_SIGN = registerItem("kapok_hanging_sign", () -> new HangingSignItem(RuBlocks.KAPOK_WOOD_SET.getHangingSign(), RuBlocks.KAPOK_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> LARCH_HANGING_SIGN = registerItem("larch_hanging_sign", () -> new HangingSignItem(RuBlocks.LARCH_WOOD_SET.getHangingSign(), RuBlocks.LARCH_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> MAGNOLIA_HANGING_SIGN = registerItem("magnolia_hanging_sign", () -> new HangingSignItem(RuBlocks.MAGNOLIA_WOOD_SET.getHangingSign(), RuBlocks.MAGNOLIA_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign", () -> new HangingSignItem(RuBlocks.MAPLE_WOOD_SET.getHangingSign(), RuBlocks.MAPLE_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> MAUVE_HANGING_SIGN = registerItem("mauve_hanging_sign", () -> new HangingSignItem(RuBlocks.MAUVE_WOOD_SET.getHangingSign(), RuBlocks.MAUVE_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> PALM_HANGING_SIGN = registerItem("palm_hanging_sign", () -> new HangingSignItem(RuBlocks.PALM_WOOD_SET.getHangingSign(), RuBlocks.PALM_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> PINE_HANGING_SIGN = registerItem("pine_hanging_sign", () -> new HangingSignItem(RuBlocks.PINE_WOOD_SET.getHangingSign(), RuBlocks.PINE_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> PINK_BIOSHROOM_HANGING_SIGN = registerItem("pink_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getHangingSign(), RuBlocks.PINK_BIOSHROOM_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> REDWOOD_HANGING_SIGN = registerItem("redwood_hanging_sign", () -> new HangingSignItem(RuBlocks.REDWOOD_WOOD_SET.getHangingSign(), RuBlocks.REDWOOD_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> SOCOTRA_HANGING_SIGN = registerItem("socotra_hanging_sign", () -> new HangingSignItem(RuBlocks.SOCOTRA_WOOD_SET.getHangingSign(), RuBlocks.SOCOTRA_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> WILLOW_HANGING_SIGN = registerItem("willow_hanging_sign", () -> new HangingSignItem(RuBlocks.WILLOW_WOOD_SET.getHangingSign(), RuBlocks.WILLOW_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> YELLOW_BIOSHROOM_HANGING_SIGN = registerItem("yellow_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getHangingSign(), RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));

    public static final Supplier<Item> BAOBAB_SIGN = registerItem("baobab_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BAOBAB_WOOD_SET.getSign(), RuBlocks.BAOBAB_WOOD_SET.getWallSign()));
    public static final Supplier<Item> BLACKWOOD_SIGN = registerItem("blackwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLACKWOOD_WOOD_SET.getSign(), RuBlocks.BLACKWOOD_WOOD_SET.getWallSign()));
    public static final Supplier<Item> BLUE_BIOSHROOM_SIGN = registerItem("blue_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getSign(), RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getWallSign()));
    public static final Supplier<Item> BRIMWOOD_SIGN = registerItem("brimwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BRIMWOOD_WOOD_SET.getSign(), RuBlocks.BRIMWOOD_WOOD_SET.getWallSign()));
    public static final Supplier<Item> COBALT_SIGN = registerItem("cobalt_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.COBALT_WOOD_SET.getSign(), RuBlocks.COBALT_WOOD_SET.getWallSign()));
    public static final Supplier<Item> CYPRESS_SIGN = registerItem("cypress_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.CYPRESS_WOOD_SET.getSign(), RuBlocks.CYPRESS_WOOD_SET.getWallSign()));
    public static final Supplier<Item> DEAD_SIGN = registerItem("dead_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.DEAD_WOOD_SET.getSign(), RuBlocks.DEAD_WOOD_SET.getWallSign()));
    public static final Supplier<Item> EUCALYPTUS_SIGN = registerItem("eucalyptus_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.EUCALYPTUS_WOOD_SET.getSign(), RuBlocks.EUCALYPTUS_WOOD_SET.getWallSign()));
    public static final Supplier<Item> GREEN_BIOSHROOM_SIGN = registerItem("green_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getSign(), RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getWallSign()));
    public static final Supplier<Item> JOSHUA_SIGN = registerItem("joshua_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.JOSHUA_WOOD_SET.getSign(), RuBlocks.JOSHUA_WOOD_SET.getWallSign()));
    public static final Supplier<Item> KAPOK_SIGN = registerItem("kapok_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.KAPOK_WOOD_SET.getSign(), RuBlocks.KAPOK_WOOD_SET.getWallSign()));
    public static final Supplier<Item> LARCH_SIGN = registerItem("larch_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.LARCH_WOOD_SET.getSign(), RuBlocks.LARCH_WOOD_SET.getWallSign()));
    public static final Supplier<Item> MAGNOLIA_SIGN = registerItem("magnolia_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAGNOLIA_WOOD_SET.getSign(), RuBlocks.MAGNOLIA_WOOD_SET.getWallSign()));
    public static final Supplier<Item> MAPLE_SIGN = registerItem("maple_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAPLE_WOOD_SET.getSign(), RuBlocks.MAPLE_WOOD_SET.getWallSign()));
    public static final Supplier<Item> MAUVE_SIGN = registerItem("mauve_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAUVE_WOOD_SET.getSign(), RuBlocks.MAUVE_WOOD_SET.getWallSign()));
    public static final Supplier<Item> PALM_SIGN = registerItem("palm_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PALM_WOOD_SET.getSign(), RuBlocks.PALM_WOOD_SET.getWallSign()));
    public static final Supplier<Item> PINE_SIGN = registerItem("pine_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINE_WOOD_SET.getSign(), RuBlocks.PINE_WOOD_SET.getWallSign()));
    public static final Supplier<Item> PINK_BIOSHROOM_SIGN = registerItem("pink_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINK_BIOSHROOM_WOOD_SET.getSign(), RuBlocks.PINK_BIOSHROOM_WOOD_SET.getWallSign()));
    public static final Supplier<Item> REDWOOD_SIGN = registerItem("redwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.REDWOOD_WOOD_SET.getSign(), RuBlocks.REDWOOD_WOOD_SET.getWallSign()));
    public static final Supplier<Item> SOCOTRA_SIGN = registerItem("socotra_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.SOCOTRA_WOOD_SET.getSign(), RuBlocks.SOCOTRA_WOOD_SET.getWallSign()));
    public static final Supplier<Item> WILLOW_SIGN = registerItem("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.WILLOW_WOOD_SET.getSign(), RuBlocks.WILLOW_WOOD_SET.getWallSign()));
    public static final Supplier<Item> YELLOW_BIOSHROOM_SIGN = registerItem("yellow_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getSign(), RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getWallSign()));

    public static final Supplier<Item> BAOBAB_BOAT = registerItem("baobab_boat", () -> new RuBoatItem(false, RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> BAOBAB_CHEST_BOAT = registerItem("baobab_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> BLACKWOOD_BOAT = registerItem("blackwood_boat", () -> new RuBoatItem(false, RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> BLACKWOOD_CHEST_BOAT = registerItem("blackwood_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> MAGNOLIA_BOAT = registerItem("magnolia_boat", () -> new RuBoatItem(false, RuBoat.ModelType.MAGNOLIA, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> MAGNOLIA_CHEST_BOAT = registerItem("magnolia_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.MAGNOLIA, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> CYPRESS_BOAT = registerItem("cypress_boat", () -> new RuBoatItem(false, RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> CYPRESS_CHEST_BOAT = registerItem("cypress_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> DEAD_BOAT = registerItem("dead_boat", () -> new RuBoatItem(false, RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> DEAD_CHEST_BOAT = registerItem("dead_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> EUCALYPTUS_BOAT = registerItem("eucalyptus_boat", () -> new RuBoatItem(false, RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> EUCALYPTUS_CHEST_BOAT = registerItem("eucalyptus_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> JOSHUA_BOAT = registerItem("joshua_boat", () -> new RuBoatItem(false, RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> JOSHUA_CHEST_BOAT = registerItem("joshua_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> KAPOK_BOAT = registerItem("kapok_boat", () -> new RuBoatItem(false, RuBoat.ModelType.KAPOK, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> KAPOK_CHEST_BOAT = registerItem("kapok_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.KAPOK, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> LARCH_BOAT = registerItem("larch_boat", () -> new RuBoatItem(false, RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> LARCH_CHEST_BOAT = registerItem("larch_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> MAPLE_BOAT = registerItem("maple_boat", () -> new RuBoatItem(false, RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> MAPLE_CHEST_BOAT = registerItem("maple_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> MAUVE_BOAT = registerItem("mauve_boat", () -> new RuBoatItem(false, RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> MAUVE_CHEST_BOAT = registerItem("mauve_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> PALM_BOAT = registerItem("palm_boat", () -> new RuBoatItem(false, RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> PALM_CHEST_BOAT = registerItem("palm_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> PINE_BOAT = registerItem("pine_boat", () -> new RuBoatItem(false, RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> PINE_CHEST_BOAT = registerItem("pine_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> REDWOOD_BOAT = registerItem("redwood_boat", () -> new RuBoatItem(false, RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> REDWOOD_CHEST_BOAT = registerItem("redwood_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> SOCOTRA_BOAT = registerItem("socotra_boat", () -> new RuBoatItem(false, RuBoat.ModelType.SOCOTRA, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> SOCOTRA_CHEST_BOAT = registerItem("socotra_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.SOCOTRA, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> WILLOW_BOAT = registerItem("willow_boat", () -> new RuBoatItem(false, RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)));
    public static final Supplier<Item> WILLOW_CHEST_BOAT = registerItem("willow_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)));

    public static final Supplier<Item> SALMONBERRY = registerItem("salmonberry", () -> new ItemNameBlockItem(RuBlocks.SALMONBERRY_BUSH.get(), new Item.Properties().food(food(3, 0.3f, t -> t))));
    public static final Supplier<Item> DUSKMELON_SLICE = registerItem("duskmelon_slice", () -> new BlockItem(RuBlocks.DUSKMELON.get(), new Item.Properties().food(food(5, 1.1f, t -> t.effect(new MobEffectInstance(MobEffects.BLINDNESS, 240), 1)))));
    public static final Supplier<Item> HANGING_EARLIGHT_FRUIT = registerItem("hanging_earlight_fruit", () -> new BlockItem(RuBlocks.HANGING_EARLIGHT.get(), new Item.Properties().food(food(6, 0.4f, t -> t.effect(new MobEffectInstance(MobEffects.GLOWING, 200), 0.1F)))));
    public static final Supplier<Item> MEADOW_SAGE = registerItem("meadow_sage", () -> new BlockItem(RuBlocks.MEADOW_SAGE.get(), new Item.Properties().food(food(2, 0.15f, t -> t.effect(new MobEffectInstance(MobEffects.HEAL, 20), 0.5f)))));

    private static FoodProperties food(int nutrition, float saturation, UnaryOperator<FoodProperties.Builder> operator) {
        return operator.apply(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)).build();
    }

    public static void addItems() {

    }

    private static Supplier<Item> registerItem(String path, Supplier<Item> item) {
        return Services.REGISTAR.register(BuiltInRegistries.ITEM, path, item);
    }
}
