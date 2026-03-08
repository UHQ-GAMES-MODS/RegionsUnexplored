package net.regions_unexplored.registry.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface BackportedBlockTags {
    TagKey<Block> SUPPORTS_VEGETATION = key("supports_vegetation");
    TagKey<Block> SUPPORTS_CROPS = key("supports_crops");

    private static TagKey<Block> key(String name) {
        return TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace(name));
    }
}
