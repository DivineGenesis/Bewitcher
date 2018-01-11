package com.divinegenesis.Bewitcher.block;

import com.divinegenesis.Bewitcher.item.ItemRegistry;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMandrake extends BlockCrops
{
	public BlockMandrake(Material materialIn) 
	{
		super();
	} 
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		if(worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.FARMLAND))
			return true;
		return false;
	} 
	
	@Override
	protected Item getSeed()
    {
        return ItemRegistry.mandrakeSeed;
    }

	@Override
    protected Item getCrop()
    {
        return null; //spawn Mandrake for crop
    }
}
