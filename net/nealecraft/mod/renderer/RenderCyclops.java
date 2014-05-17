package net.nealecraft.mod.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.nealecraft.mod.Nealecraft;
import net.nealecraft.mod.entity.EntityCyclops;
import net.nealecraft.mod.model.ModelCyclops;

public class RenderCyclops extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation(Nealecraft.modid + ":" + "textures/model/Cyclops.png");
	
	protected ModelCyclops modelEntity;

	public RenderCyclops(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelCyclops) mainModel);
	}

	public void renderCyclops(EntityCyclops entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderCyclops((EntityCyclops)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderCyclops((EntityCyclops)entity, x, y, z, u, v);
	}
	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

	

}
