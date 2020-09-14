package com.ThreeFoolsStudios.SpectralMod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.blocks.BlockLight;
import com.ThreeFoolsStudios.SpectralMod.blocks.BlockSpectralAltar;
import com.ThreeFoolsStudios.SpectralMod.blocks.BlockTest;
import com.ThreeFoolsStudios.SpectralMod.blocks.ForgeBlockTileEntity;
import com.ThreeFoolsStudios.SpectralMod.blocks.OreTest;

public class SpectralBlocks {
	//this creates an instance of the blocks that i want to add into my mod
	public static Block Necromantic_Crystal;
	public static Block Arcane_Ore;
	public static Block Elemental_Stone;
	public static Block Spectral_Altar;
	public static Block Spectral_Stone;
	public static Block Spectral_Gem_Block;
	public static Block Spectral_Shard_Forge;
	public static Block Spectral_Barrier;
	public static Block Spectral_Light;
	
	public static void init() { //this initialises each block and gives it properties
		Necromantic_Crystal = new OreTest(Material.rock).setHardness(5) //this decides what material the block will sound liek when broken
				.setUnlocalizedName("Necromantic_Crystal") //.setHardness sets how long the block takes to mine
				.setCreativeTab(SpectralMod.tabSpectral); //.setUnlocalizedName sets the name of the block.
				//.setCreativeTab sets what tab the block will be found in, in creative mod
		Arcane_Ore = new OreTest(Material.rock).setHardness(5) //this is the same for the previous block
				.setUnlocalizedName("Arcane_Ore")
				.setCreativeTab(SpectralMod.tabSpectral);
		;
		Elemental_Stone = new OreTest(Material.rock).setHardness(5) //this is the same for the previous block
				.setUnlocalizedName("Elemental_Stone")
				.setCreativeTab(SpectralMod.tabSpectral);
		;
		Spectral_Altar = new BlockSpectralAltar(Material.rock).setHardness(5) //this is the same for the previous block
				.setUnlocalizedName("Spectral_Altar")
				.setCreativeTab(SpectralMod.tabSpectral);
		;
		Spectral_Stone = new BlockTest(Material.rock).setHardness(5) //this is the same for the previous block
				.setUnlocalizedName("Spectral_Stone")
				.setCreativeTab(SpectralMod.tabSpectral);
		;
		Spectral_Gem_Block = new BlockTest(Material.rock).setHardness(5) //this is the same for the previous block
				.setUnlocalizedName("Spectral_Gem_Block")
				.setCreativeTab(SpectralMod.tabSpectral);
		;
		Spectral_Shard_Forge = new ForgeBlockTileEntity(Material.rock).setHardness(2)
				.setUnlocalizedName("Spectral_Shard_Forge") //this is the same for the previous block, but with a lower mine time
				.setCreativeTab(SpectralMod.tabSpectral); 

		Spectral_Barrier = new BlockTest(Material.rock).setHardness(50)
				.setUnlocalizedName("Spectral_Barrier") //this is the same for the previous block, but with a higher mine time
				.setCreativeTab(SpectralMod.tabSpectral);
		
		Spectral_Light = new BlockLight (Material.glass).setHardness(2)
				.setUnlocalizedName("Spectral_Light")
				.setCreativeTab(SpectralMod.tabSpectral);
		
	}

	public static void register() { //this registers the blocks to the game and sets their names
		GameRegistry.registerBlock(Necromantic_Crystal, Necromantic_Crystal
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Arcane_Ore, Arcane_Ore.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(Elemental_Stone, Elemental_Stone
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Spectral_Altar, Spectral_Altar
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Spectral_Stone, Spectral_Stone
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Spectral_Gem_Block, Spectral_Gem_Block
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Spectral_Barrier, Spectral_Barrier
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Spectral_Shard_Forge,
				Spectral_Shard_Forge.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Spectral_Light, 
				Spectral_Light.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() { //this sets the textures names for each block
		registerRender(Necromantic_Crystal);
		registerRender(Arcane_Ore);
		registerRender(Elemental_Stone);
		registerRender(Spectral_Altar);
		registerRender(Spectral_Stone);
		registerRender(Spectral_Gem_Block);
		registerRender(Spectral_Barrier);
		registerRender(Spectral_Shard_Forge);
		registerRender(Spectral_Light);
		}

	public static void registerRender(Block block) { //this sets the item texture for the blocks in the inventory
		Item item = Item.getItemFromBlock(block);
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(Reference.MOD_ID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}

}
