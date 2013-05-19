package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Model_Mob_superskeleton extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer minigun1;
    ModelRenderer minigun2;
    ModelRenderer minigun3;
    ModelRenderer minigun4;
    ModelRenderer minigun5;
  
  public Model_Mob_superskeleton()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 8, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 32, 16);
      rightarm.addBox(-1F, -2F, -1F, 2, 12, 2);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -1.570796F, -0.3490659F, 0F);
      leftarm = new ModelRenderer(this, 32, 16);
      leftarm.addBox(-1F, -2F, -1F, 2, 12, 2);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, -1.570796F, 0.3490659F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -1F, 2, 12, 2);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(0F, 0F, -1F, 2, 12, 2);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      minigun1 = new ModelRenderer(this, 32, 0);
      minigun1.addBox(-3F, -3F, -6F, 6, 6, 6);
      minigun1.setRotationPoint(0F, 5F, -7F);
      minigun1.setTextureSize(64, 32);
      minigun1.mirror = true;
      setRotation(minigun1, 0F, 0F, 0F);
      minigun2 = new ModelRenderer(this, 40, 21);
      minigun2.addBox(-2F, -2F, -5F, 1, 4, 4);
      minigun2.setRotationPoint(0F, 5F, -12F);
      minigun2.setTextureSize(64, 32);
      minigun2.mirror = true;
      setRotation(minigun2, 0F, 0F, 0F);
      minigun3 = new ModelRenderer(this, 40, 21);
      minigun3.addBox(1F, -2F, -5F, 1, 4, 4);
      minigun3.setRotationPoint(0F, 5F, -12F);
      minigun3.setTextureSize(64, 32);
      minigun3.mirror = true;
      setRotation(minigun3, 0F, 0F, 0F);
      minigun4 = new ModelRenderer(this, 40, 16);
      minigun4.addBox(-1F, -2F, -5F, 2, 1, 4);
      minigun4.setRotationPoint(0F, 5F, -12F);
      minigun4.setTextureSize(64, 32);
      minigun4.mirror = true;
      setRotation(minigun4, 0F, 0F, 0F);
      minigun5 = new ModelRenderer(this, 40, 16);
      minigun5.addBox(-1F, 1F, -5F, 2, 1, 4);
      minigun5.setRotationPoint(0F, 5F, -12F);
      minigun5.setTextureSize(64, 32);
      minigun5.mirror = true;
      setRotation(minigun5, 0F, 0F, 0F);
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
    minigun1.render(f5);
    minigun2.render(f5);
    minigun3.render(f5);
    minigun4.render(f5);
    minigun5.render(f5);
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

}
