package com.gitHub.copiousDogs.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.world.World;

public class Husky extends Dog
{

	public Husky(World world)
	{
		super(world, .5F);
		this.setSize(0.4f, 1);
	}
	
	public int getAttackStrength(Entity par1Entity)
    {
		return 2;
    }
}