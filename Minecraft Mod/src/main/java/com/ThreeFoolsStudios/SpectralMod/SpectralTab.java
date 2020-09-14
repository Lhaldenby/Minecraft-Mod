package com.ThreeFoolsStudios.SpectralMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

public class SpectralTab extends CreativeTabs{

	public SpectralTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return SpectralItems.Arcane_Gem;
	}

}
