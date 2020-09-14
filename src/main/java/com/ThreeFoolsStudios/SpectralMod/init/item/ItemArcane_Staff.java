package com.ThreeFoolsStudios.SpectralMod.init.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

public class ItemArcane_Staff extends Item{
	
	  public static final String[] bowPullIconNameArray = { "pulling_0", "pulling_1", "pulling_2" };
	  private static final String __OBFID = "CL_00001777";
	  
	  public ItemArcane_Staff()
	  {
	    this.maxStackSize = 1;
	  }
	  
	  public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		  playerIn.addStat(SpectralMod.achievementMakeStaff, 1);			
	  }
	  
	  public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
	    {
		  	int ticksInUse = getMaxItemUseDuration(stack) - count;
		  	if (ticksInUse % 10 == 0) {
		  	int j = 100;
		    boolean flag = true;
		    float f = j / 20.0F;
		      f = (f * f + f * 2.0F) / 3.0F;
		      if (f < 0.1D) {
		        return;
		      }
		      if (f > 1.0F) {
		        f = 1.0F;
		      }
		      EntityArrow entityarrow = new EntityArrow(player.worldObj, player, f * 2.0F);
		      if (!player.worldObj.isRemote) {
		        player.worldObj.spawnEntityInWorld(entityarrow);
		        }
		  	}
	    }
	  
	  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	  {
	    return stack;
	  }
	  
	  public int getMaxItemUseDuration(ItemStack stack)
	  {
	    return 72000;
	  }
	  
	  public EnumAction getItemUseAction(ItemStack stack)
	  {
	    return EnumAction.BOW;
	  }
	  
	  public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	  {
	    ArrowNockEvent event = new ArrowNockEvent(playerIn, itemStackIn);
	    if (MinecraftForge.EVENT_BUS.post(event)) {
	      return event.result;
	    }
	      playerIn.setItemInUse(itemStackIn, getMaxItemUseDuration(itemStackIn));
	    return itemStackIn;
	  }
	  
	  public int getItemEnchantability()
	  {
	    return 1;
	  }
}

