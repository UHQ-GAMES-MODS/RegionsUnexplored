package net.regions_unexplored.datagen.provider.tag;

import dev.worldgen.lithostitched.Lithostitched;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.datagen.provider.worldgen.RuProcessorLists;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuProcessorListTagProvider extends TagsProvider<StructureProcessorList> {
    public static final TagKey<StructureProcessorList> SHIPWRECK_PALETTES = TagKey.create(Registries.PROCESSOR_LIST, Lithostitched.id("shipwreck_palettes"));

    public RuProcessorListTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, Registries.PROCESSOR_LIST, lookupProvider, RegionsUnexplored.MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings(value = "all")
    public void addTags(HolderLookup.Provider provider) {
        this.tag(SHIPWRECK_PALETTES)
            .add(RuProcessorLists.SHIPWRECK_DARK_OAK_AND_BAOBAB)
            .add(RuProcessorLists.SHIPWRECK_DARK_OAK_AND_DEAD)
            .add(RuProcessorLists.SHIPWRECK_DARK_OAK_AND_EUCALYPTUS)
            .add(RuProcessorLists.SHIPWRECK_DARK_OAK_AND_JOSHUA)
            .add(RuProcessorLists.SHIPWRECK_DARK_OAK_AND_KAPOK)
            .add(RuProcessorLists.SHIPWRECK_DARK_OAK_AND_LARCH)
            .add(RuProcessorLists.SHIPWRECK_DEAD_AND_DARK_OAK)
            .add(RuProcessorLists.SHIPWRECK_DEAD_AND_LARCH)
            .add(RuProcessorLists.SHIPWRECK_DEAD_AND_SPRUCE);
    }
}
