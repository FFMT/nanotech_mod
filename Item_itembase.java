package fr.mcnanotech.kevin_68.nanotech_mod;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Item_itembase extends Item
{
	boolean vide;
    public Item_itembase(int i, boolean b)
    {
        super(i);
        maxStackSize = 64;
        this.vide = b;
        this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);

    }
    public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
    }
    
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if (vide)
    	{
            par3List.add("Item pour barrel vide");
            par3List.add("100% cobblestone");
            par3List.add("100% recyclable");
    	}
    }
}