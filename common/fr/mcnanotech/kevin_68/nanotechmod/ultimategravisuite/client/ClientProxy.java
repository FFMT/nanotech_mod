/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.CommonProxy;

public class ClientProxy extends CommonProxy
{
	public static KeyBinding flyKey, invKey, nightKey;
	
	@Override
	public void registerKey()
	{
		flyKey = new KeyBinding("Ultimate Gravi Fly Key", Keyboard.KEY_F, "key.categories.gameplay");
		invKey = new KeyBinding("Invisibility Ultimate Gravi Key", Keyboard.KEY_G, "key.categories.gameplay");
		nightKey = new KeyBinding("Night vision Ultimate Solar Helmet Key", Keyboard.KEY_H, "key.categories.gameplay");
	
		ClientRegistry.registerKeyBinding(flyKey);
		ClientRegistry.registerKeyBinding(invKey);
		ClientRegistry.registerKeyBinding(nightKey);
		
		FMLCommonHandler.instance().bus().register(new UGSClientEventHandler());
	}

	public EntityPlayer getPlayerInstance()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
}