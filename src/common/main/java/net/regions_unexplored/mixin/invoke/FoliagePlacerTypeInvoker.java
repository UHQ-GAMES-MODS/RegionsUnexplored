package net.regions_unexplored.mixin.invoke;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FoliagePlacerType.class)
public interface FoliagePlacerTypeInvoker {

    @Invoker
    static <P extends FoliagePlacer> FoliagePlacerType<P> callRegister(String id, MapCodec<P> codec) {
        throw new IllegalStateException();
    }
}
