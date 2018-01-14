package com.divinegenesis.bewitcher.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

public class BlockCandle extends BlockBase
{

	public BlockCandle(String name, Material material) {
		super(name, material);
		this.setLightLevel(15);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getLightValue(IBlockState state) {
		// TODO Auto-generated method stub
		return 15;
	}

}
