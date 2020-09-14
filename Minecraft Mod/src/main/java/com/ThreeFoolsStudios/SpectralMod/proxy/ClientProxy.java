package com.ThreeFoolsStudios.SpectralMod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.lwjgl.input.Keyboard;

import com.ThreeFoolsStudios.SpectralMod.Entity.Particles.SpectralArcaneParticle;
import com.ThreeFoolsStudios.SpectralMod.Entity.Particles.SpectralElementalParticle;
import com.ThreeFoolsStudios.SpectralMod.Entity.Particles.SpectralNecromanticParticle;
import com.ThreeFoolsStudios.SpectralMod.Gui.SpectralGuiScreen;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralBlocks;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

public class ClientProxy extends CommonProxy {
	
	public static KeyBinding[] keyBindings;
	
	public void registerRenders(){
		SpectralBlocks.registerRenders();
		SpectralItems.registerRenders();
		MinecraftForge.EVENT_BUS.register(new SpectralGuiScreen(Minecraft.getMinecraft()));
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		keyBindings = new KeyBinding[2]; 
		
		keyBindings[0] = new KeyBinding("key.SpellUp.desc", Keyboard.KEY_F , "key.SpectralMagic.category");
		keyBindings[1] = new KeyBinding("key.SpellDown.desc", Keyboard.KEY_G, "key.SpectralMagic.category");
		
		for (int i = 0; i < keyBindings.length; ++i) 
		{
		    ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
		
		super.init(event);
	}

	@Override
	public void generateArcaneParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    EntityFX SpellParticle = new SpectralArcaneParticle(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat(), 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(SpellParticle);        
	}
	
	@Override
	public void generateElementalParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    EntityFX SpellParticle = new SpectralElementalParticle(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat(), 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(SpellParticle);        
	}
	
	@Override
	public void generateNecromanticParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    EntityFX SpellParticle = new SpectralNecromanticParticle(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat(), 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(SpellParticle);        
	}
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
}
