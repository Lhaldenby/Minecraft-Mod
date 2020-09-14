package com.ThreeFoolsStudios.SpectralMod.Gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.SpectralMod;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.MasterButton;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.MasterButton2;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.MasterButton3;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.PlayerScreenButton;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.SpellButton2;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.SpellButton3;
import com.ThreeFoolsStudios.SpectralMod.Gui.Buttons.SpellButtons;
import com.ThreeFoolsStudios.SpectralMod.Packets.ActiveSpellMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.LevelMessage;
import com.ThreeFoolsStudios.SpectralMod.Packets.SpellMessage;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class GuiSpectralAltar extends GuiScreen {
	//this creates every different button i want to add to the screen
	private GuiButton a;
	private GuiButton e;
	private GuiButton n;
	
	private GuiButton Master_1;
	private GuiButton Master_2;
	private GuiButton Master_3;
	
	private GuiButton Spell_1;
	private GuiButton Spell_2;
	private GuiButton Spell_3;
	
	private GuiButton Spell_1_Upgrade_2;
	private GuiButton Spell_1_Upgrade_3;
	
	private GuiButton Spell_2_Upgrade_2;
	private GuiButton Spell_2_Upgrade_3;
	
	private GuiButton Spell_3_Upgrade_2;
	private GuiButton Spell_3_Upgrade_3;
	
	private GuiButton ToggleScreen;
	//this defines the file locations for the the texture of the different images in this gui
	private static final ResourceLocation LockedSpells = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/LockedSpells.png");
	private static final ResourceLocation texturepath = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/ClassSelection.png");
	
	private static final ResourceLocation texturepath2 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/AltarBackground.png");
	private static final ResourceLocation texturepath3 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/ArcaneSpellBackground.png");
	
	private static final ResourceLocation texturepath4 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/ElementalSpellBackground.png");
	private static final ResourceLocation texturepath5 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/NecromanticSpellBackground.png");
	
	private static final ResourceLocation texturepath6 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/Elemental_Spell_Images.png");
	private static final ResourceLocation texturepath7 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/MasterSpells.png");
	private static final ResourceLocation texturepath8 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/Arcane_Spell_Images.png");
	private static final ResourceLocation texturepath9 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/Necromantic_Spell_Images.png");
	private static final ResourceLocation texturepath10 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/ActiveSpells.png");

	private static final ResourceLocation texturepath11 = new ResourceLocation(Reference.MOD_ID + ":textures/Gui/TabIcons.png");

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
	this.drawDefaultBackground(); //this fades the game background to a grey scale
	if (SpectralPlayer.GetActiveClass() == 0) { //the the player has no spell class then draw a default background
		this.mc.getTextureManager().bindTexture(texturepath); //this draws a grey cube onto the screen with a image above which will have 
		//buttons placed in top
		this.drawTexturedModalRect((this.width - 201) /2 , (this.height - 175) /2 , 0, 0, 200, 175);
	}
	else { //if the player has a class then the texture for the altar background is drawn
		this.mc.getTextureManager().bindTexture(texturepath2);
		this.drawTexturedModalRect((this.width - 223) /2 , (this.height - 175) /2, 0, 0, 223, 175);
		this.mc.getTextureManager().bindTexture(texturepath11); //this draws the tab icon for the spell upgrade screen 
		this.drawTexturedModalRect((this.width - 212) /2 , (this.height - 130) /2, 0, 0, 16, 16);
		switch (SpectralPlayer.GetActiveClass()){
		case 1: //if the players class is arcane then it draws all the spell icons for the arcane class
			this.mc.getTextureManager().bindTexture(texturepath3);
			this.drawTexturedModalRect((this.width - 160) /2, (this.height - 120) /2, 0, 0, 180, 130); //background
			this.mc.getTextureManager().bindTexture(texturepath8);
			this.drawTexturedModalRect((this.width - 115) /2, (this.height - 100) /2, 0, 0, 16, 16);// spell icons *9 //spell 1
			this.drawTexturedModalRect((this.width + 8) /2, (this.height - 100) /2, 16, 0, 16, 16); // spell 2
			this.drawTexturedModalRect((this.width + 123) /2, (this.height - 100) /2, 32, 0, 16, 16); // spell 3
			this.drawTexturedModalRect((this.width - 115) /2, (this.height - 40) /2, 0, 16, 16, 16); // spell 1 upgrade 1
			this.drawTexturedModalRect((this.width + 8) /2, (this.height - 40) /2, 16, 16, 16, 16); // spell 2 upgrade 1
			this.drawTexturedModalRect((this.width + 123) /2, (this.height - 40) /2, 32, 16, 16, 16); // spell 3 upgrade 1
			this.drawTexturedModalRect((this.width - 115) /2, (this.height + 20) /2, 0, 32, 16, 16); // spell 1 upgrade 2
			this.drawTexturedModalRect((this.width + 8) /2, (this.height + 20) /2, 16, 32, 16, 16); // spell 2 upgrade 2
			this.drawTexturedModalRect((this.width + 123) /2, (this.height + 20) /2, 32, 32, 16, 16); // spell 3 upgrade 2
			break;
	case 2://if the players class is elemental then it draws all the spell icons for the elemental class
		this.mc.getTextureManager().bindTexture(texturepath4);
		this.drawTexturedModalRect((this.width - 160) /2, (this.height - 120) /2, 0, 0, 180, 130); //background
		this.mc.getTextureManager().bindTexture(texturepath6);
		this.drawTexturedModalRect((this.width - 115) /2, (this.height - 100) /2, 0, 0, 16, 16);// spell icons *9 //spell 1
		this.drawTexturedModalRect((this.width + 8) /2, (this.height - 100) /2, 16, 0, 16, 16); // spell 2
		this.drawTexturedModalRect((this.width + 123) /2, (this.height - 100) /2, 32, 0, 16, 16); // spell 3
		this.drawTexturedModalRect((this.width - 115) /2, (this.height - 40) /2, 0, 16, 16, 16); // spell 1 upgrade 1
		this.drawTexturedModalRect((this.width + 8) /2, (this.height - 40) /2, 16, 16, 16, 16); // spell 2 upgrade 1
		this.drawTexturedModalRect((this.width + 123) /2, (this.height - 40) /2, 32, 16, 16, 16); // spell 3 upgrade 1
		this.drawTexturedModalRect((this.width - 115) /2, (this.height + 20) /2, 0, 32, 16, 16); // spell 1 upgrade 2
		this.drawTexturedModalRect((this.width + 8) /2, (this.height + 20) /2, 16, 32, 16, 16); // spell 2 upgrade 2
		this.drawTexturedModalRect((this.width + 123) /2, (this.height + 20) /2, 32, 32, 16, 16); // spell 3 upgrade 2
		break;
	case 3: //if the players class is necromantic then it draws all the spell icons for the necromantic class
		this.mc.getTextureManager().bindTexture(texturepath5);
		this.drawTexturedModalRect((this.width - 160) /2, (this.height - 120) /2, 0, 0, 180, 130); //background
		this.mc.getTextureManager().bindTexture(texturepath9);
		this.drawTexturedModalRect((this.width - 115) /2, (this.height - 100) /2, 0, 0, 16, 16);// spell icons *9 //spell 1
		this.drawTexturedModalRect((this.width + 8) /2, (this.height - 100) /2, 16, 0, 16, 16); // spell 2
		this.drawTexturedModalRect((this.width + 123) /2, (this.height - 100) /2, 32, 0, 16, 16); // spell 3
		this.drawTexturedModalRect((this.width - 115) /2, (this.height - 40) /2, 0, 16, 16, 16); // spell 1 upgrade 1
		this.drawTexturedModalRect((this.width + 8) /2, (this.height - 40) /2, 16, 16, 16, 16); // spell 2 upgrade 1
		this.drawTexturedModalRect((this.width + 123) /2, (this.height - 40) /2, 32, 16, 16, 16); // spell 3 upgrade 1
		this.drawTexturedModalRect((this.width - 115) /2, (this.height + 20) /2, 0, 32, 16, 16); // spell 1 upgrade 2
		this.drawTexturedModalRect((this.width + 8) /2, (this.height + 20) /2, 16, 32, 16, 16); // spell 2 upgrade 2
		this.drawTexturedModalRect((this.width + 123) /2, (this.height + 20) /2, 32, 32, 16, 16); // spell 3 upgrade 2
		break;
	}
		this.mc.getTextureManager().bindTexture(texturepath7); //this draws the master spell icons
		this.drawTexturedModalRect((this.width - 115) /2, (this.height + 95) /2, 0,0, 16, 16);// Master Spells
		this.drawTexturedModalRect((this.width + 8) /2, (this.height + 95) /2, 16, 0, 16, 16);
		this.drawTexturedModalRect((this.width + 123) /2, (this.height + 95) /2, 32, 0, 16, 16);
		this.mc.getTextureManager().bindTexture(texturepath10); //this draws the spell header for obtained spells
		this.drawTexturedModalRect((this.width - 160) /2, (this.height - 160) /2, 0,0, 60, 20);
		this.drawTexturedModalRect((this.width - 40) /2, (this.height - 160) /2, 0,0, 60, 20);
		this.drawTexturedModalRect((this.width + 80) /2, (this.height - 160) /2,0, 0, 60, 20);
		switch (SpectralPlayer.GetActiveClass()){
		case 1: //this draws the strings for the spell headers for each class
			this.fontRendererObj.drawString("Dig", (this.width - 113) /2,(this.height - 150) /2, -1, true);
			this.fontRendererObj.drawString("Burst", (this.width - 2) /2,(this.height - 150) /2, -1, true);
			this.fontRendererObj.drawString("Poison", (this.width + 110) /2,(this.height - 150) /2, -1, true);
			break;
		case 2:
			this.fontRendererObj.drawString("Fire", (this.width - 118) /2,(this.height - 150) /2, -1, true);
			this.fontRendererObj.drawString("Frost", (this.width - 2) /2,(this.height - 150) /2, -1, true);
			this.fontRendererObj.drawString("Storm", (this.width + 115) /2,(this.height - 150) /2, -1, true);
			break;
		case 3:
			this.fontRendererObj.drawString("Summon", (this.width - 130) /2,(this.height - 150) /2, -1, true);
			this.fontRendererObj.drawString("Shadow", (this.width - 2) /2,(this.height - 150) /2, -1, true);
			this.fontRendererObj.drawString("Warp", (this.width + 120) /2,(this.height - 150) /2, -1, true);
			break;
		}
	}
	super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() { //the gui doesnt pause the game
		return false;
	}

	@Override
	public void initGui() {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
		
		if (SpectralPlayer.GetActiveClass() == 0) {  // this draws the class buttons for a player without a class
			this.buttonList.add(this.a = new GuiButton(0, (this.width - 60) /2,(this.height - 115) /2, 60, 20, "Arcane"));
			this.buttonList.add(this.e = new GuiButton(1, (this.width - 160) /2,(this.height + 25) /2, 60, 20, "Elemental"));
			this.buttonList.add(this.n = new GuiButton(2, (this.width + 40) /2,(this.height + 25) /2, 65, 20, "Necromantic"));
			
		}
		else { //if the player has a class then it adds the change screen button to the screen
			this.buttonList.add(this.ToggleScreen = new PlayerScreenButton(0, (this.width - 212) /2,(this.height - 70) /2, 16, 16, ""));
			
			if (SpectralPlayer.GetSpectralLevel() == 1 && SpectralPlayer.GetSpell1Level() == 0 
					&& SpectralPlayer.GetSpell2Level() == 0 && SpectralPlayer.GetSpell3Level() == 0) {
				//if the player has no spells then it draws the buttons for spell headers
				switch (SpectralPlayer.GetActiveClass()){
					
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2,(this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2,(this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2,(this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}
				
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell1Level() == 1 
					&& SpectralPlayer.GetSpectralLevel() == 2) {
				//if the player has got the first spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell2Level() == 1 
					&& SpectralPlayer.GetSpectralLevel() == 2) {
				//if the player has got the second spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetSpectralLevel() == 2) {
				//if the player has got the third spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell1Level() == 2 
					&& SpectralPlayer.GetSpectralLevel() == 3) {
				
				switch (SpectralPlayer.GetActiveClass()){
				//if the player has got the first spell draw the other spell headers
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpectralLevel() == 3 ) {
				//if the player has got the second spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell3Level() == 2 
					&& SpectralPlayer.GetSpectralLevel() == 3 ) {
				//if the player has got the third spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 2 && SpectralPlayer.GetSpell1Level() == 1 
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpectralLevel() == 3) {
				//if the player has got the first and second spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 2 && SpectralPlayer.GetSpell1Level() == 1 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetSpectralLevel() == 3) {
				//if the player has got the first and third spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetNumberOfSpells() == 2 && SpectralPlayer.GetSpell2Level() == 1 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetSpectralLevel() == 3) {
				//if the player has got the second and third spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
				}
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell1Level() == 1 
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got every spell then draw all spell level 2 buttons		
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell1Level() == 2 
					&& SpectralPlayer.GetSpell2Level() == 1){
				//if the player has got the first and second spell draw the other spell headers and level 2 icons
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell1Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got the first and third spell draw the other spell headers and level 2 icons
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got the second and third spell draw the other spell headers and level 2 icons
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell1Level() == 1){
				//if the player has got the first and second spell draw the other spell headers and level 2 and 3 icons
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell3Level() == 2 
					&& SpectralPlayer.GetSpell1Level() == 1){
				//if the player has got the first and third spell draw the other spell headers and level 2 and 3 icons
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell3Level() == 2 
					&& SpectralPlayer.GetSpell2Level() == 1){
				//if the player has got the second and third spell draw the other spell headers and level 2 and 3 icons
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell1Level() == 3){
				//if the player has got the first spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
				}
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell2Level() == 3){
				//if the player has got the second spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}
				
			} else if (SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell3Level() == 3){
				//if the player has got the third spell draw the other spell headers
				switch (SpectralPlayer.GetActiveClass()){

				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got all spells draw level 2 and 3 buttons
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 1
						&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got all spells draw level 2 and 3 buttons
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 1
						&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
				//if the player has got all spells draw level 2 and 3 buttons
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got first and third spells draw level 2 and 3 buttons and master button
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));						
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 1){
				//if the player has got first and second spells draw level 2 and 3 buttons and master button
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));	
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 1){
				//if the player has got first and second spells draw level 2 and 3 buttons and master button
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));	
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got second and third spells draw level 2 and 3 buttons and master button
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));	
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 1){
				//if the player has got first and third spells draw level 2 and 3 buttons and master button
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));	
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 1){
				//if the player has got second and third spells draw level 2 and 3 buttons and master button
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));	
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 2){
				//if the player has got first and second spells draw level 2 and 3 buttons 
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell3Level() == 2){
				//if the player has got first and third spells draw level 2 and 3 buttons 
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell2Level() == 2
					&& SpectralPlayer.GetSpell3Level() == 2){
				//if the player has got second and third spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 3 
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetMasterSpell() != 0){
				//if the player has got first and second spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetMasterSpell() != 0){
				//if the player has got first and third spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetMasterSpell() != 0){
				//if the player has got first and second spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetMasterSpell() != 0){
				//if the player has got second and third spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetMasterSpell() != 0){
				//if the player has got first and third spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetMasterSpell() != 0){
				//if the player has got second and third spells draw level 2 and 3 buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2){
				//if the player has got first and second spells draw level 2 and 3 buttons and master buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 2){
				//if the player has got first and third spells draw level 2 and 3 buttons and master buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3: 
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 2){
				//if the player has got first and second spells draw level 2 and 3 buttons and master buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 2){
				//if the player has got second and third spells draw level 2 and 3 buttons and master buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 2){
				//if the player has got first and third spells draw level 2 and 3 buttons and master buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2){
				//if the player has got first and second spells draw level 2 and 3 buttons and master buttons
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got all the spells draw level 2 and 3 buttons and master buttons
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got all the spells draw level 2 and 3 buttons and master buttons
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
				//if the player has got all the spells draw level 2 and 3 buttons and master buttons
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
				//if the player has got all the spells draw level 2 and 3 buttons as with every other if statement from this point onwards
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 3){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 3){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 3){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}

				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));	
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetMasterSpell() != 0){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetMasterSpell() != 0){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));					
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}

				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetMasterSpell() != 0){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Poison"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2 , 60, 20, "Storm"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_3 = new GuiButton(0,(this.width + 80) /2, (this.height - 160) /2, 60, 20, "Warp"));
					break;
					
				}

				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetMasterSpell() != 0){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetMasterSpell() != 0){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Burst"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Frost"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_2 = new GuiButton(0,(this.width - 40) /2, (this.height - 160) /2, 60, 20, "Shadow"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetMasterSpell() != 0){
				
				switch (SpectralPlayer.GetActiveClass()){
				
				case 1:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Dig"));
					break;
					
				case 2:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Fire"));
					break;
					
				case 3:
					this.buttonList.add(this.Spell_1 = new GuiButton(0,(this.width - 160) /2, (this.height - 160) /2, 60, 20, "Summon"));
					break;
					
				}
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3 
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 1 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 1 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 1 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
				
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_3_Upgrade_2 = new SpellButton3(0, (this.width + 123) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_2_Upgrade_2 = new SpellButton2(0, (this.width + 8) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 1 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_2 = new SpellButtons(0, (this.width - 115) /2, (this.height - 40) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));	
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 10 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
				
				this.buttonList.add(this.Master_1 = new MasterButton(0, (this.width - 115) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_2 = new MasterButton2(0, (this.width + 8) /2, (this.height + 95) /2, 16, 16, ""));
				this.buttonList.add(this.Master_3 = new MasterButton3(0, (this.width + 123) /2, (this.height + 95) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 10 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_3_Upgrade_3 = new SpellButton3(0, (this.width + 123) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 10 && SpectralPlayer.GetSpell1Level() == 3 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_2_Upgrade_3 = new SpellButton2(0, (this.width + 8) /2, (this.height + 20) /2, 16, 16, ""));
				
			} else if (SpectralPlayer.GetSpectralLevel() == 10 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0){
				
				this.buttonList.add(this.Spell_1_Upgrade_3 = new SpellButtons(0, (this.width - 115) /2, (this.height + 20) /2, 16, 16, ""));
				
			}
		
		} 
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
		if (button == this.ToggleScreen){
			this.mc.displayGuiScreen(null);
			if (this.mc.currentScreen == null){
				this.mc.displayGuiScreen(new PlayerUpgradeGui());
			}
		}
		else if (button == this.a) { // arcane class set
			this.mc.displayGuiScreen(null);
			SpectralPlayer.UpdatePlayerClass(1);
			this.initGui();			
			if (this.mc.currentScreen == null){
				this.mc.displayGuiScreen(new GuiSpectralAltar());
			}
			SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
			SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
			SpectralPlayer.GetPoints()));
		} else if (button == this.e) { // elemental class set
			this.mc.displayGuiScreen(null);
			SpectralPlayer.UpdatePlayerClass(2);
			this.initGui();			
			if (this.mc.currentScreen == null){
				this.mc.displayGuiScreen(new GuiSpectralAltar());
			}
			SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
			SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
			SpectralPlayer.GetPoints()));
		} else if (button == this.n) { // necromantic class set
			this.mc.displayGuiScreen(null);
			SpectralPlayer.UpdatePlayerClass(3);
			this.initGui();			
			if (this.mc.currentScreen == null){
				this.mc.displayGuiScreen(new GuiSpectralAltar());
			}
			SpectralMod.network.sendToServer(new LevelMessage(SpectralPlayer.GetSpectralLevel(), 
			SpectralPlayer.GetExperience(), SpectralPlayer.GetExperienceNeeded(), SpectralPlayer.GetActiveClass(), 
			SpectralPlayer.GetPoints()));
		}
		//
		else if (button == this.Spell_1) { 
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetActiveSpell(1);
			SpectralPlayer.SetNumberOfSpells(1);
			SpectralPlayer.SetSpell1Level(1);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_2) { 
			this.mc.displayGuiScreen(null);
			if (SpectralPlayer.GetNumberOfSpells() == 0){
				SpectralPlayer.SetActiveSpell(2);
			}
			SpectralPlayer.SetNumberOfSpells(1);
			SpectralPlayer.SetSpell2Level(1);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_3) { 
			if (SpectralPlayer.GetNumberOfSpells() == 0){
				SpectralPlayer.SetActiveSpell(3);
			}
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetNumberOfSpells(1);
			SpectralPlayer.SetSpell3Level(1);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_1_Upgrade_2) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetSpell1Level(2);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_2_Upgrade_2) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetSpell2Level(2);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_3_Upgrade_2) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetSpell3Level(2);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_1_Upgrade_3) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetSpell1Level(3);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_2_Upgrade_3) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetSpell2Level(3);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Spell_3_Upgrade_3) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetSpell3Level(3);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Master_1) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetNumberOfSpells(1);
			SpectralPlayer.SetMasterSpell(1);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Master_2) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetNumberOfSpells(1);
			SpectralPlayer.SetMasterSpell(2);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));					
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} else if (button == this.Master_3) {
			this.mc.displayGuiScreen(null);
			SpectralPlayer.SetNumberOfSpells(1);
			SpectralPlayer.SetMasterSpell(3);
			if (this.mc.currentScreen == null){
				this.mc.setIngameFocus();
			}
			SpectralMod.network.sendToServer(new SpellMessage(SpectralPlayer.GetNumberOfSpells(),
			SpectralPlayer.GetSpell1Level(), SpectralPlayer.GetSpell2Level(), SpectralPlayer.GetSpell3Level(),
			SpectralPlayer.GetMasterSpell()));		
			SpectralMod.network.sendToServer(new ActiveSpellMessage(SpectralPlayer.GetActiveSpell()));
		} 
	}
}
