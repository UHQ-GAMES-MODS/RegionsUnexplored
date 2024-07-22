package net.regions_unexplored.item.items;

import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.regions_unexplored.Constants;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.platform.Services;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RuCreativeModeTabs {

    public static final Supplier<CreativeModeTab> TAB = registerTab("regions_unexplored", () -> RuItems.BAOBAB_BOAT.get().getDefaultInstance(), () -> BuiltInRegistries.ITEM.stream().filter(item -> BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(Constants.MOD_ID)).map(item -> Suppliers.memoize(() -> item)).collect(Collectors.toUnmodifiableList()));

    public static Supplier<CreativeModeTab> registerTab(String path, Supplier<ItemStack> icon, Supplier<List<Supplier<Item>>> items) {
        return Services.REGISTAR.registerCreativeModeTab(path, icon, items);
    }

    public static void init(){}
}
