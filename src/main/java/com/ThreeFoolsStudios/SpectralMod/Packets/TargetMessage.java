package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class TargetMessage implements IMessage {

	private static int Warped;

	private static int Frozen;
	
	private static int WarpTimer;
	
	private static int FrozenTimer;
    
    public TargetMessage() { }

    public TargetMessage(int Warped, int Frozen, int WarpTimer, int FrozenTimer) {

    	 this.Warped = Warped;
    	 this.Frozen = Frozen;
    	 this.WarpTimer = WarpTimer;
    	 this.FrozenTimer = FrozenTimer;
    }

    @Override
    public void fromBytes(ByteBuf buf) {

    	this.Warped = buf.readInt();
    	this.Frozen = buf.readInt();
    	this.WarpTimer = buf.readInt();
    	this.FrozenTimer = buf.readInt();
   	 
    }

    @Override
    public void toBytes(ByteBuf buf) {

    	buf.writeInt(Warped);
    	buf.writeInt(Frozen);
    	buf.writeInt(WarpTimer);
    	buf.writeInt(FrozenTimer);
    }

    public static class Handler implements IMessageHandler<TargetMessage, IMessage>  {
    	
    	@Override
		public IMessage onMessage(final TargetMessage message, final MessageContext ctx) {
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                	EntityPlayer player = ctx.getServerHandler().playerEntity;
                	if (player != null){
                		ExtendedSpectralPlayer.get(player).SetFrozen(Frozen);
                		ExtendedSpectralPlayer.get(player).SetWarped(Warped);
                		ExtendedSpectralPlayer.get(player).setFrozenTimer(FrozenTimer);
                		ExtendedSpectralPlayer.get(player).setWarpTimer(WarpTimer);
                	} else {
                		System.out.println("No Message");
                	}
                }
            });
			return null;
		}

}

}
