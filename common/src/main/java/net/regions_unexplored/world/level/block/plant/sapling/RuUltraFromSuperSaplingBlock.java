package net.regions_unexplored.world.level.block.plant.sapling;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.uhq_games.regions_unexplored.block.sapling.RuUltraFromSuperTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RuUltraFromSuperSaplingBlock extends BushBlock implements BonemealableBlock {
    protected final RuUltraFromSuperTreeGrower treeGrower;
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

    public static final MapCodec<RuUltraFromSuperSaplingBlock> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(RuUltraFromSuperTreeGrower.CODEC.fieldOf("tree").forGetter(
                    (ultraSaplingBlock) -> ultraSaplingBlock.treeGrower), propertiesCodec()
            ).apply(instance, RuUltraFromSuperSaplingBlock::new)
    );

    public RuUltraFromSuperSaplingBlock(RuUltraFromSuperTreeGrower treeGrower, Properties properties) {
        super(properties);
        this.treeGrower = treeGrower;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        if (state.getValue(STAGE) == 0) {
            level.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            this.treeGrower.growTree(level, level.getChunkSource().getGenerator(), pos, state, random);
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
//        if (!serverLevel.isAreaLoaded(blockPos, 1)) return;
        if (serverLevel.getMaxLocalRawBrightness(blockPos.above()) >= 9 && randomSource.nextInt(7) == 0) {
            this.advanceTree(serverLevel, blockPos, blockState, randomSource);
        }
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return (double)level.random.nextFloat() < 0.45D;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        this.advanceTree(serverLevel, blockPos, blockState, randomSource);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
