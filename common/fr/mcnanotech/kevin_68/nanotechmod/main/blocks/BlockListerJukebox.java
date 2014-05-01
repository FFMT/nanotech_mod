/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySoundBox;

public class BlockListerJukebox extends BlockContainer
{
	public BlockListerJukebox()
	{
		super(Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntitySoundBox();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking())
		{
			return true;
		}

		if(!world.isRemote)
		{
			player.openGui(NanotechMod.modInstance, 3, world, x, y, z);
		}

		return true;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		Minecraft.getMinecraft().getSoundHandler().stopSounds();
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion)
	{
		this.onBlockDestroyedByPlayer(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
}