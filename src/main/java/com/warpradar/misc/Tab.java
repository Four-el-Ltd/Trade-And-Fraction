package com.warpradar.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tab extends CreativeTabs {
  private Item icon;

  public Tab(int i, String i2, Item icon) {
    super(i, i2);
    this.icon = icon;
  }

  @Override
  public Item getTabIconItem() {
    return this.icon;
  }
}
