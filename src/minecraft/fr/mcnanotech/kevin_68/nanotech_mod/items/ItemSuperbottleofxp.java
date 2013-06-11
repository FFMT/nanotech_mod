package fr.mcnanotech.kevin_68.nanotech_mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.others.EntitySuperBottleOfXp;

public class ItemSuperbottleofxp extends Item
{
    public ItemSuperbottleofxp(int par1)
    {
        super(par1);
        this.setCreativeTab(Nanotech_mod.CREATIVE_TAB_I);
    }
    
	public String getTextureFile()
    {
            return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if (!par3EntityPlayer.isSneaking())
    	{
    		if (!par3EntityPlayer.capabilities.isCreativeMode)
        	{
    			--par1ItemStack.stackSize;
        	}

        	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        	if (!par2World.isRemote)
        	{
        		par2World.spawnEntityInWorld(new EntitySuperBottleOfXp(par2World, par3EntityPlayer));
        	}
    	}
        return par1ItemStack;
    }
}
