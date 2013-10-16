package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.File;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
class GuiSlotMusic extends GuiSlot
{
    private final List listList;
    private final Map mapMap;
    final GuiListerJukebox listerGui;
    
    public GuiSlotMusic(GuiListerJukebox guiLister)
    {
        super(guiLister.getMc(), guiLister.width, guiLister.height, 32, guiLister.height - 65 + 4, 18);
        this.listerGui = guiLister;
        this.listList = Lists.newArrayList();
        this.mapMap = Maps.newHashMap();
        
        File di = new File(this.listerGui.getMc().mcDataDir + "/assets/records/");
        File fl[] = di.listFiles();
        
        for (int i = 0; i != fl.length; i++)
        {
            this.mapMap.put(i, fl[i]);
            this.listList.add(i);
        }
        
    }

    protected int getSize()
    {
        return this.listList.size();
    }

    protected void elementClicked(int slot, boolean doubleclick)
    {
        File di = new File(this.listerGui.getMc().mcDataDir + "/assets/records/");
        File fl[] = di.listFiles();
    	this.listerGui.getTile().playMusic(fl[slot].getName());
    }

    protected int getContentHeight()
    {
        return this.getSize() * 18;
    }

    protected void drawBackground()
    {
        this.listerGui.drawDefaultBackground();
    }

    protected void drawSlot(int par1, int par2, int par3, int par4, Tessellator tesselator)
    {
        this.listerGui.getFont().setBidiFlag(true);
        this.listerGui.drawCenteredString(this.listerGui.getFont(), (this.mapMap.get(this.listList.get(par1))).toString().replace(".ogg", "").replace(".\\assets\\records\\", ""), this.listerGui.width / 2, par3 + 1, 16777215);
    }

	@Override
	protected boolean isSelected(int i)
	{
		return false;
	}
}