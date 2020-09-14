package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class RechargeMessage implements IMessage {

    private int SpellOneRecharge;
    private int SpellTwoRecharge;
    private int SpellThreeRecharge;
    private int MasterSpellRecharge;
    
    public RechargeMessage() { }

    public RechargeMessage(int SpellOneRecharge,
    		int SpellTwoRecharge, int SpellThreeRecharge, int MasterSpellRecharge) {

    	 this.SpellOneRecharge = SpellOneRecharge;
    	 this.SpellTwoRecharge = SpellTwoRecharge;
    	 this.SpellThreeRecharge = SpellThreeRecharge;
    	 this.MasterSpellRecharge = MasterSpellRecharge;
    }

    @Override
    public void fromBytes(ByteBuf buf) {

   	 	this.SpellOneRecharge = buf.readInt();
   	 	this.SpellTwoRecharge = buf.readInt();
   	 	this.SpellThreeRecharge = buf.readInt();
   	 	this.MasterSpellRecharge = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {

    	 buf.writeInt(SpellOneRecharge);
    	 buf.writeInt(SpellTwoRecharge);
    	 buf.writeInt(SpellThreeRecharge);
    	 buf.writeInt(MasterSpellRecharge);
    }

    public static class Handler implements IMessageHandler<RechargeMessage, IMessage>  {
    	
		@Override
		public IMessage onMessage(final RechargeMessage message, final MessageContext ctx) {
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                	EntityPlayer player = ctx.getServerHandler().playerEntity;
                	if (player != null){
                		ExtendedSpectralPlayer.get(player).SetSpellOneRechargeTime(message.SpellOneRecharge);
                		ExtendedSpectralPlayer.get(player).SetSpellTwoRechargeTime(message.SpellTwoRecharge);
                		ExtendedSpectralPlayer.get(player).SetSpellThreeRechargeTime(message.SpellThreeRecharge);
                		ExtendedSpectralPlayer.get(player).SetSpellFourRechargeTime(message.MasterSpellRecharge);
                	} else {
                		System.out.println("No Message");
                	}
                }
            });
			return null;
		}
    }
}