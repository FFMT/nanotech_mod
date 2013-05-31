package fr.mcnanotech.kevin_68.nanotech_mod.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class World_nanotechbiome extends BiomeGenBase
{

	public World_nanotechbiome(int par1) 
	{
		super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.field_82914_M.clear();
       // this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = (byte)NanotechBlock.BlockGrass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.deadBushPerChunk = 0;
        this.theBiomeDecorator.mushroomsPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.generateLakes = false;
    }

    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
