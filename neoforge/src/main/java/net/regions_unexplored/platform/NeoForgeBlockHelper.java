package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.services.IBlockHelper;

@AutoService(IBlockHelper.class)
public class NeoForgeBlockHelper implements IBlockHelper {
    @Override
    public BlockSetType setBlockSetType(String path) {
        return BlockSetType.register(new BlockSetType(Constants.MOD_ID + ":" + path));
    }

    @Override
    public WoodType setWoodType(String path, BlockSetType blockSetType) {
        return WoodType.register(new WoodType(Constants.MOD_ID + ":" + path, blockSetType));
    }
}
