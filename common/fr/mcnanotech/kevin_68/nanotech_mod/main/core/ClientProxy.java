package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiOverlay;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCreeperDriller;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelMobFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderCreeperDriller;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderMobFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderMobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items.ItemAltersRender;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items.ItemCrazyGlassesGunRender;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items.ItemDebugRender;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items.ItemNanomiteArrowGunRender;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items.ItemScytheRender;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCreeperDriller;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobThedeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityReinforcedFishingHook;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySuperBottleOfXp;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotech_mod.main.utils.NanotechClientTickHandler;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(MobThedeath.class, new RenderTheDeath(new ModelTheDeath(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperCreeper.class, new RenderSuperCreeper(new ModelSuperCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperSkeleton.class, new RenderMobSuperSkeleton(new ModelSuperSkeleton(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperEnderman.class, new RenderSuperEnderman(new ModelSuperEnderman(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperZombie.class, new RenderSuperZombie(new ModelSuperZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobCreeperDriller.class, new RenderCreeperDriller(new ModelCreeperDriller(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFastZombie.class, new RenderFastZombie(new ModelMobFastZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFly.class, new RenderMobFly(new ModelFly(), 0.05F));
		RenderingRegistry.registerEntityRenderingHandler(MobFlyingCreeper.class, new RenderFlyingCreeper(new ModelFlyingCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobCrazyGuy.class, new RenderCrazyGuy(new ModelCrazyGuy(), 0.5F));
	}

	@Override
	public void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityReinforcedFishingHook.class, new RenderFish());
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperBottleOfXp.class, new RenderSnowball(NanotechItem.superBottleOfXp));
	}

	@Override
	public void registerItemRenders()
	{
		MinecraftForgeClient.registerItemRenderer(NanotechItem.scythe.itemID, new ItemScytheRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.debug.itemID, new ItemDebugRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.alters.itemID, new ItemAltersRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.nanomiteBow.itemID, new ItemNanomiteArrowGunRender());
		MinecraftForgeClient.registerItemRenderer(NanotechItem.crazyGlassesGun.itemID, new ItemCrazyGlassesGunRender());
	}

	@Override
	public void registerOverlay()
	{
		MinecraftForge.EVENT_BUS.register(new GuiOverlay(Minecraft.getMinecraft()));
	}

	@Override
	public void registerTickHandler()
	{
		TickRegistry.registerTickHandler(new NanotechClientTickHandler(), Side.CLIENT);
	}
}