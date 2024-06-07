package net.regions_unexplored.client.render;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.Constants;
import net.regions_unexplored.client.util.MaterialRegistry;
import net.regions_unexplored.data.block.RuWoodTypes;

public class RuSheets {
    public static void registerSheets() {
        signSheets();
        hangingSignSheets();
    }

    private static void signSheets() {
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.ALPHA));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.BAOBAB));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.BLACKWOOD));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.BLUE_BIOSHROOM));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.BRIMWOOD));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.COBALT));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.CYPRESS));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.DEAD));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.EUCALYPTUS));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.GREEN_BIOSHROOM));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.JOSHUA));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.KAPOK));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.LARCH));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.MAGNOLIA));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.MAPLE));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.MAUVE));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.PALM));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.PINE));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.PINK_BIOSHROOM));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.REDWOOD));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.SOCOTRA));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.WILLOW));
        MaterialRegistry.INSTANCE.setMaterial(createSignMaterial(RuWoodTypes.YELLOW_BIOSHROOM));
    }

    private static void hangingSignSheets() {
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.ALPHA));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.BAOBAB));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.BLACKWOOD));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.BLUE_BIOSHROOM));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.BRIMWOOD));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.COBALT));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.CYPRESS));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.DEAD));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.EUCALYPTUS));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.GREEN_BIOSHROOM));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.JOSHUA));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.KAPOK));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.LARCH));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.MAGNOLIA));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.MAPLE));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.MAUVE));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.PALM));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.PINE));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.PINK_BIOSHROOM));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.REDWOOD));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.SOCOTRA));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.WILLOW));
        MaterialRegistry.INSTANCE.setMaterial(createHangingSignMaterial(RuWoodTypes.YELLOW_BIOSHROOM));
    }

    private static Material createSignMaterial(WoodType woodType) {
        return new Material(Sheets.SIGN_SHEET, Constants.id("entity/signs/" + woodType.name().replace("regions_unexplored:", "")));
    }

    private static Material createHangingSignMaterial(WoodType woodType) {
        return new Material(Sheets.SIGN_SHEET, Constants.id("entity/signs/hanging/" + woodType.name().replace("regions_unexplored:", "")));
    }
}
