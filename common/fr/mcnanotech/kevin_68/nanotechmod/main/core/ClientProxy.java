/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.core;

import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderCrazyGuy;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderCreeperDriller;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderDancer;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderFastZombie;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderMobFly;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderMobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderSatelite;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderSuperCreeper;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderSuperEnderman;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderSuperZombie;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.RenderTheDeath;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemAltersRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemBlockPortableChestRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemCrazyGlassesGunRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemDebugRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemLightSaberRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemNanomiteArrowGunRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.items.ItemScytheRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.tileentity.TileEntityButtonRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer.tileentity.TileEntityPortableChestRender;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobCrazyGuy;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobCreeperDriller;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobDancer;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobFastZombie;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobFly;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobSuperCreeper;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobSuperEnderman;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobSuperZombie;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobThedeath;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntityReinforcedFishingHook;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntitySatelite;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntitySuperBottleOfXp;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityButton;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.minecraftforgefrance.ffmtlibs.FFMTClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void register()
	{
		RenderingRegistry.registerEntityRenderingHandler(MobThedeath.class, new RenderTheDeath());
		RenderingRegistry.registerEntityRenderingHandler(MobSuperCreeper.class, new RenderSuperCreeper());
		RenderingRegistry.registerEntityRenderingHandler(MobSuperSkeleton.class, new RenderMobSuperSkeleton());
		RenderingRegistry.registerEntityRenderingHandler(MobSuperEnderman.class, new RenderSuperEnderman());
		RenderingRegistry.registerEntityRenderingHandler(MobSuperZombie.class, new RenderSuperZombie());
		RenderingRegistry.registerEntityRenderingHandler(MobCreeperDriller.class, new RenderCreeperDriller());
		RenderingRegistry.registerEntityRenderingHandler(MobFastZombie.class, new RenderFastZombie());
		RenderingRegistry.registerEntityRenderingHandler(MobFly.class, new RenderMobFly(0.05F));
		RenderingRegistry.registerEntityRenderingHandler(MobFlyingCreeper.class, new RenderFlyingCreeper());
		RenderingRegistry.registerEntityRenderingHandler(MobCrazyGuy.class, new RenderCrazyGuy());
		RenderingRegistry.registerEntityRenderingHandler(MobDancer.class, new RenderDancer());

		RenderingRegistry.registerEntityRenderingHandler(EntityReinforcedFishingHook.class, new RenderFish());
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperBottleOfXp.class, new RenderSnowball(NanotechModList.superBottleOfXp));
		RenderingRegistry.registerEntityRenderingHandler(EntitySatelite.class, new RenderSatelite());

		MinecraftForgeClient.registerItemRenderer(NanotechModList.scythe, new ItemScytheRender());
		MinecraftForgeClient.registerItemRenderer(NanotechModList.debug, new ItemDebugRender());
		MinecraftForgeClient.registerItemRenderer(NanotechModList.alters, new ItemAltersRender());
		MinecraftForgeClient.registerItemRenderer(NanotechModList.nanomiteBow, new ItemNanomiteArrowGunRender());
		MinecraftForgeClient.registerItemRenderer(NanotechModList.crazyGlassesGun, new ItemCrazyGlassesGunRender());
		MinecraftForgeClient.registerItemRenderer(NanotechModList.lightSaber, new ItemLightSaberRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(NanotechModList.machine), new ItemBlockPortableChestRender());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityButton.class, new TileEntityButtonRender());
		FFMTClientRegistry.bindTESRWithInventoryRender(NanotechBlock.machine, 0, TileEntityPortableChest.class, new TileEntityPortableChestRender());

	}
}