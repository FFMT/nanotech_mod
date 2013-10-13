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

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotech_mod:" + textureName);
	}

	@SideOnly(Side.CLIENT)
	public String getRecordTitle()
	{
		return this.recordinfo;
	}
}
