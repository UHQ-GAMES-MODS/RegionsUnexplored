package net.regions_unexplored.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SignItem;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.item.items.RuBoatItem;
import net.regions_unexplored.platform.Services;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RuItems {

    public static final Supplier<Item> BAOBAB_HANGING_SIGN = registerItem("baobab_hanging_sign", () -> new HangingSignItem(RuBlocks.BAOBAB.getHangingSign(), RuBlocks.BAOBAB.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> BLACKWOOD_HANGING_SIGN = registerItem("blackwood_hanging_sign", () -> new HangingSignItem(RuBlocks.BLACKWOOD.getHangingSign(), RuBlocks.BLACKWOOD.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> BLUE_BIOSHROOM_HANGING_SIGN = registerItem("blue_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.BLUE_BIOSHROOM_SET.getHangingSign(), RuBlocks.BLUE_BIOSHROOM_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> BRIMWOOD_HANGING_SIGN = registerItem("brimwood_hanging_sign", () -> new HangingSignItem(RuBlocks.BRIMWOOD.getHangingSign(), RuBlocks.BRIMWOOD.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> COBALT_HANGING_SIGN = registerItem("cobalt_hanging_sign", () -> new HangingSignItem(RuBlocks.COBALT.getHangingSign(), RuBlocks.COBALT.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> CYPRESS_HANGING_SIGN = registerItem("cypress_hanging_sign", () -> new HangingSignItem(RuBlocks.CYPRESS.getHangingSign(), RuBlocks.CYPRESS.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> DEAD_HANGING_SIGN = registerItem("dead_hanging_sign", () -> new HangingSignItem(RuBlocks.DEAD.getHangingSign(), RuBlocks.DEAD.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> EUCALYPTUS_HANGING_SIGN = registerItem("eucalyptus_hanging_sign", () -> new HangingSignItem(RuBlocks.EUCALYPTUS.getHangingSign(), RuBlocks.EUCALYPTUS.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> GREEN_BIOSHROOM_HANGING_SIGN = registerItem("green_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.GREEN_BIOSHROOM_SET.getHangingSign(), RuBlocks.GREEN_BIOSHROOM_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> JOSHUA_HANGING_SIGN = registerItem("joshua_hanging_sign", () -> new HangingSignItem(RuBlocks.JOSHUA.getHangingSign(), RuBlocks.JOSHUA.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> KAPOK_HANGING_SIGN = registerItem("kapok_hanging_sign", () -> new HangingSignItem(RuBlocks.KAPOK.getHangingSign(), RuBlocks.KAPOK.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> LARCH_HANGING_SIGN = registerItem("larch_hanging_sign", () -> new HangingSignItem(RuBlocks.LARCH.getHangingSign(), RuBlocks.LARCH.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> MAGNOLIA_HANGING_SIGN = registerItem("magnolia_hanging_sign", () -> new HangingSignItem(RuBlocks.MAGNOLIA.getHangingSign(), RuBlocks.MAGNOLIA.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign", () -> new HangingSignItem(RuBlocks.MAPLE.getHangingSign(), RuBlocks.MAPLE.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> MAUVE_HANGING_SIGN = registerItem("mauve_hanging_sign", () -> new HangingSignItem(RuBlocks.MAUVE.getHangingSign(), RuBlocks.MAUVE.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> PALM_HANGING_SIGN = registerItem("palm_hanging_sign", () -> new HangingSignItem(RuBlocks.PALM.getHangingSign(), RuBlocks.PALM.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> PINE_HANGING_SIGN = registerItem("pine_hanging_sign", () -> new HangingSignItem(RuBlocks.PINE.getHangingSign(), RuBlocks.PINE.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> PINK_BIOSHROOM_HANGING_SIGN = registerItem("pink_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.PINK_BIOSHROOM_SET.getHangingSign(), RuBlocks.PINK_BIOSHROOM_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> REDWOOD_HANGING_SIGN = registerItem("redwood_hanging_sign", () -> new HangingSignItem(RuBlocks.REDWOOD.getHangingSign(), RuBlocks.REDWOOD.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> SOCOTRA_HANGING_SIGN = registerItem("socotra_hanging_sign", () -> new HangingSignItem(RuBlocks.SOCOTRA.getHangingSign(), RuBlocks.SOCOTRA.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> WILLOW_HANGING_SIGN = registerItem("willow_hanging_sign", () -> new HangingSignItem(RuBlocks.WILLOW.getHangingSign(), RuBlocks.WILLOW.getWallHangingSign(), new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> YELLOW_BIOSHROOM_HANGING_SIGN = registerItem("yellow_bioshroom_hanging_sign", () -> new HangingSignItem(RuBlocks.YELLOW_BIOSHROOM_SET.getHangingSign(), RuBlocks.YELLOW_BIOSHROOM_SET.getWallHangingSign(), new Item.Properties().stacksTo(16)));

    public static final Supplier<Item> BAOBAB_SIGN = registerItem("baobab_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BAOBAB.getSign(), RuBlocks.BAOBAB.getWallSign()));
    public static final Supplier<Item> BLACKWOOD_SIGN = registerItem("blackwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLACKWOOD.getSign(), RuBlocks.BLACKWOOD.getWallSign()));
    public static final Supplier<Item> BLUE_BIOSHROOM_SIGN = registerItem("blue_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLUE_BIOSHROOM_SET.getSign(), RuBlocks.BLUE_BIOSHROOM_SET.getWallSign()));
    public static final Supplier<Item> BRIMWOOD_SIGN = registerItem("brimwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BRIMWOOD.getSign(), RuBlocks.BRIMWOOD.getWallSign()));
    public static final Supplier<Item> COBALT_SIGN = registerItem("cobalt_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.COBALT.getSign(), RuBlocks.COBALT.getWallSign()));
    public static final Supplier<Item> CYPRESS_SIGN = registerItem("cypress_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.CYPRESS.getSign(), RuBlocks.CYPRESS.getWallSign()));
    public static final Supplier<Item> DEAD_SIGN = registerItem("dead_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.DEAD.getSign(), RuBlocks.DEAD.getWallSign()));
    public static final Supplier<Item> EUCALYPTUS_SIGN = registerItem("eucalyptus_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.EUCALYPTUS.getSign(), RuBlocks.EUCALYPTUS.getWallSign()));
    public static final Supplier<Item> GREEN_BIOSHROOM_SIGN = registerItem("green_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.GREEN_BIOSHROOM_SET.getSign(), RuBlocks.GREEN_BIOSHROOM_SET.getWallSign()));
    public static final Supplier<Item> JOSHUA_SIGN = registerItem("joshua_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.JOSHUA.getSign(), RuBlocks.JOSHUA.getWallSign()));
    public static final Supplier<Item> KAPOK_SIGN = registerItem("kapok_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.KAPOK.getSign(), RuBlocks.KAPOK.getWallSign()));
    public static final Supplier<Item> LARCH_SIGN = registerItem("larch_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.LARCH.getSign(), RuBlocks.LARCH.getWallSign()));
    public static final Supplier<Item> MAGNOLIA_SIGN = registerItem("magnolia_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAGNOLIA.getSign(), RuBlocks.MAGNOLIA.getWallSign()));
    public static final Supplier<Item> MAPLE_SIGN = registerItem("maple_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAPLE.getSign(), RuBlocks.MAPLE.getWallSign()));
    public static final Supplier<Item> MAUVE_SIGN = registerItem("mauve_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAUVE.getSign(), RuBlocks.MAUVE.getWallSign()));
    public static final Supplier<Item> PALM_SIGN = registerItem("palm_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PALM.getSign(), RuBlocks.PALM.getWallSign()));
    public static final Supplier<Item> PINE_SIGN = registerItem("pine_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINE.getSign(), RuBlocks.PINE.getWallSign()));
    public static final Supplier<Item> PINK_BIOSHROOM_SIGN = registerItem("pink_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINK_BIOSHROOM_SET.getSign(), RuBlocks.PINK_BIOSHROOM_SET.getWallSign()));
    public static final Supplier<Item> REDWOOD_SIGN = registerItem("redwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.REDWOOD.getSign(), RuBlocks.REDWOOD.getWallSign()));
    public static final Supplier<Item> SOCOTRA_SIGN = registerItem("socotra_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.SOCOTRA.getSign(), RuBlocks.SOCOTRA.getWallSign()));
    public static final Supplier<Item> WILLOW_SIGN = registerItem("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.WILLOW.getSign(), RuBlocks.WILLOW.getWallSign()));
    public static final Supplier<Item> YELLOW_BIOSHROOM_SIGN = registerItem("yellow_bioshroom_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.YELLOW_BIOSHROOM_SET.getSign(), RuBlocks.YELLOW_BIOSHROOM_SET.getWallSign()));

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
    public static final Supplier<Item> DUSKMELON_SLICE = registerItem("duskmelon_slice", () -> new ItemNameBlockItem(RuBlocks.DUSKMELON.get(), new Item.Properties().food(food(5, 1.1f, t -> t.effect(new MobEffectInstance(MobEffects.BLINDNESS, 240), 1)))));
    public static final Supplier<Item> HANGING_EARLIGHT_FRUIT = registerItem("hanging_earlight_fruit", () -> new ItemNameBlockItem(RuBlocks.HANGING_EARLIGHT.get(), new Item.Properties().food(food(6, 0.4f, t -> t.effect(new MobEffectInstance(MobEffects.GLOWING, 200), 0.1F)))));
    public static final Supplier<Item> MEADOW_SAGE = registerItem("meadow_sage", () -> new ItemNameBlockItem(RuBlocks.MEADOW_SAGE.get(), new Item.Properties().food(food(2, 0.15f, t -> t.effect(new MobEffectInstance(MobEffects.HEAL, 20), 0.5f)))));

    private static FoodProperties food(int nutrition, float saturation, UnaryOperator<FoodProperties.Builder> operator) {
        return operator.apply(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation)).build();
    }

    public static void addItems() {

    }

    private static Supplier<Item> registerItem(String path, Supplier<Item> item) {
        return Services.REGISTAR.register(BuiltInRegistries.ITEM, path, item);
    }
}
