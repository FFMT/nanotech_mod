package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDisk extends ItemRecord
{
	public final String recordName;
	public final String recordinfo;
	public final String textureName;

	public ItemDisk(int id, String name, String info, String texture)
	{
		super(id, name);
		recordName = name;
		maxStackSize = 1;
		recordinfo = info;
		textureName = texture;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if(world.getBlockId(x, y, z) == Block.jukebox.blockID && world.getBlockMetadata(x, y, z) == 0)
		{
			if(world.isRemote)
			{
				return true;
			}
			else
			{
				((BlockJukeBox)Block.jukebox).insertRecord(world, x, y, z, stack);
				world.playAuxSFXAtEntity((EntityPlayer)null, 1005, x, y, z, this.itemID);
				--stack.stackSize;
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("Nanotech_mod:" + textureName);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(recordinfo);
	}

	@SideOnly(Side.CLIENT)
	public String getRecordTitle()
	{
		return this.recordinfo;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}

}
