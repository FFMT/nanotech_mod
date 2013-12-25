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
		list.add(getInfo(stack, "SpotLightRed", "Red: "));
	}

	@SideOnly(Side.CLIENT)
	public String getInfo(ItemStack stack, String key, String name)
	{
		if(stack.hasTagCompound())
		{
			if(stack.getTagCompound().hasKey(key))
			{
				return name + String.valueOf(stack.getTagCompound().getInteger(key));
			}
			else
			{
				return "Empty2";
			}
		}
		else
		{
			return "Empty";
		}
	}
}