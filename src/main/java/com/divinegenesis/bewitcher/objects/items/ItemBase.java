package com.divinegenesis.bewitcher.objects.items;

import com.divinegenesis.bewitcher.Main;
import com.divinegenesis.bewitcher.init.ModItems;
import com.divinegenesis.bewitcher.util.BewitcherTab;
import com.divinegenesis.bewitcher.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(BewitcherTab.bewitchertab);

		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}