package com.divinegenesis.bewitcher.init;

import com.divinegenesis.bewitcher.Main;
import com.divinegenesis.bewitcher.objects.entities.EntityBroom;
import com.divinegenesis.bewitcher.objects.entities.EntityMandrake;
import com.divinegenesis.bewitcher.objects.entities.EntitySoul;
import com.divinegenesis.bewitcher.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void registerEntities() {
		registerEntity("Mandrake", EntityMandrake.class, Reference.ENTITY_MANDRAKE, 8, 555555, 000000);
		registerEntity("Soul", EntitySoul.class, Reference.ENTITY_SOUL, 8, 333333, 222222);
		registerEntity("Broom", EntityBroom.class, Reference.ENTITY_BROOM, 8, 333333, 222222);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1,
			int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id,
				Main.instance, range, 1, true, color1, color2);
	}
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance,
				range, 1, true);
	}
}
