package com.divinegenesis.bewitcher.objects.blocks;

import java.util.Random;

import com.divinegenesis.bewitcher.objects.entities.EntityMandrake;
import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMandrake extends BlockCrops
{
	public BlockMandrake(String name) 
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);

		ModBlocks.BLOCKS.add(this);
	}

	@Override
	protected Item getSeed() 
	{
		return ModItems.MANDRAKE_SEED;
	}

	@Override
	protected Item getCrop() 
	{
		return null; // spawn Mandrake for crop
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if (isMaxAge(state)& !worldIn.isRemote) {
			Random rand = new Random();
			int x = rand.nextInt(100) + 1;
			if (x <= 75) //25% chance of no mandrake
			{
				EntityMandrake mandrake = new EntityMandrake(worldIn);
				mandrake.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 159, 62);
				worldIn.spawnEntity(mandrake);
			}
		}
	}
}
