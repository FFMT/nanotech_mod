package fr.mcnanotech.kevin_68.nanotech_mod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Render_Mob_superenderman extends RenderLiving
{
    /** The model of the enderman */
    private Model_Mob_superenderman Mob_superendermanModel;
    private Random rnd = new Random();

    public Render_Mob_superenderman(Model_Mob_superenderman Model_Mob_superenderman, float f)
    {
        super(new Model_Mob_superenderman(), 0.5F);
        this.Mob_superendermanModel = (Model_Mob_superenderman)super.mainModel;
        this.setRenderPassModel(this.Mob_superendermanModel);
    }

    /**
     * Renders the enderman
     */
    public void renderMob_superenderman(Mob_superenderman par1Mob_superenderman, double par2, double par4, double par6, float par8, float par9)
    {
        this.Mob_superendermanModel.isCarrying = par1Mob_superenderman.getCarried() > 0;
        this.Mob_superendermanModel.isAttacking = par1Mob_superenderman.func_70823_r();

        if (par1Mob_superenderman.func_70823_r())
        {
            double var10 = 0.02D;
            par2 += this.rnd.nextGaussian() * var10;
            par6 += this.rnd.nextGaussian() * var10;
        }

        super.doRenderLiving(par1Mob_superenderman, par2, par4, par6, par8, par9);
    }

    /**
     * Render the block an enderman is carrying
     */
    protected void renderCarrying(Mob_superenderman par1Mob_superenderman, float par2)
    {
        super.renderEquippedItems(par1Mob_superenderman, par2);

        if (par1Mob_superenderman.getCarried() > 0)
        {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            float var3 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            var3 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var3, -var3, var3);
            int var4 = par1Mob_superenderman.getBrightnessForRender(par2);
            int var5 = var4 % 65536;
            int var6 = var4 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var5 / 1.0F, (float)var6 / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.loadTexture("/terrain.png");
            this.renderBlocks.renderBlockAsItem(Block.blocksList[par1Mob_superenderman.getCarried()], par1Mob_superenderman.getCarryingData(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

    /**
     * Render the endermans eyes
     */
    protected int renderEyes(Mob_superenderman par1Mob_superenderman, int par2, float par3)
    {
        if (par2 != 0)
        {
            return -1;
        }
        else
        {
            this.loadTexture("/mob/enderman_eyes.png");
            float var4 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);
            char var5 = 61680;
            int var6 = var5 % 65536;
            int var7 = var5 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var6 / 1.0F, (float)var7 / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
            return 1;
        }
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.renderEyes((Mob_superenderman)par1EntityLiving, par2, par3);
    }

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        this.renderCarrying((Mob_superenderman)par1EntityLiving, par2);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderMob_superenderman((Mob_superenderman)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderMob_superenderman((Mob_superenderman)par1Entity, par2, par4, par6, par8, par9);
    }
}
