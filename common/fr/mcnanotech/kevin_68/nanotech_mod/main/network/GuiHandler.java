package fr.mcnanotech.kevin_68.nanotech_mod.main.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiLightSaber;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiListerJukebox;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerLightSaber;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityListerJukebox;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntitySmoker;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if(tileentity instanceof TileEntityJumper)
		{
			return new ContainerJumper((TileEntityJumper)tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntitySmoker)
		{
			return new ContainerSmoker((TileEntitySmoker)tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntityMultiplier)
		{
			return new ContainerMultiplier((TileEntityMultiplier)tileentity, player.inventory, world);
		}
		if(tileentity instanceof TileEntityListerJukebox)
		{
			return new ContainerListerJukebox((TileEntityListerJukebox)tileentity, player.inventory, world);
		}
		if(id == 10)
		{
			return new ContainerLightSaber(player.inventory, player.worldObj);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);

		if(tileentity instanceof TileEntityJumper)
		{
			return new GuiJumper(player.inventory, (TileEntityJumper)tileentity, world);
		}
		if(tileentity instanceof TileEntitySmoker)
		{
			return new GuiSmoker(player.inventory, (TileEntitySmoker)tileentity, world);
		}
		if(tileentity instanceof TileEntityMultiplier)
		{
			return new GuiMultiplier(player.inventory, (TileEntityMultiplier)tileentity, world);
		}
		if(tileentity instanceof TileEntityListerJukebox)
		{
			return new GuiListerJukebox(player.inventory, (TileEntityListerJukebox)tileentity, world);
		}
		if(id == 10)
		{
			return new GuiLightSaber(player);
		}
		return null;
	}
}