    package fr.mcnanotech.kevin_68.nanotech_mod;

    import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

    public class Util_GuiHandler implements IGuiHandler
    {
            @Override
            public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
            {
                    TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                    if(tile_entity instanceof TileEntity_block_jumper)
                    {
                            return new Container_block_jumper((TileEntity_block_jumper) tile_entity, player.inventory, world);
                    }
                    if(tile_entity instanceof TileEntity_block_smoker)
                    {
                            return new Container_block_smoker((TileEntity_block_smoker) tile_entity, player.inventory, world);
                    }
                    if(tile_entity instanceof TileEntity_block_multiplier)
                    {
                            return new Container_block_multiplier((TileEntity_block_multiplier) tile_entity, player.inventory, world);
                    }
                   
                    return null;
            }
           
            @Override
            public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
            {
                    TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                   
                    if(tile_entity instanceof TileEntity_block_jumper)
                    {
                            return new GUI_block_jumper(player.inventory, (TileEntity_block_jumper) tile_entity, world);
                    }
                    if(tile_entity instanceof TileEntity_block_smoker)
                    {
                            return new GUI_block_smoker(player.inventory, (TileEntity_block_smoker) tile_entity, world);
                    }
                    if(tile_entity instanceof TileEntity_block_multiplier)
                    {
                            return new GUI_block_multiplier(player.inventory, (TileEntity_block_multiplier) tile_entity, world);
                    }
           
                    return null;
            }
    }