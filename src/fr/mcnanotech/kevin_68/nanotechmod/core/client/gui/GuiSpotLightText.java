package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiSliderForContainer;

public class GuiSpotLightText extends GuiContainerSliderBase
{
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlighttex.png");

    public InventoryPlayer invPlayer;
    public TileEntitySpotLight tileSpotLight;
    public World world;
    public GuiTextField txtField;
    public GuiBooleanButton rotateButton, revRotaButton;

    public GuiSpotLightText(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
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

        Keyboard.enableRepeatEvents(true);
        this.txtField = new GuiTextField(this.fontRendererObj, x - 40, y - 40, 256, 12);
        this.txtField.setTextColor((tileSpotLight.getTxtRed() * 65536) + (tileSpotLight.getTxtGreen() * 256) + tileSpotLight.getTxtBlue());
        this.txtField.setEnableBackgroundDrawing(true);
        this.txtField.setMaxStringLength(40);
        this.txtField.setEnabled(true);
        this.txtField.setText(tileSpotLight.getDisplayText());

        this.buttonList.add(new GuiSliderForContainer(this, 0, x - 40, y - 20, 256, 20, I18n.format("container.spotlight.red") + " : " + (tileSpotLight.getTxtRed() & 0xFF), (tileSpotLight.getTxtRed() & 0xFF) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 1, x - 40, y + 2, 256, 20, I18n.format("container.spotlight.green") + " : " + (tileSpotLight.getTxtGreen() & 0xFF), (tileSpotLight.getTxtGreen() & 0xFF) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 2, x - 40, y + 25, 256, 20, I18n.format("container.spotlight.blue") + " : " + (tileSpotLight.getTxtBlue() & 0xFF), (tileSpotLight.getTxtBlue() & 0xFF) / 255.0F));
        this.buttonList.add(new GuiSliderForContainer(this, 3, x - 40, y + 48, 256, 20, I18n.format("container.spotlight.angle") + " 1 : " + (tileSpotLight.getTxtAngle1()), (tileSpotLight.getTxtAngle1()) / 360.0F));
        this.buttonList.add(rotateButton = new GuiBooleanButton(7, x - 40, y + 94, 127, 20, I18n.format("container.spotlight.rotate") + " " + I18n.format("container.spotlight.on"), I18n.format("container.spotlight.rotate") + " " + I18n.format("container.spotlight.off"), tileSpotLight.isTxtAutoRotate()));
        this.buttonList.add(revRotaButton = new GuiBooleanButton(8, x + 90, y + 72, 127, 20, I18n.format("container.spotlight.rotationreverse") + " " + I18n.format("container.spotlight.on"), I18n.format("container.spotlight.rotationreverse") + " " + I18n.format("container.spotlight.off"), tileSpotLight.isTxtReverseRotation()));
        this.buttonList.add(new GuiSliderForContainer(this, 5, x - 40, y + 72, 127, 20, I18n.format("container.spotlight.rotationspeed") + " : " + (tileSpotLight.getTxtRotationSpeed() & 0xFF), (tileSpotLight.getTxtRotationSpeed()) / 20.0F));

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
            case 7:
            {
                rotateButton.toggle();
                PacketSender.sendSpotLightPacketBoolean(tileSpotLight, (byte)33, rotateButton.getIsActive());
                break;
            }
            case 8:
            {
                revRotaButton.toggle();
                PacketSender.sendSpotLightPacketBoolean(tileSpotLight, (byte)34, revRotaButton.getIsActive());
                break;
            }
        }
    }

    @Override
    public void handlerSliderAction(int sliderId, float sliderValue)
    {
        if(sliderId < 3)
        {
            PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)(28 + sliderId), (byte)(sliderValue * 255.0F));
            this.txtField.setTextColor((tileSpotLight.getTxtRed() * 65536) + (tileSpotLight.getTxtGreen() * 256) + tileSpotLight.getTxtBlue());
        }
        else if(sliderId == 3)
        {
            PacketSender.sendSpotLightPacket(tileSpotLight, 31, (int)(sliderValue * 360.0F));
        }
        else if(sliderId == 5)
        {
            PacketSender.sendSpotLightPacketByte(tileSpotLight, (byte)35, (byte)(sliderValue * 20.0F));
        }
    }

    @Override
    public String getSliderName(int sliderId, float sliderValue)
    {
        String name = "";
        switch(sliderId)
        {
            case 0:
            {
                name = I18n.format("container.spotlight.red") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
                break;
            }
            case 1:
            {
                name = I18n.format("container.spotlight.green") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
                break;
            }
            case 2:
            {
                name = I18n.format("container.spotlight.blue") + " : " + ((byte)(sliderValue * 255.0F) & 0xFF);
                break;
            }
            case 3:
            {
                name = I18n.format("container.spotlight.angle") + " 1 : " + ((int)(sliderValue * 360.0F));
                break;
            }
            case 5:
            {
                name = I18n.format("container.spotlight.rotationspeed") + " : " + ((int)(sliderValue * 20.0F));
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

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.txtField.drawTextBox();
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    protected void keyTyped(char par1, int par2)
    {
        if(this.txtField.textboxKeyTyped(par1, par2))
        {
            PacketSender.sendSpotLightPacket(tileSpotLight, 26, this.txtField.getText());
        }
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        this.txtField.mouseClicked(par1, par2, par3);
    }
}