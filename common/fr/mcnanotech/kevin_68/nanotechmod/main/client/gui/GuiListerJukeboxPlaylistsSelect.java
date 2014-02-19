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
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;

@SideOnly(Side.CLIENT)
@SuppressWarnings({"unchecked", "static-access"})
public class GuiListerJukeboxPlaylistsSelect extends GuiScreen
{

	private static final FontRenderer fontRenderer = null;
	public TileEntityListerJukebox tile;
	public InventoryPlayer inventoryy;
	public World worldd;

	public GuiListerJukeboxPlaylistsSelect(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
	{
		inventoryy = inventory;
		tile = tileentity;
		worldd = world;
	}

	public void initGui()
	{
		this.buttonList.add(new GuiButton(0, this.width / 2 - 75, this.height - 38, I18n.format("container.listerJukebox.back")));
		this.buttonList.add(new GuiButton(1, this.width / 2 - 151, this.height - 200, I18n.format("container.listerJukebox.playlist") + " 1"));
		this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height - 200, I18n.format("container.listerJukebox.playlist") + " 2"));
		this.buttonList.add(new GuiButton(3, this.width / 2 - 151, this.height - 150, I18n.format("container.listerJukebox.playlist") + " 3"));
		this.buttonList.add(new GuiButton(4, this.width / 2 + 2, this.height - 150, I18n.format("container.listerJukebox.playlist") + " 4"));
		this.buttonList.add(new GuiButton(5, this.width / 2 - 151, this.height - 100, I18n.format("container.listerJukebox.playlist") + " 5"));
		this.buttonList.add(new GuiButton(6, this.width / 2 + 2, this.height - 100, I18n.format("container.listerJukebox.playlist") + " 6"));
		this.buttonList.add(new GuiButton(7, this.width / 2 - 75, this.height - 75, I18n.format("container.listerJukebox.modplaylist")));
	}

	protected void actionPerformed(GuiButton guiButton)
	{
		if(guiButton.enabled)
		{
			if(guiButton.id == 0)
			{
				this.mc.displayGuiScreen(new GuiListerJukebox(inventoryy, tile, worldd));
			}
			if(guiButton.id == 1)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 1));
			}
			if(guiButton.id == 2)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 2));
			}
			if(guiButton.id == 3)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 3));
			}
			if(guiButton.id == 4)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 4));
			}
			if(guiButton.id == 5)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 5));
			}
			if(guiButton.id == 6)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 6));
			}
			if(guiButton.id == 7)
			{
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylists(inventoryy, tile, worldd, 7));
			}
		}
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		this.drawBackground(12);
		this.drawCenteredString(this.fontRendererObj, "Chose your playlist", this.width / 2, 16, 16777215);
		super.drawScreen(par1, par2, par3);
	}

	public Minecraft getMc()
	{
		return mc;
	}

	public FontRenderer getFont()
	{
		return fontRenderer;
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