package net.regions_unexplored.data.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.platform.Services;

public class RuWoodTypes {
    public static WoodType ALPHA = register("alpha", RuBlockSetType.ALPHA);
    public static WoodType BAOBAB = register("baobab", RuBlockSetType.BAOBAB);
    public static WoodType BLACKWOOD = register("blackwood", RuBlockSetType.BLACKWOOD);
    public static WoodType BLUE_BIOSHROOM = register("blue_bioshroom", RuBlockSetType.BLUE_BIOSHROOM);
    public static WoodType BRIMWOOD = register("brimwood", RuBlockSetType.BRIMWOOD);
    public static WoodType COBALT = register("cobalt", RuBlockSetType.COBALT);
    public static WoodType CYPRESS = register("cypress", RuBlockSetType.CYPRESS);
    public static WoodType DEAD = register("dead", RuBlockSetType.DEAD);
    public static WoodType EUCALYPTUS = register("eucalyptus", RuBlockSetType.EUCALYPTUS);
    public static WoodType GREEN_BIOSHROOM = register("green_bioshroom", RuBlockSetType.GREEN_BIOSHROOM);
    public static WoodType JOSHUA = register("joshua", RuBlockSetType.JOSHUA);
    public static WoodType KAPOK = register("kapok", RuBlockSetType.KAPOK);
    public static WoodType LARCH = register("larch", RuBlockSetType.LARCH);
    public static WoodType MAGNOLIA = register("magnolia", RuBlockSetType.MAGNOLIA);
    public static WoodType MAPLE = register("maple", RuBlockSetType.MAPLE);
    public static WoodType MAUVE = register("mauve", RuBlockSetType.MAUVE);
    public static WoodType PALM = register("palm", RuBlockSetType.PALM);
    public static WoodType PINE = register("pine", RuBlockSetType.PINE);
    public static WoodType PINK_BIOSHROOM = register("pink_bioshroom", RuBlockSetType.PINK_BIOSHROOM);
    public static WoodType REDWOOD = register("redwood", RuBlockSetType.REDWOOD);
    public static WoodType SOCOTRA = register("socotra", RuBlockSetType.SOCOTRA);
    public static WoodType WILLOW = register("willow", RuBlockSetType.WILLOW);
    public static WoodType YELLOW_BIOSHROOM = register("yellow_bioshroom", RuBlockSetType.YELLOW_BIOSHROOM);

    private static WoodType register(String name, BlockSetType blockSetType) {
        return Services.BLOCK_HELPER.setWoodType(name, blockSetType);
    }
}
