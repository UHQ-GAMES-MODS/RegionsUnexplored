package net.regions_unexplored.worldgen.foliageplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.regions_unexplored.worldgen.foliageplacer.RUFoliagePlacerUtils.Context;

public class RedwoodFoliagePlacer extends BlobFoliagePlacer {
    public static final MapCodec<RedwoodFoliagePlacer> CODEC = IntProvider.CODEC.fieldOf("offset").xmap(RedwoodFoliagePlacer::new, p -> p.offset);
    public static final FoliagePlacerType<RedwoodFoliagePlacer> TYPE = new FoliagePlacerType<>(CODEC);

    public RedwoodFoliagePlacer(IntProvider offset) {
        this(ConstantInt.of(1), offset, 1);
    }

    public RedwoodFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset, height);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return TYPE;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliagePlacer.FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int treeHeight, FoliagePlacer.FoliageAttachment foliageAttachment, int foliageHeight, int leafRadius, int offset) {
        Context context = new Context(level, foliageSetter, random, config, foliageAttachment.pos(), offset);
        RUFoliagePlacerUtils.placeDiamond(context, 1, -1, false);
        RUFoliagePlacerUtils.placeDiamond(context, 2, 0, false);
        RUFoliagePlacerUtils.placeSquare(context, 1, 1, false, 0.33f);
        RUFoliagePlacerUtils.placeDiamond(context, 1, 2, false);
        RUFoliagePlacerUtils.placeSquare(context, 0, 3, false);
        RUFoliagePlacerUtils.placeSquare(context, 0, 4, false);
    }
}
