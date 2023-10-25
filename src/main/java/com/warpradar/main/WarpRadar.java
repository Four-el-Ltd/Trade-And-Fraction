package com.warpradar.main;

import com.warpradar.registry.MainRegistry;
import com.warpradar.registry.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = WarpRadar.MODID, name = WarpRadar.NAME, version = WarpRadar.VERSION, dependencies = "required-after:hbm")
public class WarpRadar {
    public static final String MODID = "warpradar";
    public static final String NAME = "Warp Radar";
    public static final String VERSION = "0.0.2";

    @Metadata
    public static ModMetadata meta;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.registerItems();
        MainRegistry.regSatellites();
        try {
            if (Class.forName("com.hfr.main.MainRegistry") != null) {
                throw new IllegalStateException("xRadar is forbidden. Fuck you");
            }
        } catch (ClassNotFoundException e) {

        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
