/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.other;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NanotechPotion extends Potion
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/gui/potion/freeze.png");

	public NanotechPotion(int id, boolean isBad, int color)
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