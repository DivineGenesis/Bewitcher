package com.divinegenesis.bewitcher.objects.blocks;

import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.objects.tileentity.TECauldron;
import com.divinegenesis.bewitcher.util.interfaces.IHasModel;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class BlockWitchCauldron extends BlockBase implements IHasModel, ITileEntityProvider
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
    public BlockWitchCauldron(String name, Material blockMaterial)
    {
        super(name, blockMaterial);  
        this.setTickRandomly(true); 
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.WITCHES_CAULDRON);
    }
    
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
    		EntityPlayer player) 
    { 
    	return new ItemStack(ModBlocks.WITCHES_CAULDRON);
    } 
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, //doesnt work yet
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
    {
    	if(playerIn.isSneaking() && !worldIn.isRemote)
    	{ 
    		playerIn.addItemStackToInventory(new ItemStack(Blocks.CAULDRON, 1));
    		worldIn.setBlockState(pos, ModBlocks.RACK.getDefaultState());
    		return true;
    	}
    	return false;
    } 
    
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) 
    {
    	for(int i = 0; i < 10; i++)
    	worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, pos.getX(), pos.getY()+ 0.5D, pos.getZ(), 0.0D, 0.0D, 0.0D, new int[0]);
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TECauldron();
	}
}