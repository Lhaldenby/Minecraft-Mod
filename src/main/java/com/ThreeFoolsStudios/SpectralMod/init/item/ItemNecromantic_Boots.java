package com.ThreeFoolsStudios.SpectralMod.init.item;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNecromantic_Boots extends ItemArmor {

	public ItemNecromantic_Boots(ArmorMaterial material, int renderIndex,
			int armorType) {
		super(material, renderIndex, armorType);
	}
	
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		  playerIn.addStat(SpectralMod.achievementMakeArmour, 1);			
	  }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		return "spm:textures/models/armor/Necromantic_Layer_1.png";
	}

}
