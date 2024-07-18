package net.regions_unexplored.platform.services;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public interface IBlockHelper {
    BlockSetType setBlockSetType(String path);
    WoodType setWoodType(String path, BlockSetType blockSetType);
}
