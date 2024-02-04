package com.warpradar.main;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.warpradar.registry.MainRegistry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * WarpRadar
 * 
 * Главный класс мода
 * Здесь обрабаываются этапы запуска игры а также устанавливаются некотоыре
 * константы
 *
 * Сами этапы:
 * Метод preInit - Пре-инициализация игры(начинается сразу послк запуска форджа)
 * Метод init - Инициализация игры(начинается по окончанию пре-инициализации)
 * Метод postInit - пост-инициализация игры(начинаетчя по окончанию
 * инициализации)
 * 
 */

@Mod(modid = WarpRadar.MODID, name = WarpRadar.NAME, version = WarpRadar.VERSION, dependencies = "required-after:hbm")
public class WarpRadar {

    public static String databaseUrl;
    public static final String MODID = "warpradar";
    public static final String NAME = "Warp Radar";
    public static final String VERSION = "0.0.2";

    @SidedProxy(clientSide = "com.warpradar.main.ClientProxy", serverSide = "com.warpradar.main.CommonProxy")
    public static CommonProxy proxy;

    @Metadata
    public static ModMetadata meta;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        MainRegistry.register();
        try {
            if (Class.forName("com.hfr.main.MainRegistry") != null) {
                throw new IllegalStateException("xRadar is forbidden. Fuck you");
            }
        } catch (ClassNotFoundException e) {

        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event) throws SQLException {
        proxy.onServerStarting(event);
    }

    public static ConnectionSource getConnectionSource() {
        ConnectionSource cs;
        try {
            cs = new JdbcConnectionSource(databaseUrl);
        } catch (SQLException e) {
            throw new IllegalStateException("Товарищ шота не так");
        }
        return cs;
    }
}
