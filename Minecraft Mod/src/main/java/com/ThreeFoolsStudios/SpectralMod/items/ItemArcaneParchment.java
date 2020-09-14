package com.ThreeFoolsStudios.SpectralMod.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Packets.LevelMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.RechargeMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.ResetMessage;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;

public class ItemArcaneParchment extends Item {
	
	public ItemArcaneParchment(){
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
		
		Vec3 TargetBlock = playerIn.getLook(SpectralPlayer.GetRange());
		MovingObjectPosition LookAt = playerIn.rayTrace(SpectralPlayer.GetRange(), SpectralPlayer.GetRange());
	     double xCoord = LookAt.getBlockPos().getX();
	     double yCoord = LookAt.getBlockPos().getY();
	     double zCoord = LookAt.getBlockPos().getZ();
	     int i;
	     int j;
	     int k;
		EntityPlayer Target = worldIn.getClosestPlayer(xCoord, yCoord, zCoord, (SpectralPlayer.GetRange() / 4));
		
		EntityMob Entity = (EntityMob) worldIn.findNearestEntityWithinAABB(EntityMob.class, AxisAlignedBB.fromBounds(xCoord, yCoord,zCoord, 
				xCoord + 10, yCoord + 10, zCoord + 10), playerIn);
				if (!playerIn.isSneaking()  && SpectralPlayer.GetActiveClass() == 1){
					
					playerIn.addStat(SpectralMod.achievementCastFirstSpell, 1);
					switch (SpectralPlayer.GetActiveSpell()){
					case 1:
						if (SpectralPlayer.GetSpellOneRechargeTime() == 0){
							
							LevelUp(playerIn,worldIn);
							
							SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
							SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
							SpectralPlayer.GetPoints()));
													
							SpectralPlayer.SetSpellOneRechargeTime(60);
							
							SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
							SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
							SpectralPlayer.GetSpellFourRechargeTime()));
								
							for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
								SpectralMod.Proxy.generateArcaneParticles(playerIn);
							}
							if (!worldIn.isRemote){
								switch (SpectralPlayer.GetSpell1Level()){
								case 1:
									//worldIn.get
									worldIn.destroyBlock(new BlockPos(xCoord, yCoord, zCoord), true);
									break;
								case 2:
									worldIn.destroyBlock(new BlockPos(xCoord, yCoord, zCoord), true);
									worldIn.destroyBlock(new BlockPos(xCoord + 1, yCoord, zCoord), true);
									worldIn.destroyBlock(new BlockPos(xCoord - 1, yCoord, zCoord), true);
									worldIn.destroyBlock(new BlockPos(xCoord, yCoord, zCoord + 1), true);
									worldIn.destroyBlock(new BlockPos(xCoord, yCoord, zCoord - 1), true);
									worldIn.destroyBlock(new BlockPos(xCoord + 1, yCoord, zCoord + 1), true);
									worldIn.destroyBlock(new BlockPos(xCoord + 1, yCoord, zCoord - 1), true);
									worldIn.destroyBlock(new BlockPos(xCoord - 1, yCoord, zCoord + 1), true);
									worldIn.destroyBlock(new BlockPos(xCoord - 1, yCoord, zCoord - 1), true);
									break;
								case 3:
									for (i=0; i<3; i++){
										worldIn.destroyBlock(new BlockPos(xCoord, yCoord - i, zCoord), true);
										worldIn.destroyBlock(new BlockPos(xCoord + 1, yCoord - i, zCoord), true);
										worldIn.destroyBlock(new BlockPos(xCoord - 1, yCoord - i, zCoord), true);
										worldIn.destroyBlock(new BlockPos(xCoord, yCoord - i, zCoord + 1), true);
										worldIn.destroyBlock(new BlockPos(xCoord, yCoord - i, zCoord - 1), true);
										worldIn.destroyBlock(new BlockPos(xCoord + 1, yCoord - i, zCoord + 1), true);
										worldIn.destroyBlock(new BlockPos(xCoord + 1, yCoord - i, zCoord - 1), true);
										worldIn.destroyBlock(new BlockPos(xCoord - 1, yCoord - i, zCoord + 1), true);
										worldIn.destroyBlock(new BlockPos(xCoord - 1, yCoord - i, zCoord - 1), true);
									}
									break;
								}
							}
						}
						break;
					case 2:
						if (SpectralPlayer.GetSpellTwoRechargeTime() == 0){
							
							if (Target != null && Entity != null){
							LevelUp(playerIn,worldIn);
							}
							SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
							SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
							SpectralPlayer.GetPoints()));
							
							if (Target != null && Entity != null){
							SpectralPlayer.SetSpellTwoRechargeTime(60);
							}
							
							SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
							SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
							SpectralPlayer.GetSpellFourRechargeTime()));
														
							for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
								SpectralMod.Proxy.generateArcaneParticles(playerIn);
							}
							if (!worldIn.isRemote){
							switch (SpectralPlayer.GetSpell2Level()){
								case 1:
									Entity.attackEntityFrom(DamageSource.generic, 3);
									Target.attackEntityFrom(DamageSource.generic, 3);
									break;
								case 2:
									Entity.attackEntityFrom(DamageSource.generic, 5);
									Target.attackEntityFrom(DamageSource.generic, 5);
									break;
								case 3:
									Entity.attackEntityFrom(DamageSource.generic, 8);
									Target.attackEntityFrom(DamageSource.generic, 8);
									break;
								}
							}
							
						}
						break;
					case 3:
						if (SpectralPlayer.GetSpellThreeRechargeTime() == 0){
							
							if (Target != null){
							LevelUp(playerIn,worldIn);
							}
							
							SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
							SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
							SpectralPlayer.GetPoints()));
							
							if (Target != null){
							SpectralPlayer.SetSpellThreeRechargeTime(60);
							}
							
							SpectralMod.network.sendToServer(new RechargeMessage(SpectralPlayer.GetSpellOneRechargeTime(),
							SpectralPlayer.GetSpellTwoRechargeTime(), SpectralPlayer.GetSpellThreeRechargeTime(), 
							SpectralPlayer.GetSpellFourRechargeTime()));
																		
							for (i=0; i< (worldIn.rand.nextInt(5) + 1); i++){	
								SpectralMod.Proxy.generateArcaneParticles(playerIn);
							}
							if (!worldIn.isRemote){
							switch (SpectralPlayer.GetSpell3Level()){
								case 1:
									Target.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2));
									break;
								case 2:
									Target.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 4));
									break;
								case 3:
									Target.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 4));
									Target.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 2));
									Target.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 2));
									break;
								}
							}
						}
						break;
					case 4: 
						if (SpectralPlayer.GetSpellFourRechargeTime() == 0){
							
							if (Target != null){
							LevelUp(playerIn,worldIn);
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
								SpectralMod.Proxy.generateArcaneParticles(playerIn);
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
