package fr.mcnanotech.kevin_68.nanotech_mod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class BlockNanotechOre extends Block
{
	public static String[] type = new String[] { "silicon", "decrease" };

	public BlockNanotechOre(int id, int texture)
	{
		super(id, texture, Material.rock);
		setCreativeTab(Nanotech_mod.CREATIVE_TAB_B);
		setRequiresSelfNotify();
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for (int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}

	public int damageDropped(int metadata)
	{
		return metadata;
	}

	public int getBlockTextureFromSideAndMetadata(int side, int damage)
	{
		return blockIndexInTexture + damage;
	}

	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png";
	}

}
