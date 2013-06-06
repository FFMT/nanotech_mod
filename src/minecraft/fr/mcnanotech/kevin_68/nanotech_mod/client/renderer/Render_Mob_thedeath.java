package fr.mcnanotech.kevin_68.nanotech_mod.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.Model_Mob_thedeath;

@SideOnly(Side.CLIENT)
public class Render_Mob_thedeath extends RenderLiving
{
    private ModelBase thedeathModel = new Model_Mob_thedeath();

    public Render_Mob_thedeath(Model_Mob_thedeath model_Mob_thedeath, float f)
    {
        super(new Model_Mob_thedeath(), 0.5F);
    }
}