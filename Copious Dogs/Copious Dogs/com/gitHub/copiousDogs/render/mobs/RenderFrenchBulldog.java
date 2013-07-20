package com.gitHub.copiousDogs.render.mobs;

import com.gitHub.copiousDogs.mobs.FrenchBullDog;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderFrenchBulldog extends RenderLiving
{
	public RenderFrenchBulldog(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		// TODO Auto-generated constructor stub
	}

	public void renderTutorial(FrenchBullDog entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((FrenchBullDog)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((FrenchBullDog)par1Entity, par2, par4, par6, par8, par9);
    }

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return new ResourceLocation("copiousDogs:textures/mobs/frenchbulldogtexture.png");
	}
}