package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityReinforcedFishingHook;

@SideOnly(Side.CLIENT)
public class RenderReinforcedFishingHook extends Render
{
    private static final ResourceLocation field_110792_a = new ResourceLocation("textures/particle/particles.png");

    public void doRenderFishHook(EntityReinforcedFishingHook par1EntityFishHook, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.bindEntityTexture(par1EntityFishHook);
        Tessellator tessellator = Tessellator.instance;
        byte b0 = 1;
        byte b1 = 2;
        float f2 = (float)(b0 * 8 + 0) / 128.0F;
        float f3 = (float)(b0 * 8 + 8) / 128.0F;
        float f4 = (float)(b1 * 8 + 0) / 128.0F;
        float f5 = (float)(b1 * 8 + 8) / 128.0F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.5F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(0.0F - f7), (double)(0.0F - f8), 0.0D, (double)f2, (double)f5);
        tessellator.addVertexWithUV((double)(f6 - f7), (double)(0.0F - f8), 0.0D, (double)f3, (double)f5);
        tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)f3, (double)f4);
        tessellator.addVertexWithUV((double)(0.0F - f7), (double)(1.0F - f8), 0.0D, (double)f2, (double)f4);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();

        if (par1EntityFishHook.angler != null)
        {
            float f9 = par1EntityFishHook.angler.getSwingProgress(par9);
            float f10 = MathHelper.sin(MathHelper.sqrt_float(f9) * (float)Math.PI);
            Vec3 vec3 = par1EntityFishHook.worldObj.getWorldVec3Pool().getVecFromPool(-0.5D, 0.03D, 0.8D);
            vec3.rotateAroundX(-(par1EntityFishHook.angler.prevRotationPitch + (par1EntityFishHook.angler.rotationPitch - par1EntityFishHook.angler.prevRotationPitch) * par9) * (float)Math.PI / 180.0F);
            vec3.rotateAroundY(-(par1EntityFishHook.angler.prevRotationYaw + (par1EntityFishHook.angler.rotationYaw - par1EntityFishHook.angler.prevRotationYaw) * par9) * (float)Math.PI / 180.0F);
            vec3.rotateAroundY(f10 * 0.5F);
            vec3.rotateAroundX(-f10 * 0.7F);
            double d3 = par1EntityFishHook.angler.prevPosX + (par1EntityFishHook.angler.posX - par1EntityFishHook.angler.prevPosX) * (double)par9 + vec3.xCoord;
            double d4 = par1EntityFishHook.angler.prevPosY + (par1EntityFishHook.angler.posY - par1EntityFishHook.angler.prevPosY) * (double)par9 + vec3.yCoord;
            double d5 = par1EntityFishHook.angler.prevPosZ + (par1EntityFishHook.angler.posZ - par1EntityFishHook.angler.prevPosZ) * (double)par9 + vec3.zCoord;
            double d6 = par1EntityFishHook.angler == Minecraft.getMinecraft().thePlayer ? 0.0D : (double)par1EntityFishHook.angler.getEyeHeight();

            if (this.renderManager.options.thirdPersonView > 0 || par1EntityFishHook.angler != Minecraft.getMinecraft().thePlayer)
            {
                float f11 = (par1EntityFishHook.angler.prevRenderYawOffset + (par1EntityFishHook.angler.renderYawOffset - par1EntityFishHook.angler.prevRenderYawOffset) * par9) * (float)Math.PI / 180.0F;
                double d7 = (double)MathHelper.sin(f11);
                double d8 = (double)MathHelper.cos(f11);
                d3 = par1EntityFishHook.angler.prevPosX + (par1EntityFishHook.angler.posX - par1EntityFishHook.angler.prevPosX) * (double)par9 - d8 * 0.35D - d7 * 0.85D;
                d4 = par1EntityFishHook.angler.prevPosY + d6 + (par1EntityFishHook.angler.posY - par1EntityFishHook.angler.prevPosY) * (double)par9 - 0.45D;
                d5 = par1EntityFishHook.angler.prevPosZ + (par1EntityFishHook.angler.posZ - par1EntityFishHook.angler.prevPosZ) * (double)par9 - d7 * 0.35D + d8 * 0.85D;
            }

            double d9 = par1EntityFishHook.prevPosX + (par1EntityFishHook.posX - par1EntityFishHook.prevPosX) * (double)par9;
            double d10 = par1EntityFishHook.prevPosY + (par1EntityFishHook.posY - par1EntityFishHook.prevPosY) * (double)par9 + 0.25D;
            double d11 = par1EntityFishHook.prevPosZ + (par1EntityFishHook.posZ - par1EntityFishHook.prevPosZ) * (double)par9;
            double d12 = (double)((float)(d3 - d9));
            double d13 = (double)((float)(d4 - d10));
            double d14 = (double)((float)(d5 - d11));
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            tessellator.startDrawing(3);
            tessellator.setColorOpaque_I(0);
            byte b2 = 16;

            for (int i = 0; i <= b2; ++i)
            {
                float f12 = (float)i / (float)b2;
                tessellator.addVertex(par2 + d12 * (double)f12, par4 + d13 * (double)(f12 * f12 + f12) * 0.5D + 0.25D, par6 + d14 * (double)f12);
            }

            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
    }

    protected ResourceLocation func_110791_a(EntityReinforcedFishingHook par1EntityFishHook)
    {
        return field_110792_a;
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110791_a((EntityReinforcedFishingHook)par1Entity);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderFishHook((EntityReinforcedFishingHook)par1Entity, par2, par4, par6, par8, par9);
    }
}
