package com.divinegenesis.bewitcher.objects.blocks;

import com.divinegenesis.bewitcher.objects.tileentity.TECandle;

import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandle extends BlockBase implements ITileEntityProvider
{
	private final EnumDyeColor color = EnumDyeColor.WHITE;
	
	public BlockCandle(String name, Material material) 
	{
		super(name, material);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{ 
		return EnumBlockRenderType.MODEL; 
	}
	
	@Override
	public boolean isFullBlock(IBlockState state)
	{ 
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state)
	{ 
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{ 
		return false; 
	}
	
	@Override
	public BlockRenderLayer getBlockLayer()
	{ 
		return BlockRenderLayer.TRANSLUCENT; 
	}
	
	@Override
	public int getLightValue(IBlockState state)
	{ 
		return 15; 
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TECandle(this.color);
	}
	
	public static Block getBlockByColor(EnumDyeColor colorIn)
    {
        switch (colorIn)
        {
            case WHITE:
            	default:
                return Blocks.WHITE_SHULKER_BOX;
            case ORANGE:
                return Blocks.ORANGE_SHULKER_BOX;
            case MAGENTA:
                return Blocks.MAGENTA_SHULKER_BOX;
            case LIGHT_BLUE:
                return Blocks.LIGHT_BLUE_SHULKER_BOX;
            case YELLOW:
                return Blocks.YELLOW_SHULKER_BOX;
            case LIME:
                return Blocks.LIME_SHULKER_BOX;
            case PINK:
                return Blocks.PINK_SHULKER_BOX;
            case GRAY:
                return Blocks.GRAY_SHULKER_BOX;
            case SILVER:
                return Blocks.SILVER_SHULKER_BOX;
            case CYAN:
                return Blocks.CYAN_SHULKER_BOX;
            case PURPLE:
                return Blocks.PURPLE_SHULKER_BOX;
            case BLUE:
                return Blocks.BLUE_SHULKER_BOX;
            case BROWN:
                return Blocks.BROWN_SHULKER_BOX;
            case GREEN:
                return Blocks.GREEN_SHULKER_BOX;
            case RED:
                return Blocks.RED_SHULKER_BOX;
            case BLACK:
                return Blocks.BLACK_SHULKER_BOX;
        }
    }

    @SideOnly(Side.CLIENT)
    public static EnumDyeColor getColorFromItem(Item itemIn)
    {
        return getColorFromBlock(Block.getBlockFromItem(itemIn));
    }

    public static ItemStack getColoredItemStack(EnumDyeColor colorIn)
    {
        return new ItemStack(getBlockByColor(colorIn));
    }
    
    @SideOnly(Side.CLIENT)
    public static EnumDyeColor getColorFromBlock(Block blockIn)
    {
        return blockIn instanceof BlockShulkerBox ? ((BlockShulkerBox)blockIn).getColor() : EnumDyeColor.WHITE;
    }
}