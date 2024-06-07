package net.regions_unexplored.world.level.block.plant.food;

import com.mojang.serialization.MapCodec;
import io.github.uhq_games.regions_unexplored.item.RuItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DuskmelonBlock extends BushBlock implements BonemealableBlock {
   public static final MapCodec<? extends DuskmelonBlock> CODEC = simpleCodec(DuskmelonBlock::new);
   private static final float HURT_SPEED_THRESHOLD = 0.003F;
   public static final int MAX_AGE = 2;
   public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
   private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
   private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

   public DuskmelonBlock(Properties properties) {
      super(properties);
      this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
   }

   @Override
   protected MapCodec<? extends BushBlock> codec() {
      return CODEC;
   }

   @Override
   public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
      return new ItemStack(RuItems.DUSKMELON_SLICE);
   }

   public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
      if (blockState.getValue(AGE) == 0) {
         return SAPLING_SHAPE;
      } else {
         return blockState.getValue(AGE) < 2 ? MID_GROWTH_SHAPE : super.getShape(blockState, blockGetter, blockPos, collisionContext);
      }
   }

   public boolean isRandomlyTicking(BlockState blockState) {
      return blockState.getValue(AGE) < 2;
   }

   public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
      int i = blockState.getValue(AGE);
      if (i < 2 && serverLevel.getRawBrightness(blockPos.above(), 0) >= 9) {
         BlockState blockstate = blockState.setValue(AGE, i + 1);
         serverLevel.setBlock(blockPos, blockstate, 2);
         serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(blockstate));
      }
   }

   public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
      int i = blockState.getValue(AGE);
      boolean flag = i == 2;
      if (!flag && player.getItemInHand(interactionHand).is(Items.BONE_MEAL)) {
         return InteractionResult.PASS;
      } else if (i > 1) {
         popResource(level, blockPos, new ItemStack(RuItems.DUSKMELON_SLICE, 1));
         level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
         BlockState blockstate = blockState.setValue(AGE, 0);
         level.setBlock(blockPos, blockstate, 2);
         level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockstate));
         return InteractionResult.sidedSuccess(level.isClientSide);
      } else {
         return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
      }
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
      stateBuilder.add(AGE);
   }

   public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
      return blockState.getValue(AGE) < 2;
   }

   public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      return true;
   }

   public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      int i = Math.min(3, blockState.getValue(AGE) + 1);
      serverLevel.setBlock(blockPos, blockState.setValue(AGE, i), 2);
   }
}
