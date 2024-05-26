package com.taf.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.hbm.blocks.generic.BlockGeneric;
import com.taf.blocks.machines.BlockConverter;
import com.taf.blocks.misc.MetastableUraniumBlock;
import com.taf.main.TaF;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static Block fluid_converter;
    public static Block concrete_brick_legacy;
    public static Block block_u238m2;

    public static void initializeBlocks() {
        fluid_converter = new BlockConverter(Material.iron).setBlockName("fluid_converter")
            .setBlockTextureName(TaF.MODID + ":fluid_converter")
            .setCreativeTab(MainRegistry.BlocksTab);
        concrete_brick_legacy = new BlockGeneric(Material.iron).setBlockName("concrete_brick_legacy")
            .setBlockTextureName(TaF.MODID + ":concrete_brick_legacy")
            .setCreativeTab(MainRegistry.BlocksTab);
        block_u238m2 = new MetastableUraniumBlock().setBlockName("block_u238m2").setBlockTextureName(TaF.MODID + ":block_u238m2");

    }

    public static void registerBlocks() {
        initializeBlocks();
        GameRegistry.registerBlock(fluid_converter, fluid_converter.getUnlocalizedName());
        GameRegistry.registerBlock(concrete_brick_legacy, concrete_brick_legacy.getUnlocalizedName());
        GameRegistry.registerBlock(block_u238m2, block_u238m2.getUnlocalizedName());
    }
}
