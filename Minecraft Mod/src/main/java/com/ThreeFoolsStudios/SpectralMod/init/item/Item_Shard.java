package com.ThreeFoolsStudios.SpectralMod.init.item;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Item_Shard extends Item{

	public Item_Shard(){
		this.maxStackSize = 64;
	}

	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		  playerIn.addStat(SpectralMod.achievementGetShard, 1);			
	  }
	
}
