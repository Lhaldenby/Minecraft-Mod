package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class SpellMessage implements IMessage {

	    private int NumberSpell;
	    private int SpellOne;
	    private int SpellTwo;
	    private int SpellThree;
	    private int MasterSpell;
	    
	    public SpellMessage() { }

	    public SpellMessage(int NumberSpell, int SpellOne, int SpellTwo, int SpellThree, int MasterSpell) {

	    	 this.NumberSpell = NumberSpell;
	    	 this.SpellOne = SpellOne;
	    	 this.SpellTwo = SpellTwo;
	    	 this.SpellThree = SpellThree;
	    	 this.MasterSpell = MasterSpell;
	    }

	    @Override
	    public void fromBytes(ByteBuf buf) {

	   	 	this.NumberSpell = buf.readInt();
	   	 	this.SpellOne = buf.readInt();
	   	 	this.SpellTwo = buf.readInt();
	   	 	this.SpellThree = buf.readInt();
	   	 	this.MasterSpell = buf.readInt();
	    }

	    @Override
	    public void toBytes(ByteBuf buf) {

	    	 buf.writeInt(NumberSpell);
	    	 buf.writeInt(SpellOne);
	    	 buf.writeInt(SpellTwo);
	    	 buf.writeInt(SpellThree);
	    	 buf.writeInt(MasterSpell);
	    }

	    public static class Handler implements IMessageHandler<SpellMessage, IMessage>  {
	    	
			@Override
			public IMessage onMessage(final SpellMessage message, final MessageContext ctx) {
				IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
	            mainThread.addScheduledTask(new Runnable() {
	                @Override
	                public void run() {
	                	EntityPlayer player = ctx.getServerHandler().playerEntity;
	                	if (player != null){
	                		ExtendedSpectralPlayer.get(player).SetServerSpellNumber(message.NumberSpell);
	                		ExtendedSpectralPlayer.get(player).SetSpell1Level(message.SpellOne);
	                		ExtendedSpectralPlayer.get(player).SetSpell2Level(message.SpellTwo);
	                		ExtendedSpectralPlayer.get(player).SetSpell3Level(message.SpellThree);
	                		ExtendedSpectralPlayer.get(player).SetMasterSpell(message.MasterSpell);
	                	} else {
	                		System.out.println("No Message");
	                	}
	                }
	            });
				return null;
			}
	    }

}
