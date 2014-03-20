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

public class ItemBlockLamp extends ItemBlock
{
	private IIcon itemBlockIcon;

	public ItemBlockLamp(Block block)
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

	public void registerIcons(IIconRegister iconRegister)
	{
		itemBlockIcon = iconRegister.registerIcon("nanotechmodcity:lamp");
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
	{
		if(player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack) && player.canPlayerEdit(x, y + 2, z, side, stack) && player.canPlayerEdit(x, y + 3, z, side, stack))
		{
			Block i1 = world.getBlock(x, y, z);
			boolean isReplaceable = (i1 == Blocks.vine || i1 == Blocks.tallgrass || i1 == Blocks.deadbush || (i1 != null & i1.isReplaceable(world, x, y, z)));

			if(isReplaceable && world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 4, z))
			{
				world.setBlock(x, y, z, NanotechCityBlock.lamp, 0, 3);
				world.setBlock(x, y + 1, z, NanotechCityBlock.lamp, 1, 3);
				world.setBlock(x, y + 2, z, NanotechCityBlock.lamp, 1, 3);
				world.setBlock(x, y + 3, z, NanotechCityBlock.lamp, 2, 3);
				
				if(world.isAirBlock(x + 1, y, z))
					world.setBlock(x + 1, y, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x - 1, y, z))
					world.setBlock(x - 1, y, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 1, z))
					world.setBlock(x, y, z + 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y, z - 1))
					world.setBlock(x, y, z - 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x + 1, y + 1, z))
					world.setBlock(x + 1, y + 1, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x - 1, y + 1, z))
					world.setBlock(x - 1, y + 1, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 1, z))
					world.setBlock(x, y + 1, z + 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 1, z - 1))
					world.setBlock(x, y + 1, z - 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x + 1, y + 2, z))
					world.setBlock(x + 1, y + 2, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x - 1, y + 2, z))
					world.setBlock(x - 1, y + 2, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 2, z))
					world.setBlock(x, y + 2, z + 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 2, z - 1))
					world.setBlock(x, y + 2, z - 1, NanotechCityBlock.lightAir);

				
				world.playSoundEffect(x, y, z, NanotechCityBlock.lamp.stepSound.soundName, NanotechCityBlock.lamp.stepSound.getVolume(), NanotechCityBlock.lamp.stepSound.getPitch());
				--stack.stackSize;
				return true;

			}
			if(world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 3, z) && world.isAirBlock(x, y + 4, z) && side == 1 && player.canPlayerEdit(x, y + 4, z, side, stack))
			{
				world.setBlock(x, y + 1, z, NanotechCityBlock.lamp, 0, 3);
				world.setBlock(x, y + 2, z, NanotechCityBlock.lamp, 1, 3);
				world.setBlock(x, y + 3, z, NanotechCityBlock.lamp, 1, 3);
				world.setBlock(x, y + 4, z, NanotechCityBlock.lamp, 2, 3);
				
				if(world.isAirBlock(x + 1, y + 1, z))
					world.setBlock(x + 1, y + 1, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x - 1, y + 1, z))
					world.setBlock(x - 1, y + 1, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 1, z))
					world.setBlock(x, y + 1, z + 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 1, z - 1))
					world.setBlock(x, y + 1, z - 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x + 1, y + 2, z))
					world.setBlock(x + 1, y + 2, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x - 1, y + 2, z))
					world.setBlock(x - 1, y + 2, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 2, z))
					world.setBlock(x, y + 2, z + 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 2, z - 1))
					world.setBlock(x, y + 2, z - 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x + 1, y + 3, z))
					world.setBlock(x + 1, y + 3, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x - 1, y + 3, z))
					world.setBlock(x - 1, y + 3, z, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 3, z))
					world.setBlock(x, y + 3, z + 1, NanotechCityBlock.lightAir);
				if(world.isAirBlock(x, y + 3, z - 1))
					world.setBlock(x, y + 3, z - 1, NanotechCityBlock.lightAir);


				world.playSoundEffect(x, y, z, NanotechCityBlock.lamp.stepSound.soundName, NanotechCityBlock.lamp.stepSound.getVolume(), NanotechCityBlock.lamp.stepSound.getPitch());
				--stack.stackSize;
				return true;
			}
		}
		return false;
	}
}