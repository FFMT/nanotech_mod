/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.items.ItemCrazyGlassesGunModel;

public class ItemCrazyGlassesGunRender implements IItemRenderer
{
    protected ItemCrazyGlassesGunModel model;
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/items/crazyglassesgun.png");

    public ItemCrazyGlassesGunRender()
    {
        model = new ItemCrazyGlassesGunModel();
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
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        if(helper == ItemRendererHelper.INVENTORY_BLOCK)
        {
            return true;
        }
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
                GL11.glRotatef(75F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-30F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-65F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(110F, 1.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.45F, -0.1F, 0.1F);
                GL11.glScalef(2.0F, 2.0F, 2.0F);
                model.render(0.0625F, item);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(140F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, 0.0F, -0.8F);
                model.render(0.0625F, item);
                GL11.glPopMatrix();
                break;
            }
            case INVENTORY:
            {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                GL11.glTranslatef(0.0F, -0.2F, 0.5F);
                GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(1.7F, 1.7F, 1.7F);
                model.render(0.0625F, item);
                GL11.glPopMatrix();
                break;
            }
            default:
                break;
        }
    }
}