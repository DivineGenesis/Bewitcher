package com.divinegenesis.Bewitcher.item;

import com.divinegenesis.Bewitcher.Bewitcher;

import net.minecraft.item.Item;

public class BaseItem extends Item
{
	public BaseItem(String unlocal, String registry) 
	{
		this.setUnlocalizedName(unlocal);
		this.setRegistryName(registry);
		this.setCreativeTab(Bewitcher.tab);
	}
}
