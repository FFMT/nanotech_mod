package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
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
	public ItemDebug(int id)
	{
		super(id);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if(!world.isRemote)
		{
			player.addChatMessage(EnumChatFormatting.GRAY + "-----------------------------------------------------");
			player.addChatMessage("Name: " + EnumChatFormatting.AQUA + Block.blocksList[world.getBlockId(x, y, z)].getLocalizedName());
			player.addChatMessage("Coords: X:" + EnumChatFormatting.AQUA + String.valueOf(x) + EnumChatFormatting.WHITE + " Y:" + EnumChatFormatting.AQUA + String.valueOf(y) + EnumChatFormatting.WHITE + " Z:" + EnumChatFormatting.AQUA + String.valueOf(z));
			player.addChatMessage("Metadata : " + EnumChatFormatting.AQUA + String.valueOf(world.getBlockMetadata(x, y, z)));
			player.addChatMessage("Side: " + side);
			if(tile != null)
			{
				if(tile instanceof TileEntityJumper)
				{
					TileEntityJumper te = (TileEntityJumper)tile;
					player.addChatMessage("Power: " + EnumChatFormatting.AQUA + String.valueOf(te.getJumpHeightValue()));
					player.addChatMessage("Advanced: " + EnumChatFormatting.AQUA + String.valueOf(te.getBlockMetadata() == 1 ? "true" : "false"));
					return true;
				}

				if(tile instanceof TileEntityMultiplier)
				{
					TileEntityMultiplier te = (TileEntityMultiplier)tile;
					player.addChatMessage(EnumChatFormatting.RED + "Cheating block!");
					return true;
				}

				if(tile instanceof TileEntitySmoker)
				{
					TileEntitySmoker te = (TileEntitySmoker)tile;
					player.addChatMessage("Power: " + EnumChatFormatting.AQUA + String.valueOf(te.getSmokeValue()));
					return true;
				}

				if(tile instanceof TileEntityFountain)
				{
					TileEntityFountain te = (TileEntityFountain)tile;
					player.addChatMessage("Height: " + EnumChatFormatting.AQUA + String.valueOf(te.getHeight()));
					player.addChatMessage("Width: " + EnumChatFormatting.AQUA + String.valueOf(te.getWidth()));
					player.addChatMessage("Rotate: " + EnumChatFormatting.AQUA + String.valueOf(te.getRotate()));
					player.addChatMessage("Animated: " + EnumChatFormatting.AQUA + String.valueOf(te.getAnimated()));
					return true;
				}

				if(tile instanceof TileEntityLampLight)
				{
					TileEntityLampLight te = (TileEntityLampLight)tile;
					player.addChatMessage("Light: " + EnumChatFormatting.AQUA + String.valueOf(te.getBlockMetadata() == 0 ? "true" : "false"));
					return true;
				}

				if(tile instanceof TileEntitySpotLight)
				{
					TileEntitySpotLight te = (TileEntitySpotLight)tile;
					for(int i = 0; i < 120; i += 2)
					player.addChatMessage("HasKey: " + i + EnumChatFormatting.AQUA + String.valueOf(te.hasKey(i)) + EnumChatFormatting.WHITE + "  HasKey: " + (i + 1) + EnumChatFormatting.AQUA + String.valueOf(te.hasKey(i + 1)));
					return true;
				}

				if(tile instanceof TileEntitySunShade)
				{
					TileEntitySunShade te = (TileEntitySunShade)tile;
					player.addChatMessage("Open: " + EnumChatFormatting.AQUA + te.getIsOpen());
					return true;
				}
				
				if(tile instanceof TileEntityPortableChest)
				{
					TileEntityPortableChest te = (TileEntityPortableChest)tile;
					player.addChatMessage("Direction: " + te.getDirection());
				}
			}
		}
		return false;
	}

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotechmod:itemDebug");
	}
}