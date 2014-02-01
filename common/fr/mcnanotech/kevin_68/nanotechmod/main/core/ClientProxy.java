package fr.mcnanotech.kevin_68.nanotechmod.main.core;

import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotechmod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity.TileEntityTrashCanRender;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrashCan;
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
import fr.mcnanotech.kevin_68.nanotechmod.main.event.RenderEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityButton;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityPortableChest;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.NanotechClientTickHandler;
import fr.minecraftforgefrance.ffmtlibs.FFMTClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModRenders()
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
	}

	@Override
	public void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityReinforcedFishingHook.class, new RenderFish());
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperBottleOfXp.class, new RenderSnowball(NanotechItem.superBottleOfXp));
		RenderingRegistry.registerEntityRenderingHandler(EntitySatelite.class, new RenderSatelite());
	}

	@Override
	public void registerItemRenders()
	{
		MinecraftForgeClient.registerItemRenderer(NanotechItem.scythe.itemID, new ItemScytheRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.debug.itemID, new ItemDebugRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.alters.itemID, new ItemAltersRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.nanomiteBow.itemID, new ItemNanomiteArrowGunRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.crazyGlassesGun.itemID, new ItemCrazyGlassesGunRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.lightSaber.itemID, new ItemLightSaberRender());
	}

	@Override
	public void registerTileEntityRenders()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityButton.class, new TileEntityButtonRender());
		FFMTClientRegistry.bindTESRWithInventoryRender(NanotechBlock.machine, 0, TileEntityPortableChest.class, new TileEntityPortableChestRender());
	}

	@Override
	public void registerOverlay()
	{
		MinecraftForge.EVENT_BUS.register(new RenderEvent());
	}

	@Override
	public void registerTickHandler()
	{
		TickRegistry.registerTickHandler(new NanotechClientTickHandler(), Side.CLIENT);
	}
}