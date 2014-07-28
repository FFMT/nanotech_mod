/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.blocks.ModelButton;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityButton;

public class TileEntityButtonRender extends TileEntitySpecialRenderer
{
    private final ModelButton model;
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/blocks/button.png");

    public TileEntityButtonRender()
    {
        this.model = new ModelButton();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
    {
        this.renderTileEntityAtBlockLamp((TileEntityButton)tileentity, x, y, z, scale);
    }

    public void renderTileEntityAtBlockLamp(TileEntityButton tileentity, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.model.renderModel((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, tileentity.getBlockMetadata() == 2 ? true : (tileentity.getBlockMetadata() == 3 ? true : false));
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}