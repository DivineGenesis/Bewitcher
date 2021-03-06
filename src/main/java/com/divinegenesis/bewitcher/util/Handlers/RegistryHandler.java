package com.divinegenesis.bewitcher.util.Handlers;

import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.init.ModEntities;
import com.divinegenesis.bewitcher.init.ModItems;
import com.divinegenesis.bewitcher.objects.tileentity.TEJar;
import com.divinegenesis.bewitcher.util.Reference;
import com.divinegenesis.bewitcher.util.interfaces.IHasModel;
import com.divinegenesis.bewitcher.world.gen.WorldGenCustomStructures;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) 
	{
		for (Item item : ModItems.ITEMS) 
		{
			if (item instanceof IHasModel) 
			{
				((IHasModel) item).registerModels();
			}
		}

		for (Block block : ModBlocks.BLOCKS)
		{
			if (block instanceof IHasModel) 
			{
				((IHasModel) block).registerModels();
			}
		}
	}

	public static void preInitRegistries() 
	{
		ModEntities.registerEntities();
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
	}
	
	public static void initRegistries()
	{
		GameRegistry.registerTileEntity(TEJar.class, Reference.MOD_ID + "TileEntityJar");
	}
}