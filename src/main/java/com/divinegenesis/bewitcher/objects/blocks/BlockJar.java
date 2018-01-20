package com.divinegenesis.bewitcher.objects.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.objects.tileentity.TEJar;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockJar extends BlockBase implements ITileEntityProvider
{
	private final AxisAlignedBB AABB = new AxisAlignedBB(4/16D, 0D, 4/16D, 12/16D, 8/16D, 12/16D);
	
	public BlockJar(String name, Material materialIn) 
	{
		super(name, materialIn); 
		
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) { return AABB; }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) { return AABB; }
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) { return EnumBlockRenderType.MODEL; }
	
	@Override
	public BlockRenderLayer getBlockLayer() { return BlockRenderLayer.TRANSLUCENT; }
	
	@Override
	public boolean isFullBlock(IBlockState state) { return false; }
	
	@Override
	public boolean isTranslucent(IBlockState state) { return true; }
	
	@Override
	public boolean isOpaqueCube(IBlockState state) { return false; }
	
	@Override
	public boolean isFullCube(IBlockState state) { return false; }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){ return new TEJar(); }
	
	private TEJar getTE(World world, BlockPos pos)
	{
		return (TEJar) world.getTileEntity(pos);
	}
	 
	@Override
	public boolean hasTileEntity() 
	{
		return true;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) 
	{
		ItemStack stack = new ItemStack(this, 1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("entity", getTE(world, pos).getSoulName());
		stack.setTagCompound(nbt);
		return stack;
	}
	 @Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune)
	 { 
		 TEJar te = world.getTileEntity(pos) instanceof TEJar ? (TEJar)world.getTileEntity(pos) : null;
	        if (te != null)
	        {
	        	ItemStack stack = new ItemStack(ModBlocks.JAR, 1);
	        	NBTTagCompound nbt =  new NBTTagCompound();
	        	nbt.setString("entity", te.getSoulName());
	        	stack.setTagCompound(nbt);
	            drops.add(stack); 
	        }
	} 
	 
	 @Override
	    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	    {
	        if (willHarvest) return true;
	       // world.removeTileEntity(pos);//If it will harvest, delay deletion of the block until after getDrops
	        return super.removedByPlayer(state, world, pos, player, willHarvest);
	    } 
	 
	 @Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) 
	 {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		TEJar jar = worldIn.getTileEntity(pos) instanceof TEJar ? (TEJar)worldIn.getTileEntity(pos) : null;
		if(jar != null)
		{	
			NBTTagCompound nbt;
			if(stack.hasTagCompound()) nbt = stack.getTagCompound();
			else
			{
				nbt = new NBTTagCompound();
				nbt.setString("entity", "");
			}
			jar.addSoul(nbt.getString("entity"));
		}
	}
	 
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) 
	{
		super.addInformation(stack, player, tooltip, advanced);
		NBTTagCompound nbt; 
		if(stack.hasTagCompound())
			nbt = stack.getTagCompound();
		else
		{
			nbt = new NBTTagCompound();
			nbt.setString("entity", "");
		}
		
		if(nbt.getString("entity") != "")
			tooltip.add(nbt.getString("entity"));
		else
			tooltip.add("<EMPTY>");
	}
	
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		TileEntity te = worldIn.getTileEntity(pos);
		if(te instanceof TEJar)
		{
			TEJar jar = (TEJar) te;
			if(jar.hasSoul())
				for(int i = 0; i < 10; i++)
			    	worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, pos.getX(), pos.getY()+ 0.5D, pos.getZ(), 0.0D, 0.0D, 0.0D, new int[0]);
		}
	}
	
	@Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack tool)
    {
        super.harvestBlock(world, player, pos, state, te, tool);
        world.setBlockToAir(pos);
    }
}