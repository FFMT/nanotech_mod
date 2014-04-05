/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiScreenSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiSliderForScreen;

@SideOnly(Side.CLIENT)
@SuppressWarnings("unchecked")
public class GuiListerJukeboxAddCategory extends FFMTGuiScreenSliderBase
{
	public static final ResourceLocation texture = new ResourceLocation("textures/gui/container/anvil.png");

	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;
	public GuiTextField txtField;

	public GuiListerJukeboxAddCategory(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
	{
		inventoryy = inventory;
		tile = tileentity;
		worldd = world;
	}

	public void initGui()
	{
		super.initGui();
		int x = this.width / 2;
		int y = this.height / 2;
		this.buttonList.add(new GuiButton(0, x + 120, y + 104, 80, 20, "Exit"));
		this.buttonList.add(new GuiButton(1, x - 200, y + 104, 80, 20, "Back"));
		this.buttonList.add(new FFMTGuiSliderForScreen(this, 4, x - 100, y - 25, 200, 20, EnumChatFormatting.RED + I18n.format("container.lightsaber.red") + ": " + tile.get(5), tile.get(5) / 255));
		this.buttonList.add(new FFMTGuiSliderForScreen(this, 5, x - 100, y, 200, 20, EnumChatFormatting.GREEN + I18n.format("container.lightsaber.green") + ": " + tile.get(6), tile.get(6) / 255));
		this.buttonList.add(new FFMTGuiSliderForScreen(this, 6, x - 100, y + 25, 200, 20, EnumChatFormatting.BLUE + I18n.format("container.lightsaber.blue") + ": " + tile.get(7), tile.get(7) / 255));
		this.buttonList.add(new GuiButton(7, x - 40, y + 55, 80, 20, "Add category"));
		this.buttonList.add(new GuiButton(8, x - 40, y + 80, 80, 20, "Clear"));
		Keyboard.enableRepeatEvents(true);
		this.txtField = new GuiTextField(this.fontRendererObj, x - 90, y - 50, 180, 12);
		this.txtField.setTextColor((tile.get(5) * 65536) + (tile.get(6) * 256) + tile.get(7));
		this.txtField.setDisabledTextColour(-1);
		this.txtField.setEnableBackgroundDrawing(false);
		this.txtField.setMaxStringLength(40);
		this.txtField.setEnabled(true);
		this.txtField.setText(tile.getName(1));
	}

	protected void actionPerformed(GuiButton guiButton)
	{
		switch(guiButton.id)
		{
		case 0:
		{
			this.mc.displayGuiScreen(null);
			break;
		}
		case 1:
		{
			this.mc.displayGuiScreen(new GuiListerJukebox(inventoryy, tile, worldd));
			break;
		}
		case 7:
		{
			String name = this.txtField.getText();
			int color = (tile.get(5) * 65536) + (tile.get(6) * 256) + tile.get(7);
			if(name.length() > 1)
			{
				UtilListerJukebox.setCategory(name, color);
				break;
			}
			else
			{
				break;
			}
		}
		case 8:
		{
			NTMPacketHelper.sendPacket(tile, 5, 255);
			NTMPacketHelper.sendPacket(tile, 6, 255);
			NTMPacketHelper.sendPacket(tile, 7, 255);
			NTMPacketHelper.sendPacket(tile, 1, "");
			this.txtField.setTextColor((255 * 65536) + (255 * 256) + 255);
			break;
		}
		}
	}

	public void onGuiClosed()
	{
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	protected void keyTyped(char par1, int par2)
	{
		if(this.txtField.textboxKeyTyped(par1, par2))
		{
			NTMPacketHelper.sendPacket(tile, 1, this.txtField.getText());
		}
		else
		{
			super.keyTyped(par1, par2);
		}
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		this.txtField.mouseClicked(par1, par2, par3);
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		int x = this.width / 2;
		int y = this.height / 2;
		this.drawBackground(12);
		this.drawCenteredString(this.fontRendererObj, I18n.format("container.listerJukebox.addsounds"), x, 16, 16777215);
		this.mc.renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glScalef(1.8F, 1.0F, 1.0F);
		this.drawTexturedModalRect(x - 179, y - 54, 0, 166, 110, 16);
		GL11.glPopMatrix();
		super.drawScreen(par1, par2, par3);
		
		if(tile.getName(1) == "")
		{
			this.drawCenteredString(this.fontRendererObj, I18n.format("container.listerJukebox.fieldCateg"), x, y - 50, 16777215);
		}
		GL11.glDisable(GL11.GL_LIGHTING);
		this.txtField.drawTextBox();
	}

	public Minecraft getMc()
	{
		return mc;
	}

	public FontRenderer getFont()
	{
		return fontRendererObj;
	}

	public TileEntityListerJukebox getTile()
	{
		return tile;
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		NTMPacketHelper.sendPacket(tile, sliderId + 1, (int)(sliderValue * 255));
		this.txtField.setTextColor((tile.get(5) * 65536) + (tile.get(6) * 256) + tile.get(7));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		switch(sliderId)
		{
		case 4:
		{
			return EnumChatFormatting.RED + I18n.format("container.lightsaber.red") + ": " + tile.get(5);
		}
		case 5:
		{
			return EnumChatFormatting.GREEN + I18n.format("container.lightsaber.green") + ": " + tile.get(6);
		}
		case 6:
		{
			return EnumChatFormatting.BLUE + I18n.format("container.lightsaber.blue") + ": " + tile.get(7);
		}
		default:
		{
			return null;
		}
		}
	}
}