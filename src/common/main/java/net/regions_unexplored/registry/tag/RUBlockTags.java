package net.regions_unexplored.registry.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.TagKey;
import net.regions_unexplored.RegionsUnexplored;

public interface RUBlockTags {
   TagKey<Block> BRANCHES_CAN_SURVIVE_ON = key("branches_can_survive_on");
   TagKey<Block> BRIM_PLANT_CAN_SURVIVE_ON = key("brim_plant_can_survive_on");
   TagKey<Block> CATTAIL_CAN_SURVIVE_ON = key("cattail_can_survive_on");
   TagKey<Block> SANDY_PLANT_CAN_SURVIVE_ON = key("sandy_plant_can_survive_on");
   TagKey<Block> SHRUB_CAN_SURVIVE_ON = key("shrub_can_survive_on");
   TagKey<Block> SNOW_PLANT_CAN_SURVIVE_ON = key("snow_plant_can_survive_on");
   TagKey<Block> SUPPORTS_GRASS_SPROUTS = key("supports_grass_sprouts");
   TagKey<Block> BIOSHROOM_GROW_BLOCK = key("bioshroom_grow_block");
   TagKey<Block> REPLACEABLE_BLOCKS = key("replaceable_blocks");
   TagKey<Block> PRISMARITE_CRYSTALS = key("prismarite_crystals");
   TagKey<Block> SNOWBELLE = key("snowbelle");
   TagKey<Block> GRASS = key("grass");
   TagKey<Block> SHRUBS = key("shrubs");
   TagKey<Block> TREE_GRASS_REPLACEABLES = key("tree_grass_replaceables");
   TagKey<Block> ASH = key("ash");
   TagKey<Block> BRANCHES = key("branches");
   TagKey<Block> HYACINTH_BLOOMS = key("hyacinth_blooms");
   TagKey<Block> BAMBOO_LOGS = key("bamboo_logs");
   TagKey<Block> BAOBAB_LOGS = key("baobab_logs");
   TagKey<Block> BLACKWOOD_LOGS = key("blackwood_logs");
   TagKey<Block> BLUE_BIOSHROOM_LOGS = key("blue_bioshroom_logs");
   TagKey<Block> BRIMWOOD_LOGS = key("brimwood_logs");
   TagKey<Block> COBALT_LOGS = key("cobalt_logs");
   TagKey<Block> CYPRESS_LOGS = key("cypress_logs");
   TagKey<Block> DEAD_LOGS = key("dead_logs");
   TagKey<Block> EUCALYPTUS_LOGS = key("eucalyptus_logs");
   TagKey<Block> GREEN_BIOSHROOM_LOGS = key("green_bioshroom_logs");
   TagKey<Block> JOSHUA_LOGS = key("joshua_logs");
   TagKey<Block> KAPOK_LOGS = key("kapok_logs");
   TagKey<Block> LARCH_LOGS = key("larch_logs");
   TagKey<Block> MAGNOLIA_LOGS = key("magnolia_logs");
   TagKey<Block> MAPLE_LOGS = key("maple_logs");
   TagKey<Block> MAUVE_LOGS = key("mauve_logs");
   TagKey<Block> PALM_LOGS = key("palm_logs");
   TagKey<Block> PINE_LOGS = key("pine_logs");
   TagKey<Block> PINK_BIOSHROOM_LOGS = key("pink_bioshroom_logs");
   TagKey<Block> REDWOOD_LOGS = key("redwood_logs");
   TagKey<Block> SOCOTRA_LOGS = key("socotra_logs");
   TagKey<Block> WILLOW_LOGS = key("willow_logs");
   TagKey<Block> YELLOW_BIOSHROOM_LOGS = key("yellow_bioshroom_logs");
   TagKey<Block> CROP_PLANTABLE_BLOCKS = key("crop_plantable_blocks");

   private static TagKey<Block> key(String name) {
      return TagKey.create(Registries.BLOCK, RegionsUnexplored.id(name));
   }
}
