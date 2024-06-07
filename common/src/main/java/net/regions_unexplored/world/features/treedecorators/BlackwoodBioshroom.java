package net.regions_unexplored.world.features.treedecorators;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

public class BlackwoodBioshroom extends TreeDecorator {
	public static final BlackwoodBioshroom INSTANCE = new BlackwoodBioshroom();
	public static final Codec<BlackwoodBioshroom> CODEC = Codec.unit(() -> INSTANCE);

	@Override
	protected TreeDecoratorType<?> type() {
		return RegionsUnexplored.BLACKWOOD_BIOSHROOM;
	}

	@Override
	public void place(Context context) {
		int type = context.random().nextInt(4);
			if(type==0){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
			}
			if(type==1){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}

			}
			if(type==2){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.north())) {
					context.setBlock(px1.north(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.south())) {
					context.setBlock(px1.south(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.east())) {
					context.setBlock(px1.east(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.west())) {
					context.setBlock(px1.west(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}


				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, Blocks.SHROOMLIGHT.defaultBlockState());
				}

				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RuBlocks.PINK_BIOSHROOM_BLOCK.defaultBlockState());
				}
			}
			if(type==3){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.north())) {
					context.setBlock(px1.north(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.south())) {
					context.setBlock(px1.south(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.east())) {
					context.setBlock(px1.east(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.west())) {
					context.setBlock(px1.west(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}


				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, Blocks.SHROOMLIGHT.defaultBlockState());
				}

				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RuBlocks.BLUE_BIOSHROOM_BLOCK.defaultBlockState());
				}
			}
		}

		public static boolean isReplaceablePlant(BlockState blockState) {
			return blockState.is(RuTags.REPLACEABLE_BLOCKS);
		}

		public static boolean isReplaceable(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
			return levelSimulatedReader.isStateAtPosition(blockPos, BlackwoodBioshroom::isReplaceablePlant);
		}
	}

