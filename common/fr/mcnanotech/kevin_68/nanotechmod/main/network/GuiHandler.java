/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiLightSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiMultiplier;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.gui.GuiSmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerLightSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerMultiplier;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityListerJukebox;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityMultiplier;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getTileEntity(x, y, z);
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
		if(tileentity instanceof TileEntityPortableChest)
		{
			return new ContainerPortableChest((TileEntityPortableChest)tileentity, player.inventory, world);
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
		TileEntity tileentity = world.getTileEntity(x, y, z);

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
		if(tileentity instanceof TileEntityPortableChest)
		{
			return new GuiPortableChest(player.inventory, (TileEntityPortableChest)tileentity, world);
		}
		if(id == 10)
		{
			return new GuiLightSaber(player);
		}
		return null;
	}
}