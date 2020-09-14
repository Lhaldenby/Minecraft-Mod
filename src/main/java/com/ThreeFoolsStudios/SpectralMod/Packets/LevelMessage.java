package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class LevelMessage  implements IMessage {

    private int Level;
    private int Experience;
    private int ExperienceNeeded;
    private int Class;
    private int AvaiblePoint;
    
    public LevelMessage() { }

    public LevelMessage(int Level, int Experience, int ExperienceNeeded, int Class, int AvaiblePoint) {

    	 this.Level = Level;
    	 this.Experience = Experience;
    	 this.ExperienceNeeded = ExperienceNeeded;
    	 this.Class = Class;
    	 this.AvaiblePoint = AvaiblePoint;
    }

    @Override
    public void fromBytes(ByteBuf buf) {

    	this.Level = buf.readInt();
    	this.Experience = buf.readInt();
    	this.ExperienceNeeded = buf.readInt();
   	 	this.Class = buf.readInt();
   	 	this.AvaiblePoint = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {

    	 buf.writeInt(Level);
    	 buf.writeInt(Experience);
    	 buf.writeInt(ExperienceNeeded);
    	 buf.writeInt(Class);
    	 buf.writeInt(AvaiblePoint);
    }

    public static class Handler implements IMessageHandler<LevelMessage, IMessage>  {
    	
    	@Override
		public IMessage onMessage(final LevelMessage message, final MessageContext ctx) {
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                	EntityPlayer player = ctx.getServerHandler().playerEntity;
                	if (player != null){
                		ExtendedSpectralPlayer.get(player).SetSpectralLevel(message.Level);
                		ExtendedSpectralPlayer.get(player).SetExperience(message.Experience);
                		ExtendedSpectralPlayer.get(player).SetExperienceNeeded(message.ExperienceNeeded);
                		ExtendedSpectralPlayer.get(player).UpdatePlayerClass(message.Class);
                		ExtendedSpectralPlayer.get(player).SetPoints(message.AvaiblePoint);
                	} else {
                		System.out.println("No Message");
                	}
                }
            });
			return null;
		}
    }
}