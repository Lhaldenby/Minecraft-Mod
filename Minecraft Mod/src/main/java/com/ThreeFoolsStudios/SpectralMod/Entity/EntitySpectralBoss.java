package com.ThreeFoolsStudios.SpectralMod.Entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntitySpectralBoss extends EntityMob{

	public EntitySpectralBoss(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void applyEntityAttributes()
	{
	    super.applyEntityAttributes(); 

	    // standard attributes registered to EntityLivingBase
	   getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);
	   getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	   getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10.D);
	   getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);

	    // need to register any additional attributes
	   getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	   getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
	}
	
	protected boolean isAIEnabled()
	{
	   return true;
	}
	
	protected void setupAI(){
   
	}
	
	protected void clearAITasks()
	{
	   tasks.taskEntries.clear();
	   targetTasks.taskEntries.clear();
	}
	
}
