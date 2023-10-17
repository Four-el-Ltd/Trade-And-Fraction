package com.warpradar.misc.satellites;

import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.entity.effect.EntityNukeTorex;
import com.hbm.saveddata.satellites.Satellite;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class luchik extends Satellite {
  public luchik() {
    this.satIface = Interfaces.SAT_COORD;
  }

  @Override
  public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {
    world.spawnEntityInWorld(EntityNukeExplosionMK5.statFacNoRad(world, 300, x, y, z));
    EntityNukeTorex.statFac(world, x + 0.5, y + 0.5, z + 0.5, 300.0F);

  }

}
