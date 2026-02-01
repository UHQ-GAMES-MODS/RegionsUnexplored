package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.regions_unexplored.RegionsUnexplored;

public interface RUProcessorLists {
    ResourceKey<StructureProcessorList> SHIPWRECK_DARK_OAK_AND_BAOBAB = shipwreck("dark_oak", "baobab");
    ResourceKey<StructureProcessorList> SHIPWRECK_DARK_OAK_AND_DEAD = shipwreck("dark_oak", "dead");
    ResourceKey<StructureProcessorList> SHIPWRECK_DARK_OAK_AND_EUCALYPTUS = shipwreck("dark_oak", "eucalyptus");
    ResourceKey<StructureProcessorList> SHIPWRECK_DARK_OAK_AND_JOSHUA = shipwreck("dark_oak", "joshua");
    ResourceKey<StructureProcessorList> SHIPWRECK_DARK_OAK_AND_KAPOK = shipwreck("dark_oak", "kapok");
    ResourceKey<StructureProcessorList> SHIPWRECK_DARK_OAK_AND_LARCH = shipwreck("dark_oak", "larch");
    ResourceKey<StructureProcessorList> SHIPWRECK_DEAD_AND_DARK_OAK = shipwreck("dead", "dark_oak");
    ResourceKey<StructureProcessorList> SHIPWRECK_DEAD_AND_LARCH = shipwreck("dead", "larch");
    ResourceKey<StructureProcessorList> SHIPWRECK_DEAD_AND_SPRUCE = shipwreck("dead", "spruce");

    private static ResourceKey<StructureProcessorList> shipwreck(String primaryWood, String secondaryWood) {
        return RegionsUnexplored.key(Registries.PROCESSOR_LIST, String.format("shipwreck_palette/%s_and_%s", primaryWood, secondaryWood));
    }
}
