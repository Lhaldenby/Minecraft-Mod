package com.ThreeFoolsStudios.SpectralMod.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Packets.LevelMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.RechargeMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.ResetMessage;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;

public class ItemNecromanticParchment extends Item {
	
	public ItemNecromanticParchment(){
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
	public ItemStack onItemRightClick(ItemStack stack, World worldIn,
			EntityPlayer playerIn) {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(playerIn);
		
		MovingObjectPosition LookAt = playerIn.rayTrace(SpectralPlayer.GetRange(), SpectralPlayer.GetRange());
	     double xCoord = LookAt.getBlockPos().getX();
	     double yCoord = LookAt.getBlockPos().getY();
	     double zCoord = LookAt.getBlockPos().getZ();
	     int i;
	     int j;
	     int k;
		EntityPlayer Target = worldIn.getClosestPlayer(xCoord, yCoord, zCoord, (SpectralPlayer.GetRange() / 4));
				if (!playerIn.isSneaking() && SpectralPlayer.GetActiveClass() == 3){
					
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
								SpectralMod.Proxy.generateNecromanticParticles(playerIn);
							}	
							if (!worldIn.isRemote){
								switch (SpectralPlayer.GetSpell1Level()){
								case 1:
									EntityIronGolem IronGolem = new EntityIronGolem(worldIn);
		    	 					IronGolem.setLocationAndAngles(xCoord, yCoord + 1, zCoord, 1, 0.0F);
		    	 					IronGolem.tasks.addTask(2, new EntityAIAttackOnCollide(IronGolem, EntityPlayer.class, 1.0D, true));
		    	 					IronGolem.targetTasks.addTask(2, new EntityAINearestAttackableTarget(IronGolem, EntityPlayer.class, false));
		    	 					worldIn.spawnEntityInWorld(IronGolem);
									break;
								case 2:
									EntitySkeleton Skeleton = new EntitySkeleton(worldIn);
		    	 					Skeleton.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
		    	 					Skeleton.setCurrentItemOrArmor(1, new ItemStack(Items.iron_chestplate));
		    	 					Skeleton.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
		    	 					Skeleton.setCurrentItemOrArmor(3, new ItemStack(Items.iron_boots));
		    	 					Skeleton.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
		    				    	Skeleton.setPosition(xCoord, yCoord + 1, zCoord);
		    				    	Skeleton.tasks.addTask(2, new EntityAIAttackOnCollide(Skeleton, EntityPlayer.class, 1.0D, true));
		    	 					Skeleton.targetTasks.addTask(2, new EntityAINearestAttackableTarget(Skeleton, EntityPlayer.class, false));
		    				    	worldIn.spawnEntityInWorld(Skeleton);
									break;
								case 3:
									EntityZombie Zombie = new EntityZombie(worldIn);
		    	 					Zombie.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
		    	 					Zombie.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_chestplate));
		    	 					Zombie.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_leggings));
		    	 					Zombie.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_boots));
		    	 					Zombie.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
		    				    	Zombie.setPosition(xCoord, yCoord + 1, zCoord);
		    				    	Zombie.tasks.addTask(2, new EntityAIAttackOnCollide(Zombie, EntityPlayer.class, 1.0D, true));
		    	 					Zombie.targetTasks.addTask(2, new EntityAINearestAttackableTarget(Zombie, EntityPlayer.class, false));
		    				    	worldIn.spawnEntityInWorld(Zombie);
									break;
								}
							}
						}
						break;
					case 2:
						if (SpectralPlayer.GetSpellTwoRechargeTime() == 0){

							LevelUp(playerIn, worldIn);
							
							SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
							SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
							SpectralPlayer.GetPoints()));
														
							SpectralPlayer.SetSpellTwoRechargeTime(60);
											
							SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
							SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
							SpectralPlayer.GetSpellFourRechargeTime()));
									
							for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
								SpectralMod.Proxy.generateNecromanticParticles(playerIn);
							}	
							if (!worldIn.isRemote){
								switch (SpectralPlayer.GetSpell2Level()){
									case 1:
										playerIn.addPotionEffect(new PotionEffect(Potion.invisibility.id, 280, 2));
										break;
									case 2:
										playerIn.addPotionEffect(new PotionEffect(Potion.invisibility.id, 280, 2));
										playerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 280, 2));
										playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 280, 2));
										break;
									case 3:
										playerIn.addPotionEffect(new PotionEffect(Potion.invisibility.id, 280, 2));
										playerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 280, 2));
										playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 280, 2));
										for (i=1; i<5; i++){
											EntityPlayer Blind = 
													worldIn.getClosestPlayer(playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), i);
											Blind.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 2));
										}
										break;
								}
							}
						}
						break;
					case 3:
						if (SpectralPlayer.GetSpellThreeRechargeTime() == 0){

							if(Target != null){
							LevelUp(playerIn, worldIn);
							}
							
							SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
							SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
							SpectralPlayer.GetPoints()));
								
							if(Target != null){
							SpectralPlayer.SetSpellThreeRechargeTime(60);
							}
							
							SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
							SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
							SpectralPlayer.GetSpellFourRechargeTime()));
									
							for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
								SpectralMod.Proxy.generateNecromanticParticles(playerIn);
							}	
							if (!worldIn.isRemote && Target != null){
								ExtendedSpectralPlayer SpectralTarget = ExtendedSpectralPlayer.get(Target);
								switch (SpectralPlayer.GetSpell3Level()){
									case 1:
										SpectralTarget.setWarpTimer(200);
										break;
									case 2:
										SpectralTarget.setWarpTimer(200);
										break;
									case 3:
										SpectralTarget.setWarpTimer(200);
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
								SpectralMod.Proxy.generateNecromanticParticles(playerIn);
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
