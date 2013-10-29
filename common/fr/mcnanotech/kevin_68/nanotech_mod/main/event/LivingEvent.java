package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class LivingEvent
{
	@ForgeSubscribe
	public void onLivingFall(LivingFallEvent event)
	{
		ItemStack boots = event.entityLiving.getCurrentItemOrArmor(1);

		if(boots != null && boots.getItem().equals(NanotechItem.mysteriousBoots))
		{
			boots.damageItem((int)(event.distance / 8), event.entityLiving);
			if(boots.stackSize == 0)
			{
				event.entityLiving.setCurrentItemOrArmor(1, null);
			}
			event.distance = 0F;
		}
	}

	@ForgeSubscribe
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving.isPotionActive(Nanotech_mod.freeze))
		{
			event.entityLiving.attackEntityFrom(NanotechDamageSource.nitrogenDamage, 1);
			int blockId = event.entityLiving.worldObj.getBlockId((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ);
			if(blockId == Block.waterMoving.blockID || blockId == Block.waterStill.blockID)
			{
				event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Block.ice.blockID);
			}
			else if(blockId == Block.lavaStill.blockID || blockId == Block.lavaMoving.blockID)
			{
				event.entityLiving.removePotionEffect(30);
				if(event.entityLiving.worldObj.getBlockMetadata((int)event.entityLiving.posX , (int)event.entityLiving.posY, (int)event.entityLiving.posZ) == 0)
					event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Block.obsidian.blockID);
				else
					event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Block.cobblestone.blockID);
			}
			
			if(event.entityLiving.isBurning())
			{
				event.entityLiving.removePotionEffect(30);
			}
		}
	}
	
	@ForgeSubscribe
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(event.source.equals(NanotechDamageSource.nitrogenDamage))
		{
			event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Block.ice.blockID);
			event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX, (int)event.entityLiving.posY + 1, (int)event.entityLiving.posZ, Block.ice.blockID);
		}
	}
}