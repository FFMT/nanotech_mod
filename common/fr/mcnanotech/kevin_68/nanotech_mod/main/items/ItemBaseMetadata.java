package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class ItemBaseMetadata extends Item
{
	public static String[] type = new String[] {"siliconore", "stoneofdecrease", "mysteriousmaterial", "siliconplate", "mysteriousingot", "circuit", "advancedcircuit", "processor", "microprocessor", "camera", "detector", "engine", "nanomite", "nanomiteframe", "smallnanomite", "plug", "portalActivator"};
	private Icon[] iconbuffer;

	public ItemBaseMetadata(int id)
	{
		super(id);
		this.setHasSubtypes(true);
		this.maxStackSize = 64;
		this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
	}

	public void registerIcons(IconRegister iconregister)
	{
		iconbuffer = new Icon[type.length];
		for(int i = 0; i < type.length; i++)
		{
			iconbuffer[i] = iconregister.registerIcon("nanotech_mod:" + type[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int metadata)
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

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(stack.getItemDamage() == 16)
		{
			if(!world.isRemote && world.getBlockId(x, y, z) == NanotechBlock.portalFrame.blockID)
			{
				if(world.getBlockId(x, y, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 1, y, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 2, y + 1, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 2, y + 2, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 2, y + 3, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 1, y + 1, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 1, y + 2, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 1, y + 3, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 1, y + 4, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 4, z) == NanotechBlock.portalFrame.blockID)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechBlock.portal.blockID);
						world.setBlock(x - 1, y + 1 + i, z, NanotechBlock.portal.blockID);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize --;
					}
					return true;
				}

				if(world.getBlockId(x, y, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 1, y, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 2, y + 1, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 2, y + 2, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 2, y + 3, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 1, y + 1, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 1, y + 2, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x - 1, y + 3, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x + 1, y + 4, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 4, z) == NanotechBlock.portalFrame.blockID)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechBlock.portal.blockID);
						world.setBlock(x + 1, y + 1 + i, z, NanotechBlock.portal.blockID);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize --;
					}
					return true;
				}

				if(world.getBlockId(x, y, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y, z - 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 1, z - 2) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 2, z - 2) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 3, z - 2) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 1, z + 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 2, z + 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 3, z + 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 4, z - 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 4, z) == NanotechBlock.portalFrame.blockID)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechBlock.portal.blockID);
						world.setBlock(x, y + 1 + i, z - 1, NanotechBlock.portal.blockID);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize --;
					}
					return true;
				}

				if(world.getBlockId(x, y, z) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y, z + 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 1, z + 2) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 2, z + 2) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 3, z + 2) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 1, z - 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 2, z - 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 3, z - 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 4, z + 1) == NanotechBlock.portalFrame.blockID && world.getBlockId(x, y + 4, z) == NanotechBlock.portalFrame.blockID)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, NanotechBlock.portal.blockID);
						world.setBlock(x, y + 1 + i, z + 1, NanotechBlock.portal.blockID);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize --;
					}
					return true;
				}
			}
		}
		return false;
	}
}