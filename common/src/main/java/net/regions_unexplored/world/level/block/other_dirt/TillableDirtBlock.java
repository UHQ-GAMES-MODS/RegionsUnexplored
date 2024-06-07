package net.regions_unexplored.world.level.block.other_dirt;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

import java.util.Objects;

public class TillableDirtBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public TillableDirtBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (Objects.requireNonNull(stack.get(DataComponents.POTION_CONTENTS)).is(Potions.WATER)) {
            for(int i = 0; i < 5; ++i) {
                level.addParticle(ParticleTypes.SPLASH, (double) pos.getX() + level.random.nextDouble(), pos.getY() + 1, (double) pos.getZ() + level.random.nextDouble(), level.random.nextFloat() / 2.0F, 5.0E-5D, level.random.nextFloat() / 2.0F);
            }
            level.playSound((Player) null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(level.getBlockState(pos)== RuBlocks.PEAT_DIRT.defaultBlockState()||level.getBlockState(pos)== RuBlocks.PEAT_COARSE_DIRT.defaultBlockState()){
                level.setBlock(pos, RuBlocks.PEAT_MUD.defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, RuBlocks.PEAT_MUD.defaultBlockState()));
            }
            else if(level.getBlockState(pos)== RuBlocks.SILT_DIRT.defaultBlockState()||level.getBlockState(pos)== RuBlocks.SILT_COARSE_DIRT.defaultBlockState()){
                level.setBlock(pos, RuBlocks.SILT_MUD.defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, RuBlocks.SILT_MUD.defaultBlockState()));
            }
            else{
                level.setBlock(pos, Blocks.MUD.defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, Blocks.MUD.defaultBlockState()));
            }
            if (player instanceof ServerPlayer serverPlayer) {
                if(serverPlayer.gameMode.getGameModeForPlayer() != GameType.CREATIVE){
                    player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE, 1));
                }
            }
            else if (player.level().isClientSide()) {
                if(Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId()).getGameMode() != GameType.CREATIVE){
                    player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE, 1));
                }
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, result);
        }
    }
}