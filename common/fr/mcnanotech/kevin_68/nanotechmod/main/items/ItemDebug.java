package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySunShade;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;

public class ItemDebug extends Item
{
	public ItemDebug()
	{
		super();
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		if(!world.isRemote)
		{
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "-----------------------------------------------------"));
			player.addChatMessage(new ChatComponentText("Name: " + EnumChatFormatting.AQUA + world.getBlock(x, y, z).getLocalizedName()));
			player.addChatMessage(new ChatComponentText("Coords: X:" + EnumChatFormatting.AQUA + String.valueOf(x) + EnumChatFormatting.WHITE + " Y:" + EnumChatFormatting.AQUA + String.valueOf(y) + EnumChatFormatting.WHITE + " Z:" + EnumChatFormatting.AQUA + String.valueOf(z)));
			player.addChatMessage(new ChatComponentText("Metadata : " + EnumChatFormatting.AQUA + String.valueOf(world.getBlockMetadata(x, y, z))));
			player.addChatMessage(new ChatComponentText("Side: " + side));
			if(tile != null)
			{
				if(tile instanceof TileEntityJumper)
				{
					TileEntityJumper te = (TileEntityJumper)tile;
					player.addChatMessage(new ChatComponentText("Power: " + EnumChatFormatting.AQUA + String.valueOf(te.getJumpHeightValue())));
					player.addChatMessage(new ChatComponentText("Advanced: " + EnumChatFormatting.AQUA + String.valueOf(te.getBlockMetadata() == 1 ? "true" : "false")));
					return true;
				}

				if(tile instanceof TileEntityMultiplier)
				{
					TileEntityMultiplier te = (TileEntityMultiplier)tile;
					player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Cheating block!"));
					return true;
				}

				if(tile instanceof TileEntitySmoker)
				{
					TileEntitySmoker te = (TileEntitySmoker)tile;
					player.addChatMessage(new ChatComponentText("Power: " + EnumChatFormatting.AQUA + String.valueOf(te.getSmokeValue())));
					return true;
				}

				if(tile instanceof TileEntityFountain)
				{
					TileEntityFountain te = (TileEntityFountain)tile;
					player.addChatMessage(new ChatComponentText("Height: " + EnumChatFormatting.AQUA + String.valueOf(te.getHeight())));
					player.addChatMessage(new ChatComponentText("Width: " + EnumChatFormatting.AQUA + String.valueOf(te.getWidth())));
					player.addChatMessage(new ChatComponentText("Rotate: " + EnumChatFormatting.AQUA + String.valueOf(te.getRotate())));
					player.addChatMessage(new ChatComponentText("Animated: " + EnumChatFormatting.AQUA + String.valueOf(te.getAnimated())));
					return true;
				}

				if(tile instanceof TileEntityLampLight)
				{
					TileEntityLampLight te = (TileEntityLampLight)tile;
					player.addChatMessage(new ChatComponentText("Light: " + EnumChatFormatting.AQUA + String.valueOf(te.getBlockMetadata() == 0 ? "true" : "false")));
					return true;
				}

				if(tile instanceof TileEntitySpotLight)
				{
					TileEntitySpotLight te = (TileEntitySpotLight)tile;
					for(int i = 0; i < 120; i += 2)
						player.addChatMessage(new ChatComponentText("HasKey: " + i + EnumChatFormatting.AQUA + String.valueOf(te.hasKey(i)) + EnumChatFormatting.WHITE + "  HasKey: " + (i + 1) + EnumChatFormatting.AQUA + String.valueOf(te.hasKey(i + 1))));
					return true;
				}

				if(tile instanceof TileEntitySunShade)
				{
					TileEntitySunShade te = (TileEntitySunShade)tile;
					player.addChatMessage(new ChatComponentText("Open: " + EnumChatFormatting.AQUA + te.getIsOpen()));
					return true;
				}

				if(tile instanceof TileEntityPortableChest)
				{
					TileEntityPortableChest te = (TileEntityPortableChest)tile;
					player.addChatMessage(new ChatComponentText("Direction: " + te.getDirection()));
				}
			}
		}
		return false;
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotechmod:itemDebug");
	}
}