package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items.ItemLightSaberModel;

public class ItemLightSaberRender implements IItemRenderer
{
	protected ItemLightSaberModel model;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/items/lightsword.png");

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
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(-140, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.65F, -1.35F, 0.0F);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, false);
			GL11.glColor3d(item.getItemDamage() == 1 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 2 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 3 ? 255 :(item.getItemDamage() == 4 ? 255 : 0));
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, true);			
			GL11.glPopMatrix();
			break;
		}
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(-140, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.65F, -1.35F, 0.0F);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, false);
			GL11.glColor3d(item.getItemDamage() == 1 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 2 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 3 ? 255 :(item.getItemDamage() == 4 ? 255 : 0));
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, true);
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
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, false);
			GL11.glColor3d(item.getItemDamage() == 1 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 2 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 3 ? 255 :(item.getItemDamage() == 4 ? 255 : 0));
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, true);
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
			model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, false);
			GL11.glColor3d(item.getItemDamage() == 1 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 2 ? 255 :(item.getItemDamage() == 4 ? 255 : 0), item.getItemDamage() == 3 ? 255 :(item.getItemDamage() == 4 ? 255 : 0));
			model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, true);
			GL11.glPopMatrix();
			break;
		}
		default:
			break;
		}
	}
}