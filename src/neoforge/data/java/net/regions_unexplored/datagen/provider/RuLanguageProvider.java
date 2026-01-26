package net.regions_unexplored.datagen.provider;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.data.RUBiomes;
import net.regions_unexplored.registry.RUEntityTypes;
import org.jetbrains.annotations.NotNull;

public class RuLanguageProvider extends LanguageProvider {
    public RuLanguageProvider(PackOutput output) {
        super(output, RegionsUnexplored.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("item_group.regions_unexplored.main", "Regions Unexplored");
        // Advancement translations
        this.add("advancements.regions_unexplored.title", "Regions Unexplored");
        this.add("advancements.regions_unexplored.description", "Discover the many biomes and explore the world!");

        this.add("advancements.regions_unexplored.pioneer.title", "Pioneer");
        this.add("advancements.regions_unexplored.pioneer.description", "Explore all Surface biomes from Regions Unexplored!");

        this.add("advancements.regions_unexplored.regions_explored.title", "Regions Explored");
        this.add("advancements.regions_unexplored.regions_explored.description", "You've explored all the biomes from Regions Unexplored");

        this.add("advancements.regions_unexplored.every_bit_of_the_rainbow.title", "Every Bit of the Rainbow");
        this.add("advancements.regions_unexplored.every_bit_of_the_rainbow.description", "Collect or craft every colour of the Snowbelle Flower.");

        this.add("advancements.regions_unexplored.from_the_tree_tops.title", "From the Tree Tops");
        this.add("advancements.regions_unexplored.from_the_tree_tops.description", "Hang from a Kapok tree's vines.");

        this.add("advancements.regions_unexplored.light_as_a_frog.title", "Light as a Frog");
        this.add("advancements.regions_unexplored.light_as_a_frog.description", "Walk or bounce on a Giant Lily Pad.");

        this.add("advancements.regions_unexplored.eternal_expedition.title", "Eternal Expedition");
        this.add("advancements.regions_unexplored.eternal_expedition.description", "Venture into all Nether biomes from Regions Unexplored!");

        this.add("advancements.regions_unexplored.downer.title", "Downer");
        this.add("advancements.regions_unexplored.downer.description", "Walk through and take damage from a Dorcel Flower.");

        this.add("advancements.regions_unexplored.light_snack.title", "Light Snack");
        this.add("advancements.regions_unexplored.light_snack.description", "Consume a Hanging Earlight Fruit.");

        this.add("advancements.regions_unexplored.spelunker.title", "Spelunker");
        this.add("advancements.regions_unexplored.spelunker.description", "Find all Cave biomes from Regions Unexplored!");

        this.add("advancements.regions_unexplored.blind_as_a_bat.title", "Blind as a Bat");
        this.add("advancements.regions_unexplored.blind_as_a_bat.description", "Consume a Duskmelon.");

        this.add("advancements.regions_unexplored.this_tree_bleeds_red.title", "This Tree Bleeds Red");
        this.add("advancements.regions_unexplored.this_tree_bleeds_red.description", "Chop down a Socotra tree.");

        this.add("advancements.regions_unexplored.got_wood.title", "Got Wood?");
        this.add("advancements.regions_unexplored.got_wood.description", "Collect every log from Regions Unexplored.");

        this.add("advancements.regions_unexplored.mycologist.title", "Mycologist");
        this.add("advancements.regions_unexplored.mycologist.description", "Collect every Bioshroom type.");

        this.add("advancements.regions_unexplored.ancient_specimens.title", "Ancient Specimens");
        this.add("advancements.regions_unexplored.ancient_specimens.description", "Collect every Bioshroom Stem type.");

        // Block translations
        BuiltInRegistries.BLOCK.stream().forEach(blockRegistryObject -> {
            if(blockRegistryObject.toString().contains("regions_unexplored")&&
                    !blockRegistryObject.toString().contains("potted_")&&
                    !blockRegistryObject.toString().contains("hanging_earlight")&&
                    !blockRegistryObject.toString().contains("duskmelon")&&
                    !blockRegistryObject.toString().contains("salmonberry")&&
                    !blockRegistryObject.toString().contains("_wall_sign")&&
                    !blockRegistryObject.toString().contains("_wall_hanging_sign")){
                this.add(blockRegistryObject, capitalizeString(filterBlockLang(blockRegistryObject)));
            }
        });
        //Misc block translations
        this.add(RUBlocks.DUSKMELON.get(), "Duskmelon Slice");
        this.add(RUBlocks.SALMONBERRY_BUSH.get(), "Salmonberry");
        this.add(RUBlocks.HANGING_EARLIGHT.get(), "Hanging Earlight Fruit");

        //Entity translations
        this.add(RUEntityTypes.BOAT.get(), "Boat");
        this.add(RUEntityTypes.CHEST_BOAT.get(), "Boat With Chest");

        this.add("death.attack.dorcel", "%s was dragged underground by Dorcel");
        this.add("death.attack.dorcel.player", "%s was dragged underground by Dorcel");

        this.add("death.attack.dusk_trap", "%s was eaten by a Dusktrap");
        this.add("death.attack.dusk_trap.player", "%s was eaten by a Dusktrap");

        // Item translations
        BuiltInRegistries.ITEM.stream().forEach(itemRegistryObject -> {
            if(itemRegistryObject.toString().contains("regions_unexplored")){
                if(itemRegistryObject.toString().contains("boat")){
                    if(itemRegistryObject.toString().contains("chest_boat")){
                        this.add(itemRegistryObject, filterChestBoatLang(itemRegistryObject));
                    }
                    else{
                        this.add(itemRegistryObject, capitalizeString(filterItemLang(itemRegistryObject)));
                    }
                }
            }
        });

        // Biome Translations
        this.add(RUBiomes.ALPHA_GROVE, capitalizeString(filterBiomeLang(RUBiomes.ALPHA_GROVE)));
        this.add(RUBiomes.ANCIENT_DELTA, capitalizeString(filterBiomeLang(RUBiomes.ANCIENT_DELTA)));
        this.add(RUBiomes.ARID_MOUNTAINS, capitalizeString(filterBiomeLang(RUBiomes.ARID_MOUNTAINS)));
        this.add(RUBiomes.ASHEN_WOODLAND, capitalizeString(filterBiomeLang(RUBiomes.ASHEN_WOODLAND)));
        this.add(RUBiomes.AUTUMNAL_MAPLE_FOREST, capitalizeString(filterBiomeLang(RUBiomes.AUTUMNAL_MAPLE_FOREST)));
        this.add(RUBiomes.BAOBAB_SAVANNA, capitalizeString(filterBiomeLang(RUBiomes.BAOBAB_SAVANNA)));
        this.add(RUBiomes.BAMBOO_FOREST, capitalizeString(filterBiomeLang(RUBiomes.BAMBOO_FOREST)));
        this.add(RUBiomes.BARLEY_FIELDS, capitalizeString(filterBiomeLang(RUBiomes.BARLEY_FIELDS)));
        this.add(RUBiomes.BAYOU, capitalizeString(filterBiomeLang(RUBiomes.BAYOU)));
        this.add(RUBiomes.BIOSHROOM_CAVES, capitalizeString(filterBiomeLang(RUBiomes.BIOSHROOM_CAVES)));
        this.add(RUBiomes.BLACKSTONE_BASIN, capitalizeString(filterBiomeLang(RUBiomes.BLACKSTONE_BASIN)));
        this.add(RUBiomes.BLACKWOOD_TAIGA, capitalizeString(filterBiomeLang(RUBiomes.BLACKWOOD_TAIGA)));
        this.add(RUBiomes.BOREAL_TAIGA, capitalizeString(filterBiomeLang(RUBiomes.BOREAL_TAIGA)));
        this.add(RUBiomes.CHALK_CLIFFS, capitalizeString(filterBiomeLang(RUBiomes.CHALK_CLIFFS)));
        this.add(RUBiomes.COLD_BOREAL_TAIGA, capitalizeString(filterBiomeLang(RUBiomes.COLD_BOREAL_TAIGA)));
        this.add(RUBiomes.COLD_DECIDUOUS_FOREST, capitalizeString(filterBiomeLang(RUBiomes.COLD_DECIDUOUS_FOREST)));
        this.add(RUBiomes.COLD_RIVER, capitalizeString(filterBiomeLang(RUBiomes.COLD_RIVER)));
        this.add(RUBiomes.DECIDUOUS_FOREST, capitalizeString(filterBiomeLang(RUBiomes.DECIDUOUS_FOREST)));
        this.add(RUBiomes.DRY_BUSHLAND, capitalizeString(filterBiomeLang(RUBiomes.DRY_BUSHLAND)));
        this.add(RUBiomes.EUCALYPTUS_FOREST, capitalizeString(filterBiomeLang(RUBiomes.EUCALYPTUS_FOREST)));
        this.add(RUBiomes.FEN, capitalizeString(filterBiomeLang(RUBiomes.FEN)));
        this.add(RUBiomes.FLOWER_FIELDS, capitalizeString(filterBiomeLang(RUBiomes.FLOWER_FIELDS)));
        this.add(RUBiomes.FROZEN_PINE_TAIGA, capitalizeString(filterBiomeLang(RUBiomes.FROZEN_PINE_TAIGA)));
        this.add(RUBiomes.FROZEN_TUNDRA, capitalizeString(filterBiomeLang(RUBiomes.FROZEN_TUNDRA)));
        this.add(RUBiomes.FUNGAL_FEN, capitalizeString(filterBiomeLang(RUBiomes.FUNGAL_FEN)));
        this.add(RUBiomes.GLISTERING_MEADOW, capitalizeString(filterBiomeLang(RUBiomes.GLISTERING_MEADOW)));
        this.add(RUBiomes.GOLDEN_BOREAL_TAIGA, capitalizeString(filterBiomeLang(RUBiomes.GOLDEN_BOREAL_TAIGA)));
        this.add(RUBiomes.GRASSLAND, capitalizeString(filterBiomeLang(RUBiomes.GRASSLAND)));
        this.add(RUBiomes.GRASSY_BEACH, capitalizeString(filterBiomeLang(RUBiomes.GRASSY_BEACH)));
        this.add(RUBiomes.GRAVEL_BEACH, capitalizeString(filterBiomeLang(RUBiomes.GRAVEL_BEACH)));
        this.add(RUBiomes.HIGHLAND_FIELDS, capitalizeString(filterBiomeLang(RUBiomes.HIGHLAND_FIELDS)));
        this.add(RUBiomes.HYACINTH_DEEPS, capitalizeString(filterBiomeLang(RUBiomes.HYACINTH_DEEPS)));
        this.add(RUBiomes.ICY_HEIGHTS, capitalizeString(filterBiomeLang(RUBiomes.ICY_HEIGHTS)));
        this.add(RUBiomes.INFERNAL_HOLT, capitalizeString(filterBiomeLang(RUBiomes.INFERNAL_HOLT)));
        this.add(RUBiomes.JOSHUA_DESERT, capitalizeString(filterBiomeLang(RUBiomes.JOSHUA_DESERT)));
        this.add(RUBiomes.MAGNOLIA_WOODLAND, capitalizeString(filterBiomeLang(RUBiomes.MAGNOLIA_WOODLAND)));
        this.add(RUBiomes.MARSH, capitalizeString(filterBiomeLang(RUBiomes.MARSH)));
        this.add(RUBiomes.MAPLE_FOREST, capitalizeString(filterBiomeLang(RUBiomes.MAPLE_FOREST)));
        this.add(RUBiomes.MOUNTAINS, capitalizeString(filterBiomeLang(RUBiomes.MOUNTAINS)));
        this.add(RUBiomes.MAUVE_HILLS, capitalizeString(filterBiomeLang(RUBiomes.MAUVE_HILLS)));
        this.add(RUBiomes.MUDDY_RIVER, capitalizeString(filterBiomeLang(RUBiomes.MUDDY_RIVER)));
        this.add(RUBiomes.MYCOTOXIC_UNDERGROWTH, capitalizeString(filterBiomeLang(RUBiomes.MYCOTOXIC_UNDERGROWTH)));
        this.add(RUBiomes.ORCHARD, capitalizeString(filterBiomeLang(RUBiomes.ORCHARD)));
        this.add(RUBiomes.OUTBACK, capitalizeString(filterBiomeLang(RUBiomes.OUTBACK)));
        this.add(RUBiomes.OLD_GROWTH_BAYOU, capitalizeString(filterBiomeLang(RUBiomes.OLD_GROWTH_BAYOU)));
        this.add(RUBiomes.PINE_SLOPES, capitalizeString(filterBiomeLang(RUBiomes.PINE_SLOPES)));
        this.add(RUBiomes.PINE_TAIGA, capitalizeString(filterBiomeLang(RUBiomes.PINE_TAIGA)));
        this.add(RUBiomes.PRAIRIE, capitalizeString(filterBiomeLang(RUBiomes.PRAIRIE)));
        this.add(RUBiomes.PRISMACHASM, capitalizeString(filterBiomeLang(RUBiomes.PRISMACHASM)));
        this.add(RUBiomes.POPPY_FIELDS, capitalizeString(filterBiomeLang(RUBiomes.POPPY_FIELDS)));
        this.add(RUBiomes.PUMPKIN_FIELDS, capitalizeString(filterBiomeLang(RUBiomes.PUMPKIN_FIELDS)));
        this.add(RUBiomes.RAINFOREST, capitalizeString(filterBiomeLang(RUBiomes.RAINFOREST)));
        this.add(RUBiomes.REDWOODS, capitalizeString(filterBiomeLang(RUBiomes.REDWOODS)));
        this.add(RUBiomes.REDSTONE_ABYSS, capitalizeString(filterBiomeLang(RUBiomes.REDSTONE_ABYSS)));
        this.add(RUBiomes.REDSTONE_CAVES, capitalizeString(filterBiomeLang(RUBiomes.REDSTONE_CAVES)));
        this.add(RUBiomes.ROCKY_MEADOW, capitalizeString(filterBiomeLang(RUBiomes.ROCKY_MEADOW)));
        this.add(RUBiomes.ROCKY_REEF, capitalizeString(filterBiomeLang(RUBiomes.ROCKY_REEF)));
        this.add(RUBiomes.SAGUARO_DESERT, capitalizeString(filterBiomeLang(RUBiomes.SAGUARO_DESERT)));
        this.add(RUBiomes.SHRUBLAND, capitalizeString(filterBiomeLang(RUBiomes.SHRUBLAND)));
        this.add(RUBiomes.SCORCHING_CAVES, capitalizeString(filterBiomeLang(RUBiomes.SCORCHING_CAVES)));
        this.add(RUBiomes.SPIRES, capitalizeString(filterBiomeLang(RUBiomes.SPIRES)));
        this.add(RUBiomes.STEPPE, capitalizeString(filterBiomeLang(RUBiomes.STEPPE)));
        this.add(RUBiomes.SILVER_BIRCH_FOREST, capitalizeString(filterBiomeLang(RUBiomes.SILVER_BIRCH_FOREST)));
        this.add(RUBiomes.SPARSE_RAINFOREST, capitalizeString(filterBiomeLang(RUBiomes.SPARSE_RAINFOREST)));
        this.add(RUBiomes.SPARSE_REDWOODS, capitalizeString(filterBiomeLang(RUBiomes.SPARSE_REDWOODS)));
        this.add(RUBiomes.TEMPERATE_GROVE, capitalizeString(filterBiomeLang(RUBiomes.TEMPERATE_GROVE)));
        this.add(RUBiomes.TROPICS, capitalizeString(filterBiomeLang(RUBiomes.TROPICS)));
        this.add(RUBiomes.TROPICAL_RIVER, capitalizeString(filterBiomeLang(RUBiomes.TROPICAL_RIVER)));
        this.add(RUBiomes.TOWERING_CLIFFS, capitalizeString(filterBiomeLang(RUBiomes.TOWERING_CLIFFS)));
        this.add(RUBiomes.WILLOW_FOREST, capitalizeString(filterBiomeLang(RUBiomes.WILLOW_FOREST)));
        this.add(RUBiomes.CLOVER_PLAINS, capitalizeString(filterBiomeLang(RUBiomes.CLOVER_PLAINS)));
    }

    /**
     * A method to capitalize a string and remove anything what's between it.
     * <a href="https://stackoverflow.com/questions/1892765/how-to-capitalize-the-first-character-of-each-word-in-a-string">Source</a>
     * @param string the string you want to capitalize.
     * @return a capitalised string.
     */
    private static @NotNull String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '_') {
                /*small change to fix chest boat lang
                if(string.contains("with")&&chars[i+1]!='w'){
                }*/
                found = false;
            }
        }
        return String.valueOf(chars);
    }

    /**
     * Filters the block to get the name of the block.
     * @param key The block.
     * @return The name of the block
     */
    private static @NotNull String filterBlockLang(@NotNull Block key) {
        return key.getDescriptionId()
                .replace("block.regions_unexplored.", "")
                .replace("_plant", "")
                .replace("_", " ");
    }

    private static @NotNull String filterItemLang(@NotNull ItemLike key) {
        return key.asItem().getDescriptionId()
                .replace("item.regions_unexplored.", "")
                .replace("_", " ");
    }

    private static @NotNull String filterChestBoatLang(@NotNull ItemLike key) {
        String type = key.asItem().getDescriptionId()
                .replace("item.regions_unexplored.", "")
                .replace("chest_boat", "")
                .replace("_", "");

        String name = capitalizeString(type)+" Boat with Chest";

        return name;
    }


    private static String filterBiomeLang(ResourceKey<Biome> key) {
        return key.identifier().toLanguageKey()
                .replace("regions_unexplored.", "")
                .replace("_", " ");
    }

    // used to create a biome translation string
    private void add(ResourceKey<Biome> key, String translation) {
        this.add("biome." + key.identifier().toLanguageKey(), translation);
    }
}
