package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTextSpotLight;

public class TileEntityTextSpotLightRender extends TileEntitySpecialRenderer
{
	protected static final ResourceLocation texture = new ResourceLocation("textures/entity/beacon_beam.png");

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		this.renderTileEntityTextSpotLightAt((TileEntityTextSpotLight)tileentity, x, y, z, f);
	}

	private void renderTileEntityTextSpotLightAt(TileEntityTextSpotLight tileEntity, double x, double y, double z, float f)
	{
		//TODO render
	}
}