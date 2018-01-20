package com.divinegenesis.bewitcher.objects.entities;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySoul extends EntityMob
{
	private String entity;
	
	public EntitySoul(World worldIn, String entity) 
	{
		super(worldIn);
		this.entity = entity;
	}
	
	public EntitySoul(World worldIn) 
	{
		super(worldIn);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setString("entity", this.entity);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readEntityFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		// TODO Auto-generated method stub
		this.entity = compound.getString("entity");
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
	}
	
	public String getSoul()
	{
		return this.entity;
	}
	
	public void setSoul(String soul)
	{
		this.entity = soul;
	}

}
