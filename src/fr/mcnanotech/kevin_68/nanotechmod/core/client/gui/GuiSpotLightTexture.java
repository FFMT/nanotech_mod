package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight.BaseListEntry;
import fr.mcnanotech.kevin_68.nanotechmod.core.utils.UtilSpotLight.TextureEntry;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;

public class GuiSpotLightTexture extends GuiListBase
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlight.png");

	public InventoryPlayer invPlayer;
	public TileEntitySpotLight tileSpotLight;
	public World world;
	private GuiList gList;
	private ArrayList<BaseListEntry> list = UtilSpotLight.list();
	private TextureEntry selected;
	private GuiBooleanButton booButton;

	public GuiSpotLightTexture(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, wrld));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		world = wrld;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(0, new GuiButton(0, x + 6, y + 117, 78, 20, I18n.format("container.spotlight.back")));
		this.buttonList.add(1, booButton = new GuiBooleanButton(1, x + 91, y + 117, 78, 20, I18n.format("container.spotlight.main"), I18n.format("container.spotlight.sec"), true));
		gList = new GuiList(this, list, x + 6, y + 17, x + 169, y + 115);
		gList.addButton(buttonList);
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
			booButton.toggle();
			break;
		}
		default:
		{
			this.gList.actionPerformed(guibutton, this.buttonList);
		}
		}
	}

	@Override
	public void setSelected(BaseListEntry entry)
	{
		if(entry instanceof TextureEntry)
		{
			TextureEntry ent = (TextureEntry)entry;
			this.selected = ent;
			PacketSender.sendSpotLightPacket(tileSpotLight, booButton.getIsActive() ? 6 : 7, ent.getName());
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		super.drawScreen(par1, par2, par3);
		this.gList.drawScreen(x, y);
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