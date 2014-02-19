/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.item.ItemRecord;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDisk extends ItemRecord
{
	public final String recordName;
	public final String recordinfo;

	public ItemDisk(String name, String info)
	{
		super(name);
		recordName = name;
		maxStackSize = 1;
		recordinfo = info;
	}

	@SideOnly(Side.CLIENT)
	public String getRecordTitle()
	{
		return this.recordinfo;
	}
}
