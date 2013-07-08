package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ClientProxy;

@SideOnly(Side.CLIENT)
public class KeyboardClient extends Keyboard
{
    public static Minecraft mc = FMLClientHandler.instance().getClient();
    public static KeyBinding flyKey = new KeyBinding("Ultimate Gravi Fly Key", 33);
    public static KeyBinding invKey = new KeyBinding("Invisibility Ultimate Gravi Key", 34);
    public static KeyBinding nightKey = new KeyBinding("Night vision Ultimate Solar Helmet Key", 35); 
    private static int lastKeyState = 0;
    private static boolean lastKeyModeState = false;
    public static int icBoostKeyID;
    public static int icAltKeyID;
    public static int icModeKeyID;
    public static float moveStrafe;
    public static float moveForward;

    public KeyboardClient()
    {
        KeyBindingRegistry.registerKeyBinding(new KeyboardHandler(this, new KeyBinding[] {flyKey, invKey, nightKey}, new boolean[] {false, false, false}));     
    }

    public static boolean isBoostKeyDown(EntityPlayer var0)
    {
        return mc.gameSettings.keyBindings[icBoostKeyID].pressed;
    }

    public static boolean isAltKeyDown(EntityPlayer var0)
    {
        return mc.gameSettings.keyBindings[icAltKeyID].pressed;
    }

    public static boolean isModeKeyPress(EntityPlayer var0)
    {
        if (mc.gameSettings.keyBindings[icModeKeyID].pressed)
        {
            if (!lastKeyModeState)
            {
                lastKeyModeState = true;
                sendModeKey(var0);
            }

            return true;
        }
        else
        {
            lastKeyModeState = false;
            return false;
        }
    }

    public static boolean isJumpKeyDown(EntityPlayer var0)
    {
        return mc.gameSettings.keyBindJump.pressed;
    }

    public static boolean isForwardKeyDown(EntityPlayer var0)
    {
        return mc.gameSettings.keyBindForward.pressed;
    }

    public static boolean isSneakKeyDown(EntityPlayer var0)
    {
        return mc.gameSettings.keyBindSneak.pressed;
    }

    public static void sendModeKey(EntityPlayer var0)
    {
        ClientProxy.sendMyPacket("keyModePressed", 1);
    }

    public void sendKeyUpdate(EntityPlayer var1)
    {
        int var2 = (isBoostKeyDown(var1) ? 1 : 0) << 0 | (isAltKeyDown(var1) ? 1 : 0) << 1 | (isModeKeyPress(var1) ? 1 : 0) << 2 | (isForwardKeyDown(var1) ? 1 : 0) << 3 | (isJumpKeyDown(var1) ? 1 : 0) << 4 | (isSneakKeyDown(var1) ? 1 : 0) << 5;

        if (var2 != lastKeyState)
        {
            ClientProxy.sendMyPacket("keyState", var2);
            lastKeyState = var2;
            super.processKeyUpdate(var1, var2);
        }
    }

    public static void updatePlayerMove()
    {
        moveStrafe = 0.0F;
        moveForward = 0.0F;

        if (mc.gameSettings.keyBindForward.pressed)
        {
            ++moveForward;
        }

        if (mc.gameSettings.keyBindBack.pressed)
        {
            --moveForward;
        }

        if (mc.gameSettings.keyBindLeft.pressed)
        {
            ++moveStrafe;
        }

        if (mc.gameSettings.keyBindRight.pressed)
        {
            --moveStrafe;
        }

        if (mc.gameSettings.keyBindSneak.pressed)
        {
            moveStrafe = (float)((double)moveStrafe * 0.3D);
            moveForward = (float)((double)moveForward * 0.3D);
        }
    }
}
