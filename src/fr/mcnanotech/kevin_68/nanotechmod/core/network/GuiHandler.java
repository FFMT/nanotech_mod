package fr.mcnanotech.kevin_68.nanotechmod.core.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.gui.GuiSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity instanceof TileEntitySpotLight)
		{
			return new ContainerSpotLight((TileEntitySpotLight)tileentity, player.inventory, world);
		}

		return null;

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity instanceof TileEntitySpotLight)
		{
			return new GuiSpotLight(player.inventory, (TileEntitySpotLight)tileentity, world);
		}
		
		return null;
	}
}