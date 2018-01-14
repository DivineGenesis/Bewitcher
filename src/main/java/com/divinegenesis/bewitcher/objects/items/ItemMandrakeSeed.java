package com.divinegenesis.bewitcher.objects.items;

import com.divinegenesis.bewitcher.Main;
import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.init.ModItems;
import com.divinegenesis.bewitcher.util.BewitcherTab;
import com.divinegenesis.bewitcher.util.interfaces.IHasModel;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemMandrakeSeed extends ItemSeeds implements IHasModel {

	public ItemMandrakeSeed(String name) {
		super(ModBlocks.MANDRAKE_CROP, Blocks.FARMLAND);
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
