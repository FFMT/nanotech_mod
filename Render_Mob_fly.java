package fr.mcnanotech.kevin_68.nanotech_mod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render_Mob_fly extends RenderLiving
{
    private ModelBase flyModel = new Model_Mob_fly();

    public Render_Mob_fly(Model_Mob_fly model_Mob_fly, float f)
    {
        super(new Model_Mob_fly(), 0.5F);
    }
}
