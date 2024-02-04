package com.warpradar.main;

import java.nio.file.Path;
import java.sql.SQLException;

import net.minecraftforge.common.DimensionManager;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.warpradar.misc.db.entity.Faction;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * CommonProxy
 *
 * Обрабатывает события происходящие на стороне сервера и клиента
 * Сами события аналогичны {@link WarpRadar}
 */

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void onServerStarting(FMLServerStartingEvent event) throws SQLException {
        Path path = DimensionManager.getCurrentSaveRootDirectory()
            .toPath()
            .resolve(
                event.getServer()
                    .getEntityWorld()
                    .getWorldInfo()
                    .getWorldName());
        WarpRadar.databaseUrl = "jbdc:sqlite:" + path.toString() + "/warpradar.db";

        ConnectionSource cSource = WarpRadar.getConnectionSource();
        TableUtils.createTable(cSource, Faction.class);

    }
}
