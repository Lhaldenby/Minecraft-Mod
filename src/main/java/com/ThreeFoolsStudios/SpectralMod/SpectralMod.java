package com.ThreeFoolsStudios.SpectralMod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.ThreeFoolsStudios.SpectralMod.Event.SpectralEventHandler;
import com.ThreeFoolsStudios.SpectralMod.Gui.SpectralGuiHandler;
import com.ThreeFoolsStudios.SpectralMod.Packets.ActiveSpellMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.LevelMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.RechargeMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.ResetMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.SpellMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.TargetMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.UpgradeMessage;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;
import com.ThreeFoolsStudios.SpectralMod.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class SpectralMod {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy Proxy;
	
	public static final SpectralTab tabSpectral = new SpectralTab("tabSpectral");
	
	public static SimpleNetworkWrapper network;
	
	public static Item Spectral_Projectile;
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
	MinecraftForge.EVENT_BUS.register(new SpectralEventHandler());
	MinecraftForge.EVENT_BUS.register(new SpectralGuiHandler());
	}
	
	@Instance
	public static SpectralMod instance = new SpectralMod();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Proxy.Preinit(event);	
		network = NetworkRegistry.INSTANCE.newSimpleChannel("SpectralChannel");
	    network.registerMessage(RechargeMessage.Handler.class, RechargeMessage.class, 0, Side.SERVER);
	    network.registerMessage(LevelMessage.Handler.class, LevelMessage.class, 1, Side.SERVER); 
	    network.registerMessage(UpgradeMessage.Handler.class, UpgradeMessage.class, 2, Side.SERVER);
	    network.registerMessage(SpellMessage.Handler.class, SpellMessage.class, 3, Side.SERVER); 
	    network.registerMessage(ActiveSpellMessage.Handler.class, ActiveSpellMessage.class, 4, Side.SERVER); 
	    network.registerMessage(ResetMessage.Handler.class, ResetMessage.class, 5, Side.SERVER); 	
	    network.registerMessage(TargetMessage.Handler.class, TargetMessage.class, 6, Side.SERVER); 
	 }

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		Proxy.registerRenders();
		Proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static Achievement achievementStartSpectralMagic = new Achievement("achievement.StartSpectralMagic", "StartSpectralMagic", 
			0, 0, Items.book  , (Achievement)null);
	
	public static Achievement achievementCastFirstSpell =
			new Achievement("achievement.CastFirstSpell", "CastFirstSpell",
					1, 1, Items.glass_bottle, SpectralMod.achievementStartSpectralMagic);
	
	public static Achievement achievementFullSpell =
			new Achievement("achievement.FullSpell", "FullSpell",
					1, 3, Items.blaze_rod, SpectralMod.achievementCastFirstSpell);
	
	public static Achievement achievementAllSpells =
			new Achievement("achievement.AllSpells", "AllSpells",
					3, 1, Items.brewing_stand, SpectralMod.achievementCastFirstSpell);
	
	public static Achievement achievementMaxSpells =
			new Achievement("achievement.MaxSpells", "MaxSpells",
					3, 3, Items.cauldron, SpectralMod.achievementAllSpells);
	
	public static Achievement achievementGetShard =
			new Achievement("achievement.GetShard", "GetShard",
					0, -2, Blocks.furnace, SpectralMod.achievementStartSpectralMagic);
	
	public static Achievement achievementMakeGem =
			new Achievement("achievement.MakeGem", "MakeGem",
					2, -3, Items.diamond, SpectralMod.achievementGetShard);
	
	public static Achievement achievementMakeArmour =
			new Achievement("achievement.MakeArmour", "MakeArmour",
					4, -3, Items.diamond_chestplate, SpectralMod.achievementMakeGem);
	
	public static Achievement achievementMakeStaff =
			new Achievement("achievement.MakeStaff", "MakeStaff",
					2, -5, Items.stick, SpectralMod.achievementMakeGem);
	
	public static Achievement achievementChooseClass =
			new Achievement("achievement.ChooseClass", "ChooseClass",
					-2, 0, Items.feather, SpectralMod.achievementStartSpectralMagic);
	
	public static Achievement achievementLevelUp =
			new Achievement("achievement.LevelUp", "LevelUp",
					-4, 0, Items.ghast_tear, SpectralMod.achievementChooseClass);
	
	public static Achievement achievementMaxLevel =
			new Achievement("achievement.MaxLevel", "MaxLevel",
					-4, -2, Items.golden_apple, SpectralMod.achievementLevelUp);

}
