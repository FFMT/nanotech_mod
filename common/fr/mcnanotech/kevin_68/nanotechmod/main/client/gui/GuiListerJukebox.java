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
@SuppressWarnings("unchecked")
public class GuiListerJukebox extends GuiScreen
{
	private GuiSlotMusic musicList;
	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;
	private GuiButton stopButton;

	public GuiListerJukebox(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
	{
		inventoryy = inventory;
		tile = tileentity;
		worldd = world;
	}

	public void initGui()
	{
		this.buttonList.add(this.stopButton = new GuiButton(6, this.width / 2 - 152, this.height - 38, 100, 20, I18n.format("container.listerJukebox.stop")));
		this.buttonList.add(new GuiButton(7, this.width / 2 + 52, this.height - 38, 100, 20, I18n.format("container.listerJukebox.playlists")));
		this.buttonList.add(new GuiButton(8, this.width / 2 - 50, this.height - 38, 100, 20, I18n.format("container.listerJukebox.playAll")));
		this.musicList = new GuiSlotMusic(this);
		this.musicList.registerScrollButtons(7, 8);
	}

	protected void actionPerformed(GuiButton guiButton)
	{
		if(guiButton.enabled)
		{
			switch(guiButton.id)
			{
			case 6:
				tile.stopMusic();
				break;
			case 7:
				this.mc.displayGuiScreen(new GuiListerJukeboxPlaylistsSelect(inventoryy, tile, worldd));
				break;
			case 8:
				tile.playAllPlaylist(musicList.mapMap, musicList.listList);
				break;
			default:
				this.musicList.actionPerformed(guiButton);
			}
		}
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		this.musicList.drawScreen(par1, par2, par3);
		this.drawCenteredString(this.fontRendererObj, I18n.format("container.listerJukebox.chose"), this.width / 2, 16, 16777215);
		super.drawScreen(par1, par2, par3);
	}

	static GuiButton getstopButton(GuiListerJukebox gui)
	{
		return gui.stopButton;
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