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
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;

@SideOnly(Side.CLIENT)
@SuppressWarnings("unchecked")
public class GuiListerJukeboxAddSound extends GuiScreen
{
	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;
	public GuiTextField txtField;

	public GuiListerJukeboxAddSound(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
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
		this.buttonList.add(new GuiButton(0, x + 120, y + 80, 80, 20, "Exit"));
		this.buttonList.add(new GuiButton(1, x - 200, y + 80, 80, 20, "Back"));
		this.buttonList.add(new GuiButton(2, x - 200, y - 25, 80, 20, "Mod id list"));
		this.buttonList.add(new GuiButton(3, x + 150, y - 25, 80, 20, "Category"));
		Keyboard.enableRepeatEvents(true);
		this.txtField = new GuiTextField(this.fontRendererObj, x - 100, y - 50, 180, 12);
		this.txtField.setTextColor(-1);
		this.txtField.setDisabledTextColour(-1);
		this.txtField.setEnableBackgroundDrawing(false);
		this.txtField.setMaxStringLength(40);
		this.txtField.setEnabled(true);
		this.txtField.setText(tile.getName());
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
		case 2:
		{
			this.mc.displayGuiScreen(new GuiListerJukeboxModidList(inventoryy, tile, worldd));
			break;
		}
		case 3:
		{
			this.mc.displayGuiScreen(new GuiListerJukeboxCategoryList(inventoryy, tile, worldd, false, false));
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
			NTMPacketHelper.sendPacket(tile, this.txtField.getText());
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
		if(tile.get(0) != -1)
		{
			this.drawCenteredString(this.fontRendererObj, UtilListerJukebox.getModid(tile.get(0)), x - 160, y - 50, 16777215);
		}
		super.drawScreen(par1, par2, par3);
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
}