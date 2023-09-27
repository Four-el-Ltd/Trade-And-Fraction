package com.warpradar.registry;

import com.warpradar.items.food.ItemEnergy;
import com.warpradar.main.WarpRadar;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
  public static final Item bottle_leninade = new ItemEnergy().makeBottle(com.hbm.items.ModItems.bottle_empty, null)
      .setUnlocalizedName("bottle_leninade").setTextureName(WarpRadar.MODID + ":bottle_leninade");

  public static void registerItems() {
    GameRegistry.registerItem(bottle_leninade, bottle_leninade.getUnlocalizedName());
  }
}
