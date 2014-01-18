package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.items.ItemLightSaberModel;

public class ItemLightSaberRender implements IItemRenderer
{
	protected ItemLightSaberModel model;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/items/lightsword.png");

	public ItemLightSaberRender()
	{
		model = new ItemLightSaberModel();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case ENTITY:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
		}

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		int red = (item.hasTagCompound() && item.getTagCompound().hasKey("red")) ? item.getTagCompound().getInteger("red") : 0;
		int green = (item.hasTagCompound() && item.getTagCompound().hasKey("green")) ? item.getTagCompound().getInteger("green") : 0;
		int blue = (item.hasTagCompound() && item.getTagCompound().hasKey("blue")) ? item.getTagCompound().getInteger("blue") : 0;
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(-140, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.65F, -1.35F, 0.0F);
			model.render(0.0625F, item, false);
			GL11.glColor3d((float)(red) / 255.0F, (float)(green) / 255.0F, (float)(blue) / 255.0F);
			model.render(0.0625F, item, true);
			GL11.glPopMatrix();
			break;
		}
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(-140, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.65F, -1.35F, 0.0F);
			model.render(0.0625F, item, false);
			GL11.glColor3d((float)(red) / 255.0F, (float)(green) / 255.0F, (float)(blue) / 255.0F);
			model.render(0.0625F, item, true);
			GL11.glPopMatrix();
			break;
		}
		case ENTITY:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(0, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.4F, 0.2F, 0.0F);
			GL11.glScalef(2.0F, 2.0F, 2.0F);
			if(RenderItem.renderInFrame)
			{
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				GL11.glTranslatef(-1.1F, -0.5F, 0.1F);
				GL11.glRotatef(-45.0F, 0.0F, 0.0F, 1.0F);
			}
			model.render(0.0625F, item, false);
			GL11.glColor3d((float)(red) / 255.0F, (float)(green) / 255.0F, (float)(blue) / 255.0F);
			model.render(0.0625F, item, true);
			GL11.glPopMatrix();
			break;
		}
		case INVENTORY:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(45.F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(11.5F, -16.0F, 0.0F);
			GL11.glScalef(17F, 17F, 17F);
			model.render(0.0625F, item, false);
			GL11.glColor3d((float)(red) / 255.0F, (float)(green) / 255.0F, (float)(blue) / 255.0F);
			model.render(0.0625F, item, true);
			GL11.glPopMatrix();
			break;
		}
		default:
			break;
		}
	}
}