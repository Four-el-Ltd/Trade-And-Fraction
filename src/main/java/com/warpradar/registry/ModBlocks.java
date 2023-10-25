package com.warpradar.registry;

import com.warpradar.blocks.machines.BlockConverter;
import com.warpradar.main.WarpRadar;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
  public static Block converter = new BlockConverter(Material.iron).setBlockName("converter")
      .setBlockTextureName(WarpRadar.MODID + ":converter").setCreativeTab(MainRegistry.BlocksTab);

  public static void registerBlocks() {
    GameRegistry.registerBlock(converter, converter.getUnlocalizedName());
  }
}
