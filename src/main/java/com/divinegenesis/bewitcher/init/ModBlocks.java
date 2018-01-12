package com.divinegenesis.bewitcher.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;

import java.util.ArrayList;
import java.util.List;

import com.divinegenesis.bewitcher.objects.blocks.BlockMandrake;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final BlockCrops MANDRAKE_CROP = new BlockMandrake("mandrake_crop");
}
