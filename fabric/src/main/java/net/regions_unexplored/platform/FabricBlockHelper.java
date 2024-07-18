package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.services.IBlockHelper;

@AutoService(IBlockHelper.class)
public class FabricBlockHelper implements IBlockHelper {
    @Override
    public BlockSetType setBlockSetType(String path) {
        return new BlockSetTypeBuilder().register(Constants.id(path));
    }

    @Override
    public WoodType setWoodType(String path, BlockSetType blockSetType) {
        return new WoodTypeBuilder().register(Constants.id(path), blockSetType);
    }
}
