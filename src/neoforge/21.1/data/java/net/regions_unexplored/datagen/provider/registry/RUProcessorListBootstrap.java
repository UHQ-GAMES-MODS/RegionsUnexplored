package net.regions_unexplored.datagen.provider.registry;

import dev.worldgen.lithostitched.api.worldgen.processor.LithostitchedProcessors;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.WoodSet;

import java.util.List;
import java.util.Map;

import static net.regions_unexplored.registry.data.RUProcessorLists.*;

public class RUProcessorListBootstrap {
    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        context.register(SHIPWRECK_DARK_OAK_AND_BAOBAB, darkOakAndModded(RUBlocks.BAOBAB_WOOD_SET));
        context.register(SHIPWRECK_DARK_OAK_AND_DEAD, darkOakAndModded(RUBlocks.DEAD_WOOD_SET));
        context.register(SHIPWRECK_DARK_OAK_AND_EUCALYPTUS, darkOakAndModded(RUBlocks.EUCALYPTUS_WOOD_SET));
        context.register(SHIPWRECK_DARK_OAK_AND_JOSHUA, darkOakAndModded(RUBlocks.JOSHUA_WOOD_SET));
        context.register(SHIPWRECK_DARK_OAK_AND_KAPOK, darkOakAndModded(RUBlocks.KAPOK_WOOD_SET));
        context.register(SHIPWRECK_DARK_OAK_AND_LARCH, darkOakAndModded(RUBlocks.LARCH_WOOD_SET));
        context.register(SHIPWRECK_DEAD_AND_DARK_OAK, create(
            RUBlocks.DEAD_WOOD_SET.getLog(),
            RUBlocks.DEAD_WOOD_SET.getPlanks(),
            RUBlocks.DEAD_WOOD_SET.getStairs(),
            RUBlocks.DEAD_WOOD_SET.getSlab(),
            RUBlocks.DEAD_WOOD_SET.getFence(),
            RUBlocks.DEAD_WOOD_SET.getDoor(),
            RUBlocks.DEAD_WOOD_SET.getTrapdoor(),
            Blocks.DARK_OAK_PLANKS,
            Blocks.DARK_OAK_STAIRS,
            Blocks.DARK_OAK_SLAB,
            Blocks.DARK_OAK_FENCE
        ));
        context.register(SHIPWRECK_DEAD_AND_LARCH, moddedAndModded(RUBlocks.DEAD_WOOD_SET, RUBlocks.LARCH_WOOD_SET));
        context.register(SHIPWRECK_DEAD_AND_SPRUCE, create(
            RUBlocks.DEAD_WOOD_SET.getLog(),
            RUBlocks.DEAD_WOOD_SET.getPlanks(),
            RUBlocks.DEAD_WOOD_SET.getStairs(),
            RUBlocks.DEAD_WOOD_SET.getSlab(),
            RUBlocks.DEAD_WOOD_SET.getFence(),
            RUBlocks.DEAD_WOOD_SET.getDoor(),
            RUBlocks.DEAD_WOOD_SET.getTrapdoor(),
            Blocks.SPRUCE_PLANKS,
            Blocks.SPRUCE_STAIRS,
            Blocks.SPRUCE_SLAB,
            Blocks.SPRUCE_FENCE
        ));
    }

    private static StructureProcessorList darkOakAndModded(WoodSet secondary) {
        return create(
            Blocks.DARK_OAK_LOG,
            Blocks.DARK_OAK_PLANKS,
            Blocks.DARK_OAK_STAIRS,
            Blocks.DARK_OAK_SLAB,
            Blocks.DARK_OAK_FENCE,
            Blocks.DARK_OAK_DOOR,
            Blocks.DARK_OAK_TRAPDOOR,
            secondary.getPlanks(),
            secondary.getStairs(),
            secondary.getSlab(),
            secondary.getFence()
        );
    }

    private static StructureProcessorList moddedAndModded(WoodSet primary, WoodSet secondary) {
        return create(
            primary.getLog(),
            primary.getPlanks(),
            primary.getStairs(),
            primary.getSlab(),
            primary.getFence(),
            primary.getDoor(),
            primary.getTrapdoor(),
            secondary.getPlanks(),
            secondary.getStairs(),
            secondary.getSlab(),
            secondary.getFence()
        );
    }
    
    private static StructureProcessorList create(Block primaryLog, Block primaryPlanks, Block primaryStairs, Block primarySlab, Block primaryFence, Block primaryDoor, Block primaryTrapdoor, Block secondaryPlanks, Block secondaryStairs, Block secondarySlab, Block secondaryFence) {
        return new StructureProcessorList(List.of(
            LithostitchedProcessors.blockSwap(Map.ofEntries(
                Map.entry(id(Blocks.OAK_LOG), id(primaryLog)),
                Map.entry(id(Blocks.OAK_PLANKS), id(primaryPlanks)),
                Map.entry(id(Blocks.OAK_STAIRS), id(primaryStairs)),
                Map.entry(id(Blocks.OAK_SLAB), id(primarySlab)),
                Map.entry(id(Blocks.OAK_FENCE), id(primaryFence)),
                Map.entry(id(Blocks.OAK_DOOR), id(primaryDoor)),
                Map.entry(id(Blocks.OAK_TRAPDOOR), id(primaryTrapdoor)),
                Map.entry(id(Blocks.SPRUCE_PLANKS), id(secondaryPlanks)),
                Map.entry(id(Blocks.SPRUCE_STAIRS), id(secondaryStairs)),
                Map.entry(id(Blocks.SPRUCE_SLAB), id(secondarySlab)),
                Map.entry(id(Blocks.SPRUCE_FENCE), id(secondaryFence))
            ))
        ));
    }
    
    private static ResourceKey<Block> id(Block block) {
        return block.builtInRegistryHolder().key();
    }
}
