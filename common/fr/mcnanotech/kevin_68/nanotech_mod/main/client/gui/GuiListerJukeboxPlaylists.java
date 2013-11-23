package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;

@SideOnly(Side.CLIENT)
public class GuiListerJukeboxPlaylists extends GuiScreen
{
	private GuiSlotMusicPlaylist musicList;
	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;
	private GuiSmallButton stopButton;
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
		this.buttonList.add(this.stopButton = new GuiSmallButton(6, this.width / 2 - 150, this.height - 38, "Stop"));
		this.buttonList.add(new GuiSmallButton(7, this.width / 2, this.height - 38, "Playlist"));
		this.musicList = new GuiSlotMusicPlaylist(this, playList);
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
			default:
				this.musicList.actionPerformed(guiButton);
			}
		}
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		this.musicList.drawScreen(par1, par2, par3);
		this.drawCenteredString(this.fontRenderer, "Playlist " + this.playList, this.width / 2, 16, 16777215);
		super.drawScreen(par1, par2, par3);
	}

	static GuiSmallButton getstopButton(GuiListerJukeboxPlaylists gui)
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