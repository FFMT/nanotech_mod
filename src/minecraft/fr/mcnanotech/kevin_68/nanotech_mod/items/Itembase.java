package fr.mcnanotech.kevin_68.nanotech_mod.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class Itembase extends Item
{
    public Itembase(int i)
    {
        super(i);
        maxStackSize = 64;
        this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);

    }
    public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
    }
    
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	if (stack.itemID == NanotechItem.Vide.itemID)
    	{
            list.add("Item pour barrel vide");
            list.add("100% cobblestone");
            list.add("100% recyclable");
    	}
    }
}