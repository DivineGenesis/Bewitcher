package com.divinegenesis.bewitcher.util;

import com.divinegenesis.bewitcher.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BewitcherTab extends CreativeTabs
{
    public static final CreativeTabs bewitchertab = new BewitcherTab("bewitchertab");

    public BewitcherTab(String label) {
        super("bewitchertab");
    }
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.MANDRAKE_ROOT);
    }

}