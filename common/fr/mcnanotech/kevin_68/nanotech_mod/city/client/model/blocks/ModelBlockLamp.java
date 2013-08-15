package fr.mcnanotech.kevin_68.nanotech_mod.city.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockLamp extends ModelBase
{
	   ModelRenderer Shape1;
	    ModelRenderer Shape2;
	    ModelRenderer Shape3;
	    ModelRenderer Shape4;
	    ModelRenderer Shape5;
	    ModelRenderer Shape6;
	    ModelRenderer Shape7;
	    ModelRenderer Shape8;
	    ModelRenderer Shape9;
	    ModelRenderer Shape10;
	    ModelRenderer Shape11;
	    ModelRenderer Shape12;
	  
	  public ModelBlockLamp()
	  {
	    textureWidth = 128;
	    textureHeight = 64;
	    
	      Shape1 = new ModelRenderer(this, 0, 0);
	      Shape1.addBox(-5F, 0F, -5F, 10, 1, 10);
	      Shape1.setRotationPoint(0F, 23F, 0F);
	      Shape1.setTextureSize(128, 64);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
	      Shape2 = new ModelRenderer(this, 0, 11);
	      Shape2.addBox(-4.5F, -1F, -4.5F, 9, 1, 9);
	      Shape2.setRotationPoint(0F, 23F, 0F);
	      Shape2.setTextureSize(128, 64);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 0, 21);
	      Shape3.addBox(-4F, -2F, -4F, 8, 2, 8);
	      Shape3.setRotationPoint(0F, 22F, 0F);
	      Shape3.setTextureSize(128, 64);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 0, 31);
	      Shape4.addBox(-3.5F, -5F, -3.5F, 7, 4, 7);
	      Shape4.setRotationPoint(0F, 21F, 0F);
	      Shape4.setTextureSize(128, 64);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	      Shape5 = new ModelRenderer(this, 0, 42);
	      Shape5.addBox(-3F, -23F, -3F, 6, 16, 6);
	      Shape5.setRotationPoint(0F, 23F, 0F);
	      Shape5.setTextureSize(128, 64);
	      Shape5.mirror = true;
	      setRotation(Shape5, 0F, 0F, 0F);
	      Shape6 = new ModelRenderer(this, 42, 0);
	      Shape6.addBox(-3.5F, -24F, -3.5F, 7, 1, 7);
	      Shape6.setRotationPoint(0F, 23F, 0F);
	      Shape6.setTextureSize(128, 64);
	      Shape6.mirror = true;
	      setRotation(Shape6, 0F, 0F, 0F);
	      Shape7 = new ModelRenderer(this, 42, 8);
	      Shape7.addBox(-3F, -40F, -3F, 6, 17, 6);
	      Shape7.setRotationPoint(0F, 22F, 0F);
	      Shape7.setTextureSize(128, 64);
	      Shape7.mirror = true;
	      setRotation(Shape7, 0F, 0F, 0F);
	      Shape8 = new ModelRenderer(this, 42, 31);
	      Shape8.addBox(-3.5F, -42F, -3.5F, 7, 1, 7);
	      Shape8.setRotationPoint(0F, 23F, 0F);
	      Shape8.setTextureSize(128, 64);
	      Shape8.mirror = true;
	      setRotation(Shape8, 0F, 0F, 0F);
	      Shape9 = new ModelRenderer(this, 42, 39);
	      Shape9.addBox(-3F, -43F, -3F, 6, 1, 6);
	      Shape9.setRotationPoint(0F, 23F, 0F);
	      Shape9.setTextureSize(128, 64);
	      Shape9.mirror = true;
	      setRotation(Shape9, 0F, 0F, 0F);
	      Shape10 = new ModelRenderer(this, 42, 46);
	      Shape10.addBox(-2.5F, -44F, -2.5F, 5, 1, 5);
	      Shape10.setRotationPoint(0F, 23F, 0F);
	      Shape10.setTextureSize(128, 64);
	      Shape10.mirror = true;
	      setRotation(Shape10, 0F, 0F, 0F);
	      Shape11 = new ModelRenderer(this, 42, 52);
	      Shape11.addBox(-2F, -45F, -2F, 4, 1, 4);
	      Shape11.setRotationPoint(0F, 23F, 0F);
	      Shape11.setTextureSize(128, 64);
	      Shape11.mirror = true;
	      setRotation(Shape11, 0F, 0F, 0F);
	      Shape12 = new ModelRenderer(this, 42, 57);
	      Shape12.addBox(-1.5F, -47F, -1.5F, 3, 2, 3);
	      Shape12.setRotationPoint(0F, 23F, 0F);
	      Shape12.setTextureSize(128, 64);
	      Shape12.mirror = true;
	      setRotation(Shape12, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape11.render(f5);
	    Shape12.render(f5);
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
