package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.city.container.ContainerOnlineJukebox;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityOnlineJukebox;

public class GuiOnlineJukebox extends GuiContainer
{
	private TileEntityOnlineJukebox tileOnlineJukebox;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/gui/Smoker.png");
	private GuiTextField textboxSeed;
	private String seed;
	
	public GuiOnlineJukebox(InventoryPlayer playerinventory, TileEntityOnlineJukebox tileentity, World world)
	{
		super(new ContainerOnlineJukebox(tileentity, playerinventory, world));
		tileOnlineJukebox = tileentity;
		this.seed = "";
	}
	
    public void updateScreen()
    {
        this.textboxSeed.updateCursorCounter();
    }
    
	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		buttonList.add(new GuiButton(1, x + 75, y + 15, 20, 20, "Exit"));
		//buttonList.add(new GuiButton(2, x + 75, y + 45, 20, 20, "-"));
        this.textboxSeed = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 60, 200, 20);
        this.textboxSeed.setText(this.seed);
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if (guibutton.id == 1)
        {
			this.mc.displayGuiScreen((GuiScreen)null);
        }
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRenderer.drawString("Smoke Block", 6, 6, 4210752);
		fontRenderer.drawString(seed, 6, 20, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 4210752);
		this.textboxSeed.drawTextBox();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
    protected void keyTyped(char par1, int par2)
    {
    	if (this.textboxSeed.isFocused())
        {
            this.textboxSeed.textboxKeyTyped(par1, par2);
            this.seed = this.textboxSeed.getText();
        }

        if (par2 == 28 || par2 == 156)
        {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        this.textboxSeed.mouseClicked(par1, par2, par3);
    }
}
