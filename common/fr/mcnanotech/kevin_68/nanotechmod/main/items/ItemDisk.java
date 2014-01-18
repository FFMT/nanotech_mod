package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemRecord;
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
		this.itemIcon = iconregister.registerIcon("nanotechmod:" + textureName);
	}

	@SideOnly(Side.CLIENT)
	public String getRecordTitle()
	{
		return this.recordinfo;
	}
}
