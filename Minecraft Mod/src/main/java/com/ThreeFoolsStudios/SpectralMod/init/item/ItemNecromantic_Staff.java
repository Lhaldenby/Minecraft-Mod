package com.ThreeFoolsStudios.SpectralMod.init.item;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemNecromantic_Staff extends Item{
	
public static final String[] bowPullIconNameArray = { "pulling_0", "pulling_1", "pulling_2" };
private static final String __OBFID = "CL_00001777";

public ItemNecromantic_Staff()
{
  this.maxStackSize = 1;
}

public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
	  playerIn.addStat(SpectralMod.achievementMakeStaff, 1);			
}

public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
{
  int j = getMaxItemUseDuration(stack) - timeLeft;
  ArrowLooseEvent event = new ArrowLooseEvent(playerIn, stack, j);
  if (MinecraftForge.EVENT_BUS.post(event)) {
    return;
  }
  j = event.charge;
  
  boolean flag = (playerIn.capabilities.isCreativeMode) || (EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0) ||
  		(!playerIn.capabilities.isCreativeMode);
  if ((flag) || (playerIn.inventory.hasItem(Items.arrow)))
  {
    float f = j / 20.0F;
    f = (f * f + f * 2.0F) / 3.0F;
    if (f < 0.1D) {
      return;
    }
    if (f > 1.0F) {
      f = 1.0F;
    }
    EntityArrow entityarrow = new EntityArrow(worldIn, playerIn, f * 2.0F);
    if (f == 1.0F) {
      entityarrow.setIsCritical(true);
    }
    int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
    if (k > 0) {
      entityarrow.setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
    }
    int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
    if (l > 0) {
      entityarrow.setKnockbackStrength(l);
    }
    if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
      entityarrow.setFire(100);
    }
    stack.damageItem(1, playerIn);
    worldIn.playSoundAtEntity(playerIn, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
    if (flag) {
      entityarrow.canBePickedUp = 2;
    } else {
      playerIn.inventory.consumeInventoryItem(Items.arrow);
    }
    playerIn.triggerAchievement(net.minecraft.stats.StatList.objectUseStats[Item.getIdFromItem(this)]);
    if (!worldIn.isRemote) {
      worldIn.spawnEntityInWorld(entityarrow);
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
  if ((playerIn.capabilities.isCreativeMode) || (playerIn.inventory.hasItem(Items.arrow)) ||
	    	(!playerIn.capabilities.isCreativeMode)) {
    playerIn.setItemInUse(itemStackIn, getMaxItemUseDuration(itemStackIn));
  }
  return itemStackIn;
}

public int getItemEnchantability()
{
  return 1;
}
}

