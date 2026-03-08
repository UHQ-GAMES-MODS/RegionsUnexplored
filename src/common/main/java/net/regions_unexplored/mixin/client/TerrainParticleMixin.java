package net.regions_unexplored.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.particle.TerrainParticle;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.registry.RUBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TerrainParticle.class)
public class TerrainParticleMixin {
    @WrapOperation(
        method = "<init>(Lnet/minecraft/client/multiplayer/ClientLevel;DDDDDDLnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"
        )
    )
    private boolean fixRUGrassBlockParticles(BlockState state, Block block, Operation<Boolean> operation) {
        return operation.call(state, block) || state.is(RUBlocks.SILT_GRASS_BLOCK.get()) || state.is(RUBlocks.PEAT_GRASS_BLOCK.get());
    }
}
