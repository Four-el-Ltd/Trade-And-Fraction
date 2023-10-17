package com.warpradar.main;

import net.minecraft.init.Blocks;

import com.warpradar.registry.MainRegistry;
import com.warpradar.registry.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = WarpRadar.MODID, version = WarpRadar.VERSION, dependencies = "required-after:hbm")
public class WarpRadar {
    public static final String MODID = "warpradar";
    public static final String VERSION = "0.0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModItems.registerItems();
        MainRegistry.regSatellites();
    }
}
