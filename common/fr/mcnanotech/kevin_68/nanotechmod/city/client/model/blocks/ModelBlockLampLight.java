/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockLampLight extends ModelBase
{
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
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape16;
    ModelRenderer Shape17;

    public ModelBlockLampLight()
    {
        textureWidth = 64;
        textureHeight = 32;

        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(-2F, 0F, -2F, 4, 1, 4);
        Shape2.setRotationPoint(0F, 23F, 0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 5);
        Shape3.addBox(-2.5F, -1F, -2.5F, 5, 1, 5);
        Shape3.setRotationPoint(0F, 23F, 0F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 0, 11);
        Shape4.addBox(-3F, -2F, -3F, 6, 1, 6);
        Shape4.setRotationPoint(0F, 23F, 0F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 0, 18);
        Shape5.addBox(-4F, -3F, -4F, 8, 1, 8);
        Shape5.setRotationPoint(0F, 23F, 0F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 12, 0);
        Shape6.addBox(-1.5F, -15F, -1.5F, 3, 1, 3);
        Shape6.setRotationPoint(0F, 23F, 0F);
        Shape6.setTextureSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 19, 0);
        Shape7.addBox(-2.5F, -14F, -2.5F, 5, 1, 5);
        Shape7.setRotationPoint(0F, 23F, 0F);
        Shape7.setTextureSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 32, 0);
        Shape8.addBox(-4F, -13F, -4F, 8, 1, 8);
        Shape8.setRotationPoint(0F, 23F, 0F);
        Shape8.setTextureSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 22, 21);
        Shape9.addBox(-5F, -12F, -5F, 10, 1, 10);
        Shape9.setRotationPoint(0F, 23F, 0F);
        Shape9.setTextureSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 60, 21);
        Shape10.addBox(-0.5F, -12F, 3F, 1, 9, 1);
        Shape10.setRotationPoint(0F, 23F, 0F);
        Shape10.setTextureSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, -0.1745329F, 0.7853982F, 0F);
        Shape11 = new ModelRenderer(this, 60, 21);
        Shape11.addBox(-0.5F, -12F, -4F, 1, 9, 1);
        Shape11.setRotationPoint(0F, 23F, 0F);
        Shape11.setTextureSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, 0.1745329F, 0.7853982F, 0F);
        Shape12 = new ModelRenderer(this, 60, 21);
        Shape12.addBox(3F, -12F, -0.5F, 1, 9, 1);
        Shape12.setRotationPoint(0F, 23F, 0F);
        Shape12.setTextureSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, 0.12F, 0.7853982F, 0.1945329F);
        Shape13 = new ModelRenderer(this, 60, 21);
        Shape13.addBox(-4F, -12F, -0.5F, 1, 9, 1);
        Shape13.setRotationPoint(0F, 23F, 0F);
        Shape13.setTextureSize(64, 32);
        Shape13.mirror = true;
        setRotation(Shape13, -0.12F, 0.7853982F, -0.1945329F);
        Shape14 = new ModelRenderer(this, 50, 4);
        Shape14.addBox(-2.58F, -11.5F, -3.5F, 0, 8, 7);
        Shape14.setRotationPoint(0F, 23F, 0F);
        Shape14.setTextureSize(64, 32);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 0F, -0.1570796F);
        Shape15 = new ModelRenderer(this, 50, 4);
        Shape15.addBox(2.6F, -11.5F, -3.5F, 0, 8, 7);
        Shape15.setRotationPoint(0F, 23F, 0F);
        Shape15.setTextureSize(64, 32);
        Shape15.mirror = true;
        setRotation(Shape15, 0F, 0F, 0.1570796F);
        Shape18 = new ModelRenderer(this, 44, 15);
        Shape18.addBox(-1.5F, -7F, -0.04666667F, 3, 4, 0);
        Shape18.setRotationPoint(0F, 23F, 0F);
        Shape18.setTextureSize(64, 32);
        Shape18.mirror = true;
        setRotation(Shape18, 0F, 0.7853982F, 0F);
        Shape19 = new ModelRenderer(this, 44, 15);
        Shape19.addBox(-1.5F, -7F, 0F, 3, 4, 0);
        Shape19.setRotationPoint(0F, 23F, 0F);
        Shape19.setTextureSize(64, 32);
        Shape19.mirror = true;
        setRotation(Shape19, 0F, -0.7853982F, 0F);
        Shape16 = new ModelRenderer(this, 50, 11);
        Shape16.addBox(-3.5F, -11.5F, -2.6F, 7, 8, 0);
        Shape16.setRotationPoint(0F, 23F, 0F);
        Shape16.setTextureSize(64, 32);
        Shape16.mirror = true;
        setRotation(Shape16, 0.1570796F, 0F, 0F);
        Shape17 = new ModelRenderer(this, 50, 11);
        Shape17.addBox(-3.5F, -11.5F, 2.6F, 7, 8, 0);
        Shape17.setRotationPoint(0F, 23F, 0F);
        Shape17.setTextureSize(64, 32);
        Shape17.mirror = true;
        setRotation(Shape17, -0.1570796F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
        Shape18.render(f5);
        Shape19.render(f5);
        Shape16.render(f5);
        Shape17.render(f5);
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
