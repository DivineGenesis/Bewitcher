package com.divinegenesis.bewitcher.Objects.blocks;

import com.divinegenesis.bewitcher.Main;
import com.divinegenesis.bewitcher.init.ModBlocks;
import com.divinegenesis.bewitcher.init.ModItems;
import com.divinegenesis.bewitcher.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{

    public BlockBase(String name, Material material){
        super (material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}


