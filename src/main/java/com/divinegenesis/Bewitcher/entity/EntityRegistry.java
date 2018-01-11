package com.divinegenesis.Bewitcher.entity;

import java.util.ArrayList;

import com.divinegenesis.Bewitcher.entity.monster.EntityMandrake;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class EntityRegistry 
{
	public static final EntityEntry mandrake = new EntityEntry(EntityMandrake.class, "mandrake");
	
	@EventBusSubscriber
	public static class RegistryHandler
	{
		public static ArrayList<EntityEntry> entity = new ArrayList<EntityEntry>(); 
		
		@SubscribeEvent
		public void registerBlocks(RegistryEvent.Register<EntityEntry> event)
		{
			
			for(EntityEntry e : entity)
				event.getRegistry().register(e);
		}
	}
}
