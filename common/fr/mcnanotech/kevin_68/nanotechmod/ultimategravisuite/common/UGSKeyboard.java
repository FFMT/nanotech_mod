package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;

public class UGSKeyboard
{
    private final Map<EntityPlayer, Boolean> flyKeyState = new HashMap();
    private final Map<EntityPlayer, Boolean> invisibleKeyState = new HashMap();

    public void registerKey()
    {

    }

    public boolean isFlyKeyDown(EntityPlayer player)
    {
        if(this.flyKeyState.containsKey(player))
        {
            return this.flyKeyState.get(player);
        }
        return false;
    }

    public boolean isInvisibleKeyDown(EntityPlayer player)
    {
        if(this.invisibleKeyState.containsKey(player))
        {
            return this.invisibleKeyState.get(player);
        }
        return false;
    }

    public boolean isSneakKeyDown(EntityPlayer player)
    {
        return player.isSneaking();
    }

    public void sendKeyUpdate()
    {}

    public void processKeyUpdate(EntityPlayer player, int keyState)
    {
        this.flyKeyState.put(player, Boolean.valueOf((keyState & 0x1) != 0));
        this.invisibleKeyState.put(player, Boolean.valueOf((keyState & 0x2) != 0));
    }

    public void removePlayerReferences(EntityPlayer player)
    {
        this.flyKeyState.remove(player);
        this.invisibleKeyState.remove(player);
    }
}