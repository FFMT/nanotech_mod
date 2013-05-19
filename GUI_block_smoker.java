package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GUI_block_smoker extends GuiContainer
{
            public GUI_block_smoker(InventoryPlayer player_inventory, TileEntity_block_smoker tile_entity, World world)
            {
                    super(new Container_block_smoker(tile_entity, player_inventory, world));
            }
            
            @Override
            public void initGui() {
                    super.initGui();
                    int x = (width - xSize) / 2;
                    int y = (height - ySize) / 2;
                    controlList.add(new GuiButton(1, x + 75, y + 15, 20, 20, "+"));
                    controlList.add(new GuiButton(2, x + 75, y + 45, 20, 20, "-"));
            }

            protected void actionPerformed(GuiButton guibutton) {

                        if (guibutton.id == 1)
                        {
                        	 Nanotech_mod.Block_smokepower += 1;
                        }
                        if (guibutton.id == 2)
                        {
                        	Nanotech_mod.Block_smokepower -= 1;
                        }

            }          
            @Override
            protected void drawGuiContainerForegroundLayer(int i, int j)
            {
            	  int x = (width - xSize) / 2;
                  int y = (height - ySize) / 2;
                  fontRenderer.drawString("Smoke Block", 6, 6, 4210752);
                    fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 + 2, 4210752);
                    if (Nanotech_mod.Block_smokepower == 0){fontRenderer.drawString("0", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 1){fontRenderer.drawString("1", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 2){ fontRenderer.drawString("2", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 3){ fontRenderer.drawString("3", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 4){ fontRenderer.drawString("4", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 5){fontRenderer.drawString("5", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 6){ fontRenderer.drawString("6", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 7){ fontRenderer.drawString("7", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 8){ fontRenderer.drawString("8", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 9){ fontRenderer.drawString("9", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 10){ fontRenderer.drawString("10", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 11){ fontRenderer.drawString("11", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 12){ fontRenderer.drawString("12", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 13){ fontRenderer.drawString("13", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 14){ fontRenderer.drawString("14", x, y, 4210752);}
                    if (Nanotech_mod.Block_smokepower == 15){ fontRenderer.drawString("15", x, y, 4210752);}
                	if (Nanotech_mod.Block_smokepower == 0){Block_smoker.smoke = 0;}
                	if (Nanotech_mod.Block_smokepower == 1){Block_smoker.smoke = 1;}
                	if (Nanotech_mod.Block_smokepower == 2){Block_smoker.smoke = 2;}
                	if (Nanotech_mod.Block_smokepower == 3){Block_smoker.smoke = 3;}
                	if (Nanotech_mod.Block_smokepower == 4){Block_smoker.smoke = 4;}
                	if (Nanotech_mod.Block_smokepower == 5){Block_smoker.smoke = 5;}
                	if (Nanotech_mod.Block_smokepower == 6){Block_smoker.smoke = 6;}
                	if (Nanotech_mod.Block_smokepower == 7){Block_smoker.smoke = 7;}
                	if (Nanotech_mod.Block_smokepower == 8){Block_smoker.smoke = 8;}
                	if (Nanotech_mod.Block_smokepower == 9){Block_smoker.smoke = 9;}
                	if (Nanotech_mod.Block_smokepower == 10){Block_smoker.smoke = 10;}
                	if (Nanotech_mod.Block_smokepower == 11){Block_smoker.smoke = 11;}
                	if (Nanotech_mod.Block_smokepower == 12){Block_smoker.smoke = 12;}
                	if (Nanotech_mod.Block_smokepower == 13){Block_smoker.smoke = 13;}
                	if (Nanotech_mod.Block_smokepower == 14){Block_smoker.smoke = 14;}
                	if (Nanotech_mod.Block_smokepower == 15){Block_smoker.smoke = 15;}
                	if (Nanotech_mod.Block_smokepower == 16){Nanotech_mod.Block_smokepower -= 1;}
                	if (Nanotech_mod.Block_smokepower == -1){Nanotech_mod.Block_smokepower += 1;}
            }
           
            @Override
            protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
            {
                    int picture = mc.renderEngine.getTexture("/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/GUI/Blocksmoker.png");
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    this.mc.renderEngine.bindTexture(picture);
                    int x = (width - xSize) / 2;
                    int y = (height - ySize) / 2;
                   
                    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

            }
}