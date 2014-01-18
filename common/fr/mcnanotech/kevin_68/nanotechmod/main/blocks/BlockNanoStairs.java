package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.Item;

public class BlockNanoStairs extends BlockStairs
{
	protected BlockNanoStairs(int id, Block block, int meta)
	{
		super(id, block, meta);
		this.setLightOpacity(0);
	}

	public int idDropped(int metadata, Random rand, int par3)
	{
		if(this.blockID == NanotechBlock.nukeBuildingStairs.blockID)
		{
			return Item.ingotIron.itemID;
		}
		else
		{
			return this.blockID;
		}
	}

	public int quantityDropped(Random rand)
	{
		return 1;
	}

}