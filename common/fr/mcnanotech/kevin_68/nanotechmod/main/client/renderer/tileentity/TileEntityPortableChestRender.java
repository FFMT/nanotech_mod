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
	public final ModelPortableChest model;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/blocks/portablechest.png");

	public TileEntityPortableChestRender()
	{
		this.model = new ModelPortableChest();
	}

	@Override
	public void renderInventory(double x, double y, double z)
	{
		this.renderTileEntityAtPortableChest(null, x, y, z, 0, true);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick)
	{
		this.renderTileEntityAtPortableChest((TileEntityPortableChest)tileentity, x, y, z, tick, false);
	}

	public void renderTileEntityAtPortableChest(TileEntityPortableChest tePortableChest, double x, double y, double z, float tick, boolean isInv)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(tePortableChest != null && !isInv)
		{
			GL11.glRotatef(180F + 90F * tePortableChest.getDirection(), 0.0F, 1.0F, 0.0F);
			float angle = tePortableChest.prevLidAngle + (tePortableChest.lidAngle - tePortableChest.prevLidAngle) * tick;
			angle = 1.0F - angle;
			angle = 1.0F - angle * angle * angle;
			this.model.Shape6.rotateAngleX = -(angle * (float)Math.PI / 2.0F);
			this.model.Shape7.rotateAngleX = -(angle * (float)Math.PI / 2.0F);
			this.model.Shape8.rotateAngleX = -(angle * (float)Math.PI / 2.0F);
			this.model.Shape9.rotateAngleX = -(angle * (float)Math.PI / 2.0F);
			this.model.Shape10.rotateAngleX = -(angle * (float)Math.PI / 2.0F);
			this.model.Shape11.rotateAngleX = -(angle * (float)Math.PI / 2.0F);
		}
		else
		{
			GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		}
		this.model.render(0.0625F);
		GL11.glPopMatrix();
	}
}