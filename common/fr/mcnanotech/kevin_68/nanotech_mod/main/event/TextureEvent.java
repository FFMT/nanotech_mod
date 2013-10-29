package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class TextureEvent
{
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onPostTextureStitch(TextureStitchEvent.Post event)
	{

		if(event.map.textureType == 0)
		{

			Nanotech_mod.liquidNitrogen.setIcons(NanotechBlock.liquidNitrogen.getBlockTextureFromSide(1),
			NanotechBlock.liquidNitrogen.getBlockTextureFromSide(2));
		}
	}
}