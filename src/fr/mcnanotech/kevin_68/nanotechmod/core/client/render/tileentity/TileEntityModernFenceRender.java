package fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.model.ModelModernFence1;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.model.ModelModernFence2;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntityModernFence;

public class TileEntityModernFenceRender extends TileEntitySpecialRenderer
{
    private final ModelModernFence1 model;
    private final ModelModernFence2 model2;
    protected static final ResourceLocation texture = new ResourceLocation(NanotechMod.MODID, "textures/blocks/modern_fence.png");
    protected static final ResourceLocation texture2 = new ResourceLocation(NanotechMod.MODID, "textures/blocks/modern_fence2.png");
    public int[][] colors = new int[][] { {25, 25, 25}, {153, 51, 51}, {102, 127, 51}, {102, 76, 51}, {51, 76, 178}, {127, 63, 178}, {76, 127, 153}, {153, 153, 153}, {76, 76, 76}, {242, 127, 165}, {127, 204, 25}, {229, 229, 51}, {102, 153, 216}, {178, 76, 216}, {216, 127, 51}, {255, 255, 255}};

    public TileEntityModernFenceRender()
    {
        this.model = new ModelModernFence1();
        this.model2 = new ModelModernFence2();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
    {
        TileEntityModernFence te = (TileEntityModernFence)tileentity;
        if(te.render[0])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 90F);
        if(te.render[1])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 270F);
        if(te.render[2])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 0F);
        if(te.render[3])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 180F);
        if(te.render[4])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 225F);
        if(te.render[5])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 135F);
        if(te.render[6])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 315F);
        if(te.render[7])
            this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale, 45F);
        this.renderTileEntityAtBlockModernFenceBase((TileEntityModernFence)tileentity, x, y, z, scale);
    }

    public void renderTileEntityAtBlockModernFenceBase(TileEntityModernFence tileentity, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        this.bindTexture(texture2);
        int[] curColor = colors[tileentity.getColor()];
        GL11.glColor3f(curColor[0] / 255.0F, curColor[1] / 255.0F, curColor[2] / 255.0F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
        this.model2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAtBlockModernFence(TileEntityModernFence tileentity, double x, double y, double z, float scale, float angle)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        this.bindTexture(texture);
        int[] curColor = colors[tileentity.getColor()];
        GL11.glColor3f(curColor[0] / 255.0F, curColor[1] / 255.0F, curColor[2] / 255.0F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}