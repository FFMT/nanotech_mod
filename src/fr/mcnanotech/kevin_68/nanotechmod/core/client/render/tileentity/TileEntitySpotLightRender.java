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
			double a2 = tileentity.isAutoRotate() ? ((d3 * (tileentity.getRotationSpeed())) * (tileentity.isReverseRotation() ? -1 : 1)) : Math.toRadians(angle2Deg);

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
			tessellator.draw();

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
				tessellator.draw();
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