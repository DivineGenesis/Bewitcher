package com.divinegenesis.bewitcher.objects.blocks;

import com.divinegenesis.bewitcher.Main;
import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.init.ModItems;
import com.divinegenesis.bewitcher.util.BewitcherTab;
import com.divinegenesis.bewitcher.util.IHasModel;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Random;

public class BlockWitchCauldron extends BlockCauldron implements IHasModel{
    public BlockWitchCauldron(String name)
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(BewitcherTab.bewitchertab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.WITCHES_CAULDRON);
    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
