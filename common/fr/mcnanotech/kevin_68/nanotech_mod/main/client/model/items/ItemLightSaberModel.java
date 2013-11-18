package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items;

import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class ItemLightSaberModel extends ModelBase
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public ItemLightSaberModel()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-0.5F, -3F, -0.5F, 1, 3, 1);
		Shape1.setRotationPoint(0F, 24F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 4, 0);
		Shape2.addBox(-1F, -4F, -1F, 2, 1, 2);
		Shape2.setRotationPoint(0F, 24F, 0F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 4);
		Shape3.addBox(-0.5F, -18F, -0.5F, 1, 14, 1);
		Shape3.setRotationPoint(0F, 24F, 0F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean multiColor)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		if(!multiColor)
		{
			Shape1.render(f5);
			Shape2.render(f5);
		}
		else
		{
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem().itemID == NanotechItem.lightSaber.itemID)
				{
					if(!player.inventory.getCurrentItem().hasTagCompound())
					{
						player.inventory.getCurrentItem().setTagCompound(new NBTTagCompound());
					}
					else if(!player.inventory.getCurrentItem().getTagCompound().hasKey("IsOn"))
					{
						player.inventory.getCurrentItem().getTagCompound().setBoolean("IsOn", false);
					}
					else if(player.inventory.getCurrentItem().getTagCompound().getBoolean("IsOn"))
					{
						Shape3.render(f5);
					}
				}
			}
			else
			{
				Shape3.render(f5);
			}
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
