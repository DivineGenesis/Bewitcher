package com.divinegenesis.bewitcher.objects.blocks;

import com.divinegenesis.bewitcher.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRack extends BlockBase
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockRack(String name, Material material)
	{
		super(name, material);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		 //doesnt work yet
		if(playerIn.getHeldItemMainhand().isItemEqual(new ItemStack(Blocks.CAULDRON)))
		{
			worldIn.setBlockState(pos, ModBlocks.WITCHES_CAULDRON.getDefaultState());
			return true;
		}
		return false;
	}

}
