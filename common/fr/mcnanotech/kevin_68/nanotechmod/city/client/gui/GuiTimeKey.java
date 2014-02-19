/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiTimeKey extends GuiButton
{
	protected static final ResourceLocation textures = new ResourceLocation("nanotechmodcity:textures/gui/widget.png");

	public GuiTimeKey(int par1, int par2, int par3)
	{
		super(par1, par2, par3, 3, 3, "");
	}

	@SuppressWarnings("unused")
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
	{
		if(this.visible)
		{
			par1Minecraft.getTextureManager().bindTexture(textures);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_146123_n = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);
			this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, 3, 3);
			this.mouseDragged(par1Minecraft, par2, par3);
		}
	}

	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
	{
		return this.enabled && this.visible && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
	}

	protected int getHoverState(boolean par1)
	{
		byte b0 = 1;

		if(!this.enabled)
		{
			b0 = 0;
		}
		else if(par1)
		{
			b0 = 2;
		}

		return b0;
	}
}