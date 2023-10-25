package com.warpradar.registry;

import com.hbm.inventory.fluid.Fluids;
import com.hbm.saveddata.satellites.Satellite;
import com.warpradar.main.WarpRadar;
import com.warpradar.misc.Tab;
import com.warpradar.misc.satellites.luchik;
import com.warpradar.tileentities.machines.TileEntityConverter;

import net.minecraft.init.Items;
import net.minecraftforge.fluids.FluidRegistry;

public class MainRegistry {
  public static void register() {
    regFluidMap();
    regSatellites();
    ModItems.registerItems();
    ModBlocks.registerBlocks();
    regTabs();
  }

  public static Tab BlocksTab;
  public static Tab ItemsTab;

  public static void regFluidMap() {
    TileEntityConverter.FluidMap.put(Fluids.STEAM, FluidRegistry.getFluid("steam"));
  }

  public static void regSatellites() {
    Satellite.registerSatellite(luchik.class, ModItems.sat_luchik);
  }

  public static void regTabs() {
    BlocksTab = new Tab(Items.diamond_horse_armor, WarpRadar.MODID + "BlocksTab");
    ItemsTab = new Tab(ModItems.bottle_leninade, WarpRadar.MODID + "ItemsTab");
  }
}
