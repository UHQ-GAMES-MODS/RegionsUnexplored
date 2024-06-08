package net.regions_unexplored.item.behaviour;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;

public class RuBoatItemBehaviour extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior();
    private final RuBoat.ModelType model;
    private final boolean chest;

    public RuBoatItemBehaviour(boolean chest, RuBoat.ModelType model) {
        this.model = model; this.chest = chest;
    }

    @Override
    public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        Boat boat;
        double d3;

        Vec3 pos = new Vec3(
        blockSource.center().x + (double) ((float) direction.getStepX() * 1.125F),
        blockSource.center().y + (double) ((float) direction.getStepY() * 1.125F),
        blockSource.center().y + (double) ((float) direction.getStepZ() * 1.125F));
        BlockPos blockpos = blockSource.pos().relative(direction);

        if (blockSource.level().getFluidState(blockpos).is(FluidTags.WATER)) {
            d3 = 1.0D;
        } else {
            if (!blockSource.level().getBlockState(blockpos).isAir() || !blockSource.level().getFluidState(blockpos.below()).is(FluidTags.WATER)) {
                return this.dispenseItemBehavior.dispense(blockSource, itemStack);
            }
            d3 = 0.0D;
        }

        if (this.chest) {
            boat = new RuChestBoat(blockSource.level(), pos.x, pos.y + d3, pos.z); ((RuChestBoat)boat).setModel(this.model);
        } else {
            boat = new RuBoat(blockSource.level(), pos.x, pos.y + d3, pos.z); ((RuBoat)boat).setModel(this.model);
        }

        boat.setYRot(direction.toYRot());
        blockSource.level().addFreshEntity(boat);
        itemStack.shrink(1);

        return itemStack;
    }

    @Override
    protected void playSound(BlockSource p_123373_)
    {
        p_123373_.level().levelEvent(1000, p_123373_.pos(), 0);
    }
}