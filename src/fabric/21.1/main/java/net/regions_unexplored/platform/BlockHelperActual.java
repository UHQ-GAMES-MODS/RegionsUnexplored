package net.regions_unexplored.platform;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.msrandom.multiplatform.annotations.Actual;
import net.regions_unexplored.RegionsUnexplored;

public class BlockHelperActual {
    @Actual
    public static WoodType setWoodType(String path, BlockSetType blockSetType) {
        return new WoodTypeBuilder().register(RegionsUnexplored.id(path), blockSetType);
    }
}
