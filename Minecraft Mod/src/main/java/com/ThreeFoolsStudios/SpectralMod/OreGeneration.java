package com.ThreeFoolsStudios.SpectralMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;

public class OreGeneration implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0:
			generateOverWorld(world, random, chunkX, chunkZ);
			break;
		}
	}

	public void generateOverWorld(World world, Random rand, int x, int z) {
			generateOreN(SpectralBlocks.Necromantic_Crystal, world, rand, x, z, 4, 9, 15, 8, 80, Blocks.stone);
			generateOreA(SpectralBlocks.Arcane_Ore, world, rand, x, z, 4, 9, 15, 8, 80, Blocks.stone);
			generateOreE(SpectralBlocks.Elemental_Stone, world, rand, x, z, 4, 9, 15, 8, 80, Blocks.stone);
	}

	public void generateOreN(Block block, World world, Random random,
			int chunkX, int chunkZ, int minVeinSize, int maxVeinSize,
			int chance, int minY, int maxY, Block generateIn) {
		
		int VeinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), VeinSize);
		for (int i=0; i< chance; i++){
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, new BlockPos(xRand, yRand, zRand));}
		}
		
		public void generateOreA(Block block, World world, Random random,
				int chunkX, int chunkZ, int minVeinSize, int maxVeinSize,
				int chance, int minY, int maxY, Block generateIn) {
			
			int VeinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
			int heightRange = maxY - minY;
			WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), VeinSize);
			for (int i=0; i< chance; i++){
				int xRand = chunkX * 16 + random.nextInt(16);
				int yRand = random.nextInt(heightRange) + minY;
				int zRand = chunkZ * 16 + random.nextInt(16);
				gen.generate(world, random, new BlockPos(xRand, yRand, zRand));}
			}
			
			public void generateOreE(Block block, World world, Random random,
					int chunkX, int chunkZ, int minVeinSize, int maxVeinSize,
					int chance, int minY, int maxY, Block generateIn) {
				
				int VeinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
				int heightRange = maxY - minY;
				WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), VeinSize);
				for (int i=0; i< chance; i++){
					int xRand = chunkX * 16 + random.nextInt(16);
					int yRand = random.nextInt(heightRange) + minY;
					int zRand = chunkZ * 16 + random.nextInt(16);
					gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
				}
	}


}