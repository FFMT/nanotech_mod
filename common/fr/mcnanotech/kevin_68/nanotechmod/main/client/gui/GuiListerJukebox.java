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
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;

@SideOnly(Side.CLIENT)
@SuppressWarnings("unchecked")
public class GuiListerJukebox extends GuiScreen
{
	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;

	public GuiListerJukebox(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
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
		this.buttonList.add(new GuiButton(1, x - 90, y - 70, 180, 20, "All sounds"));
		this.buttonList.add(new GuiButton(2, x - 90, y - 45, 180, 20, "Sounds lists"));
		this.buttonList.add(new GuiButton(3, x - 90, y - 20, 180, 20, "Add sound"));
		this.buttonList.add(new GuiButton(4, x - 90, y + 5, 180, 20, "Add list"));
		this.buttonList.add(new GuiButton(5, x - 90, y + 30, 180, 20, "Stop current playing sound"));
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
		case 3:
		{
			this.mc.displayGuiScreen(new GuiListerJukeboxAddSound(inventoryy, tile, worldd));
			break;
		}
		}
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		this.drawBackground(12);
		this.drawCenteredString(this.fontRendererObj, I18n.format("container.listerJukebox.chose"), this.width / 2, 16, 16777215);
		super.drawScreen(par1, par2, par3);
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