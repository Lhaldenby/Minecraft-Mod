package com.ThreeFoolsStudios.SpectralMod.init.item;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemElemental_Staff extends Item{
	
	  public static final String[] bowPullIconNameArray = { "pulling_0", "pulling_1", "pulling_2" };
	  private static final String __OBFID = "CL_00001777";
	  
	  public ItemElemental_Staff()
	  {
	    this.maxStackSize = 1;
	  }
	  
	  public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		  playerIn.addStat(SpectralMod.achievementMakeStaff, 1);			
	  }
	  
	  @Override
		public ItemStack onItemRightClick(ItemStack stack, World worldIn,
				EntityPlayer playerIn) {
	
		 return stack;
		  
	  }
	    
}
