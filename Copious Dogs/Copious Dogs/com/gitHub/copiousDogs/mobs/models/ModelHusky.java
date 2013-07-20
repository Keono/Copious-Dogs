// Date: 7/17/2013 3:37:07 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package com.gitHub.copiousDogs.mobs.models;

import com.gitHub.copiousDogs.mobs.Dog;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelHusky extends DogModelBase
{
	@Override
	protected void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public ModelHusky()
	{
		textureWidth = 64;
		textureHeight = 32;

		WolfHead = new ModelRenderer(this, 0, 0);
		WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
		WolfHead.setRotationPoint(-1F, 11.5F, -7F);
		WolfHead.setTextureSize(64, 32);
		WolfHead.mirror = true;
		setRotation(WolfHead, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 24, 11);
		Body.addBox(-4F, -2F, -3F, 6, 15, 6);
		Body.setRotationPoint(0F, 14F, -4F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 1.570796F, 0F, 0F);
		Mane = new ModelRenderer(this, 21, 0);
		Mane.addBox(-4F, -3F, -4F, 6, 8, 1);
		Mane.setRotationPoint(0F, 14F, -3F);
		Mane.setTextureSize(64, 32);
		Mane.mirror = true;
		setRotation(Mane, 1.570796F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 0, 19);
		Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg1.setRotationPoint(-2.5F, 16F, 7F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 0, 19);
		Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg2.setRotationPoint(0.5F, 16F, 7F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
		Leg3 = new ModelRenderer(this, 36, 0);
		Leg3.addBox(-1F, 0F, -1F, 2, 6, 3);
		Leg3.setRotationPoint(-2.5F, 18F, -4F);
		Leg3.setTextureSize(64, 32);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 36, 0);
		Leg4.addBox(-1F, 0F, -1F, 2, 6, 3);
		Leg4.setRotationPoint(0.5F, 18F, -4F);
		Leg4.setTextureSize(64, 32);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0F);
		Tail = new ModelRenderer(this, 9, 19);
		Tail.addBox(-1F, 0F, -1F, 2, 9, 2);
		Tail.setRotationPoint(-1F, 11.8F, 8F);
		Tail.setTextureSize(64, 32);
		Tail.mirror = true;
		setRotation(Tail, 0.4608543F, 0F, 0F);
		Ear1 = new ModelRenderer(this, 16, 13);
		Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
		Ear1.setRotationPoint(-1F, 11.5F, -7F);
		Ear1.setTextureSize(64, 32);
		Ear1.mirror = true;
		setRotation(Ear1, 0F, 0F, 0F);
		Ear2 = new ModelRenderer(this, 16, 13);
		Ear2.addBox(0F, -5F, 0F, 2, 2, 1);
		Ear2.setRotationPoint(0F, 12.5F, -7F);
		Ear2.setTextureSize(64, 32);
		Ear2.mirror = true;
		setRotation(Ear2, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 0, 11);
		Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
		Nose.setRotationPoint(-0.5F, 11.5F, -7F);
		Nose.setTextureSize(64, 32);
		Nose.mirror = true;
		setRotation(Nose, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		WolfHead.render(f5);
		Body.render(f5);
		Mane.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Tail.render(f5);
		Ear1.render(f5);
		Ear2.render(f5);
		Nose.render(f5);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float walkTime,
			float isWalking, float random)
	{
		// entity will always be instance of dog. instanceof calls are slow
		Dog dog = (Dog) entity;

		if (dog.isBegging())
		{
			this.Ear1.setRotationPoint(-1F, 11.5F, -7F);
			this.Ear2.setRotationPoint(-1F, 11.5F, -7F);
			this.Ear1.rotateAngleZ = (float) Math.toRadians(30);
			this.Ear2.rotateAngleZ = (float) Math.toRadians(30);
			this.WolfHead.rotateAngleZ = (float) Math.toRadians(30);
			this.Nose.rotateAngleZ = (float) Math.toRadians(30);
		}
		else
		{
			this.WolfHead.rotateAngleZ = 0;
			this.Nose.rotateAngleZ = 0;
			this.Ear1.setRotationPoint(-3F, 13.7F, -8F);
			this.Ear2.setRotationPoint(2F, 13.5F, -8F);
			setRotation(Ear1, 0F, 0F, 0.248884F);
			setRotation(Ear2, 0F, 0F, -0.2488901F);
		}

		super.setLivingAnimations(dog, walkTime, isWalking, random);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
