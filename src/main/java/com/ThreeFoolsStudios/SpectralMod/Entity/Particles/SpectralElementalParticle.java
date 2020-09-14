package com.ThreeFoolsStudios.SpectralMod.Entity.Particles;

import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.world.World;

public class SpectralElementalParticle extends EntityAuraFX{

	public SpectralElementalParticle(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        setParticleTextureIndex(65); 
        particleScale = 2.0F;
        setRBGColorF(0x00, 0x00, 0x88);
    }
}
