package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.WoodSet;

import static net.regions_unexplored.util.BlockCompatUtil.*;

public class BlockToolCompat {
    public static void setup() {
        // TODO: For 26.1 port, replace with `strippables` data map on Neo
        for (WoodSet set : RUBlocks.WOOD_SETS) {
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
        registerStrippableBlock(RUBlocks.ASHEN_WOOD_SET.getLog(), RUBlocks.DEAD_WOOD_SET.getStrippedLog());
        registerStrippableBlock(RUBlocks.ASHEN_WOOD_SET.getWood(), RUBlocks.DEAD_WOOD_SET.getStrippedWood());
        registerStrippableBlock(RUBlocks.SILVER_BIRCH_WOOD_SET.getLog(), Blocks.STRIPPED_BIRCH_LOG);
        registerStrippableBlock(RUBlocks.SILVER_BIRCH_WOOD_SET.getWood(), Blocks.STRIPPED_BIRCH_WOOD);
        registerStrippableBlock(RUBlocks.BRIMWOOD_WOOD_SET.getLogMagma(), RUBlocks.BRIMWOOD_WOOD_SET.getStrippedLog());

        //ShovelBlocks
        registerShovelled(RUBlocks.PEAT_PODZOL.get(), RUBlocks.PEAT_DIRT_PATH.get().defaultBlockState());
        registerShovelled(RUBlocks.PEAT_DIRT.get(), RUBlocks.PEAT_DIRT_PATH.get().defaultBlockState());
        registerShovelled(RUBlocks.SILT_PODZOL.get(), RUBlocks.SILT_DIRT_PATH.get().defaultBlockState());
        registerShovelled(RUBlocks.SILT_DIRT.get(), RUBlocks.SILT_DIRT_PATH.get().defaultBlockState());

        registerShovelled(RUBlocks.CHALK_GRASS_BLOCK.get(), RUBlocks.CHALK.get().defaultBlockState());
        registerShovelled(RUBlocks.CHALK_GRASS_BLOCK.get(), RUBlocks.CHALK.get().defaultBlockState());

        registerShovelled(RUBlocks.CHALK_GRASS_BLOCK.get(), RUBlocks.CHALK.get().defaultBlockState());
        registerShovelled(RUBlocks.ARGILLITE_GRASS_BLOCK.get(), RUBlocks.ARGILLITE.get().defaultBlockState());

        registerShovelled(RUBlocks.STONE_GRASS_BLOCK.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RUBlocks.VIRIDESCENT_NYLIUM.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RUBlocks.PRISMOSS.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RUBlocks.MOSSY_STONE.get(), Blocks.STONE.defaultBlockState());

        registerShovelled(RUBlocks.DEEPSLATE_GRASS_BLOCK.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RUBlocks.DEEPSLATE_PRISMOSS.get(), Blocks.DEEPSLATE.defaultBlockState());
    }
}
