package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.gui.GuiFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.gui.GuiSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.gui.GuiTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.container.ContainerTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity instanceof TileEntitySpotLight)
		{
			return new ContainerSpotLight((TileEntitySpotLight)tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntityFountain)
		{
			return new ContainerFountain((TileEntityFountain)tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntityTextSpotLight)
		{
			return new ContainerTextSpotLight((TileEntityTextSpotLight)tileentity, player.inventory, world);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity instanceof TileEntitySpotLight)
		{
			return new GuiSpotLight(player.inventory, (TileEntitySpotLight)tileentity, world);
		}
		if(tileentity instanceof TileEntityFountain)
		{
			return new GuiFountain(player.inventory, (TileEntityFountain)tileentity, world);
		}
		if(tileentity instanceof TileEntityTextSpotLight)
		{
			return new GuiTextSpotLight(player.inventory, (TileEntityTextSpotLight)tileentity, world);
		}

		return null;
	}
}