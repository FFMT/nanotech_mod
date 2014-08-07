package fr.mcnanotech.kevin_68.nanotechmod.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.core.NanotechMod;

public class ItemBlockLamp extends ItemBlock
{
    private IIcon itemBlockIcon;

    public ItemBlockLamp(Block block)
    {
        super(block);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getSpriteNumber()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata)
    {
        return itemBlockIcon;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemBlockIcon = iconRegister.registerIcon(NanotechMod.MODID + ":lamp");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
        if(player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack) && player.canPlayerEdit(x, y + 2, z, side, stack) && player.canPlayerEdit(x, y + 3, z, side, stack))
        {
            Block i1 = world.getBlock(x, y, z);
            boolean isReplaceable = (i1 == Blocks.vine || i1 == Blocks.tallgrass || i1 == Blocks.deadbush || (i1 != null & i1.isReplaceable(world, x, y, z)));

            if(isReplaceable && world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 4, z))
            {
                world.setBlock(x, y, z, NTMBlocks.lamp, 0, 3);
                world.setBlock(x, y + 1, z, NTMBlocks.lamp, 1, 3);
                world.setBlock(x, y + 2, z, NTMBlocks.lamp, 1, 3);
                world.setBlock(x, y + 3, z, NTMBlocks.lamp, 2, 3);

                world.playSoundEffect(x, y, z, NTMBlocks.lamp.stepSound.soundName, NTMBlocks.lamp.stepSound.getVolume(), NTMBlocks.lamp.stepSound.getPitch());
                --stack.stackSize;
                return true;

            }
            if(world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.isAirBlock(x, y + 3, z) && world.isAirBlock(x, y + 4, z) && side == 1 && player.canPlayerEdit(x, y + 4, z, side, stack))
            {
                world.setBlock(x, y + 1, z, NTMBlocks.lamp, 0, 3);
                world.setBlock(x, y + 2, z, NTMBlocks.lamp, 1, 3);
                world.setBlock(x, y + 3, z, NTMBlocks.lamp, 1, 3);
                world.setBlock(x, y + 4, z, NTMBlocks.lamp, 2, 3);

                world.playSoundEffect(x, y, z, NTMBlocks.lamp.stepSound.soundName, NTMBlocks.lamp.stepSound.getVolume(), NTMBlocks.lamp.stepSound.getPitch());
                --stack.stackSize;
                return true;
            }
        }
        return false;
    }
}