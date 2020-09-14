package com.ThreeFoolsStudios.SpectralMod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

public class OreTest extends Block{

	public OreTest(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe",2);
		setLightLevel(50.0F);
	}


}
