package com.divinegenesis.bewitcher.util.Handlers;

import com.divinegenesis.bewitcher.objects.entities.EntitySoul;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler 
{
	
	@SubscribeEvent
	public static void onMobDeath(LivingDeathEvent event)
	{ 
		if( !event.getEntity().getEntityWorld().isRemote)
		if((event.getSource().getTrueSource() instanceof EntityPlayer) && !(event.getEntity() instanceof EntitySoul) )
		{
			System.out.println("DEAD"); 
			BlockPos pos = event.getEntity().getPosition();
			EntitySoul soul = new EntitySoul(event.getEntity().world);
			soul.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 159, 62);
			event.getEntity().getEntityWorld().spawnEntity(soul);
		}
		
	}
}
