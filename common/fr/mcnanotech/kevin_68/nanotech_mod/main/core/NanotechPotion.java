package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NanotechPotion extends Potion
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/gui/potion/freeze.png");

	protected NanotechPotion(int id, boolean isBad, int color)
	{
		super(id, isBad, color);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		return true;
	}
}
