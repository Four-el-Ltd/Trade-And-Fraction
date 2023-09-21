package com.warpradar.registry;

import com.hbm.inventory.fluid.Fluids;
import com.warpradar.misc.Tab;
import com.warpradar.tileentities.machines.TileEntityConverter;

import net.minecraft.init.Items;
import net.minecraftforge.fluids.FluidRegistry;

public class MainRegistry {
  public static final Tab xyi = new Tab(Items.diamond_horse_armor);

  public static void reg() {
    TileEntityConverter.FluidMap.put(Fluids.STEAM, FluidRegistry.getFluid("steam"));
  }
}
