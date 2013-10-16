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
public class GuiListerJukebox extends GuiScreen
{

    private GuiSlotMusic musicList;
    public TileEntityListerJukebox tile;
    private GuiSmallButton stopButton;
    public GuiListerJukebox(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
    {
    	tile = tileentity;
    }

    public void initGui()
    {
        this.buttonList.add(this.stopButton = new GuiSmallButton(6, this.width / 2 - 75, this.height - 38, "Stop"));
        this.musicList = new GuiSlotMusic(this);
        this.musicList.registerScrollButtons(7, 8);
    }

    protected void actionPerformed(GuiButton guiButton)
    {
        if (guiButton.enabled)
        {
            switch (guiButton.id)
            {
                case 6:
                    tile.stopMusic();
                    break;
                default:
                    this.musicList.actionPerformed(guiButton);
            }
        }
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.musicList.drawScreen(par1, par2, par3);
        this.drawCenteredString(this.fontRenderer, "Chose your music", this.width / 2, 16, 16777215);
        super.drawScreen(par1, par2, par3);
    }

    static GuiSmallButton getstopButton(GuiListerJukebox gui)
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
}
