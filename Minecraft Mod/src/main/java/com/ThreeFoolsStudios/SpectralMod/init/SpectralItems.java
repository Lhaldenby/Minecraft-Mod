package com.ThreeFoolsStudios.SpectralMod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemArcane_Boots;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemArcane_ChestPlate;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemArcane_Helmet;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemArcane_Leggings;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemArcane_Staff;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemElemental_Boots;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemElemental_ChestPlate;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemElemental_Helmet;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemElemental_Leggings;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemElemental_Staff;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemNecromantic_Boots;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemNecromantic_ChestPlate;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemNecromantic_Helmet;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemNecromantic_Leggings;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemNecromantic_Staff;
import com.ThreeFoolsStudios.SpectralMod.init.item.ItemStaff;
import com.ThreeFoolsStudios.SpectralMod.init.item.Item_Gem;
import com.ThreeFoolsStudios.SpectralMod.init.item.Item_Shard;
import com.ThreeFoolsStudios.SpectralMod.items.ItemArcaneParchment;
import com.ThreeFoolsStudios.SpectralMod.items.ItemElementalParchment;
import com.ThreeFoolsStudios.SpectralMod.items.ItemNecromanticParchment;
import com.ThreeFoolsStudios.SpectralMod.items.ItemSpectralTomb;

public class SpectralItems {
	//this creates an instance of the items that i want to add into my mod
	public static Item Necromantic_Gem;
	public static Item Necromantic_Shard;
	public static Item Arcane_Gem;
	public static Item Arcane_Shard;
	public static Item Elemental_Shard;
	public static Item Elemental_Gem;
	
	public static Item Spectral_Tomb;

	public static Item Staff;
	public static Item Arcane_Staff;
	public static Item Elemental_Staff;
	public static Item Necromantic_Staff;
	
	public static Item Arcane_Helmet;
	public static Item Arcane_ChestPlate;
	public static Item Arcane_Leggings;
	public static Item Arcane_Boots;
	public static Item Elemental_Helmet;
	public static Item Elemental_ChestPlate;
	public static Item Elemental_Leggings;
	public static Item Elemental_Boots;
	public static Item Necromantic_Helmet;
	public static Item Necromantic_ChestPlate;
	public static Item Necromantic_Leggings;
	public static Item Necromantic_Boots;
	
	public static Item Necromantic_Parchment;
	public static Item Elemental_Parchment;
	public static Item Arcane_Parchment;
	
	//these are two different instances of different types of weapons added to the game by my mod
	public static final Item.ToolMaterial SpectralStaff = EnumHelper.addToolMaterial("SpectralStaff", 4, 1024, 6.0F, 4.0F, 20);
	public static final Item.ToolMaterial NormWeapon = EnumHelper.addToolMaterial("NormWeapon", 2, 512, 4.0F, 1.0F, 5);
	
	public static final ItemArmor.ArmorMaterial ArcaneArmorMaterial = EnumHelper.addArmorMaterial("ArcaneArmorMaterial", "", 4096,new int[]{2,8,7,4}, 20);
	
	public static void init () {//initialises the item into the game by my mod  //actual name is item.Necromatic_Gem
		Necromantic_Gem = new Item_Gem().setUnlocalizedName("Necromantic_Gem").setCreativeTab(SpectralMod.tabSpectral);
		//.SetUnlocalizedName sets the name of the item   //.setCreativeTab sets which tab the item can be found in creative mod
		Necromantic_Shard = new Item_Shard().setUnlocalizedName("Necromantic_Shard").setCreativeTab(SpectralMod.tabSpectral);
		//this is the same for every normal item
		Arcane_Shard = new Item_Shard().setUnlocalizedName("Arcane_Shard").setCreativeTab(SpectralMod.tabSpectral);
		Arcane_Gem = new Item_Gem().setUnlocalizedName("Arcane_Gem").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_Shard = new Item_Shard().setUnlocalizedName("Elemental_Shard").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_Gem = new Item_Gem().setUnlocalizedName("Elemental_Gem").setCreativeTab(SpectralMod.tabSpectral);
		//this changes from a normal item to a ItemStaff which i set the properties of
		Staff = new ItemStaff(NormWeapon).setUnlocalizedName("Staff").setCreativeTab(SpectralMod.tabSpectral);
		//this changes the item to a ItemStaff which i can give more properite and make to do extra things
		Arcane_Staff = new ItemArcane_Staff().setUnlocalizedName("Arcane_Staff").setCreativeTab(SpectralMod.tabSpectral);
		//each item with a custom new (Item name) has the possibilty to be given extra code to do new things
		Elemental_Staff = new ItemElemental_Staff().setUnlocalizedName("Elemental_Staff").setCreativeTab(SpectralMod.tabSpectral);
		Necromantic_Staff = new ItemNecromantic_Staff().setUnlocalizedName("Necromantic_Staff").setCreativeTab(SpectralMod.tabSpectral);
		Arcane_Helmet = new ItemArcane_Helmet(ArcaneArmorMaterial, 0, 0).setUnlocalizedName("Arcane_Helmet").setCreativeTab(SpectralMod.tabSpectral);
		Arcane_ChestPlate = new ItemArcane_ChestPlate(ArcaneArmorMaterial, 0, 1).setUnlocalizedName("Arcane_ChestPlate").setCreativeTab(SpectralMod.tabSpectral);
		Arcane_Leggings = new ItemArcane_Leggings(ArcaneArmorMaterial, 0, 2).setUnlocalizedName("Arcane_Leggings").setCreativeTab(SpectralMod.tabSpectral);
		Arcane_Boots = new ItemArcane_Boots(ArcaneArmorMaterial, 0, 3).setUnlocalizedName("Arcane_Boots").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_Helmet = new ItemElemental_Helmet(ArcaneArmorMaterial, 0, 0).setUnlocalizedName("Elemental_Helmet").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_ChestPlate = new ItemElemental_ChestPlate(ArcaneArmorMaterial, 0, 1).setUnlocalizedName("Elemental_ChestPlate").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_Leggings = new ItemElemental_Leggings(ArcaneArmorMaterial, 0, 2).setUnlocalizedName("Elemental_Leggings").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_Boots = new ItemElemental_Boots(ArcaneArmorMaterial, 0, 3).setUnlocalizedName("Elemental_Boots").setCreativeTab(SpectralMod.tabSpectral);
		Necromantic_Helmet = new ItemNecromantic_Helmet(ArcaneArmorMaterial, 0, 0).setUnlocalizedName("Necromantic_Helmet").setCreativeTab(SpectralMod.tabSpectral);
		Necromantic_ChestPlate = new ItemNecromantic_ChestPlate(ArcaneArmorMaterial, 0, 1).setUnlocalizedName("Necromantic_ChestPlate").setCreativeTab(SpectralMod.tabSpectral);
		Necromantic_Leggings = new ItemNecromantic_Leggings(ArcaneArmorMaterial, 0, 2).setUnlocalizedName("Necromantic_Leggings").setCreativeTab(SpectralMod.tabSpectral);
		Necromantic_Boots = new ItemNecromantic_Boots(ArcaneArmorMaterial, 0, 3).setUnlocalizedName("Necromantic_Boots").setCreativeTab(SpectralMod.tabSpectral);
		Spectral_Tomb = new ItemSpectralTomb().setUnlocalizedName("Spectral_Tomb").setCreativeTab(SpectralMod.tabSpectral);
		Necromantic_Parchment = new ItemNecromanticParchment().setUnlocalizedName("Necromantic_Parchment").setCreativeTab(SpectralMod.tabSpectral);
		Arcane_Parchment = new ItemArcaneParchment().setUnlocalizedName("Arcane_Parchment").setCreativeTab(SpectralMod.tabSpectral);
		Elemental_Parchment = new ItemElementalParchment().setUnlocalizedName("Elemental_Parchment").setCreativeTab(SpectralMod.tabSpectral);
	}
	
	public static void register () { //this registers all the items to the game that i want to add into the mod
		GameRegistry.registerItem(Necromantic_Gem, Necromantic_Gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_Shard, Necromantic_Shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Shard, Arcane_Shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Gem, Arcane_Gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Shard, Elemental_Shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Gem, Elemental_Gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Staff, Staff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Staff, Arcane_Staff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Staff, Elemental_Staff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_Staff, Necromantic_Staff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Helmet, Arcane_Helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_ChestPlate, Arcane_ChestPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Leggings, Arcane_Leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Boots, Arcane_Boots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Helmet, Elemental_Helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_ChestPlate, Elemental_ChestPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Leggings, Elemental_Leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Boots, Elemental_Boots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_Helmet, Necromantic_Helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_ChestPlate, Necromantic_ChestPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_Leggings, Necromantic_Leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_Boots, Necromantic_Boots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Spectral_Tomb, Spectral_Tomb.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Necromantic_Parchment, Necromantic_Parchment.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Arcane_Parchment, Arcane_Parchment.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Elemental_Parchment, Elemental_Parchment.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() { //this sets the name of the texture for each item
		registerRender(Necromantic_Gem);
		registerRender(Necromantic_Shard);
		registerRender(Arcane_Shard);
		registerRender(Arcane_Gem);
		registerRender(Elemental_Shard);
		registerRender(Elemental_Gem);
     	registerRender(Staff);
		registerRender(Arcane_Staff);
		registerRender(Elemental_Staff);
		registerRender(Necromantic_Staff);
		registerRender(Arcane_Helmet);
		registerRender(Arcane_ChestPlate);
		registerRender(Arcane_Leggings);
		registerRender(Arcane_Boots);
		registerRender(Elemental_Helmet);
		registerRender(Elemental_ChestPlate);
		registerRender(Elemental_Leggings);
		registerRender(Elemental_Boots);
		registerRender(Necromantic_Helmet);
		registerRender(Necromantic_ChestPlate);
		registerRender(Necromantic_Leggings);
		registerRender(Necromantic_Boots);
		registerRender(Spectral_Tomb);
		registerRender(Necromantic_Parchment);
		registerRender(Arcane_Parchment);
		registerRender(Elemental_Parchment);
	}
	
	public static void registerRender(Item item) { //this registers the texture for the item when held in the inventory.
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
