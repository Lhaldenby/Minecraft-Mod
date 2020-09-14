package com.ThreeFoolsStudios.SpectralMod.TileEntity;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySpectralLight extends TileEntity implements IUpdatePlayerListBox
{

	private int Ticks;
	
	@Override
	public void update() {
		Ticks++;
		if(Ticks % 300 == 0){
			Ticks = 0;
			worldObj.setBlockToAir(getPos());
		}	
	}

}
