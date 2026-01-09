package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.WoodSet;

import static net.regions_unexplored.util.BlockCompatUtil.*;

public class BlockToolCompat {
    public static void setup() {
        // TODO: For 26.1 port, replace with `strippables` data map on Neo
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            Block log = set.getLog();
            Block strippedLog = set.getStrippedLog();
            if (log != null && strippedLog != null) {
                registerStrippableBlock(log, strippedLog);
            }

            Block wood = set.getWood();
            Block strippedWood = set.getStrippedWood();
            if (wood != null && strippedWood != null) {
                registerStrippableBlock(wood, strippedWood);
            }
        }
        // Special cases
        registerStrippableBlock(RuBlocks.ASHEN_WOOD_SET.getLog(), RuBlocks.DEAD_WOOD_SET.getStrippedLog());
        registerStrippableBlock(RuBlocks.ASHEN_WOOD_SET.getWood(), RuBlocks.DEAD_WOOD_SET.getStrippedWood());
        registerStrippableBlock(RuBlocks.SILVER_BIRCH_WOOD_SET.getLog(), Blocks.STRIPPED_BIRCH_LOG);
        registerStrippableBlock(RuBlocks.SILVER_BIRCH_WOOD_SET.getWood(), Blocks.STRIPPED_BIRCH_WOOD);
        registerStrippableBlock(RuBlocks.BRIMWOOD_WOOD_SET.getLogMagma(), RuBlocks.BRIMWOOD_WOOD_SET.getStrippedLog());

        //ShovelBlocks
        registerShovelled(RuBlocks.PEAT_PODZOL.get(), RuBlocks.PEAT_DIRT_PATH.get().defaultBlockState());
        registerShovelled(RuBlocks.PEAT_DIRT.get(), RuBlocks.PEAT_DIRT_PATH.get().defaultBlockState());
        registerShovelled(RuBlocks.SILT_PODZOL.get(), RuBlocks.SILT_DIRT_PATH.get().defaultBlockState());
        registerShovelled(RuBlocks.SILT_DIRT.get(), RuBlocks.SILT_DIRT_PATH.get().defaultBlockState());

        registerShovelled(RuBlocks.CHALK_GRASS_BLOCK.get(), RuBlocks.CHALK.get().defaultBlockState());
        registerShovelled(RuBlocks.CHALK_GRASS_BLOCK.get(), RuBlocks.CHALK.get().defaultBlockState());

        registerShovelled(RuBlocks.CHALK_GRASS_BLOCK.get(), RuBlocks.CHALK.get().defaultBlockState());
        registerShovelled(RuBlocks.ARGILLITE_GRASS_BLOCK.get(), RuBlocks.ARGILLITE.get().defaultBlockState());

        registerShovelled(RuBlocks.STONE_GRASS_BLOCK.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.VIRIDESCENT_NYLIUM.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.PRISMOSS.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.MOSSY_STONE.get(), Blocks.STONE.defaultBlockState());

        registerShovelled(RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RuBlocks.DEEPSLATE_PRISMOSS.get(), Blocks.DEEPSLATE.defaultBlockState());
    }
}
