package net.regions_unexplored.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.registry.data.RUNoises;
import net.regions_unexplored.datagen.provider.*;
import net.regions_unexplored.datagen.provider.tag.RuBiomeTagProvider;
import net.regions_unexplored.datagen.provider.tag.RuBlockTagProvider;
import net.regions_unexplored.datagen.provider.tag.RuItemTagProvider;
import net.regions_unexplored.datagen.provider.tag.RuProcessorListTagProvider;
import net.regions_unexplored.datagen.provider.worldgen.RuProcessorLists;
import net.regions_unexplored.data.worldgen.biome.BiomeRegistry;
import net.regions_unexplored.registry.data.RUDamageTypes;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = RegionsUnexplored.MOD_ID)
public class DataGeneration {

    private static final RegistrySetBuilder BOOTSTRAPS = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatureRegistry::bootstrap)
        .add(Registries.PLACED_FEATURE, PlacedFeatureRegistry::bootstrap)
        .add(Registries.BIOME, BiomeRegistry::bootstrap)
        .add(Registries.NOISE, RUNoises::bootstrap)
        .add(Registries.DAMAGE_TYPE, RUDamageTypes::bootstrap)
        .add(Registries.PROCESSOR_LIST, RuProcessorLists::bootstrap)
    ;

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> holder = event.getLookupProvider();

        var datapackRegistries = new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), BOOTSTRAPS, Set.of(RegionsUnexplored.MOD_ID));

        var dataProvider = generator.addProvider(event.includeServer(), datapackRegistries);

        generator.addProvider(true, new RuAdvancementProvider(packOutput, datapackRegistries.getRegistryProvider(), existingFileHelper));

        generator.addProvider(event.includeServer(), new RuBlockModelProvider(packOutput, RegionsUnexplored.MOD_ID, existingFileHelper));

        generator.addProvider(true, new RuRecipeProvider(packOutput, holder));
        generator.addProvider(true, RuLootTableProvider.create(packOutput, holder));
        generator.addProvider(true, new RuLanguageProvider(packOutput));

        //tags
        TagsProvider<Block> blockTagsProvider = generator.addProvider(event.includeServer(), new RuBlockTagProvider(packOutput, datapackRegistries.getRegistryProvider(), RegionsUnexplored.MOD_ID, existingFileHelper));
        TagsProvider<Item> itemTagsProvider = generator.addProvider(event.includeServer(), new RuItemTagProvider(packOutput, datapackRegistries.getRegistryProvider(), blockTagsProvider.contentsGetter(),  RegionsUnexplored.MOD_ID, existingFileHelper));
        TagsProvider<Biome> biomeTagsProvider = generator.addProvider(event.includeServer(), new RuBiomeTagProvider(packOutput, datapackRegistries.getRegistryProvider(), RegionsUnexplored.MOD_ID, existingFileHelper));
        TagsProvider<StructureProcessorList> processorListTagsProvider = generator.addProvider(event.includeServer(), new RuProcessorListTagProvider(packOutput, datapackRegistries.getRegistryProvider(), existingFileHelper));

        generator.addProvider(event.includeServer(), new RuDataMapGenerator(packOutput, holder));
    }
}