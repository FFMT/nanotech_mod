package fr.mcnanotech.kevin_68.nanotech_mod.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.client.gui.GuiJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.client.gui.GuiMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.client.gui.GuiSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.container.ContainerMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.tileentity.TileEntitySmoker;

public class UtilGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if(tileentity instanceof TileEntityJumper)
		{
			return new ContainerJumper((TileEntityJumper) tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntitySmoker)
		{
			return new ContainerSmoker((TileEntitySmoker) tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntityMultiplier)
		{
			return new ContainerMultiplier((TileEntityMultiplier) tileentity, player.inventory, world);
		}
                   
		return null;
		}
           
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
                   
		if(tileentity instanceof TileEntityJumper)
		{
			return new GuiJumper(player.inventory, (TileEntityJumper) tileentity, world);
		}
		if(tileentity instanceof TileEntitySmoker)
		{
			return new GuiSmoker(player.inventory, (TileEntitySmoker) tileentity, world);
		}
		if(tileentity instanceof TileEntityMultiplier)
		{
			return new GuiMultiplier(player.inventory, (TileEntityMultiplier) tileentity, world);
		}
           
		return null;
	}
}