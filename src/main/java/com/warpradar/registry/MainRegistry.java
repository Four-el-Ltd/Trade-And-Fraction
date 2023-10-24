package com.warpradar.registry;

import com.hbm.inventory.fluid.Fluids;
import com.hbm.saveddata.satellites.Satellite;
import com.warpradar.misc.Tab;
import com.warpradar.misc.satellites.luchik;
import com.warpradar.tileentities.machines.TileEntityConverter;

import net.minecraft.init.Items;
import net.minecraftforge.fluids.FluidRegistry;

public class MainRegistry {
  public static final Tab BlocksTab = new Tab(Items.diamond_horse_armor);
  public static final Tab ItemsTab = new Tab(ModItems.bottle_leninade);

  public static void regFluidMap() {
    TileEntityConverter.FluidMap.put(Fluids.STEAM, FluidRegistry.getFluid("steam"));
  }

  public static void regSatellites() {
    Satellite.registerSatellite(luchik.class, ModItems.sat_luchik);
  }
}
