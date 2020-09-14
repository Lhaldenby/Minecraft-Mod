package com.ThreeFoolsStudios.SpectralMod.Gui;

import java.io.IOException;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.MagicScreenButton;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.PlayerScreenButton;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.UpgradeButton;
import com.ThreeFoolsStudios.SpectralMod.Packets.UpgradeMessage;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

public class PlayerUpgradeGui extends GuiScreen{

	private GuiButton Upgrade1;
	private GuiButton DownGrade1;
	
	private GuiButton Upgrade2;
	private GuiButton DownGrade2;
	
	private GuiButton Upgrade3;
	private GuiButton DownGrade3;
	
	private GuiButton Upgrade4;
	private GuiButton DownGrade4;
	
	private GuiButton Upgrade5;
	private GuiButton DownGrade5;
	
	private GuiButton ToggleScreen;
	
	private static final ResourceLocation LockedSpells = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/LockedSpells.png");
	
	private static final ResourceLocation texturepath = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/AltarBackground.png");
	private static final ResourceLocation texturepath1 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/TabIcons.png");
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
		
		this.drawDefaultBackground();
		this.mc.getTextureManager().bindTexture(texturepath);
		this.drawTexturedModalRect((this.width - 223) /2 , (this.height - 175) /2, 0, 0, 223, 175);
		this.mc.getTextureManager().bindTexture(texturepath1);
		this.drawTexturedModalRect((this.width - 212) /2,(this.height - 70) /2, 16, 0, 16, 16);
		
		this.mc.getTextureManager().bindTexture(LockedSpells);
		this.drawTexturedModalRect((this.width - 150) /2 , (this.height - 125) /2, 0, 0, 60, 20);
		this.drawTexturedModalRect((this.width - 150) /2 , (this.height - 70) /2, 0, 0, 60, 20);
		this.drawTexturedModalRect((this.width - 150) /2 , (this.height - 15) /2, 0, 0, 60, 20);
		this.drawTexturedModalRect((this.width - 150) /2 , (this.height + 40) /2, 0, 0, 60, 20);
		this.drawTexturedModalRect((this.width - 150) /2 , (this.height + 95) /2, 0, 0, 60, 20);
		
		this.fontRendererObj.drawString("Range", (this.width - 122) /2,(this.height - 115) /2, -1, true);
		this.drawString(this.mc.fontRendererObj ,  Integer.toString(SpectralPlayer.GetRange()), (this.width + 85) /2, (this.height -112) /2, -10);
		this.fontRendererObj.drawString("Speed", (this.width - 122) /2,(this.height - 60) /2, -1, true);
		this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetSpeed()), (this.width + 90) /2, (this.height - 57) /2, -10);
		this.fontRendererObj.drawString("Health", (this.width - 122) /2,(this.height - 5) /2, -1, true);
		this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetHealth()), (this.width + 90) /2, (this.height - 2) /2, -10);
		this.fontRendererObj.drawString("Strength", (this.width - 135) /2,(this.height + 50) /2, -1, true);
		this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetStrength()), (this.width + 90) /2, (this.height + 53) /2, -10);
		this.fontRendererObj.drawString("Resistance", (this.width - 142) /2,(this.height + 105) /2, -1, true);
		this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetResistance()), (this.width + 90) /2, (this.height + 108) /2, -10);
		this.drawString(this.mc.fontRendererObj , "Available Points: ", (this.width - 150) /2, (this.height + 145) /2, -10);
		this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetPoints()), (this.width + 40) /2, (this.height + 145) /2, -10);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void initGui() {
		this.buttonList.add(this.ToggleScreen = new MagicScreenButton(0, (this.width - 212) /2 , (this.height - 130) /2, 16, 16, ""));
		
		this.buttonList.add(this.Upgrade1 = new UpgradeButton(0, (this.width + 120) /2,(this.height - 120) /2, 16, 16, "+"));
		this.buttonList.add(this.DownGrade1 = new UpgradeButton(0, (this.width + 40) /2,(this.height - 120) /2, 16, 16, "-"));
		
		this.buttonList.add(this.Upgrade2 = new UpgradeButton(0, (this.width + 120) /2,(this.height - 65) /2, 16, 16, "+"));
		this.buttonList.add(this.DownGrade2 = new UpgradeButton(0, (this.width + 40) /2,(this.height - 65) /2, 16, 16, "-"));
		
		this.buttonList.add(this.Upgrade3 = new UpgradeButton(0, (this.width + 120) /2,(this.height - 10) /2, 16, 16, "+"));
		this.buttonList.add(this.DownGrade3 = new UpgradeButton(0, (this.width + 40) /2,(this.height - 10) /2, 16, 16, "-"));
		
		this.buttonList.add(this.Upgrade4 = new UpgradeButton(0, (this.width + 120) /2,(this.height + 45) /2, 16, 16, "+"));
		this.buttonList.add(this.DownGrade4 = new UpgradeButton(0, (this.width + 40) /2,(this.height + 45) /2, 16, 16, "-"));
		
		this.buttonList.add(this.Upgrade5 = new UpgradeButton(0, (this.width + 120) /2,(this.height + 100) /2, 16, 16, "+"));
		this.buttonList.add(this.DownGrade5 = new UpgradeButton(0, (this.width + 40) /2,(this.height + 100) /2, 16, 16, "-"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
		
	if(button == this.ToggleScreen){
		this.mc.displayGuiScreen(null);
		if (this.mc.currentScreen == null){
			this.mc.displayGuiScreen(new GuiSpectralAltar());
		}	
	}
	else if (button == this.Upgrade1){
		SpectralPlayer.RaiseRange();
		SpectralPlayer.LowerSkillPoints();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.DownGrade1){
		if (SpectralPlayer.GetRange() != 10){
		SpectralPlayer.RaiseSkillPoints();
		}
		SpectralPlayer.LowerRange();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.Upgrade2){
		SpectralPlayer.RaiseSpeed();
		SpectralPlayer.LowerSkillPoints();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.DownGrade2){
		if (SpectralPlayer.GetSpeed() != 0){
			SpectralPlayer.RaiseSkillPoints();
			}
		SpectralPlayer.LowerSpeed();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.Upgrade3){
		SpectralPlayer.RaiseHealth();
		SpectralPlayer.LowerSkillPoints();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.DownGrade3){
		if (SpectralPlayer.GetHealth() != 0){
			SpectralPlayer.RaiseSkillPoints();
			}
		SpectralPlayer.LowerHealth();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.Upgrade4){
		SpectralPlayer.RaiseStrength();
		SpectralPlayer.LowerSkillPoints();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.DownGrade4){
		if (SpectralPlayer.GetStrength() != 0){
			SpectralPlayer.RaiseSkillPoints();
			}
		SpectralPlayer.LowerStrength();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.Upgrade5){
		SpectralPlayer.RaiseResistance();
		SpectralPlayer.LowerSkillPoints();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	else if (button == this.DownGrade5){
		if (SpectralPlayer.GetResistance() != 0){
			SpectralPlayer.RaiseSkillPoints();
			}
		SpectralPlayer.LowerResistance();
		SpectralMod.network.sendToServer(new UpgradeMessage(SpectralPlayer.GetPoints(),
		SpectralPlayer.GetRange(), SpectralPlayer.GetSpeed(), SpectralPlayer.GetStrength(),
		SpectralPlayer.GetHealth(), SpectralPlayer.GetResistance()));
	}
	
	}
}
