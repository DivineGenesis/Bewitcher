package com.divinegenesis.bewitcher.world.gen.generators;

import java.util.Random;

import com.divinegenesis.bewitcher.util.Reference;
import com.divinegenesis.bewitcher.util.interfaces.IStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenStructure extends WorldGenerator implements IStructure 
{

	public static String structName;
	
	public WorldGenStructure(String name) 
	{
		this.structName = name;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		this.generateStructure(worldIn, position);
		return true;
	}
	
	public static void generateStructure(World world, BlockPos pos)
	{
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = WORLD_SERVER.getStructureTemplateManager();
		ResourceLocation loc = new ResourceLocation(Reference.MOD_ID, structName);
		Template template = manager.get(mcServer, loc);
		
		if(template != null)
		{
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, SETTINGS);
		}
	}

}
