package com.gitHub.copiousDogs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.gitHub.copiousDogs.mobs.Dog;

public class DogBiscuit extends ItemCopiousDogs
{
	public DogBiscuit(int id)
	{
		super(id);
		setUnlocalizedName("DogBiscuit");
		setMaxStackSize(64);
	}
	
	public float getHealAmount()
	{
		return 3;
	}
	
	@Override
	public boolean func_111207_a(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
		
		if (par3EntityLivingBase instanceof Dog) {
			
			Dog dog = (Dog) par3EntityLivingBase;
				
			if (!dog.isTamed()) {
				
				par2EntityPlayer.swingItem();
						
				dog.setTameValue((byte)(dog.getTameValue() + dog.getRNG().nextInt(10)));
						
				dog.tryToTame(par2EntityPlayer);
				
				if (!par2EntityPlayer.capabilities.isCreativeMode) {
					
					par1ItemStack.stackSize--;
				}
						
				return true;
			}
		}
		
		return false;
	}
}
