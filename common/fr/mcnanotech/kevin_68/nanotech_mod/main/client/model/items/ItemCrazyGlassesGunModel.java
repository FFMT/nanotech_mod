package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class ItemCrazyGlassesGunModel extends ModelBase
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Item1;
	ModelRenderer Item2;
	ModelRenderer Item3;
	ModelRenderer Item4;

	public ItemCrazyGlassesGunModel()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(-7F, -1F, -3F, 9, 1, 11);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 20);
		Shape3.addBox(1F, -2F, -3F, 1, 1, 10);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 12, 19);
		Shape4.addBox(-1F, -2F, -3F, 1, 1, 10);
		Shape4.setRotationPoint(0F, 0F, 0F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 24, 18);
		Shape5.addBox(-3F, -2F, -3F, 1, 1, 10);
		Shape5.setRotationPoint(0F, 0F, 0F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 36, 17);
		Shape6.addBox(-5F, -2F, -3F, 1, 1, 10);
		Shape6.setRotationPoint(0F, 0F, 0F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 30, 6);
		Shape7.addBox(-7F, -2F, -3F, 1, 1, 10);
		Shape7.setRotationPoint(0F, 0F, 0F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 12);
		Shape8.addBox(-7F, -5F, 7F, 9, 4, 1);
		Shape8.setRotationPoint(0F, 0F, 0F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Item1 = new ModelRenderer(this, 42, 0);
		Item1.addBox(0F, -9F, -1F, 1, 8, 8);
		Item1.setRotationPoint(0F, 0F, 0F);
		Item1.setTextureSize(64, 32);
		Item1.mirror = true;
		setRotation(Item1, 0F, 0F, 0F);
		Item2 = new ModelRenderer(this, 42, 0);
		Item2.addBox(-2F, -9F, -1F, 1, 8, 8);
		Item2.setRotationPoint(0F, 0F, 0F);
		Item2.setTextureSize(64, 32);
		Item2.mirror = true;
		setRotation(Item2, 0F, 0F, 0F);
		Item3 = new ModelRenderer(this, 42, 0);
		Item3.addBox(-4F, -9F, -1F, 1, 8, 8);
		Item3.setRotationPoint(0F, 0F, 0F);
		Item3.setTextureSize(64, 32);
		Item3.mirror = true;
		setRotation(Item3, 0F, 0F, 0F);
		Item4 = new ModelRenderer(this, 42, 0);
		Item4.addBox(-6F, -9F, -1F, 1, 8, 8);
		Item4.setRotationPoint(0F, 0F, 0F);
		Item4.setTextureSize(64, 32);
		Item4.mirror = true;
		setRotation(Item4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);

		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if(player.inventory.getCurrentItem() != null)
			{
				if(player.inventory.getCurrentItem().itemID == NanotechItem.crazyGlassesGun.itemID)
				{
					if(player.inventory.getCurrentItem().hasTagCompound())
					{
						if(player.inventory.getCurrentItem().getTagCompound().hasKey("Charge"))
						{
							if(player.inventory.getCurrentItem().getTagCompound().getByte("Charge") == 4)
							{
								Item1.render(f5);
								Item2.render(f5);
								Item3.render(f5);
								Item4.render(f5);
							}
							else if(player.inventory.getCurrentItem().getTagCompound().getByte("Charge") == 3)
							{
								Item1.render(f5);
								Item2.render(f5);
								Item3.render(f5);
							}
							else if(player.inventory.getCurrentItem().getTagCompound().getByte("Charge") == 2)
							{
								Item1.render(f5);
								Item2.render(f5);
							}
							else if(player.inventory.getCurrentItem().getTagCompound().getByte("Charge") == 1)
							{
								Item1.render(f5);
							}
						}
					}
				}
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
