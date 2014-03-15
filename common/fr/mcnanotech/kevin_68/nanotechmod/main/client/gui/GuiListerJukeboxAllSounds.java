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
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;

@SideOnly(Side.CLIENT)
@SuppressWarnings("unchecked")
public class GuiListerJukeboxAllSounds extends GuiScreen
{
	public TileEntityListerJukebox tile;
	public World worldd;
	public InventoryPlayer inventoryy;
	public GuiListerJukeboxLists guiList;

	public GuiListerJukeboxAllSounds(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
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
		this.buttonList.add(new GuiButton(2, x - 115, y + 104, 80, 20, "Play"));
		this.buttonList.add(new GuiButton(3, x + 35, y + 104, 80, 20, "Stop"));
		this.buttonList.add(new GuiButton(4, x - 25, y + 104, 50, 20, "Edit"));
		this.guiList = new GuiListerJukeboxLists(this, UtilListerJukebox.getAllSoundsName());
		this.guiList.registerScrollButtons(7, 8);
	}

	protected void actionPerformed(GuiButton guiButton)
	{
		if(guiButton.enabled)
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
				if(guiList.getSelectedSlot() != -1)
				{
					this.tile.playSound(UtilListerJukebox.getAllSoundsDirectory().get(guiList.getSelectedSlot()));
				}
				break;
			}
			case 3:
			{
				this.tile.playSound((String)null);
				break;
			}
			case 5:
			{
				if(guiList.getSelectedSlot() != -1)
				{
					this.mc.displayGuiScreen(new GuiListerJukeboxEditSounds(inventoryy, tile, worldd, guiList.getSelectedSlot()));
				}
				break;
			}
			default:
			{
				this.guiList.actionPerformed(guiButton);
			}
			}
		}
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		this.guiList.drawScreen(par1, par2, par3);
		this.drawCenteredString(this.fontRendererObj, I18n.format("container.listerJukebox.allsound"), this.width / 2, 16, 16777215);
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