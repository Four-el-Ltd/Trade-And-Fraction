package com.warpradar.tileentities.machines;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.fluid.tank.FluidTank;
import com.hbm.tileentity.TileEntityLoadedBase;

import api.hbm.fluid.IFluidStandardReceiver;

/**
 * TileEntityConverter
 * Класс сущности конвертера
 * Здесь определено всё его поведение
 */

public class TileEntityConverter extends TileEntityLoadedBase implements IFluidStandardReceiver, IFluidHandler {

    public static HashMap<FluidType, Fluid> FluidMap = new HashMap<>();

    public FluidTank bobtank;
    public net.minecraftforge.fluids.FluidTank forgetank;

    public TileEntityConverter() {
        bobtank = new FluidTank(Fluids.NONE, 12000);
        forgetank = new net.minecraftforge.fluids.FluidTank(12000);
    }

    /**
     * Метод обновления сущности
     * вызывается каждый тик
     * Реалищует всю логику сущности
     *
     * В данном случае:
     * Снятие n-ого количества Бобовской жидкости если её больше нуля и существует
     * форжевская жидкость соответствуюшая Бобовской
     * Начисление аналогичного количества форжевской жидкости
     */
    @Override
    public void updateEntity() {

        if (!worldObj.isRemote && bobtank.getTankType() != Fluids.NONE) {
            if (FluidMap.containsKey(bobtank.getTankType()) && forgetank.getFluidAmount() < forgetank.getCapacity()) {
                if (forgetank.getFluid() == null) {

                } else if (forgetank.getFluid()
                    .getFluid() == FluidMap.get(bobtank.getTankType())) {

                    } else {
                        return;
                    }
                int amount = Math.min(forgetank.getCapacity() - forgetank.getFluidAmount(), bobtank.getFill());
                bobtank.setFill(bobtank.getFill() - amount);
                FluidStack fluidStack = new FluidStack(FluidMap.get(bobtank.getTankType()), amount);
                forgetank.fill(fluidStack, true);
            }
            this.subscribeToAllAround(bobtank.getTankType(), this);
        }
    }

    @Override
    public FluidTank[] getReceivingTanks() {
        FluidTank a[] = { bobtank };
        return a;
    }

    @Override
    public FluidTank[] getAllTanks() {
        FluidTank a[] = { bobtank };
        return a;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        return forgetank.fill(resource, doFill);
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(forgetank.getFluid())) {
            return null;
        }
        return forgetank.drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return forgetank.drain(maxDrain, doDrain);
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[] { forgetank.getInfo() };
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return true;
    }

    /**
     * Данный метод при запуске мира/прогрузке чанков с сущностью считыввает ее
     * данные из NBT
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        bobtank.readFromNBT(nbt, "tank1");
        forgetank.readFromNBT(nbt);
    }

    /**
     * Данный метод каждый тик созраняет данные сущноати в NBT
     */
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        bobtank.writeToNBT(nbt, "tank1");
        forgetank.writeToNBT(nbt);
    }

}
