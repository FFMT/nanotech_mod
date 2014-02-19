/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechFluid;

public class BucketEvent
{
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		int metadata = event.world.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ);

		if(block.equals(NanotechFluid.blockNitrogen) && metadata == 0)
		{
			event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
			event.result = new ItemStack(NanotechFluid.bucketNitrogen);
			event.setResult(Result.ALLOW);
		}

	}
}