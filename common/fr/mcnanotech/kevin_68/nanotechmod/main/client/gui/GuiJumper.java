/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.network.NTMPacketHelper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

@SuppressWarnings({"unchecked"})
public class GuiJumper extends FFMTGuiContainerSliderBase
{
	private TileEntityJumper tileJumper;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/gui/jumper.png");

	public GuiJumper(InventoryPlayer playerInventory, TileEntityJumper tileEntity, World world)
	{
		super(new ContainerJumper(tileEntity, playerInventory, world));
		tileJumper = tileEntity;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x - 75, y + 20, I18n.format("container.jumper.height"), (float)(tileJumper.getJumpHeightValue()) / 9.0F));
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		NTMPacketHelper.sendPacket(this.tileJumper, (int)(sliderValue * 9));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return I18n.format("container.jumper.height");
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRendererObj.drawString(I18n.format("container.jumper"), 6, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory"), 6, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		boolean flag9 = tileJumper.getJumpHeightValue() == 9;
		boolean flag8 = tileJumper.getJumpHeightValue() == 8;
		boolean flag7 = tileJumper.getJumpHeightValue() == 7;
		boolean flag6 = tileJumper.getJumpHeightValue() == 6;
		boolean flag5 = tileJumper.getJumpHeightValue() == 5;
		boolean flag4 = tileJumper.getJumpHeightValue() == 4;
		boolean flag3 = tileJumper.getJumpHeightValue() == 3;
		boolean flag2 = tileJumper.getJumpHeightValue() == 2;
		boolean flag1 = tileJumper.getJumpHeightValue() == 1;
		boolean flag0 = tileJumper.getJumpHeightValue() == 0;

		if(flag9)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Blocks.emerald_block), width / 2 - 9, y + 45);
		}
		if(flag8)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Items.emerald), width / 2 - 9, y + 45);
		}
		if(flag7)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Blocks.diamond_block), width / 2 - 9, y + 45);
		}
		if(flag6)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Items.diamond), width / 2 - 9, y + 45);
		}
		if(flag5)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Blocks.gold_block), width / 2 - 9, y + 45);
		}
		if(flag4)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Items.gold_ingot), width / 2 - 9, y + 45);
		}
		if(flag3)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Blocks.iron_block), width / 2 - 9, y + 45);
		}
		if(flag2)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Items.iron_ingot), width / 2 - 9, y + 45);
		}
		if(flag1)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Items.coal), width / 2 - 9, y + 45);
		}
		if(flag0)
		{
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Items.feather), width / 2 - 9, y + 45);
		}
	}
}