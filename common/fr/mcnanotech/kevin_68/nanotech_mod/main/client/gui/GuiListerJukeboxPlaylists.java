package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;

@SideOnly(Side.CLIENT)
public class GuiListerJukeboxPlaylists extends GuiScreen
{
	private GuiSlotMusicPlaylist musicList;
	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;
	private GuiButton stopButton;
	public GuiButton playAllButton;
	private int playList;

	public GuiListerJukeboxPlaylists(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world, int playlistnumber)
	{
		inventoryy = inventory;
		tile = tileentity;
		worldd = world;
		playList = playlistnumber;
	}

	public void initGui()
	{
		this.buttonList.add(this.stopButton = new GuiSmallButton(6, this.width / 2 - 152, this.height - 38, 100, 20, I18n.getString("container.listerJukebox.stop")));
		this.buttonList.add(new GuiButton(7, this.width / 2 + 52, this.height - 38, 100, 20, I18n.getString("container.listerJukebox.playlists")));
		this.buttonList.add(this.playAllButton = new GuiButton(8, this.width / 2 - 50, this.height - 38, 100, 20, I18n.getString("container.listerJukebox.playAll")));
		this.musicList = new GuiSlotMusicPlaylist(this, playList);
		this.musicList.registerScrollButtons(7, 8);
		playAllButton.enabled = (playList == 1 ? !musicList.mapMap1.isEmpty() : (playList == 2 ? !musicList.mapMap2.isEmpty() : (playList == 3 ? !musicList.mapMap3.isEmpty() : (playList == 4 ? !musicList.mapMap4.isEmpty() : (playList == 5 ? !musicList.mapMap5.isEmpty() : (playList == 6 ? !musicList.mapMap6.isEmpty() : (playList == 7 ? !musicList.mapMapMods.isEmpty() : false)))))));
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
				tile.playAllPlaylist((playList == 1 ? musicList.mapMap1 : (playList == 2 ? musicList.mapMap2 : (playList == 3 ? musicList.mapMap3 : (playList == 4 ? musicList.mapMap4 : (playList == 5 ? musicList.mapMap5 : (playList == 6 ? musicList.mapMap6 : musicList.mapMapMods)))))), (playList == 1 ? musicList.listList1 : (playList == 2 ? musicList.listList2 : (playList == 3 ? musicList.listList3 : (playList == 4 ? musicList.listList4 : (playList == 5 ? musicList.listList5 : (playList == 6 ? musicList.listList6 : musicList.listListMods)))))));
				break;
			default:
				this.musicList.actionPerformed(guiButton);
			}
		}
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		this.musicList.drawScreen(par1, par2, par3);
		this.drawCenteredString(this.fontRenderer, (this.playList == 7 ? "Mods playlist" : ("Playlist " + this.playList)), this.width / 2, 16, 16777215);
		super.drawScreen(par1, par2, par3);
	}

	static GuiButton getstopButton(GuiListerJukeboxPlaylists gui)
	{
		return gui.stopButton;
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