package fr.mcnanotech.kevin_68.nanotech_mod.city.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemConfigCopy extends Item
{
	public ItemConfigCopy(int par1)
	{
		super(par1);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(getInfo(stack, "SpotLightRed", "Red: ", 0) + getInfo(stack, "SpotLightGreen", "  Green: ", 0) + getInfo(stack, "SpotLightBlue", "  Blue: ", 0));
		list.add(getInfo(stack, "SpotLightDarkRed", "DarkRed: ", 0) + getInfo(stack, "SpotLightDarkGreen", "  DarkGreen: ", 0) + getInfo(stack, "SpotLightDarkBlue", "  DarkBlue: ", 0));
		list.add(getInfo(stack, "SpotLightAngle1", "Angle1: ", 0) + getInfo(stack, "SpotLightAngle2", "  Angle2: ", 0));
		list.add(getInfo(stack, "SpotLightAutoRotate", "Rotate: ", 1) + getInfo(stack, "SpotLightRotationSpeed", "  Speed: ", 0) + getInfo(stack, "SpotLightReverseRotation", "  Reverse rotation: ", 1));
		list.add(getInfo(stack, "SpotLightSecondaryLazer", "Secondary lazer: ", 1));
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
					return name + (stack.getTagCompound().getInteger(key) == 1 ? "False" : "True");
				}
				else
				{
					return "Empty ";
				}
			}
			else
			{
				return "Empty ";
			}
		}
		else
		{
			return "Empty ";
		}
	}
}