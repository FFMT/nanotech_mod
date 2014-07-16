package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;

public class GuiSpotLightAddTexture extends GuiContainer
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlight.png");

	public InventoryPlayer invPlayer;
	public TileEntitySpotLight tileSpotLight;
	public World world;
	public GuiBooleanButton timeButton;
	public GuiTextField nameField;
	public GuiTextField pathField;
	public GuiTextField delNameField;
	public String name, path, delname;

	public GuiSpotLightAddTexture(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, wrld));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		world = wrld;
	}

	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		Keyboard.enableRepeatEvents(true);
		this.nameField = new GuiTextField(this.fontRendererObj, x + 6, y + 20, 160, 12);
		this.nameField.setDisabledTextColour(-1);
		this.nameField.setEnableBackgroundDrawing(true);
		this.nameField.setMaxStringLength(40);
		this.nameField.setEnabled(true);
		this.nameField.setText("");

		this.pathField = new GuiTextField(this.fontRendererObj, x + 6, y + 50, 160, 12);
		this.pathField.setDisabledTextColour(-1);
		this.pathField.setEnableBackgroundDrawing(true);
		this.pathField.setMaxStringLength(60);
		this.pathField.setEnabled(true);
		this.pathField.setText("");
		
		this.delNameField = new GuiTextField(this.fontRendererObj, x + 6, y + 80, 160, 12);
		this.delNameField.setDisabledTextColour(-1);
		this.delNameField.setEnableBackgroundDrawing(true);
		this.delNameField.setMaxStringLength(60);
		this.delNameField.setEnabled(true);
		this.delNameField.setText("");

		this.buttonList.add(new GuiButton(0, x + 6, y + 117, 78, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(new GuiButton(1, x + 91, y + 95, 78, 20, I18n.format("container.spotlight.add")));
		this.buttonList.add(new GuiButton(2, x + 91, y + 117, 78, 20, I18n.format("container.spotlight.del")));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 0:
		{
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
			break;
		}
		case 1:
		{
			UtilSpotLight.setSound(name, path);
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
			break;
		}
		case 2:
		{
			UtilSpotLight.deleteTexure(delname);
			break;
		}
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.nameField.drawTextBox();
		this.pathField.drawTextBox();
		this.delNameField.drawTextBox();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawString(this.fontRendererObj, I18n.format("container.spotlight.texname") + " : ", x + 10, y + 10, 0xffffff);
		this.drawString(this.fontRendererObj, I18n.format("container.spotlight.texpath") + " : ", x + 10, y + 40, 0xffffff);
		this.drawString(this.fontRendererObj, I18n.format("container.spotlight.delname") + " : ", x + 10, y + 70, 0xffffff);

	}

	public void onGuiClosed()
	{
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	protected void keyTyped(char par1, int par2)
	{
		if(this.nameField.textboxKeyTyped(par1, par2))
		{
			name = this.nameField.getText();
		}
		else if(this.pathField.textboxKeyTyped(par1, par2))
		{
			path = this.pathField.getText();
		}
		else if(this.delNameField.textboxKeyTyped(par1, par2))
		{
			delname = this.delNameField.getText();
		}
		else
		{
			super.keyTyped(par1, par2);
		}
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		this.nameField.mouseClicked(par1, par2, par3);
		this.pathField.mouseClicked(par1, par2, par3);
		this.delNameField.mouseClicked(par1, par2, par3);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}