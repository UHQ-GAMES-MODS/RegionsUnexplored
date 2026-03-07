package net.regions_unexplored.worldgen.foliageplacer;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import static net.regions_unexplored.worldgen.foliageplacer.RUFoliagePlacerUtils.*;

public class PineFoliagePlacer extends BlobFoliagePlacer {
    public static final MapCodec<PineFoliagePlacer> CODEC = IntProvider.CODEC.fieldOf("offset").xmap(PineFoliagePlacer::new, p -> p.offset);
    public static final FoliagePlacerType<PineFoliagePlacer> TYPE = new FoliagePlacerType<>(CODEC);

    public PineFoliagePlacer(IntProvider offset) {
        this(ConstantInt.of(1), offset, 1);
    }

    public PineFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset, height);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return TYPE;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int treeHeight, FoliageAttachment foliageAttachment, int foliageHeight, int leafRadius, int offset) {
        Context context = new Context(level, foliageSetter, random, config, foliageAttachment.pos(), offset);
        placeSquare(context, 0, 2, false);
        placeSquare(context, 0, 1, false);
        placeDiamond(context, 1, 0, false);
        if (random.nextBoolean()) {
            placeDiamond(context, 1, -1, false);
            placeSquare(context, 1, -2, false);
            placeDiamond(context, 2, -3, false);
            placeDiamond(context, 1, -4, false);
            placeDiamond(context, 2, -5, false);
            placeSquare(context, 2, -6, false, 0);
            if (random.nextFloat() < 0.3) {
                placeDiamond(context, 3, 4, -7, false);
            } else {
                placeSquare(context, 1, -7, false);
            }
            placeDiamond(context, 1, -8, false);
        } else {
            placeSquare(context, 0, -1, false);
            placeDiamond(context, 1, -2, false);
            placeSquare(context, 1, -3, false);
            placeDiamond(context, 2, -4, false);
            placeDiamond(context, 1, -5, false);
            placeSquare(context, 2, -6, false, 0);
            if (random.nextFloat() < 0.3) {
                placeDiamond(context, 3, 4, -7, false);
            } else {
                placeSquare(context, 2, -7, false);
            }
            placeDiamond(context, 1, -8, false);
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        return dx == currentRadius && dz == currentRadius && currentRadius != 0;
    }
}
