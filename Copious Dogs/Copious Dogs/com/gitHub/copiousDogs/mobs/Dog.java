package com.gitHub.copiousDogs.mobs;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.gitHub.copiousDogs.CopiousDogs;
import com.gitHub.copiousDogs.items.DogCollar;
import com.gitHub.copiousDogs.mobs.ai.EntityAIBegBiscuit;
import com.gitHub.copiousDogs.mobs.ai.EntityAIFollowOwnerLeashed;

public class Dog extends EntityTameable
{
	
	protected static float moveSpeed;
	
	/**
	 * A value describing how close this dog is to getting tamed.
	 * 10 is tamed.
	 */
	
	public boolean hasCollar() {
		
		return (this.dataWatcher.getWatchableObjectByte(18) & 4) != 0;
	}
	
	public boolean isTailAnimated() {
		
		return (this.dataWatcher.getWatchableObjectByte(18) & 1) != 0;
	}
	
	public boolean isBegging() {
		
		return (this.dataWatcher.getWatchableObjectByte(18) & 2) != 0;
	}
	
	public boolean isLeashed() {
		
		return (this.dataWatcher.getWatchableObjectByte(18) & 8) != 0;
	}
	
	public void setHasCollar(boolean par0) {
		
		this.dataWatcher.updateObject(18, (byte) (this.dataWatcher.getWatchableObjectByte(18) + (par0 ? 4:-4)));
	}
	
	public void setTailAnimated(boolean par0) {
		
		this.dataWatcher.updateObject(18, (byte) (this.dataWatcher.getWatchableObjectByte(18) + (par0 ? 1:-1)));
	}
	
	public void setBegging(boolean par0) {
		
		this.dataWatcher.updateObject(18, (byte) (this.dataWatcher.getWatchableObjectByte(18) + (par0 ? 2:-2)));
	}
	
	public void setLeashed(boolean par0) {
		
		this.dataWatcher.updateObject(18, (byte) (this.dataWatcher.getWatchableObjectByte(18) + (par0 ? 8:-8)));
	}
	
	public byte getCollarColor() {
		
		return this.dataWatcher.getWatchableObjectByte(21);
	}
	
	public void setCollarColor(byte par0) {
		
		this.dataWatcher.updateObject(21, par0);
	}
	
	@Override
	protected int getDropItemId()
	{
		return -1;
	}
	
	@Override
	protected String getLivingSound()
    {
        return "mob.wolf.bark";
    }

	@Override
    protected String getHurtSound()
    {
        return "mob.wolf.hurt";
    }

	@Override
    protected String getDeathSound()
    {
        return "mob.wolf.death";
    }

	@Override
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.worldObj.playSoundAtEntity(this, "mob.wolf.step", 0.15F, 1.0F);
    }

	@Override
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	@Override
	protected void updateAITick() {
		
		this.dataWatcher.updateObject(19, new Float(this.func_110143_aJ()));
	}
	
	@Override
	protected void entityInit() {
		
		super.entityInit();
		this.dataWatcher.addObject(18, (byte)0);
		this.dataWatcher.addObject(19, new Float(this.func_110143_aJ()));
		this.dataWatcher.addObject(20, (byte)0);
		this.dataWatcher.addObject(21, (byte)-1);
	}
	
	public Dog(World world, float moveSpeed) {
		
		super(world);
		this.moveSpeed = moveSpeed;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIFollowOwnerLeashed(this, moveSpeed, 5.0F, 2.0F));
		this.tasks.addTask(2, new EntityAIWander(this, moveSpeed));
		this.tasks.addTask(8, new EntityAIBegBiscuit(this, 2F));
    	this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    	this.tasks.addTask(9, new EntityAILookIdle(this));
	}


	public void setTamed(boolean par1)
	{
		super.setTamed(par1);

		if (par1)
		{
			this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
    	}
		else
		{	
			this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8.0D);
		}
		
		setTailAnimated(true);
	}
	
	public void tryToTame(EntityPlayer player) {
		
		if (getTameValue() >= 10) {
			
			setTamed(true);
			setOwner(player.getEntityName());
			playTameEffect(true);
		
		}
		else {
					
			playTameEffect(false);
		}
	}
	
	public void setTameValue(byte par0) {
		
		this.dataWatcher.updateObject(20, par0);
	}
	
	public byte getTameValue() {
		
		return this.dataWatcher.getWatchableObjectByte(20);
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer) {
	
		ItemStack stack = par1EntityPlayer.getCurrentEquippedItem();
	
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		
		return null;
	}
}
