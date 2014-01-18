package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.ModelTheDeath;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobThedeath;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;

public class RenderTheDeath extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/entity/thedeath.png");

	public RenderTheDeath()
	{
		super(new ModelTheDeath(), 0.5F);
	}

	protected ResourceLocation getTheDeathTexture(MobThedeath entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTheDeathTexture((MobThedeath)entity);
	}

	protected void preRenderScale(MobThedeath mob, float par2)
	{
		GL11.glScalef(3F, 3F, 3F);
	}

	protected void preRenderCallback(EntityLivingBase entityliving, float par2)
	{
		this.preRenderScale((MobThedeath)entityliving, par2);
	}

	public void renderHealtBar(MobThedeath mob, double x, double y, double z, float par8, float par9)
	{
		BossStatus.setBossStatus(mob, true);
		super.doRenderLiving(mob, x, y, z, par8, par9);
	}

	public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
	{
		this.renderHealtBar((MobThedeath)entity, x, y, z, par8, par9);
	}

	protected void renderEquippedItems(EntityLivingBase livingbase, float par2)
	{
		this.func_130005_c((EntityLiving)livingbase, par2);
	}

	protected void func_130005_c(EntityLiving living, float par2)
	{
		float f1 = 1.0F;
		GL11.glColor3f(f1, f1, f1);
		super.renderEquippedItems(living, par2);
		ItemStack itemstack = living.getHeldItem();
		float f2;

		if(itemstack != null)
		{
			GL11.glPushMatrix();

			if(this.mainModel.isChild)
			{
				f2 = 0.5F;
				GL11.glTranslatef(0.0F, 0.625F, 0.0F);
				GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
				GL11.glScalef(f2, f2, f2);
			}

			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

			IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

			if(itemstack.itemID == NanotechItem.scythe.itemID)
			{
				GL11.glRotatef(120F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(160F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-15F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.5F, 1.0F, 1.3F);
			}
			else if(Item.itemsList[itemstack.itemID].isFull3D())
			{
				f2 = 0.625F;

				if(Item.itemsList[itemstack.itemID].shouldRotateAroundWhenRendering())
				{
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
				GL11.glScalef(f2, -f2, f2);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else
			{
				f2 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f2, f2, f2);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			this.renderManager.itemRenderer.renderItem(living, itemstack, 0);

			if(itemstack.getItem().requiresMultipleRenderPasses())
			{
				for(int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
				{
					this.renderManager.itemRenderer.renderItem(living, itemstack, x);
				}
			}

			GL11.glPopMatrix();
		}
	}
}