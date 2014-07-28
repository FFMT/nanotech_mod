/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.BlockNanoSaplings;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;

public class EventBonemeal
{
    private int counter = 0;

    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
        if(event.block.equals(NanotechBlock.nanoSaplings))
        {
            if(!event.world.isRemote)
            {
                if(counter > event.world.rand.nextInt(2) + 2)
                {
                    ((BlockNanoSaplings)NanotechBlock.nanoSaplings).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
                    event.setResult(Result.ALLOW);
                    counter = 0;
                }
                else
                {
                    event.setResult(Result.ALLOW);
                    counter++;
                }
            }
        }
    }
}