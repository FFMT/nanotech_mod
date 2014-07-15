/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiHelper;

@SideOnly(Side.CLIENT)
public class TileEntitySpotLightRender extends TileEntitySpecialRenderer
{

	public void renderTileEntitySpotLightAt(TileEntitySpotLight tileentity, double x, double y, double z, float tick)
	{
		float f1 = tileentity.isActive();
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		if(f1 > 0.0F)
		{
			Tessellator tessellator = Tessellator.instance;
			GuiHelper.bindTexture(UtilSpotLight.getEntryByName(tileentity.getTextureName()).getPath());
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
			OpenGlHelper.glBlendFunc(770, 1, 1, 0);
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA(tileentity.getRed(), tileentity.getGreen(), tileentity.getBlue(), 32);
			float f2 = (float)tileentity.getWorldObj().getTotalWorldTime() + tick;
			float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
			byte b0 = 1;
			double d4 = (double)b0 * 0.2D;// taille
			double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);

			double angle1Deg = tileentity.getAngle1();
			double angle2Deg = tileentity.getAngle2();
			double a1 = Math.toRadians(angle1Deg);
			double a2 = tileentity.isAutoRotate() ? ((d3 * (tileentity.getRotationSpeed() / 4)) * (tileentity.isReverseRotation() ? -1 : 1)) : Math.toRadians(angle2Deg);

			double xo = 0.5D;
			double yo = 0.5D;
			double zo = 0.5D;
			double xm = xo + (256 * Math.cos(a2) * Math.sin(a1));
			double ym = yo + (256 * Math.cos(a1));
			double zm = zo + (256 * Math.sin(a2) * Math.sin(a1));

			double xa = xo + (0.2D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a1 + (Math.PI / 4D)));
			double ya = xo + (0.2D * Math.cos(a1 + (Math.PI / 4D)));
			double za = zo + (0.2D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a1 + (Math.PI / 4D)));

			double xA = xa + xm - xo;
			double yA = ya + ym - yo;
			double zA = za + zm - zo;

			double xb = xo + (0.2D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (3 * Math.PI / 4D)));
			double yb = xo + (0.2D * Math.cos(a1 + (3 * Math.PI / 4D)));
			double zb = zo + (0.2D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (3 * Math.PI / 4D)));

			double xB = xb + xm - xo;
			double yB = yb + ym - yo;
			double zB = zb + zm - zo;

			double xc = xo + (0.2D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (5 * Math.PI / 4D)));
			double yc = xo + (0.2D * Math.cos(a1 + (5 * Math.PI / 4D)));
			double zc = zo + (0.2D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (5 * Math.PI / 4D)));

			double xC = xc + xm - xo;
			double yC = yc + ym - yo;
			double zC = zc + zm - zo;

			double xd = xo + (0.2D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a1 + (7 * Math.PI / 4D)));
			double yd = xo + (0.2D * Math.cos(a1 + (7 * Math.PI / 4D)));
			double zd = zo + (0.2D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a1 + (7 * Math.PI / 4D)));

			double xD = xd + xm - xo;
			double yD = yd + ym - yo;
			double zD = zd + zm - zo;

			double t0 = 0.0D;
			double t1 = 1.0D;
			double t2 = (double)(-1.0F + f3);
			double t3 = (double)(256.0F * f1) * (0.5D / d4) + t2;
			
			double angle1Deg2 = angle1Deg + 180;
			double a12 = Math.toRadians(angle1Deg2);

			double xm2 = xo + (256 * Math.cos(a2) * Math.sin(a12));
			double ym2 = yo + (256 * Math.cos(a12));
			double zm2 = zo + (256 * Math.sin(a2) * Math.sin(a12));

			double xa2 = xo + (0.2D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a12 + (Math.PI / 4D)));
			double ya2 = xo + (0.2D * Math.cos(a12 + (Math.PI / 4D)));
			double za2 = zo + (0.2D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a12 + (Math.PI / 4D)));

			double xA2 = xa2 + xm2 - xo;
			double yA2 = ya2 + ym2 - yo;
			double zA2 = za2 + zm2 - zo;

			double xb2 = xo + (0.2D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (3 * Math.PI / 4D)));
			double yb2 = xo + (0.2D * Math.cos(a12 + (3 * Math.PI / 4D)));
			double zb2 = zo + (0.2D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (3 * Math.PI / 4D)));

			double xB2 = xb2 + xm2 - xo;
			double yB2 = yb2 + ym2 - yo;
			double zB2 = zb2 + zm2 - zo;

			double xc2 = xo + (0.2D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (5 * Math.PI / 4D)));
			double yc2 = xo + (0.2D * Math.cos(a12 + (5 * Math.PI / 4D)));
			double zc2 = zo + (0.2D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (5 * Math.PI / 4D)));

			double xC2 = xc2 + xm2 - xo;
			double yC2 = yc2 + ym2 - yo;
			double zC2 = zc2 + zm2 - zo;

			double xd2 = xo + (0.2D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a12 + (7 * Math.PI / 4D)));
			double yd2 = xo + (0.2D * Math.cos(a12 + (7 * Math.PI / 4D)));
			double zd2 = zo + (0.2D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a12 + (7 * Math.PI / 4D)));

			double xD2 = xd2 + xm2 - xo;
			double yD2 = yd2 + ym2 - yo;
			double zD2 = zd2 + zm2 - zo;

			if(tileentity.getDisplayAxe() == 0)
			{
				tessellator.addVertexWithUV(x + xa, y + ya, z + za, t1, t3);
				tessellator.addVertexWithUV(x + xA, y + yA, z + zA, t1, t2);
				tessellator.addVertexWithUV(x + xB, y + yB, z + zB, t0, t2);
				tessellator.addVertexWithUV(x + xb, y + yb, z + zb, t0, t3);

				tessellator.addVertexWithUV(x + xa, y + ya, z + za, t1, t3);
				tessellator.addVertexWithUV(x + xA, y + yA, z + zA, t1, t2);
				tessellator.addVertexWithUV(x + xC, y + yC, z + zC, t0, t2);
				tessellator.addVertexWithUV(x + xc, y + yc, z + zc, t0, t3);

				tessellator.addVertexWithUV(x + xc, y + yc, z + zc, t1, t3);
				tessellator.addVertexWithUV(x + xC, y + yC, z + zC, t1, t2);
				tessellator.addVertexWithUV(x + xD, y + yD, z + zD, t0, t2);
				tessellator.addVertexWithUV(x + xd, y + yd, z + zd, t0, t3);

				tessellator.addVertexWithUV(x + xb, y + yb, z + zb, t1, t3);
				tessellator.addVertexWithUV(x + xB, y + yB, z + zB, t1, t2);
				tessellator.addVertexWithUV(x + xD, y + yD, z + zD, t0, t2);
				tessellator.addVertexWithUV(x + xd, y + yd, z + zd, t0, t3);

				tessellator.addVertexWithUV(x + xb, y + yb, z + zb, t1, t3);
				tessellator.addVertexWithUV(x + xB, y + yB, z + zB, t1, t2);
				tessellator.addVertexWithUV(x + xC, y + yC, z + zC, t0, t2);
				tessellator.addVertexWithUV(x + xc, y + yc, z + zc, t0, t3);

				tessellator.addVertexWithUV(x + xa, y + ya, z + za, t1, t3);
				tessellator.addVertexWithUV(x + xA, y + yA, z + zA, t1, t2);
				tessellator.addVertexWithUV(x + xD, y + yD, z + zD, t0, t2);
				tessellator.addVertexWithUV(x + xd, y + yd, z + zd, t0, t3);
			}
			else if(tileentity.getDisplayAxe() == 1)
			{
				tessellator.addVertexWithUV(x + ya, y + xa, z + za, t1, t3);
				tessellator.addVertexWithUV(x + yA, y + xA, z + zA, t1, t2);
				tessellator.addVertexWithUV(x + yB, y + xB, z + zB, t0, t2);
				tessellator.addVertexWithUV(x + yb, y + xb, z + zb, t0, t3);

				tessellator.addVertexWithUV(x + ya, y + xa, z + za, t1, t3);
				tessellator.addVertexWithUV(x + yA, y + xA, z + zA, t1, t2);
				tessellator.addVertexWithUV(x + yC, y + xC, z + zC, t0, t2);
				tessellator.addVertexWithUV(x + yc, y + xc, z + zc, t0, t3);

				tessellator.addVertexWithUV(x + yc, y + xc, z + zc, t1, t3);
				tessellator.addVertexWithUV(x + yC, y + xC, z + zC, t1, t2);
				tessellator.addVertexWithUV(x + yD, y + xD, z + zD, t0, t2);
				tessellator.addVertexWithUV(x + yd, y + xd, z + zd, t0, t3);

				tessellator.addVertexWithUV(x + yb, y + xb, z + zb, t1, t3);
				tessellator.addVertexWithUV(x + yB, y + xB, z + zB, t1, t2);
				tessellator.addVertexWithUV(x + yD, y + xD, z + zD, t0, t2);
				tessellator.addVertexWithUV(x + yd, y + xd, z + zd, t0, t3);

				tessellator.addVertexWithUV(x + yb, y + xb, z + zb, t1, t3);
				tessellator.addVertexWithUV(x + yB, y + xB, z + zB, t1, t2);
				tessellator.addVertexWithUV(x + yC, y + xC, z + zC, t0, t2);
				tessellator.addVertexWithUV(x + yc, y + xc, z + zc, t0, t3);

				tessellator.addVertexWithUV(x + ya, y + xa, z + za, t1, t3);
				tessellator.addVertexWithUV(x + yA, y + xA, z + zA, t1, t2);
				tessellator.addVertexWithUV(x + yD, y + xD, z + zD, t0, t2);
				tessellator.addVertexWithUV(x + yd, y + xd, z + zd, t0, t3);
			}
			else if(tileentity.getDisplayAxe() == 2)
			{
				tessellator.addVertexWithUV(x + xa, y + za, z + ya, t1, t3);
				tessellator.addVertexWithUV(x + xA, y + zA, z + yA, t1, t2);
				tessellator.addVertexWithUV(x + xB, y + zB, z + yB, t0, t2);
				tessellator.addVertexWithUV(x + xb, y + zb, z + yb, t0, t3);

				tessellator.addVertexWithUV(x + xa, y + za, z + ya, t1, t3);
				tessellator.addVertexWithUV(x + xA, y + zA, z + yA, t1, t2);
				tessellator.addVertexWithUV(x + xC, y + zC, z + yC, t0, t2);
				tessellator.addVertexWithUV(x + xc, y + zc, z + yc, t0, t3);

				tessellator.addVertexWithUV(x + xc, y + zc, z + yc, t1, t3);
				tessellator.addVertexWithUV(x + xC, y + zC, z + yC, t1, t2);
				tessellator.addVertexWithUV(x + xD, y + zD, z + yD, t0, t2);
				tessellator.addVertexWithUV(x + xd, y + zd, z + yd, t0, t3);

				tessellator.addVertexWithUV(x + xb, y + zb, z + yb, t1, t3);
				tessellator.addVertexWithUV(x + xB, y + zB, z + yB, t1, t2);
				tessellator.addVertexWithUV(x + xD, y + zD, z + yD, t0, t2);
				tessellator.addVertexWithUV(x + xd, y + zd, z + yd, t0, t3);

				tessellator.addVertexWithUV(x + xb, y + zb, z + yb, t1, t3);
				tessellator.addVertexWithUV(x + xB, y + zB, z + yB, t1, t2);
				tessellator.addVertexWithUV(x + xC, y + zC, z + yC, t0, t2);
				tessellator.addVertexWithUV(x + xc, y + zc, z + yc, t0, t3);

				tessellator.addVertexWithUV(x + xa, y + za, z + ya, t1, t3);
				tessellator.addVertexWithUV(x + xA, y + zA, z + yA, t1, t2);
				tessellator.addVertexWithUV(x + xD, y + zD, z + yD, t0, t2);
				tessellator.addVertexWithUV(x + xd, y + zd, z + yd, t0, t3);
			}
			tessellator.draw();
			
			if(tileentity.isSideLaser())
			{
				tessellator.startDrawingQuads();
				tessellator.setColorRGBA(tileentity.getRed(), tileentity.getGreen(), tileentity.getBlue(), 32);

				if(tileentity.getDisplayAxe() == 0)
				{
					tessellator.addVertexWithUV(x + xa2, y + ya2, z + za2, t1, t3);
					tessellator.addVertexWithUV(x + xA2, y + yA2, z + zA2, t1, t2);
					tessellator.addVertexWithUV(x + xB2, y + yB2, z + zB2, t0, t2);
					tessellator.addVertexWithUV(x + xb2, y + yb2, z + zb2, t0, t3);

					tessellator.addVertexWithUV(x + xa2, y + ya2, z + za2, t1, t3);
					tessellator.addVertexWithUV(x + xA2, y + yA2, z + zA2, t1, t2);
					tessellator.addVertexWithUV(x + xC2, y + yC2, z + zC2, t0, t2);
					tessellator.addVertexWithUV(x + xc2, y + yc2, z + zc2, t0, t3);

					tessellator.addVertexWithUV(x + xc2, y + yc2, z + zc2, t1, t3);
					tessellator.addVertexWithUV(x + xC2, y + yC2, z + zC2, t1, t2);
					tessellator.addVertexWithUV(x + xD2, y + yD2, z + zD2, t0, t2);
					tessellator.addVertexWithUV(x + xd2, y + yd2, z + zd2, t0, t3);

					tessellator.addVertexWithUV(x + xb2, y + yb2, z + zb2, t1, t3);
					tessellator.addVertexWithUV(x + xB2, y + yB2, z + zB2, t1, t2);
					tessellator.addVertexWithUV(x + xD2, y + yD2, z + zD2, t0, t2);
					tessellator.addVertexWithUV(x + xd2, y + yd2, z + zd2, t0, t3);

					tessellator.addVertexWithUV(x + xb2, y + yb2, z + zb2, t1, t3);
					tessellator.addVertexWithUV(x + xB2, y + yB2, z + zB2, t1, t2);
					tessellator.addVertexWithUV(x + xC2, y + yC2, z + zC2, t0, t2);
					tessellator.addVertexWithUV(x + xc2, y + yc2, z + zc2, t0, t3);

					tessellator.addVertexWithUV(x + xa2, y + ya2, z + za2, t1, t3);
					tessellator.addVertexWithUV(x + xA2, y + yA2, z + zA2, t1, t2);
					tessellator.addVertexWithUV(x + xD2, y + yD2, z + zD2, t0, t2);
					tessellator.addVertexWithUV(x + xd2, y + yd2, z + zd2, t0, t3);
				}
				else if(tileentity.getDisplayAxe() == 1)
				{
					tessellator.addVertexWithUV(x + ya2, y + xa2, z + za2, t1, t3);
					tessellator.addVertexWithUV(x + yA2, y + xA2, z + zA2, t1, t2);
					tessellator.addVertexWithUV(x + yB2, y + xB2, z + zB2, t0, t2);
					tessellator.addVertexWithUV(x + yb2, y + xb2, z + zb2, t0, t3);

					tessellator.addVertexWithUV(x + ya2, y + xa2, z + za2, t1, t3);
					tessellator.addVertexWithUV(x + yA2, y + xA2, z + zA2, t1, t2);
					tessellator.addVertexWithUV(x + yC2, y + xC2, z + zC2, t0, t2);
					tessellator.addVertexWithUV(x + yc2, y + xc2, z + zc2, t0, t3);

					tessellator.addVertexWithUV(x + yc2, y + xc2, z + zc2, t1, t3);
					tessellator.addVertexWithUV(x + yC2, y + xC2, z + zC2, t1, t2);
					tessellator.addVertexWithUV(x + yD2, y + xD2, z + zD2, t0, t2);
					tessellator.addVertexWithUV(x + yd2, y + xd2, z + zd2, t0, t3);

					tessellator.addVertexWithUV(x + yb2, y + xb2, z + zb2, t1, t3);
					tessellator.addVertexWithUV(x + yB2, y + xB2, z + zB2, t1, t2);
					tessellator.addVertexWithUV(x + yD2, y + xD2, z + zD2, t0, t2);
					tessellator.addVertexWithUV(x + yd2, y + xd2, z + zd2, t0, t3);

					tessellator.addVertexWithUV(x + yb2, y + xb2, z + zb2, t1, t3);
					tessellator.addVertexWithUV(x + yB2, y + xB2, z + zB2, t1, t2);
					tessellator.addVertexWithUV(x + yC2, y + xC2, z + zC2, t0, t2);
					tessellator.addVertexWithUV(x + yc2, y + xc2, z + zc2, t0, t3);

					tessellator.addVertexWithUV(x + ya2, y + xa2, z + za2, t1, t3);
					tessellator.addVertexWithUV(x + yA2, y + xA2, z + zA2, t1, t2);
					tessellator.addVertexWithUV(x + yD2, y + xD2, z + zD2, t0, t2);
					tessellator.addVertexWithUV(x + yd2, y + xd2, z + zd2, t0, t3);
				}
				else if(tileentity.getDisplayAxe() == 2)
				{
					tessellator.addVertexWithUV(x + xa2, y + za2, z + ya2, t1, t3);
					tessellator.addVertexWithUV(x + xA2, y + zA2, z + yA2, t1, t2);
					tessellator.addVertexWithUV(x + xB2, y + zB2, z + yB2, t0, t2);
					tessellator.addVertexWithUV(x + xb2, y + zb2, z + yb2, t0, t3);

					tessellator.addVertexWithUV(x + xa2, y + za2, z + ya2, t1, t3);
					tessellator.addVertexWithUV(x + xA2, y + zA2, z + yA2, t1, t2);
					tessellator.addVertexWithUV(x + xC2, y + zC2, z + yC2, t0, t2);
					tessellator.addVertexWithUV(x + xc2, y + zc2, z + yc2, t0, t3);

					tessellator.addVertexWithUV(x + xc2, y + zc2, z + yc2, t1, t3);
					tessellator.addVertexWithUV(x + xC2, y + zC2, z + yC2, t1, t2);
					tessellator.addVertexWithUV(x + xD2, y + zD2, z + yD2, t0, t2);
					tessellator.addVertexWithUV(x + xd2, y + zd2, z + yd2, t0, t3);

					tessellator.addVertexWithUV(x + xb2, y + zb2, z + yb2, t1, t3);
					tessellator.addVertexWithUV(x + xB2, y + zB2, z + yB2, t1, t2);
					tessellator.addVertexWithUV(x + xD2, y + zD2, z + yD2, t0, t2);
					tessellator.addVertexWithUV(x + xd2, y + zd2, z + yd2, t0, t3);

					tessellator.addVertexWithUV(x + xb2, y + zb2, z + yb2, t1, t3);
					tessellator.addVertexWithUV(x + xB2, y + zB2, z + yB2, t1, t2);
					tessellator.addVertexWithUV(x + xC2, y + zC2, z + yC2, t0, t2);
					tessellator.addVertexWithUV(x + xc2, y + zc2, z + yc2, t0, t3);

					tessellator.addVertexWithUV(x + xa2, y + za2, z + ya2, t1, t3);
					tessellator.addVertexWithUV(x + xA2, y + zA2, z + yA2, t1, t2);
					tessellator.addVertexWithUV(x + xD2, y + zD2, z + yD2, t0, t2);
					tessellator.addVertexWithUV(x + xd2, y + zd2, z + yd2, t0, t3);
				}
				tessellator.draw();
			}


			GuiHelper.bindTexture(UtilSpotLight.getEntryByName(tileentity.getSecTextureName()).getPath());
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glDepthMask(false);

			double xe = xo + (0.5D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a1 + (Math.PI / 4D)));
			double ye = xo + (0.5D * Math.cos(a1 + (Math.PI / 4D)));
			double ze = zo + (0.5D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a1 + (Math.PI / 4D)));

			double xE = xe + xm - xo;
			double yE = ye + ym - yo;
			double zE = ze + zm - zo;

			double xf = xo + (0.5D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (3 * Math.PI / 4D)));
			double yf = xo + (0.5D * Math.cos(a1 + (3 * Math.PI / 4D)));
			double zf = zo + (0.5D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (3 * Math.PI / 4D)));

			double xF = xf + xm - xo;
			double yF = yf + ym - yo;
			double zF = zf + zm - zo;

			double xg = xo + (0.5D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (5 * Math.PI / 4D)));
			double yg = xo + (0.5D * Math.cos(a1 + (5 * Math.PI / 4D)));
			double zg = zo + (0.5D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a1 + (5 * Math.PI / 4D)));

			double xG = xg + xm - xo;
			double yG = yg + ym - yo;
			double zG = zg + zm - zo;

			double xh = xo + (0.5D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a1 + (7 * Math.PI / 4D)));
			double yh = xo + (0.5D * Math.cos(a1 + (7 * Math.PI / 4D)));
			double zh = zo + (0.5D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a1 + (7 * Math.PI / 4D)));

			double xH = xh + xm - xo;
			double yH = yh + ym - yo;
			double zH = zh + zm - zo;

			if(tileentity.isSecondaryLaser())
			{
				tessellator.startDrawingQuads();
				tessellator.setColorRGBA(tileentity.getSecRed(), tileentity.getSecGreen(), tileentity.getSecBlue(), 32);
				
				if(tileentity.getDisplayAxe() == 0)
				{
					tessellator.addVertexWithUV(x + xe, y + ye, z + ze, t1, t3);
					tessellator.addVertexWithUV(x + xE, y + yE, z + zE, t1, t2);
					tessellator.addVertexWithUV(x + xF, y + yF, z + zF, t0, t2);
					tessellator.addVertexWithUV(x + xf, y + yf, z + zf, t0, t3);

					tessellator.addVertexWithUV(x + xe, y + ye, z + ze, t1, t3);
					tessellator.addVertexWithUV(x + xE, y + yE, z + zE, t1, t2);
					tessellator.addVertexWithUV(x + xG, y + yG, z + zG, t0, t2);
					tessellator.addVertexWithUV(x + xg, y + yg, z + zg, t0, t3);

					tessellator.addVertexWithUV(x + xg, y + yg, z + zg, t1, t3);
					tessellator.addVertexWithUV(x + xG, y + yG, z + zG, t1, t2);
					tessellator.addVertexWithUV(x + xH, y + yH, z + zH, t0, t2);
					tessellator.addVertexWithUV(x + xh, y + yh, z + zh, t0, t3);

					tessellator.addVertexWithUV(x + xf, y + yf, z + zf, t1, t3);
					tessellator.addVertexWithUV(x + xF, y + yF, z + zF, t1, t2);
					tessellator.addVertexWithUV(x + xH, y + yH, z + zH, t0, t2);
					tessellator.addVertexWithUV(x + xh, y + yh, z + zh, t0, t3);

					tessellator.addVertexWithUV(x + xf, y + yf, z + zf, t1, t3);
					tessellator.addVertexWithUV(x + xF, y + yF, z + zF, t1, t2);
					tessellator.addVertexWithUV(x + xG, y + yG, z + zG, t0, t2);
					tessellator.addVertexWithUV(x + xg, y + yg, z + zg, t0, t3);

					tessellator.addVertexWithUV(x + xe, y + ya, z + za, t1, t3);
					tessellator.addVertexWithUV(x + xE, y + yE, z + zE, t1, t2);
					tessellator.addVertexWithUV(x + xD, y + yD, z + zD, t0, t2);
					tessellator.addVertexWithUV(x + xd, y + yd, z + zd, t0, t3);
				}
				else if(tileentity.getDisplayAxe() == 1)
				{
					tessellator.addVertexWithUV(x + ye, y + xe, z + ze, t1, t3);
					tessellator.addVertexWithUV(x + yE, y + xE, z + zE, t1, t2);
					tessellator.addVertexWithUV(x + yF, y + xF, z + zF, t0, t2);
					tessellator.addVertexWithUV(x + yf, y + xf, z + zf, t0, t3);

					tessellator.addVertexWithUV(x + ye, y + xe, z + ze, t1, t3);
					tessellator.addVertexWithUV(x + yE, y + xE, z + zE, t1, t2);
					tessellator.addVertexWithUV(x + yG, y + xG, z + zG, t0, t2);
					tessellator.addVertexWithUV(x + yg, y + xg, z + zg, t0, t3);

					tessellator.addVertexWithUV(x + yg, y + xg, z + zg, t1, t3);
					tessellator.addVertexWithUV(x + yG, y + xG, z + zG, t1, t2);
					tessellator.addVertexWithUV(x + yH, y + xH, z + zH, t0, t2);
					tessellator.addVertexWithUV(x + yh, y + xh, z + zh, t0, t3);

					tessellator.addVertexWithUV(x + yf, y + xf, z + zf, t1, t3);
					tessellator.addVertexWithUV(x + yF, y + xF, z + zF, t1, t2);
					tessellator.addVertexWithUV(x + yH, y + xH, z + zH, t0, t2);
					tessellator.addVertexWithUV(x + yh, y + xh, z + zh, t0, t3);

					tessellator.addVertexWithUV(x + yf, y + xf, z + zf, t1, t3);
					tessellator.addVertexWithUV(x + yF, y + xF, z + zF, t1, t2);
					tessellator.addVertexWithUV(x + yG, y + xG, z + zG, t0, t2);
					tessellator.addVertexWithUV(x + yg, y + xg, z + zg, t0, t3);

					tessellator.addVertexWithUV(x + ye, y + xa, z + za, t1, t3);
					tessellator.addVertexWithUV(x + yE, y + xE, z + zE, t1, t2);
					tessellator.addVertexWithUV(x + yD, y + xD, z + zD, t0, t2);
					tessellator.addVertexWithUV(x + yd, y + xd, z + zd, t0, t3);
				}
				else if(tileentity.getDisplayAxe() == 2)
				{
					tessellator.addVertexWithUV(x + xe, y + ze, z + ye, t1, t3);
					tessellator.addVertexWithUV(x + xE, y + zE, z + yE, t1, t2);
					tessellator.addVertexWithUV(x + xF, y + zF, z + yF, t0, t2);
					tessellator.addVertexWithUV(x + xf, y + zf, z + yf, t0, t3);

					tessellator.addVertexWithUV(x + xe, y + ze, z + ye, t1, t3);
					tessellator.addVertexWithUV(x + xE, y + zE, z + yE, t1, t2);
					tessellator.addVertexWithUV(x + xG, y + zG, z + yG, t0, t2);
					tessellator.addVertexWithUV(x + xg, y + zg, z + yg, t0, t3);

					tessellator.addVertexWithUV(x + xg, y + zg, z + yg, t1, t3);
					tessellator.addVertexWithUV(x + xG, y + zG, z + yG, t1, t2);
					tessellator.addVertexWithUV(x + xH, y + zH, z + yH, t0, t2);
					tessellator.addVertexWithUV(x + xh, y + zh, z + yh, t0, t3);

					tessellator.addVertexWithUV(x + xf, y + zf, z + yf, t1, t3);
					tessellator.addVertexWithUV(x + xF, y + zF, z + yF, t1, t2);
					tessellator.addVertexWithUV(x + xH, y + zH, z + yH, t0, t2);
					tessellator.addVertexWithUV(x + xh, y + zh, z + yh, t0, t3);

					tessellator.addVertexWithUV(x + xf, y + zf, z + yf, t1, t3);
					tessellator.addVertexWithUV(x + xF, y + zF, z + yF, t1, t2);
					tessellator.addVertexWithUV(x + xG, y + zG, z + yG, t0, t2);
					tessellator.addVertexWithUV(x + xg, y + zg, z + yg, t0, t3);

					tessellator.addVertexWithUV(x + xe, y + za, z + ya, t1, t3);
					tessellator.addVertexWithUV(x + xE, y + zE, z + yE, t1, t2);
					tessellator.addVertexWithUV(x + xD, y + zD, z + yD, t0, t2);
					tessellator.addVertexWithUV(x + xd, y + zd, z + yd, t0, t3);
				}
				tessellator.draw();
				
				if(tileentity.isSideLaser())
				{
					double xe2 = xo + (0.5D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a12 + (Math.PI / 4D)));
					double ye2 = xo + (0.5D * Math.cos(a12 + (Math.PI / 4D)));
					double ze2 = zo + (0.5D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a12 + (Math.PI / 4D)));

					double xE2 = xe2 + xm2 - xo;
					double yE2 = ye2 + ym2 - yo;
					double zE2 = ze2 + zm2 - zo;

					double xf2 = xo + (0.5D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (3 * Math.PI / 4D)));
					double yf2 = xo + (0.5D * Math.cos(a12 + (3 * Math.PI / 4D)));
					double zf2 = zo + (0.5D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (3 * Math.PI / 4D)));

					double xF2 = xf2 + xm2 - xo;
					double yF2 = yf2 + ym2 - yo;
					double zF2 = zf2 + zm2 - zo;

					double xg2 = xo + (0.5D * Math.cos(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (5 * Math.PI / 4D)));
					double yg2 = xo + (0.5D * Math.cos(a12 + (5 * Math.PI / 4D)));
					double zg2 = zo + (0.5D * Math.sin(a2 + (3 * Math.PI / 4D)) * Math.sin(a12 + (5 * Math.PI / 4D)));

					double xG2 = xg2 + xm2 - xo;
					double yG2 = yg2 + ym2 - yo;
					double zG2 = zg2 + zm2 - zo;

					double xh2 = xo + (0.5D * Math.cos(a2 + (Math.PI / 4D)) * Math.sin(a12 + (7 * Math.PI / 4D)));
					double yh2 = xo + (0.5D * Math.cos(a12 + (7 * Math.PI / 4D)));
					double zh2 = zo + (0.5D * Math.sin(a2 + (Math.PI / 4D)) * Math.sin(a12 + (7 * Math.PI / 4D)));

					double xH2 = xh2 + xm2 - xo;
					double yH2 = yh2 + ym2 - yo;
					double zH2 = zh2 + zm2 - zo;

					if(tileentity.isSecondaryLaser())
					{
						tessellator.startDrawingQuads();
						tessellator.setColorRGBA(tileentity.getSecRed(), tileentity.getSecGreen(), tileentity.getSecBlue(), 32);
						
						if(tileentity.getDisplayAxe() == 0)
						{
							tessellator.addVertexWithUV(x + xe2, y + ye2, z + ze2, t1, t3);
							tessellator.addVertexWithUV(x + xE2, y + yE2, z + zE2, t1, t2);
							tessellator.addVertexWithUV(x + xF2, y + yF2, z + zF2, t0, t2);
							tessellator.addVertexWithUV(x + xf2, y + yf2, z + zf2, t0, t3);

							tessellator.addVertexWithUV(x + xe2, y + ye2, z + ze2, t1, t3);
							tessellator.addVertexWithUV(x + xE2, y + yE2, z + zE2, t1, t2);
							tessellator.addVertexWithUV(x + xG2, y + yG2, z + zG2, t0, t2);
							tessellator.addVertexWithUV(x + xg2, y + yg2, z + zg2, t0, t3);

							tessellator.addVertexWithUV(x + xg2, y + yg2, z + zg2, t1, t3);
							tessellator.addVertexWithUV(x + xG2, y + yG2, z + zG2, t1, t2);
							tessellator.addVertexWithUV(x + xH2, y + yH2, z + zH2, t0, t2);
							tessellator.addVertexWithUV(x + xh2, y + yh2, z + zh2, t0, t3);

							tessellator.addVertexWithUV(x + xf2, y + yf2, z + zf2, t1, t3);
							tessellator.addVertexWithUV(x + xF2, y + yF2, z + zF2, t1, t2);
							tessellator.addVertexWithUV(x + xH2, y + yH2, z + zH2, t0, t2);
							tessellator.addVertexWithUV(x + xh2, y + yh2, z + zh2, t0, t3);

							tessellator.addVertexWithUV(x + xf2, y + yf2, z + zf2, t1, t3);
							tessellator.addVertexWithUV(x + xF2, y + yF2, z + zF2, t1, t2);
							tessellator.addVertexWithUV(x + xG2, y + yG2, z + zG2, t0, t2);
							tessellator.addVertexWithUV(x + xg2, y + yg2, z + zg2, t0, t3);

							tessellator.addVertexWithUV(x + xe2, y + ya2, z + za2, t1, t3);
							tessellator.addVertexWithUV(x + xE2, y + yE2, z + zE2, t1, t2);
							tessellator.addVertexWithUV(x + xD2, y + yD2, z + zD2, t0, t2);
							tessellator.addVertexWithUV(x + xd2, y + yd2, z + zd2, t0, t3);
						}
						else if(tileentity.getDisplayAxe() == 1)
						{
							tessellator.addVertexWithUV(x + ye2, y + xe2, z + ze2, t1, t3);
							tessellator.addVertexWithUV(x + yE2, y + xE2, z + zE2, t1, t2);
							tessellator.addVertexWithUV(x + yF2, y + xF2, z + zF2, t0, t2);
							tessellator.addVertexWithUV(x + yf2, y + xf2, z + zf2, t0, t3);

							tessellator.addVertexWithUV(x + ye2, y + xe2, z + ze2, t1, t3);
							tessellator.addVertexWithUV(x + yE2, y + xE2, z + zE2, t1, t2);
							tessellator.addVertexWithUV(x + yG2, y + xG2, z + zG2, t0, t2);
							tessellator.addVertexWithUV(x + yg2, y + xg2, z + zg2, t0, t3);

							tessellator.addVertexWithUV(x + yg2, y + xg2, z + zg2, t1, t3);
							tessellator.addVertexWithUV(x + yG2, y + xG2, z + zG2, t1, t2);
							tessellator.addVertexWithUV(x + yH2, y + xH2, z + zH2, t0, t2);
							tessellator.addVertexWithUV(x + yh2, y + xh2, z + zh2, t0, t3);

							tessellator.addVertexWithUV(x + yf2, y + xf2, z + zf2, t1, t3);
							tessellator.addVertexWithUV(x + yF2, y + xF2, z + zF2, t1, t2);
							tessellator.addVertexWithUV(x + yH2, y + xH2, z + zH2, t0, t2);
							tessellator.addVertexWithUV(x + yh2, y + xh2, z + zh2, t0, t3);

							tessellator.addVertexWithUV(x + yf2, y + xf2, z + zf2, t1, t3);
							tessellator.addVertexWithUV(x + yF2, y + xF2, z + zF2, t1, t2);
							tessellator.addVertexWithUV(x + yG2, y + xG2, z + zG2, t0, t2);
							tessellator.addVertexWithUV(x + yg2, y + xg2, z + zg2, t0, t3);

							tessellator.addVertexWithUV(x + ye2, y + xa2, z + za2, t1, t3);
							tessellator.addVertexWithUV(x + yE2, y + xE2, z + zE2, t1, t2);
							tessellator.addVertexWithUV(x + yD2, y + xD2, z + zD2, t0, t2);
							tessellator.addVertexWithUV(x + yd2, y + xd2, z + zd2, t0, t3);
						}
						else if(tileentity.getDisplayAxe() == 2)
						{
							tessellator.addVertexWithUV(x + xe2, y + ze2, z + ye2, t1, t3);
							tessellator.addVertexWithUV(x + xE2, y + zE2, z + yE2, t1, t2);
							tessellator.addVertexWithUV(x + xF2, y + zF2, z + yF2, t0, t2);
							tessellator.addVertexWithUV(x + xf2, y + zf2, z + yf2, t0, t3);

							tessellator.addVertexWithUV(x + xe2, y + ze2, z + ye2, t1, t3);
							tessellator.addVertexWithUV(x + xE2, y + zE2, z + yE2, t1, t2);
							tessellator.addVertexWithUV(x + xG2, y + zG2, z + yG2, t0, t2);
							tessellator.addVertexWithUV(x + xg2, y + zg2, z + yg2, t0, t3);

							tessellator.addVertexWithUV(x + xg2, y + zg2, z + yg2, t1, t3);
							tessellator.addVertexWithUV(x + xG2, y + zG2, z + yG2, t1, t2);
							tessellator.addVertexWithUV(x + xH2, y + zH2, z + yH2, t0, t2);
							tessellator.addVertexWithUV(x + xh2, y + zh2, z + yh2, t0, t3);

							tessellator.addVertexWithUV(x + xf2, y + zf2, z + yf2, t1, t3);
							tessellator.addVertexWithUV(x + xF2, y + zF2, z + yF2, t1, t2);
							tessellator.addVertexWithUV(x + xH2, y + zH2, z + yH2, t0, t2);
							tessellator.addVertexWithUV(x + xh2, y + zh2, z + yh2, t0, t3);

							tessellator.addVertexWithUV(x + xf2, y + zf2, z + yf2, t1, t3);
							tessellator.addVertexWithUV(x + xF2, y + zF2, z + yF2, t1, t2);
							tessellator.addVertexWithUV(x + xG2, y + zG2, z + yG2, t0, t2);
							tessellator.addVertexWithUV(x + xg2, y + zg2, z + yg2, t0, t3);

							tessellator.addVertexWithUV(x + xe2, y + za2, z + ya2, t1, t3);
							tessellator.addVertexWithUV(x + xE2, y + zE2, z + yE2, t1, t2);
							tessellator.addVertexWithUV(x + xD2, y + zD2, z + yD2, t0, t2);
							tessellator.addVertexWithUV(x + xd2, y + zd2, z + yd2, t0, t3);
						}
						tessellator.draw();
					}
				}
			}
			
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDepthMask(true);
		}
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.5F);
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick)
	{
		this.renderTileEntitySpotLightAt((TileEntitySpotLight)tileentity, x, y, z, tick);
	}
}