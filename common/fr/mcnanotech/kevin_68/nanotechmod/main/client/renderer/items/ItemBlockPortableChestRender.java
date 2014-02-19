/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.blocks.ModelPortableChest;

public class ItemBlockPortableChestRender implements IItemRenderer
{
	public final ModelPortableChest model;
	public final ModelBiped modelB;
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/blocks/portablechest.png");
	protected static ResourceLocation player;
	private static final ResourceLocation steveTextures = new ResourceLocation("textures/entity/steve.png");

	public ItemBlockPortableChestRender()
	{
		model = new ModelPortableChest();
		modelB = new ModelBiped();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		if(item.getItemDamage() == 0)
		{
			switch(type)
			{
			case EQUIPPED:
				return true;
			case EQUIPPED_FIRST_PERSON:
				return true;
			case ENTITY:
				return true;
			default:
				return false;
			}
		}
		else
		{
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
		if(item.getItemDamage() == 0)
		{
			switch(type)
			{
			case EQUIPPED:
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-25F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.0F, -0.5F, 0.0F);
				model.render(0.0625F);
				GL11.glPopMatrix();
				break;
			}
			case EQUIPPED_FIRST_PERSON:
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-30F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-86.9F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(0.9F, -0.8F, -1.8F);
				GL11.glScaled(1.5F, 1.5F, 1.5F);
				model.render(0.0625F);
				GL11.glPopMatrix();

				GL11.glPushMatrix();
				if(((AbstractClientPlayer)((Entity)data[1])).getLocationSkin() != null)
				{
					player = ((AbstractClientPlayer)((Entity)data[1])).getLocationSkin();
				}
				else
				{
					player = steveTextures;
				}
				Minecraft.getMinecraft().renderEngine.bindTexture(player);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-120F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(2.0F, 0.5F, 0.2F);
				modelB.bipedRightArm.render(0.0625F);
				GL11.glPopMatrix();

				GL11.glPushMatrix();
				if(((AbstractClientPlayer)((Entity)data[1])).getLocationSkin() != null)
				{
					player = ((AbstractClientPlayer)((Entity)data[1])).getLocationSkin();
				}
				else
				{
					player = steveTextures;
				}
				Minecraft.getMinecraft().renderEngine.bindTexture(player);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-120F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(-0.32F, 0.5F, 0.2F);
				modelB.bipedLeftArm.render(0.0625F);
				GL11.glPopMatrix();
				break;
			}
			case ENTITY:
			{
				if(RenderItem.renderInFrame)
				{
					GL11.glPushMatrix();
					Minecraft.getMinecraft().renderEngine.bindTexture(texture);
					GL11.glTranslatef(0.2F, -1.25F, 0.0F);
					GL11.glScalef(1.4F, 1.4F, 1.4F);
					GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
					model.render(0.0625F);
					GL11.glPopMatrix();
					break;
				}
			}
			default:
				break;
			}
		}
	}
}