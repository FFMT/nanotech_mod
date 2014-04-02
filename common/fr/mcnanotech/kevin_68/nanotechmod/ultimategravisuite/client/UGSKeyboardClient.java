package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.PacketKeys;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UGSKeyboard;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;

public class UGSKeyboardClient extends UGSKeyboard
{
	public static KeyBinding flyKey, invKey;
	private int lastKeyState = 0;

	public UGSKeyboardClient()
	{
		flyKey = new KeyBinding("Ultimate Gravi Fly Key", Keyboard.KEY_F, "IC2");
		invKey = new KeyBinding("Invisibility Ultimate Gravi Key", Keyboard.KEY_G, "IC2");
	
		ClientRegistry.registerKeyBinding(flyKey);
		ClientRegistry.registerKeyBinding(invKey);
	}

	public void sendKeyUpdate()
	{
		int currentKeyState = (this.flyKey.isPressed() ? 1 : 0) << 0 | (this.invKey.isPressed() ? 1 : 0) << 1;
		if(currentKeyState != this.lastKeyState)
		{
			this.lastKeyState = currentKeyState;
			try
			{
				UltimateGraviSuiteMod.packetHandler.sendToServer(new PacketKeys(currentKeyState));
			}
			catch(Exception exception)
			{
				UltimateGraviSuiteMod.ugslogger.error("Failed to send a key packet");
			}
			super.processKeyUpdate(FMLClientHandler.instance().getClientPlayerEntity(), currentKeyState);
		}
	}
}