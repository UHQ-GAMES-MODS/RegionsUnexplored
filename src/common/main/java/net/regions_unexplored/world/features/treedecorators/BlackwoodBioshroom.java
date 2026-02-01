package net.regions_unexplored.world.features.treedecorators;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.tag.RUBlockTags;

public class BlackwoodBioshroom extends TreeDecorator {
	public static BlackwoodBioshroom INSTANCE = new BlackwoodBioshroom();
	public static MapCodec<BlackwoodBioshroom> CODEC = MapCodec.unit(BlackwoodBioshroom::new);
	public static TreeDecoratorType<BlackwoodBioshroom> TYPE = new TreeDecoratorType<>(CODEC);

	@Override
	protected TreeDecoratorType<?> type() {
		return TYPE;
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
					context.setBlock(px1, RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
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
					context.setBlock(px1, RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
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
					context.setBlock(px1, RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.north())) {
					context.setBlock(px1.north(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.south())) {
					context.setBlock(px1.south(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.east())) {
					context.setBlock(px1.east(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.west())) {
					context.setBlock(px1.west(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
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
					context.setBlock(px1s.west(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
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
					context.setBlock(px1, RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.north())) {
					context.setBlock(px1.north(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.south())) {
					context.setBlock(px1.south(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.east())) {
					context.setBlock(px1.east(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.west())) {
					context.setBlock(px1.west(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
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
					context.setBlock(px1s.west(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
			}
		}

		public static boolean isReplaceablePlant(BlockState blockState) {
			return blockState.is(RUBlockTags.REPLACEABLE_BLOCKS);
		}

		public static boolean isReplaceable(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
			return levelSimulatedReader.isStateAtPosition(blockPos, BlackwoodBioshroom::isReplaceablePlant);
		}
	}

