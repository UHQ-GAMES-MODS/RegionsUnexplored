package net.regions_unexplored.block.sapling;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public final class RuUltraFromSuperTreeGrower {
    private static final Map<String, RuUltraFromSuperTreeGrower> GROWERS = new Object2ObjectArrayMap<>();

    // TODO: Fix this codec
    public static final Codec<RuUltraFromSuperTreeGrower> CODEC = ExtraCodecs.stringResolverCodec((grower) -> grower.name, GROWERS::get);

    private final String name;
    private final float secondaryChance;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> ultraTree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryUltraTree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> superTree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondarySuperTree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryTree;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> flowers;
    private final Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryFlowers;

    public RuUltraFromSuperTreeGrower(String key, Optional<ResourceKey<ConfiguredFeature<?, ?>>> superTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> flowers) {
        this(key, 0.0F, Optional.empty(), Optional.empty(), superTree, Optional.empty(), tree, Optional.empty(), flowers, Optional.empty());
    }

    public RuUltraFromSuperTreeGrower(String key, Optional<ResourceKey<ConfiguredFeature<?, ?>>> ultraTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> superTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> flowers) {
        this(key, 0.0F, ultraTree, Optional.empty(), superTree, Optional.empty(), tree, Optional.empty(), flowers, Optional.empty());
    }

    public RuUltraFromSuperTreeGrower(String key, float secondaryChance, Optional<ResourceKey<ConfiguredFeature<?, ?>>> ultraTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryUltraTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> superTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondarySuperTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> flowers, Optional<ResourceKey<ConfiguredFeature<?, ?>>> secondaryFlowers) {
        this.name = key;
        this.secondaryChance = secondaryChance;
        this.ultraTree = ultraTree;
        this.secondaryUltraTree = secondaryUltraTree;
        this.superTree = superTree;
        this.secondarySuperTree = secondarySuperTree;
        this.tree = tree;
        this.secondaryTree = secondaryTree;
        this.flowers = flowers;
        this.secondaryFlowers = secondaryFlowers;
        GROWERS.put(key, this);
    }

    @Nullable
    private ResourceKey<ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource random) {
        return this.secondaryUltraTree.isPresent() && random.nextFloat() < this.secondaryChance ? this.secondaryUltraTree.get() : this.ultraTree.orElse(null);
    }

    @Nullable
    private ResourceKey<ConfiguredFeature<?, ?>> getConfiguredSuperFeature(RandomSource random) {
        return this.secondarySuperTree.isPresent() && random.nextFloat() < this.secondaryChance ? this.secondarySuperTree.get() : this.superTree.orElse(null);
    }

    @Nullable
    private ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean b) {
        if (random.nextFloat() < this.secondaryChance) {
            if (b && this.secondaryFlowers.isPresent()) {
                return this.secondaryFlowers.get();
            }

            if (this.secondaryTree.isPresent()) {
                return this.secondaryTree.get();
            }
        }

        return b && this.flowers.isPresent() ? this.flowers.get() : this.tree.orElse(null);
    }

    public boolean growTree(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, RandomSource random) {

        ResourceKey<ConfiguredFeature<?, ?>> resourcekey = this.getConfiguredUltraFeature(random);
        if (resourcekey != null) {
            Holder<ConfiguredFeature<?, ?>> holder = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(resourcekey).orElse(null);
            if (holder != null) {
                for(int i = 1; i >= -1; --i) {
                    for(int j = 1; j >= -1; --j) {
                        if (isThreeBlockSapling(state, level, pos, i, j)) {
                            ConfiguredFeature<?, ?> configuredfeature = holder.value();
                            BlockState blockstate = Blocks.AIR.defaultBlockState();
                            level.setBlock(pos.offset(i, 0, j), blockstate, 4);
                            level.setBlock(pos.offset(i, 0, j+1), blockstate, 4);
                            level.setBlock(pos.offset(i, 0, j-1), blockstate, 4);
                            level.setBlock(pos.offset(i+1, 0, j), blockstate, 4);
                            level.setBlock(pos.offset(i-1, 0, j), blockstate, 4);
                            level.setBlock(pos.offset(i+1, 0, j+1), blockstate, 4);
                            level.setBlock(pos.offset(i+1, 0, j-1), blockstate, 4);
                            level.setBlock(pos.offset(i-1, 0, j+1), blockstate, 4);
                            level.setBlock(pos.offset(i-1, 0, j-1), blockstate, 4);
                            if (configuredfeature.place(level, generator, random, pos.offset(i, 0, j))) {
                                return true;
                            }

                            level.setBlock(pos.offset(i, 0, j), state, 4);
                            level.setBlock(pos.offset(i, 0, j+1), state, 4);
                            level.setBlock(pos.offset(i, 0, j-1), state, 4);
                            level.setBlock(pos.offset(i+1, 0, j), state, 4);
                            level.setBlock(pos.offset(i-1, 0, j), state, 4);
                            level.setBlock(pos.offset(i+1, 0, j+1), state, 4);
                            level.setBlock(pos.offset(i+1, 0, j-1), state, 4);
                            level.setBlock(pos.offset(i-1, 0, j+1), state, 4);
                            level.setBlock(pos.offset(i-1, 0, j-1), state, 4);
                            return false;
                        }
                    }
                }
            }
        }



        ResourceKey<ConfiguredFeature<?, ?>> resourcekey1 = this.getConfiguredSuperFeature(random);
        if (resourcekey1 != null) {
            Holder<ConfiguredFeature<?, ?>> holder = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(resourcekey1).orElse((Holder.Reference<ConfiguredFeature<?, ?>>)null);
            if (holder != null) {
                for(int i = 1; i >= -1; --i) {
                    for(int j = 1; j >= -1; --j) {
                        if (isStarBlockSapling(state, level, pos, i, j)) {
                            ConfiguredFeature<?, ?> configuredfeature = holder.value();
                            BlockState blockstate = Blocks.AIR.defaultBlockState();
                            level.setBlock(pos.offset(i, 0, j), blockstate, 4);
                            level.setBlock(pos.offset(i, 0, j+1), blockstate, 4);
                            level.setBlock(pos.offset(i, 0, j-1), blockstate, 4);
                            level.setBlock(pos.offset(i+1, 0, j), blockstate, 4);
                            level.setBlock(pos.offset(i-1, 0, j), blockstate, 4);
                            if (configuredfeature.place(level, generator, random, pos.offset(i, 0, j))) {
                                return true;
                            }

                            level.setBlock(pos.offset(i, 0, j), state, 4);
                            level.setBlock(pos.offset(i, 0, j+1), state, 4);
                            level.setBlock(pos.offset(i, 0, j-1), state, 4);
                            level.setBlock(pos.offset(i+1, 0, j), state, 4);
                            level.setBlock(pos.offset(i-1, 0, j), state, 4);
                            return false;
                        }
                    }
                }
            }
        }

        ResourceKey<ConfiguredFeature<?, ?>> resourcekey2 = this.getConfiguredFeature(random, this.hasFlowers(level, pos));
        if (resourcekey2 == null) {
            return false;
        } else {
            Holder<ConfiguredFeature<?, ?>> holder1 = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(resourcekey2).orElse((Holder.Reference<ConfiguredFeature<?, ?>>)null);
            if (holder1 == null) {
                return false;
            } else {
                ConfiguredFeature<?, ?> configuredfeature1 = holder1.value();
                BlockState blockstate1 = level.getFluidState(pos).createLegacyBlock();
                level.setBlock(pos, blockstate1, 4);
                if (configuredfeature1.place(level, generator, random, pos)) {
                    if (level.getBlockState(pos) == blockstate1) {
                        level.sendBlockUpdated(pos, state, blockstate1, 2);
                    }

                    return true;
                } else {
                    level.setBlock(pos, state, 4);
                    return false;
                }
            }
        }
    }

    public static boolean isThreeBlockSapling(BlockState state, BlockGetter getter, BlockPos pos, int X, int Z) {
        Block block = state.getBlock();
        return  getter.getBlockState(pos.offset(X, 0, Z)).is(block) &&
                getter.getBlockState(pos.offset(X, 0, Z+1)).is(block) &&
                getter.getBlockState(pos.offset(X, 0, Z-1)).is(block) &&
                getter.getBlockState(pos.offset(X+1, 0, Z)).is(block) &&
                getter.getBlockState(pos.offset(X-1, 0, Z)).is(block) &&
                getter.getBlockState(pos.offset(X+1, 0, Z+1)).is(block) &&
                getter.getBlockState(pos.offset(X+1, 0, Z-1)).is(block) &&
                getter.getBlockState(pos.offset(X-1, 0, Z+1)).is(block) &&
                getter.getBlockState(pos.offset(X-1, 0, Z-1)).is(block);
    }

    public static boolean isStarBlockSapling(BlockState state, BlockGetter getter, BlockPos pos, int X, int Z) {
        Block block = state.getBlock();
        return  getter.getBlockState(pos.offset(X, 0, Z)).is(block) &&
                getter.getBlockState(pos.offset(X, 0, Z+1)).is(block) &&
                getter.getBlockState(pos.offset(X, 0, Z-1)).is(block) &&
                getter.getBlockState(pos.offset(X+1, 0, Z)).is(block) &&
                getter.getBlockState(pos.offset(X-1, 0, Z)).is(block);
    }

    private boolean hasFlowers(LevelAccessor level, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.MutableBlockPos.betweenClosed(pos.below().north(2).west(2), pos.above().south(2).east(2))) {
            if (level.getBlockState(blockpos).is(BlockTags.FLOWERS)) {
                return true;
            }
        }

        return false;
    }
}