package com.divinegenesis.Bewitcher.item;

import com.divinegenesis.Bewitcher.Reference;
import com.divinegenesis.Bewitcher.Reference.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemRegistry 
{
	public static final Item 
		mandrakeSeed = new MandrakeSeed(items.MANDRAKE_SEED.getUnlocalizedName(), items.MANDRAKE_SEED.getRegistryName()),
		mandrake = new BaseItem(items.MANDRAKE.getUnlocalizedName(), items.MANDRAKE.getRegistryName());
	
	@EventBusSubscriber(modid = Reference.ID)
	public static class RegistryHandler
	{
		@SubscribeEvent
		public void itemRegistry(RegistryEvent.Register<Item> event)
		{
			event.getRegistry().register(mandrakeSeed);
			event.getRegistry().register(mandrake);
		}
	}
	
	public static void registerRenders()
		{
			registerRender(mandrake);
			registerRender(mandrakeSeed);
		}
	private static void registerRender(Item item)
	{
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
	}
}
