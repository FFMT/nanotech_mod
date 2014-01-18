package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockSunShade extends ItemBlock
{
	private Icon itemBlockIcon;

	public ItemBlockSunShade(int id)
	{
		super(id);
	}

	@SideOnly(Side.CLIENT)
	public int getSpriteNumber()
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int metadata)
	{
		return itemBlockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemBlockIcon = iconRegister.registerIcon("nanotech_mod_city:sunShade");
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
	{
		if(player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack) && player.canPlayerEdit(x, y + 2, z, side, stack))
		{
			int i1 = world.getBlockId(x, y, z);
			boolean isReplaceable = (i1 == Block.vine.blockID || i1 == Block.tallGrass.blockID || i1 == Block.deadBush.blockID || (Block.blocksList[i1] != null & Block.blocksList[i1].isBlockReplaceable(world, x, y, z)));

			if(isReplaceable && world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z))
			{
				world.setBlock(x, y, z, NanotechCityBlock.sunShade.blockID, 0, 3);
				world.setBlock(x, y + 1, z, NanotechCityBlock.sunShade.blockID, 1, 3);
				world.setBlock(x, y + 2, z, NanotechCityBlock.sunShade.blockID, 1, 3);
				world.playSoundEffect(x, y, z, NanotechCityBlock.sunShade.stepSound.getPlaceSound(), NanotechCityBlock.sunShade.stepSound.getVolume(), NanotechCityBlock.sunShade.stepSound.getPitch());
				--stack.stackSize;
				return true;
			}

			else if(world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 3, z) && side == 1 && player.canPlayerEdit(x, y + 3, z, side, stack))
			{
				world.setBlock(x, y + 1, z, NanotechCityBlock.sunShade.blockID, 0, 3);
				world.setBlock(x, y + 2, z, NanotechCityBlock.sunShade.blockID, 1, 3);
				world.setBlock(x, y + 3, z, NanotechCityBlock.sunShade.blockID, 1, 3);
				world.playSoundEffect(x, y, z, NanotechCityBlock.sunShade.stepSound.getPlaceSound(), NanotechCityBlock.sunShade.stepSound.getVolume(), NanotechCityBlock.sunShade.stepSound.getPitch());
				--stack.stackSize;
				return true;
			}
		}
		return false;
	}
}