package com.ThreeFoolsStudios.SpectralMod.blocks;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Gui.GuiSpectralAltar;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpectralAltar extends Block {
	
	public BlockSpectralAltar(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 2);
	}

	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		
		if( 
				(worldIn.getBlockState( new BlockPos( pos.getX(), pos.getY(), pos.getZ())).getBlock() == SpectralBlocks.Spectral_Altar) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+1, pos.getY()-1, pos.getZ())).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+1, pos.getY()-1, pos.getZ()+1)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX(), pos.getY()-1, pos.getZ()+1)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-1, pos.getY()-1, pos.getZ()+1)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-1, pos.getY()-1, pos.getZ())).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-1, pos.getY()-1, pos.getZ()-1)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX(), pos.getY()-1, pos.getZ()-1)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+1, pos.getY()-1, pos.getZ()-1)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+2, pos.getY(), pos.getZ()+2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+2, pos.getY(), pos.getZ()-2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-2, pos.getY(), pos.getZ()-2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-2, pos.getY(), pos.getZ()+2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+2, pos.getY()+1, pos.getZ()+2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+2, pos.getY()+1, pos.getZ()-2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-2, pos.getY()+1, pos.getZ()-2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-2, pos.getY()+1, pos.getZ()+2)).getBlock() == SpectralBlocks.Spectral_Stone) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+2, pos.getY()+2, pos.getZ()+2)).getBlock() == SpectralBlocks.Spectral_Gem_Block) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()+2, pos.getY()+2, pos.getZ()-2)).getBlock() == SpectralBlocks.Spectral_Gem_Block) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-2, pos.getY()+2, pos.getZ()-2)).getBlock() == SpectralBlocks.Spectral_Gem_Block) &&
				(worldIn.getBlockState( new BlockPos( pos.getX()-2, pos.getY()+2, pos.getZ()+2)).getBlock() == SpectralBlocks.Spectral_Gem_Block) 
				){
			playerIn.openGui(SpectralMod.instance, 1, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
		}
		else {
			if (!worldIn.isRemote == true){
			String SPAcoloredText = EnumChatFormatting.WHITE + "Spectral Altar Uncompleted";
			   playerIn.addChatMessage( new ChatComponentTranslation(SPAcoloredText));
			}
		}
	}

}
