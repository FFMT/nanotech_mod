/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.NanotechModCity;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrail;
import fr.mcnanotech.kevin_68.nanotechmod.city.utils.CTHelper;

public class BlockTrail extends Block
{
	private IIcon[] iconBuffer;

	public BlockTrail()
	{
		super(Material.ground);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisalignedBB, List list, Entity entity)
	{
		float f = 0.0625F;
		boolean[] flag = CTHelper.get(world, x, y, z, NanotechCityBlock.trail);

		if((flag[CTHelper.VrN] || flag[CTHelper.SrN] || flag[CTHelper.tErN] || flag[CTHelper.tWrN] || flag[CTHelper.tEWrN] || flag[CTHelper.tSEWrN] || flag[CTHelper.tNSEWrN]) && !flag[CTHelper.SEWrN])
		{
			this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - f, 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (2 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (3 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (4 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (5 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (6 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (7 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if((flag[CTHelper.VrS] || flag[CTHelper.NrS] || flag[CTHelper.tErS] || flag[CTHelper.tWrS] || flag[CTHelper.tEWrS] || flag[CTHelper.tNEWrS] || flag[CTHelper.tNSEWrS]) && !flag[CTHelper.NEWrS])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, f, 1.0F, 1.0F - f, (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (2 * f), 1.0F, 1.0F - (2 * f), (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (3 * f), 1.0F, 1.0F - (3 * f), (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (4 * f), 1.0F, 1.0F - (4 * f), (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (5 * f), 1.0F, 1.0F - (5 * f), (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (6 * f), 1.0F, 1.0F - (6 * f), (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (7 * f), 1.0F, 1.0F - (7 * f), (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (8 * f), 1.0F, 1.0F - (8 * f), (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (9 * f), 1.0F, 1.0F - (9 * f), (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (10 * f), 1.0F, 1.0F - (10 * f), (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (11 * f), 1.0F, 1.0F - (11 * f), (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (12 * f), 1.0F, 1.0F - (12 * f), (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (13 * f), 1.0F, 1.0F - (13 * f), (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (14 * f), 1.0F, 1.0F - (14 * f), (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (15 * f), 1.0F, 1.0F - (15 * f), (16 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if((flag[CTHelper.VrE] || flag[CTHelper.WrE] || flag[CTHelper.tNrE] || flag[CTHelper.tSrE] || flag[CTHelper.tNSrE] || flag[CTHelper.tNSWrE] || flag[CTHelper.tNSEWrE]) && !flag[CTHelper.NSWrE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if((flag[CTHelper.VrW] || flag[CTHelper.ErW] || flag[CTHelper.tNrW] || flag[CTHelper.tSrW] || flag[CTHelper.tNSrW] || flag[CTHelper.tNSErW] || flag[CTHelper.tNSEWrW]) && !flag[CTHelper.NSErW])
		{
			this.setBlockBounds(1.0F, 0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F - (2 * f), 1.0F - f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 2), 0.0F, 0.0F, 1.0F - (3 * f), 1.0F - (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 3), 0.0F, 0.0F, 1.0F - (4 * f), 1.0F - (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 4), 0.0F, 0.0F, 1.0F - (5 * f), 1.0F - (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 5), 0.0F, 0.0F, 1.0F - (6 * f), 1.0F - (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 6), 0.0F, 0.0F, 1.0F - (7 * f), 1.0F - (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 7), 0.0F, 0.0F, 1.0F - (8 * f), 1.0F - (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 8), 0.0F, 0.0F, 1.0F - (9 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 9), 0.0F, 0.0F, 1.0F - (10 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 10), 0.0F, 0.0F, 1.0F - (11 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 11), 0.0F, 0.0F, 1.0F - (12 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 12), 0.0F, 0.0F, 1.0F - (13 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 13), 0.0F, 0.0F, 1.0F - (14 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 14), 0.0F, 0.0F, 1.0F - (15 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 15), 0.0F, 0.0F, 1.0F - (16 * f), 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNS] || flag[CTHelper.EWrNS])
		{
			this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - (14 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (13 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (12 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (11 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (10 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (9 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrEW] || flag[CTHelper.NSrEW])
		{
			this.setBlockBounds(1.0F, 0.0F, 0.0F, 1.0F - f, 1.0F - (f * 15), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F - (2 * f), 1.0F - (f * 14), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 2), 0.0F, 0.0F, 1.0F - (3 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 3), 0.0F, 0.0F, 1.0F - (4 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 4), 0.0F, 0.0F, 1.0F - (5 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 5), 0.0F, 0.0F, 1.0F - (6 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 6), 0.0F, 0.0F, 1.0F - (7 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 7), 0.0F, 0.0F, 1.0F - (8 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 8), 0.0F, 0.0F, 1.0F - (9 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 9), 0.0F, 0.0F, 1.0F - (10 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 10), 0.0F, 0.0F, 1.0F - (11 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 11), 0.0F, 0.0F, 1.0F - (12 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 12), 0.0F, 0.0F, 1.0F - (13 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 13), 0.0F, 0.0F, 1.0F - (14 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 14), 0.0F, 0.0F, 1.0F - (15 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (f * 15), 0.0F, 0.0F, 1.0F - (16 * f), 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNE] || flag[CTHelper.tSrNE] || flag[CTHelper.tWrNE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, f, f, 1.0F - f, (f * 2), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 2), (f * 2), 1.0F - (f * 2), (f * 3), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 3), (f * 3), 1.0F - (f * 3), (f * 4), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 4), (f * 4), 1.0F - (f * 4), (f * 5), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 5), (f * 5), 1.0F - (f * 5), (f * 6), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 6), (f * 6), 1.0F - (f * 6), (f * 7), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 7), (f * 7), 1.0F - (f * 7), (f * 8), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 8), (f * 8), 1.0F - (f * 8), (f * 9), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 9), (f * 9), 1.0F - (f * 9), (f * 10), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 10), (f * 10), 1.0F - (f * 10), (f * 11), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 11), (f * 11), 1.0F - (f * 11), (f * 12), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 12), (f * 12), 1.0F - (f * 12), (f * 13), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 13), (f * 13), 1.0F - (f * 13), (f * 14), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 14), (f * 14), 1.0F - (f * 14), (f * 15), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 15), (f * 15), 1.0F - (f * 15), (f * 16), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNW] || flag[CTHelper.tSrNW] || flag[CTHelper.tErNW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, f, 1.0F, (f * 2), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), (f * 2), (f * 2), 1.0F, (f * 3), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), (f * 3), (f * 3), 1.0F, (f * 4), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), (f * 4), (f * 4), 1.0F, (f * 5), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), (f * 5), (f * 5), 1.0F, (f * 6), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), (f * 6), (f * 6), 1.0F, (f * 7), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), (f * 7), (f * 7), 1.0F, (f * 8), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), (f * 8), (f * 8), 1.0F, (f * 9), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), (f * 9), (f * 9), 1.0F, (f * 10), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), (f * 10), (f * 10), 1.0F, (f * 11), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), (f * 11), (f * 11), 1.0F, (f * 12), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), (f * 12), (f * 12), 1.0F, (f * 13), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), (f * 13), (f * 13), 1.0F, (f * 14), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), (f * 14), (f * 14), 1.0F, (f * 15), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), (f * 15), (f * 15), 1.0F, (f * 16), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrSE] || flag[CTHelper.tNrSE] || flag[CTHelper.tWrSE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, f, 0.0F, 1.0F - f, (f * 2), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 2), 0.0F, 1.0F - (f * 2), (f * 3), 1.0F - (f * 2));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 3), 0.0F, 1.0F - (f * 3), (f * 4), 1.0F - (f * 3));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 4), 0.0F, 1.0F - (f * 4), (f * 5), 1.0F - (f * 4));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 5), 0.0F, 1.0F - (f * 5), (f * 6), 1.0F - (f * 5));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 6), 0.0F, 1.0F - (f * 6), (f * 7), 1.0F - (f * 6));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 7), 0.0F, 1.0F - (f * 7), (f * 8), 1.0F - (f * 7));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 8), 0.0F, 1.0F - (f * 8), (f * 9), 1.0F - (f * 8));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 9), 0.0F, 1.0F - (f * 9), (f * 10), 1.0F - (f * 9));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 10), 0.0F, 1.0F - (f * 10), (f * 11), 1.0F - (f * 10));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 11), 0.0F, 1.0F - (f * 11), (f * 12), 1.0F - (f * 11));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 12), 0.0F, 1.0F - (f * 12), (f * 13), 1.0F - (f * 12));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 13), 0.0F, 1.0F - (f * 13), (f * 14), 1.0F - (f * 13));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 14), 0.0F, 1.0F - (f * 14), (f * 15), 1.0F - (f * 14));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (f * 15), 0.0F, 1.0F - (f * 15), (f * 16), 1.0F - (f * 15));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrSW] || flag[CTHelper.tNrSW] || flag[CTHelper.tErSW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 0.0F, 1.0F, (f * 2), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), (f * 2), 0.0F, 1.0F, (f * 3), 1.0F - (f * 2));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), (f * 3), 0.0F, 1.0F, (f * 4), 1.0F - (f * 3));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), (f * 4), 0.0F, 1.0F, (f * 5), 1.0F - (f * 4));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), (f * 5), 0.0F, 1.0F, (f * 6), 1.0F - (f * 5));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), (f * 6), 0.0F, 1.0F, (f * 7), 1.0F - (f * 6));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), (f * 7), 0.0F, 1.0F, (f * 8), 1.0F - (f * 7));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), (f * 8), 0.0F, 1.0F, (f * 9), 1.0F - (f * 8));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), (f * 9), 0.0F, 1.0F, (f * 10), 1.0F - (f * 9));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), (f * 10), 0.0F, 1.0F, (f * 11), 1.0F - (f * 10));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), (f * 11), 0.0F, 1.0F, (f * 12), 1.0F - (f * 11));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), (f * 12), 0.0F, 1.0F, (f * 13), 1.0F - (f * 12));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), (f * 13), 0.0F, 1.0F, (f * 14), 1.0F - (f * 13));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), (f * 14), 0.0F, 1.0F, (f * 15), 1.0F - (f * 14));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), (f * 15), 0.0F, 1.0F, (f * 16), 1.0F - (f * 15));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNSE] || flag[CTHelper.WrNSE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, f, f, 1.0F - f, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (2 * f), (2 * f), 1.0F - (2 * f), (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (3 * f), (3 * f), 1.0F - (3 * f), (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (4 * f), (4 * f), 1.0F - (4 * f), (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (5 * f), (5 * f), 1.0F - (5 * f), (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (6 * f), (6 * f), 1.0F - (6 * f), (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, (7 * f), (7 * f), 1.0F - (7 * f), (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNSW] || flag[CTHelper.ErNSW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, f, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNEW] || flag[CTHelper.SrNEW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, f, 1.0F - f, (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), (2 * f), 1.0F - (2 * f), (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), (3 * f), 1.0F - (3 * f), (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), (4 * f), 1.0F - (4 * f), (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), (5 * f), 1.0F - (5 * f), (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), (6 * f), 1.0F - (6 * f), (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), (7 * f), 1.0F - (7 * f), (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrSEW] || flag[CTHelper.NrSEW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 0.0F, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 0.0F, 1.0F - (2 * f), (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 0.0F, 1.0F - (3 * f), (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 0.0F, 1.0F - (4 * f), (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 0.0F, 1.0F - (5 * f), (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 0.0F, 1.0F - (6 * f), (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 0.0F, 1.0F - (7 * f), (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.VrNSEW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, f, 1.0F - f, (f * 2), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), (f * 2), (f * 2), 1.0F - (f * 2), (f * 3), 1.0F - (f * 2));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), (f * 3), (f * 3), 1.0F - (f * 3), (f * 4), 1.0F - (f * 3));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), (f * 4), (f * 4), 1.0F - (f * 4), (f * 5), 1.0F - (f * 4));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), (f * 5), (f * 5), 1.0F - (f * 5), (f * 6), 1.0F - (f * 5));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), (f * 6), (f * 6), 1.0F - (f * 6), (f * 7), 1.0F - (f * 6));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), (f * 7), (f * 7), 1.0F - (f * 7), (f * 8), 1.0F - (f * 7));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}

		else if(flag[CTHelper.tNErne])
		{
			this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - f, 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (2 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (3 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (4 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (5 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (6 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (7 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.tNWrnw])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (1 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - f, 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (2 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (3 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (4 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (5 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (6 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (7 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.tSErse])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, f, 1.0F, 1.0F - f, (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (2 * f), 1.0F, 1.0F - (2 * f), (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (3 * f), 1.0F, 1.0F - (3 * f), (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (4 * f), 1.0F, 1.0F - (4 * f), (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (5 * f), 1.0F, 1.0F - (5 * f), (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (6 * f), 1.0F, 1.0F - (6 * f), (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (7 * f), 1.0F, 1.0F - (7 * f), (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (8 * f), 1.0F, 1.0F - (8 * f), (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (9 * f), 1.0F, 1.0F - (9 * f), (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (10 * f), 1.0F, 1.0F - (10 * f), (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (11 * f), 1.0F, 1.0F - (11 * f), (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (12 * f), 1.0F, 1.0F - (12 * f), (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (13 * f), 1.0F, 1.0F - (13 * f), (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (14 * f), 1.0F, 1.0F - (14 * f), (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (15 * f), 1.0F, 1.0F - (15 * f), (16 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.tSWrsw])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, f, 1.0F, 1.0F - f, (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (2 * f), 1.0F, 1.0F - (2 * f), (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (3 * f), 1.0F, 1.0F - (3 * f), (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (4 * f), 1.0F, 1.0F - (4 * f), (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (5 * f), 1.0F, 1.0F - (5 * f), (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (6 * f), 1.0F, 1.0F - (6 * f), (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (7 * f), 1.0F, 1.0F - (7 * f), (8 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (8 * f), 1.0F, 1.0F - (8 * f), (9 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (9 * f), 1.0F, 1.0F - (9 * f), (10 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (10 * f), 1.0F, 1.0F - (10 * f), (11 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (11 * f), 1.0F, 1.0F - (11 * f), (12 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (12 * f), 1.0F, 1.0F - (12 * f), (13 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (13 * f), 1.0F, 1.0F - (13 * f), (14 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (14 * f), 1.0F, 1.0F - (14 * f), (15 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (15 * f), 1.0F, 1.0F - (15 * f), (16 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F - (15 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - (14 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (13 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (12 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (11 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (10 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (9 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (1 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.NErSW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 0.0F, 1.0F - f, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 0.0F, 1.0F - (2 * f), (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 0.0F, 1.0F - (3 * f), (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 0.0F, 1.0F - (4 * f), (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 0.0F, 1.0F - (5 * f), (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 0.0F, 1.0F - (6 * f), (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 0.0F, 1.0F - (7 * f), (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - f, f, f, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (2 * f), (2 * f), (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (3 * f), (3 * f), (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (4 * f), (4 * f), (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (5 * f), (5 * f), (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (6 * f), (6 * f), (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (7 * f), (7 * f), (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.NWrSE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 0.0F, 1.0F - f, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 0.0F, 1.0F - (2 * f), (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 0.0F, 1.0F - (3 * f), (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 0.0F, 1.0F - (4 * f), (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 0.0F, 1.0F - (5 * f), (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 0.0F, 1.0F - (6 * f), (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 0.0F, 1.0F - (7 * f), (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 1.0F - f, 0.0F, (2 * f), f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 1.0F - (2 * f), 0.0F, (3 * f), (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 1.0F - (3 * f), 0.0F, (4 * f), (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 1.0F - (4 * f), 0.0F, (5 * f), (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 1.0F - (5 * f), 0.0F, (6 * f), (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 1.0F - (6 * f), 0.0F, (7 * f), (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 1.0F - (7 * f), 0.0F, (8 * f), (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.SErNW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, f, 1.0F - f, (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), (2 * f), 1.0F - (2 * f), (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), (3 * f), 1.0F - (3 * f), (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), (4 * f), 1.0F - (4 * f), (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), (5 * f), 1.0F - (5 * f), (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), (6 * f), 1.0F - (6 * f), (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), (7 * f), 1.0F - (7 * f), (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - f, f, f, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (2 * f), (2 * f), (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (3 * f), (3 * f), (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (4 * f), (4 * f), (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (5 * f), (5 * f), (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (6 * f), (6 * f), (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (7 * f), (7 * f), (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.SWrNE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, f, 1.0F - f, (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), (2 * f), 1.0F - (2 * f), (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), (3 * f), 1.0F - (3 * f), (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), (4 * f), 1.0F - (4 * f), (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), (5 * f), 1.0F - (5 * f), (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), (6 * f), 1.0F - (6 * f), (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), (7 * f), 1.0F - (7 * f), (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 1.0F - f, 0.0F, (2 * f), f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 1.0F - (2 * f), 0.0F, (3 * f), (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 1.0F - (3 * f), 0.0F, (4 * f), (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 1.0F - (4 * f), 0.0F, (5 * f), (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 1.0F - (5 * f), 0.0F, (6 * f), (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 1.0F - (6 * f), 0.0F, (7 * f), (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 1.0F - (7 * f), 0.0F, (8 * f), (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.NSErW])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 0.0F, 1.0F - f, (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 2 * f), ( 2 * f), 0.0F, 1.0F - ( 2 * f), (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 3 * f), ( 3 * f), 0.0F, 1.0F - ( 3 * f), (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 4 * f), ( 4 * f), 0.0F, 1.0F - ( 4 * f), (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 5 * f), ( 5 * f), 0.0F, 1.0F - ( 5 * f), (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 6 * f), ( 6 * f), 0.0F, 1.0F - ( 6 * f), (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 7 * f), ( 7 * f), 0.0F, 1.0F - ( 7 * f), (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - f, f, f, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (2 * f), (2 * f), (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (3 * f), (3 * f), (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (4 * f), (4 * f), (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (5 * f), (5 * f), (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (6 * f), (6 * f), (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(1.0F - (7 * f), (7 * f), (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.NSWrE])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 0.0F, 1.0F - f, (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 2 * f), ( 2 * f), 0.0F, 1.0F - ( 2 * f), (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 3 * f), ( 3 * f), 0.0F, 1.0F - ( 3 * f), (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 4 * f), ( 4 * f), 0.0F, 1.0F - ( 4 * f), (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 5 * f), ( 5 * f), 0.0F, 1.0F - ( 5 * f), (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 6 * f), ( 6 * f), 0.0F, 1.0F - ( 6 * f), (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(( 7 * f), ( 7 * f), 0.0F, 1.0F - ( 7 * f), (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, f, f, f, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F,  (2 * f),  (2 * f),  (2 * f), (3 * f), 1.0F -  (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F,  (3 * f),  (3 * f),  (3 * f), (4 * f), 1.0F -  (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F,  (4 * f),  (4 * f),  (4 * f), (5 * f), 1.0F -  (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F,  (5 * f),  (5 * f),  (5 * f), (6 * f), 1.0F -  (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F,  (6 * f),  (6 * f),  (6 * f), (7 * f), 1.0F -  (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F,  (7 * f),  (7 * f),  (7 * f), (8 * f), 1.0F -  (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.NEWrS])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, f, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			
			this.setBlockBounds(f, f, 0.0F, 1.0F - f, (2 * f), f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 0.0F, 1.0F - (2 * f), (3 * f), (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 0.0F, 1.0F - (3 * f), (4 * f), (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 0.0F, 1.0F - (4 * f), (5 * f), (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 0.0F, 1.0F - (5 * f), (6 * f), (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 0.0F, 1.0F - (6 * f), (7 * f), (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 0.0F, 1.0F - (7 * f), (8 * f), (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else if(flag[CTHelper.SEWrN])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, f, 1.0F, (2 * f), 1.0F - f);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(0.0F, 0.0F, (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds(f, f, 1.0F - f, 1.0F - f, (2 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((2 * f), (2 * f), 1.0F - (2 * f), 1.0F - (2 * f), (3 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((3 * f), (3 * f), 1.0F - (3 * f), 1.0F - (3 * f), (4 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((4 * f), (4 * f), 1.0F - (4 * f), 1.0F - (4 * f), (5 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((5 * f), (5 * f), 1.0F - (5 * f), 1.0F - (5 * f), (6 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((6 * f), (6 * f), 1.0F - (6 * f), 1.0F - (6 * f), (7 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
			this.setBlockBounds((7 * f), (7 * f), 1.0F - (7 * f), 1.0F - (7 * f), (8 * f), 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedBB, list, entity);
		}

		this.setBlockBoundsForItemRender();
	}

	public void setBlockBoundsForItemRender()
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		boolean[] flag = CTHelper.get(world, x, y, z, NanotechCityBlock.trail);

		if(flag[CTHelper.VrNSEW] || flag[CTHelper.VrNSE] || flag[CTHelper.VrNSW] || flag[CTHelper.VrNEW] || flag[CTHelper.VrSEW] || flag[CTHelper.VrNS] || flag[CTHelper.VrEW] || flag[CTHelper.NrSEW] || flag[CTHelper.SrNEW] || flag[CTHelper.ErNSW] || flag[CTHelper.WrNSE] || flag[CTHelper.NErSW] || flag[CTHelper.NSrEW] || flag[CTHelper.EWrNS] || flag[CTHelper.NErSW] || flag[CTHelper.SErNW] || flag[CTHelper.NWrSE] || flag[CTHelper.SWrNE] || flag[CTHelper.NSErW] || flag[CTHelper.NSWrE] || flag[CTHelper.NEWrS] || flag[CTHelper.SEWrN])
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityTrail();
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override
	public int getRenderType()
	{
		return ClientProxy.renderTrailID;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess blockaccess, int x, int y, int z)
	{
		return Blocks.grass.colorMultiplier(blockaccess, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		boolean[] flag = CTHelper.get(blockAccess, x, y, z, NanotechCityBlock.trail);
		if(side != 0)
		{
			if(flag[CTHelper.V] && !flag[CTHelper.N] && !flag[CTHelper.S] && !flag[CTHelper.E] && !flag[CTHelper.W])
			{
				return side == 1 ? iconBuffer[3] : iconBuffer[0];
			}
			if(flag[CTHelper.N] && !flag[CTHelper.NS] && !flag[CTHelper.NE] && !flag[CTHelper.NW])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[100] : iconBuffer[0]);
			}
			if(flag[CTHelper.S] && !flag[CTHelper.NS] && !flag[CTHelper.SE] && !flag[CTHelper.SW])
			{
				return side == 1 ? iconBuffer[5] : (side == 3 ? iconBuffer[100] : iconBuffer[0]);
			}
			if(flag[CTHelper.E] && !flag[CTHelper.EW] && !flag[CTHelper.NE] && !flag[CTHelper.SE])
			{
				return side == 1 ? iconBuffer[6] : (side == 5 ? iconBuffer[100] : iconBuffer[0]);
			}
			if(flag[CTHelper.W] && !flag[CTHelper.EW] && !flag[CTHelper.NW] && !flag[CTHelper.SW])
			{
				return side == 1 ? iconBuffer[7] : (side == 4 ? iconBuffer[100] : iconBuffer[0]);
			}
			if(flag[CTHelper.VrN] && !flag[CTHelper.SrN] && !flag[CTHelper.NrN])
			{
				return side == 1 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 4 ? iconBuffer[1] : (side == 5 ? iconBuffer[1] : iconBuffer[0])));
			}
			if(flag[CTHelper.VrS] && !flag[CTHelper.NrS] && !flag[CTHelper.SrS])
			{
				return side == 1 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 5 ? iconBuffer[2] : (side == 4 ? iconBuffer[2] : iconBuffer[0])));
			}
			if(flag[CTHelper.VrE] && !flag[CTHelper.WrE] && !flag[CTHelper.ErE])
			{
				return side == 1 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 2 ? iconBuffer[2] : (side == 3 ? iconBuffer[2] : iconBuffer[0])));
			}
			if(flag[CTHelper.VrW] && !flag[CTHelper.ErW] && !flag[CTHelper.WrW])
			{
				return side == 1 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 3 ? iconBuffer[1] : (side == 2 ? iconBuffer[1] : iconBuffer[0])));
			}
			if(flag[CTHelper.VrNS] && !flag[CTHelper.NSrNS])
			{
				return side == 1 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 4 ? iconBuffer[99] : (side == 5 ? iconBuffer[99] : iconBuffer[0]))));
			}
			if(flag[CTHelper.VrEW] && !flag[CTHelper.EWrEW])
			{
				return side == 1 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 2 ? iconBuffer[99] : (side == 3 ? iconBuffer[99] : iconBuffer[0]))));
			}
			if(flag[CTHelper.VrNE] && !flag[CTHelper.NErNE] && !flag[CTHelper.NrNE] && !flag[CTHelper.ErNE])
			{
				return side == 1 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 3 ? iconBuffer[2] : (side == 4 ? iconBuffer[1] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrNW] && !flag[CTHelper.NWrNW] && !flag[CTHelper.NrNW] && !flag[CTHelper.WrNW])
			{
				return side == 1 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 3 ? iconBuffer[1] : (side == 5 ? iconBuffer[1] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrSE] && !flag[CTHelper.SErSE] && !flag[CTHelper.SrSE] && !flag[CTHelper.ErSE])
			{
				return side == 1 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 2 ? iconBuffer[2] : (side == 4 ? iconBuffer[2] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrSW] && !flag[CTHelper.SWrSW] && !flag[CTHelper.SrSW] && !flag[CTHelper.WrSW])
			{
				return side == 1 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 2 ? iconBuffer[1] : (side == 5 ? iconBuffer[2] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrNSE] && !flag[CTHelper.NSErNSE] && !flag[CTHelper.tNrNSE] && !flag[CTHelper.tSrNSE] && !flag[CTHelper.tErNSE] && !flag[CTHelper.tNSrNSE] && !flag[CTHelper.tNErNSE] && !flag[CTHelper.tSErNSE])
			{
				return side == 1 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 4 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrNSW] && !flag[CTHelper.NSWrNSW] && !flag[CTHelper.tNrNSW] && !flag[CTHelper.tSrNSW] && !flag[CTHelper.tWrNSW] && !flag[CTHelper.tNSrNSW] && !flag[CTHelper.tNWrNSW] && !flag[CTHelper.tSWrNSW])
			{
				return side == 1 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 5 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrNEW] && !flag[CTHelper.NEWrNEW] && !flag[CTHelper.tNrNEW] && !flag[CTHelper.tErNEW] && !flag[CTHelper.tWrNEW] && !flag[CTHelper.tEWrNEW] && !flag[CTHelper.tNWrNEW] && !flag[CTHelper.tNErNEW])
			{
				return side == 1 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 2 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 3 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrSEW] && !flag[CTHelper.SEWrSEW] && !flag[CTHelper.tSrSEW] && !flag[CTHelper.tErSEW] && !flag[CTHelper.tWrSEW] && !flag[CTHelper.tEWrSEW] && !flag[CTHelper.tSErSEW] && !flag[CTHelper.tSWrSEW])
			{
				return side == 1 ? iconBuffer[3] : (side == 5 ? iconBuffer[3] : (side == 3 ? iconBuffer[3] : (side == 4 ? iconBuffer[3] : (side == 2 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.VrNSEW] && !flag[CTHelper.NSEWrNSEW] && !flag[CTHelper.tNrNSEW] && !flag[CTHelper.tSrNSEW] && !flag[CTHelper.tErNSEW] && !flag[CTHelper.tWrNSEW] && !flag[CTHelper.tNSrNSEW] && !flag[CTHelper.tEWrNSEW] && !flag[CTHelper.tNSErNSEW] && !flag[CTHelper.tNSWrNSEW] && !flag[CTHelper.tNEWrNSEW] && !flag[CTHelper.tSEWrNSEW])
			{
				return iconBuffer[3];
			}
			if(flag[CTHelper.NrS] && !flag[CTHelper.NSrS])
			{
				return side == 1 ? iconBuffer[4] : (side == 3 ? iconBuffer[4] : (side == 5 ? iconBuffer[2] : (side == 4 ? iconBuffer[2] : iconBuffer[0])));
			}
			if(flag[CTHelper.SrN] && !flag[CTHelper.NSrN])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 4 ? iconBuffer[1] : (side == 5 ? iconBuffer[1] : iconBuffer[0])));
			}
			if(flag[CTHelper.ErW] && !flag[CTHelper.EWrW])
			{
				return side == 1 ? iconBuffer[6] : (side == 4 ? iconBuffer[4] : (side == 2 ? iconBuffer[1] : (side == 3 ? iconBuffer[1] : iconBuffer[0])));
			}
			if(flag[CTHelper.WrE] && !flag[CTHelper.EWrE])
			{
				return side == 1 ? iconBuffer[7] : (side == 5 ? iconBuffer[4] : (side == 2 ? iconBuffer[2] : (side == 3 ? iconBuffer[2] : iconBuffer[0])));
			}
			if(flag[CTHelper.NSrN])
			{
				return side == 1 ? iconBuffer[8] : (side == 2 ? iconBuffer[8] : (side == 4 ? iconBuffer[1] : (side == 5 ? iconBuffer[1] : iconBuffer[0])));
			}
			if(flag[CTHelper.NSrS])
			{
				return side == 1 ? iconBuffer[8] : (side == 3 ? iconBuffer[8] : (side == 4 ? iconBuffer[2] : (side == 5 ? iconBuffer[2] : iconBuffer[0])));
			}
			if(flag[CTHelper.EWrE])
			{
				return side == 1 ? iconBuffer[9] : (side == 5 ? iconBuffer[8] : (side == 2 ? iconBuffer[2] : (side == 3 ? iconBuffer[2] : iconBuffer[0])));
			}
			if(flag[CTHelper.EWrW])
			{
				return side == 1 ? iconBuffer[9] : (side == 4 ? iconBuffer[8] : (side == 2 ? iconBuffer[1] : (side == 3 ? iconBuffer[1] : iconBuffer[0])));
			}
			if(flag[CTHelper.NS] && !flag[CTHelper.NSW] && !flag[CTHelper.NSE] && !flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[8] : (side == 2 ? iconBuffer[100] : (side == 3 ? iconBuffer[100] : iconBuffer[0]));
			}
			if(flag[CTHelper.EW] && !flag[CTHelper.NEW] && !flag[CTHelper.SEW] && !flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[9] : (side == 4 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0]));
			}
			if(flag[CTHelper.NW] && !flag[CTHelper.NEW] && !flag[CTHelper.NSW] && !flag[CTHelper.NSEW] && !flag[CTHelper.tNWrnw])
			{
				return side == 1 ? iconBuffer[10] : (side == 2 ? iconBuffer[100] : (side == 4 ? iconBuffer[100] : iconBuffer[0]));
			}
			while(!Loader.isModLoaded("nanotechmodcity"))
			{
				System.out.println("Why did you copy/paste my class ?");
			}
			if(flag[CTHelper.NE] && !flag[CTHelper.NEW] && !flag[CTHelper.NSE] && !flag[CTHelper.NSEW] && !flag[CTHelper.tNErne])
			{
				return side == 1 ? iconBuffer[11] : (side == 2 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0]));
			}
			if(flag[CTHelper.SE] && !flag[CTHelper.SEW] && !flag[CTHelper.NSE] && !flag[CTHelper.NSEW] && !flag[CTHelper.tSErse])
			{
				return side == 1 ? iconBuffer[12] : (side == 3 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0]));
			}
			if(flag[CTHelper.SW] && !flag[CTHelper.NSW] && !flag[CTHelper.SEW] && !flag[CTHelper.NSEW] && !flag[CTHelper.tSWrsw])
			{
				return side == 1 ? iconBuffer[13] : (side == 3 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0]));
			}
			if(flag[CTHelper.NSE] && !flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[15] : (side == 3 ? iconBuffer[100] : (side == 2 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0])));
			}
			if(flag[CTHelper.NSW] && !flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[14] : (side == 3 ? iconBuffer[100] : (side == 2 ? iconBuffer[100] : (side == 4 ? iconBuffer[100] : iconBuffer[0])));
			}
			if(flag[CTHelper.NEW] && !flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[17] : (side == 4 ? iconBuffer[100] : (side == 2 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0])));
			}
			if(flag[CTHelper.SEW] && !flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[16] : (side == 4 ? iconBuffer[100] : (side == 3 ? iconBuffer[100] : (side == 5 ? iconBuffer[100] : iconBuffer[0])));
			}
			if(flag[CTHelper.NSEW])
			{
				return side == 1 ? iconBuffer[18] : iconBuffer[0];
			}
			if(flag[CTHelper.NrN])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[5] : iconBuffer[0]);
			}
			if(flag[CTHelper.SrS])
			{
				return side == 1 ? iconBuffer[5] : (side == 3 ? iconBuffer[5] : iconBuffer[0]);
			}
			if(flag[CTHelper.ErE])
			{
				return side == 1 ? iconBuffer[6] : (side == 5 ? iconBuffer[5] : iconBuffer[0]);
			}
			if(flag[CTHelper.WrW])
			{
				return side == 1 ? iconBuffer[7] : (side == 4 ? iconBuffer[5] : iconBuffer[0]);
			}
			if(flag[CTHelper.NSrNS])
			{
				return side == 1 ? iconBuffer[8] : (side == 2 ? iconBuffer[8] : (side == 3 ? iconBuffer[8] : iconBuffer[0]));
			}
			if(flag[CTHelper.EWrEW])
			{
				return side == 1 ? iconBuffer[9] : (side == 4 ? iconBuffer[8] : (side == 5 ? iconBuffer[8] : iconBuffer[0]));
			}
			if(flag[CTHelper.NErNE])
			{
				return side == 1 ? iconBuffer[11] : (side == 2 ? iconBuffer[12] : (side == 5 ? iconBuffer[13] : iconBuffer[0]));
			}
			if(flag[CTHelper.NWrNW])
			{
				return side == 1 ? iconBuffer[10] : (side == 2 ? iconBuffer[13] : (side == 4 ? iconBuffer[13] : iconBuffer[0]));
			}
			if(flag[CTHelper.SErSE])
			{
				return side == 1 ? iconBuffer[12] : (side == 3 ? iconBuffer[12] : (side == 5 ? iconBuffer[12] : iconBuffer[0]));
			}
			if(flag[CTHelper.SWrSW])
			{
				return side == 1 ? iconBuffer[13] : (side == 3 ? iconBuffer[13] : (side == 4 ? iconBuffer[12] : iconBuffer[0]));
			}
			if(flag[CTHelper.NSErNSE])
			{
				return side == 1 ? iconBuffer[15] : (side == 3 ? iconBuffer[15] : (side == 2 ? iconBuffer[15] : (side == 5 ? iconBuffer[15] : (side == 4 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.NSWrNSW])
			{
				return side == 1 ? iconBuffer[14] : (side == 3 ? iconBuffer[14] : (side == 2 ? iconBuffer[14] : (side == 4 ? iconBuffer[14] : (side == 5 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.NEWrNEW])
			{
				return side == 1 ? iconBuffer[17] : (side == 5 ? iconBuffer[14] : (side == 2 ? iconBuffer[13] : (side == 4 ? iconBuffer[14] : (side == 3 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.SEWrSEW])
			{
				return side == 1 ? iconBuffer[16] : (side == 5 ? iconBuffer[15] : (side == 3 ? iconBuffer[16] : (side == 4 ? iconBuffer[15] : (side == 2 ? iconBuffer[99] : iconBuffer[100]))));
			}
			if(flag[CTHelper.NSEWrNSEW])
			{
				return iconBuffer[18];
			}
			if(flag[CTHelper.NrNE])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[5] : (side == 5 ? iconBuffer[7] : iconBuffer[0]));
			}
			if(flag[CTHelper.NrNW])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[5] : (side == 4 ? iconBuffer[7] : iconBuffer[0]));
			}
			if(flag[CTHelper.SrSE])
			{
				return side == 1 ? iconBuffer[5] : (side == 3 ? iconBuffer[5] : (side == 5 ? iconBuffer[6] : iconBuffer[0]));
			}
			if(flag[CTHelper.SrSW])
			{
				return side == 1 ? iconBuffer[5] : (side == 3 ? iconBuffer[5] : (side == 4 ? iconBuffer[6] : iconBuffer[0]));
			}
			if(flag[CTHelper.ErNE])
			{
				return side == 1 ? iconBuffer[6] : (side == 2 ? iconBuffer[6] : (side == 5 ? iconBuffer[5] : iconBuffer[0]));
			}
			if(flag[CTHelper.WrNW])
			{
				return side == 1 ? iconBuffer[7] : (side == 2 ? iconBuffer[7] : (side == 4 ? iconBuffer[5] : iconBuffer[0]));
			}
			if(flag[CTHelper.ErSE])
			{
				return side == 1 ? iconBuffer[6] : (side == 3 ? iconBuffer[6] : (side == 5 ? iconBuffer[5] : iconBuffer[0]));
			}
			if(flag[CTHelper.WrSW])
			{
				return side == 1 ? iconBuffer[7] : (side == 3 ? iconBuffer[7] : (side == 4 ? iconBuffer[5] : iconBuffer[0]));
			}
			if(flag[CTHelper.tNrE])
			{
				return side == 1 ? iconBuffer[4] : (side == 5 ? iconBuffer[7] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNrW])
			{
				return side == 1 ? iconBuffer[4] : (side == 4 ? iconBuffer[7] : iconBuffer[0]);
			}
			if(flag[CTHelper.tSrE])
			{
				return side == 1 ? iconBuffer[5] : (side == 5 ? iconBuffer[6] : iconBuffer[0]);
			}
			if(flag[CTHelper.tSrW])
			{
				return side == 1 ? iconBuffer[5] : (side == 4 ? iconBuffer[6] : iconBuffer[0]);
			}
			if(flag[CTHelper.tErN])
			{
				return side == 1 ? iconBuffer[6] : (side == 2 ? iconBuffer[6] : iconBuffer[0]);
			}
			if(flag[CTHelper.tErS])
			{
				return side == 1 ? iconBuffer[6] : (side == 3 ? iconBuffer[6] : iconBuffer[0]);
			}
			if(flag[CTHelper.tWrN])
			{
				return side == 1 ? iconBuffer[7] : (side == 2 ? iconBuffer[7] : iconBuffer[0]);
			}
			if(flag[CTHelper.tWrS])
			{
				return side == 1 ? iconBuffer[7] : (side == 3 ? iconBuffer[7] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNrSE])
			{
				return side == 1 ? iconBuffer[4] : (side == 3 ? iconBuffer[4] : (side == 5 ? iconBuffer[7] : iconBuffer[0]));
			}
			if(flag[CTHelper.tNrSW])
			{
				return side == 1 ? iconBuffer[4] : (side == 3 ? iconBuffer[4] : (side == 4 ? iconBuffer[7] : iconBuffer[0]));
			}
			if(flag[CTHelper.tSrNE])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 5 ? iconBuffer[6] : iconBuffer[0]));
			}
			if(flag[CTHelper.tSrNW])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 4 ? iconBuffer[6] : iconBuffer[0]));
			}
			if(flag[CTHelper.tErNW])
			{
				return side == 1 ? iconBuffer[6] : (side == 2 ? iconBuffer[6] : (side == 4 ? iconBuffer[4] : iconBuffer[0]));
			}
			if(flag[CTHelper.tErSW])
			{
				return side == 1 ? iconBuffer[6] : (side == 3 ? iconBuffer[6] : (side == 4 ? iconBuffer[4] : iconBuffer[0]));
			}
			if(flag[CTHelper.tWrNE])
			{
				return side == 1 ? iconBuffer[7] : (side == 2 ? iconBuffer[7] : (side == 5 ? iconBuffer[4] : iconBuffer[0]));
			}
			if(flag[CTHelper.tWrSE])
			{
				return side == 1 ? iconBuffer[7] : (side == 3 ? iconBuffer[7] : (side == 5 ? iconBuffer[4] : iconBuffer[0]));
			}
			if(flag[CTHelper.tNErne])
			{
				return side == 1 ? iconBuffer[11] : (side == 2 ? iconBuffer[12] : (side == 5 ? iconBuffer[13] : iconBuffer[0]));
			}
			if(flag[CTHelper.tNWrnw])
			{
				return side == 1 ? iconBuffer[10] : (side == 2 ? iconBuffer[13] : (side == 4 ? iconBuffer[13] : iconBuffer[0]));
			}
			if(flag[CTHelper.tSErse])
			{
				return side == 1 ? iconBuffer[12] : (side == 3 ? iconBuffer[12] : (side == 5 ? iconBuffer[12] : iconBuffer[0]));
			}
			if(flag[CTHelper.tSWrsw])
			{
				return side == 1 ? iconBuffer[13] : (side == 3 ? iconBuffer[13] : (side == 4 ? iconBuffer[12] : iconBuffer[0]));
			}
			if(flag[CTHelper.tEWrN] && !flag[CTHelper.tNEWrN])
			{
				return side == 1 ? iconBuffer[9] : (side == 2 ? iconBuffer[9] : iconBuffer[0]);
			}
			if(flag[CTHelper.tEWrS] && !flag[CTHelper.tSEWrS])
			{
				return side == 1 ? iconBuffer[9] : (side == 3 ? iconBuffer[9] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSrE] && !flag[CTHelper.tNSErE])
			{
				return side == 1 ? iconBuffer[8] : (side == 5 ? iconBuffer[9] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSrW] && !flag[CTHelper.tNSWrW])
			{
				return side == 1 ? iconBuffer[8] : (side == 4 ? iconBuffer[9] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSErE])
			{
				return side == 1 ? iconBuffer[15] : (side == 5 ? iconBuffer[16] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSWrW])
			{
				return side == 1 ? iconBuffer[14] : (side == 4 ? iconBuffer[16] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNEWrN])
			{
				return side == 1 ? iconBuffer[17] : (side == 2 ? iconBuffer[16] : iconBuffer[0]);
			}
			if(flag[CTHelper.tSEWrS])
			{
				return side == 1 ? iconBuffer[16] : (side == 3 ? iconBuffer[16] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSErW] && !flag[CTHelper.NSErW])
			{
				return side == 1 ? iconBuffer[15] : (side == 4 ? iconBuffer[17] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSWrE] && !flag[CTHelper.NSWrE])
			{
				return side == 1 ? iconBuffer[14] : (side == 5 ? iconBuffer[17] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNEWrS] && !flag[CTHelper.NEWrS])
			{
				return side == 1 ? iconBuffer[17] : (side == 3 ? iconBuffer[17] : iconBuffer[0]);
			}
			if(flag[CTHelper.tSEWrN] && !flag[CTHelper.SEWrN])
			{
				return side == 1 ? iconBuffer[16] : (side == 2 ? iconBuffer[17] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSEWrN])
			{
				return side == 1 ? iconBuffer[18] : (side == 2 ? iconBuffer[18] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSEWrS])
			{
				return side == 1 ? iconBuffer[18] : (side == 3 ? iconBuffer[18] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSEWrE])
			{
				return side == 1 ? iconBuffer[18] : (side == 5 ? iconBuffer[18] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNSEWrW])
			{
				return side == 1 ? iconBuffer[18] : (side == 4 ? iconBuffer[18] : iconBuffer[0]);
			}
			if(flag[CTHelper.tNrNSEW])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[5] : (side == 3 ? iconBuffer[4] : (side == 4 ? iconBuffer[7] : iconBuffer[7])));
			}
			if(flag[CTHelper.tSrNSEW])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 3 ? iconBuffer[5] : (side == 4 ? iconBuffer[6] : iconBuffer[6])));
			}
			if(flag[CTHelper.tErNSEW])
			{
				return side == 1 ? iconBuffer[6] : (side == 2 ? iconBuffer[6] : (side == 3 ? iconBuffer[6] : (side == 4 ? iconBuffer[4] : iconBuffer[5])));
			}
			if(flag[CTHelper.tWrNSEW])
			{
				return side == 1 ? iconBuffer[7] : (side == 2 ? iconBuffer[7] : (side == 3 ? iconBuffer[7] : (side == 4 ? iconBuffer[5] : iconBuffer[4])));
			}
			if(flag[CTHelper.tNSrNSEW])
			{
				return side == 1 ? iconBuffer[8] : (side == 2 ? iconBuffer[8] : (side == 3 ? iconBuffer[8] : iconBuffer[9]));
			}
			if(flag[CTHelper.tEWrNSEW])
			{
				return side == 1 ? iconBuffer[9] : (side == 4 ? iconBuffer[8] : (side == 5 ? iconBuffer[8] : iconBuffer[9]));
			}
			if(flag[CTHelper.tNSErNSEW])
			{
				return side == 1 ? iconBuffer[15] : (side == 4 ? iconBuffer[17] : (side == 5 ? iconBuffer[16] : iconBuffer[15]));
			}
			if(flag[CTHelper.tNSWrNSEW])
			{
				return side == 1 ? iconBuffer[14] : (side == 4 ? iconBuffer[16] : (side == 5 ? iconBuffer[17] : iconBuffer[14]));
			}
			if(flag[CTHelper.tNEWrNSEW])
			{
				return side == 1 ? iconBuffer[17] : (side == 3 ? iconBuffer[17] : (side == 2 ? iconBuffer[16] : iconBuffer[14]));
			}
			if(flag[CTHelper.tSEWrNSEW])
			{
				return side == 1 ? iconBuffer[16] : (side == 2 ? iconBuffer[17] : (side == 3 ? iconBuffer[16] : iconBuffer[15]));
			}
			if(flag[CTHelper.tSrSEW])
			{
				return side == 1 ? iconBuffer[5] : (side == 3 ? iconBuffer[5] : (side == 2 ? iconBuffer[99] : iconBuffer[6]));
			}
			if(flag[CTHelper.tErSEW])
			{
				return side == 1 ? iconBuffer[6] : (side == 3 ? iconBuffer[6] : (side == 2 ? iconBuffer[99] : (side == 4 ? iconBuffer[4] : iconBuffer[5])));
			}
			if(flag[CTHelper.tWrSEW])
			{
				return side == 1 ? iconBuffer[7] : (side == 3 ? iconBuffer[7] : (side == 2 ? iconBuffer[99] : (side == 5 ? iconBuffer[4] : iconBuffer[5])));
			}
			if(flag[CTHelper.tNrNEW])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[4] : (side == 3 ? iconBuffer[99] : iconBuffer[7]));
			}
			if(flag[CTHelper.tErNEW])
			{
				return side == 1 ? iconBuffer[6] : (side == 2 ? iconBuffer[6] : (side == 3 ? iconBuffer[99] : (side == 4 ? iconBuffer[4] : iconBuffer[5])));
			}
			if(flag[CTHelper.tWrNEW])
			{
				return side == 1 ? iconBuffer[7] : (side == 2 ? iconBuffer[7] : (side == 3 ? iconBuffer[99] : (side == 5 ? iconBuffer[4] : iconBuffer[5])));
			}
			if(flag[CTHelper.tNrNSE])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[5] : (side == 3 ? iconBuffer[4] : (side == 4 ? iconBuffer[99] : iconBuffer[7])));
			}
			if(flag[CTHelper.tSrNSE])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 3 ? iconBuffer[5] : (side == 4 ? iconBuffer[99] : iconBuffer[6])));
			}
			if(flag[CTHelper.tErNSE])
			{
				return side == 1 ? iconBuffer[6] : (side == 5 ? iconBuffer[5] : (side == 4 ? iconBuffer[99] : iconBuffer[6]));
			}
			if(flag[CTHelper.tNrNSW])
			{
				return side == 1 ? iconBuffer[4] : (side == 2 ? iconBuffer[5] : (side == 3 ? iconBuffer[4] : (side == 5 ? iconBuffer[99] : iconBuffer[7])));
			}
			if(flag[CTHelper.tSrNSW])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 3 ? iconBuffer[5] : (side == 5 ? iconBuffer[99] : iconBuffer[6])));
			}
			if(flag[CTHelper.tWrNSW])
			{
				return side == 1 ? iconBuffer[7] : (side == 4 ? iconBuffer[5] : (side == 5 ? iconBuffer[99] : iconBuffer[7]));
			}
			if(flag[CTHelper.tNSrNSE])
			{
				return side == 1 ? iconBuffer[8] : (side == 2 ? iconBuffer[8] : (side == 3 ? iconBuffer[8] : (side == 5 ? iconBuffer[9] : iconBuffer[99])));
			}
			if(flag[CTHelper.tNSrNSW])
			{
				return side == 1 ? iconBuffer[8] : (side == 2 ? iconBuffer[8] : (side == 3 ? iconBuffer[8] : (side == 4 ? iconBuffer[9] : iconBuffer[99])));
			}
			if(flag[CTHelper.tEWrSEW])
			{
				return side == 1 ? iconBuffer[9] : (side == 4 ? iconBuffer[8] : (side == 5 ? iconBuffer[8] : (side == 3 ? iconBuffer[9] : iconBuffer[99])));
			}
			if(flag[CTHelper.tEWrNEW])
			{
				return side == 1 ? iconBuffer[9] : (side == 4 ? iconBuffer[8] : (side == 5 ? iconBuffer[8] : (side == 2 ? iconBuffer[9] : iconBuffer[99])));
			}
			if(flag[CTHelper.tSErSEW])
			{
				return side == 1 ? iconBuffer[12] : (side == 3 ? iconBuffer[12] : (side == 5 ? iconBuffer[12] : (side == 4 ? iconBuffer[11] : iconBuffer[99])));
			}
			if(flag[CTHelper.tSWrSEW])
			{
				return side == 1 ? iconBuffer[13] : (side == 3 ? iconBuffer[13] : (side == 5 ? iconBuffer[11] : (side == 4 ? iconBuffer[12] : iconBuffer[99])));
			}
			if(flag[CTHelper.tNErNSE])
			{
				return side == 1 ? iconBuffer[11] : (side == 3 ? iconBuffer[11] : (side == 2 ? iconBuffer[12] : (side == 5 ? iconBuffer[13] : iconBuffer[99])));
			}
			if(flag[CTHelper.tSErNSE])
			{
				return side == 1 ? iconBuffer[12] : (side == 3 ? iconBuffer[12] : (side == 2 ? iconBuffer[11] : (side == 5 ? iconBuffer[12] : iconBuffer[99])));
			}
			if(flag[CTHelper.tNWrNEW])
			{
				return side == 1 ? iconBuffer[10] : (side == 2 ? iconBuffer[13] : (side == 4 ? iconBuffer[13] : (side == 5 ? iconBuffer[10] : iconBuffer[99])));
			}
			if(flag[CTHelper.tNErNEW])
			{
				return side == 1 ? iconBuffer[11] : (side == 2 ? iconBuffer[12] : (side == 4 ? iconBuffer[10] : (side == 5 ? iconBuffer[13] : iconBuffer[99])));
			}
			if(flag[CTHelper.tNWrNSW])
			{
				return side == 1 ? iconBuffer[10] : (side == 2 ? iconBuffer[13] : (side == 3 ? iconBuffer[10] : (side == 4 ? iconBuffer[13] : iconBuffer[99])));
			}
			if(flag[CTHelper.tSWrNSW])
			{
				return side == 1 ? iconBuffer[13] : (side == 2 ? iconBuffer[10] : (side == 3 ? iconBuffer[13] : (side == 4 ? iconBuffer[12] : iconBuffer[99])));
			}
			if(flag[CTHelper.NrSEW])
			{
				return side == 1 ? iconBuffer[4] : (side == 3 ? iconBuffer[4] : (side == 4 ? iconBuffer[7] : (side == 5 ? iconBuffer[7] : iconBuffer[99])));
			}
			if(flag[CTHelper.SrNEW])
			{
				return side == 1 ? iconBuffer[5] : (side == 2 ? iconBuffer[4] : (side == 4 ? iconBuffer[6] : (side == 5 ? iconBuffer[6] : iconBuffer[99])));
			}
			if(flag[CTHelper.ErNSW])
			{
				return side == 1 ? iconBuffer[6] : (side == 4 ? iconBuffer[4] : (side == 2 ? iconBuffer[6] : (side == 3 ? iconBuffer[6] : iconBuffer[99])));
			}
			if(flag[CTHelper.WrNSE])
			{
				return side == 1 ? iconBuffer[7] : (side == 5 ? iconBuffer[4] : (side == 2 ? iconBuffer[7] : (side == 3 ? iconBuffer[7] : iconBuffer[99])));
			}
			if(flag[CTHelper.NSrEW])
			{
				return side == 1 ? iconBuffer[8] : (side == 4 ? iconBuffer[9] : (side == 5 ? iconBuffer[9] : iconBuffer[99]));
			}
			if(flag[CTHelper.EWrNS])
			{
				return side == 1 ? iconBuffer[9] : (side == 2 ? iconBuffer[9] : (side == 3 ? iconBuffer[9] : iconBuffer[99]));
			}
			if(flag[CTHelper.NErSW])
			{
				return side == 1 ? iconBuffer[11] : (side == 3 ? iconBuffer[11] : (side == 4 ? iconBuffer[10] : (side == 2 ? iconBuffer[12] : iconBuffer[13])));
			}
			if(flag[CTHelper.NWrSE])
			{
				return side == 1 ? iconBuffer[10] : (side == 5 ? iconBuffer[10] : (side == 3 ? iconBuffer[10] : iconBuffer[13]));
			}
			if(flag[CTHelper.SErNW])
			{
				return side == 1 ? iconBuffer[12] : iconBuffer[11];
			}
			if(flag[CTHelper.SWrNE])
			{
				return side == 1 ? iconBuffer[13] : (side == 5 ? iconBuffer[11] : (side == 2 ? iconBuffer[10] : (side == 3 ? iconBuffer[13] : iconBuffer[12])));
			}
			if(flag[CTHelper.NSErW])
			{
				return side == 1 ? iconBuffer[15] : (side == 4 ? iconBuffer[17] : (side == 3 ? iconBuffer[15] : (side == 2 ? iconBuffer[15] : iconBuffer[16])));
			}
			if(flag[CTHelper.NSWrE])
			{
				return side == 1 ? iconBuffer[14] : (side == 5 ? iconBuffer[17] : (side == 2 ? iconBuffer[14] : (side == 3 ? iconBuffer[14] : iconBuffer[16])));
			}
			if(flag[CTHelper.NEWrS])
			{
				return side == 1 || side == 3 ? iconBuffer[17] : (side == 2 ? iconBuffer[16] : iconBuffer[14]);
			}
			if(flag[CTHelper.SEWrN])
			{
				return side == 1 || side == 3 ? iconBuffer[16] : (side == 2 ? iconBuffer[17] : iconBuffer[15]);
			}
		}
		else
		{
			return iconBuffer[100];
		}

		return side == 1 ? iconBuffer[102] : (side == 0 ? iconBuffer[102] : iconBuffer[0]);
	}

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		iconBuffer = new IIcon[105];

		iconBuffer[0] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/side1");
		iconBuffer[1] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/side2");
		iconBuffer[2] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/side3");
		iconBuffer[3] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex1");
		iconBuffer[4] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex2");
		iconBuffer[5] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex3");
		iconBuffer[6] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex5");
		iconBuffer[7] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex4");
		iconBuffer[8] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex6");
		iconBuffer[9] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex7");
		iconBuffer[10] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex8");
		iconBuffer[11] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex9");
		iconBuffer[12] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex10");
		iconBuffer[13] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex11");
		iconBuffer[14] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex12");
		iconBuffer[15] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex13");
		iconBuffer[16] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex14");
		iconBuffer[17] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex15");
		iconBuffer[18] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/tex16");
		iconBuffer[99] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/side4");
		iconBuffer[100] = iconRegister.registerIcon(NanotechModCity.MODID + ":empty");
		iconBuffer[101] = iconRegister.registerIcon(NanotechModCity.MODID + ":trail/hand");
		iconBuffer[102] = iconRegister.registerIcon(NanotechModCity.MODID + ":spotlight");
	}

	public IIcon getIcon(int side, int metadata)
	{
		return side == 1 ? iconBuffer[101] : Blocks.grass.getIcon(side, 0);
	}
}