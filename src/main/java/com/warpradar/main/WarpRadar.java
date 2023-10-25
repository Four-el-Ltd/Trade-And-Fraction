package com.warpradar.main;

import net.minecraft.init.Blocks;

import com.warpradar.registry.MainRegistry;
import com.warpradar.registry.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = WarpRadar.MODID, name = WarpRadar.NAME, version = WarpRadar.VERSION, dependencies = "required-after:hbm")
public class WarpRadar {
    public static final String MODID = "warpradar";
    public static final String NAME = "Warp Radar";
    public static final String VERSION = "0.0.2";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
            if (Class.forName("com.hfr.main.MainRegistry") != null) {
                throw new IllegalStateException("Пидор ебанный");
            }
        } catch (ClassNotFoundException e) {

        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModItems.registerItems();
        MainRegistry.regSatellites();
    }
}
