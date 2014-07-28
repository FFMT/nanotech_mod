/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSuperZombie extends ModelBase
{
    // fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;

    public ModelSuperZombie()
    {
        textureWidth = 64;
        textureHeight = 32;

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
        setRotation(rightarm, -1.570796F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, -1.570796F, 0F, 0F);
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
        rightarm2 = new ModelRenderer(this, 40, 16);
        rightarm2.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm2.setRotationPoint(-5F, 7F, 0F);
        rightarm2.setTextureSize(64, 32);
        rightarm2.mirror = true;
        setRotation(rightarm2, -1.570796F, 0F, 0F);
        leftarm2 = new ModelRenderer(this, 40, 16);
        leftarm2.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm2.setRotationPoint(5F, 7F, 0F);
        leftarm2.setTextureSize(64, 32);
        leftarm2.mirror = true;
        setRotation(leftarm2, -1.570796F, 0F, 0F);
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
        rightarm2.render(f5);
        leftarm2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity)
    {
        super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
        this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
        this.head.rotateAngleX = f5 / (180F / (float)Math.PI);
        this.head.rotateAngleY = this.head.rotateAngleY;
        this.head.rotateAngleX = this.head.rotateAngleX;
        float var7 = MathHelper.sin(this.onGround * (float)Math.PI);
        float var8 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightarm.rotateAngleY = -(0.1F - var7 * 0.6F);
        this.leftarm.rotateAngleY = 0.1F - var7 * 0.6F;
        this.rightarm.rotateAngleX = -((float)Math.PI / 2F);
        this.leftarm.rotateAngleX = -((float)Math.PI / 2F);
        this.rightarm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
        this.leftarm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
        this.rightarm.rotateAngleZ += MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(f3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(f3 * 0.067F) * 0.05F;
        this.rightarm2.rotateAngleZ = 0.0F;
        this.leftarm2.rotateAngleZ = 0.0F;
        this.rightarm2.rotateAngleY = -(0.1F - var7 * 0.6F);
        this.leftarm2.rotateAngleY = 0.1F - var7 * 0.6F;
        this.rightarm2.rotateAngleX = -((float)Math.PI / 2F);
        this.leftarm2.rotateAngleX = -((float)Math.PI / 2F);
        this.rightarm2.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
        this.leftarm2.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
        this.rightarm2.rotateAngleZ += MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm2.rotateAngleZ -= MathHelper.cos(f3 * 0.09F) * 0.05F + 0.05F;
        this.rightarm2.rotateAngleX += MathHelper.sin(f3 * 0.067F) * 0.05F;
        this.leftarm2.rotateAngleX -= MathHelper.sin(f3 * 0.067F) * 0.05F;
        this.rightleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
        this.leftleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float)Math.PI) * 1.4F * f2;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;

        if(this.isRiding)
        {
            this.rightarm.rotateAngleX += -((float)Math.PI / 5F);
            this.leftarm.rotateAngleX += -((float)Math.PI / 5F);
            this.rightarm2.rotateAngleX += -((float)Math.PI / 5F);
            this.leftarm2.rotateAngleX += -((float)Math.PI / 5F);
            this.rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.rightleg.rotateAngleY = ((float)Math.PI / 10F);
            this.leftleg.rotateAngleY = -((float)Math.PI / 10F);
        }
    }

}
