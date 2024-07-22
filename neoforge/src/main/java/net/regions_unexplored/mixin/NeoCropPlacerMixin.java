package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.data.tags.RuTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class NeoCropPlacerMixin {
    @Inject(at = @At("HEAD"), method = "getGrowthSpeed", cancellable = true)
    private static void regions_unexplored$getGrowthSpeed(BlockState blockState, BlockGetter p_52274_, BlockPos p_52275_, CallbackInfoReturnable<Float> cir) {
        Block block = blockState.getBlock();
        if(p_52274_.getBlockState(p_52275_.below()).is(RuTags.CROP_PLANTABLE_BLOCKS)){
            float f1 = 1.0F;
            BlockPos blockPos1 = p_52275_.below();

            for(int i1 = -1; i1 <= 1; ++i1) {
                for(int j1 = -1; j1 <= 1; ++j1) {
                    float g1 = 0.0F;
                    BlockState blockState1 = p_52274_.getBlockState(blockPos1.offset(i1, 0, j1));
                    if (blockState1.is(RuTags.CROP_PLANTABLE_BLOCKS)) {
                        g1 = 1.0F;
                        if (blockState1.getValue(FarmBlock.MOISTURE) > 0) {
                            g1 = 3.0F;
                        }
                    }

                    if (i1 != 0 || j1 != 0) {
                        g1 /= 4.0F;
                    }

                    f1 += g1;
                }
            }

            BlockPos blockPos21 = p_52275_.north();
            BlockPos blockPos31 = p_52275_.south();
            BlockPos blockPos41 = p_52275_.west();
            BlockPos blockPos51 = p_52275_.east();
            boolean bl1 = p_52274_.getBlockState(blockPos41).is(block) || p_52274_.getBlockState(blockPos51).is(block);
            boolean bl21 = p_52274_.getBlockState(blockPos21).is(block) || p_52274_.getBlockState(blockPos31).is(block);
            if (bl1 && bl21) {
                f1 /= 2.0F;
            } else {
                boolean bl31 = p_52274_.getBlockState(blockPos41.north()).is(block) || p_52274_.getBlockState(blockPos51.north()).is(block) || p_52274_.getBlockState(blockPos51.south()).is(block) || p_52274_.getBlockState(blockPos41.south()).is(block);
                if (bl31) {
                    f1 /= 2.0F;
                }
            }


            cir.setReturnValue(f1);
        }
    }
}
