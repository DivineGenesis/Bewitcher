package com.divinegenesis.bewitcher.objects.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBroom extends EntityMob
{

	public EntityBroom(World worldIn) {
		super(worldIn);  
		this.setEntityInvulnerable(true);
	}
 

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		if(entityIn instanceof EntityPlayer)
			return true;
		return false;
	} 
	
	
	
	
	
	
}
