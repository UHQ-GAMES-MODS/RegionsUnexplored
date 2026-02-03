package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.BlockFactory;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.registry.RUParticleTypes;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class RUTintedParticlesLeavesBlock extends LeavesBlock {
    public static final float PARTICLE_CHANCE = 0.025f;

    private final Supplier<ParticleType<ColorParticleOption>> particle;
    private final TintGetter tintGetter;

    public RUTintedParticlesLeavesBlock(Properties properties, Supplier<ParticleType<ColorParticleOption>> particle, int tint) {
        this(properties, particle, TintGetter.constant(tint));
    }

    public RUTintedParticlesLeavesBlock(Properties properties, Supplier<ParticleType<ColorParticleOption>> particle, TintGetter getter) {
        super(properties);
        this.particle = particle;
        this.tintGetter = getter;
    }

    public static BlockFactory small(TintGetter tint) {
        return p -> new RUTintedParticlesLeavesBlock(p, RUParticleTypes.SMALL_LEAVES, tint);
    }

    public static BlockFactory standard() {
        return standard(TintGetter.DEFAULT);
    }

    public static BlockFactory standard(TintGetter tint) {
        return standard(RUParticleTypes.STANDARD_LEAVES, tint);
    }

    public static BlockFactory standard(Supplier<ParticleType<ColorParticleOption>> type, TintGetter tint) {
        return p -> new RUTintedParticlesLeavesBlock(p, type, tint);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);

        if (!(level instanceof ClientLevel clientLevel)) return;
        if (random.nextFloat() >= PARTICLE_CHANCE) return;
        if (isFaceFull(belowState.getCollisionShape(level, below), Direction.UP)) return;
        if (!RuClientConfig.LEAVES_PARTICLES.get()) return;

        spawnLeavesParticle(clientLevel, pos, random);
    }

    protected void spawnLeavesParticle(ClientLevel level, BlockPos pos, RandomSource random) {
        ColorParticleOption particle = ColorParticleOption.create(this.particle.get(), this.tintGetter.apply(level, pos));
        ParticleUtils.spawnParticleBelow(level, pos, random, particle);
    }

    public interface TintGetter extends BiFunction<ClientLevel, BlockPos, Integer> {
        TintGetter DEFAULT = (level, pos) -> Minecraft.getInstance().getBlockColors().getColor(level.getBlockState(pos), level, pos, 0);

        static TintGetter defaultDarken(float amount) {
            return (level, pos) -> {
                int base = DEFAULT.apply(level, pos);
                int r = (int) (((base >> 16) & 0xFF) * amount) << 16;
                int g = (int) (((base >> 8) & 0xFF) * amount) << 8;
                int b = (int) ((base & 0xFF) * amount);
                return r | g | b;
            };
        }

        static TintGetter constant(int tint) {
            return (level, pos) -> tint;
        }
    }
}
