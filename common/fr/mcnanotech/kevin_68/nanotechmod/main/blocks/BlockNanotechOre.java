/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNanotechOre extends Block
{
    public static String[] type = new String[] {"silicon", "decrease"};
    public IIcon[] iconbuffer;

    public BlockNanotechOre()
    {
        super(Material.rock);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconregister)
    {
        iconbuffer = new IIcon[type.length];
        for(int i = 0; i < type.length; i++)
        {
            iconbuffer[i] = iconregister.registerIcon(this.getTextureName() + type[i] + "ore");
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata < type.length)
        {
            return iconbuffer[metadata];
        }
        else
        {
            return iconbuffer[0];
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
        {
            list.add(new ItemStack(item, 1, metadatanumber));
        }
    }

    @Override
    public int damageDropped(int metadata)
    {
        return metadata;
    }
}