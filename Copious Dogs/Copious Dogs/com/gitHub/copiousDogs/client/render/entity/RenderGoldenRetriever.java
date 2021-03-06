package com.gitHub.copiousDogs.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemDye;
import net.minecraft.util.ResourceLocation;

import com.gitHub.copiousDogs.entity.Dog;
import com.gitHub.copiousDogs.entity.GoldenRetriever;

public class RenderGoldenRetriever extends RenderDog
{

	public RenderGoldenRetriever(ModelBase par1ModelBase, ModelBase par2ModelBase, float shadowSize)
	{
		super(par1ModelBase, par2ModelBase, shadowSize, "goldenretrievertexture");
	}

	public void renderTutorial(GoldenRetriever entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((GoldenRetriever)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((GoldenRetriever)par1Entity, par2, par4, par6, par8, par9);
    }
}
