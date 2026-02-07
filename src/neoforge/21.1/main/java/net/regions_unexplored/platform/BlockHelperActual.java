package net.regions_unexplored.platform;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.msrandom.multiplatform.annotations.Actual;
import net.regions_unexplored.RegionsUnexplored;

public class BlockHelperActual {
    @Actual
    public static WoodType setWoodType(String path, BlockSetType blockSetType) {
        return WoodType.register(new WoodType(RegionsUnexplored.id(path).toString(), blockSetType));
    }
}
