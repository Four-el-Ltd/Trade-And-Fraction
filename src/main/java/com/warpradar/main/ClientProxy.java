package com.warpradar.main;

import net.minecraft.client.Minecraft;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * ClientProxy
 *
 * Обрабатывает события просходящие на стороне клиента
 * Сами события аналогичны {@link WarpRadar}
 * 
 */

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        if (Minecraft.getMinecraft().thePlayer.getDisplayName()
            .equals("MetalloloM")) {
            throw new IllegalStateException("Верни варприфт гий");
        }
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
