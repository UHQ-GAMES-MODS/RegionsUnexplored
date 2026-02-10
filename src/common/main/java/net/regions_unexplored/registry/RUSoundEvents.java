package net.regions_unexplored.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.platform.Registrar;
import net.regions_unexplored.sound.SoundTypeHelper;
import net.regions_unexplored.sound.WoodSoundSet;

public interface RUSoundEvents {
    WoodSoundSet BAOBAB_SET = WoodSoundSet.create("baobab");
    WoodSoundSet REDWOOD_SET = WoodSoundSet.create("redwood");

    SoundType LEAF_LITTER = SoundTypeHelper.create("leaf_litter");

    static SoundEvent register(String name) {
        SoundEvent event = SoundEvent.createVariableRangeEvent(RegionsUnexplored.id(name));
        Registrar.register(BuiltInRegistries.SOUND_EVENT, name, () -> event);
        return event;
    }

    static void init() {}
}
