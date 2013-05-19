package fr.mcnanotech.kevin_68.nanotech_mod;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends CommonProxy
{
  public static int renderBlockID;
  public static Minecraft mc = FMLClientHandler.instance().getClient();
	
  @SideOnly(Side.CLIENT)
  public void registerRenderThings()
  {
    MinecraftForgeClient.preloadTexture("/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png");
    MinecraftForgeClient.preloadTexture("/Nanotech_mod/client/textures/items.png");
    MinecraftForgeClient.preloadTexture("/Nanotech_mod/client/textures/GUI_blockjump.png");
    MinecraftForgeClient.preloadTexture("/Nanotech_mod/client/textures/GUI_blocksmoke.png");
    RenderingRegistry.registerEntityRenderingHandler(Mob_thedeath.class, new Render_Mob_thedeath(new Model_Mob_thedeath(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_supercreeper.class, new Render_Mob_supercreeper(new Model_Mob_supercreeper(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_superskeleton.class, new Render_Mob_superskeleton(new Model_Mob_superskeleton(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_superenderman.class, new Render_Mob_superenderman(new Model_Mob_superenderman(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_superzombie.class, new Render_Mob_superzombie(new Model_Mob_superzombie(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_creeperforreur.class, new Render_Mob_creeperforreur(new Model_Mob_creeperforreur(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_fastzombie.class, new Render_Mob_fastzombie(new Model_Mob_fastzombie(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_fly.class, new Render_Mob_fly(new Model_Mob_fly(), 0.5F));
    RenderingRegistry.registerEntityRenderingHandler(Mob_flyingcreeper.class, new Render_Mob_flyingcreeper(new Model_Mob_flyingcreeper(), 0.5F));

  }

  public int addTerrainOverride(String path)
  {
    return RenderingRegistry.addTextureOverride("/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png", path);
  }
  
  public boolean isClient()
  {
    return true;
  }
}