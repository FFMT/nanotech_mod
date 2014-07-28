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
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockNanoStairs extends BlockStairs
{
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