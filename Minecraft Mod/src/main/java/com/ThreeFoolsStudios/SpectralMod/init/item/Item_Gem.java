package com.ThreeFoolsStudios.SpectralMod.init.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;

public class Item_Gem extends Item{

	public Item_Gem(){
		this.maxStackSize = 64;
	}

	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		  playerIn.addStat(SpectralMod.achievementMakeGem, 1);			
	  }
	
}
