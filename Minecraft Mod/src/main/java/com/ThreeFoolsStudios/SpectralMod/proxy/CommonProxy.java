package com.ThreeFoolsStudios.SpectralMod.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ThreeFoolsStudios.SpectralMod.OreGeneration;
import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Event.SpectralEventHandler;
import com.ThreeFoolsStudios.SpectralMod.Gui.SpectralGuiHandler;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

public class CommonProxy {
	
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void Preinit(FMLPreInitializationEvent event){
		SpectralBlocks.init();
		SpectralBlocks.register();
		SpectralItems.init();
		SpectralItems.register();
		GameRegistry.registerWorldGenerator(new OreGeneration(), 3);
	}
	
	public void init(FMLInitializationEvent event){		
		NetworkRegistry.INSTANCE.registerGuiHandler(SpectralMod.instance, new SpectralGuiHandler());
		MinecraftForge.EVENT_BUS.register(new SpectralEventHandler());
		SpectralEventHandler handler = new SpectralEventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler);
		
		//crafting recipes begin
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Necromantic_Gem),
				 "NNN", "NNN", "NNN",'N',
			SpectralItems.Necromantic_Shard );
		
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Arcane_Gem),
				"AAA", "AAA", "AAA", 'A',
			SpectralItems.Arcane_Shard );
		
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Elemental_Gem),
				"EEE", "EEE", "EEE",'E',
			SpectralItems.Elemental_Shard );
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Altar),
				"BBB", "OBO", "OOO", 'O',
			Blocks.obsidian, 'B',
			SpectralBlocks.Spectral_Gem_Block );
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Gem_Block),
				"NNN", "NNN", "NNN",
						'N', SpectralItems.Necromantic_Gem );
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Gem_Block),
				"AAA", "AAA", "AAA", 'A',
			SpectralItems.Arcane_Gem );
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Gem_Block),
				"EEE", "EEE", "EEE", 'E', SpectralItems.Elemental_Gem );
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Stone),
				"SSS", "SBS", "SSS", 'S', Blocks.stone, 'B',
			SpectralBlocks.Spectral_Gem_Block );
		
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Staff),
				"  W", " WW", "W  ", 'W', Items.stick );
		
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Arcane_Staff),
				"  A", " WA", "W  ", 'W', Items.stick, 'A',
			SpectralItems.Arcane_Gem );
		
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Elemental_Staff),
				"  E", " WE", "W  ", 'W', Items.stick, 'E',
			SpectralItems.Elemental_Gem );
		
		GameRegistry.addRecipe(new ItemStack(SpectralItems.Necromantic_Staff),
				"  N", " WN", "W  ", 'W', Items.stick, 'N',
			SpectralItems.Necromantic_Gem );
				
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Shard_Forge),
				"SAS", "SSS", "SSS", 'S', Blocks.stone,'A',
			SpectralItems.Arcane_Shard ); 
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Shard_Forge),
				"SES", "SSS", "SSS", 'S', Blocks.stone,'E',
			SpectralItems.Elemental_Shard ); 
		
		GameRegistry.addRecipe(new ItemStack(SpectralBlocks.Spectral_Shard_Forge),
				"SNS", "SSS", "SSS", 'S', Blocks.stone,'N',
			SpectralItems.Necromantic_Shard );
		
		GameRegistry.addSmelting(SpectralBlocks.Arcane_Ore, new ItemStack(SpectralItems.Arcane_Shard, 1), 1F);
		GameRegistry.addSmelting(SpectralBlocks.Elemental_Stone, new ItemStack(SpectralItems.Elemental_Shard, 1), 1F);
		GameRegistry.addSmelting(SpectralBlocks.Necromantic_Crystal, new ItemStack(SpectralItems.Necromantic_Shard, 1), 1F);
		
		//shapeless crafting doesn't matter where the items go in crafting table
		GameRegistry.addShapelessRecipe(new ItemStack(SpectralItems.Spectral_Tomb),
				new Object[]{ Items.book, SpectralItems.Arcane_Gem});
		
		GameRegistry.addShapelessRecipe(new ItemStack(SpectralItems.Spectral_Tomb),
				new Object[]{ Items.book, SpectralItems.Elemental_Gem});
		
		GameRegistry.addShapelessRecipe(new ItemStack(SpectralItems.Spectral_Tomb),
				new Object[]{ Items.book, SpectralItems.Necromantic_Gem});
		//crafting recipes end
			
		SpectralMod.achievementStartSpectralMagic.registerStat();
		SpectralMod.achievementCastFirstSpell.registerStat();
		SpectralMod.achievementFullSpell.registerStat();
		SpectralMod.achievementAllSpells.registerStat();
		SpectralMod.achievementMaxSpells.registerStat();
		SpectralMod.achievementGetShard.registerStat();
		SpectralMod.achievementMakeGem.registerStat();
		SpectralMod.achievementMakeArmour.registerStat();
		SpectralMod.achievementMakeStaff.registerStat();
		SpectralMod.achievementChooseClass.registerStat();
		SpectralMod.achievementLevelUp.registerStat();
		SpectralMod.achievementMaxLevel.registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage(
				"Spectral Magic", new Achievement[] {
				SpectralMod.achievementStartSpectralMagic, SpectralMod.achievementCastFirstSpell,
				SpectralMod.achievementFullSpell, SpectralMod.achievementAllSpells, SpectralMod.achievementMaxSpells,
				SpectralMod.achievementGetShard, SpectralMod.achievementMakeGem, SpectralMod.achievementMakeArmour,
				SpectralMod.achievementMakeStaff, SpectralMod.achievementChooseClass, SpectralMod.achievementLevelUp,
				SpectralMod.achievementMaxLevel
				}));
	}
	
	
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
	extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name)
	{
	return extendedEntityData.remove(name);
	}

	public void generateArcaneParticles(Entity theEntity){}
	
	public void generateElementalParticles(Entity theEntity){}
	
	public void generateNecromanticParticles(Entity theEntity){}
	
	public void postInit(FMLPostInitializationEvent event) {
	}

	public void registerRenders() {
		// TODO Auto-generated method stub
		
	}

	public void preInit(FMLPreInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
