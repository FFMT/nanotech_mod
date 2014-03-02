package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import org.lwjgl.input.Keyboard;

import ic2.core.IC2;
import ic2.core.network.NetworkManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UGSKeyboard;

public class UGSKeyboardClient extends UGSKeyboard
{
	public KeyBinding flyKey, invKey, nightKey;
	private int lastKeyState = 0;

	public UGSKeyboardClient()
	{
		flyKey = new KeyBinding("Ultimate Gravi Fly Key", Keyboard.KEY_F, "IC2");
		invKey = new KeyBinding("Invisibility Ultimate Gravi Key", Keyboard.KEY_G, "IC2");
		nightKey = new KeyBinding("Night vision Ultimate Solar Helmet Key", Keyboard.KEY_H, "IC2");
	
		ClientRegistry.registerKeyBinding(flyKey);
		ClientRegistry.registerKeyBinding(invKey);
		ClientRegistry.registerKeyBinding(nightKey);
	}

	public void sendKeyUpdate()
	{
		int currentKeyState = (this.flyKey.isPressed() ? 1 : 0) << 0 | (this.invKey.isPressed() ? 1 : 0) << 1 | (this.nightKey.isPressed() ? 1 : 0) << 2 | (FMLClientHandler.instance().getClient().gameSettings.keyBindForward.isPressed() ? 1 : 0) << 3;
		if(currentKeyState != this.lastKeyState)
		{
			// TODO send update packet
			super.processKeyUpdate(IC2.platform.getPlayerInstance(), currentKeyState);
			this.lastKeyState = currentKeyState;
		}
	}
}