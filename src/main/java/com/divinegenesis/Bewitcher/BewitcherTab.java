package com.divinegenesis.Bewitcher;

import com.divinegenesis.Bewitcher.item.ItemRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BewitcherTab extends CreativeTabs
{

	public BewitcherTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemRegistry.mandrake);
	}

}
