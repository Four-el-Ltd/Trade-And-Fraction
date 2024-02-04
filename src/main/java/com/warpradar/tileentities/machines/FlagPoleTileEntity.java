package com.warpradar.tileentities.machines;

import com.hbm.tileentity.TileEntityLoadedBase;
import com.warpradar.misc.db.entity.Faction;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * FlagPole
 */
public class FlagPoleTileEntity extends TileEntityLoadedBase {
    private Faction owner;

    public FlagPoleTileEntity() {
        super();
    }

    @Override
    public void updateEntity() {
        if (!canSeeSky()) {
            worldObj.getBlock(xCoord, yCoord, zCoord)
                    .breakBlock(worldObj, xCoord, yCoord, zCoord, null, 0);
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    public void validate() {
        super.validate();
    }

    public Faction getOwner() {
        return owner;
    }

    public void setOwner(Faction newOwner) {
        owner = newOwner;
        // TODO: НБТ!
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        // TODO Auto-generated method stub
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setLong("owner", owner.getId());
        super.writeToNBT(nbt);
    }

    public boolean canSeeSky() {
        return worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord);
    }

    public void Claim(World world, EntityPlayer player) {
        if (Math.abs(xCoord - player.posX) < 2 && player.posY == yCoord && Math.abs(player.posZ - zCoord) < 2) {
            // TODO: клейм
        } else {
            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText(
                        "Для клейма необходимо: Находится на расстоянии в как минимум двух блоков от флагштока по всем осям кроме высота(высота должна быть одинаковой)"));
            }
            // TODO: Игрок идет нахуй
        }
    }

}
