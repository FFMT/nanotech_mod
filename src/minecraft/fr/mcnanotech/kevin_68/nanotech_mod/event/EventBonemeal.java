package fr.mcnanotech.kevin_68.nanotech_mod.event;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.BlockNanosaplings;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;

public class EventBonemeal
{
	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent event)
	{
		if (event.ID == NanotechBlock.BlockNanosaplings.blockID)
		{
			if (!event.world.isRemote)
			{
				((BlockNanosaplings) NanotechBlock.BlockNanosaplings).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
				event.setResult(Result.ALLOW);
			}
		}
	}
}