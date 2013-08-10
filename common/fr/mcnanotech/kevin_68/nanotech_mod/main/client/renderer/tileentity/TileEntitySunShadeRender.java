package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.blocks.ModelBlockSunShade;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySunShade;

public class TileEntitySunShadeRender extends TileEntitySpecialRenderer
{
	private final ModelBlockSunShade model;
	protected static final ResourceLocation texture = new ResourceLocation("Nanotech_mod:textures/items/scythe.png");

	public TileEntitySunShadeRender()
	{
		this.model = new ModelBlockSunShade();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
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
		this.func_110628_a(new ResourceLocation("Nanotech_mod:textures/blocks/BlockSunShade" + tileentity.texture + ".png"));
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
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