package com.warpradar.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Tab
 * Класс всех креативных вкладок
 * Ничего большкч
 */

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
