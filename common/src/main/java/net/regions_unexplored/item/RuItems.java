package net.regions_unexplored.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.regions_unexplored.Constants;
import net.regions_unexplored.api.item.Food;
import net.regions_unexplored.api.item.FoodItemWithBlock;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.item.items.RuBoatItem;

import java.util.HashMap;
import java.util.Map;

public class RuItems {
    public static Map<String, Item> ITEMS = new HashMap<>();

    public static final Item BAOBAB_HANGING_SIGN = registerItem("baobab_hanging_sign", new HangingSignItem(RuBlocks.BAOBAB_HANGING_SIGN, RuBlocks.BAOBAB_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BLACKWOOD_HANGING_SIGN = registerItem("blackwood_hanging_sign", new HangingSignItem(RuBlocks.BLACKWOOD_HANGING_SIGN, RuBlocks.BLACKWOOD_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BLUE_BIOSHROOM_HANGING_SIGN = registerItem("blue_bioshroom_hanging_sign", new HangingSignItem(RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN, RuBlocks.BLUE_BIOSHROOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item BRIMWOOD_HANGING_SIGN = registerItem("brimwood_hanging_sign", new HangingSignItem(RuBlocks.BRIMWOOD_HANGING_SIGN, RuBlocks.BRIMWOOD_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item COBALT_HANGING_SIGN = registerItem("cobalt_hanging_sign", new HangingSignItem(RuBlocks.COBALT_HANGING_SIGN, RuBlocks.COBALT_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item CYPRESS_HANGING_SIGN = registerItem("cypress_hanging_sign", new HangingSignItem(RuBlocks.CYPRESS_HANGING_SIGN, RuBlocks.CYPRESS_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item DEAD_HANGING_SIGN = registerItem("dead_hanging_sign", new HangingSignItem(RuBlocks.DEAD_HANGING_SIGN, RuBlocks.DEAD_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item EUCALYPTUS_HANGING_SIGN = registerItem("eucalyptus_hanging_sign", new HangingSignItem(RuBlocks.EUCALYPTUS_HANGING_SIGN, RuBlocks.EUCALYPTUS_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item GREEN_BIOSHROOM_HANGING_SIGN = registerItem("green_bioshroom_hanging_sign", new HangingSignItem(RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN, RuBlocks.GREEN_BIOSHROOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item JOSHUA_HANGING_SIGN = registerItem("joshua_hanging_sign", new HangingSignItem(RuBlocks.JOSHUA_HANGING_SIGN, RuBlocks.JOSHUA_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item KAPOK_HANGING_SIGN = registerItem("kapok_hanging_sign", new HangingSignItem(RuBlocks.KAPOK_HANGING_SIGN, RuBlocks.KAPOK_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item LARCH_HANGING_SIGN = registerItem("larch_hanging_sign", new HangingSignItem(RuBlocks.LARCH_HANGING_SIGN, RuBlocks.LARCH_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item MAGNOLIA_HANGING_SIGN = registerItem("magnolia_hanging_sign", new HangingSignItem(RuBlocks.MAGNOLIA_HANGING_SIGN, RuBlocks.MAGNOLIA_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item MAPLE_HANGING_SIGN = registerItem("maple_hanging_sign", new HangingSignItem(RuBlocks.MAPLE_HANGING_SIGN, RuBlocks.MAPLE_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item MAUVE_HANGING_SIGN = registerItem("mauve_hanging_sign", new HangingSignItem(RuBlocks.MAUVE_HANGING_SIGN, RuBlocks.MAUVE_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item PALM_HANGING_SIGN = registerItem("palm_hanging_sign", new HangingSignItem(RuBlocks.PALM_HANGING_SIGN, RuBlocks.PALM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item PINE_HANGING_SIGN = registerItem("pine_hanging_sign", new HangingSignItem(RuBlocks.PINE_HANGING_SIGN, RuBlocks.PINE_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item PINK_BIOSHROOM_HANGING_SIGN = registerItem("pink_bioshroom_hanging_sign", new HangingSignItem(RuBlocks.PINK_BIOSHROOM_HANGING_SIGN, RuBlocks.PINK_BIOSHROOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item REDWOOD_HANGING_SIGN = registerItem("redwood_hanging_sign", new HangingSignItem(RuBlocks.REDWOOD_HANGING_SIGN, RuBlocks.REDWOOD_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item SOCOTRA_HANGING_SIGN = registerItem("socotra_hanging_sign", new HangingSignItem(RuBlocks.SOCOTRA_HANGING_SIGN, RuBlocks.SOCOTRA_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item WILLOW_HANGING_SIGN = registerItem("willow_hanging_sign", new HangingSignItem(RuBlocks.WILLOW_HANGING_SIGN, RuBlocks.WILLOW_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));
    public static final Item YELLOW_BIOSHROOM_HANGING_SIGN = registerItem("yellow_bioshroom_hanging_sign", new HangingSignItem(RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN, RuBlocks.YELLOW_BIOSHROOM_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16)));

    public static final Item BAOBAB_SIGN = registerItem("baobab_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BAOBAB_SIGN, RuBlocks.BAOBAB_WALL_SIGN));
    public static final Item BLACKWOOD_SIGN = registerItem("blackwood_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLACKWOOD_SIGN, RuBlocks.BLACKWOOD_WALL_SIGN));
    public static final Item BLUE_BIOSHROOM_SIGN = registerItem("blue_bioshroom_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLUE_BIOSHROOM_SIGN, RuBlocks.BLUE_BIOSHROOM_WALL_SIGN));
    public static final Item BRIMWOOD_SIGN = registerItem("brimwood_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BRIMWOOD_SIGN, RuBlocks.BRIMWOOD_WALL_SIGN));
    public static final Item COBALT_SIGN = registerItem("cobalt_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.COBALT_SIGN, RuBlocks.COBALT_WALL_SIGN));
    public static final Item CYPRESS_SIGN = registerItem("cypress_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.CYPRESS_SIGN, RuBlocks.CYPRESS_WALL_SIGN));
    public static final Item DEAD_SIGN = registerItem("dead_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.DEAD_SIGN, RuBlocks.DEAD_WALL_SIGN));
    public static final Item EUCALYPTUS_SIGN = registerItem("eucalyptus_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.EUCALYPTUS_SIGN, RuBlocks.EUCALYPTUS_WALL_SIGN));
    public static final Item GREEN_BIOSHROOM_SIGN = registerItem("green_bioshroom_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.GREEN_BIOSHROOM_SIGN, RuBlocks.GREEN_BIOSHROOM_WALL_SIGN));
    public static final Item JOSHUA_SIGN = registerItem("joshua_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.JOSHUA_SIGN, RuBlocks.JOSHUA_WALL_SIGN));
    public static final Item KAPOK_SIGN = registerItem("kapok_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.KAPOK_SIGN, RuBlocks.KAPOK_WALL_SIGN));
    public static final Item LARCH_SIGN = registerItem("larch_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.LARCH_SIGN, RuBlocks.LARCH_WALL_SIGN));
    public static final Item MAGNOLIA_SIGN = registerItem("magnolia_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAGNOLIA_SIGN, RuBlocks.MAGNOLIA_WALL_SIGN));
    public static final Item MAPLE_SIGN = registerItem("maple_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAPLE_SIGN, RuBlocks.MAPLE_WALL_SIGN));
    public static final Item MAUVE_SIGN = registerItem("mauve_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAUVE_SIGN, RuBlocks.MAUVE_WALL_SIGN));
    public static final Item PALM_SIGN = registerItem("palm_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PALM_SIGN, RuBlocks.PALM_WALL_SIGN));
    public static final Item PINE_SIGN = registerItem("pine_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINE_SIGN, RuBlocks.PINE_WALL_SIGN));
    public static final Item PINK_BIOSHROOM_SIGN = registerItem("pink_bioshroom_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINK_BIOSHROOM_SIGN, RuBlocks.PINK_BIOSHROOM_WALL_SIGN));
    public static final Item REDWOOD_SIGN = registerItem("redwood_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.REDWOOD_SIGN, RuBlocks.REDWOOD_WALL_SIGN));
    public static final Item SOCOTRA_SIGN = registerItem("socotra_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.SOCOTRA_SIGN, RuBlocks.SOCOTRA_WALL_SIGN));
    public static final Item WILLOW_SIGN = registerItem("willow_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.WILLOW_SIGN, RuBlocks.WILLOW_WALL_SIGN));
    public static final Item YELLOW_BIOSHROOM_SIGN = registerItem("yellow_bioshroom_sign", new SignItem(new Item.Properties().stacksTo(16), RuBlocks.YELLOW_BIOSHROOM_SIGN, RuBlocks.YELLOW_BIOSHROOM_WALL_SIGN));

    public static final Item BAOBAB_BOAT = registerItem("baobab_boat", new RuBoatItem(false, RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1)));
    public static final Item BAOBAB_CHEST_BOAT = registerItem("baobab_chest_boat", new RuBoatItem(true, RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1)));
    public static final Item BLACKWOOD_BOAT = registerItem("blackwood_boat", new RuBoatItem(false, RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Item BLACKWOOD_CHEST_BOAT = registerItem("blackwood_chest_boat", new RuBoatItem(true, RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Item MAGNOLIA_BOAT = registerItem("magnolia_boat", new RuBoatItem(false, RuBoat.ModelType.MAGNOLIA, (new Item.Properties()).stacksTo(1)));
    public static final Item MAGNOLIA_CHEST_BOAT = registerItem("magnolia_chest_boat", new RuBoatItem(true, RuBoat.ModelType.MAGNOLIA, (new Item.Properties()).stacksTo(1)));
    public static final Item CYPRESS_BOAT = registerItem("cypress_boat", new RuBoatItem(false, RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1)));
    public static final Item CYPRESS_CHEST_BOAT = registerItem("cypress_chest_boat", new RuBoatItem(true, RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1)));
    public static final Item DEAD_BOAT = registerItem("dead_boat", new RuBoatItem(false, RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1)));
    public static final Item DEAD_CHEST_BOAT = registerItem("dead_chest_boat", new RuBoatItem(true, RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1)));
    public static final Item EUCALYPTUS_BOAT = registerItem("eucalyptus_boat", new RuBoatItem(false, RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1)));
    public static final Item EUCALYPTUS_CHEST_BOAT = registerItem("eucalyptus_chest_boat", new RuBoatItem(true, RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1)));
    public static final Item JOSHUA_BOAT = registerItem("joshua_boat", new RuBoatItem(false, RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1)));
    public static final Item JOSHUA_CHEST_BOAT = registerItem("joshua_chest_boat", new RuBoatItem(true, RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1)));
    public static final Item KAPOK_BOAT = registerItem("kapok_boat", new RuBoatItem(false, RuBoat.ModelType.KAPOK, (new Item.Properties()).stacksTo(1)));
    public static final Item KAPOK_CHEST_BOAT = registerItem("kapok_chest_boat", new RuBoatItem(true, RuBoat.ModelType.KAPOK, (new Item.Properties()).stacksTo(1)));
    public static final Item LARCH_BOAT = registerItem("larch_boat", new RuBoatItem(false, RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1)));
    public static final Item LARCH_CHEST_BOAT = registerItem("larch_chest_boat", new RuBoatItem(true, RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1)));
    public static final Item MAPLE_BOAT = registerItem("maple_boat", new RuBoatItem(false, RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1)));
    public static final Item MAPLE_CHEST_BOAT = registerItem("maple_chest_boat", new RuBoatItem(true, RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1)));
    public static final Item MAUVE_BOAT = registerItem("mauve_boat", new RuBoatItem(false, RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1)));
    public static final Item MAUVE_CHEST_BOAT = registerItem("mauve_chest_boat", new RuBoatItem(true, RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1)));
    public static final Item PALM_BOAT = registerItem("palm_boat", new RuBoatItem(false, RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1)));
    public static final Item PALM_CHEST_BOAT = registerItem("palm_chest_boat", new RuBoatItem(true, RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1)));
    public static final Item PINE_BOAT = registerItem("pine_boat", new RuBoatItem(false, RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1)));
    public static final Item PINE_CHEST_BOAT = registerItem("pine_chest_boat", new RuBoatItem(true, RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1)));
    public static final Item REDWOOD_BOAT = registerItem("redwood_boat", new RuBoatItem(false, RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Item REDWOOD_CHEST_BOAT = registerItem("redwood_chest_boat", new RuBoatItem(true, RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)));
    public static final Item SOCOTRA_BOAT = registerItem("socotra_boat", new RuBoatItem(false, RuBoat.ModelType.SOCOTRA, (new Item.Properties()).stacksTo(1)));
    public static final Item SOCOTRA_CHEST_BOAT = registerItem("socotra_chest_boat", new RuBoatItem(true, RuBoat.ModelType.SOCOTRA, (new Item.Properties()).stacksTo(1)));
    public static final Item WILLOW_BOAT = registerItem("willow_boat", new RuBoatItem(false, RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)));
    public static final Item WILLOW_CHEST_BOAT = registerItem("willow_chest_boat", new RuBoatItem(true, RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)));

    public static final Item SALMONBERRY = registerItem("salmonberry", new FoodItemWithBlock(RuBlocks.SALMONBERRY_BUSH, new Item.Properties(), new Food(3, 0.3f)));
    public static final Item DUSKMELON_SLICE = registerItem("duskmelon_slice", new FoodItemWithBlock(RuBlocks.DUSKMELON, new Item.Properties(), new Food(5, 1.1f).addEffect(MobEffects.BLINDNESS, 240, 1)));
    public static final Item HANGING_EARLIGHT_FRUIT = registerItem("hanging_earlight_fruit", new FoodItemWithBlock(RuBlocks.HANGING_EARLIGHT, new Item.Properties(), new Food(6, 0.4f).addEffect(MobEffects.GLOWING, 200, 0.1F)));
    public static final Item MEADOW_SAGE = registerItem("meadow_sage", new FoodItemWithBlock(RuBlocks.MEADOW_SAGE, new Item.Properties(), new Food(2, 0.15f).addEffect(MobEffects.HEAL, 20, 0.5f)));

    public static void addItems() {
        if (ITEMS.isEmpty()) return;
        ITEMS.forEach(RuItems::registerItem);
    }

    private static Item registerItem(String path, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Constants.id(path), item);
    }
}
