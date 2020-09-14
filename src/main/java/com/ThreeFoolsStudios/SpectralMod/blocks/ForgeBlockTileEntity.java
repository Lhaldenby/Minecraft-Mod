package com.ThreeFoolsStudios.SpectralMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.TileEntity.ShardForgeTileEntity;

public class ForgeBlockTileEntity extends Block implements ITileEntityProvider {

	public ForgeBlockTileEntity(Material materialIn) {
		super(materialIn);
		setHarvestLevel("pickaxe", 2);
		this.isBlockContainer = true;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
	    if (!world.isRemote) {
	        player.openGui(SpectralMod.instance, 2, world, pos.getX(), pos.getY(), pos.getZ());
	    }
	    return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ShardForgeTileEntity();
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
		ShardForgeTileEntity te = (ShardForgeTileEntity) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	    world.removeTileEntity(pos);
	}

	 @Override
	 public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
	     super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
	     TileEntity tileentity = worldIn.getTileEntity(pos);
	     return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
	 }
	 
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    if (stack.hasDisplayName()) {
	        ((ShardForgeTileEntity) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}
	    
}
