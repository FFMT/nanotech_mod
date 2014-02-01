package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.blocks.ModelPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.minecraftforgefrance.ffmtlibs.renderer.TileEntityInventorySpecialRenderer;

public class TileEntityPortableChestRender extends TileEntityInventorySpecialRenderer
{
	private final ModelPortableChest model;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/blocks/portablechest.png");

	public TileEntityPortableChestRender()
	{
		this.model = new ModelPortableChest();
	}
	
	@Override
	public void renderInventory(double x, double y, double z)
	{
		this.renderTileEntityAtPortableChest(null, x, y, z, 0);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
	{
		this.renderTileEntityAtPortableChest((TileEntityPortableChest)tileentity, x, y, z, scale);
	}

	public void renderTileEntityAtPortableChest(TileEntityPortableChest tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(tileentity != null)
		{
			if(tileentity.getDirection() == (byte)0)
			{
				GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			}
			else if(tileentity.getDirection() == (byte)1)
			{
				GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
			}
			else if(tileentity.getDirection() == (byte)2)
			{
				GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
			}
			else if(tileentity.getDirection() == (byte)3)
			{
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			}
		}
		else
		{
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		}
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block)
	{
		Tessellator tess = Tessellator.instance;
		float brightness = block.getBlockBrightness(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)modulousModifier, divModifier);
	}

}