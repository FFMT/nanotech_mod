package fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

//
// GuiBuffBar implements a simple status bar at the top of the screen which
// shows the current buffs/debuffs applied to the character.
//
public class GuiOverlay extends Gui
{
  private Minecraft mc;

  public GuiOverlay(Minecraft mc)
  {
    super();
   
    // We need this to invoke the render engine.
    this.mc = mc;
  }
  @ForgeSubscribe(priority = EventPriority.NORMAL)
  public void onRenderExperienceBar(RenderGameOverlayEvent event)
  {
    if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
    {      
      return;
    }

    ItemStack stack = this.mc.thePlayer.inventory.armorItemInSlot(3);
    if (this.mc.gameSettings.thirdPersonView == 0 && stack != null && stack.getItem().itemID == NanotechItem.Mysterioushelmet.itemID)
    {
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int k = scaledresolution.getScaledWidth();
        int l = scaledresolution.getScaledHeight();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING); 
    	this.mc.renderEngine.bindTexture("/mods/Nanotech_mod/textures/armor/test.png");
    	 Tessellator tessellator = Tessellator.instance;
         tessellator.startDrawingQuads();
         tessellator.addVertexWithUV(0.0D, (double)l, -90.0D, 0.0D, 1.0D);
         tessellator.addVertexWithUV((double)k, (double)l, -90.0D, 1.0D, 1.0D);
         tessellator.addVertexWithUV((double)k, 0.0D, -90.0D, 1.0D, 0.0D);
         tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
         tessellator.draw();
    }
  }
}