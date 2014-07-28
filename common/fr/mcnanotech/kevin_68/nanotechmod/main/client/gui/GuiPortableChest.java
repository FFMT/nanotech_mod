/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;

public class GuiPortableChest extends GuiContainer
{
    private TileEntityPortableChest tileChest;
    private IInventory playerInventory;
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/gui/portablechest.png");

    public GuiPortableChest(InventoryPlayer playerinventory, TileEntityPortableChest tileentity, World world)
    {
        super(new ContainerPortableChest(tileentity, playerinventory, world));
        tileChest = tileentity;
        playerInventory = playerinventory;
        this.ySize = 230;
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRendererObj.drawString(I18n.format(this.playerInventory.getInventoryName()), 8, 129, 0);
        this.fontRendererObj.drawString(this.tileChest.hasCustomInventoryName() ? this.tileChest.getCustomGuiName() : I18n.format(this.tileChest.getInventoryName()), 8, 7, 0);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}