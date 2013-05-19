package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class Model_Mob_thedeath extends ModelBase
{
	
		  //fields
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
		    ModelRenderer Shape13;
		    ModelRenderer Shape14;
		    ModelRenderer Shape15;
		    ModelRenderer Shape16;
		    ModelRenderer Shape17;
		    ModelRenderer Shape18;
		    ModelRenderer Shape19;
		    ModelRenderer Shape20;
		    ModelRenderer Shape21;
		    ModelRenderer Shape22;
		    ModelRenderer Shape23;
		    ModelRenderer Shape24;
		    ModelRenderer Shape25;
		    ModelRenderer Shape26;
		    ModelRenderer Shape27;
		    ModelRenderer Shape28;
		    ModelRenderer Shape29;
		    ModelRenderer Shape30;
		  
		  public Model_Mob_thedeath()
		  {
		    textureWidth = 512;
		    textureHeight = 512;
		    
		      Shape1 = new ModelRenderer(this, 0, 0);
		      Shape1.addBox(-3F, -6F, -2F, 6, 6, 6);
		      Shape1.setRotationPoint(0F, -7.8F, -1F);
		      Shape1.setTextureSize(64, 32);
		      Shape1.mirror = true;
		      setRotation(Shape1, 0F, 0F, 0F);
		      Shape2 = new ModelRenderer(this, 36, 0);
		      Shape2.addBox(-1F, 0F, -1F, 2, 8, 2);
		      Shape2.setRotationPoint(0F, -8F, 0F);
		      Shape2.setTextureSize(64, 32);
		      Shape2.mirror = true;
		      setRotation(Shape2, 0F, 0F, 0F);
		      Shape3 = new ModelRenderer(this, 47, 0);
		      Shape3.addBox(-1F, 0F, -1F, 2, 3, 2);
		      Shape3.setRotationPoint(0F, -0.3F, 0F);
		      Shape3.setTextureSize(64, 32);
		      Shape3.mirror = true;
		      setRotation(Shape3, 0.4363323F, 0F, 0F);
		      Shape4 = new ModelRenderer(this, 60, 0);
		      Shape4.addBox(-1F, 0F, -1F, 2, 3, 2);
		      Shape4.setRotationPoint(0F, 2F, 1F);
		      Shape4.setTextureSize(64, 32);
		      Shape4.mirror = true;
		      setRotation(Shape4, 0.6457718F, 0F, 0F);
		      Shape5 = new ModelRenderer(this, 71, 0);
		      Shape5.addBox(-1F, 0F, -1F, 2, 3, 2);
		      Shape5.setRotationPoint(0F, 4F, 2.5F);
		      Shape5.setTextureSize(64, 32);
		      Shape5.mirror = true;
		      setRotation(Shape5, 0.4886922F, 0F, 0F);
		      Shape6 = new ModelRenderer(this, 71, 0);
		      Shape6.addBox(-1F, 0F, -1F, 2, 3, 2);
		      Shape6.setRotationPoint(0F, 6F, 3.6F);
		      Shape6.setTextureSize(64, 32);
		      Shape6.mirror = true;
		      setRotation(Shape6, 0.3316126F, 0F, 0F);
		      Shape7 = new ModelRenderer(this, 81, 0);
		      Shape7.addBox(-1F, 0F, -1F, 2, 3, 2);
		      Shape7.setRotationPoint(0F, 8.7F, 4.5F);
		      Shape7.setTextureSize(64, 32);
		      Shape7.mirror = true;
		      setRotation(Shape7, 0.122173F, 0F, 0F);
		      Shape8 = new ModelRenderer(this, 93, 0);
		      Shape8.addBox(-1F, 0F, -1F, 2, 3, 2);
		      Shape8.setRotationPoint(0F, 11.7F, 4.8F);
		      Shape8.setTextureSize(64, 32);
		      Shape8.mirror = true;
		      setRotation(Shape8, 0.122173F, 0F, 0F);
		      Shape9 = new ModelRenderer(this, 36, 11);
		      Shape9.addBox(-6F, -1F, -1F, 6, 2, 2);
		      Shape9.setRotationPoint(-1F, -4F, 0F);
		      Shape9.setTextureSize(64, 32);
		      Shape9.mirror = true;
		      setRotation(Shape9, 0F, 0F, 0F);
		      Shape10 = new ModelRenderer(this, 56, 11);
		      Shape10.addBox(0F, -1F, -1F, 6, 2, 2);
		      Shape10.setRotationPoint(1F, -4F, 0F);
		      Shape10.setTextureSize(64, 32);
		      Shape10.mirror = true;
		      setRotation(Shape10, 0F, 0F, 0F);
		      Shape11 = new ModelRenderer(this, 36, 11);
		      Shape11.addBox(-6F, -1F, -1F, 6, 2, 2);
		      Shape11.setRotationPoint(-6F, -4F, 0F);
		      Shape11.setTextureSize(64, 32);
		      Shape11.mirror = true;
		      setRotation(Shape11, 0F, -0.4537856F, 0F);
		      Shape12 = new ModelRenderer(this, 36, 11);
		      Shape12.addBox(0F, -1F, -1F, 6, 2, 2);
		      Shape12.setRotationPoint(6F, -4F, 0F);
		      Shape12.setTextureSize(64, 32);
		      Shape12.mirror = true;
		      setRotation(Shape12, 0F, 0.4537856F, 0F);
		      Shape13 = new ModelRenderer(this, 24, 67);
		      Shape13.addBox(-6F, 0F, 0F, 12, 9, 0);
		      Shape13.setRotationPoint(0F, -7.8F, 3F);
		      Shape13.setTextureSize(64, 32);
		      Shape13.mirror = true;
		      setRotation(Shape13, -0.0523599F, 0F, 0F);
		      Shape14 = new ModelRenderer(this, 10, 90);
		      Shape14.addBox(-12F, -1F, 0F, 24, 8, 0);
		      Shape14.setRotationPoint(0F, 1.9F, 3F);
		      Shape14.setTextureSize(64, 32);
		      Shape14.mirror = true;
		      setRotation(Shape14, 0.4363323F, 0F, 0F);
		      Shape15 = new ModelRenderer(this, 10, 100);
		      Shape15.addBox(-12F, 0F, 0F, 24, 9, 0);
		      Shape15.setRotationPoint(0F, 8F, 5.8F);
		      Shape15.setTextureSize(64, 32);
		      Shape15.mirror = true;
		      setRotation(Shape15, 0.1745329F, 0F, 0F);
		      Shape16 = new ModelRenderer(this, 0, 22);
		      Shape16.addBox(0F, 0F, -5F, 0, 7, 8);
		      Shape16.setRotationPoint(-3F, -13.8F, 0F);
		      Shape16.setTextureSize(64, 32);
		      Shape16.mirror = true;
		      setRotation(Shape16, 0F, 0F, 0.4363323F);
		      Shape17 = new ModelRenderer(this, 0, 40);
		      Shape17.addBox(0F, 0F, -5F, 0, 7, 8);
		      Shape17.setRotationPoint(3F, -13.8F, 0F);
		      Shape17.setTextureSize(64, 32);
		      Shape17.mirror = true;
		      setRotation(Shape17, 0F, 0F, -0.4363323F);
		      Shape18 = new ModelRenderer(this, 0, 55);
		      Shape18.addBox(0F, -3F, -5F, 0, 6, 8);
		      Shape18.setRotationPoint(0F, -13.8F, 0F);
		      Shape18.setTextureSize(64, 32);
		      Shape18.mirror = true;
		      setRotation(Shape18, 0F, 0F, 1.570796F);
		      Shape19 = new ModelRenderer(this, 22, 43);
		      Shape19.addBox(0F, 0F, 0F, 0, 3, 7);
		      Shape19.setRotationPoint(-5.9F, -7.5F, 3F);
		      Shape19.setTextureSize(64, 32);
		      Shape19.mirror = true;
		      setRotation(Shape19, 1.134464F, 1.570796F, 0F);
		      Shape20 = new ModelRenderer(this, 22, 55);
		      Shape20.addBox(0F, 0F, 0F, 0, 3, 7);
		      Shape20.setRotationPoint(3F, -13.7F, 3F);
		      Shape20.setTextureSize(64, 32);
		      Shape20.mirror = true;
		      setRotation(Shape20, -1.134464F, 1.570796F, 0F);
		      Shape21 = new ModelRenderer(this, 21, 22);
		      Shape21.addBox(-1F, -0.5F, 0F, 0, 7, 8);
		      Shape21.setRotationPoint(-6F, -6.5F, -5F);
		      Shape21.setTextureSize(64, 32);
		      Shape21.mirror = true;
		      setRotation(Shape21, 0F, 0F, 1.169371F);
		      Shape22 = new ModelRenderer(this, 42, 22);
		      Shape22.addBox(0F, 0F, -5F, 0, 7, 8);
		      Shape22.setRotationPoint(6F, -7.5F, 0F);
		      Shape22.setTextureSize(64, 32);
		      Shape22.mirror = true;
		      setRotation(Shape22, 0F, 0F, -1.169371F);
		      Shape23 = new ModelRenderer(this, 0, 80);
		      Shape23.addBox(5F, 0F, 0F, 8, 6, 0);
		      Shape23.setRotationPoint(-1F, -5F, 2.9F);
		      Shape23.setTextureSize(64, 32);
		      Shape23.mirror = true;
		      setRotation(Shape23, -0.0523599F, 0F, 0F);
		      Shape24 = new ModelRenderer(this, 0, 72);
		      Shape24.addBox(-11F, 0F, 0F, 8, 6, 0);
		      Shape24.setRotationPoint(-1F, -5F, 2.9F);
		      Shape24.setTextureSize(64, 32);
		      Shape24.mirror = true;
		      setRotation(Shape24, -0.0523599F, 0F, 0F);
		      Shape25 = new ModelRenderer(this, 40, 43);
		      Shape25.addBox(0F, 0F, 0F, 0, 3, 7);
		      Shape25.setRotationPoint(-12F, -5F, 2.9F);
		      Shape25.setTextureSize(64, 32);
		      Shape25.mirror = true;
		      setRotation(Shape25, 0.4014257F, 1.570796F, 0F);
		      Shape26 = new ModelRenderer(this, 40, 55);
		      Shape26.addBox(0F, 0F, 0F, 0, 3, 7);
		      Shape26.setRotationPoint(5F, -8F, 2.9F);
		      Shape26.setTextureSize(64, 32);
		      Shape26.mirror = true;
		      setRotation(Shape26, -0.4014257F, 1.570796F, 0F);
		      Shape27 = new ModelRenderer(this, 102, 0);
		      Shape27.addBox(-4F, 0F, 0F, 8, 1, 1);
		      Shape27.setRotationPoint(0F, -2F, -0.5F);
		      Shape27.setTextureSize(512, 512);
		      Shape27.mirror = true;
		      setRotation(Shape27, 0F, 0F, 0F);
		      Shape28 = new ModelRenderer(this, 120, 0);
		      Shape28.addBox(-3.5F, 0F, 0F, 7, 1, 1);
		      Shape28.setRotationPoint(0F, 0F, -0.3F);
		      Shape28.setTextureSize(512, 512);
		      Shape28.mirror = true;
		      setRotation(Shape28, 0.2094395F, 0F, 0F);
		      Shape29 = new ModelRenderer(this, 135, 0);
		      Shape29.addBox(-3F, 0F, 0F, 6, 1, 1);
		      Shape29.setRotationPoint(0F, 2F, 0.5F);
		      Shape29.setTextureSize(512, 512);
		      Shape29.mirror = true;
		      setRotation(Shape29, 0.5235988F, 0F, 0F);
		      Shape30 = new ModelRenderer(this, 149, 0);
		      Shape30.addBox(-2.5F, 0F, 0F, 5, 1, 1);
		      Shape30.setRotationPoint(0F, 4F, 1.8F);
		      Shape30.setTextureSize(512, 512);
		      Shape30.mirror = true;
		      setRotation(Shape30, 0.5759587F, 0F, 0F);
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
		    Shape13.render(f5);
		    Shape14.render(f5);
		    Shape15.render(f5);
		    Shape16.render(f5);
		    Shape17.render(f5);
		    Shape18.render(f5);
		    Shape19.render(f5);
		    Shape20.render(f5);
		    Shape21.render(f5);
		    Shape22.render(f5);
		    Shape23.render(f5);
		    Shape24.render(f5);
		    Shape25.render(f5);
		    Shape26.render(f5);
		    Shape27.render(f5);
		    Shape28.render(f5);
		    Shape29.render(f5);
		    Shape30.render(f5);
		  }
		  
		  private void setRotation(ModelRenderer model, float x, float y, float z)
		  {
		    model.rotateAngleX = x;
		    model.rotateAngleY = y;
		    model.rotateAngleZ = z;
		  }
		  
		  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity)
		  {
		    super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
		  }
	

	/**
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer stick;
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;
    ModelRenderer par4;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public Model_Mob_thedeath()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -1.466077F, -0.2617994F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, -0.5759587F, 0.2617994F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      stick = new ModelRenderer(this, 0, 62);
      stick.addBox(-23F, 0F, 0F, 40, 1, 1);
      stick.setRotationPoint(0F, 4F, -7F);
      stick.setTextureSize(64, 32);
      stick.mirror = true;
      setRotation(stick, 0F, 0F, 0.8901179F);
      part1 = new ModelRenderer(this, 0, 36);
      part1.addBox(-2F, 0F, 0F, 6, 1, 1);
      part1.setRotationPoint(-18F, -10.9F, -7F);
      part1.setTextureSize(64, 32);
      part1.mirror = true;
      setRotation(part1, 0F, 0F, -0.6981317F);
      part2 = new ModelRenderer(this, 0, 39);
      part2.addBox(-5F, 0F, 0F, 8, 1, 1);
      part2.setRotationPoint(-17F, -10.5F, -7F);
      part2.setTextureSize(64, 32);
      part2.mirror = true;
      setRotation(part2, 0F, 0F, -0.6981317F);
      part3 = new ModelRenderer(this, 0, 42);
      part3.addBox(-9F, 0F, 0F, 11, 1, 1);
      part3.setRotationPoint(-15F, -11F, -7F);
      part3.setTextureSize(64, 32);
      part3.mirror = true;
      setRotation(part3, 0F, 0F, -0.6981317F);
      par4 = new ModelRenderer(this, 0, 45);
      par4.addBox(-11F, 0F, 0F, 12, 1, 1);
      par4.setRotationPoint(-15F, -9.7F, -7F);
      par4.setTextureSize(64, 32);
      par4.mirror = true;
      setRotation(par4, 0F, 0F, -0.6981317F);
      Shape1 = new ModelRenderer(this, 0, 48);
      Shape1.addBox(-13F, 0F, 0F, 12, 1, 1);
      Shape1.setRotationPoint(-15F, -8.5F, -7F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, -0.6981317F);
      Shape2 = new ModelRenderer(this, 0, 51);
      Shape2.addBox(-14.13333F, 0F, 0F, 9, 1, 1);
      Shape2.setRotationPoint(-15F, -7.2F, -7F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, -0.6981317F);
      Shape3 = new ModelRenderer(this, 0, 54);
      Shape3.addBox(-14F, 0F, 0F, 4, 1, 1);
      Shape3.setRotationPoint(-15F, -6F, -7F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, -0.6981317F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    stick.render(f5);
    part1.render(f5);
    part2.render(f5);
    part3.render(f5);
    par4.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
      this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
      this.head.rotateAngleY = this.head.rotateAngleY;
      this.head.rotateAngleX = this.head.rotateAngleX;
      float var7 = MathHelper.sin(this.onGround * (float)Math.PI);
      float var8 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
      this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.rightleg.rotateAngleY = 0.0F;
      this.leftleg.rotateAngleY = 0.0F;

      if (this.isRiding)
      {
          this.rightarm.rotateAngleX += -((float)Math.PI / 5F);
          this.leftarm.rotateAngleX += -((float)Math.PI / 5F);
          this.rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.rightleg.rotateAngleY = ((float)Math.PI / 10F);
          this.leftleg.rotateAngleY = -((float)Math.PI / 10F);
      }
  }
**/
}

