 package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;

public class ItemLamp extends Item
{
	public ItemLamp(int id)
	{
		super(id);
	}

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("Nanotech_mod:itemLamp");
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if (par7 != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(x, y, z, par7, stack) && player.canPlayerEdit(x, y + 1, z, par7, stack))
        {
            int i1 = world.getBlockId(x, y, z);

            if (world.isAirBlock(x, y + 1, z))
            {
                world.setBlock(x, y + 1, z, NanotechBlock.BlockLamp.blockID, 0, 1);
                world.setBlock(x, y + 2, z, NanotechBlock.BlockLamp.blockID, 1, 1);
                world.setBlock(x, y + 3, z, NanotechBlock.BlockLamp.blockID, 1, 1);
                world.setBlock(x, y + 4, z, NanotechBlock.BlockLamp.blockID, 2, 1);
                --stack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
	}
}
