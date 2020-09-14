package com.ThreeFoolsStudios.SpectralMod.Gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.ThreeFoolsStudios.SpectralMod.TileEntity.ShardForgeTileEntity;

public class SpectralGuiHandler implements IGuiHandler{
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		switch (ID) {
		case 0: return new GuiBook();
		case 1: return new GuiSpectralAltar();
		case 2: return new ForgeTileEntityContainer(player.inventory, (ShardForgeTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0: return new GuiBook();
		case 1: return new GuiSpectralAltar();
		case 2: return new GuiForgeTileEntity(player.inventory, (ShardForgeTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}

}
