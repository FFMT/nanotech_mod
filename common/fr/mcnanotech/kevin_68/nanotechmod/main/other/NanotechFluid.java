/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.other;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.BlockLiquidNitrogen;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.ItemNitrogenBucket;

public class NanotechFluid
{
	public static Block blockNitrogen;
	public static Item bucketNitrogen;
	public static Fluid liquidNitrogen;
	
	public static void initFluid()
	{
		liquidNitrogen = new Fluid("liquidnitrogen").setDensity(4000).setViscosity(500).setTemperature(77).setLuminosity(0).setUnlocalizedName("liquidNitrogen");
		FluidRegistry.registerFluid(liquidNitrogen);
		
		blockNitrogen = new BlockLiquidNitrogen(liquidNitrogen, Material.water).setBlockName("liquidNitrogen").setBlockTextureName(NanotechMod.MODID + ":nitrogen"); 
		bucketNitrogen = new ItemNitrogenBucket(blockNitrogen).setUnlocalizedName("nitrogenBucket").setTextureName(NanotechMod.MODID + ":nitrogenBucket").setCreativeTab(NanotechMod.CreaI).setContainerItem(Items.bucket);
		liquidNitrogen.setBlock(blockNitrogen).setIcons(blockNitrogen.getBlockTextureFromSide(1), blockNitrogen.getBlockTextureFromSide(2));
		
		GameRegistry.registerBlock(blockNitrogen, ItemBlock.class, "blockLiquidNitrogen", NanotechMod.MODID);
		GameRegistry.registerItem(bucketNitrogen, "nitrogenBucket", NanotechMod.MODID);
	}
	

	public static void initFluidContainer()
	{
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("liquidnitrogen", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketNitrogen), FluidContainerRegistry.EMPTY_BUCKET);
	}
}
