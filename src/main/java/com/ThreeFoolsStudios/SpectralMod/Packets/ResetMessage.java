package com.ThreeFoolsStudios.SpectralMod.Packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class ResetMessage implements IMessage {

	private int Level;
	private int Experience;
	private int XPNeeded;
	private int ActiveSpell;
	private int Class;
    private int NumberSpell;
    private int SpellOne;
    private int SpellTwo;
    private int SpellThree;
    private int MasterSpell;
    private int points;
    private int range;
    private int speed;
    private int strength;
    private int health;
    private int resistance;
    
    public ResetMessage() { }

    public ResetMessage(int Level, int Experience, int XPNeeded, int ActiveSpell, int Class,
    		int NumberSpell, int SpellOne, int SpellTwo, int SpellThree, int MasterSpell, int points,
    		int range, int speed, int strength, int health, int resistance) {

    	 this.Level = Level;
    	 this.Experience = Experience;
    	 this.XPNeeded = XPNeeded;
    	 this.ActiveSpell = ActiveSpell;
    	 this.Class = Class;
    	 this.NumberSpell = NumberSpell;
    	 this.SpellOne = SpellOne;
    	 this.SpellTwo = SpellTwo;
    	 this.SpellThree = SpellThree;
    	 this.MasterSpell = MasterSpell;
    	 this.points = points;
    	 this.range = range;
    	 this.speed = speed;
    	 this.strength = strength;
    	 this.health = health;
    	 this.resistance = resistance;
    }

    @Override
    public void fromBytes(ByteBuf buf) {

    	this.Level = buf.readInt();
    	this.Experience = buf.readInt();
   	 	this.XPNeeded = buf.readInt();
   	 	this.ActiveSpell = buf.readInt();
   	 	this.Class = buf.readInt();
   	 	this.NumberSpell = buf.readInt();
   	 	this.SpellOne = buf.readInt();
   	 	this.SpellTwo = buf.readInt();
   	 	this.SpellThree = buf.readInt();
   	 	this.MasterSpell = buf.readInt();
   	 	this.points = buf.readInt();
   	 	this.range = buf.readInt();
   	 	this.speed = buf.readInt();
   	 	this.strength = buf.readInt();
   	 	this.health = buf.readInt();
   	 	this.resistance = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {

    	 buf.writeInt(Level);
    	 buf.writeInt(Experience);
    	 buf.writeInt(XPNeeded);
    	 buf.writeInt(ActiveSpell);
    	 buf.writeInt(Class);
    	 buf.writeInt(NumberSpell);
    	 buf.writeInt(SpellOne);
    	 buf.writeInt(SpellTwo);
    	 buf.writeInt(SpellThree);
    	 buf.writeInt(MasterSpell);
    	 buf.writeInt(points);
    	 buf.writeInt(range);
    	 buf.writeInt(speed);
    	 buf.writeInt(strength);
    	 buf.writeInt(health);
    	 buf.writeInt(resistance);
    }

    public static class Handler implements IMessageHandler<ResetMessage, IMessage>  {
    	
		@Override
		public IMessage onMessage(final ResetMessage message, final MessageContext ctx) {
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                	EntityPlayer player = ctx.getServerHandler().playerEntity;
                	if (player != null){
                		ExtendedSpectralPlayer.get(player).SetSpectralLevel(message.Level);
                		ExtendedSpectralPlayer.get(player).SetExperience(message.Experience);
                		ExtendedSpectralPlayer.get(player).SetExperienceNeeded(message.XPNeeded);
                		ExtendedSpectralPlayer.get(player).SetActiveSpell(message.ActiveSpell);
                		ExtendedSpectralPlayer.get(player).UpdatePlayerClass(message.Class);
                		ExtendedSpectralPlayer.get(player).SetServerSpellNumber(message.NumberSpell);
                		ExtendedSpectralPlayer.get(player).SetSpell1Level(message.SpellOne);
                		ExtendedSpectralPlayer.get(player).SetSpell2Level(message.SpellTwo);
                		ExtendedSpectralPlayer.get(player).SetSpell3Level(message.SpellThree);
                		ExtendedSpectralPlayer.get(player).SetMasterSpell(message.MasterSpell);
                		ExtendedSpectralPlayer.get(player).SetPoints(message.points);
                		ExtendedSpectralPlayer.get(player).SetRange(message.range);
                		ExtendedSpectralPlayer.get(player).SetSpeed(message.speed);
                		ExtendedSpectralPlayer.get(player).SetStrength(message.strength);
                		ExtendedSpectralPlayer.get(player).SetHealth(message.health);
                		ExtendedSpectralPlayer.get(player).SetResistance(message.resistance);
                	} else {
                		System.out.println("No Message");
                	}
                }
            });
			return null;
		}
    }

}
