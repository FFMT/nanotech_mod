package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;

public class GuiJumper extends GuiContainer
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
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		buttonList.add(new GuiButton(1, x + 75, y + 15, 20, 20, "+"));
		buttonList.add(new GuiButton(2, x + 75, y + 45, 20, 20, "-"));
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			if(tileJumper.getJumpHeightValue() < 9)
			{
				ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
				DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

				try
				{
					dataoutputstream.writeInt(tileJumper.getJumpHeightValue() + 1);
					this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTM|jumper", bytearrayoutputstream.toByteArray()));
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
			}
		}
		else if(guibutton.id == 2)
		{
			if(tileJumper.getJumpHeightValue() > 0)
			{
				ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
				DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

				try
				{
					dataoutputstream.writeInt(tileJumper.getJumpHeightValue() - 1);
					this.mc.getNetHandler().addToSendQueue(new Packet250CustomPayload("NTM|jumper", bytearrayoutputstream.toByteArray()));
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
			}
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
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if(tileJumper.getJumpHeightValue() == 0)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.feather), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 1)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.coal), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 2)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.ingotIron), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 3)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockIron), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 4)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.ingotGold), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 5)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockGold), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 6)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.diamond), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 7)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockDiamond), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 8)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Item.emerald), x + 140, y + 35);
		}
		else if(tileJumper.getJumpHeightValue() == 9)
		{
			itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, new ItemStack(Block.blockEmerald), x + 140, y + 35);
		}
	}
}