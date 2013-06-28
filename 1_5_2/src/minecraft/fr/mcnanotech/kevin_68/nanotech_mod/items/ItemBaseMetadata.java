package fr.mcnanotech.kevin_68.nanotech_mod.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class ItemBaseMetadata extends Item
{
	public static String[] type = new String[] { "Siliconore", "Stoneofdecrease", "Mysteriousmaterial", "Siliconplate", "Mysteriousingot", "Circuit", "Advencedcircuit", "Processor", "Microprocessor", "Camera", "Detector", "Engine", "Nanomite", "Nanomiteframe", "Smallnanomite", "Vide" };

	public ItemBaseMetadata(int id)
	{
		super(id);
		setHasSubtypes(true);
		maxStackSize = 64;
		this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}

	public int getMetadata(int metadata)
	{
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int damage)
	{
		if (damage < 5 || damage > 11 && damage < 15)
			return damage;
		else if (damage > 4 && damage < 8)
			return damage + 4;
		else if (damage == 8)
			return 20;
		else if (damage == 9)
			return 21;
		else if (damage == 10)
			return 25;
		else if (damage == 11)
			return 26;
		else if (damage == 15)
			return 80;
		else
			return 0;
	}

	public String getItemNameIS(ItemStack stack)
	{
		if (stack.getItemDamage() < type.length)
		{
			return "item." + type[stack.getItemDamage()];
		}
		else
		{
			return getItemName();
		}
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemid, CreativeTabs creativeTabs, List list)
	{
		for (int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(itemid, 1, metadatanumber));
		}
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (stack.getItemDamage() == 15)
		{
			list.add(StatCollector.translateToLocal("info.void.1"));
			list.add(StatCollector.translateToLocal("info.void.2"));
			list.add(StatCollector.translateToLocal("info.void.3"));
		}
	}

}
