package com.divinegenesis.bewitcher.objects.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEJar extends TileEntity
{
	 private String soul = "";
	 
	 public boolean addSoul(String str)
	 {
		 if(soul == "" && !world.isRemote)
		 {
			 soul = str;
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean hasSoul()
	 {
		 return (soul != "");
	 }
	 
	 public String getSoulName()
	 {
		 return soul;
	 }
	 
	 
	 @Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	 {
		 super.writeToNBT(compound);
		 compound.setString("entity", soul); 
		return compound;
		}
	 
	 @Override
	public void readFromNBT(NBTTagCompound compound) 
	 {
		super.readFromNBT(compound);
		this.soul = compound.getString("entity");
	}
}