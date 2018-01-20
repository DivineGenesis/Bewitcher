package com.divinegenesis.bewitcher.init;

import com.divinegenesis.bewitcher.objects.blocks.BlockCandle;
import com.divinegenesis.bewitcher.objects.blocks.BlockJar;
import com.divinegenesis.bewitcher.objects.blocks.BlockWitchCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;

import java.util.ArrayList;
import java.util.List;

import com.divinegenesis.bewitcher.objects.blocks.BlockMandrake;
import com.divinegenesis.bewitcher.objects.blocks.BlockRack;

import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final BlockCrops MANDRAKE_CROP = new BlockMandrake("mandrake_crop");
	public static final BlockWitchCauldron WITCHES_CAULDRON = new BlockWitchCauldron("witches_cauldron", Material.IRON );
	public static final BlockCandle CANDLE = new BlockCandle("candle", Material.CLAY);
	public static final BlockJar JAR = new BlockJar("jar", Material.WOOD);
	public static final BlockRack RACK = new BlockRack("rack", Material.WOOD);
}