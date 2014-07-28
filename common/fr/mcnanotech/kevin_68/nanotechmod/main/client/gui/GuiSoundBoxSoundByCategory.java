package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.SoundEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiHelper;

public class GuiSoundBoxSoundByCategory extends GuiSoundBoxListBase
{
    private TileEntitySoundBox tile;
    private InventoryPlayer inv;
    private World wrld;
    private GuiSoundBoxList sBList;
    private GuiButton playButton;
    private SoundEntry selected;
    private CategoryEntry categ;

    public GuiSoundBoxSoundByCategory(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, CategoryEntry entry)
    {
        super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
        this.tile = tileEntity;
        this.inv = inventoryPlayer;
        this.wrld = world;
        this.categ = entry;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.buttonList.add(0, new GuiButton(0, x + 6, y + 117, 78, 20, "Cancel"));
        this.buttonList.add(1, playButton = new GuiButton(1, x + 91, y + 117, 78, 20, "Play"));
        sBList = new GuiSoundBoxList(this, UtilSoundBox.getSoundsByCategory(categ), x + 6, y + 17, x + 169, y + 115);
        sBList.addButton(buttonList);
        this.playButton.enabled = false;
    }

    @Override
    protected void actionPerformed(GuiButton guibutton)
    {
        switch(guibutton.id)
        {
            case 0:
            {
                this.mc.displayGuiScreen(new GuiSoundBoxCategories(inv, tile, wrld));
                break;
            }
            case 1:
            {
                this.tile.playSound(this.selected.getDir());
                break;
            }
            default:
            {
                this.sBList.actionPerformed(guibutton, this.buttonList);
            }
        }
    }

    @Override
    public void setSelected(BaseNTMEntry entry)
    {
        if(entry instanceof SoundEntry)
        {
            this.selected = (SoundEntry)entry;
            this.playButton.enabled = true;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        fontRendererObj.drawString("Sound box" + " - ", 6, 6, 4210752);
        fontRendererObj.drawString(categ.getName(), fontRendererObj.getStringWidth("Sound box" + " - ") + 6, 6, categ.getColor());
    }

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        super.drawScreen(par1, par2, par3);
        this.sBList.drawScreen(x, y);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GuiHelper.bindTexture("nanotechmod", "textures/gui/soundbox.png");
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}