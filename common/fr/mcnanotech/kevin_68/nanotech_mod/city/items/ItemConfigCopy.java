package fr.mcnanotech.kevin_68.nanotech_mod.city.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemConfigCopy extends Item
{
	public ItemConfigCopy(int par1)
	{
		super(par1);
	}
	
	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotech_mod_city:configcopier");
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey("Type"))
			{
				if(stack.getTagCompound().getInteger("Type") == 0)
				{
					list.add(EnumChatFormatting.AQUA + I18n.getString("tile.spotlight.name"));
					list.add(getInfo(stack, "SpotLightRed", I18n.getString("container.spotlight.red") + ": ", 0) + getInfo(stack, "SpotLightGreen", "  " + I18n.getString("container.spotlight.green") + ": ", 0) + getInfo(stack, "SpotLightBlue", "  " + I18n.getString("container.spotlight.blue") + ": ", 0));
					list.add(getInfo(stack, "SpotLightDarkRed", I18n.getString("container.spotlight.darkred") + ": ", 0) + getInfo(stack, "SpotLightDarkGreen", "  " + I18n.getString("container.spotlight.darkgreen") + ": ", 0) + getInfo(stack, "SpotLightDarkBlue", "  " + I18n.getString("container.spotlight.darkblue") + ": ", 0));
					list.add(getInfo(stack, "SpotLightAngle1", I18n.getString("container.spotlight.angle") + " 1: ", 0) + getInfo(stack, "SpotLightAngle2", "  " + I18n.getString("container.spotlight.angle") + " 2: ", 0) + getInfo(stack, "SpotLightReverseRotation", "  " + I18n.getString("container.spotlight.rotationreverse") + ": ", 1));
					list.add(getInfo(stack, "SpotLightAutoRotate", I18n.getString("container.spotlight.rotate") + ": ", 1) + getInfo(stack, "SpotLightRotationSpeed", "  " + I18n.getString("container.spotlight.rotationspeed") + ": ", 0));
					list.add(getInfo(stack, "SpotLightSecondaryLazer", I18n.getString("container.spotlight.secondlazer") + ": ", 1));
				}
				else if(stack.getTagCompound().getInteger("Type") == 1)
				{
					list.add(EnumChatFormatting.AQUA + I18n.getString("tile.textspotlight.name"));
					list.add(getInfo(stack, "TextSpotLightText", I18n.getString("container.configcopier.text") + ": ", 2));
					list.add(getInfo(stack, "TextSpotLightRed", I18n.getString("container.spotlight.red") + ": ", 0) + getInfo(stack, "TextSpotLightGreen", "  " + I18n.getString("container.spotlight.green") + ": ", 0) + getInfo(stack, "TextSpotLightBlue", "  " + I18n.getString("container.spotlight.blue") + ": ", 0));
					list.add(getInfo(stack, "TextSpotLightAngle", I18n.getString("container.spotlight.angle") + ": ", 0) + getInfo(stack, "TextSpotLightReverseRotation", "  " + I18n.getString("container.spotlight.rotationreverse") + ": ", 1));
					list.add(getInfo(stack, "TextSpotLightAutoRotate", I18n.getString("container.spotlight.rotate") + ": ", 1) + getInfo(stack, "TextSpotLightRotationSpeed", "  " + I18n.getString("container.spotlight.rotationspeed") + ": ", 0));
					list.add(getInfo(stack, "TextSpotLightScale", I18n.getString("container.textspotlight.scale") + ": ", 0) + getInfo(stack, "TextSpotLightHeight", "  " + I18n.getString("container.textspotlight.height") + ": ", 0));
				}
				else
				{
					list.add(EnumChatFormatting.AQUA + I18n.getString("container.configcopier.empty"));
				}
			}
			else
			{
				list.add(EnumChatFormatting.AQUA + I18n.getString("container.configcopier.empty"));
			}
		}
		else
		{
			list.add(EnumChatFormatting.AQUA + I18n.getString("container.configcopier.empty"));
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
					return name + (stack.getTagCompound().getInteger(key) == 1 ? I18n.getString("container.spotlight.false") : I18n.getString("container.spotlight.true"));
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