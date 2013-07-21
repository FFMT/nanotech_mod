package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items.ItemCrazyGlassesModel;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items.ItemScytheModel;

public class ItemCrazyGlassesRender implements IItemRenderer
{

	protected ItemCrazyGlassesModel model;
	
	public ItemCrazyGlassesRender()
	{
		model = new ItemCrazyGlassesModel();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch(type)
		{
		case EQUIPPED: return true;
		default: return false;
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
			Minecraft.getMinecraft().renderEngine.bindTexture("/mods/Nanotech_mod/textures/items/crazyGlasses.png");
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		default:
			break;
		}
	}


}
