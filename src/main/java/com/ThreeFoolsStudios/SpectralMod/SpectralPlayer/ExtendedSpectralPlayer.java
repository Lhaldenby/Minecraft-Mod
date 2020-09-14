package com.ThreeFoolsStudios.SpectralMod.SpectralPlayer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.ThreeFoolsStudios.SpectralMod.proxy.CommonProxy;

public class ExtendedSpectralPlayer implements IExtendedEntityProperties{
	
	public final static String SPECTRAL_PLAYER = "ExtendedSpectralPlayer";
	
	private final EntityPlayer player;
	
	private int SpectralMagicLevel, SpectralMagicExperience, SpectralExperienceNeeded;
	
	private int SpellOneRechargeTime,SpellTwoRechargeTime,SpellThreeRechargeTime,SpellFourRechargeTime;
	
	private int SpellOneMaxRechargeTime,SpellTwoMaxRechargeTime,SpellThreeMaxRechargeTime,SpellFourMaxRechargeTime;
	
	private int ActiveSpell,ActiveClass;
	
	private int NumberOfSpells;
	
	private int Spell1Level,Spell2Level,Spell3Level,masterSpell;
	
	private int AvailablePoints;
	
	private int Range,Speed,Strength,SpectralHealth,Resistance;
	
	private int Warped, Frozen;
	
	private int WarpTimer, WarpMax;
	
	private int FrozenTimer, FrozenMax1, FrozenMax2;
	
	public ExtendedSpectralPlayer(EntityPlayer player)
	{
	this.player = player;
	this.SpectralMagicLevel = 1;
	this.SpectralMagicExperience = 0;
	this.SpectralExperienceNeeded = 50;
	this.SpellOneRechargeTime = 0;
	this.SpellTwoRechargeTime = 0;
	this.SpellThreeRechargeTime = 0;
	this.SpellFourRechargeTime = 0;
	this.SpellOneMaxRechargeTime = 60;
	this.SpellTwoMaxRechargeTime = 60;
	this.SpellThreeMaxRechargeTime = 60;
	this.SpellFourMaxRechargeTime = 200;
	this.ActiveSpell = 0;
	this.ActiveClass = 0;
	this.NumberOfSpells = 0;
	this.Spell1Level = 0;
	this.Spell2Level = 0;
	this.Spell3Level = 0;
	this.masterSpell = 0;
	this.AvailablePoints = 2;
	this.Range = 10;
	this.Speed = 0;
	this.Strength = 0;
	this.SpectralHealth = 0;
	this.Resistance = 0;
	this.Warped = 0;
	this.Frozen = 0;
	this.WarpTimer = 0;
	this.WarpMax = 200;
	this.FrozenTimer = 0;
	this.FrozenMax1 = 100;
	this.FrozenMax2 = 200;
	}
	
	private static String getSaveKey(EntityPlayer player) {
		return player.getName() + ":" + SPECTRAL_PLAYER;
		}
	
	public static final void register(EntityPlayer player)
	{
	player.registerExtendedProperties(ExtendedSpectralPlayer.SPECTRAL_PLAYER, new ExtendedSpectralPlayer(player));
	}
	
	public static final ExtendedSpectralPlayer get(EntityPlayer player)
	{
	return (ExtendedSpectralPlayer) player.getExtendedProperties(SPECTRAL_PLAYER);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("SpectralMagicLevel", this.SpectralMagicLevel);
		properties.setInteger("SpectralMagicExperience", this.SpectralMagicExperience);
		properties.setInteger("SpectralExperienceNeeded", this.SpectralExperienceNeeded);
		properties.setInteger("SpellOneRechargeTime", this.SpellOneRechargeTime);
		properties.setInteger("SpellTwoRechargeTime", this.SpellTwoRechargeTime);
		properties.setInteger("SpellThreeRechargeTime", this.SpellThreeRechargeTime);
		properties.setInteger("SpellFourRechargeTime", this.SpellFourRechargeTime);
		properties.setInteger("SpellOneMaxRechargeTime", this.SpellOneMaxRechargeTime);
		properties.setInteger("SpellTwoMaxRechargeTime", this.SpellTwoMaxRechargeTime);
		properties.setInteger("SpellThreeMaxRechargeTime", this.SpellThreeMaxRechargeTime);
		properties.setInteger("SpellFourMaxRechargeTime", this.SpellFourMaxRechargeTime);
		properties.setInteger("ActiveSpell", this.ActiveSpell);
		properties.setInteger("ActiveClass", this.ActiveClass);
		properties.setInteger("NumberOfSpells", this.NumberOfSpells);
		properties.setInteger("Spell1Level", this.Spell1Level);
		properties.setInteger("Spell2Level", this.Spell2Level);
		properties.setInteger("Spell3Level", this.Spell3Level);
		properties.setInteger("masterSpell", this.masterSpell);
		properties.setInteger("AvailablePoints", this.AvailablePoints);
		properties.setInteger("Range", this.Range);
		properties.setInteger("Speed", this.Speed);
		properties.setInteger("Strength", this.Strength);
		properties.setInteger("SpectralHealth", this.SpectralHealth);
		properties.setInteger("Resistance", this.Resistance);
		properties.setInteger("Warped", this.Warped);
		properties.setInteger("Frozen", this.Frozen);
		properties.setInteger("FrozenTimer", this.FrozenTimer);
		properties.setInteger("FrozenMax1", this.FrozenMax1);
		properties.setInteger("FrozenMax2", this.FrozenMax2);
		properties.setInteger("WarpTimer", this.WarpTimer);
		properties.setInteger("WarpMax", this.WarpMax);
		compound.setTag(SPECTRAL_PLAYER, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(SPECTRAL_PLAYER);
		// Get our data from the custom tag compound
		this.SpectralMagicLevel = properties.getInteger("SpectralMagicLevel");
		this.SpectralMagicExperience = properties.getInteger("SpectralMagicExperience");
		this.SpectralExperienceNeeded = properties.getInteger("SpectralExperienceNeeded");
		this.SpellOneRechargeTime = properties.getInteger("SpellOneRechargeTime");
		this.SpellTwoRechargeTime = properties.getInteger("SpellTwoRechargeTime");
		this.SpellThreeRechargeTime = properties.getInteger("SpellThreeRechargeTime");
		this.SpellFourRechargeTime = properties.getInteger("SpellFourRechargeTime");
		this.SpellOneMaxRechargeTime = properties.getInteger("SpellOneMaxRechargeTime");
		this.SpellTwoMaxRechargeTime = properties.getInteger("SpellTwoMaxRechargeTime");
		this.SpellThreeMaxRechargeTime = properties.getInteger("SpellThreeMaxRechargeTime");
		this.SpellFourMaxRechargeTime = properties.getInteger("SpellFourMaxRechargeTime");
		this.ActiveSpell = properties.getInteger("ActiveSpell");
		this.ActiveClass = properties.getInteger("ActiveClass");
		this.NumberOfSpells = properties.getInteger("NumberOfSpells");
		this.Spell1Level = properties.getInteger("Spell1Level");
		this.Spell2Level = properties.getInteger("Spell2Level");
		this.Spell3Level = properties.getInteger("Spell3Level");
		this.masterSpell = properties.getInteger("masterSpell");
		this.masterSpell = properties.getInteger("AvailablePoints");
		this.Range = properties.getInteger("Range");
		this.Speed = properties.getInteger("Speed");
		this.Strength = properties.getInteger("Strength");
		this.SpectralHealth = properties.getInteger("SpectralHealth");
		this.Resistance = properties.getInteger("Resistance");
		this.Frozen = properties.getInteger("Frozen");
		this.Warped = properties.getInteger("Warped");
		this.FrozenTimer = properties.getInteger("FrozenTimer");
		this.FrozenMax1 = properties.getInteger("FrozenMax1");
		this.FrozenMax2 = properties.getInteger("FrozenMax2");
		this.WarpTimer = properties.getInteger("WarpTimer");
		this.WarpMax = properties.getInteger("WarpMax");
	}
	
	public void ForceLevelUp(int amount){
		this.SpectralMagicLevel = this.SpectralMagicLevel + amount;
		this.AvailablePoints = this.AvailablePoints + 2;
	}
	
	public int GetExperience(){
		return this.SpectralMagicExperience;
	}
	
	public void SetExperience(int amount){
		this.SpectralMagicExperience = amount;
	}	
	
	public void SpectralExperienceGive(int amount){
		this.SpectralMagicExperience = this.SpectralMagicExperience + amount;
	}
	
	public int GetExperienceNeeded(){
		return this.SpectralExperienceNeeded;
	}
	
	public void SetExperienceNeeded(int amount){
		this.SpectralExperienceNeeded = amount;
	}	
	
	public int GetSpectralLevel(){
		return SpectralMagicLevel;
	}
	
	public void SetSpectralLevel(int amount){
		this.SpectralMagicLevel = amount;
	}
	
	public void SpectralLevelUp(int amount){
		this.SpectralMagicLevel = this.SpectralMagicLevel + amount;
		this.SpectralExperienceNeeded = this.SpectralExperienceNeeded + 50;
		this.SpectralMagicExperience = 0;
		this.AvailablePoints = this.AvailablePoints + 2;
	}
	
	public int GetActiveSpell(){
		return this.ActiveSpell;
	}
	
	public void SetActiveSpell(int amount){
		this.ActiveSpell = amount;
	}
	
	public int GetActiveClass(){
		return this.ActiveClass;
	}
	
	public void UpdatePlayerClass(int Class){
		this.ActiveClass = Class;
	}
	
	public void SetSpellOneRechargeTime(int amount){
		this.SpellOneRechargeTime = amount;
	}
	
	public void SetSpellTwoRechargeTime(int amount){
		this.SpellTwoRechargeTime = amount;
	}
	
	public void SetSpellThreeRechargeTime(int amount){
		this.SpellThreeRechargeTime = amount;
	}
	
	public void SetSpellFourRechargeTime(int amount){
		this.SpellFourRechargeTime = amount;
	}
	
	public int GetSpellOneRechargeTime(){
		return this.SpellOneRechargeTime;
	}
	
	public int GetSpellTwoRechargeTime(){
		return this.SpellTwoRechargeTime;
	}
	
	public int GetSpellThreeRechargeTime(){
		return this.SpellThreeRechargeTime;
	}
	
	public int GetSpellFourRechargeTime(){
		return this.SpellFourRechargeTime;
	}
	
	public int GetSpellOneMaxRechargeTime(){
		return this.SpellOneMaxRechargeTime;
	}
	
	public int GetSpellTwoMaxRechargeTime(){
		return this.SpellTwoMaxRechargeTime;
	}
	
	public int GetSpellThreeMaxRechargeTime(){
		return this.SpellThreeMaxRechargeTime;
	}
	
	public int GetSpellFourMaxRechargeTime(){
		return this.SpellFourMaxRechargeTime;
	}
	
	public void ReduceSpellOneRechargeTime(int amount){
		this.SpellOneRechargeTime = this.SpellOneRechargeTime - amount;
	}
	
	public void ReduceSpellTwoRechargeTime(int amount){
		this.SpellTwoRechargeTime = this.SpellTwoRechargeTime - amount;
	}
	
	public void ReduceSpellThreeRechargeTime(int amount){
		this.SpellThreeRechargeTime = this.SpellThreeRechargeTime - amount;
	}
	
	public void ReduceSpellFourRechargeTime(int amount){
		this.SpellFourRechargeTime = this.SpellFourRechargeTime - amount;
	}
	
	public int GetNumberOfSpells(){
		return this.NumberOfSpells;
	}
	
	public void SetNumberOfSpells(int amount){
		this.NumberOfSpells = this.NumberOfSpells + amount;
	}
	
	public void SetServerSpellNumber(int amount){
		this.NumberOfSpells = amount;
	}
	public int GetSpell1Level(){
		return this.Spell1Level;
	}
	
	public int GetSpell2Level(){
		return this.Spell2Level;
	}
	
	public int GetSpell3Level(){
		return this.Spell3Level;
	}
	
	public void SetSpell1Level(int amount){
		this.Spell1Level = amount;
	}
	
	public void SetSpell2Level(int amount){
		this.Spell2Level = amount;
	}
	
	public void SetSpell3Level(int amount){
		this.Spell3Level = amount;
	}
	
	
	public void SetMasterSpell(int amount){
		this.masterSpell = amount;
	}
	
	public int GetMasterSpell(){
		return masterSpell;
	}
	
	public void SpectralSpellChangeDown(){
		switch (NumberOfSpells){
		
		case 2:
			if(this.Spell2Level >= 1 && this.Spell1Level >=1){
				if(ActiveSpell == 2){
					this.ActiveSpell = 1;
				} 
				else{
					this.ActiveSpell = 2;
				}
			}
			if(this.Spell3Level >= 1 && this.Spell1Level >=1){
				if(ActiveSpell == 3){
					this.ActiveSpell = 1;
				} 
				else{
					this.ActiveSpell = 3;
				}
			}
			if(this.Spell3Level >= 1 && this.Spell2Level >=1){
				if(ActiveSpell == 3){
					this.ActiveSpell = 2;
				} 
				else{
					this.ActiveSpell = 3;
				}
			}
			break;
			
		case 3:
			if (this.masterSpell == 0){
				if(ActiveSpell != 3){
					this.ActiveSpell = this.ActiveSpell + 1;
				} else{
					this.ActiveSpell = 1;
				}
			} else {
				if (this.Spell1Level >= 1 && this.Spell2Level >= 1){
					if (ActiveSpell == 1){
						this.ActiveSpell = 2;
					} 
					else if (ActiveSpell == 2){
						this.ActiveSpell = 4;
					} 
					else if (ActiveSpell == 4){
						this.ActiveSpell = 1;
					}
				} 
				else if (this.Spell1Level >= 1 && this.Spell3Level >= 1){
					if (ActiveSpell == 1){
						this.ActiveSpell = 3;
					} 
					else if (ActiveSpell == 3){
						this.ActiveSpell = 4;
					} 
					else if (ActiveSpell == 4){
						this.ActiveSpell = 1;
					}
				} 
				else if (this.Spell3Level >= 1 && this.Spell2Level >= 1){
					if (ActiveSpell == 2){
						this.ActiveSpell = 3;
					} 
					else if (ActiveSpell == 3){
						this.ActiveSpell = 4;
					} 
					else if (ActiveSpell == 4){
						this.ActiveSpell = 2;
					}
				}
			}
			break;
			
		case 4:
			if(ActiveSpell != 4){
				this.ActiveSpell = this.ActiveSpell + 1;
			} 
			else{
				this.ActiveSpell = 1;
			}
			break;
		}
		
	}
	
	public void SpectralSpellChangeUp(){
		switch (NumberOfSpells){
		
		case 2:
			if(this.Spell2Level >= 1 && this.Spell1Level >=1){
				if(ActiveSpell == 2){
					this.ActiveSpell = 1;
				} 
				else{
					this.ActiveSpell = 2;
				}
			}
			if(this.Spell3Level >= 1 && this.Spell1Level >=1){
				if(ActiveSpell == 3){
					this.ActiveSpell = 1;
				} 
				else{
					this.ActiveSpell = 3;
				}
			}
			if(this.Spell3Level >= 1 && this.Spell2Level >=1){
				if(ActiveSpell == 3){
					this.ActiveSpell = 2;
				} 
				else{
					this.ActiveSpell = 3;
				}
			}
			break;
			
		case 3:
			if (this.masterSpell == 0){
				if(ActiveSpell != 1){
					this.ActiveSpell = this.ActiveSpell - 1;
				} 
				else{
					this.ActiveSpell = 3;
				}
			} 
			else {
				if (this.Spell1Level >= 1 && this.Spell2Level >= 1){
					if (ActiveSpell == 1){
						this.ActiveSpell = 4;
					} 
					else if (ActiveSpell == 2){
						this.ActiveSpell = 1;
					} 
					else if (ActiveSpell == 4){
						this.ActiveSpell = 2;
					}
				} 
				else if (this.Spell1Level >= 1 && this.Spell3Level >= 1){
					if (ActiveSpell == 1){
						this.ActiveSpell = 4;
					} 
					else if (ActiveSpell == 3){
						this.ActiveSpell = 1;
					} 
					else if (ActiveSpell == 4){
						this.ActiveSpell = 3;
					}
				} 
				else if (this.Spell3Level >= 1 && this.Spell2Level >= 1){
					if (ActiveSpell == 2){
						this.ActiveSpell = 4;
					} 
					else if (ActiveSpell == 3){
						this.ActiveSpell = 2;
					} 
					else if (ActiveSpell == 4){
						this.ActiveSpell = 3;
					}
				}
			}
			break;
			
		case 4:
			if(ActiveSpell != 1){
				this.ActiveSpell = this.ActiveSpell - 1;
			} 
			else{
				this.ActiveSpell = 4;
			}
			break;
		}
		
	}
	
	public int GetPoints(){
		return this.AvailablePoints;
	}
	
	public void SetPoints(int amount){
		this.AvailablePoints = amount;
	}
	
	public void LowerSkillPoints(){
		if (this.AvailablePoints > 0 ){
		this.AvailablePoints = this.AvailablePoints - 1;
		}
	}
	
	public void RaiseSkillPoints(){
		if (this.AvailablePoints < (2*this.SpectralMagicLevel) ){
		this.AvailablePoints = this.AvailablePoints + 1;
		}
	}
	
	public int GetRange(){
		return this.Range;
	}
	
	public void SetRange(int amount){
		this.Range = amount;
	}
	
	public void LowerRange(){
		if (this.Range > 10){
		this.Range = this.Range - 1;
		}
	}
	
	public void RaiseRange(){
		if (this.AvailablePoints != 0){
		this.Range = this.Range + 1;
		}
	}
	
	public int GetSpeed(){
		return this.Speed;
	}
	
	public void SetSpeed(int amount){
		this.Speed = amount;
	}
	
	public void LowerSpeed(){
		if (this.Speed > 0){
		this.Speed = this.Speed - 1;
		}
	}
	
	public void RaiseSpeed(){
		if (this.AvailablePoints != 0){
		this.Speed = this.Speed + 1;
		}
	}
	
	public int GetHealth(){
		return this.SpectralHealth;
	}
	
	public void SetHealth(int amount){
		this.SpectralHealth = amount;
	}
	
	public void LowerHealth(){
		if (this.SpectralHealth > 0){
		this.SpectralHealth = this.SpectralHealth - 1;
		}
	}
	
	public void RaiseHealth(){
		if (this.AvailablePoints != 0){
		this.SpectralHealth = this.SpectralHealth + 1;
		}
	}
	
	public int GetStrength(){
		return this.Strength;
	}
	
	public void SetStrength(int amount){
		this.Strength = amount;
	}
	
	public void LowerStrength(){
		if (this.Strength > 0){
		this.Strength = this.Strength - 1;
		}
	}
	
	public void RaiseStrength(){
		if (this.AvailablePoints != 0){
	    this.Strength = this.Strength + 1;
		}
	}
	
	public int GetResistance(){
		return this.Resistance;
	}
	
	public void SetResistance(int amount){
		this.Resistance = amount;
	}
	
	public void LowerResistance(){
		if (this.Resistance > 0){
		this.Resistance = this.Resistance - 1;
		}
	}
	
	public void RaiseResistance(){
		if (this.AvailablePoints != 0){
		this.Resistance = this.Resistance + 1;
		}
	}
	
	public int GetFrozen(){
		return this.Frozen;
	}
	
	public void SetFrozen(int Var){
		this.Frozen = Var;
	}
	
	public int GetWarped(){
		return this.Warped;
	}
	
	public void SetWarped(int Var){
		this.Warped = Var;
	}
	
	public int GetFrozenTimer(){
		return this.FrozenTimer;
	}
	
	public void setFrozenTimer(int Var){
		this.FrozenTimer = Var;
	}
	
	public void ReduceFrozenTime(int Var){
		this.FrozenTimer = this.FrozenTimer - Var;
	}
	
	public int GetFrozenMax1(){
		return this.FrozenMax1;
	}
	
	public void setFrozenMax1(int Var){
		this.FrozenMax1 = Var;
	}
	
	public int GetFrozenMax2(){
		return this.FrozenMax2;
	}
	
	public void setFrozenMax2(int Var){
		this.FrozenMax2 = Var;
	}
	
	public int GetWarpTimer(){
		return this.WarpTimer;
	}
	
	public void setWarpTimer(int Var){
		this.WarpTimer = Var;
	}
	
	public void ReduceWarpTime(int Var){
		this.WarpTimer = this.WarpTimer - Var;
	}
	
	public int GetWarpMax(){
		return this.WarpMax;
	}
	
	public void setWarpMax(int Var){
		this.WarpMax = Var;
	}
	
	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub
		
	}
	
	public static void saveProxyData(EntityPlayer player) {
		ExtendedSpectralPlayer playerData = ExtendedSpectralPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();
		
		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static void loadProxyData(EntityPlayer player) {
		ExtendedSpectralPlayer playerData = ExtendedSpectralPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		
		if(savedData != null){
			playerData.loadNBTData(savedData);
		}
		//playerData.syncProperties();
	}
	
}
