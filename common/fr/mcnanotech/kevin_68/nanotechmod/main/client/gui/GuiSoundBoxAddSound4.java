package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiHelper;
import fr.minecraftforgefrance.ffmtlibs.entity.EggColor;

public class GuiSoundBoxAddSound4 extends GuiContainer
{

    private TileEntitySoundBox tile;
    private InventoryPlayer inv;
    private World wrld;
    private String name, dir;
    private CategoryEntry categ;
    private int[] color;

    public GuiSoundBoxAddSound4(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, String name, int[] color, String dir, CategoryEntry categ)
    {
        super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
        this.tile = tileEntity;
        this.inv = inventoryPlayer;
        this.wrld = world;
        this.name = name;
        this.color = color;
        this.dir = dir;
        this.categ = categ;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.buttonList.add(new GuiButton(3, x + 6, y + 112, 78, 20, "Cancel"));
        this.buttonList.add(new GuiButton(4, x + 88, y + 112, 78, 20, "Create"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton)
    {
        switch(guibutton.id)
        {
            case 3:
            {
                this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
                break;
            }
            case 4:
            {
                UtilSoundBox.setSound(UtilSoundBox.getPlyN(mc), UtilSoundBox.getNextSoundId(UtilSoundBox.getPlyN(mc)), dir, name, categ, (color[0] * 65536) + (color[1] * 256) + color[2]);
                this.mc.displayGuiScreen(new GuiSoundBox(inv, tile, wrld));
                break;
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        fontRendererObj.drawString("Sound box" + " - " + "Add sound resume", 6, 6, 4210752);

        this.drawCenteredString(fontRendererObj, "Sound name: " + name, 85, 30, (color[0] * 65536) + (color[1] * 256) + color[2]);
        this.drawCenteredString(fontRendererObj, "Directory: " + dir, 85, 45, EggColor.WHITE);
        this.drawCenteredString(fontRendererObj, "Category: " + categ.getName(), 85, 60, EggColor.WHITE);
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
