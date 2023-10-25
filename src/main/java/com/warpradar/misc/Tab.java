package com.warpradar.misc;

import com.warpradar.main.WarpRadar;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tab extends CreativeTabs {
  private Item icon;

  public Tab(Item icon, String name) {
    super(name);
    this.icon = icon;
  }

  @Override
  public Item getTabIconItem() {
    return this.icon;
  }
}
