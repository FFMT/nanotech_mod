package fr.mcnanotech.kevin_68.nanotech_mod.items;
 
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
 
public class Item_mysteriousarmor extends ItemArmor implements IArmorTextureProvider
{
 
        public Item_mysteriousarmor(int par1,EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
        {
            super(par1, par2EnumArmorMaterial, par3, par4);
            MinecraftForge.EVENT_BUS.register(this);
        }
        
        @SideOnly(Side.CLIENT)
        public EnumRarity getRarity(ItemStack par1ItemStack)
        {
            return EnumRarity.epic;
        }
 
        public String getTextureFile(){
                return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
               
        }
 
        public String getArmorTextureFile(ItemStack par1)
        {
                if ( par1.itemID==Nanotech_mod.Item_mysterioushelmet.itemID|| par1.itemID==Nanotech_mod.Item_mysteriouschestplate.itemID||par1.itemID==Nanotech_mod.Item_mysteriousboots.itemID)
                {
                   return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Mysteriousarmor.png";
                }
                if(par1.itemID==Nanotech_mod.Item_mysteriousleggins.itemID)
                {
                   return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Mysteriousarmor2.png";
                }
                return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Mysteriousarmor.png";
        }      
        
    	@ForgeSubscribe
    	public void livingFall(LivingFallEvent event)
    	{
    	
        if ((event.entity instanceof EntityPlayer))
        {
        	EntityPlayer player = (EntityPlayer)event.entity;
        	ItemStack armorb = player.inventory.armorInventory[0];
       	
        	if ((armorb != null) && (armorb.getItem() == Nanotech_mod.Item_mysteriousboots))
        	{
        		if (!(event.entityLiving instanceof EntityPlayer)) return;
        		EntityPlayer eventPlayer = (EntityPlayer)event.entityLiving;
        		event.distance = 0F;
        	}
        }
    	}
}