package net.regions_unexplored.platform;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.msrandom.multiplatform.annotations.Expect;

public class BlockHelper {
    @Expect
    public static BlockSetType setBlockSetType(String path);
    @Expect
    public static WoodType setWoodType(String path, BlockSetType blockSetType);
}
