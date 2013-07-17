package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.FFMT.FFMTAPI.FFMTColor;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerBlockSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityBlockSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.render.TileEntityBlockSpotLightRender;

public class GuiBlockSpotLight extends GuiContainer
{
	protected TileEntityBlockSpotLight tileSpotLight;
    public GuiBlockSpotLight(InventoryPlayer player_inventory, TileEntityBlockSpotLight tile_entity, World world)
	{
		super(new ContainerBlockSpotLight(tile_entity, player_inventory, world));
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

			buttonList.add(new GuiButton(0, width/2-30, y + 7, 20, 20, FFMTColor.red + "-1"));
			buttonList.add(new GuiButton(1, width/2-58, y + 7, 20, 20, FFMTColor.red + "-10"));
			buttonList.add(new GuiButton(2, width/2-86, y + 7, 20, 20, FFMTColor.red + "-100"));
			buttonList.add(new GuiButton(3, width/2+10, y + 7, 20, 20, FFMTColor.red + "+1"));
			buttonList.add(new GuiButton(4, width/2+38, y + 7, 20, 20, FFMTColor.red + "+10"));
			buttonList.add(new GuiButton(5, width/2+66, y + 7, 20, 20, FFMTColor.red + "+100"));
			
			buttonList.add(new GuiButton(6, width/2-30, y + 29, 20, 20, FFMTColor.green + "-1"));
			buttonList.add(new GuiButton(7, width/2-58, y + 29, 20, 20, FFMTColor.green + "-10"));
			buttonList.add(new GuiButton(8, width/2-86, y + 29, 20, 20, FFMTColor.green + "-100"));
			buttonList.add(new GuiButton(9, width/2+10, y + 29, 20, 20, FFMTColor.green + "+1"));
			buttonList.add(new GuiButton(10, width/2+38, y + 29, 20, 20, FFMTColor.green + "+10"));
			buttonList.add(new GuiButton(11, width/2+66, y + 29, 20, 20, FFMTColor.green + "+100"));
		
			buttonList.add(new GuiButton(12, width/2-30, y + 51, 20, 20, FFMTColor.blue + "-1"));
			buttonList.add(new GuiButton(13, width/2-58, y + 51, 20, 20, FFMTColor.blue + "-10"));
			buttonList.add(new GuiButton(14, width/2-86, y + 51, 20, 20, FFMTColor.blue + "-100"));
			buttonList.add(new GuiButton(15, width/2+10, y + 51, 20, 20, FFMTColor.blue + "+1"));
			buttonList.add(new GuiButton(16, width/2+38, y + 51, 20, 20, FFMTColor.blue + "+10"));
			buttonList.add(new GuiButton(17, width/2+66, y + 51, 20, 20, FFMTColor.blue + "+100"));

			buttonList.add(new GuiButton(18, width/2-30, y + 73, 20, 20, FFMTColor.darkRed + "-1"));
			buttonList.add(new GuiButton(19, width/2-58, y + 73, 20, 20, FFMTColor.darkRed + "-10"));
			buttonList.add(new GuiButton(20, width/2-86, y + 73, 20, 20, FFMTColor.darkRed + "-100"));
			buttonList.add(new GuiButton(21, width/2+10, y + 73, 20, 20, FFMTColor.darkRed + "+1"));
			buttonList.add(new GuiButton(22, width/2+38, y + 73, 20, 20, FFMTColor.darkRed + "+10"));
			buttonList.add(new GuiButton(23, width/2+66, y + 73, 20, 20, FFMTColor.darkRed + "+100"));
			
			buttonList.add(new GuiButton(24, width/2-30, y + 95, 20, 20, FFMTColor.darkGreen + "-1"));
			buttonList.add(new GuiButton(25, width/2-58, y + 95, 20, 20, FFMTColor.darkGreen + "-10"));
			buttonList.add(new GuiButton(26, width/2-86, y + 95, 20, 20, FFMTColor.darkGreen + "-100"));
			buttonList.add(new GuiButton(27, width/2+10, y + 95, 20, 20, FFMTColor.darkGreen + "+1"));
			buttonList.add(new GuiButton(28, width/2+38, y + 95, 20, 20, FFMTColor.darkGreen + "+10"));
			buttonList.add(new GuiButton(29, width/2+66, y + 95, 20, 20, FFMTColor.darkGreen + "+100"));
		
			buttonList.add(new GuiButton(30, width/2-30, y + 117, 20, 20, FFMTColor.darkBlue + "-1"));
			buttonList.add(new GuiButton(31, width/2-58, y + 117, 20, 20, FFMTColor.darkBlue + "-10"));
			buttonList.add(new GuiButton(32, width/2-86, y + 117, 20, 20, FFMTColor.darkBlue + "-100"));
			buttonList.add(new GuiButton(33, width/2+10, y + 117, 20, 20, FFMTColor.darkBlue + "+1"));
			buttonList.add(new GuiButton(34, width/2+38, y + 117, 20, 20, FFMTColor.darkBlue + "+10"));
			buttonList.add(new GuiButton(35, width/2+66, y + 117, 20, 20, FFMTColor.darkBlue + "+100"));
	}

	protected void actionPerformed(GuiButton guibutton)
	{
		if (guibutton.id == 0)
		{
			if (tileSpotLight.getRedValue() > 0)
			{
				tileSpotLight.addRedValue(-1);
			}
		}
		if (guibutton.id == 1)
		{
			if (tileSpotLight.getRedValue()  > 10)
			{
				tileSpotLight.addRedValue(-10);
			}
			else
			{
				tileSpotLight.setRedValue(0);
			}
		}
		if (guibutton.id == 2)
		{
			if (tileSpotLight.getRedValue()  > 100)
			{
				tileSpotLight.addRedValue(-100);
			}
			else
			{
				tileSpotLight.setRedValue(0);
			}
		}
		if (guibutton.id == 3)
		{
			if (tileSpotLight.getRedValue()  < 255)
			{
				tileSpotLight.addRedValue(1);
			}
		}
		if (guibutton.id == 4)
		{
			if (tileSpotLight.getRedValue()  < 245)
			{
				tileSpotLight.addRedValue(10);
			}
			else
			{
				tileSpotLight.setRedValue(255);
			}
		}
		if (guibutton.id == 5)
		{
			if (tileSpotLight.getRedValue()  < 155)
			{
				tileSpotLight.addRedValue(100);
			}
			else
			{
				tileSpotLight.setRedValue(255);
			}
		}
		
		if (guibutton.id == 6)
		{
			if (tileSpotLight.getGreenValue() > 0)
			{
				tileSpotLight.addGreenValue(-1);
			}
		}
		if (guibutton.id == 7)
		{
			if (tileSpotLight.getGreenValue() > 10)
			{
				tileSpotLight.addGreenValue(-10);
			}
			else
			{
				tileSpotLight.setGreenValue(0);
			}
		}
		if (guibutton.id == 8)
		{
			if (tileSpotLight.getGreenValue() > 100)
			{
				tileSpotLight.addGreenValue(-100);
			}
			else
			{
				tileSpotLight.setGreenValue(0);
			}
		}
		if (guibutton.id == 9)
		{
			if (tileSpotLight.getGreenValue() < 255)
			{
				tileSpotLight.addGreenValue(1);
			}
		}
		if (guibutton.id == 10)
		{
			if (tileSpotLight.getGreenValue() < 245)
			{
				tileSpotLight.addGreenValue(10);
			}
			else
			{
				tileSpotLight.setGreenValue(255);
			}
		}
		if (guibutton.id == 11)
		{
			if (tileSpotLight.getGreenValue() < 155)
			{
				tileSpotLight.addGreenValue(100);
			}
			else
			{
				tileSpotLight.setGreenValue(255);
			}
		}
		
		if (guibutton.id == 12)
		{
			if (tileSpotLight.getBlueValue() > 0)
			{
				tileSpotLight.addBlueValue(-1);
			}
		}
		if (guibutton.id == 13)
		{
			if (tileSpotLight.getBlueValue() > 10)
			{
				tileSpotLight.addBlueValue(-10);
			}
			else
			{
				tileSpotLight.setBlueValue(0);
			}
		}
		if (guibutton.id == 14)
		{
			if (tileSpotLight.getBlueValue() > 100)
			{
				tileSpotLight.addBlueValue(-100);
			}
			else
			{
				tileSpotLight.setBlueValue(0);
			}
		}
		if (guibutton.id == 15)
		{
			if (tileSpotLight.getBlueValue() < 255)
			{
				tileSpotLight.addBlueValue(1);
			}
		}
		if (guibutton.id == 16)
		{
			if (tileSpotLight.getBlueValue() < 245)
			{
				tileSpotLight.addBlueValue(10);
			}
			else
			{
				tileSpotLight.setBlueValue(255);
			}
		}
		if (guibutton.id == 17)
		{
			if (tileSpotLight.getBlueValue() < 155)
			{
				tileSpotLight.addBlueValue(100);
			}
			else
			{
				tileSpotLight.setBlueValue(255);
			}
		}
		
		if (guibutton.id == 18)
		{
			if (tileSpotLight.getDarkRedValue() > 0)
			{
				tileSpotLight.addDarkRedValue(-1);
			}
		}
		if (guibutton.id == 19)
		{
			if (tileSpotLight.getDarkRedValue() > 10)
			{
				tileSpotLight.addDarkRedValue(-10);
			}
			else
			{
				tileSpotLight.setDarkRedValue(0);
			}
		}
		if (guibutton.id == 20)
		{
			if (tileSpotLight.getDarkRedValue() > 100)
			{
				tileSpotLight.addDarkRedValue(-100);
			}
			else
			{
				tileSpotLight.setDarkRedValue(0);
			}
		}
		if (guibutton.id == 21)
		{
			if (tileSpotLight.getDarkRedValue() < 255)
			{
				tileSpotLight.addDarkRedValue(1);
			}
		}
		if (guibutton.id == 22)
		{
			if (tileSpotLight.getDarkRedValue() < 245)
			{
				tileSpotLight.addDarkRedValue(10);
			}
			else
			{
				tileSpotLight.setDarkRedValue(255);
			}
		}
		if (guibutton.id == 23)
		{
			if (tileSpotLight.getDarkRedValue() < 155)
			{
				tileSpotLight.addDarkRedValue(100);
			}
			else
			{
				tileSpotLight.setDarkRedValue(255);
			}
		}
		
		if (guibutton.id == 24)
		{
			if (tileSpotLight.getDarkGreenValue() > 0)
			{
				tileSpotLight.addDarkGreenValue(-1);
			}
		}
		if (guibutton.id == 25)
		{
			if (tileSpotLight.getDarkGreenValue() > 10)
			{
				tileSpotLight.addDarkGreenValue(-10);
			}
			else
			{
				tileSpotLight.setDarkGreenValue(0);
			}
		}
		if (guibutton.id == 26)
		{
			if (tileSpotLight.getDarkGreenValue() > 100)
			{
				tileSpotLight.addDarkGreenValue(-100);
			}
			else
			{
				tileSpotLight.setDarkGreenValue(0);
			}
		}
		if (guibutton.id == 27)
		{
			if (tileSpotLight.getDarkGreenValue() < 255)
			{
				tileSpotLight.addDarkGreenValue(1);
			}
		}
		if (guibutton.id == 28)
		{
			if (tileSpotLight.getDarkGreenValue() < 245)
			{
				tileSpotLight.addDarkGreenValue(10);
			}
			else
			{
				tileSpotLight.setDarkGreenValue(255);
			}
		}
		if (guibutton.id == 29)
		{
			if (tileSpotLight.getDarkGreenValue() < 155)
			{
				tileSpotLight.addDarkGreenValue(100);
			}
			else
			{
				tileSpotLight.addDarkGreenValue(255);
			}
		}
		
		if (guibutton.id == 30)
		{
			if (tileSpotLight.getDarkBlueValue() > 0)
			{
				tileSpotLight.addDarkBlueValue(-1);
			}
		}
		if (guibutton.id == 31)
		{
			if (tileSpotLight.getDarkBlueValue() > 10)
			{
				tileSpotLight.addDarkBlueValue(-10);
			}
			else
			{
				tileSpotLight.setDarkBlueValue(0);
			}
		}
		if (guibutton.id == 32)
		{
			if (tileSpotLight.getDarkBlueValue() > 100)
			{
				tileSpotLight.addDarkBlueValue(-100);
			}
			else
			{
				tileSpotLight.setDarkBlueValue(0);
			}
		}
		if (guibutton.id == 33)
		{
			if (tileSpotLight.getDarkBlueValue() < 255)
			{
				tileSpotLight.addDarkBlueValue(1);
			}
		}
		if (guibutton.id == 34)
		{
			if (tileSpotLight.getDarkBlueValue() < 245)
			{
				tileSpotLight.addDarkBlueValue(10);
			}
			else
			{
				tileSpotLight.setDarkBlueValue(255);
			}
		}
		if (guibutton.id == 35)
		{
			if (tileSpotLight.getDarkBlueValue() < 155)
			{
				tileSpotLight.addDarkBlueValue(100);
			}
			else
			{
				tileSpotLight.setDarkBlueValue(255);
			}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		/*fontRenderer.drawString(String.valueOf(tileSpotLight.getRedValue()), xSize/2 - 2, ySize + -153, FFMTColor.redInt);
		fontRenderer.drawString(String.valueOf(tileSpotLight.getGreenValue()), xSize/2 - 2, ySize + -131, FFMTColor.greenInt);
		fontRenderer.drawString(String.valueOf(tileSpotLight.getBlueValue()), xSize/2 - 2, ySize + -109, FFMTColor.blueInt);
		fontRenderer.drawString(String.valueOf(tileSpotLight.getDarkRedValue()), xSize/2 - 2, ySize + -87, FFMTColor.darkRedInt);
		fontRenderer.drawString(String.valueOf(tileSpotLight.getDarkGreenValue()), xSize/2 - 2, ySize + -65, FFMTColor.darkGreenInt);
		fontRenderer.drawString(String.valueOf(tileSpotLight.getDarkBlueValue()), xSize/2 - 2, ySize + -43, FFMTColor.darkBlueInt);
*/
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture("/mods/Nanotech_mod/textures/gui/BlockJumper.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}