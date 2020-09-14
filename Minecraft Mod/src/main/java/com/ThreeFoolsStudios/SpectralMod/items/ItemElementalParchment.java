package com.ThreeFoolsStudios.SpectralMod.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Packets.LevelMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.RechargeMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.ResetMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.TargetMessage;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;

public class ItemElementalParchment extends Item {
	
	public ItemElementalParchment(){
		this.maxStackSize = 1;
	}
	
	public void LevelUp(EntityPlayer playerIn, World worldIn) {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(playerIn);
		
		SpectralPlayer.SpectralExperienceGive(5);
		if (SpectralPlayer.GetExperience() >= SpectralPlayer.GetExperienceNeeded()) {
			
		if ( (SpectralPlayer.GetSpectralLevel() == 1 && SpectralPlayer.GetNumberOfSpells() == 1) ||
				
				(SpectralPlayer.GetSpectralLevel() == 2 && (SpectralPlayer.GetNumberOfSpells() == 2 ||
				SpectralPlayer.GetSpell1Level() == 2 || SpectralPlayer.GetSpell2Level() == 2 ||
				SpectralPlayer.GetSpell3Level() == 2)) ||
				
				(SpectralPlayer.GetSpectralLevel() == 3 && (SpectralPlayer.GetSpell1Level() == 3 ||
				SpectralPlayer.GetSpell2Level() == 3 || SpectralPlayer.GetSpell3Level() == 3 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell1Level() == 1 ||
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetSpell1Level() == 1 ||
				SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 1)) ||
				
				(SpectralPlayer.GetSpectralLevel() == 4 && (
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 2 ||
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell1Level() == 2 ||
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2 ||
				SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetSpell1Level() == 2 ||
				SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetSpell2Level() == 2 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell1Level() == 1 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell1Level() == 1 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 1 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 2)) ||
						
				(SpectralPlayer.GetSpectralLevel() == 5 && (
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell1Level() == 2 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell1Level() == 2 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 &&	
				SpectralPlayer.GetSpell3Level() == 1 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2)) ||

				(SpectralPlayer.GetSpectralLevel() == 6 && (
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 1 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 3 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 3)) ||

				(SpectralPlayer.GetSpectralLevel() == 7 &&(
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 ||
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 1 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3 ||
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 3))||

				(SpectralPlayer.GetSpectralLevel() == 8 && (
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 &&
				SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetMasterSpell() != 0 ||
				SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetMasterSpell() != 0)) ||

				(SpectralPlayer.GetSpectralLevel() == 9 && ( SpectralPlayer.GetMasterSpell() !=0 &&
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 2 || SpectralPlayer.GetMasterSpell() !=0 &&
				SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetMasterSpell() !=0 &&
				SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3 &&
				SpectralPlayer.GetSpell3Level() == 3 || SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3) ) ||

				(SpectralPlayer.GetSpectralLevel() == 10 && SpectralPlayer.GetSpell1Level() == 3 &&
				SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0)
				){
						SpectralPlayer.SpectralLevelUp(1);
				} 
		else {
			playerIn.addChatMessage( new ChatComponentTranslation("Upgrade your spells, then you can level up"));
		}
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn,EntityPlayer playerIn) {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(playerIn);
		
		Vec3 TargetBlock = playerIn.getLook(SpectralPlayer.GetRange());
		MovingObjectPosition LookAt = playerIn.rayTrace(SpectralPlayer.GetRange(), SpectralPlayer.GetRange());
		double xCoord = LookAt.getBlockPos().getX();
	     double yCoord = LookAt.getBlockPos().getY();
	     double zCoord = LookAt.getBlockPos().getZ();
	     int i;
	     int j;
	     int k;
		EntityPlayer Target = worldIn.getClosestPlayer(xCoord, yCoord, zCoord, (SpectralPlayer.GetRange() / 4));
			if (!playerIn.isSneaking() && SpectralPlayer.GetActiveClass() == 2){
				
				playerIn.addStat(SpectralMod.achievementCastFirstSpell, 1);
				switch (SpectralPlayer.GetActiveSpell()){
				case 1:
					if (SpectralPlayer.GetSpellOneRechargeTime() == 0){

						LevelUp(playerIn, worldIn);
						
						SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
						SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
						SpectralPlayer.GetPoints()));
												
						SpectralPlayer.SetSpellOneRechargeTime(60);
								
						SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
						SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
						SpectralPlayer.GetSpellFourRechargeTime()));
													
						for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
							SpectralMod.Proxy.generateElementalParticles(playerIn);
						}
						if (!worldIn.isRemote){
							switch (SpectralPlayer.GetSpell1Level()){
								case 1:
									EntitySmallFireball smallfireball = new EntitySmallFireball(worldIn, playerIn.posX, playerIn.posY + playerIn.height , playerIn.posZ , TargetBlock.xCoord, TargetBlock.yCoord, TargetBlock.zCoord);
									smallfireball.shootingEntity = playerIn;
									worldIn.spawnEntityInWorld(smallfireball);
									break;
								case 2:
									EntityLargeFireball Largefireball = new EntityLargeFireball(worldIn, playerIn.posX, playerIn.posY + playerIn.height , playerIn.posZ , TargetBlock.xCoord, TargetBlock.yCoord, TargetBlock.zCoord);
									Largefireball.shootingEntity = playerIn;
									worldIn.spawnEntityInWorld(Largefireball);
									break;
								case 3:
									for (i=1; i<2; i++){
										EntityLargeFireball Largefireballs = new EntityLargeFireball(worldIn, playerIn.posX, playerIn.posY + playerIn.height , playerIn.posZ , TargetBlock.xCoord, TargetBlock.yCoord, TargetBlock.zCoord);
										Largefireballs.shootingEntity = playerIn;
										worldIn.spawnEntityInWorld(Largefireballs);
									}
									break;
							}
						}
					}
					break;
				case 2:
					if (SpectralPlayer.GetSpellTwoRechargeTime() == 0){

						if (Target != null){
						LevelUp(playerIn, worldIn);
						}
						
						SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
						SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
						SpectralPlayer.GetPoints()));
						
						if (Target != null){
						SpectralPlayer.SetSpellTwoRechargeTime(60);
						}
						
						SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
						SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
						SpectralPlayer.GetSpellFourRechargeTime()));
								
						for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
							SpectralMod.Proxy.generateElementalParticles(playerIn);
						}
						if (!worldIn.isRemote && Target != null){
							ExtendedSpectralPlayer SpectralTarget = ExtendedSpectralPlayer.get(Target);
							switch (SpectralPlayer.GetSpell2Level()){
								case 1:
									SpectralTarget.setFrozenTimer(100);
									SpectralMod.network.sendToServer(new TargetMessage(SpectralTarget.GetWarped(), SpectralTarget.GetFrozen(),
							    			SpectralTarget.GetWarpTimer(), SpectralTarget.GetFrozenTimer()));
									break;
								case 2:
									SpectralTarget.setFrozenTimer(100);
									SpectralMod.network.sendToServer(new TargetMessage(SpectralTarget.GetWarped(), SpectralTarget.GetFrozen(),
							    			SpectralTarget.GetWarpTimer(), SpectralTarget.GetFrozenTimer()));
									break;
								case 3:
									SpectralTarget.setFrozenTimer(200);
									SpectralMod.network.sendToServer(new TargetMessage(SpectralTarget.GetWarped(), SpectralTarget.GetFrozen(),
							    			SpectralTarget.GetWarpTimer(), SpectralTarget.GetFrozenTimer()));		
									break;
							}
						}
					}
					break;
				case 3:
					if (SpectralPlayer.GetSpellThreeRechargeTime() == 0){

						LevelUp(playerIn, worldIn);
						
						SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
						SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
						SpectralPlayer.GetPoints()));
								
						SpectralPlayer.SetSpellThreeRechargeTime(60);
								
						SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
						SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
						SpectralPlayer.GetSpellFourRechargeTime()));
													
						for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
							SpectralMod.Proxy.generateElementalParticles(playerIn);
						}
						if (!worldIn.isRemote){
							switch (SpectralPlayer.GetSpell3Level()){
								case 1:
									EntityLightningBolt LightningBolt = new EntityLightningBolt(worldIn, xCoord, yCoord, zCoord);
									worldIn.addWeatherEffect(LightningBolt);
									break;
								case 2:
									EntityLightningBolt LightningBolt1 = new EntityLightningBolt(worldIn, xCoord, yCoord, zCoord);
									worldIn.addWeatherEffect(LightningBolt1);
									EntityLightningBolt LightningBolt2 = new EntityLightningBolt(worldIn, xCoord + 1, yCoord, zCoord);
									worldIn.addWeatherEffect(LightningBolt2);
									EntityLightningBolt LightningBolt3 = new EntityLightningBolt(worldIn, xCoord - 1, yCoord, zCoord);
									worldIn.addWeatherEffect(LightningBolt3);
									EntityLightningBolt LightningBolt4 = new EntityLightningBolt(worldIn, xCoord, yCoord, zCoord + 1);
									worldIn.addWeatherEffect(LightningBolt4);
									EntityLightningBolt LightningBolt5 = new EntityLightningBolt(worldIn, xCoord, yCoord, zCoord - 1);
									worldIn.addWeatherEffect(LightningBolt5);
									EntityLightningBolt LightningBolt6 = new EntityLightningBolt(worldIn, xCoord + 1, yCoord, zCoord + 1);
									worldIn.addWeatherEffect(LightningBolt6);
									EntityLightningBolt LightningBolt7 = new EntityLightningBolt(worldIn, xCoord + 1, yCoord, zCoord - 1);
									worldIn.addWeatherEffect(LightningBolt7);
									EntityLightningBolt LightningBolt8 = new EntityLightningBolt(worldIn, xCoord - 1, yCoord, zCoord + 1);
									worldIn.addWeatherEffect(LightningBolt8);
									EntityLightningBolt LightningBolt9 = new EntityLightningBolt(worldIn, xCoord - 1, yCoord, zCoord - 1);
									worldIn.addWeatherEffect(LightningBolt9);
									break;
								case 3:
									for (i=2; i<SpectralPlayer.GetRange(); i++){
										EntityLightningBolt LightningBolts = new EntityLightningBolt(worldIn, playerIn.posX + i, playerIn.posY, playerIn.posZ);
										worldIn.addWeatherEffect(LightningBolts);
									}
									break;
							}
						}
						
					}
					break;
				case 4: 
					if (SpectralPlayer.GetSpellFourRechargeTime() == 0){

						if (Target != null){
						LevelUp(playerIn, worldIn);
						}
						
						SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
						SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
						SpectralPlayer.GetPoints()));
						
						if (Target != null){
						SpectralPlayer.SetSpellFourRechargeTime(200);
						}
						
						SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
						SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
						SpectralPlayer.GetSpellFourRechargeTime()));
							
						for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
							SpectralMod.Proxy.generateElementalParticles(playerIn);
						}
						if (!worldIn.isRemote){
							switch (SpectralPlayer.GetMasterSpell()){
								case 1:
									playerIn.setPosition(xCoord, yCoord + 1, zCoord);
									break;
								case 2:
									playerIn.setHealth(20 + SpectralPlayer.GetHealth());
									break;
								case 3:
									if ((playerIn.getRotationYawHead() >= 0 && playerIn.getRotationYawHead() <= 45)
											|| (playerIn.getRotationYawHead() >= -360 && playerIn.getRotationYawHead() <= -315)){
											Block blk = SpectralBlocks.Spectral_Light;
											IBlockState SpectralLight = blk.getDefaultState(); 
											worldIn.setBlockState(new BlockPos(xCoord, yCoord, zCoord - 1), SpectralLight);		
											}
										else if ((playerIn.getRotationYawHead() > 45 && playerIn.getRotationYawHead() <= 90)
												|| (playerIn.getRotationYawHead() > -315 && playerIn.getRotationYawHead() <= -270)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord + 1, yCoord, zCoord ), SpectralLight);		
												}
										else if ((playerIn.getRotationYawHead() > 90 && playerIn.getRotationYawHead() <= 135)
												|| (playerIn.getRotationYawHead() > -270 && playerIn.getRotationYawHead() <= -225)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord + 1, yCoord, zCoord), SpectralLight);		
												}
										else if ((playerIn.getRotationYawHead() > 135 && playerIn.getRotationYawHead() <= 180)
												|| (playerIn.getRotationYawHead() > -225 && playerIn.getRotationYawHead() <= -180)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord, yCoord, zCoord + 1), SpectralLight);		
												}
										else if ((playerIn.getRotationYawHead() > 180 && playerIn.getRotationYawHead() <= 225)
												|| (playerIn.getRotationYawHead() > -180 && playerIn.getRotationYawHead() <= -135)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord, yCoord, zCoord + 1), SpectralLight);		
												}
										else if ((playerIn.getRotationYawHead() > 225 && playerIn.getRotationYawHead() <= 270)
												|| (playerIn.getRotationYawHead() > -135 && playerIn.getRotationYawHead() <= -90)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord - 1, yCoord, zCoord), SpectralLight);		
												}
										else if ((playerIn.getRotationYawHead() > 270 && playerIn.getRotationYawHead() <= 315)
												|| (playerIn.getRotationYawHead() > -90 && playerIn.getRotationYawHead() <= -45)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord - 1, yCoord, zCoord), SpectralLight);		
												}
										else if ((playerIn.getRotationYawHead() > 315 && playerIn.getRotationYawHead() <= 360)
												|| (playerIn.getRotationYawHead() > -45 && playerIn.getRotationYawHead() <= 0)){
												Block blk = SpectralBlocks.Spectral_Light;
												IBlockState SpectralLight = blk.getDefaultState(); 
												worldIn.setBlockState(new BlockPos(xCoord, yCoord, zCoord - 1), SpectralLight);		
												}							
									break;
							}
						}
						
					}
					break;
				}
				
			}
		
		//class ritual
				if (!worldIn.isRemote && playerIn.isSneaking()){
					if (worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Gem_Block &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 2, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 3, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord - 2, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 3, yCoord, zCoord)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord + 1)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord + 2)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord + 3)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord - 1)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord - 2)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord, yCoord, zCoord - 3)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 3, yCoord, zCoord + 1)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 3, yCoord, zCoord - 1)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord - 3, yCoord, zCoord + 1)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord - 3, yCoord, zCoord - 1)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord, zCoord + 3)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord, zCoord + 3)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord, zCoord - 3)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord, zCoord - 3)).getBlock() == SpectralBlocks.Spectral_Stone &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord, zCoord + 1)).getBlock() == Blocks.netherrack &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord, zCoord - 1)).getBlock() == Blocks.netherrack &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord, zCoord + 1)).getBlock() == Blocks.netherrack &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord, zCoord - 1)).getBlock() == Blocks.netherrack &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord + 1, zCoord + 1)).getBlock() == Blocks.fire &&
							worldIn.getBlockState(new BlockPos(xCoord + 1, yCoord + 1, zCoord - 1)).getBlock() == Blocks.fire &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord + 1, zCoord + 1)).getBlock() == Blocks.fire &&
							worldIn.getBlockState(new BlockPos(xCoord - 1, yCoord + 1, zCoord - 1)).getBlock() == Blocks.fire){
					
							SpectralMod.network.sendToServer(new ResetMessage(1,0,50,0,0,0,0,0,0,0,2,10,0,0,0,0));
							
					}
				}
				
		return stack;
	}

}
