/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.city.core.ClientProxy;
import fr.mcnanotech.kevin_68.nanotechmod.city.utils.CTHelper;

public class TileEntityTrailRenderISBRH implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		float f = 0.0625F;
		boolean[] flag = CTHelper.get(world, x, y, z, NanotechCityBlock.trail);

		if(flag[CTHelper.VrN] || flag[CTHelper.SrN] || flag[CTHelper.tErN] || flag[CTHelper.tWrN] || flag[CTHelper.tEWrN] || flag[CTHelper.tSEWrN])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - f, 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (2 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (3 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (4 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (5 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (6 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (7 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}

		if(flag[CTHelper.VrS] || flag[CTHelper.NrS] || flag[CTHelper.tErS] || flag[CTHelper.tWrS] || flag[CTHelper.tEWrS] || flag[CTHelper.tNEWrS])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, f, 1.0F, 1.0F - f, (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (2 * f), 1.0F, 1.0F - (2 * f), (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (3 * f), 1.0F, 1.0F - (3 * f), (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (4 * f), 1.0F, 1.0F - (4 * f), (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (5 * f), 1.0F, 1.0F - (5 * f), (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (6 * f), 1.0F, 1.0F - (6 * f), (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (7 * f), 1.0F, 1.0F - (7 * f), (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (8 * f), 1.0F, 1.0F - (8 * f), (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (9 * f), 1.0F, 1.0F - (9 * f), (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (10 * f), 1.0F, 1.0F - (10 * f), (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (11 * f), 1.0F, 1.0F - (11 * f), (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (12 * f), 1.0F, 1.0F - (12 * f), (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (13 * f), 1.0F, 1.0F - (13 * f), (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (14 * f), 1.0F, 1.0F - (14 * f), (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (15 * f), 1.0F, 1.0F - (15 * f), (16 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}

		if(flag[CTHelper.VrE] || flag[CTHelper.WrE] || flag[CTHelper.tNrE] || flag[CTHelper.tSrE] || flag[CTHelper.tNSrE] || flag[CTHelper.tNSWrE])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}

		if(flag[CTHelper.VrW] || flag[CTHelper.ErW] || flag[CTHelper.tNrW] || flag[CTHelper.tSrW] || flag[CTHelper.tNSrW] || flag[CTHelper.tNSErW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (1 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}

		if(flag[CTHelper.VrNS])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - (14 * f), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (13 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (12 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (11 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (10 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (9 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (8 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}

		if(flag[CTHelper.VrEW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrNE] || flag[CTHelper.tSrNE] || flag[CTHelper.tWrNE])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, f, f, 1.0F - f, (f * 2), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 2), (f * 2), 1.0F - (f * 2), (f * 3), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 3), (f * 3), 1.0F - (f * 3), (f * 4), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 4), (f * 4), 1.0F - (f * 4), (f * 5), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 5), (f * 5), 1.0F - (f * 5), (f * 6), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 6), (f * 6), 1.0F - (f * 6), (f * 7), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 7), (f * 7), 1.0F - (f * 7), (f * 8), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 8), (f * 8), 1.0F - (f * 8), (f * 9), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 9), (f * 9), 1.0F - (f * 9), (f * 10), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 10), (f * 10), 1.0F - (f * 10), (f * 11), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 11), (f * 11), 1.0F - (f * 11), (f * 12), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 12), (f * 12), 1.0F - (f * 12), (f * 13), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 13), (f * 13), 1.0F - (f * 13), (f * 14), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 14), (f * 14), 1.0F - (f * 14), (f * 15), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 15), (f * 15), 1.0F - (f * 15), (f * 16), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrNW] || flag[CTHelper.tSrNW] || flag[CTHelper.tErNW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, f, f, 1.0F, (f * 2), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), (f * 2), (f * 2), 1.0F, (f * 3), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), (f * 3), (f * 3), 1.0F, (f * 4), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), (f * 4), (f * 4), 1.0F, (f * 5), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), (f * 5), (f * 5), 1.0F, (f * 6), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), (f * 6), (f * 6), 1.0F, (f * 7), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), (f * 7), (f * 7), 1.0F, (f * 8), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), (f * 8), (f * 8), 1.0F, (f * 9), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), (f * 9), (f * 9), 1.0F, (f * 10), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), (f * 10), (f * 10), 1.0F, (f * 11), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), (f * 11), (f * 11), 1.0F, (f * 12), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), (f * 12), (f * 12), 1.0F, (f * 13), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), (f * 13), (f * 13), 1.0F, (f * 14), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), (f * 14), (f * 14), 1.0F, (f * 15), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), (f * 15), (f * 15), 1.0F, (f * 16), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrSE] || flag[CTHelper.tNrSE] || flag[CTHelper.tWrSE])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, f, 0.0F, 1.0F - f, (f * 2), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 2), 0.0F, 1.0F - (f * 2), (f * 3), 1.0F - (f * 2));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 3), 0.0F, 1.0F - (f * 3), (f * 4), 1.0F - (f * 3));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 4), 0.0F, 1.0F - (f * 4), (f * 5), 1.0F - (f * 4));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 5), 0.0F, 1.0F - (f * 5), (f * 6), 1.0F - (f * 5));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 6), 0.0F, 1.0F - (f * 6), (f * 7), 1.0F - (f * 6));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 7), 0.0F, 1.0F - (f * 7), (f * 8), 1.0F - (f * 7));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 8), 0.0F, 1.0F - (f * 8), (f * 9), 1.0F - (f * 8));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 9), 0.0F, 1.0F - (f * 9), (f * 10), 1.0F - (f * 9));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 10), 0.0F, 1.0F - (f * 10), (f * 11), 1.0F - (f * 10));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 11), 0.0F, 1.0F - (f * 11), (f * 12), 1.0F - (f * 11));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 12), 0.0F, 1.0F - (f * 12), (f * 13), 1.0F - (f * 12));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 13), 0.0F, 1.0F - (f * 13), (f * 14), 1.0F - (f * 13));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 14), 0.0F, 1.0F - (f * 14), (f * 15), 1.0F - (f * 14));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (f * 15), 0.0F, 1.0F - (f * 15), (f * 16), 1.0F - (f * 15));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrSW] || flag[CTHelper.tNrSW] || flag[CTHelper.tErSW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, f, 0.0F, 1.0F, (f * 2), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), (f * 2), 0.0F, 1.0F, (f * 3), 1.0F - (f * 2));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), (f * 3), 0.0F, 1.0F, (f * 4), 1.0F - (f * 3));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), (f * 4), 0.0F, 1.0F, (f * 5), 1.0F - (f * 4));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), (f * 5), 0.0F, 1.0F, (f * 6), 1.0F - (f * 5));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), (f * 6), 0.0F, 1.0F, (f * 7), 1.0F - (f * 6));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), (f * 7), 0.0F, 1.0F, (f * 8), 1.0F - (f * 7));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), (f * 8), 0.0F, 1.0F, (f * 9), 1.0F - (f * 8));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), (f * 9), 0.0F, 1.0F, (f * 10), 1.0F - (f * 9));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), (f * 10), 0.0F, 1.0F, (f * 11), 1.0F - (f * 10));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), (f * 11), 0.0F, 1.0F, (f * 12), 1.0F - (f * 11));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), (f * 12), 0.0F, 1.0F, (f * 13), 1.0F - (f * 12));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), (f * 13), 0.0F, 1.0F, (f * 14), 1.0F - (f * 13));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), (f * 14), 0.0F, 1.0F, (f * 15), 1.0F - (f * 14));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), (f * 15), 0.0F, 1.0F, (f * 16), 1.0F - (f * 15));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrNSE])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, f, f, 1.0F - f, (2 * f), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (2 * f), (2 * f), 1.0F - (2 * f), (3 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (3 * f), (3 * f), 1.0F - (3 * f), (4 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (4 * f), (4 * f), 1.0F - (4 * f), (5 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (5 * f), (5 * f), 1.0F - (5 * f), (6 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (6 * f), (6 * f), 1.0F - (6 * f), (7 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, (7 * f), (7 * f), 1.0F - (7 * f), (8 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrNSW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, f, f, 1.0F, (2 * f), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((2 * f), (2 * f), (2 * f), 1.0F, (3 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((3 * f), (3 * f), (3 * f), 1.0F, (4 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((4 * f), (4 * f), (4 * f), 1.0F, (5 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((5 * f), (5 * f), (5 * f), 1.0F, (6 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((6 * f), (6 * f), (6 * f), 1.0F, (7 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((7 * f), (7 * f), (7 * f), 1.0F, (8 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrNEW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, f, f, 1.0F - f, (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((2 * f), (2 * f), (2 * f), 1.0F - (2 * f), (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((3 * f), (3 * f), (3 * f), 1.0F - (3 * f), (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((4 * f), (4 * f), (4 * f), 1.0F - (4 * f), (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((5 * f), (5 * f), (5 * f), 1.0F - (5 * f), (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((6 * f), (6 * f), (6 * f), 1.0F - (6 * f), (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((7 * f), (7 * f), (7 * f), 1.0F - (7 * f), (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrSEW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, f, 0.0F, 1.0F - f, (2 * f), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((2 * f), (2 * f), 0.0F, 1.0F - (2 * f), (3 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((3 * f), (3 * f), 0.0F, 1.0F - (3 * f), (4 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((4 * f), (4 * f), 0.0F, 1.0F - (4 * f), (5 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((5 * f), (5 * f), 0.0F, 1.0F - (5 * f), (6 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((6 * f), (6 * f), 0.0F, 1.0F - (6 * f), (7 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((7 * f), (7 * f), 0.0F, 1.0F - (7 * f), (8 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.VrNSEW])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, f, f, 1.0F - f, (f * 2), 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), (f * 2), (f * 2), 1.0F - (f * 2), (f * 3), 1.0F - (f * 2));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), (f * 3), (f * 3), 1.0F - (f * 3), (f * 4), 1.0F - (f * 3));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), (f * 4), (f * 4), 1.0F - (f * 4), (f * 5), 1.0F - (f * 4));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), (f * 5), (f * 5), 1.0F - (f * 5), (f * 6), 1.0F - (f * 5));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), (f * 6), (f * 6), 1.0F - (f * 6), (f * 7), 1.0F - (f * 6));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), (f * 7), (f * 7), 1.0F - (f * 7), (f * 8), 1.0F - (f * 7));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.tNErne])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - f, 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (2 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (3 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (4 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (5 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (6 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (7 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.tNWrnw])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (1 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (2 * f), 1.0F, 1.0F - f, 1.0F - f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (3 * f), 1.0F, 1.0F - (2 * f), 1.0F - (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (4 * f), 1.0F, 1.0F - (3 * f), 1.0F - (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (5 * f), 1.0F, 1.0F - (4 * f), 1.0F - (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (6 * f), 1.0F, 1.0F - (5 * f), 1.0F - (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (7 * f), 1.0F, 1.0F - (6 * f), 1.0F - (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (8 * f), 1.0F, 1.0F - (7 * f), 1.0F - (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (9 * f), 1.0F, 1.0F - (8 * f), 1.0F - (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (10 * f), 1.0F, 1.0F - (9 * f), 1.0F - (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (11 * f), 1.0F, 1.0F - (10 * f), 1.0F - (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (12 * f), 1.0F, 1.0F - (11 * f), 1.0F - (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (13 * f), 1.0F, 1.0F - (12 * f), 1.0F - (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (14 * f), 1.0F, 1.0F - (13 * f), 1.0F - (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (15 * f), 1.0F, 1.0F - (14 * f), 1.0F - (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 1.0F - (16 * f), 1.0F, 1.0F - (15 * f), 1.0F - (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.tSErse])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, f, 1.0F, 1.0F - f, (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (2 * f), 1.0F, 1.0F - (2 * f), (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (3 * f), 1.0F, 1.0F - (3 * f), (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (4 * f), 1.0F, 1.0F - (4 * f), (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (5 * f), 1.0F, 1.0F - (5 * f), (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (6 * f), 1.0F, 1.0F - (6 * f), (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (7 * f), 1.0F, 1.0F - (7 * f), (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (8 * f), 1.0F, 1.0F - (8 * f), (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (9 * f), 1.0F, 1.0F - (9 * f), (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (10 * f), 1.0F, 1.0F - (10 * f), (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (11 * f), 1.0F, 1.0F - (11 * f), (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (12 * f), 1.0F, 1.0F - (12 * f), (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (13 * f), 1.0F, 1.0F - (13 * f), (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (14 * f), 1.0F, 1.0F - (14 * f), (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (15 * f), 1.0F, 1.0F - (15 * f), (16 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - f, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}
		else if(flag[CTHelper.tSWrsw])
		{
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, f, 1.0F, 1.0F - f, (2 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (2 * f), 1.0F, 1.0F - (2 * f), (3 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (3 * f), 1.0F, 1.0F - (3 * f), (4 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (4 * f), 1.0F, 1.0F - (4 * f), (5 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (5 * f), 1.0F, 1.0F - (5 * f), (6 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (6 * f), 1.0F, 1.0F - (6 * f), (7 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (7 * f), 1.0F, 1.0F - (7 * f), (8 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (8 * f), 1.0F, 1.0F - (8 * f), (9 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (9 * f), 1.0F, 1.0F - (9 * f), (10 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (10 * f), 1.0F, 1.0F - (10 * f), (11 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (11 * f), 1.0F, 1.0F - (11 * f), (12 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (12 * f), 1.0F, 1.0F - (12 * f), (13 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (13 * f), 1.0F, 1.0F - (13 * f), (14 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (14 * f), 1.0F, 1.0F - (14 * f), (15 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, (15 * f), 1.0F, 1.0F - (15 * f), (16 * f));
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, f, 1.0F - (15 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds(f, 0.0F, 0.0F, (2 * f), 1.0F - (14 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 2), 0.0F, 0.0F, (3 * f), 1.0F - (13 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 3), 0.0F, 0.0F, (4 * f), 1.0F - (12 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 4), 0.0F, 0.0F, (5 * f), 1.0F - (11 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 5), 0.0F, 0.0F, (6 * f), 1.0F - (10 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 6), 0.0F, 0.0F, (7 * f), 1.0F - (9 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 7), 0.0F, 0.0F, (8 * f), 1.0F - (8 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 8), 0.0F, 0.0F, (9 * f), 1.0F - (7 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 9), 0.0F, 0.0F, (10 * f), 1.0F - (6 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 10), 0.0F, 0.0F, (11 * f), 1.0F - (5 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 11), 0.0F, 0.0F, (12 * f), 1.0F - (4 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 12), 0.0F, 0.0F, (13 * f), 1.0F - (3 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 13), 0.0F, 0.0F, (14 * f), 1.0F - (2 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 14), 0.0F, 0.0F, (15 * f), 1.0F - (1 * f), 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			renderer.setRenderBounds((f * 15), 0.0F, 0.0F, (16 * f), 1.0F, 1.0F);
			renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
			return true;
		}

		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelID)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.renderTrailID;
	}
}