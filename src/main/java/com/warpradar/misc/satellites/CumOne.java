package com.warpradar.misc.satellites;

import com.hbm.handler.BossSpawnHandler;
import com.hbm.saveddata.satellites.Satellite;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CumOne extends Satellite {
  public CumOne() {
    this.satIface = Interfaces.SAT_COORD;
  }

  @Override
  public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {
    if (!world.isRemote) {
      BossSpawnHandler.meteorShower = 1000000;
      BossSpawnHandler.spawnMeteorAtPlayer(player, false);
    }
  }
}
