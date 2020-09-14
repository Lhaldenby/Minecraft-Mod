package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class ActiveSpellMessage implements IMessage {

	    private int Spell;
	    
	    public ActiveSpellMessage() { }

	    public ActiveSpellMessage(int Spell) {

	    	 this.Spell = Spell;
	    }

	    @Override
	    public void fromBytes(ByteBuf buf) {

	   	 	this.Spell = buf.readInt();
	    }

	    @Override
	    public void toBytes(ByteBuf buf) {

	    	 buf.writeInt(Spell);
	    }

	    public static class Handler implements IMessageHandler<ActiveSpellMessage, IMessage>  {
	    	
			@Override
			public IMessage onMessage(final ActiveSpellMessage message, final MessageContext ctx) {
				IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
	            mainThread.addScheduledTask(new Runnable() {
	                @Override
	                public void run() {
	                	EntityPlayer player = ctx.getServerHandler().playerEntity;
	                	if (player != null){
	                		ExtendedSpectralPlayer.get(player).SetActiveSpell(message.Spell);
	                	} else {
	                		System.out.println("No Message");
	                	}
	                }
	            });
				return null;
			}
	    }
	}