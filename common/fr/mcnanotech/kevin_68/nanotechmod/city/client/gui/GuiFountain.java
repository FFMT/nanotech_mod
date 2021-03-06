/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityFountain;

public class GuiFountain extends GuiContainer
{
    private TileEntityFountain tileFoutain;
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmodcity:textures/gui/Fountain.png");

    public GuiFountain(InventoryPlayer playerinventory, TileEntityFountain tileentity, World world)
    {
        super(new ContainerFountain(tileentity, playerinventory, world));
        tileFoutain = tileentity;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void initGui()
    {
        super.initGui();
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        buttonList.add(new GuiButton(1, width / 2 - 58, y + 17, 20, 20, "+"));
        buttonList.add(new GuiButton(2, width / 2 + 38, y + 17, 20, 20, "-"));
        buttonList.add(new GuiButton(3, width / 2 - 58, y + 39, 20, 20, "+"));
        buttonList.add(new GuiButton(4, width / 2 + 38, y + 39, 20, 20, "-"));
        buttonList.add(new GuiButton(5, width / 2 - 73, y + 61, 50, 20, "Rotate"));
        buttonList.add(new GuiButton(6, width / 2 + 23, y + 61, 50, 20, "Stop"));
        buttonList.add(new GuiButton(7, width / 2 - 73, y + 83, 50, 20, "Animate"));
        buttonList.add(new GuiButton(8, width / 2 + 23, y + 83, 50, 20, "Stop"));
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 1)
        {
            if(tileFoutain.getHeight() < 6.0F)
            {
                this.sendFountainPacket(tileFoutain.getHeight() + 0.5F, tileFoutain.getWidth(), tileFoutain.getRotate(), tileFoutain.getAnimated());
            }
        }

        else if(guibutton.id == 2)
        {
            if(tileFoutain.getHeight() > 0.5F)
            {
                this.sendFountainPacket(tileFoutain.getHeight() - 0.5F, tileFoutain.getWidth(), tileFoutain.getRotate(), tileFoutain.getAnimated());
            }
        }
        else if(guibutton.id == 3)
        {
            if(tileFoutain.getWidth() < 0.5D)
            {
                this.sendFountainPacket(tileFoutain.getHeight(), tileFoutain.getWidth() + 0.05F, tileFoutain.getRotate(), tileFoutain.getAnimated());
            }
        }

        else if(guibutton.id == 4)
        {
            if(tileFoutain.getWidth() > 0.05F)
            {
                this.sendFountainPacket(tileFoutain.getHeight(), tileFoutain.getWidth() - 0.05F, tileFoutain.getRotate(), tileFoutain.getAnimated());
            }
        }
        else if(guibutton.id == 5)
        {
            if(!tileFoutain.getRotate())
            {
                this.sendFountainPacket(tileFoutain.getHeight(), tileFoutain.getWidth(), true, tileFoutain.getAnimated());
            }
        }

        else if(guibutton.id == 6)
        {
            if(tileFoutain.getRotate())
            {
                this.sendFountainPacket(tileFoutain.getHeight(), tileFoutain.getWidth(), false, tileFoutain.getAnimated());
            }
        }

        else if(guibutton.id == 7)
        {
            if(!tileFoutain.getAnimated())
            {
                this.sendFountainPacket(tileFoutain.getHeight(), tileFoutain.getWidth(), tileFoutain.getRotate(), true);
            }
        }

        else if(guibutton.id == 8)
        {
            if(tileFoutain.getAnimated())
            {
                this.sendFountainPacket(tileFoutain.getHeight(), tileFoutain.getWidth(), tileFoutain.getRotate(), false);
            }
        }
    }

    private void sendFountainPacket(float height, float width, boolean doRotate, boolean isAnimated)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

        try
        {
            dataoutputstream.writeFloat(height);
            dataoutputstream.writeFloat(width);
            dataoutputstream.writeBoolean(doRotate);
            dataoutputstream.writeBoolean(isAnimated);
            // TODO packet
            // this.mc.getNetHandler().addToSendQueue(new
            // Packet250CustomPayload("NTMC|fount",
            // bytearrayoutputstream.toByteArray()));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            // TODO log
            // NanotechModCity.nanoLog.severe("Failed to send a packet from a fountain");
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        int rotatePos;
        int animPos;
        if(tileFoutain.rotate)
        {
            rotatePos = 8;
        }
        else
        {
            rotatePos = 10;
        }
        if(tileFoutain.animated)
        {
            animPos = 8;
        }
        else
        {
            animPos = 10;
        }

        fontRendererObj.drawString(I18n.format("container.fountain"), 6, 6, 4210752);
        fontRendererObj.drawString(String.valueOf(tileFoutain.height), xSize / 2 - 5, ySize + -143, 4210752);
        fontRendererObj.drawString(String.valueOf(tileFoutain.width), xSize / 2 - 5, ySize + -121, 4210752);
        fontRendererObj.drawString(String.valueOf(tileFoutain.rotate), xSize / 2 - rotatePos, ySize + -99, 4210752);
        fontRendererObj.drawString(String.valueOf(tileFoutain.animated), xSize / 2 - animPos, ySize + -77, 4210752);
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
}