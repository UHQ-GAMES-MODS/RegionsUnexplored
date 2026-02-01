package net.regions_unexplored.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public interface BlockFactory extends Function<BlockBehaviour.Properties, Block> {
}
