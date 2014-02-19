/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemConfigCopy extends Item
{
	public ItemConfigCopy()
	{
		super();
	}
	
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotechmodcity:configcopier");
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey("Type"))
			{
				if(stack.getTagCompound().getInteger("Type") == 0)
				{
					list.add(EnumChatFormatting.AQUA + I18n.format("tile.spotlight.name"));
					list.add(getInfo(stack, "SpotLightRed", I18n.format("container.spotlight.red") + ": ", 0) + getInfo(stack, "SpotLightGreen", "  " + I18n.format("container.spotlight.green") + ": ", 0) + getInfo(stack, "SpotLightBlue", "  " + I18n.format("container.spotlight.blue") + ": ", 0));
					list.add(getInfo(stack, "SpotLightDarkRed", I18n.format("container.spotlight.darkred") + ": ", 0) + getInfo(stack, "SpotLightDarkGreen", "  " + I18n.format("container.spotlight.darkgreen") + ": ", 0) + getInfo(stack, "SpotLightDarkBlue", "  " + I18n.format("container.spotlight.darkblue") + ": ", 0));
					list.add(getInfo(stack, "SpotLightAngle1", I18n.format("container.spotlight.angle") + " 1: ", 0) + getInfo(stack, "SpotLightAngle2", "  " + I18n.format("container.spotlight.angle") + " 2: ", 0) + getInfo(stack, "SpotLightReverseRotation", "  " + I18n.format("container.spotlight.rotationreverse") + ": ", 1));
					list.add(getInfo(stack, "SpotLightAutoRotate", I18n.format("container.spotlight.rotate") + ": ", 1) + getInfo(stack, "SpotLightRotationSpeed", "  " + I18n.format("container.spotlight.rotationspeed") + ": ", 0));
					list.add(getInfo(stack, "SpotLightSecondaryLazer", I18n.format("container.spotlight.secondlazer") + ": ", 1));
				}
				else if(stack.getTagCompound().getInteger("Type") == 1)
				{
					list.add(EnumChatFormatting.AQUA + I18n.format("tile.textspotlight.name"));
					list.add(getInfo(stack, "TextSpotLightText", I18n.format("container.configcopier.text") + ": ", 2));
					list.add(getInfo(stack, "TextSpotLightRed", I18n.format("container.spotlight.red") + ": ", 0) + getInfo(stack, "TextSpotLightGreen", "  " + I18n.format("container.spotlight.green") + ": ", 0) + getInfo(stack, "TextSpotLightBlue", "  " + I18n.format("container.spotlight.blue") + ": ", 0));
					list.add(getInfo(stack, "TextSpotLightAngle", I18n.format("container.spotlight.angle") + ": ", 0) + getInfo(stack, "TextSpotLightReverseRotation", "  " + I18n.format("container.spotlight.rotationreverse") + ": ", 1));
					list.add(getInfo(stack, "TextSpotLightAutoRotate", I18n.format("container.spotlight.rotate") + ": ", 1) + getInfo(stack, "TextSpotLightRotationSpeed", "  " + I18n.format("container.spotlight.rotationspeed") + ": ", 0));
					list.add(getInfo(stack, "TextSpotLightScale", I18n.format("container.textspotlight.scale") + ": ", 0) + getInfo(stack, "TextSpotLightHeight", "  " + I18n.format("container.textspotlight.height") + ": ", 0));
				}
				else
				{
					list.add(EnumChatFormatting.AQUA + I18n.format("container.configcopier.empty"));
				}
			}
			else
			{
				list.add(EnumChatFormatting.AQUA + I18n.format("container.configcopier.empty"));
			}
		}
		else
		{
			list.add(EnumChatFormatting.AQUA + I18n.format("container.configcopier.empty"));
		}
	}

	@SideOnly(Side.CLIENT)
	public String getInfo(ItemStack stack, String key, String name, int i)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey(key))
			{
				if(i == 0)
				{
					return name + String.valueOf(stack.getTagCompound().getInteger(key));
				}
				else if(i == 1)
				{
					return name + (stack.getTagCompound().getInteger(key) == 1 ? I18n.format("container.spotlight.false") : I18n.format("container.spotlight.true"));
				}
				else if(i == 2)
				{
					return name + (stack.getTagCompound().getString(key));
				}
				else
				{
					return "";
				}
			}
			else
			{
				return "";
			}
		}
		else
		{
			return "";
		}
	}
}