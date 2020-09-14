package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class UpgradeMessage implements IMessage {

	    private int AvaiblePoint;
	    private int Range;
	    private int Speed;
	    private int Strength;
	    private int Health;
	    private int Resistance;
	    
	    public UpgradeMessage() { }

	    public UpgradeMessage(int AvaiblePoint, int Range, int Speed, int Strength, int Health, int Resistance) {

	    	 this.AvaiblePoint = AvaiblePoint;
	    	 this.Range = Range;
	    	 this.Speed = Speed;
	    	 this.Strength = Strength;
	    	 this.Health = Health;
	    	 this.Resistance = Resistance;
	    }

	    @Override
	    public void fromBytes(ByteBuf buf) {

	   	 	this.AvaiblePoint = buf.readInt();
	   	 	this.Range = buf.readInt();
	   	 	this.Speed = buf.readInt();
	   	 	this.Strength = buf.readInt();
	   	 	this.Health = buf.readInt();
	   	 	this.Resistance = buf.readInt();
	    }

	    @Override
	    public void toBytes(ByteBuf buf) {

	    	 buf.writeInt(AvaiblePoint);
	    	 buf.writeInt(Range);
	    	 buf.writeInt(Speed);
	    	 buf.writeInt(Strength);
	    	 buf.writeInt(Health);
	    	 buf.writeInt(Resistance);
	    }

	    public static class Handler implements IMessageHandler<UpgradeMessage, IMessage>  {
	    	
	    	@Override
			public IMessage onMessage(final UpgradeMessage message, final MessageContext ctx) {
				IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
	            mainThread.addScheduledTask(new Runnable() {
	                @Override
	                public void run() {
	                	EntityPlayer player = ctx.getServerHandler().playerEntity;
	                	if (player != null){
	                		ExtendedSpectralPlayer.get(player).SetPoints(message.AvaiblePoint);
	                		ExtendedSpectralPlayer.get(player).SetRange(message.Range);
	                		ExtendedSpectralPlayer.get(player).SetSpeed(message.Speed);
	                		ExtendedSpectralPlayer.get(player).SetStrength(message.Strength);
	                		ExtendedSpectralPlayer.get(player).SetHealth(message.Health);
	                		ExtendedSpectralPlayer.get(player).SetResistance(message.Resistance);
	                	} else {
	                		System.out.println("No Message");
	                	}
	                }
	            });
				return null;
			}

	}

}
