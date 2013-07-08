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

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID && par3World.getBlockMetadata(par4, par5, par6) == 0)
		{
			if (par3World.isRemote)
			{
				return true;
			}
			else
			{
				((BlockJukeBox) Block.jukebox).insertRecord(par3World, par4, par5, par6, par1ItemStack);
				par3World.playAuxSFXAtEntity((EntityPlayer) null, 1005, par4, par5, par6, this.itemID);
				--par1ItemStack.stackSize;
				return true;
			}
		}
		else
		{
			return false;
		}
	}
	
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("Nanotech_mod:" + textureName);
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
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.rare;
	}

}
