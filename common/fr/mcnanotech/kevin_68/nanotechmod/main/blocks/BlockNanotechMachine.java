/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.FakePlayer;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.minecraftforgefrance.ffmtlibs.FFMTClientRegistry;

public class BlockNanotechMachine extends Block
{
    public static String[] subName = new String[] {"portableChest"};

    protected BlockNanotechMachine(Material material)
    {
        super(material);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(metadata == 0)
        {
            return Blocks.chest.getBlockTextureFromSide(0);
        }
        return blockIcon;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for(int metadatanumber = 0; metadatanumber < subName.length; metadatanumber++)
        {
            list.add(new ItemStack(item, 1, metadatanumber));
        }
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return FFMTClientRegistry.tesrRenderId;
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        switch(metadata)
        {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        switch(metadata)
        {
            case 0:
                return new TileEntityPortableChest();
            default:
                return null;
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        if(metadata == 0)
        {
            ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
            ItemStack chestStack = new ItemStack(this, 1, 0);
            TileEntity te = world.getTileEntity(x, y, z);
            if(te != null && te instanceof TileEntityPortableChest)
            {
                TileEntityPortableChest teChest = (TileEntityPortableChest)te;
                NBTTagCompound nbttag = new NBTTagCompound();

                NBTTagList nbttaglist = new NBTTagList();
                for(int i = 0; i < teChest.inventory.length; i++)
                {
                    if(teChest.inventory[i] != null)
                    {
                        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                        nbttagcompound1.setByte("Slot", (byte)i);
                        teChest.inventory[i].writeToNBT(nbttagcompound1);
                        nbttaglist.appendTag(nbttagcompound1);
                    }
                }

                nbttag.setTag("Items", nbttaglist);
                chestStack.setTagCompound(nbttag);

                if(teChest.hasCustomInventoryName())
                {
                    chestStack.setStackDisplayName(teChest.getCustomGuiName());
                }
            }
            ret.add(chestStack);
            return ret;
        }
        else
        {
            return super.getDrops(world, x, y, z, metadata, fortune);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        FMLNetworkHandler.openGui(player, NanotechMod.modInstance, 1, world, x, y, z);
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;

        if(stack.getItemDamage() == 0)
        {
            TileEntity te = world.getTileEntity(x, y, z);
            if(te != null && te instanceof TileEntityPortableChest)
            {
                TileEntityPortableChest teChest = (TileEntityPortableChest)te;
                teChest.setDirection((byte)direction);

                if(stack.hasTagCompound())
                {
                    if(stack.hasDisplayName())
                    {
                        teChest.setCustomGuiName(stack.getDisplayName());
                    }

                    NBTTagList nbttaglist = stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND);
                    for(int i = 0; i < nbttaglist.tagCount(); i++)
                    {
                        NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(i);
                        int j = nbttagcompound1.getByte("Slot");

                        if(j >= 0 && j < teChest.inventory.length)
                        {
                            teChest.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
                        }
                    }
                }
            }
        }
        world.markBlockForUpdate(x, y, z);
    }

    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z)
    {
        if(!world.isRemote && !player.capabilities.isCreativeMode && world.getBlockMetadata(x, y, z) == 0)
        {
            player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
            player.addExhaustion(0.025F);
            int i1 = EnchantmentHelper.getFortuneModifier(player);
            if(!player.getCommandSenderName().contains("[") || !(player instanceof FakePlayer))
            {
                ArrayList<ItemStack> items = getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), i1);
                for(ItemStack is : items)
                {
                    this.dropBlockAsItem(world, x, y, z, is);
                }
            }
        }
        world.setBlockToAir(x, y, z);
        return true;
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int side)
    {}

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        super.breakBlock(world, x, y, z, block, metadata);
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        if(world.getBlockMetadata(x, y, z) == 0)
        {
            ItemStack chestStack = new ItemStack(this, 1, 0);
            TileEntity te = world.getTileEntity(x, y, z);
            if(te != null && te instanceof TileEntityPortableChest)
            {
                TileEntityPortableChest teChest = (TileEntityPortableChest)te;
                NBTTagCompound nbttag = new NBTTagCompound();

                NBTTagList nbttaglist = new NBTTagList();
                for(int i = 0; i < teChest.inventory.length; i++)
                {
                    if(teChest.inventory[i] != null)
                    {
                        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                        nbttagcompound1.setByte("Slot", (byte)i);
                        teChest.inventory[i].writeToNBT(nbttagcompound1);
                        nbttaglist.appendTag(nbttagcompound1);
                    }
                }

                nbttag.setTag("Items", nbttaglist);
                chestStack.setTagCompound(nbttag);

                if(teChest.hasCustomInventoryName())
                {
                    chestStack.setStackDisplayName(teChest.getCustomGuiName());
                }
            }
            return chestStack;
        }
        else
        {
            return super.getPickBlock(target, world, x, y, z);
        }
    }

    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventValue)
    {
        super.onBlockEventReceived(world, x, y, z, eventId, eventValue);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null ? tileentity.receiveClientEvent(eventId, eventValue) : false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iiconRegister)
    {
        // Empty
    }
}