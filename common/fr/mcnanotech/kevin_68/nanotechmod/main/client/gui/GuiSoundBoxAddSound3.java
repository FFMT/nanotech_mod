package fr.mcnanotech.kevin_68.nanotechmod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;
import fr.minecraftforgefrance.ffmtlibs.client.gui.FFMTGuiHelper;

public class GuiSoundBoxAddSound3 extends GuiContainer
{
	private TileEntitySoundBox tile;
	private InventoryPlayer inv;
	private World wrld;
	private String name, dir, categ;
	private int[] color;

	private GuiButton nextButton;
	private GuiDropDown myDropdownList;

	public GuiSoundBoxAddSound3(InventoryPlayer inventoryPlayer, TileEntitySoundBox tileEntity, World world, String name, int[] color, String dir)
	{
		super(new ContainerListerJukebox(tileEntity, inventoryPlayer, world));
		this.tile = tileEntity;
		this.inv = inventoryPlayer;
		this.wrld = world;
		this.name = name;
		this.color = color;
		this.dir = dir;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		categ = "default";
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.add(new GuiButton(3, x + 6, y + 112, 78, 20, "Cancel"));
		this.buttonList.add(nextButton = new GuiButton(4, x + 88, y + 112, 78, 20, "Next"));
		nextButton.enabled = true;// TODO change when categ done

		myDropdownList = new GuiDropDown(mc, x + 10, y + 20, 80, 156);
		myDropdownList.addDefaultOption("Default");
		myDropdownList.addOption("nenedrg");
		myDropdownList.addOption("eeeeeeeeee");
		myDropdownList.addOption("neneee<sbdeeeeeedrg");
		myDropdownList.addOption("neneed<sdbbbsdb<eeeeeedrg");
		myDropdownList.addOption("nenee<b<fqsgweeeeedrg");
		myDropdownList.addOption("neneedbeeeeeedrg");
		myDropdownList.addOption("neneee<<sbdsbsbeeedrg");
		myDropdownList.addOption("nenessb<sbd<seeeeedrg");
		myDropdownList.addOption("neneee<SEGeeedrg");
		myDropdownList.addOption("neneeeS<EGee<sedrg");
		myDropdownList.addOption("neneeeeedbedrg");
		myDropdownList.addOption("neneeEGeeeedrg");
		myDropdownList.addOption("neneeeesd<beedrg");
		myDropdownList.addOption("neneeSEGSessbdeeedrg");
		myDropdownList.addOption("neneeeeeedrg");
		myDropdownList.addOption("neneeeeb<eeedrg");
		myDropdownList.addOption("neneee<sbdsbdeeedrg");
		myDropdownList.addOption("neneee<bseeedrg");
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
			this.mc.displayGuiScreen(new GuiSoundBoxAddSound4(inv, tile, wrld, name, color, dir, categ));
			break;
		}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRendererObj.drawString("Sound box" + " - " + "Add sound step 4", 6, 6, 4210752);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		super.drawScreen(par1, par2, par3);
		myDropdownList.drawScreen(par1, par2, par3);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		FFMTGuiHelper.bindTexture("nanotechmod", "textures/gui/soundbox.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		myDropdownList.mouseClicked(par1, par2, par3);
		super.mouseClicked(par1, par2, par3);
	}
}