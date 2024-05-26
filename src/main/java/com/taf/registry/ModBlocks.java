package com.taf.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.hbm.blocks.generic.BlockGeneric;
import com.taf.blocks.machines.BlockConverter;
import com.taf.blocks.misc.MetastableUraniumBlock;
import com.taf.main.Taf;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static Block converter;
    public static Block concrete_brick_legacy;
    public static Block block_u238m2;

    public static void initializeBlocks() {
        converter = new BlockConverter(Material.iron).setBlockName("converter")
            .setBlockTextureName(Taf.MODID + ":converter")
            .setCreativeTab(MainRegistry.BlocksTab);
        concrete_brick_legacy = new BlockGeneric(Material.iron).setBlockName("concrete_brick_legacy")
            .setBlockTextureName(Taf.MODID + ":concrete_brick_legacy")
            .setCreativeTab(MainRegistry.BlocksTab);
        block_u238m2 = new MetastableUraniumBlock().setBlockName("block_u238m2").setBlockTextureName(Taf.MODID + ":block_u238m2");

    }

    public static void registerBlocks() {
        initializeBlocks();
        GameRegistry.registerBlock(converter, converter.getUnlocalizedName());
        GameRegistry.registerBlock(concrete_brick_legacy, concrete_brick_legacy.getUnlocalizedName());
        GameRegistry.registerBlock(block_u238m2, block_u238m2.getUnlocalizedName());
    }
}
