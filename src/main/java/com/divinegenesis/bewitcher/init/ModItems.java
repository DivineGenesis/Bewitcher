package com.divinegenesis.bewitcher.init;

import com.divinegenesis.bewitcher.objects.items.ItemBase;
import com.divinegenesis.bewitcher.objects.items.ItemMandrakeSeed;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item MANDRAKE_ROOT = new ItemBase("mandrake_root");
	public static final Item MANDRAKE_SEED = new ItemMandrakeSeed("mandrake_seed");
}