package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render_Mob_fastzombie extends RenderLiving
{
    private ModelBase SuperzombieModel = new Model_Mob_fastzombie();

    public Render_Mob_fastzombie(Model_Mob_fastzombie model_Mob_fastzombie, float f)
    {
        super(new Model_Mob_fastzombie(), 0.5F);
    }
}