/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityFountainRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityLampLightRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityLampRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityModernFenceRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntitySpotLightRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntitySunShadeRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityTextSpotLightRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityTrailRenderISBRH;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityTrailRenderTESR;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityTrashCanRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityModernFence;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySunShade;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTextSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrail;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrashCan;
import fr.minecraftforgefrance.ffmtlibs.FFMTClientRegistry;

public class ClientProxy extends CommonProxy
{

	public static int renderTrailID;

	@Override
	public void registerTileRenders()
	{
		renderTrailID = RenderingRegistry.getNextAvailableRenderId();

		RenderingRegistry.registerBlockHandler(renderTrailID, new TileEntityTrailRenderISBRH());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpotLight.class, new TileEntitySpotLightRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrail.class, new TileEntityTrailRenderTESR());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFountain.class, new TileEntityFountainRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLamp.class, new TileEntityLampRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLampLight.class, new TileEntityLampLightRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySunShade.class, new TileEntitySunShadeRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModernFence.class, new TileEntityModernFenceRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTextSpotLight.class, new TileEntityTextSpotLightRender());

		FFMTClientRegistry.bindTESRWithInventoryRender(NanotechCityBlock.trashcan, 0, TileEntityTrashCan.class, new TileEntityTrashCanRender());
	}
}