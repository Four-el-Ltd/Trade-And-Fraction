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
    if (world.getTotalWorldTime() - lastOp < 12000) {
      return;
    }
    world.spawnEntityInWorld(EntityNukeExplosionMK5.statFacNoRad(world, 300, x, y, z));
    lastOp = world.getTotalWorldTime();

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
