package fr.mcnanotech.kevin_68.nanotech_mod.items;
 
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
 
public class Item_nanomitearmor extends ItemArmor implements IArmorTextureProvider
{
	public Item_nanomitearmor(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(id, par2EnumArmorMaterial, par3, par4);
	}
        
	public String getTextureFile()
	{
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/items.png";
	}
 
	public String getArmorTextureFile(ItemStack stack)
	{
		if(stack.itemID == NanotechItem.Nanomitehelmet.itemID || stack.itemID == NanotechItem.Nanomitechestplate.itemID || stack.itemID == NanotechItem.Nanomiteboots.itemID)
		{
			return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor.png";
		}
		if(stack.itemID == NanotechItem.Nanomiteleggins.itemID)
		{
			return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor2.png";
		}
		return "/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/armor/Nanomitearmor.png";
	}      
}