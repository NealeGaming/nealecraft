package net.nealecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCyclops extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer lleg;
    ModelRenderer rleg;
    ModelRenderer rarm;
    ModelRenderer larm;
  
  public ModelCyclops()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, -6F, -3F, 9, 10, 10);
      head.setRotationPoint(-1.5F, -10F, -2F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 20);
      body.addBox(-5F, 0F, -4F, 10, 15, 8);
      body.setRotationPoint(0F, -6F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      lleg = new ModelRenderer(this, 16, 43);
      lleg.addBox(-2F, 0F, -2F, 4, 15, 4);
      lleg.setRotationPoint(3F, 9F, 0F);
      lleg.setTextureSize(64, 32);
      lleg.mirror = true;
      setRotation(lleg, 0F, 0F, 0F);
      rleg = new ModelRenderer(this, 0, 43);
      rleg.addBox(-2F, 0F, -2F, 4, 15, 4);
      rleg.setRotationPoint(-3F, 9F, 0F);
      rleg.setTextureSize(64, 32);
      rleg.mirror = true;
      setRotation(rleg, 0F, 0F, 0F);
      rarm = new ModelRenderer(this, 38, 24);
      rarm.addBox(0F, -1F, -2F, 5, 20, 4);
      rarm.setRotationPoint(5F, -5F, 0F);
      rarm.setTextureSize(64, 32);
      rarm.mirror = true;
      setRotation(rarm, 0F, 0F, 0F);
      larm = new ModelRenderer(this, 38, 0);
      larm.addBox(-2F, -1F, -2F, 5, 20, 4);
      larm.setRotationPoint(-8F, -5F, 0F);
      larm.setTextureSize(64, 32);
      larm.mirror = true;
      setRotation(larm, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    lleg.render(f5);
    rleg.render(f5);
    rarm.render(f5);
    larm.render(f5);
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
    
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.lhornang.rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.lhornang.rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.rhorn.rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.rhorn.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.rarm.rotateAngleZ = 0.0F;
    this.larm.rotateAngleZ = 0.0F;
    this.rleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.lleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rleg.rotateAngleY = 0.0F;
    this.lleg.rotateAngleY = 0.0F;
    
  }

}
