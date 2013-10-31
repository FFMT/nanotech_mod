package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockNanoStairs extends BlockStairs
{
	protected BlockNanoStairs(int id, Block block, int meta)
	{
		super(id, block, meta);
		this.setLightOpacity(0);
	}

	public int quantityDropped(Random rand)
	{
		if(this.blockID == NanotechBlock.nukeBuildingStairs.blockID)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}

}