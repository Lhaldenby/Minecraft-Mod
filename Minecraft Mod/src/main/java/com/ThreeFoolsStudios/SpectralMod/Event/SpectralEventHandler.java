package com.ThreeFoolsStudios.SpectralMod.Event;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Packets.ActiveSpellMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.RechargeMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.TargetMessage;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;
import com.ThreeFoolsStudios.SpectralMod.proxy.ClientProxy;
import com.ThreeFoolsStudios.SpectralMod.proxy.CommonProxy;

public class SpectralEventHandler {
	
	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event)
	{
		if ((!event.player.worldObj.isRemote) && (!event.player.inventory.hasItem(SpectralItems.Spectral_Tomb))){
			
			event.player.inventory.addItemStackToInventory(new ItemStack(SpectralItems.Spectral_Tomb));
		}
	
	} 
	
	@SubscribeEvent
	public void onEntityConstructed(EntityEvent.EntityConstructing event)
	{
		//if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer && FirstJoin == true){
		//	System.out.println("respawn");
		//	NBTTagCompound playerData = CommonProxy.getEntityData(((EntityPlayer) event.entity).getCustomNameTag());
		//	if (playerData != null){
		//		((ExtendedSpectralPlayer)(event.entity.getExtendedProperties(ExtendedSpectralPlayer.SPECTRAL_PLAYER))).loadNBTData(playerData);
		//	}
		//}
		
		if (event.entity instanceof EntityPlayer && ExtendedSpectralPlayer.get((EntityPlayer) event.entity) == null){
			ExtendedSpectralPlayer.register((EntityPlayer) event.entity);
			System.out.println("new player");
		}
		
	}
	
	@SubscribeEvent
	public void OnLivingDeathEvent(LivingDeathEvent event){
	//	if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
	//		NBTTagCompound playerData = new NBTTagCompound();
	//		((ExtendedSpectralPlayer)(event.entity.getExtendedProperties(ExtendedSpectralPlayer.SPECTRAL_PLAYER))).saveNBTData(playerData);
	//		CommonProxy.storeEntityData(((EntityPlayer) event.entity).getName(), playerData);
	//		ExtendedSpectralPlayer.saveProxyData((EntityPlayer) event.entity);
	//	}		
	}
	
	//@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void TickEvent(PlayerTickEvent event){
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(event.player);
		
	    KeyBinding[] keyBindings = ClientProxy.keyBindings;
	   
	    // check each enumerated key binding type for pressed and take appropriate action
	    if (keyBindings[0].isPressed()) 
	    {
	        SpectralPlayer.SpectralSpellChangeUp(); 	
	    	SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
	    }
	    if (keyBindings[1].isPressed()) 
	    {
	        SpectralPlayer.SpectralSpellChangeDown(); 
	        SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
	    }
	    
	    if (SpectralPlayer.GetFrozenTimer() != 0 && SpectralPlayer.GetSpell2Level() == 1){
	    	SpectralPlayer.SetFrozen(1);
	    	SpectralPlayer.ReduceFrozenTime(1);
			if (SpectralPlayer.GetFrozenTimer() == 0){
		    	SpectralPlayer.SetFrozen(0);
		    }
	    	event.player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 1));
	    	SpectralMod.network.sendToServer(new TargetMessage(SpectralPlayer.GetWarped(), SpectralPlayer.GetFrozen(),
	    			SpectralPlayer.GetWarpTimer(), SpectralPlayer.GetFrozenTimer()));
		 }
	    
	    if (SpectralPlayer.GetFrozenTimer() != 0 && SpectralPlayer.GetSpell2Level() == 2){
	    	SpectralPlayer.SetFrozen(1);
	    	SpectralPlayer.ReduceFrozenTime(1);
	    	if (SpectralPlayer.GetFrozenTimer() == 0){
		    	SpectralPlayer.SetFrozen(0);
		    }
	    	event.player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 1));
	    	event.player.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 1));
	    	SpectralMod.network.sendToServer(new TargetMessage(SpectralPlayer.GetWarped(), SpectralPlayer.GetFrozen(),
	    			SpectralPlayer.GetWarpTimer(), SpectralPlayer.GetFrozenTimer()));
	    }
	    
	    if (SpectralPlayer.GetFrozenTimer() != 0 && SpectralPlayer.GetSpell2Level() == 3){
	    	SpectralPlayer.SetFrozen(1);
	    	SpectralPlayer.ReduceFrozenTime(1);
	    	if (SpectralPlayer.GetFrozenTimer() == 0){
		    	SpectralPlayer.SetFrozen(0);
		    }
	    	event.player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 1));
	    	event.player.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 1));
	    	event.player.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 1));
	    	SpectralMod.network.sendToServer(new TargetMessage(SpectralPlayer.GetWarped(), SpectralPlayer.GetFrozen(),
	    			SpectralPlayer.GetWarpTimer(), SpectralPlayer.GetFrozenTimer()));
	     }
	    
	    if (SpectralPlayer.GetWarpTimer()!= 0 && SpectralPlayer.GetSpell3Level() == 1){
	    	if (SpectralPlayer.GetWarpTimer() == 200 && event.player.dimension != -1){
	    		event.player.travelToDimension(-1);
	    	}
	    	
	    	SpectralPlayer.ReduceWarpTime(1);
	    	
	    	if (SpectralPlayer.GetWarpTimer() == 0 && event.player.dimension != 0){
	    		event.player.travelToDimension(0);
	    	}
	    	SpectralMod.network.sendToServer(new TargetMessage(SpectralPlayer.GetWarped(), SpectralPlayer.GetFrozen(),
	    			SpectralPlayer.GetWarpTimer(), SpectralPlayer.GetFrozenTimer()));
	    }
	    
	    if (SpectralPlayer.GetWarpTimer()!= 0 && SpectralPlayer.GetSpell3Level() == 2){
	    	if (SpectralPlayer.GetWarpTimer() == 200 && event.player.dimension != 1){
	    		event.player.travelToDimension(1);
	    	}
	    	
	    	SpectralPlayer.ReduceWarpTime(1);
	    	
	    	if (SpectralPlayer.GetWarpTimer() == 0 && event.player.dimension != 0){
	    		event.player.travelToDimension(0);
	    	}
	    	SpectralMod.network.sendToServer(new TargetMessage(SpectralPlayer.GetWarped(), SpectralPlayer.GetFrozen(),
	    			SpectralPlayer.GetWarpTimer(), SpectralPlayer.GetFrozenTimer()));
	    }

	    if (SpectralPlayer.GetWarpTimer()!= 0 && SpectralPlayer.GetSpell3Level() == 3){
	    	if (SpectralPlayer.GetWarpTimer() == 200 && event.player.dimension != -1){
	    		event.player.travelToDimension(-1);
	    	}
	    	
	    	SpectralPlayer.ReduceWarpTime(1);
	    	
	    	if (SpectralPlayer.GetWarpTimer() == 100 && event.player.dimension != 1){
	    		event.player.travelToDimension(1);
	    	}
	    	
	    	if (SpectralPlayer.GetWarpTimer() == 0 && event.player.dimension != 0){
	    		event.player.travelToDimension(0);
	    	}
	    	SpectralMod.network.sendToServer(new TargetMessage(SpectralPlayer.GetWarped(), SpectralPlayer.GetFrozen(),
	    			SpectralPlayer.GetWarpTimer(), SpectralPlayer.GetFrozenTimer()));
	    }
	    
	    if (SpectralPlayer.GetSpellOneRechargeTime() != 0){
	    	SpectralPlayer.ReduceSpellOneRechargeTime(1);
	    	SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
		    SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), SpectralPlayer.GetSpellFourRechargeTime()));
	    	
	    }
	    if (SpectralPlayer.GetSpellTwoRechargeTime() != 0){
	    	SpectralPlayer.ReduceSpellTwoRechargeTime(1);	    	
	    	SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
		    SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), SpectralPlayer.GetSpellFourRechargeTime()));
	    	
	    }
	    if (SpectralPlayer.GetSpellThreeRechargeTime() != 0){
	    	SpectralPlayer.ReduceSpellThreeRechargeTime(1);	    	
	    	SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
		    SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), SpectralPlayer.GetSpellFourRechargeTime()));		   
	    	
	    }
	    if (SpectralPlayer.GetSpellFourRechargeTime() != 0){
	    	SpectralPlayer.ReduceSpellFourRechargeTime(1);	    	
	    	SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
		    SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), SpectralPlayer.GetSpellFourRechargeTime()));
	    	
	    }
	   
	    if (SpectralPlayer.GetSpell1Level() == 3 || SpectralPlayer.GetSpell2Level() == 3 || SpectralPlayer.GetSpell3Level() == 3){
			event.player.addStat(SpectralMod.achievementFullSpell, 1);
	    }
	    if (SpectralPlayer.GetSpell1Level() >= 1 && SpectralPlayer.GetSpell2Level() >= 1 && 
	    	SpectralPlayer.GetSpell3Level() >= 1 && SpectralPlayer.GetMasterSpell() != 0){
	    	event.player.addStat(SpectralMod.achievementAllSpells, 1);
	    }
	    if (SpectralPlayer.GetActiveClass() != 0){
	    	event.player.addStat(SpectralMod.achievementChooseClass, 1);
	    }
	    if (SpectralPlayer.GetSpectralLevel() > 1){
	    	event.player.addStat(SpectralMod.achievementLevelUp, 1);
	    }
	    if (SpectralPlayer.GetSpectralLevel() == 10){
	    	event.player.addStat(SpectralMod.achievementMaxLevel, 1);
	    }
	    
	       event.player.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
	       .setBaseValue(event.player.capabilities.getWalkSpeed() + (SpectralPlayer.GetSpeed() / 10));
	      
	       event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth)
	       .setBaseValue(20 + SpectralPlayer.GetHealth());
	       
	       event.player.getEntityAttribute(SharedMonsterAttributes.attackDamage)
	       .setBaseValue( 5 + SpectralPlayer.GetStrength());
	       
	       event.player.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
	       .setBaseValue(SpectralPlayer.GetResistance());
	      
	}
	
}
