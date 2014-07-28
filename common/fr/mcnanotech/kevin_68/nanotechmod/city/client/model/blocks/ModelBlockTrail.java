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

public class ModelBlockTrail extends ModelBase
{
    ModelRenderer Block;

    public ModelBlockTrail()
    {
        textureWidth = 64;
        textureHeight = 32;

        Block = new ModelRenderer(this, 0, 0);
        Block.addBox(-8F, -7.99F, -8F, 16, 16, 16);
        Block.setRotationPoint(0F, 16F, 0F);
        Block.setTextureSize(64, 32);
        Block.mirror = true;
        setRotation(Block, 0F, 0F, 0F);
    }

    public void render(float f)
    {
        Block.render(f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}