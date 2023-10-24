package com.warpradar.blocks.machines;

import com.hbm.items.machine.IItemFluidIdentifier;
import com.warpradar.registry.MainRegistry;
import com.warpradar.tileentities.machines.TileEntityConverter;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConverter extends BlockContainer {
  public BlockConverter(Material mat) {
    super(mat);
    setCreativeTab(MainRegistry.BlocksTab);
  }

  @Override
  public TileEntity createNewTileEntity(World world, int meta) {
    return new TileEntityConverter();
  }

  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float fX, float fY,
      float fZ) {
    TileEntity te = world.getTileEntity(x, y, z);
    if (player.getHeldItem().getItem() instanceof IItemFluidIdentifier && te instanceof TileEntityConverter) {
      IItemFluidIdentifier id = (IItemFluidIdentifier) player.getHeldItem().getItem();
      TileEntityConverter tec = (TileEntityConverter) te;
      tec.bobtank.setTankType(id.getType(world, x, y, z, player.getHeldItem()));
      return true;
    }
    return false;
  }
}
