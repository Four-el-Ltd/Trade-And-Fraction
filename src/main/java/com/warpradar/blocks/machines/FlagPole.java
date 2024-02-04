package com.warpradar.blocks.machines;

import com.warpradar.tileentities.machines.FlagPoleTileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * FlagPole
 */
public class FlagPole extends BlockContainer {

    /**
     * @param material
     */
    protected FlagPole(Material material) {
        super(material);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new FlagPoleTileEntity();
    }

}
