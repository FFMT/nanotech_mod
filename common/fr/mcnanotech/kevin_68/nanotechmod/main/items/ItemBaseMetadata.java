/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechModList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class ItemBaseMetadata extends Item
{
	public static String[] type = new String[] {"siliconore", "stoneofdecrease", "mysteriousmaterial", "siliconplate", "mysteriousingot", "circuit", "advancedcircuit", "processor", "microprocessor", "camera", "detector", "engine", "nanomite", "nanomiteframe", "smallnanomite", "plug", "portalActivator", "fish_veryveryfrozen", "fish_veryfrozen", "fish_frozen", "cageCrazyGlasses", "presentPaper"};
	private IIcon[] iconbuffer;

	public ItemBaseMetadata()
	{
		super();
		this.setHasSubtypes(true);
		this.maxStackSize = 64;
		this.setCreativeTab(NanotechMod.CreaI);
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		iconbuffer = new IIcon[type.length];
		for(int i = 0; i < type.length; i++)
		{
			iconbuffer[i] = iconregister.registerIcon(this.getIconString() + type[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		if(metadata < type.length)
		{
			return iconbuffer[metadata];
		}
		else
		{
			return iconbuffer[0];
		}
	}

	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

	@Override
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
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(item, 1, metadatanumber));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(stack.getItemDamage() == 15)
		{
			list.add(StatCollector.translateToLocal("info.void.1"));
			list.add(StatCollector.translateToLocal("info.void.2"));
			list.add(StatCollector.translateToLocal("info.void.3"));
		}
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(stack.getItemDamage() == 16)
		{
			if(!world.isRemote && world.getBlock(x, y, z).equals(NanotechModList.portalFrame))
			{
				if(world.getBlock(x, y, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 1, y, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 2, y + 1, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 2, y + 2, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 2, y + 3, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 1, y + 1, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 1, y + 2, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 1, y + 3, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 1, y + 4, z).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 4, z).equals(NanotechModList.portalFrame))
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechModList.portal);
						world.setBlock(x - 1, y + 1 + i, z, NanotechModList.portal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}

				if(world.getBlock(x, y, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 1, y, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 2, y + 1, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 2, y + 2, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 2, y + 3, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 1, y + 1, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 1, y + 2, z).equals(NanotechModList.portalFrame) && world.getBlock(x - 1, y + 3, z).equals(NanotechModList.portalFrame) && world.getBlock(x + 1, y + 4, z).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 4, z).equals(NanotechModList.portalFrame))
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechModList.portal);
						world.setBlock(x + 1, y + 1 + i, z, NanotechModList.portal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}

				if(world.getBlock(x, y, z).equals(NanotechModList.portalFrame) && world.getBlock(x, y, z - 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 1, z - 2).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 2, z - 2).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 3, z - 2).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 1, z + 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 2, z + 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 3, z + 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 4, z - 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 4, z).equals(NanotechModList.portalFrame))
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechModList.portal);
						world.setBlock(x, y + 1 + i, z - 1, NanotechModList.portal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}

				if(world.getBlock(x, y, z).equals(NanotechModList.portalFrame) && world.getBlock(x, y, z + 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 1, z + 2).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 2, z + 2).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 3, z + 2).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 1, z - 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 2, z - 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 3, z - 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 4, z + 1).equals(NanotechModList.portalFrame) && world.getBlock(x, y + 4, z).equals(NanotechModList.portalFrame))
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechModList.portal);
						world.setBlock(x, y + 1 + i, z + 1, NanotechModList.portal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}
			}
		}
		return false;
	}
}