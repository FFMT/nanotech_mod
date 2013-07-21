package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ItemCrazyGlassesModel extends ModelBiped
	{
	  //fields
	    ModelRenderer LeftArm1;
	    ModelRenderer RightArm1;
	    ModelRenderer LeftArm2;
	    ModelRenderer RightArm2;
	    ModelRenderer LeftGlass;
	    ModelRenderer RightGlass;
	    ModelRenderer RightArm3;
	    ModelRenderer LeftArm3;
	    ModelRenderer CenterArm;
	  
	  public ItemCrazyGlassesModel()
	  {
	    textureWidth = 64;
	    textureHeight = 64;
	    
	      LeftArm1 = new ModelRenderer(this, 26, 0);
	      LeftArm1.addBox(4F, -5F, -5F, 1, 1, 7);
	      LeftArm1.setRotationPoint(0F, 0F, 0F);
	      LeftArm1.setTextureSize(64, 64);
	      LeftArm1.mirror = true;
	      setRotation(LeftArm1, 0F, 0F, 0F);
	      RightArm1 = new ModelRenderer(this, 10, 0);
	      RightArm1.addBox(-5F, -5F, -5F, 1, 1, 7);
	      RightArm1.setRotationPoint(0F, 0F, 0F);
	      RightArm1.setTextureSize(64, 64);
	      RightArm1.mirror = true;
	      setRotation(RightArm1, 0F, 0F, 0F);
	      LeftArm2 = new ModelRenderer(this, 29, 0);
	      LeftArm2.addBox(4F, -4F, 1F, 1, 1, 1);
	      LeftArm2.setRotationPoint(0F, 0F, 0F);
	      LeftArm2.setTextureSize(64, 64);
	      LeftArm2.mirror = true;
	      setRotation(LeftArm2, 0F, 0F, 0F);
	      RightArm2 = new ModelRenderer(this, 13, 0);
	      RightArm2.addBox(-5F, -4F, 1F, 1, 1, 1);
	      RightArm2.setRotationPoint(0F, 0F, 0F);
	      RightArm2.setTextureSize(64, 64);
	      RightArm2.mirror = true;
	      setRotation(RightArm2, 0F, 0F, 0F);
	      LeftGlass = new ModelRenderer(this, 31, 8);
	      LeftGlass.addBox(1F, -5.2F, -5F, 2, 2, 1);
	      LeftGlass.setRotationPoint(0F, 0F, 0F);
	      LeftGlass.setTextureSize(64, 64);
	      LeftGlass.mirror = true;
	      setRotation(LeftGlass, 0F, 0F, 0F);
	      RightGlass = new ModelRenderer(this, 15, 8);
	      RightGlass.addBox(-3F, -5.2F, -5F, 2, 2, 1);
	      RightGlass.setRotationPoint(0F, 0F, 0F);
	      RightGlass.setTextureSize(64, 64);
	      RightGlass.mirror = true;
	      setRotation(RightGlass, 0F, 0F, 0F);
	      RightArm3 = new ModelRenderer(this, 13, 2);
	      RightArm3.addBox(-4F, -5F, -5F, 1, 1, 1);
	      RightArm3.setRotationPoint(0F, 0F, 0F);
	      RightArm3.setTextureSize(64, 64);
	      RightArm3.mirror = true;
	      setRotation(RightArm3, 0F, 0F, 0F);
	      LeftArm3 = new ModelRenderer(this, 29, 2);
	      LeftArm3.addBox(3F, -5F, -5F, 1, 1, 1);
	      LeftArm3.setRotationPoint(0F, 0F, 0F);
	      LeftArm3.setTextureSize(64, 64);
	      LeftArm3.mirror = true;
	      setRotation(LeftArm3, 0F, 0F, 0F);
	      CenterArm = new ModelRenderer(this, 0, 0);
	      CenterArm.addBox(-1F, -5F, -5F, 2, 1, 1);
	      CenterArm.setRotationPoint(0F, 0F, 0F);
	      CenterArm.setTextureSize(64, 64);
	      CenterArm.mirror = true;
	      setRotation(CenterArm, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    LeftArm1.render(f5);
	    RightArm1.render(f5);
	    LeftArm2.render(f5);
	    RightArm2.render(f5);
	    LeftGlass.render(f5);
	    RightGlass.render(f5);
	    RightArm3.render(f5);
	    LeftArm3.render(f5);
	    CenterArm.render(f5);
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
        this.LeftArm1.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.LeftArm1.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.RightArm1.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.RightArm1.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.LeftArm2.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.LeftArm2.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.RightArm2.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.RightArm2.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.LeftGlass.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.LeftGlass.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.RightGlass.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.RightGlass.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.RightArm3.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.RightArm3.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.LeftArm3.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.LeftArm3.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.CenterArm.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.CenterArm.rotateAngleX = f4 / (180F / (float)Math.PI);
	  }

	}
