package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render_Mob_superzombie extends RenderLiving
{
    private ModelBase SuperzombieModel = new Model_Mob_superzombie();

    public Render_Mob_superzombie(Model_Mob_superzombie model_Mob_superzombie, float f)
    {
        super(new Model_Mob_superzombie(), 0.5F);
    }
}