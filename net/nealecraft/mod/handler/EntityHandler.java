package net.nealecraft.mod.handler;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.nealecraft.mod.Nealecraft;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {

	public static void registerMonsters(Class entityClass, String name) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777215;
		int subColor = random.nextInt() * 16777215;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.addSpawn(entityClass, 50, 2, 4, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.forest);
		EntityRegistry.registerModEntity(entityClass, name, entityId, Nealecraft.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
		
	}
}
