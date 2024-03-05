package com.warpradar.registry;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;

import com.warpradar.tileentities.machines.TileEntityConverter;

public class TileMappings {

    public static HashMap<Class<? extends TileEntity>, String[]> map = new HashMap();

    public static void writeMappings() {
        put(TileEntityConverter.class, "tileentity_converter");
    }

    private static void put(Class<? extends TileEntity> cl, String... names) {
        map.put(cl, names);
    }
}
