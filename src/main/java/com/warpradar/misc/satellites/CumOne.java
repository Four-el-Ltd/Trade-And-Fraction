package com.warpradar.misc.satellites;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.hbm.entity.projectile.EntityMeteor;
import com.hbm.saveddata.satellites.Satellite;

public class CumOne extends Satellite {

    public CumOne() {
        this.satIface = Interfaces.SAT_COORD;
    }

    @Override
    public void onCoordAction(World world, EntityPlayer player, int x, int y, int z) {
        if (!world.isRemote) {
            EntityMeteor meteor = new EntityMeteor(world);
            meteor.setPositionAndRotation(x, 384, z, 0, 0);
            world.spawnEntityInWorld(meteor);
        }
    }
}
