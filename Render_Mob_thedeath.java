package fr.mcnanotech.kevin_68.nanotech_mod;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.boss.EntityDragon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render_Mob_thedeath extends RenderLiving
{
    private ModelBase thedeathModel = new Model_Mob_thedeath();

    public Render_Mob_thedeath(Model_Mob_thedeath model_Mob_thedeath, float f)
    {
        super(new Model_Mob_thedeath(), 0.5F);
    }
}