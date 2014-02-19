/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.items.ItemNanomiteArrowGunModel;

public class ItemNanomiteArrowGunRender implements IItemRenderer
{
	protected ItemNanomiteArrowGunModel model;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/items/nanomitearrowgun.png");

	public ItemNanomiteArrowGunRender()
	{
		model = new ItemNanomiteArrowGunModel();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED:
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
			GL11.glRotatef(17F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(43F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-50F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(78F, 1.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.45F, 0.1F, 0.1F);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			break;
		}
		default:
			break;
		}
	}
}