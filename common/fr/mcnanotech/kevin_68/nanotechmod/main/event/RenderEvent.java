package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;

public class RenderEvent
{
	private Minecraft mc = Minecraft.getMinecraft();
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/armor/crazyGlassesOverlay.png");

	@ForgeSubscribe
	public void onRenderGameOverlay(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		else
		{
			ItemStack stack = this.mc.thePlayer.inventory.armorItemInSlot(3);
			if(this.mc.gameSettings.thirdPersonView == 0 && stack != null && stack.getItem().itemID == NanotechItem.crazyGlasses.itemID)
			{
				int k = event.resolution.getScaledWidth();
				int l = event.resolution.getScaledHeight();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				this.mc.renderEngine.bindTexture(texture);
				Tessellator tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(0.0D, (double)l, -90.0D, 0.0D, 1.0D);
				tessellator.addVertexWithUV((double)k, (double)l, -90.0D, 1.0D, 1.0D);
				tessellator.addVertexWithUV((double)k, 0.0D, -90.0D, 1.0D, 0.0D);
				tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
				tessellator.draw();
				GL11.glDepthMask(true);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}