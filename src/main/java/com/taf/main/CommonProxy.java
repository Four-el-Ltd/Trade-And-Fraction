package com.taf.main;

import com.taf.config.FluidConvertorConfig;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * CommonProxy
 *
 * Обрабатывает события происходящие на стороне сервера и клиента
 * Сами события аналогичны {@link TaF}
 */

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        FluidConvertorConfig.initialize();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void onServerStarting(FMLServerStartingEvent event) {}
}
