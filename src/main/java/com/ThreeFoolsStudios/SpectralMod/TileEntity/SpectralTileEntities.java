package com.ThreeFoolsStudios.SpectralMod.TileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SpectralTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(ShardForgeTileEntity.class, "Shard_Forge_Tile_Entity");
	}
	
}
