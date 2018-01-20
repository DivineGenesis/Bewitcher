package com.divinegenesis.bewitcher.objects.entities;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityMandrake extends EntityMob
{
	public EntityMandrake(World world)
	{
		super(world);
		this.setSize(0.6F, 0.75F);
	}
}