package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class Event_bonemeal
{
        @ForgeSubscribe
        public void onUseBonemeal(BonemealEvent event)
        {
                if (event.ID == 	Nanotech_mod.Block_nanosaplings.blockID)
                {
                        if (!event.world.isRemote)
                        {
                                ((Block_nanosaplings)Nanotech_mod.Block_nanosaplings).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
                                event.setResult(Result.ALLOW);
                        }
                }
        }
}