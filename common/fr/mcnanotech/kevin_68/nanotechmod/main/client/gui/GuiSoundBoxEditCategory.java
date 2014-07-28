package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiSoundBoxConfirm.YesAction;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilSoundBox.CategoryEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiHelper;

public class GuiSoundBoxEditCategory extends GuiContainer implements YesAction
{
    private TileEntitySoundBox tile;
    private InventoryPlayer inv;
    private World wrld;
    public CategoryEntry entry;

    public GuiSoundBoxEditCategory(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, CategoryEntry entry)
    {
        super(new ContainerSoundBox(tileEntity, inventoryPlayer, world));
        this.tile = tileEntity;
        this.inv = inventoryPlayer;
        this.wrld = world;
        this.entry = entry;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.buttonList.add(new GuiButton(0, x + 6, y + 117, 78, 20, "Cancel"));
        this.buttonList.add(new GuiButton(1, x + 91, y + 117, 78, 20, "Apply"));
        this.buttonList.add(new GuiButton(2, x + 10, y + 20, 156, 20, "Name: " + entry.getName()));
        this.buttonList.add(new GuiButton(3, x + 10, y + 92, 156, 20, EnumChatFormatting.RED + "Delete"));
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
                UtilSoundBox.editCategory(entry, UtilSoundBox.getPlyN(mc));
                this.mc.displayGuiScreen(new GuiSoundBoxCategories(inv, tile, wrld));
                break;
            }
            case 2:
            {
                this.mc.displayGuiScreen(new GuiSoundBoxAddCategory(inv, tile, wrld, true, this));
                break;
            }
            case 3:
            {
                this.mc.displayGuiScreen(new GuiSoundBoxConfirm(inv, tile, wrld, this, "Are you sure?"));
                break;
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        fontRendererObj.drawString("Sound box" + " - " + "Edit category", 6, 6, 4210752);
    }

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        super.drawScreen(par1, par2, par3);
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

    @Override
    public void handleYesAction()
    {
        UtilSoundBox.deleteCategory(UtilSoundBox.getPlyN(mc), entry.getId());
        this.mc.displayGuiScreen(new GuiSoundBoxCategories(inv, tile, wrld));
    }
}