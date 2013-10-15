package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;

@SideOnly(Side.CLIENT)
public class GuiListerJukebox extends GuiScreen
{
    /** This GUI's language list. */
    private GuiSlotMusic languageList;
    public TileEntityListerJukebox tile;
    /** This GUI's 'Done' button. */
    private GuiSmallButton doneButton;

    public GuiListerJukebox(InventoryPlayer inventory, TileEntityListerJukebox tileentity, World world)
    {
    	tile = tileentity;
    }

    public void initGui()
    {
        this.buttonList.add(this.doneButton = new GuiSmallButton(6, this.width / 2 - 75, this.height - 38, "Stop"));
        this.languageList = new GuiSlotMusic(this);
        this.languageList.registerScrollButtons(7, 8);
    }

    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
                case 5:
                    break;
                case 6:
                    tile.stopMusic();
                    break;
                default:
                    this.languageList.actionPerformed(par1GuiButton);
            }
        }
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.languageList.drawScreen(par1, par2, par3);
        this.drawCenteredString(this.fontRenderer, "Chose your music", this.width / 2, 16, 16777215);
        super.drawScreen(par1, par2, par3);
    }

    static GuiSmallButton getDoneButton(GuiListerJukebox par0GuiLanguage)
    {
        return par0GuiLanguage.doneButton;
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
