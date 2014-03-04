/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.CommonProxy;

public class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		FMLCommonHandler.instance().bus().register(new USGClientEventHandler());
	}

	@Override
	public EntityPlayer getPlayerInstance()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
}