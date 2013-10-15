package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
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
	private GuiTextField textbox;
	private String link;

	public GuiOnlineJukebox(InventoryPlayer playerinventory, TileEntityOnlineJukebox tileentity, World world)
	{
		super(new ContainerOnlineJukebox(tileentity, playerinventory, world));
		tileOnlineJukebox = tileentity;
		this.link = "";
	}

	public void updateScreen()
	{
		this.textbox.updateCursorCounter();
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		buttonList.add(new GuiButton(1, x + 75, y + 15, 20, 20, "Exit"));
		buttonList.add(new GuiButton(2, x + 75, y + 65, 20, 20, "Download"));
		buttonList.add(new GuiButton(3, x + 75, y + 85, 20, 20, "Play"));
		this.textbox = new GuiTextField(this.fontRenderer, x + 62, y + 44, 103, 12);
		this.textbox.setTextColor(-1);
		this.textbox.setDisabledTextColour(-1);
		this.textbox.setEnableBackgroundDrawing(false);
		this.textbox.setText(this.link);
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if(guibutton.id == 1)
		{
			this.mc.displayGuiScreen((GuiScreen)null);
		}
		else if(guibutton.id == 2)
		{
			try
			{
				URL u = new URL("http://dl.mcnanotech.fr:80/Launcher/Version/version.TXT");
				URLConnection uc = u.openConnection();
				int taille = uc.getContentLength();
				InputStream brut = uc.getInputStream();
				InputStream entree = new BufferedInputStream(brut);
				byte[] donnees = new byte[taille];
				int octetsLus = 0;
				int deplacement = 0;
				float alreadyRead = 0;

				while(deplacement < taille)
				{
					octetsLus = entree.read(donnees, deplacement, donnees.length - deplacement);
					alreadyRead = alreadyRead + octetsLus;
					if(octetsLus == -1)
						break;
					deplacement += octetsLus;

				}
				entree.close();
				String fichier = u.getFile();
				fichier = fichier.substring(fichier.lastIndexOf("/") + 1);
				FileOutputStream fichierSortie = new FileOutputStream(fichier);
				fichierSortie.write(donnees);
				fichierSortie.flush();
				fichierSortie.close();
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else if(guibutton.id == 3)
		{
			
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		fontRenderer.drawString("Smoke Block", 6, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 4210752);
	}

	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.textbox.drawTextBox();
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
		if(this.textbox.textboxKeyTyped(par1, par2))
		{
			this.func_135015_g();
		}
		else
		{
			super.keyTyped(par1, par2);
		}
	}

	private void func_135015_g()
	{
		String s = this.textbox.getText();
		s = "";
	}

	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		this.textbox.mouseClicked(par1, par2, par3);
	}
}
