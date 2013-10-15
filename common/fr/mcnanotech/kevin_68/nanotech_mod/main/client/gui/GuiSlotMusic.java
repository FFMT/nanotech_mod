package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.Language;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
class GuiSlotMusic extends GuiSlot
{
    private final List field_77251_g;
    private final Map field_77253_h;

    final GuiListerJukebox listerGui;
    
    public GuiSlotMusic(GuiListerJukebox par1GuiLanguage)
    {
        super(par1GuiLanguage.getMc(), par1GuiLanguage.width, par1GuiLanguage.height, 32, par1GuiLanguage.height - 65 + 4, 18);
        this.listerGui = par1GuiLanguage;
        this.field_77251_g = Lists.newArrayList();
        this.field_77253_h = Maps.newHashMap();
        
        File di = new File(this.listerGui.getMc().mcDataDir + "/assets/records/");
        File fl[] = di.listFiles();
        
        for (int i = 0; i != fl.length; i++)
        {
        	System.out.println(fl[i]);
            this.field_77253_h.put(i, fl[i]);
            this.field_77251_g.add(i);
        }
        
    }

    /**
     * Gets the size of the current slot list.
     */
    protected int getSize()
    {
        return this.field_77251_g.size();
    }

    /**
     * the element in the slot that was clicked, boolean for wether it was double clicked or not
     */
    protected void elementClicked(int par1, boolean par2)
    {
        File di = new File(this.listerGui.getMc().mcDataDir + "/assets/records/");
        File fl[] = di.listFiles();
    	System.out.println(fl[par1]);
    	this.listerGui.getTile().playMusic(fl[par1].getName());
    }

    /**
     * return the height of the content being scrolled
     */
    protected int getContentHeight()
    {
        return this.getSize() * 18;
    }

    protected void drawBackground()
    {
        this.listerGui.drawDefaultBackground();
    }

    protected void drawSlot(int par1, int par2, int par3, int par4, Tessellator par5Tessellator)
    {
        this.listerGui.getFont().setBidiFlag(true);
        this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.field_77253_h.get(this.field_77251_g.get(par1))).toString(), this.listerGui.width / 2, par3 + 1, 16777215);
    }

	@Override
	protected boolean isSelected(int i)
	{
		return false;
	}
}
