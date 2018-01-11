package com.divinegenesis.Bewitcher;

import com.divinegenesis.Bewitcher.block.BlockRegistry;
import com.divinegenesis.Bewitcher.item.ItemRegistry;
import com.divinegenesis.Bewitcher.proxy.IProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		name = Reference.NAME, 
		modid = Reference.ID,
		version = Reference.VERSION
	)
public class Bewitcher 
{
	public static BewitcherTab tab = new BewitcherTab("bewitcher");
	
	@SidedProxy(serverSide = Reference.SERVER_PATH, clientSide = Reference.CLIENT_PATH)
	public static IProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		//MinecraftForge.EVENT_BUS.register(new EntityRegistry.RegistryHandler());
		MinecraftForge.EVENT_BUS.register(new BlockRegistry.RegistryHandler());
		MinecraftForge.EVENT_BUS.register(new ItemRegistry.RegistryHandler());
		proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
