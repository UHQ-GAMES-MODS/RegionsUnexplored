package net.regions_unexplored.world.level.block.plant.tall;

import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.regions_unexplored.registry.RUSoundEvents;

public class RuDoublePlantBlock extends DoublePlantBlock {

    public RuDoublePlantBlock(Properties properties) {
        super(properties.sound(RUSoundEvents.TALL_GRASS));
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }
}

