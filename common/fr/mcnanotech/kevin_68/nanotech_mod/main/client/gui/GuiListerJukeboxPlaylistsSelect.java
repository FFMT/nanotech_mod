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
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;

@SideOnly(Side.CLIENT)
public class GuiListerJukeboxPlaylistsSelect extends GuiScreen
{

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
		this.buttonList.add(new GuiSmallButton(0, this.width / 2 - 75, this.height - 38, "Back"));
		this.buttonList.add(new GuiSmallButton(1, this.width / 2 - 151, this.height - 200, "Playlist 1"));
		this.buttonList.add(new GuiSmallButton(2, this.width / 2 + 2, this.height - 200, "Playlist 2"));
		this.buttonList.add(new GuiSmallButton(3, this.width / 2 - 151, this.height - 150, "Playlist 3"));
		this.buttonList.add(new GuiSmallButton(4, this.width / 2 + 2, this.height - 150, "Playlist 4"));
		this.buttonList.add(new GuiSmallButton(5, this.width / 2 - 151, this.height - 100, "Playlist 5"));
		this.buttonList.add(new GuiSmallButton(6, this.width / 2 + 2, this.height - 100, "Playlist 6"));
		this.buttonList.add(new GuiSmallButton(7, this.width / 2 - 75, this.height - 75, "Mods Playlist"));
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
		this.drawCenteredString(this.fontRenderer, "Chose your playlist", this.width / 2, 16, 16777215);
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