package fr.mcnanotech.kevin_68.nanotech_mod.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.Model_Mob_superskeleton;

@SideOnly(Side.CLIENT)
public class Render_Mob_superskeleton extends RenderLiving
{
    private ModelBase SuperskeletonModel = new Model_Mob_superskeleton();

    public Render_Mob_superskeleton(Model_Mob_superskeleton model_Mob_superskeleton, float f)
    {
        super(new Model_Mob_superskeleton(), 0.5F);
    }
}
