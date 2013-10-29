package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import tutoriel.common.ModTutoriel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TextureEvent
{
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void onPostTextureStitch(TextureStitchEvent.Post event)

	{

		if(event.map.textureType == 0)

		{

			// ModTutoriel.fluidTutorial.setIcons(ModTutoriel.blockFluidTutorial.getBlockTextureFromSide(1),
			// ModTutoriel.blockFluidTutorial.getBlockTextureFromSide(2));

		}

	}

}
