package net.regions_unexplored.world.level.block.cave;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.registry.RUBlocks;

public class PrismossBlock extends Block implements BonemealableBlock {
   public PrismossBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
      return level.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      //NORTH
      if(level.getBlockState(pos.north()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
         level.setBlock(pos.north(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.north()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //SOUTH
      if(level.getBlockState(pos.south()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.south()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //EAST
      if(level.getBlockState(pos.east()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.east(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.east().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.east()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.east(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.east().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //WEST
      if(level.getBlockState(pos.west()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.west(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.west().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.west()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.west(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.west().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //NORTH-EAST
      if(level.getBlockState(pos.north().east()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().east(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().east().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.north().east()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().east(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().east().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //NORTH-WEST
      if(level.getBlockState(pos.north().west()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().west(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().west().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.north().west()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().west(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().west().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //SOUTH-EAST
      if(level.getBlockState(pos.south().east()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().east(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().east().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.south().east()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().east(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().east().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //SOUTH-WEST
      if(level.getBlockState(pos.south().west()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().west(), RUBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().west().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.south().west()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().west(), RUBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().west().above(), RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }

   }

}
