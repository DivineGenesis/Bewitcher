package com.divinegenesis.Bewitcher;

public class Reference 
{
	public static final String NAME = "Bewitcher";
	public static final String ID = "bewitcher";
	public static final String VERSION = "1.0";
	public static final String SERVER_PATH = "com.divinegenesis.Bewitcher.proxy.ServerProxy";
	public static final String CLIENT_PATH = "com.divinegenesis.Bewitcher.proxy.ClientProxy";
	
	public static enum items
	{
		MANDRAKE_SEED("mandrake_seed", "mandrakeSeed"),
		MANDRAKE("mandrake", "itemMandrake");
		
		private String unlocalizedName, registryName;
		
		private items(String unlocal, String registry) 
		{
			unlocalizedName = unlocal;
			registryName = registry;
		}
		
		public String getUnlocalizedName()
		{
			return unlocalizedName;
		}
		
		public String getRegistryName()
		{
			return registryName;
		}
	}
	
	public static enum blocks
	{
		MANDRAKE("mandrake", "blockMandrake");
		
		private String unlocalizedName, registryName;
		
		private blocks(String unlocal, String registry) 
		{
			unlocalizedName = unlocal;
			registryName = registry;
		}
		
		public String getUnlocalizedName()
		{
			return unlocalizedName;
		}
		
		public String getRegistryName()
		{
			return registryName;
		}
	}
	
	
}
