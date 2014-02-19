/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechCityList;

public class ItemBlockSunShade extends ItemBlock
{
	private IIcon itemBlockIcon;

	public ItemBlockSunShade(Block block)
	{
		super(block);
	}

	@SideOnly(Side.CLIENT)
	public int getSpriteNumber()
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int metadata)
	{
		return itemBlockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemBlockIcon = iconRegister.registerIcon("nanotechmodcity:sunShade");
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
	{
		if(player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack) && player.canPlayerEdit(x, y + 2, z, side, stack))
		{
			Block i1 = world.getBlock(x, y, z);
			boolean isReplaceable = (i1 == Blocks.vine || i1 == Blocks.tallgrass || i1 == Blocks.deadbush || (i1 != null & i1.isReplaceable(world, x, y, z)));

			if(isReplaceable && world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z))
			{
				world.setBlock(x, y, z, NanotechCityList.sunShade, 0, 3);
				world.setBlock(x, y + 1, z, NanotechCityList.sunShade, 1, 3);
				world.setBlock(x, y + 2, z, NanotechCityList.sunShade, 1, 3);
				world.playSoundEffect(x, y, z, NanotechCityList.sunShade.stepSound.soundName, NanotechCityList.sunShade.stepSound.getVolume(), NanotechCityList.sunShade.stepSound.getPitch());
				--stack.stackSize;
				return true;
			}

			else if(world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 3, z) && side == 1 && player.canPlayerEdit(x, y + 3, z, side, stack))
			{
				world.setBlock(x, y + 1, z, NanotechCityList.sunShade, 0, 3);
				world.setBlock(x, y + 2, z, NanotechCityList.sunShade, 1, 3);
				world.setBlock(x, y + 3, z, NanotechCityList.sunShade, 1, 3);
				world.playSoundEffect(x, y, z, NanotechCityList.sunShade.stepSound.soundName, NanotechCityList.sunShade.stepSound.getVolume(), NanotechCityList.sunShade.stepSound.getPitch());
				--stack.stackSize;
				return true;
			}
		}
		return false;
	}
}