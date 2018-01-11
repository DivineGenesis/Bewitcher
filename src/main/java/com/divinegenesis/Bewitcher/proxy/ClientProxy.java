package com.divinegenesis.Bewitcher.proxy;

import com.divinegenesis.Bewitcher.item.ItemRegistry;

public class ClientProxy implements IProxy
{

	@Override
	public void preInit() 
	{
		
	}

	@Override
	public void init() 
	{
		ItemRegistry.registerRenders();
	}

	@Override
	public void postInit() 
	{
		
	}
}
