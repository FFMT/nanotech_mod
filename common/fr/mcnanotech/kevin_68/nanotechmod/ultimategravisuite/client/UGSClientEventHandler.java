package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.client;

import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;

public class UGSClientEventHandler
{
    private Minecraft mc = FMLClientHandler.instance().getClient();

    @SubscribeEvent
    public void onTickPlayer(TickEvent.PlayerTickEvent event)
    {
        if(event.phase == TickEvent.Phase.END)
        {
            UltimateGraviSuiteMod.keyboard.sendKeyUpdate();

            ItemStack chestplate = event.player.getEquipmentInSlot(3);
            if(chestplate != null && chestplate.getItem() == UltimateGraviSuiteMod.ultimateGraviChestPlate)
            {
                if(!event.player.onGround && event.player.capabilities.isFlying && IC2.keyboard.isBoostKeyDown(event.player) && ElectricItem.manager.getCharge(chestplate) > UltimateGraviSuiteMod.ultimateMinCharge)
                {
                    float moveStrafe = 0.0F;
                    float moveForward = 0.0F;

                    if(mc.gameSettings.keyBindForward.getIsKeyPressed())
                    {
                        ++moveForward;
                    }

                    if(mc.gameSettings.keyBindBack.getIsKeyPressed())
                    {
                        --moveForward;
                    }

                    if(mc.gameSettings.keyBindLeft.getIsKeyPressed())
                    {
                        ++moveStrafe;
                    }

                    if(mc.gameSettings.keyBindRight.getIsKeyPressed())
                    {
                        --moveStrafe;
                    }

                    if(mc.gameSettings.keyBindSneak.getIsKeyPressed())
                    {
                        moveStrafe *= 0.3F;
                        moveForward *= 0.3F;
                    }
                    event.player.moveFlying(moveStrafe, moveForward, 0.15F);

                    if(mc.gameSettings.keyBindJump.getIsKeyPressed())
                    {
                        event.player.motionY += 0.18F;
                    }

                    if(mc.gameSettings.keyBindSneak.getIsKeyPressed())
                    {
                        event.player.motionY -= 0.18F;
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void renderPower(RenderGameOverlayEvent.Text event)
    {
        ItemStack chestPlate = mc.thePlayer.inventory.armorItemInSlot(2);
        if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuiteMod.ultimateGraviChestPlate))
        {
            double charge = ElectricItem.manager.getCharge(chestPlate);
            long percentage = (long)(((long)charge * 100.0D) / 1000000000);
            String graviPercentage = StatCollector.translateToLocalFormatted("ultimate.energy.level", getTextEnergyStatus(percentage));
            if(UltimateGraviSuiteMod.hudPos.equals("right"))
            {
                event.right.add(graviPercentage);
                if(chestPlate.hasTagCompound() && chestPlate.getTagCompound().getBoolean("fly"))
                {
                    event.right.add(StatCollector.translateToLocal("ultimate.fly.on"));
                }
            }
            else
            {
                event.left.add(graviPercentage);
                if(chestPlate.hasTagCompound() && chestPlate.getTagCompound().getBoolean("fly"))
                {
                    event.left.add(StatCollector.translateToLocal("ultimate.fly.on"));
                }
            }
        }
    }

    public String getTextEnergyStatus(long percentage)
    {
        String color;
        if(percentage <= 10 && percentage > 5)
            color = String.valueOf(EnumChatFormatting.GOLD);
        else if(percentage <= 5)
            color = String.valueOf(EnumChatFormatting.RED);
        else
            color = String.valueOf(EnumChatFormatting.GREEN);
        return color + Long.toString(percentage) + "%";
    }
}