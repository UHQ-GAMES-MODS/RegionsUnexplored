package net.regions_unexplored.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

import static net.regions_unexplored.registry.RUSoundEvents.register;

public record WoodSoundSet(
    SoundEvent buttonOff, SoundEvent buttonOn,
    SoundEvent doorClose, SoundEvent doorOpen,
    SoundEvent fenceGateClose, SoundEvent fenceGateOpen,
    SoundEvent hangingSignPlace, SoundEvent hangingSignStep,
    SoundEvent trapdoorClose, SoundEvent trapdoorOpen,
    SoundEvent basePlace, SoundEvent baseStep,
    SoundEvent pressurePlateOff, SoundEvent pressurePlateOn
) {
    public static WoodSoundSet create(String name) {
        return new WoodSoundSet(
            register(id(name, ".button_click_off")),
            register(id(name, ".button_click_on")),
            register(id(name, ".door_close")),
            register(id(name, ".door_open")),
            register(id(name, ".fence_gate_close")),
            register(id(name, ".fence_gate_open")),
            register(id(name, ".hanging_sign_place")),
            register(id(name, ".hanging_sign_step")),
            register(id(name, ".trapdoor_close")),
            register(id(name, ".trapdoor_open")),
            register(id(name, ".place")),
            register(id(name, ".step")),
            register(id(name, ".pressure_plate_click_off")),
            register(id(name, ".pressure_plate_click_on"))
        );
    }
    
    private static String id(String baseName, String suffix) {
        return "block." + baseName + suffix;
    }

    public SoundType baseType() {
        return new SoundType(1f, 1f, this.basePlace, this.baseStep, this.basePlace, this.baseStep, this.baseStep);
    }

    public SoundType hangingSignType() {
        return new SoundType(1f, 1f, this.hangingSignPlace, this.hangingSignStep, this.hangingSignPlace, this.hangingSignStep, this.hangingSignStep);
    }
}
