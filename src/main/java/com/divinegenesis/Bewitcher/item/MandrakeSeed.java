package com.divinegenesis.Bewitcher.item;

import com.divinegenesis.Bewitcher.Bewitcher;
import com.divinegenesis.Bewitcher.block.BlockRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class MandrakeSeed extends ItemSeeds
{
	public MandrakeSeed(String unlocalized, String registry) 
	{
		super(BlockRegistry.mandrake, Blocks.FARMLAND);
		this.setUnlocalizedName(unlocalized);
		this.setRegistryName(registry);
		this.setCreativeTab(Bewitcher.tab);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return EnumPlantType.Crop;
	}
}
