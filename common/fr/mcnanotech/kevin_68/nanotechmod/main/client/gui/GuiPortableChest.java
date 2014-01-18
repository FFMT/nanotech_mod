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
		this.fontRenderer.drawString(this.playerInventory.isInvNameLocalized() ? this.playerInventory.getInvName() : I18n.getString(this.playerInventory.getInvName()), 8, 129, 0);
		this.fontRenderer.drawString(this.tileChest.isInvNameLocalized() ? this.tileChest.getInvName() : I18n.getString(this.tileChest.getInvName()), 8, 7, 0);
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