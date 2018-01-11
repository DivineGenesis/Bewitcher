package com.divinegenesis.Bewitcher.block;

import java.util.ArrayList;

import com.divinegenesis.Bewitcher.Reference;
import com.divinegenesis.Bewitcher.Reference.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockRegistry 
{	
	public static final Block mandrake = new BlockMandrake(Material.GRASS).setUnlocalizedName(blocks.MANDRAKE.getUnlocalizedName()).setRegistryName(blocks.MANDRAKE.getRegistryName());
	
	@EventBusSubscriber(modid = Reference.ID)
	public static class RegistryHandler
	{
		public static ArrayList<Block> blocks = new ArrayList<Block>(); 
		public static ArrayList<ItemBlock> items = new ArrayList<ItemBlock>(); 
		
		@SubscribeEvent
		public void registerBlocks(RegistryEvent.Register<Block> event)
		{
			blocks.add(mandrake);
			
			for(Block b : blocks)
				event.getRegistry().register(b);
		}
		
		@SubscribeEvent
		public void registerItemBlocks(RegistryEvent.Register<Item> event)
		{
			items.add(new ItemBlock(mandrake));
			
			for(ItemBlock i : items)
			{
				ResourceLocation registry = i.getBlock().getRegistryName();
				event.getRegistry().register(i.setRegistryName(registry));
				
			}
		}
	}
}
