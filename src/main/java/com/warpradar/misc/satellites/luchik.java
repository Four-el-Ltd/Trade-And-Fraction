package com.warpradar.misc.satellites;

import com.hbm.entity.logic.EntityNukeExplosionMK5;
import com.hbm.saveddata.satellites.Satellite;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class luchik extends Satellite {
  public long lastOp;

  public luchik() {
    this.satIface = Interfaces.SAT_COORD;
  }

  @Override
  public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {
    if (lastOp + (10 * 60 * 1000) < System.currentTimeMillis()) {
      world.spawnEntityInWorld(EntityNukeExplosionMK5.statFacNoRad(world, 300, x, y, z));
      lastOp = System.currentTimeMillis();
    }

  }

  @Override
  public void writeToNBT(NBTTagCompound nbt) {
    nbt.setLong("lastOp", lastOp);
  }

  @Override
  public void readFromNBT(NBTTagCompound nbt) {
    lastOp = nbt.getLong("lastOp");
  }
}
