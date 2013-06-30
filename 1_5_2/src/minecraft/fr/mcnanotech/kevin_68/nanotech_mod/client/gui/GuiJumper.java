package fr.mcnanotech.kevin_68.nanotech_mod.client.gui;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityJumper;

public class GuiJumper extends GuiContainer
{
	public GuiJumper(InventoryPlayer player_inventory, TileEntityJumper tile_entity, World world)
	{
		super(new ContainerJumper(tile_entity, player_inventory, world));
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		buttonList.add(new GuiButton(1, x + 75, y + 15, 20, 20, "+"));
		buttonList.add(new GuiButton(2, x + 75, y + 45, 20, 20, "-"));
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if (guibutton.id == 1)
		{
			TileEntityJumper.Block_jumper_height += 1;
		}
		if (guibutton.id == 2)
		{
			TileEntityJumper.Block_jumper_height -= 1;
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRenderer.drawString("Jump Block", 6, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture("/mods/Nanotech_mod/textures/gui/Blockjumper.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if (TileEntityJumper.jumpheight <= -1)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.shovelWood), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight >= 10)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.shovelWood), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 9)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockEmerald), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 8)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.emerald), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 7)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockDiamond), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 6)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.diamond), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 5)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockGold), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 4)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.ingotGold), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 3)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockIron), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 2)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.ingotIron), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 1)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.coal), x + 140, y + 35);
		}
		if (TileEntityJumper.jumpheight == 0)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.feather), x + 140, y + 35);
		}
		if (TileEntityJumper.Block_jumper_height == 0)
		{
			TileEntityJumper.jumpheight = 0;
		}
		if (TileEntityJumper.Block_jumper_height == 1)
		{
			TileEntityJumper.jumpheight = 1;
		}
		if (TileEntityJumper.Block_jumper_height == 2)
		{
			TileEntityJumper.jumpheight = 2;
		}
		if (TileEntityJumper.Block_jumper_height == 3)
		{
			TileEntityJumper.jumpheight = 3;
		}
		if (TileEntityJumper.Block_jumper_height == 4)
		{
			TileEntityJumper.jumpheight = 4;
		}
		if (TileEntityJumper.Block_jumper_height == 5)
		{
			TileEntityJumper.jumpheight = 5;
		}
		if (TileEntityJumper.Block_jumper_height == 6)
		{
			TileEntityJumper.jumpheight = 6;
		}
		if (TileEntityJumper.Block_jumper_height == 7)
		{
			TileEntityJumper.jumpheight = 7;
		}
		if (TileEntityJumper.Block_jumper_height == 8)
		{
			TileEntityJumper.jumpheight = 8;
		}
		if (TileEntityJumper.Block_jumper_height == 9)
		{
			TileEntityJumper.jumpheight = 9;
		}
		if (TileEntityJumper.Block_jumper_height == 10)
		{
			TileEntityJumper.Block_jumper_height -= 1;
		}
		if (TileEntityJumper.Block_jumper_height == -1)
		{
			TileEntityJumper.Block_jumper_height += 1;
		}
	}
}