package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class NanotechPotion extends Potion
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/gui/potion/freeze.png");

	protected NanotechPotion(int par1, boolean par2, int par3)
	{
		super(par1, par2, par3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() 
	{       
	    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	    return true;
	}
}
