package com.divinegenesis.bewitcher.objects.tileentity;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;

public class TECandle extends TileEntity
{
	private EnumDyeColor color;
	private boolean lit = false;
	
	public TECandle(EnumDyeColor color) 
	{
		this.color = color;
	}
	
	
	public boolean isLit() { return lit; }
}
