package betterwithmods.api.tile;

import betterwithmods.api.block.IOverpower;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IMechanicalPower  {
    int getMechanicalOutput(EnumFacing facing);

    int getMechanicalInput(EnumFacing facing);

    int getMaximumInput(EnumFacing facing);

    int getMinimumInput(EnumFacing facing);

    Block getBlockType();

    World getWorld();

    BlockPos getPos();

    default int calculateInput() {
        int findPower = 0;
        for (EnumFacing facing : EnumFacing.values()) {
            int power = getMechanicalInput(facing);
            if (power > findPower) {
                findPower = power;
            }
        }
        if (overpowerChance() && findPower > getMaximumInput(EnumFacing.UP)) {
            overpower();
            return 0;
        }
        return findPower;
    }

    default boolean overpowerChance() {
        return getWorld().rand.nextInt(10) == 0;
    }

    default void overpower() {
        if (getBlockType() instanceof IOverpower)
            ((IOverpower) getBlockType()).overpower(getWorld(), getPos());
    }
}
