package com.gitHub.copiousDogs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.gitHub.copiousDogs.CopiousDogs;
import com.gitHub.copiousDogs.mobs.Dog;

public class DogLeash extends ItemCopiousDogs {
	
	public DogLeash(int id) {
		
		super(id);
		setUnlocalizedName("dogLeash");
	}
	
	@Override
	public boolean func_111207_a(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
		
		if (par3EntityLivingBase instanceof Dog) {
			
			Dog dog = (Dog) par3EntityLivingBase;
			
			if (dog.hasCollar()) {
				
				par2EntityPlayer.swingItem();
				
				if (!dog.isLeashed()) {
					
					dog.setLeashed(true);
				}
				else {
					
					dog.setLeashed(false);
				}
				
				System.out.println(dog.isLeashed());
				
				return true;
			}
		}
			
		return false;
	}
}
