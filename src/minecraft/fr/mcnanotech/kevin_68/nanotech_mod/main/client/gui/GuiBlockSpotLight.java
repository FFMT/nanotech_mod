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
			if (TileEntityBlockSpotLightRender.red > 0)
			{
				TileEntityBlockSpotLightRender.red -= 1;
			}
		}
		if (guibutton.id == 1)
		{
			if (TileEntityBlockSpotLightRender.red > 10)
			{
				TileEntityBlockSpotLightRender.red -= 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.red = 0;
			}
		}
		if (guibutton.id == 2)
		{
			if (TileEntityBlockSpotLightRender.red > 100)
			{
				TileEntityBlockSpotLightRender.red -= 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.red = 0;
			}
		}
		if (guibutton.id == 3)
		{
			if (TileEntityBlockSpotLightRender.red < 255)
			{
				TileEntityBlockSpotLightRender.red += 1;
			}
		}
		if (guibutton.id == 4)
		{
			if (TileEntityBlockSpotLightRender.red < 245)
			{
				TileEntityBlockSpotLightRender.red += 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.red = 255;
			}
		}
		if (guibutton.id == 5)
		{
			if (TileEntityBlockSpotLightRender.red < 155)
			{
				TileEntityBlockSpotLightRender.red += 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.red = 255;
			}
		}
		
		if (guibutton.id == 6)
		{
			if (TileEntityBlockSpotLightRender.green > 0)
			{
				TileEntityBlockSpotLightRender.green -= 1;
			}
		}
		if (guibutton.id == 7)
		{
			if (TileEntityBlockSpotLightRender.green > 10)
			{
				TileEntityBlockSpotLightRender.green -= 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.green = 0;
			}
		}
		if (guibutton.id == 8)
		{
			if (TileEntityBlockSpotLightRender.green > 100)
			{
				TileEntityBlockSpotLightRender.green -= 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.green = 0;
			}
		}
		if (guibutton.id == 9)
		{
			if (TileEntityBlockSpotLightRender.green < 255)
			{
				TileEntityBlockSpotLightRender.green += 1;
			}
		}
		if (guibutton.id == 10)
		{
			if (TileEntityBlockSpotLightRender.green < 245)
			{
				TileEntityBlockSpotLightRender.green += 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.green = 255;
			}
		}
		if (guibutton.id == 11)
		{
			if (TileEntityBlockSpotLightRender.green < 155)
			{
				TileEntityBlockSpotLightRender.green += 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.green = 255;
			}
		}
		
		if (guibutton.id == 12)
		{
			if (TileEntityBlockSpotLightRender.blue > 0)
			{
				TileEntityBlockSpotLightRender.blue -= 1;
			}
		}
		if (guibutton.id == 13)
		{
			if (TileEntityBlockSpotLightRender.blue > 10)
			{
				TileEntityBlockSpotLightRender.blue -= 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.blue = 0;
			}
		}
		if (guibutton.id == 14)
		{
			if (TileEntityBlockSpotLightRender.blue > 100)
			{
				TileEntityBlockSpotLightRender.blue -= 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.blue = 0;
			}
		}
		if (guibutton.id == 15)
		{
			if (TileEntityBlockSpotLightRender.blue < 255)
			{
				TileEntityBlockSpotLightRender.blue += 1;
			}
		}
		if (guibutton.id == 16)
		{
			if (TileEntityBlockSpotLightRender.blue < 245)
			{
				TileEntityBlockSpotLightRender.blue += 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.blue = 255;
			}
		}
		if (guibutton.id == 17)
		{
			if (TileEntityBlockSpotLightRender.blue < 155)
			{
				TileEntityBlockSpotLightRender.blue += 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.blue = 255;
			}
		}
		
		if (guibutton.id == 18)
		{
			if (TileEntityBlockSpotLightRender.darkRed > 0)
			{
				TileEntityBlockSpotLightRender.darkRed -= 1;
			}
		}
		if (guibutton.id == 19)
		{
			if (TileEntityBlockSpotLightRender.darkRed > 10)
			{
				TileEntityBlockSpotLightRender.darkRed -= 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkRed = 0;
			}
		}
		if (guibutton.id == 20)
		{
			if (TileEntityBlockSpotLightRender.darkRed > 100)
			{
				TileEntityBlockSpotLightRender.darkRed -= 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkRed = 0;
			}
		}
		if (guibutton.id == 21)
		{
			if (TileEntityBlockSpotLightRender.darkRed < 255)
			{
				TileEntityBlockSpotLightRender.darkRed += 1;
			}
		}
		if (guibutton.id == 22)
		{
			if (TileEntityBlockSpotLightRender.darkRed < 245)
			{
				TileEntityBlockSpotLightRender.darkRed += 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkRed = 255;
			}
		}
		if (guibutton.id == 23)
		{
			if (TileEntityBlockSpotLightRender.darkRed < 155)
			{
				TileEntityBlockSpotLightRender.darkRed += 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkRed = 255;
			}
		}
		
		if (guibutton.id == 24)
		{
			if (TileEntityBlockSpotLightRender.darkGreen > 0)
			{
				TileEntityBlockSpotLightRender.darkGreen -= 1;
			}
		}
		if (guibutton.id == 25)
		{
			if (TileEntityBlockSpotLightRender.darkGreen > 10)
			{
				TileEntityBlockSpotLightRender.darkGreen -= 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkGreen = 0;
			}
		}
		if (guibutton.id == 26)
		{
			if (TileEntityBlockSpotLightRender.darkGreen > 100)
			{
				TileEntityBlockSpotLightRender.darkGreen -= 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkGreen = 0;
			}
		}
		if (guibutton.id == 27)
		{
			if (TileEntityBlockSpotLightRender.darkGreen < 255)
			{
				TileEntityBlockSpotLightRender.darkGreen += 1;
			}
		}
		if (guibutton.id == 28)
		{
			if (TileEntityBlockSpotLightRender.darkGreen < 245)
			{
				TileEntityBlockSpotLightRender.darkGreen += 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkGreen = 255;
			}
		}
		if (guibutton.id == 29)
		{
			if (TileEntityBlockSpotLightRender.darkGreen < 155)
			{
				TileEntityBlockSpotLightRender.darkGreen += 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkGreen = 255;
			}
		}
		
		if (guibutton.id == 30)
		{
			if (TileEntityBlockSpotLightRender.darkBlue > 0)
			{
				TileEntityBlockSpotLightRender.darkBlue -= 1;
			}
		}
		if (guibutton.id == 31)
		{
			if (TileEntityBlockSpotLightRender.darkBlue > 10)
			{
				TileEntityBlockSpotLightRender.darkBlue -= 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkBlue = 0;
			}
		}
		if (guibutton.id == 32)
		{
			if (TileEntityBlockSpotLightRender.darkBlue > 100)
			{
				TileEntityBlockSpotLightRender.darkBlue -= 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkBlue = 0;
			}
		}
		if (guibutton.id == 33)
		{
			if (TileEntityBlockSpotLightRender.darkBlue < 255)
			{
				TileEntityBlockSpotLightRender.darkBlue += 1;
			}
		}
		if (guibutton.id == 34)
		{
			if (TileEntityBlockSpotLightRender.darkBlue < 245)
			{
				TileEntityBlockSpotLightRender.darkBlue += 10;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkBlue = 255;
			}
		}
		if (guibutton.id == 35)
		{
			if (TileEntityBlockSpotLightRender.darkBlue < 155)
			{
				TileEntityBlockSpotLightRender.darkBlue += 100;
			}
			else
			{
				TileEntityBlockSpotLightRender.darkBlue = 255;
			}
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		//fontRenderer.drawString("Jump Block", 6, 6, 4210752);
		fontRenderer.drawString(String.valueOf(TileEntityBlockSpotLightRender.red), xSize/2 - 2, ySize + -153, FFMTColor.redInt);
		fontRenderer.drawString(String.valueOf(TileEntityBlockSpotLightRender.green), xSize/2 - 2, ySize + -131, FFMTColor.greenInt);
		fontRenderer.drawString(String.valueOf(TileEntityBlockSpotLightRender.blue), xSize/2 - 2, ySize + -109, FFMTColor.blueInt);
		fontRenderer.drawString(String.valueOf(TileEntityBlockSpotLightRender.darkRed), xSize/2 - 2, ySize + -87, FFMTColor.darkRedInt);
		fontRenderer.drawString(String.valueOf(TileEntityBlockSpotLightRender.darkGreen), xSize/2 - 2, ySize + -65, FFMTColor.darkGreenInt);
		fontRenderer.drawString(String.valueOf(TileEntityBlockSpotLightRender.darkBlue), xSize/2 - 2, ySize + -43, FFMTColor.darkBlueInt);

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