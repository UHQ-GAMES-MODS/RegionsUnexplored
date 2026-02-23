package net.regions_unexplored.worldgen.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class RedwoodFoliagePlacer extends BlobFoliagePlacer {
    public static final MapCodec<RedwoodFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(i -> RedwoodFoliagePlacer.blobParts(i).apply(i, RedwoodFoliagePlacer::new));
    public static final FoliagePlacerType<RedwoodFoliagePlacer> TYPE = new FoliagePlacerType<>(CODEC);

    public RedwoodFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset, height);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return TYPE;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliagePlacer.FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int treeHeight, FoliagePlacer.FoliageAttachment foliageAttachment, int foliageHeight, int leafRadius, int offset) {
        this.placeLeavesRow(level, foliageSetter, random, config, foliageAttachment.pos(), 1, -1, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(level, foliageSetter, random, config, foliageAttachment.pos(), 2, 0, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(level, foliageSetter, random, config, foliageAttachment.pos(), 1, 1, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(level, foliageSetter, random, config, foliageAttachment.pos(), 1, 2, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(level, foliageSetter, random, config, foliageAttachment.pos(), 0, 3, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(level, foliageSetter, random, config, foliageAttachment.pos(), 0, 4, foliageAttachment.doubleTrunk());
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        return switch (y) {
            case -1, 2 -> dx + dz > 1;
            case 0 -> dx + dz > 2;
            case 1 -> dx + dz == 2 && random.nextInt(3) == 0;
            default -> false;
        };
    }
}
