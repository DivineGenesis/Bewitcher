package com.divinegenesis.bewitcher.util.Handlers;

import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.objects.entities.EntitySoul;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler 
{
	
	@SubscribeEvent
	public static void onMobDeath(LivingDeathEvent event)
	{ 
		if( (event.getSource().getTrueSource() instanceof EntityPlayer) && !(event.getEntity() instanceof EntitySoul) && !event.getEntity().getEntityWorld().isRemote)
		{
			BlockPos pos = event.getEntity().getPosition();
			EntitySoul soul = new EntitySoul(event.getEntity().world);
			NBTTagCompound nbt = event.getEntity().getEntityData();
			nbt.setString("entity", event.getEntity().getName());
			soul.writeToNBT(nbt);//setSoul(event.getEntity().getName());
			soul.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 159, 62);
			event.getEntity().getEntityWorld().spawnEntity(soul);
		}
	}

	@SubscribeEvent
	public static void onEntityInteract(EntityInteract event)
	{
		if( !event.getWorld().isRemote && event.getTarget() instanceof EntitySoul && event.getItemStack().isItemEqual(new ItemStack(ModBlocks.JAR)))
		{
			EntitySoul soul = (EntitySoul) event.getTarget();
			NBTTagCompound nbt;
			if(event.getItemStack().hasTagCompound())
			{
				nbt = event.getItemStack().getTagCompound();
			}
			else
			{
				nbt = new NBTTagCompound();
			}
			 
			nbt.setString("entity", soul.getSoul()); 
			event.getTarget().setDead();
			
			ItemStack stack = new ItemStack(ModBlocks.JAR, 1);
			stack.setTagCompound(nbt);
			event.getItemStack().setCount(event.getItemStack().getCount()-1);
			event.getEntityPlayer().inventory.addItemStackToInventory(stack);
		}
	}
}
