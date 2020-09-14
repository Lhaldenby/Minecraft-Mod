package com.ThreeFoolsStudios.SpectralMod.Entity.Particles;

import com.ThreeFoolsStudios.SpectralMod.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SpectralArcaneParticle extends EntityAuraFX{

	public SpectralArcaneParticle(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        setParticleTextureIndex(65); 
        particleScale = 2.0F;
        setRBGColorF(0x11, 0x00, 0x88);
    }
	
}
