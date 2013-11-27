package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntityTrashCanRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.core.ClientProxy;

public class TrashCanRender implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		TileEntityTrashCanRender.INSTANCE.renderTileEntityTrashCanAt(null, -0.5, -0.5, -0.5, 0.0F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.trashCanRenderId;
	}
}