package fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.model.ModelSunShade;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySunShade;

public class TileEntitySunShadeRender extends TileEntitySpecialRenderer
{
    private final ModelSunShade model;

    public TileEntitySunShadeRender()
    {
        this.model = new ModelSunShade();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
    {
        this.renderTileEntityAtBlockLamp((TileEntitySunShade)tileentity, x, y, z, scale);
    }

    public void renderTileEntityAtBlockLamp(TileEntitySunShade tileentity, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        this.bindTexture(new ResourceLocation(NanotechMod.MODID, "textures/blocks/sun_shade_" + (tileentity.getIsOpen() ? "open" : "close") + ".png"));
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}