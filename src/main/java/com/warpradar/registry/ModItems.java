package com.warpradar.registry;

import net.minecraft.item.Item;

import com.hbm.items.machine.ItemSatChip;
import com.warpradar.items.food.ItemEnergy;
import com.warpradar.main.WarpRadar;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item bottle_leninade;
    public static Item sat_luchik;
    public static Item sat_cumone;
    public static Item bedrock_wand;

    public static void initializeItems() {
        bottle_leninade = new ItemEnergy().makeBottle(com.hbm.items.ModItems.bottle_empty, null)
            .setUnlocalizedName("bottle_leninade")
            .setTextureName(WarpRadar.MODID + ":bottle_leninade")
            .setCreativeTab(MainRegistry.ItemsTab);
        sat_luchik = new ItemSatChip().setUnlocalizedName("sat_luchik")
            .setMaxStackSize(1)
            .setTextureName(WarpRadar.MODID + ":sat_luchik")
            .setCreativeTab(MainRegistry.ItemsTab);
        sat_cumone = new ItemSatChip().setUnlocalizedName("sat_cumone")
            .setMaxStackSize(1)
            .setTextureName(WarpRadar.MODID + ":sat_cumone")
            .setCreativeTab(MainRegistry.ItemsTab);
    }

    public static void registerItems() {
        initializeItems();
        GameRegistry.registerItem(bottle_leninade, bottle_leninade.getUnlocalizedName());
        GameRegistry.registerItem(sat_luchik, sat_luchik.getUnlocalizedName());
        GameRegistry.registerItem(sat_cumone, sat_cumone.getUnlocalizedName());
        GameRegistry.registerItem(bedrock_wand, bedrock_wand.getUnlocalizedName());
    }

}
