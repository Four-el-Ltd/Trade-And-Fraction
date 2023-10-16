package com.warpradar.misc.satellites;

import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.saveddata.satellites.Satellite;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class luchik extends Satellite {
  public luchik() {
    this.satIface = Interfaces.SAT_COORD;
  }

  @Override
  public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {
    EntityNukeExplosionMK5.statFacNoRad(world, 1000, x, y, z);
  }

}
