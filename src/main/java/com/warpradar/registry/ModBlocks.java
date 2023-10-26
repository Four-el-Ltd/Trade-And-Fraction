package com.warpradar.registry;

import com.hbm.blocks.generic.BlockConcreteColored;
import com.warpradar.blocks.machines.BlockConverter;
import com.warpradar.main.WarpRadar;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
  public static Block converter;
  public static Block concrete_brick_legacy;

  public static void initializeBlocks() {
    converter = new BlockConverter(Material.iron).setBlockName("converter")
        .setBlockTextureName(WarpRadar.MODID + ":converter").setCreativeTab(MainRegistry.BlocksTab);
    concrete_brick_legacy = new BlockConcreteColored(Material.iron).setBlockName("concrete_brick_legacy")
        .setBlockTextureName(WarpRadar.MODID + ":concrete_brick_legacy").setCreativeTab(MainRegistry.BlocksTab);

  }

  public static void registerBlocks() {
    initializeBlocks();
    GameRegistry.registerBlock(converter, converter.getUnlocalizedName());
    GameRegistry.registerBlock(concrete_brick_legacy, concrete_brick_legacy.getUnlocalizedName());
  }
}
