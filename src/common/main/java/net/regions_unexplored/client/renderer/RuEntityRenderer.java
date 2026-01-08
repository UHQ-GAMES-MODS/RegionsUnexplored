package net.regions_unexplored.client.renderer;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.entity.client.RuBoatRenderer;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.platform.RenderHelper;

public class RuEntityRenderer {
    public static void renderBoat(){
        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();

        for (RuBoat.ModelType type : RuBoat.ModelType.values()) {
            RenderHelper.registerLayerDefinition(RuBoatRenderer.boatTextureLocation(type), () -> boatLayerDefinition);
            RenderHelper.registerLayerDefinition(RuBoatRenderer.chestBoatTextureLocation(type), () -> chestBoatLayerDefinition);
        }



        RenderHelper.registerEntityRenderer(RuEntities.BOAT.get(), context -> new RuBoatRenderer(context, false));
        RenderHelper.registerEntityRenderer(RuEntities.CHEST_BOAT.get(), context -> new RuBoatRenderer(context, true));
    }
}
