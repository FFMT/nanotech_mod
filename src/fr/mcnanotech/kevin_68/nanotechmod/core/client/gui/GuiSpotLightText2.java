package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiSliderForContainer;

public class GuiSpotLightText2 extends GuiContainerSliderBase
{
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlighttex.png");

    public InventoryPlayer invPlayer;
    public TileEntitySpotLight tileSpotLight;
    public World world;

    public GuiSpotLightText2(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
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

        this.buttonList.add(new GuiSliderForContainer(this, 0, x - 87, y - 20, 350, 20, I18n.format("container.spotlight.scale") + " : " + (int)((tileSpotLight.getTxtScale() & 0xFF) * 3.96F + 10) + " %", (tileSpotLight.getTxtScale() & 0xFF) / 250.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 1, x - 87, y + 2, 350, 20, I18n.format("container.spotlight.height") + " : " + ((tileSpotLight.getTxtHeight() & 0xFF) - 125), (tileSpotLight.getTxtHeight() & 0xFF) / 250.0F));

        this.buttonList.add(new GuiButton(6, x + 38, y + 117, 100, 20, I18n.format("container.spotlight.back")));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton)
    {
        switch(guibutton.id)
        {
            case 6:
            {
                this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
                break;
            }
        }
    }

    @Override
    public void handlerSliderAction(int sliderId, float sliderValue)
    {
        PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)(38 + sliderId), (byte)(sliderValue * 250.0F));
    }

    @Override
    public String getSliderName(int sliderId, float sliderValue)
    {
        String name = "";
        switch(sliderId)
        {
            case 0:
            {
                name = I18n.format("container.spotlight.scale") + " : " + (int)(((byte)(sliderValue * 250.0F) & 0xFF) * 3.96F + 10) + " %";
                break;
            }
            case 1:
            {
                name = I18n.format("container.spotlight.height") + " : " + (((byte)(sliderValue * 250.0F) & 0xFF) - 125);
                break;
            }
        }
        return name;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.mc.renderEngine.bindTexture(texture);
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}