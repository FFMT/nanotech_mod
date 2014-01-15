package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.gui.FFMTGuiSliderForContainer;

public class GuiJumper extends FFMTGuiContainerSliderBase
{
	private TileEntityJumper tileJumper;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/gui/jumper.png");

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
		this.buttonList.add(new FFMTGuiSliderForContainer(this, 0, x - 75, y + 20, I18n.getString("container.jumper.height"), (float)(tileJumper.getJumpHeightValue()) / 9.0F));
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		this.sendJumperPacket((int)(sliderValue * 9));
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		return I18n.getString("container.jumper.height");
	}

	private void sendJumperPacket(int value)
	{
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
		try
		{
			dataoutputstream.writeInt(value);
			this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTM|jumper", bytearrayoutputstream.toByteArray()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to send a packet from a Jumper");
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRenderer.drawString(I18n.getString("container.jumper"), 6, 6, 4210752);
		fontRenderer.drawString(I18n.getString("container.inventory"), 6, ySize - 96 + 2, 4210752);
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
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockEmerald), width / 2 - 9, y + 45);
		}
		if(flag8)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.emerald), width / 2 - 9, y + 45);
		}
		if(flag7)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockDiamond), width / 2 - 9, y + 45);
		}
		if(flag6)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.diamond), width / 2 - 9, y + 45);
		}
		if(flag5)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockGold), width / 2 - 9, y + 45);
		}
		if(flag4)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.ingotGold), width / 2 - 9, y + 45);
		}
		if(flag3)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockIron), width / 2 - 9, y + 45);
		}
		if(flag2)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.ingotIron), width / 2 - 9, y + 45);
		}
		if(flag1)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.coal), width / 2 - 9, y + 45);
		}
		if(flag0)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.feather), width / 2 - 9, y + 45);
		}
	}
}