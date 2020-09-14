package com.ThreeFoolsStudios.SpectralMod.blocks;

import java.util.Random;

import com.ThreeFoolsStudios.SpectralMod.TileEntity.TileEntitySpectralLight;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLight extends Block implements ITileEntityProvider{

	public BlockLight(Material materialIn) {
		super(materialIn);
		setLightLevel(50.0F);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySpectralLight();
	}

}
