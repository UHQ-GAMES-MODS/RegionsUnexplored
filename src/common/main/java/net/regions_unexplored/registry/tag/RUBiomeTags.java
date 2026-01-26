package net.regions_unexplored.registry.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.RegionsUnexplored;

public interface RUBiomeTags {
   TagKey<Biome> HAS_ASHEN_WOLF = key("has_wolf_variant/ashen");
   TagKey<Biome> HAS_BLACK_WOLF = key("has_wolf_variant/black");
   TagKey<Biome> HAS_CHESTNUT_WOLF = key("has_wolf_variant/chestnut");
   TagKey<Biome> HAS_PALE_WOLF = key("has_wolf_variant/pale");
   TagKey<Biome> HAS_RUSTY_WOLF = key("has_wolf_variant/rusty");
   TagKey<Biome> HAS_SNOWY_WOLF = key("has_wolf_variant/snowy");
   TagKey<Biome> HAS_SPOTTED_WOLF = key("has_wolf_variant/spotted");
   TagKey<Biome> HAS_STRIPED_WOLF = key("has_wolf_variant/striped");
   TagKey<Biome> HAS_WOODS_WOLF = key("has_wolf_variant/woods");

   private static TagKey<Biome> key(String name) {
      return TagKey.create(Registries.BIOME, RegionsUnexplored.id(name));
   }
}
