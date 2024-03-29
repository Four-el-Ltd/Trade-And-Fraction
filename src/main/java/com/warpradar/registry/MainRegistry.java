package com.warpradar.registry;

import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidRegistry;

import com.hbm.inventory.fluid.Fluids;
import com.hbm.saveddata.satellites.Satellite;
import com.warpradar.main.WarpRadar;
import com.warpradar.misc.Tab;
import com.warpradar.misc.satellites.CumOne;
import com.warpradar.misc.satellites.luchik;
import com.warpradar.tileentities.machines.TileEntityConverter;

import cpw.mods.fml.common.registry.GameRegistry;

public class MainRegistry {

    public static void register() {
        regFluidMap();
        regSatellites();
        ModItems.registerItems();
        TileMappings.writeMappings();
        registerTiles();
        ModBlocks.registerBlocks();
        regTabs();
    }

    public static void registerTiles() {
        for (Entry<Class<? extends TileEntity>, String[]> E : TileMappings.map.entrySet()) {
            if (E.getValue().length == 1) {
                GameRegistry.registerTileEntity(E.getKey(), E.getValue()[0]);
            } else {
                GameRegistry.registerTileEntityWithAlternatives(E.getKey(), E.getValue()[0], E.getValue());
            }
        }
    }

    public static Tab BlocksTab;
    public static Tab ItemsTab;

    public static void regFluidMap() {
        TileEntityConverter.FluidMap.put(Fluids.STEAM, FluidRegistry.getFluid("steam"));
        TileEntityConverter.FluidMap.put(Fluids.WATER, FluidRegistry.WATER);
        TileEntityConverter.FluidMap.put(Fluids.OIL, FluidRegistry.getFluid("oil"));
    }

    public static void regSatellites() {
        Satellite.registerSatellite(luchik.class, ModItems.sat_luchik);
        Satellite.registerSatellite(CumOne.class, ModItems.sat_cumone);
    }

    public static void regTabs() {
        BlocksTab = new Tab(Items.diamond_horse_armor, WarpRadar.MODID + "BlocksTab");
        ItemsTab = new Tab(ModItems.bottle_leninade, WarpRadar.MODID + "ItemsTab");
    }
}
