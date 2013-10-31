package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.NewExplosion;

public class BlockNuke extends Block
{

	public BlockNuke(int id)
	{
		super(id, Material.tnt);
	}


	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid)
	{
		if(!world.isRemote)
		{
			NewExplosion explosion = new NewExplosion(world, null, x, y, z, 50.0F, 0.0F);
			explosion.doExplosion();
			world.newExplosion(null, x, y, z, 15, true, true);
			
		}
	}
}
