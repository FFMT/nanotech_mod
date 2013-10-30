package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockModernFence extends ItemBlock
{
	public ItemBlockModernFence(int id)
	{
		super(id);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("nanotech_mod_city:modernFence");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
	{
		return itemIcon;
	}
}