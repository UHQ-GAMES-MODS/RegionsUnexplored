package net.regions_unexplored.world.level.region;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.regions_unexplored.Constants;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class RuRegionNether extends Region {
    public static final ResourceLocation LOCATION = Constants.id("nether");

    public RuRegionNether(int weight) {
        super(LOCATION, RegionType.NETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        if (RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_MYCOTOXIC_UNDERGROWTH) {
            this.addBiome(mapper, Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), 0.0F, RuBiomes.MYCOTOXIC_UNDERGROWTH);
        }
        if (RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_GLISTERING_MEADOW) {
            this.addBiome(mapper, Climate.Parameter.point(-0.5F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), 0.175F, RuBiomes.GLISTERING_MEADOW);
        }
        if (RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_BLACKSTONE_BASIN) {
            this.addBiome(mapper, Climate.Parameter.point(0.4F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), 0.0F, RuBiomes.BLACKSTONE_BASIN);
        }
        if (RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_INFERNAL_HOLT){
            this.addBiome(mapper, Climate.Parameter.point(0.0F), Climate.Parameter.point(-0.5F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), 0.0F, RuBiomes.INFERNAL_HOLT);
        }
        if(RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_REDSTONE_ABYSS) {
            this.addBiome(mapper, Climate.Parameter.point(0.0F), Climate.Parameter.point(0.5F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), 0.375F, RuBiomes.REDSTONE_ABYSS);
        }
    }
}