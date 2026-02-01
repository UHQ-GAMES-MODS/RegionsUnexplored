package net.regions_unexplored.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.registry.RUBlocks;

public class RuBlockEntitiesFabric {
    public static void addBlockEntities() {
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            if (set.getSign() != null) {
                cast(BlockEntityType.SIGN).addSupportedBlock(set.getSign());
            }
            if (set.getWallSign() != null) {
                cast(BlockEntityType.SIGN).addSupportedBlock(set.getWallSign());
            }

            if (set.getHangingSign() != null) {
                cast(BlockEntityType.HANGING_SIGN).addSupportedBlock(set.getHangingSign());
            }
            if (set.getWallHangingSign() != null) {
                cast(BlockEntityType.HANGING_SIGN).addSupportedBlock(set.getWallHangingSign());
            }
        }
    }

    private static FabricBlockEntityType cast(BlockEntityType<?> type) {
        return (FabricBlockEntityType) type;
    }
}
