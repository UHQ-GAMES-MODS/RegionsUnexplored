package net.regions_unexplored.world.level.block.forest_dirt;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.phys.BlockHitResult;
import net.regions_unexplored.block.RuBlocks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class PeatGrassBlock extends SpreadingForestDirtBlock implements BonemealableBlock {
   public PeatGrassBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state) {
      return levelReader.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      BlockPos blockPos = pos.above();
      BlockState blockState = Blocks.SHORT_GRASS.defaultBlockState();
      Optional<Holder.Reference<PlacedFeature>> optional = level.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(VegetationPlacements.GRASS_BONEMEAL);

      label46:
      for (int i = 0; i < 128; ++i) {
         BlockPos blockPos1 = blockPos;

         for (int j = 0; j < i / 16; ++j) {
            blockPos1 = blockPos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
            if (!level.getBlockState(blockPos1.below()).is(this) || level.getBlockState(blockPos1).isCollisionShapeFullBlock(level, blockPos1)) {
               continue label46;
            }
         }

         BlockState blockState1 = level.getBlockState(blockPos1);
         if (blockState1.is(blockState.getBlock()) && random.nextInt(10) == 0) {
            ((BonemealableBlock) blockState.getBlock()).performBonemeal(level, random, blockPos1, blockState1);
         }

         if (blockState1.isAir()) {
            Holder<PlacedFeature> holder;
            if (random.nextInt(8) == 0) {
               List<ConfiguredFeature<?, ?>> list = level.getBiome(blockPos1).value().getGenerationSettings().getFlowerFeatures();
               if (list.isEmpty()) {
                  continue;
               }

               holder = ((RandomPatchConfiguration) list.get(0).config()).feature();
            } else {
               if (!optional.isPresent()) {
                  continue;
               }

               holder = optional.get();
            }

            holder.value().place(level, level.getChunkSource().getGenerator(), random, blockPos1);
         }
      }

   }

   @Override
   protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
      if (playerHasShieldUseIntent(player, interactionHand)) {
         return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
      }
      else if (stack.getItem() instanceof ShovelItem) {
         BlockState newBlockState = evaluateFlattenedState(level, pos, player, state);
         if (player instanceof ServerPlayer) {
            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, stack);
         }

         level.setBlock(pos, newBlockState, 11);
         level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newBlockState));
         stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(interactionHand));
         return ItemInteractionResult.sidedSuccess(level.isClientSide);
      }
      else if ((stack.getItem() instanceof HoeItem)&&level.getBlockState(pos.above()).isAir()) {
         BlockState newBlockState = evaluateTilledState(level, pos, player, state);
         if (player instanceof ServerPlayer) {
            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, stack);
         }
         level.setBlock(pos, newBlockState, 11);
         level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newBlockState));
         stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(interactionHand));
         return ItemInteractionResult.sidedSuccess(level.isClientSide);
      }
      else{
         return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
      }
   }

   private BlockState evaluateFlattenedState(Level level, BlockPos pos, @Nullable Player player, BlockState state) {
      BlockState flattenedState = RuBlocks.PEAT_DIRT_PATH.get().defaultBlockState();
      level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
      return flattenedState;
   }

   private BlockState evaluateTilledState(Level level, BlockPos pos, @Nullable Player player, BlockState state) {
      BlockState tilledState = RuBlocks.PEAT_FARMLAND.get().defaultBlockState();
      level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
      return tilledState;
   }

   private static boolean playerHasShieldUseIntent(Player player, InteractionHand interactionHand) {
      return interactionHand.equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
   }
}
