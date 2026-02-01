package net.regions_unexplored.registry.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.regions_unexplored.RegionsUnexplored;

public interface RUItemTags {
   TagKey<Item> PRISMARITE_CRYSTALS = key("prismarite_crystals");
   TagKey<Item> BIOSHROOMS = key("bioshrooms");
   TagKey<Item> LOGS = key("logs");
   TagKey<Item> SNOWBELLE = key("snowbelle");
   TagKey<Item> GRASS = key("grass");
   TagKey<Item> SHRUBS = key("shrubs");
   TagKey<Item> ASH = key("ash");
   TagKey<Item> BRANCHES = key("branches");
   TagKey<Item> HYACINTH_BLOOMS = key("hyacinth_blooms");
   TagKey<Item> BAMBOO_LOGS = key("bamboo_logs");
   TagKey<Item> BAOBAB_LOGS = key("baobab_logs");
   TagKey<Item> BLACKWOOD_LOGS = key("blackwood_logs");
   TagKey<Item> BLUE_BIOSHROOM_LOGS = key("blue_bioshroom_logs");
   TagKey<Item> BRIMWOOD_LOGS = key("brimwood_logs");
   TagKey<Item> COBALT_LOGS = key("cobalt_logs");
   TagKey<Item> CYPRESS_LOGS = key("cypress_logs");
   TagKey<Item> DEAD_LOGS = key("dead_logs");
   TagKey<Item> EUCALYPTUS_LOGS = key("eucalyptus_logs");
   TagKey<Item> GREEN_BIOSHROOM_LOGS = key("green_bioshroom_logs");
   TagKey<Item> JOSHUA_LOGS = key("joshua_logs");
   TagKey<Item> KAPOK_LOGS = key("kapok_logs");
   TagKey<Item> LARCH_LOGS = key("larch_logs");
   TagKey<Item> MAGNOLIA_LOGS = key("magnolia_logs");
   TagKey<Item> MAPLE_LOGS = key("maple_logs");
   TagKey<Item> MAUVE_LOGS = key("mauve_logs");
   TagKey<Item> PALM_LOGS = key("palm_logs");
   TagKey<Item> PINE_LOGS = key("pine_logs");
   TagKey<Item> PINK_BIOSHROOM_LOGS = key("pink_bioshroom_logs");
   TagKey<Item> REDWOOD_LOGS = key("redwood_logs");
   TagKey<Item> SOCOTRA_LOGS = key("socotra_logs");
   TagKey<Item> WILLOW_LOGS = key("willow_logs");
   TagKey<Item> YELLOW_BIOSHROOM_LOGS = key("yellow_bioshroom_logs");

   static TagKey<Item> key(String name) {
      return TagKey.create(Registries.ITEM, RegionsUnexplored.id(name));
   }
}
