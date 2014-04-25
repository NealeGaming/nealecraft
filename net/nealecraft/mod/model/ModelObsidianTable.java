package net.nealecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelObsidianTable extends ModelBase
{
  //fields
    ModelRenderer tabletop;
    ModelRenderer legone;
    ModelRenderer legtwo;
    ModelRenderer legthree;
    ModelRenderer legfour;
  
  public ModelObsidianTable()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      tabletop = new ModelRenderer(this, 0, 0);
      tabletop.addBox(0F, 0F, 0F, 16, 4, 16);
      tabletop.setRotationPoint(-8F, 12F, -8F);
      tabletop.setTextureSize(64, 32);
      tabletop.mirror = true;
      setRotation(tabletop, 0F, 0F, 0F);
      legone = new ModelRenderer(this, 48, 20);
      legone.addBox(0F, 0F, 0F, 4, 8, 4);
      legone.setRotationPoint(-8F, 16F, -8F);
      legone.setTextureSize(64, 32);
      legone.mirror = true;
      setRotation(legone, 0F, 0F, 0F);
      legtwo = new ModelRenderer(this, 32, 20);
      legtwo.addBox(0F, 0F, 0F, 4, 8, 4);
      legtwo.setRotationPoint(4F, 16F, 4F);
      legtwo.setTextureSize(64, 32);
      legtwo.mirror = true;
      setRotation(legtwo, 0F, 0F, 0F);
      legthree = new ModelRenderer(this, 0, 20);
      legthree.addBox(4F, 0F, -8F, 4, 8, 4);
      legthree.setRotationPoint(0F, 16F, 0F);
      legthree.setTextureSize(64, 32);
      legthree.mirror = true;
      setRotation(legthree, 0F, 0F, 0F);
      legfour = new ModelRenderer(this, 16, 20);
      legfour.addBox(0F, 0F, 0F, 4, 8, 4);
      legfour.setRotationPoint(-8F, 16F, 4F);
      legfour.setTextureSize(64, 32);
      legfour.mirror = true;
      setRotation(legfour, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    tabletop.render(f5);
    legone.render(f5);
    legtwo.render(f5);
    legthree.render(f5);
    legfour.render(f5);
  }
  
  public void renderModel(float f) {
	  tabletop.render(f);
	  legone.render(f);
	  legtwo.render(f);
	  legthree.render(f);
	  legfour.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
