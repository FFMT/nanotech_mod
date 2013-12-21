package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;

@SideOnly(Side.CLIENT)
public class TileEntitySpotLightRender extends TileEntitySpecialRenderer
{
	protected static final ResourceLocation texture = new ResourceLocation("textures/entity/beacon_beam.png");

	public void renderTileEntitySpotLightAt(TileEntitySpotLight tileentity, double x, double y, double z, float par8)
	{
		float f1 = tileentity.func_82125_v_();

		if(f1 > 0.0F)
		{
			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(texture);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA(tileentity.getRedValue(), tileentity.getGreenValue(), tileentity.getBlueValue(), 32);
			float f2 = (float)tileentity.getWorldObj().getTotalWorldTime() + par8;
			float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
			byte b0 = 1;
			double d4 = (double)b0 * 0.2D;// taille
			double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
			
			double angle1Deg = tileentity.getAngle1();
			double angle2Deg = tileentity.getAngle2();
			double a1 = Math.toRadians(angle1Deg);
			double a2 = !tileentity.getAutoRotate() ? d3 * (tileentity.getRotationSpeed()/10): Math.toRadians(angle2Deg);
			
			double xo = 0.5D;
			double yo = 0.5D;
			double zo = 0.5D;
			double xm = xo + (256 * Math.cos(a2) * Math.sin(a1));
			double ym = yo + (256 * Math.cos(a1));
			double zm = zo + (256 * Math.sin(a2) * Math.sin(a1));
			
			double xa = xo + (0.2D * Math.cos(a2 + (Math.PI/4D)) * Math.sin(a1 + (Math.PI/4D)));
			double ya = xo + (0.2D * Math.cos(a1 + (Math.PI/4D)));
			double za = zo + (0.2D * Math.sin(a2 + (Math.PI/4D)) * Math.sin(a1 + (Math.PI/4D)));
			
			double xA = xa + xm - xo;
			double yA = ya + ym - yo;
			double zA = za + zm - zo;
			
			double xb = xo + (0.2D * Math.cos(a2 + (3*Math.PI/4D)) * Math.sin(a1 + (3*Math.PI/4D)));
			double yb = xo + (0.2D * Math.cos(a1 + (3*Math.PI/4D)));
			double zb = zo + (0.2D * Math.sin(a2 + (3*Math.PI/4D)) * Math.sin(a1 + (3*Math.PI/4D)));
			
			double xB = xb + xm - xo;
			double yB = yb + ym - yo;
			double zB = zb + zm - zo;
			
			double xc = xo + (0.2D * Math.cos(a2 + (3*Math.PI/4D)) * Math.sin(a1 + (5*Math.PI/4D)));
			double yc = xo + (0.2D * Math.cos(a1 + (5*Math.PI/4D)));
			double zc = zo + (0.2D * Math.sin(a2 + (3*Math.PI/4D)) * Math.sin(a1 + (5*Math.PI/4D)));
			
			double xC = xc + xm - xo;
			double yC = yc + ym - yo;
			double zC = zc + zm - zo;
			
			double xd = xo + (0.2D * Math.cos(a2 + (Math.PI/4D)) * Math.sin(a1 + (7*Math.PI/4D)));
			double yd = xo + (0.2D * Math.cos(a1 + (7*Math.PI/4D)));
			double zd = zo + (0.2D * Math.sin(a2 + (Math.PI/4D)) * Math.sin(a1 + (7*Math.PI/4D)));
			
			double xD = xd + xm - xo;
			double yD = yd + ym - yo;
			double zD = zd + zm - zo;
			
			double t0 = 0.0D;
			double t1 = 1.0D;
			double t2 = (double)(-1.0F + f3);
			double t3 = (double)(256.0F * f1) * (0.5D / d4) + t2;
			

			//tessellator.addVertexWithUV(x + xm, y + ym, z + zm);
			//tessellator.addVertexWithUV(x + xo, y + yo, z + zo);
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
			
			
			
			
			

			double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d4;
			double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d4;
			double d7 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d4;
			double d8 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d4;
			double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d4;
			double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d4;
			double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d4;
			double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d4;
			double d13 = (double)(256.0F * f1);			
			double d14 = 0.0D;
			double d15 = 1.0D;
			double d16 = (double)(-1.0F + f3);
			double d17 = (double)(256.0F * f1) * (0.5D / d4) + d16;
			
			/*tessellator.addVertexWithUV(x + d5, y + d13, z + d6, d15, d17);
			tessellator.addVertexWithUV(x + d5, y, z + d6, d15, d16);
			tessellator.addVertexWithUV(x + d7, y, z + d8, d14, d16);
			tessellator.addVertexWithUV(x + d7, y + d13, z + d8, d14, d17);
			tessellator.addVertexWithUV(x + d11, y + d13, z + d12, d15, d17);
			tessellator.addVertexWithUV(x + d11, y, z + d12, d15, d16);
			tessellator.addVertexWithUV(x + d9, y, z + d10, d14, d16);
			tessellator.addVertexWithUV(x + d9, y + d13, z + d10, d14, d17);
			tessellator.addVertexWithUV(x + d7, y + d13, z + d8, d15, d17);
			tessellator.addVertexWithUV(x + d7, y, z + d8, d15, d16);
			tessellator.addVertexWithUV(x + d11, y, z + d12, d14, d16);
			tessellator.addVertexWithUV(x + d11, y + d13, z + d12, d14, d17);
			tessellator.addVertexWithUV(x + d9, y + d13, z + d10, d15, d17);
			tessellator.addVertexWithUV(x + d9, y, z + d10, d15, d16);
			tessellator.addVertexWithUV(x + d5, y, z + d6, d14, d16);
			tessellator.addVertexWithUV(x + d5, y + d13, z + d6, d14, d17);
			tessellator.draw();*/
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glDepthMask(false);
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA(tileentity.getDarkRedValue(), tileentity.getDarkGreenValue(), tileentity.getDarkBlueValue(), 32);
			double d18 = 0.2D;
			double d19 = 0.2D;
			double d20 = 0.8D;
			double d21 = 0.2D;
			double d22 = 0.2D;
			double d23 = 0.8D;
			double d24 = 0.8D;
			double d25 = 0.8D;
			double d26 = (double)(256.0F * f1);

			double d27 = 0.0D;
			double d28 = 1.0D;
			double d29 = (double)(-1.0F + f3);
			double d30 = (double)(256.0F * f1) + d29;
			tessellator.addVertexWithUV(x + d18, y + d26, z + d19, d28, d30);
			tessellator.addVertexWithUV(x + d18, y, z + d19, d28, d29);
			tessellator.addVertexWithUV(x + d20, y, z + d21, d27, d29);
			tessellator.addVertexWithUV(x + d20, y + d26, z + d21, d27, d30);
			tessellator.addVertexWithUV(x + d24, y + d26, z + d25, d28, d30);
			tessellator.addVertexWithUV(x + d24, y, z + d25, d28, d29);
			tessellator.addVertexWithUV(x + d22, y, z + d23, d27, d29);
			tessellator.addVertexWithUV(x + d22, y + d26, z + d23, d27, d30);
			tessellator.addVertexWithUV(x + d20, y + d26, z + d21, d28, d30);
			tessellator.addVertexWithUV(x + d20, y, z + d21, d28, d29);
			tessellator.addVertexWithUV(x + d24, y, z + d25, d27, d29);
			tessellator.addVertexWithUV(x + d24, y + d26, z + d25, d27, d30);
			tessellator.addVertexWithUV(x + d22, y + d26, z + d23, d28, d30);
			tessellator.addVertexWithUV(x + d22, y, z + d23, d28, d29);
			tessellator.addVertexWithUV(x + d18, y, z + d19, d27, d29);
			tessellator.addVertexWithUV(x + d18, y + d26, z + d19, d27, d30);
			tessellator.draw();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDepthMask(true);
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float par8)
	{
		this.renderTileEntitySpotLightAt((TileEntitySpotLight)tileentity, x, y, z, par8);
	}
}