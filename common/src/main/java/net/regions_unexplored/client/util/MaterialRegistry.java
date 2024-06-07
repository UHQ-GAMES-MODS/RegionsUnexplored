package net.regions_unexplored.client.util;

import net.minecraft.client.resources.model.Material;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaterialRegistry {
    public final List<Material> materials;
    public static MaterialRegistry INSTANCE = new MaterialRegistry();

    public MaterialRegistry() {
        this.materials = new ArrayList<>();
    }

    public void setMaterial(Material material) {
        this.materials.add(material);
    }

    public Collection<Material> getMaterials() {
        return Collections.unmodifiableList(materials);
    }
}
