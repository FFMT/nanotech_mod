package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class ItemBaseMetadata extends Item
{
	public static String[] type = new String[]
	{"siliconore", "stoneofdecrease", "mysteriousmaterial", "siliconplate", "mysteriousingot", "circuit", "advancedcircuit", "processor", "microprocessor", "camera", "detector", "engine", "nanomite", "nanomiteframe", "smallnanomite", "void"};
	private Icon[] iconbuffer;

	public ItemBaseMetadata(int id)
	{
		super(id);
		setHasSubtypes(true);
		maxStackSize = 64;
		this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}

	public void registerIcons(IconRegister iconregister)
	{
		iconbuffer = new Icon[type.length];
		for(int i = 0; i < type.length; i++)
		{
			iconbuffer[i] = iconregister.registerIcon("Nanotech_mod:" + type[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		if(damage < type.length)
		{
			return iconbuffer[damage];
		}
		else
		{
			return iconbuffer[0];
		}
	}

	public int getMetadata(int metadata)
	{
		return metadata;
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		if(stack.getItemDamage() < type.length)
		{
			return "item." + type[stack.getItemDamage()];
		}
		else
		{
			return getUnlocalizedName();
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(itemid, 1, metadatanumber));
		}
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(stack.getItemDamage() == 15)
		{
			list.add(StatCollector.translateToLocal("info.void.1"));
			list.add(StatCollector.translateToLocal("info.void.2"));
			list.add(StatCollector.translateToLocal("info.void.3"));
		}
	}

}
