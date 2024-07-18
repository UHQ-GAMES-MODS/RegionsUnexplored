package net.regions_unexplored.client.renderer;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.entity.client.RuBoatRenderer;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.platform.Services;

public class RuEntityRenderer {
    public static void renderBoat(){
        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();

        for (RuBoat.ModelType type : RuBoat.ModelType.values()) {
            Services.RENDER_HELPER.registerLayerDefinition(RuBoatRenderer.boatTextureLocation(type), () -> boatLayerDefinition);
            Services.RENDER_HELPER.registerLayerDefinition(RuBoatRenderer.chestBoatTextureLocation(type), () -> chestBoatLayerDefinition);
        }

        Services.RENDER_HELPER.registerEntityRenderer(RuEntities.BOAT, context -> new RuBoatRenderer(context, false));
        Services.RENDER_HELPER.registerEntityRenderer(RuEntities.CHEST_BOAT, context -> new RuBoatRenderer(context, true));
    }
}
