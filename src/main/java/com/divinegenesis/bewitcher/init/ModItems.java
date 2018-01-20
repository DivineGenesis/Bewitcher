package com.divinegenesis.bewitcher.init;

import com.divinegenesis.bewitcher.objects.items.ItemBase;
import com.divinegenesis.bewitcher.objects.items.ItemMandrakeSeed;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item MANDRAKE_ROOT = new ItemBase("mandrake_root");
	public static final Item MANDRAKE_SEED = new ItemMandrakeSeed("mandrake_seed");
	public static final Item GUN = new ItemMandrakeSeed("gun");
	
	public static final Item WOOL_BAT = new ItemBase("wool_bat");
	public static final Item TONGUE_DOG = new ItemBase("tongue_dog");
	public static final Item TOOTH_DOG = new ItemBase("tooth_dog");
	public static final Item SCALE_DRAGON = new ItemBase("scale_dragon");
	public static final Item WOLF_BANE_SEED = new ItemBase("wolf_bane_seed");
}