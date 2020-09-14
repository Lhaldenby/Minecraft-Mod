package com.ThreeFoolsStudios.SpectralMod.items;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Gui.GuiBook;
import com.ThreeFoolsStudios.SpectralMod.Gui.SpectralGuiHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemSpectralTomb extends Item {
	
	public ItemSpectralTomb(){
	this.maxStackSize = 1;
	}
	 @Override
	    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		 playerIn.addStat(SpectralMod.achievementStartSpectralMagic, 1);
	        if (worldIn.isRemote) {
	            playerIn.openGui(SpectralMod.instance, 0, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);	            
	        }
	        return itemStackIn;
	    }		

}
