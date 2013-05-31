package fr.mcnanotech.kevin_68.nanotech_mod.items;
 
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
 
public class Item_nanomitearmor extends ItemArmor implements IArmorTextureProvider
{
 
        public Item_nanomitearmor(int par1,EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
        {
            super(par1, par2EnumArmorMaterial, par3, par4);
        }
        
        public String getTextureFile(){
                return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
               
        }
 
        public String getArmorTextureFile(ItemStack par1)
        {
                if ( par1.itemID==Nanotech_mod.Item_nanomitehelmet.itemID|| par1.itemID==Nanotech_mod.Item_nanomitechestplate.itemID||par1.itemID==Nanotech_mod.Item_nanomiteboots.itemID)
                {
                   return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor.png";
                }
                if(par1.itemID==Nanotech_mod.Item_nanomiteleggins.itemID)
                {
                   return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor2.png";
                }
                return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor.png";
        }      
}