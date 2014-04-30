/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import fr.minecraftforgefrance.ffmtlibs.block.FFMTBlockSittable;

public class BlockNanoStairs extends BlockStairs
{

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		return FFMTBlockSittable.onBlockActivated(world, x, y, z, player, 0.5F, 2.0F, 0.5F, 0, 0, 0, 0);
	}

	protected BlockNanoStairs(Block block, int meta)
	{
		super(block, meta);
		this.setLightOpacity(0);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int par3)
	{
		if(this.equals(NanotechBlock.nukeBuildingStairs))
		{
			return Items.iron_ingot;
		}
		else
		{
			return Item.getItemFromBlock(this);
		}
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}

}