/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.ClientProxy;

public class BlockCerealRender implements ISimpleBlockRenderingHandler
{
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        float f = 0.0625F, f2 = (3 * f) / 4;
        Tessellator tessellator = Tessellator.instance;

        if(metadata == 0)
        {
            renderer.setRenderBounds(6 * f, 0.0F, 2 * f, 10 * f, 1.0F - (2 * f), 1.0F - (2 * f));
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
        else if(metadata == 1)
        {
            renderer.setRenderBounds(2 * f, 0.0F, 6 * f, 1.0F - (2 * f), 1.0F - (2 * f), 10 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
        else
        {
            renderer.setRenderBounds(6 * f, 0, 6 * f, 10 * f, f, 10 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(6 * f, f, 5 * f, 10 * f, 2 * f, 6 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 * f, f, 6 * f, 6 * f, 2 * f, 10 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(6 * f, f, 10 * f, 10 * f, 2 * f, 11 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(10 * f, f, 6 * f, 11 * f, 2 * f, 10 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 * f, 2 * f, 4 * f, 11 * f, 3 * f, 5 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(11 * f, 2 * f, 5 * f, 12 * f, 3 * f, 11 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(4 * f, 2 * f, 5 * f, 5 * f, 3 * f, 11 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 * f, 2 * f, 11 * f, 11 * f, 3 * f, 12 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 * f, 2 * f, 5 * f, 6 * f, 3 * f, 6 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 * f, 2 * f, 10 * f, 6 * f, 3 * f, 11 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(10 * f, 2 * f, 10 * f, 11 * f, 3 * f, 11 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(10 * f, 2 * f, 5 * f, 11 * f, 3 * f, 6 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(4 * f, 3 * f, 4 * f, 5 * f, 4 * f, 12 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(4 * f, 3 * f, 4 * f, 12 * f, 4 * f, 5 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 * f, 3 * f, 11 * f, 12 * f, 4 * f, 12 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(11 * f, 3 * f, 5 * f, 12 * f, 4 * f, 12 * f);
            this.renderInInventory(tessellator, renderer, block, metadata);

            if(metadata == 3 || metadata == 9)
            {
                renderer.setRenderBounds(6 * f, f + f2, 6 * f, 10 * f, f + f2, 10 * f);
                this.renderInInventory(tessellator, renderer, block, metadata);
            }
            else if(metadata == 4 || metadata == 8)
            {
                renderer.setRenderBounds(5 * f, f + (2 * f2), 5 * f, 11 * f, f + (2 * f2), 11 * f);
                this.renderInInventory(tessellator, renderer, block, metadata);
            }
            else if(metadata == 5 || metadata == 7)
            {
                renderer.setRenderBounds(5 * f, f + (3 * f2), 5 * f, 11 * f, f + (3 * f2), 11 * f);
                this.renderInInventory(tessellator, renderer, block, metadata);
            }
            else if(metadata == 6)
            {
                renderer.setRenderBounds(5 * f, f + (4 * f2), 5 * f, 11 * f, f + (4 * f2), 11 * f);
                this.renderInInventory(tessellator, renderer, block, metadata);
            }
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        float f = 0.0625F, f2 = (3 * f) / 4;

        if(world.getBlockMetadata(x, y, z) == 0)
        {
            renderer.setRenderBounds(6 * f, 0.0F, 2 * f, 10 * f, 1.0F - (2 * f), 1.0F - (2 * f));
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            return true;
        }
        else if(world.getBlockMetadata(x, y, z) == 1)
        {
            renderer.setRenderBounds(2 * f, 0.0F, 6 * f, 1.0F - (2 * f), 1.0F - (2 * f), 10 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            return true;
        }
        else
        {
            renderer.setRenderBounds(6 * f, 0, 6 * f, 10 * f, f, 10 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(6 * f, f, 5 * f, 10 * f, 2 * f, 6 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(5 * f, f, 6 * f, 6 * f, 2 * f, 10 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(6 * f, f, 10 * f, 10 * f, 2 * f, 11 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(10 * f, f, 6 * f, 11 * f, 2 * f, 10 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(5 * f, 2 * f, 4 * f, 11 * f, 3 * f, 5 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(11 * f, 2 * f, 5 * f, 12 * f, 3 * f, 11 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(4 * f, 2 * f, 5 * f, 5 * f, 3 * f, 11 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(5 * f, 2 * f, 11 * f, 11 * f, 3 * f, 12 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(5 * f, 2 * f, 5 * f, 6 * f, 3 * f, 6 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(5 * f, 2 * f, 10 * f, 6 * f, 3 * f, 11 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(10 * f, 2 * f, 10 * f, 11 * f, 3 * f, 11 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(10 * f, 2 * f, 5 * f, 11 * f, 3 * f, 6 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(4 * f, 3 * f, 4 * f, 5 * f, 4 * f, 12 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(4 * f, 3 * f, 4 * f, 12 * f, 4 * f, 5 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(5 * f, 3 * f, 11 * f, 12 * f, 4 * f, 12 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
            renderer.setRenderBounds(11 * f, 3 * f, 5 * f, 12 * f, 4 * f, 12 * f);
            renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);

            if(world.getBlockMetadata(x, y, z) == 3 || world.getBlockMetadata(x, y, z) == 9)
            {
                renderer.setRenderBounds(6 * f, f + f2, 6 * f, 10 * f, f + f2, 10 * f);
                renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
                return true;
            }
            else if(world.getBlockMetadata(x, y, z) == 4 || world.getBlockMetadata(x, y, z) == 8)
            {
                renderer.setRenderBounds(5 * f, f + (2 * f2), 5 * f, 11 * f, f + (2 * f2), 11 * f);
                renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
                return true;
            }
            else if(world.getBlockMetadata(x, y, z) == 5 || world.getBlockMetadata(x, y, z) == 7)
            {
                renderer.setRenderBounds(5 * f, f + (3 * f2), 5 * f, 11 * f, f + (3 * f2), 11 * f);
                renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
                return true;
            }
            else if(world.getBlockMetadata(x, y, z) == 6)
            {
                renderer.setRenderBounds(5 * f, f + (4 * f2), 5 * f, 11 * f, f + (4 * f2), 11 * f);
                renderer.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
                return true;
            }

            return true;
        }
    }

    private void renderInInventory(Tessellator tessellator, RenderBlocks renderer, Block block, int metadata)
    {
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return ClientProxy.renderCerealID;
    }
}