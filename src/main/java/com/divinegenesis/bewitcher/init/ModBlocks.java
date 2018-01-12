package com.divinegenesis.bewitcher.init;

import com.divinegenesis.bewitcher.objects.blocks.BlockBase;
import com.divinegenesis.bewitcher.objects.blocks.BlockWitchCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockCrops;

import java.util.ArrayList;
import java.util.List;

import com.divinegenesis.bewitcher.objects.blocks.BlockMandrake;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final BlockCrops MANDRAKE_CROP = new BlockMandrake("mandrake_crop");
	public static final BlockCauldron WITCHES_CAULDRON = new BlockWitchCauldron("witches_cauldron");
}
