package fr.mcnanotech.FFMT.FFMTAPITestMod.Entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.FFMT.FFMTAPI.FFMTColor;

public class FFMTAPIMobTest extends EntityMob
{

	public FFMTAPIMobTest(World par1World) 
	{
		super(par1World);
	}

	@Override
	public int getMaxHealth() 
	{
		return Integer.MAX_VALUE;
	}
	
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
    	if (this.worldObj.isRemote)
    	{
    		message(par1EntityPlayer);
    		return true;
    	}
    	
    	return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void message(EntityPlayer player)
    {
    	player.addChatMessage(FFMTColor.aqua + "test" + FFMTColor.black + "test" + FFMTColor.blue + "test" + FFMTColor.darkAqua + "test" + FFMTColor.darkBlue + "test" + FFMTColor.darkGray + "test" + FFMTColor.darkGreen + "test" + FFMTColor.darkRed + "test" + FFMTColor.gold + "test");
    	player.addChatMessage(FFMTColor.gray + "test" + FFMTColor.green + "test" + FFMTColor.lightPurple + "test" + FFMTColor.purple + "test" + FFMTColor.red + "test" + FFMTColor.white + "test" + FFMTColor.yellow + "test");
    	player.addChatMessage(FFMTColor.strike + "test");
    	player.addChatMessage(FFMTColor.bold + "test");
    	player.addChatMessage(FFMTColor.italic + "test");
    	player.addChatMessage(FFMTColor.underline + "test");
    	player.addChatMessage(FFMTColor.obfuscated + "test");

    }

}
