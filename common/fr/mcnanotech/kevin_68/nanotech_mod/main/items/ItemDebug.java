package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySunShade;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;

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
			player.addChatMessage(FFMTColor.gray + "-----------------------------------------------------");
			player.addChatMessage("Name: " + FFMTColor.aqua + Block.blocksList[world.getBlockId(x, y, z)].getLocalizedName());
			player.addChatMessage("Coords: X:" + FFMTColor.aqua + String.valueOf(x) + FFMTColor.white + " Y:" + FFMTColor.aqua + String.valueOf(y) + FFMTColor.white + " Z:" + FFMTColor.aqua + String.valueOf(z));
			player.addChatMessage("Metadata : " + FFMTColor.aqua + String.valueOf(world.getBlockMetadata(x, y, z)));
			player.addChatMessage("Side: " + side);
			if(tile != null)
			{
				if(tile instanceof TileEntityJumper)
				{
					TileEntityJumper te = (TileEntityJumper)tile;
					player.addChatMessage("Power: " + FFMTColor.aqua + String.valueOf(te.getJumpHeightValue()));
					player.addChatMessage("Advanced: " + FFMTColor.aqua + String.valueOf(te.getBlockMetadata() == 1 ? "true" : "false"));
					return true;
				}

				if(tile instanceof TileEntityMultiplier)
				{
					TileEntityMultiplier te = (TileEntityMultiplier)tile;
					player.addChatMessage(FFMTColor.red + "Cheating block!");
					return true;
				}

				if(tile instanceof TileEntitySmoker)
				{
					TileEntitySmoker te = (TileEntitySmoker)tile;
					player.addChatMessage("Power: " + FFMTColor.aqua + String.valueOf(te.getSmokeValue()));
					return true;
				}

				if(tile instanceof TileEntityFountain)
				{
					TileEntityFountain te = (TileEntityFountain)tile;
					player.addChatMessage("Height: " + FFMTColor.aqua + String.valueOf(te.getHeight()));
					player.addChatMessage("Width: " + FFMTColor.aqua + String.valueOf(te.getWidth()));
					player.addChatMessage("Rotate: " + FFMTColor.aqua + String.valueOf(te.getRotate()));
					player.addChatMessage("Animated: " + FFMTColor.aqua + String.valueOf(te.getAnimated()));
					return true;
				}

				if(tile instanceof TileEntityLampLight)
				{
					TileEntityLampLight te = (TileEntityLampLight)tile;
					player.addChatMessage("Light: " + FFMTColor.aqua + String.valueOf(te.getBlockMetadata() == 0 ? "true" : "false"));
					return true;
				}

				if(tile instanceof TileEntitySpotLight)
				{
					TileEntitySpotLight te = (TileEntitySpotLight)tile;
					player.addChatMessage("Powered: " + FFMTColor.aqua + String.valueOf(te.isActive));
					player.addChatMessage("Reverse: " + FFMTColor.aqua + String.valueOf(te.isReverse));
					player.addChatMessage("Red: " + FFMTColor.aqua + String.valueOf(te.red));
					player.addChatMessage("Green: " + FFMTColor.aqua + String.valueOf(te.green));
					player.addChatMessage("Blue: " + FFMTColor.aqua + String.valueOf(te.blue));
					player.addChatMessage("Darkred: " + FFMTColor.aqua + String.valueOf(te.darkRed));
					player.addChatMessage("Darkgreen: " + FFMTColor.aqua + String.valueOf(te.darkGreen));
					player.addChatMessage("Darkblue: " + FFMTColor.aqua + String.valueOf(te.darkBlue));
					return true;
				}

				if(tile instanceof TileEntitySunShade)
				{
					TileEntitySunShade te = (TileEntitySunShade)tile;
					player.addChatMessage("Open: " + FFMTColor.aqua + te.getIsOpen());
					return true;
				}
			}
		}
		return false;
	}

	public void registerIcons(IconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotech_mod:itemDebug");
	}
}