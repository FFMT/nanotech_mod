/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.model.blocks.ModelBlockTrail;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.model.blocks.ModelBlockTrailTilted;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrail;
import fr.mcnanotech.kevin_68.nanotechmod.city.utils.CTHelper;

public class TileEntityTrailRenderTESR extends TileEntitySpecialRenderer
{
	private final ModelBlockTrail model;
	private final ModelBlockTrailTilted model2;
	protected static final ResourceLocation texture = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model1.png");
	protected static final ResourceLocation texture2 = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model2.png");
	protected static final ResourceLocation texture3 = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model3.png");
	protected static final ResourceLocation texture4 = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model4.png");
	protected static final ResourceLocation texture5 = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model5.png");
	protected static final ResourceLocation texture6 = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model6.png");
	protected static final ResourceLocation texture7 = new ResourceLocation(NanotechModCity.MODID + ":textures/blocks/trail/model7.png");

	public TileEntityTrailRenderTESR()
	{
		this.model = new ModelBlockTrail();
		this.model2 = new ModelBlockTrailTilted();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
	{
		this.renderTileEntityAtBlockTrail((TileEntityTrail)tileentity, x, y, z, scale);
	}

	public void renderTileEntityAtBlockTrail(TileEntityTrail tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

		boolean[] flag = CTHelper.get(tileentity.getWorldObj(), tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, NanotechCityBlock.trail);

		if(flag[CTHelper.VrN] || flag[CTHelper.SrN] || flag[CTHelper.tErN] || flag[CTHelper.tWrN] || flag[CTHelper.tEWrN] || flag[CTHelper.tSEWrN] || flag[CTHelper.tNSEWrN])
		{
			GL11.glScalef(1.0F, 0.99F, 0.999F);
			GL11.glTranslatef(0.0F, -0.015F, 0.004F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model2.render(0.0625F, 0);
		}
		else if(flag[CTHelper.VrS] || flag[CTHelper.NrS] || flag[CTHelper.tErS] || flag[CTHelper.tWrS] || flag[CTHelper.tEWrS] || flag[CTHelper.tNEWrS] || flag[CTHelper.tNSEWrS])
		{
			GL11.glScalef(1.0F, 0.99F, 0.999F);
			GL11.glTranslatef(0.0F, -0.015F, -0.0048F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 0);
		}
		else if(flag[CTHelper.VrE] || flag[CTHelper.WrE] || flag[CTHelper.tNrE] || flag[CTHelper.tSrE]  || flag[CTHelper.tNSrE] || flag[CTHelper.tNSWrE] || flag[CTHelper.tNSEWrE])
		{
			GL11.glScalef(0.999F, 0.99F, 1.0F);
			GL11.glTranslatef(-0.004F, -0.015F, 0.0F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 0);
		}
		else if(flag[CTHelper.VrW] || flag[CTHelper.ErW] || flag[CTHelper.tNrW] || flag[CTHelper.tSrW]  || flag[CTHelper.tNSrW] || flag[CTHelper.tNSErW] || flag[CTHelper.tNSEWrW])
		{
			GL11.glScalef(0.999F, 0.99F, 1.0F);
			GL11.glTranslatef(0.004F, -0.015F, 0.0F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 0);
		}
		else if(flag[CTHelper.VrNS])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.00F);
			this.bindTexture(texture3);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model2.render(0.0625F, 1);
		}
		else if(flag[CTHelper.VrEW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.00F);
			this.bindTexture(texture3);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 1);
		}
		else if(flag[CTHelper.VrNE] || flag[CTHelper.tSrNE] || flag[CTHelper.tWrNE])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(-0.0045F, -0.015F, 0.0045F);
			this.bindTexture(texture5);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model2.render(0.0625F, 4);
		}
		else if(flag[CTHelper.VrNW] || flag[CTHelper.tSrNW] || flag[CTHelper.tErNW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0046F, -0.015F, 0.0046F);
			this.bindTexture(texture5);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 4);
		}
		else if(flag[CTHelper.VrSE] || flag[CTHelper.tNrSE] || flag[CTHelper.tWrSE])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(-0.0046F, -0.015F, -0.0046F);
			this.bindTexture(texture5);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 4);
		}
		else if(flag[CTHelper.VrSW] || flag[CTHelper.tNrSW] || flag[CTHelper.tErSW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0046F, -0.015F, -0.0046F);
			this.bindTexture(texture5);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 4);
		}
		else if(flag[CTHelper.VrNSE])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.0F);
			this.bindTexture(texture7);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 6);
		}
		else if(flag[CTHelper.VrNSW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.0F);
			this.bindTexture(texture7);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model2.render(0.0625F, 6);
		}
		else if(flag[CTHelper.VrNEW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.0F);
			this.bindTexture(texture7);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 6);
		}
		else if(flag[CTHelper.VrSEW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.0F);
			this.bindTexture(texture7);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 6);
		}
		else if(flag[CTHelper.VrNSEW])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0F, -0.015F, 0.0F);
			this.bindTexture(texture6);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model2.render(0.0625F, 5);
		}
		else if(flag[CTHelper.tNErne])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(-0.0048F, -0.015F, 0.0048F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model2.render(0.0625F, 2);
			this.bindTexture(texture4);
			this.model2.render(0.0625F, 3);
		}
		else if(flag[CTHelper.tNWrnw])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0048F, -0.015F, 0.0048F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 2);
			this.bindTexture(texture4);
			this.model2.render(0.0625F, 3);
		}
		else if(flag[CTHelper.tSErse])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(-0.0048F, -0.015F, -0.0048F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 2);
			this.bindTexture(texture4);
			this.model2.render(0.0625F, 3);
		}
		else if(flag[CTHelper.tSWrsw])
		{
			GL11.glScalef(0.99F, 0.99F, 0.99F);
			GL11.glTranslatef(0.0048F, -0.015F, -0.0048F);
			this.bindTexture(texture2);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			this.model2.render(0.0625F, 2);
			this.bindTexture(texture4);
			this.model2.render(0.0625F, 3);
		}
		else
		{
			GL11.glScalef(0.9995F, 0.9995F, 0.9995F);
			GL11.glTranslatef(0.0F, -0.0046F, 0.0F);
			this.bindTexture(texture);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.model.render(0.0625F);
		}
		GL11.glPopMatrix();
	}
}