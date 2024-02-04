package com.warpradar.tileentities.machines;

import com.hbm.tileentity.TileEntityLoadedBase;

/**
 * FlagPole
 */
public class FlagPole extends TileEntityLoadedBase {

    @Override
    public void updateEntity() {
        if (!canSeeSky()) {
            worldObj.getBlock(xCoord, yCoord, zCoord)
                .breakBlock(worldObj, xCoord, yCoord, zCoord, null, 0);
        }
    }

    @Override
    public void invalidate() {
        super.invalidat();
    }

    @Override
    public void validate() {
        super.validate();
    }

    public boolean canSeeSky() {
        return worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord);
    }

}
