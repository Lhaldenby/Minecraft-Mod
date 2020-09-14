package com.ThreeFoolsStudios.SpectralMod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.Event.SpectralEventHandler;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

@SideOnly(Side.CLIENT)
public class SpectralGuiScreen extends Gui
{
private Minecraft mc;

private static final ResourceLocation texturepath = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpellHotbar.png");
private static final ResourceLocation texturepath1 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/Arcane_Spell_Images.png");
private static final ResourceLocation texturepath2 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/Elemental_Spell_Images.png");
private static final ResourceLocation texturepath3 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/Necromantic_Spell_Images.png");
private static final ResourceLocation texturepath4 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/MasterSpells.png");
private static final ResourceLocation texturepath5 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralExperienceBar.png");
private static final ResourceLocation texturepath6 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/RechargeIcons.png");
private static final ResourceLocation texturepath7 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/FrozenGUI.png");

public SpectralGuiScreen(Minecraft mc)
{
super();
// We need this to invoke the render engine.
this.mc = mc;

}

@SubscribeEvent(priority = EventPriority.NORMAL)
public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
	ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
	
	if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

	// this gets the size of the screens
	int xPos = event.resolution.getScaledWidth(); //gets width of the screen
	int yPos = event.resolution.getScaledHeight(); //gets the height of the screen
	int TopScreen = 0; //top of the screen is at 0 pixels
	
	// setting all color values to 1.0F will render the texture as it looks in your texture file
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	//In Minecraft vanilla code it says to do this because of a lighting bug
	GL11.glDisable(GL11.GL_LIGHTING);

	if(SpectralPlayer.GetFrozen() == 1){
		this.drawScaledCustomSizeModalRect(0, 0, 0, 0, (xPos + 100)/ 2, yPos, xPos, yPos, 256, 256);		
	}
	
	switch (SpectralPlayer.GetNumberOfSpells()){ //gets number of spells
			
		case 1: //if player has one spell
			this.mc.getTextureManager().bindTexture(texturepath); //sets the texture path for the hotbar to 1 slot
			this.drawTexturedModalRect(xPos/2 - 11, TopScreen, 0, 0, 22, 22); //draws this on the screen
			if (SpectralPlayer.GetActiveClass() == 1){ //gets spell image if you are Arcane class
				if (SpectralPlayer.GetSpell1Level() == 1){ //if you have spell 1 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2){ //if you have spell 1 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3){ //if you have spell 1 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1){ //if you have spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2){ //if you have spell 2 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3){ //if you have spell 2 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 0, 16, 16);
					 
				} else if (SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 32, 16, 16);
					
				} 
			}
			else if (SpectralPlayer.GetActiveClass() == 2){ //gets spell if you are elemental class
				if (SpectralPlayer.GetSpell1Level() == 1){ //if you have spell 1 level 1
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2){ //if you have spell 1 level 2
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3){ //if you have spell 1 level 3
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1){ //if you have spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2){ //if you have spell 2 level 2
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3){ //if you have spell 2 level 3
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath2); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 32, 16, 16);
					
				} 	
			}
			else if (SpectralPlayer.GetActiveClass() == 3){ //gets spell if you are necromantic class
				if (SpectralPlayer.GetSpell1Level() == 1){  //if you have spell 1 level 1
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2){  //if you have spell 1 level 2
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3){ //if you have spell 1 level 3
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 208, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1){ //if you have spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2){ //if you have spell 2 level 2
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3){ //if you have spell 2 level 3
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath3); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 240, 32, 16, 16);
					
				} 
			}
			break;
			
		case 2: //if you have two spells
			this.mc.getTextureManager().bindTexture(texturepath); //displays the spell hotbar for two spells
			this.drawTexturedModalRect(xPos /2 - 22, TopScreen, 0, 0, 43, 22);
			
			if (SpectralPlayer.GetActiveClass() == 1){ //if you are Arcane class gets image
				if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1){ //if you have spell 1 level 1 and spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1){ //if you have spell 1 level 2 and spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1){ //if you have spell 3 level 1 and spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2){ //if you have spell 1 level 1 and spell 2 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3){ //if you have spell 1 level 1 and spell 2 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2){ //if you have spell 1 level 2 and spell 2 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2){ //if you have spell 1 level 3 and spell 2 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3){ //if you have spell 1 level 2 and spell 2 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3){ //if you have spell 3 level 1 and spell 2 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} 
				else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 1 level 1 and spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 1 level 2 and spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 1 level 3 and spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 1 level 1 and spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 1 level 1 and spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 1 level 2 and spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 1 level 3 and spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 1 level 2 and spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 1 level 3 and spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} 
				else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 2 level 1 and spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 2 level 2 and spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){ //if you have spell 2 level 3 and spell 3 level 1
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 2 level 1 and spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 2 level 1 and spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 2 level 2 and spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){ //if you have spell 2 level 3 and spell 3 level 2
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 2 level 2 and spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){ //if you have spell 2 level 3 and spell 3 level 3
					this.mc.getTextureManager().bindTexture(texturepath1); //draws this spell to the screen
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} 	
			}
			else if (SpectralPlayer.GetActiveClass() == 2){ //this gets the image if they are elemental class
				if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1){ //this will be exactly the same as the arcane class
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} 
				else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} 
				else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath2);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} 
			}
			else if (SpectralPlayer.GetActiveClass() == 3){ //this will get the spell image if they are necromantic class
				if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1){ //this is the same as the arcane class
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 224, 32, 16, 16);
					
				} 
				else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} 
				else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 16, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);
					this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 240, 32, 16, 16);
					
				} 
			}
			break;
			
		case 3: //this is if they have 3 spells available to use
			this.mc.getTextureManager().bindTexture(texturepath); //this gets the spell hotbar for the 3 spells and draws it on the screen
			this.drawTexturedModalRect(xPos /2 -33, TopScreen, 0, 0, 64, 22);
			//this theme continues downwards, where the code checks for each variation of the 3 spells and 3 levels for each spell to see
			//what the player has choosen. Then according to what the player has choosen, the specific image for each spell will be drawn on the screen.
			if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9, TopScreen + 3, 224, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() == 1 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() == 1 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 3 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==1 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==1 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==1 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==2 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==2 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==2 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==1 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==1 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==1 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==2 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==2 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==2 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
					
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 1){
				this.mc.getTextureManager().bindTexture(texturepath1);	
				this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
				this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
				this.mc.getTextureManager().bindTexture(texturepath4);
				this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
				
			}
			
			else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 1 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() == 1 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() == 1 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 2 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() == 2 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() == 2 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 232, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 2){
					this.mc.getTextureManager().bindTexture(texturepath2);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				}
			
				else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 1 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() == 1 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() == 1 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() == 2 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() == 2 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() == 2 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==1 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==2 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 1  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 2  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3  && SpectralPlayer.GetSpell2Level() ==3 
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 232, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 1
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 0, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 224, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 1 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 208, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 2 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 224, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 2
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 16, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell2Level() == 3 && SpectralPlayer.GetSpell3Level() == 3
						&& SpectralPlayer.GetMasterSpell() == 3 && SpectralPlayer.GetActiveClass() == 3){
					this.mc.getTextureManager().bindTexture(texturepath3);	
					this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 224, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 9,  TopScreen + 3, 240, 32, 16, 16);
					this.mc.getTextureManager().bindTexture(texturepath4);
					this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 240, 0, 16, 16);
					
				}
			break;
			
		case 4: //this runs if the player has all of the spells that he/she can get.
			this.mc.getTextureManager().bindTexture(texturepath);
			this.drawTexturedModalRect(xPos /2 - 44, TopScreen, 0, 0, 85, 22);
			
			switch (SpectralPlayer.GetMasterSpell()){ //this sees what master spell you have
			
			case 1: //if you have the first master spell this runs
				this.mc.getTextureManager().bindTexture(texturepath4); //this gets the mast spell the player has and draws it on the screen
				this.drawTexturedModalRect(xPos/2 + 22, TopScreen + 3, 208, 0, 16, 16);
				
				break;
				
			case 2: //if you have the second master spell this runs
				this.mc.getTextureManager().bindTexture(texturepath4); //this gets the mast spell the player has and draws it on the screen
				this.drawTexturedModalRect(xPos/2 + 22, TopScreen + 3, 224, 0, 16, 16);
				
				break;
				
			case 3: //if you have the third master spell this runs
				this.mc.getTextureManager().bindTexture(texturepath4); //this gets the mast spell the player has and draws it on the screen
				this.drawTexturedModalRect(xPos/2 + 22, TopScreen + 3, 240, 0, 16, 16);
				
				break;
			
			}
			//this theme continues downwards, where the code checks for each variation of the 3 spells and 3 levels for each spell to see
			//what the player has choosen. Then according to what the player has choosen, the specific image for each spell will be drawn on the screen.
			if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
					this.mc.getTextureManager().bindTexture(texturepath1);	
					this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
					this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
					this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
					
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
						
				} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
						&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
						
				}
				else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
						
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} 
					else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
						this.mc.getTextureManager().bindTexture(texturepath1);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
						
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 1){
							this.mc.getTextureManager().bindTexture(texturepath1);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} 
					
					else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
						this.mc.getTextureManager().bindTexture(texturepath2);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
						
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					}
					else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} 
						else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
							this.mc.getTextureManager().bindTexture(texturepath2);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 2){
								this.mc.getTextureManager().bindTexture(texturepath2);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						}
					
				else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
						&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
						this.mc.getTextureManager().bindTexture(texturepath3);	
						this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
						this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
						this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
						
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					} else if (SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 3
							&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
							
					}
					else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
							&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} 
						else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
							this.mc.getTextureManager().bindTexture(texturepath3);	
							this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
							this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
							
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 0, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 16, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 2
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 16, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						} else if (SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 3
								&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetActiveClass() == 3){
								this.mc.getTextureManager().bindTexture(texturepath3);	
								this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 208, 0, 16, 16);
								this.drawTexturedModalRect(xPos/2 - 20,  TopScreen + 3, 224, 32, 16, 16);
								this.drawTexturedModalRect(xPos/2 + 1,  TopScreen + 3, 240, 32, 16, 16);
								
						}			
				
			break;
	
	}
	
	if (SpectralPlayer.GetActiveClass() != 0 && SpectralPlayer.GetNumberOfSpells() != 0){ //if they have started the mod they get a experience bar
		this.mc.getTextureManager().bindTexture(texturepath5);
		this.drawTexturedModalRect(xPos/2 - 44, TopScreen + 23, 0, 0, 85, 7); //this draws how much experience they have as part of the bar
		int Experiencebarwidth = (int)(((float) SpectralPlayer.GetExperience() / SpectralPlayer.GetExperienceNeeded()) * 79);
		this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 25, 0, 7, Experiencebarwidth, 3);
	}

	this.mc.getTextureManager().bindTexture(texturepath);
	
	switch (SpectralPlayer.GetNumberOfSpells()){ //this gets how many spells they have
	
		case 1: //this draws the highlighted square round the active spell
				this.drawTexturedModalRect(xPos /2 - 11, TopScreen, 0, 22, 22, 22);
				break;
	
		case 2: //this runs if they have 2 spells
			switch (SpectralPlayer.GetActiveSpell()){  //this hightlights the active spell
			
				case 1:
					this.drawTexturedModalRect(xPos /2 - 22, TopScreen, 0, 22, 22, 22);
					break;
				case 2: 
					if (SpectralPlayer.GetSpell1Level() >= 1){
					this.drawTexturedModalRect(xPos /2 - 1, TopScreen, 0, 22, 22, 22);
					} else
					{
						this.drawTexturedModalRect(xPos /2 - 22, TopScreen, 0, 22, 22, 22);	
					}
					break;
				case 3: 
					this.drawTexturedModalRect(xPos /2 - 1, TopScreen, 0, 22, 22, 22);
					break;
			} 
			break;
	 
		case 3: //this runs if they have 3 spells
			switch (SpectralPlayer.GetActiveSpell()){ //this highlights the active spell
			
				case 1:
					this.drawTexturedModalRect(xPos /2 - 33, TopScreen, 0, 22, 22, 22);
					break;
				case 2: 
					if ((SpectralPlayer.GetSpell1Level() >=1 && SpectralPlayer.GetSpell3Level() >=1) ||
						(SpectralPlayer.GetSpell1Level() >=1 && SpectralPlayer.GetMasterSpell() != 0)){
					this.drawTexturedModalRect(xPos /2 - 12, TopScreen, 0, 22, 22, 22);
					} else {
					this.drawTexturedModalRect(xPos /2 - 33, TopScreen, 0, 22, 22, 22);	
					}
					break;
				case 3:
					if (SpectralPlayer.GetSpell1Level() >= 1 && SpectralPlayer.GetSpell2Level() >=1){
					this.drawTexturedModalRect(xPos /2 + 9, TopScreen, 0, 22, 22, 22);
					} else {
					this.drawTexturedModalRect(xPos /2 - 12, TopScreen, 0, 22, 22, 22);
					}
					break;
				case 4:
					this.drawTexturedModalRect(xPos /2 + 9, TopScreen, 0, 22, 22, 22);
					break;
			}
			break;
			
		case 4: //this runs if they have 4 spells
			switch (SpectralPlayer.GetActiveSpell()){ //this highlights the active spell
	
				case 1:
					this.drawTexturedModalRect(xPos /2 - 44, TopScreen, 0, 22, 22, 22);
					break;
				case 2: 
					this.drawTexturedModalRect(xPos /2 - 22, TopScreen, 0, 22, 22, 22);
					break;
				case 3:
					this.drawTexturedModalRect(xPos /2 - 2, TopScreen, 0, 22, 22, 22);
					break;
				case 4:
					this.drawTexturedModalRect(xPos /2 + 19, TopScreen, 0, 22, 22, 22);
					break;
				}
			break;
		
	}
	
	this.mc.getTextureManager().bindTexture(texturepath6); //this gets the amount of time left until a spell can be used again
	int OneRechargeTime = (int)(((float) SpectralPlayer.GetSpellOneRechargeTime() / SpectralPlayer.GetSpellOneMaxRechargeTime()) * 16);
	int TwoRechargeTime = (int)(((float) SpectralPlayer.GetSpellTwoRechargeTime() / SpectralPlayer.GetSpellTwoMaxRechargeTime()) * 16);
	int ThreeRechargeTime = (int)(((float) SpectralPlayer.GetSpellThreeRechargeTime() / SpectralPlayer.GetSpellThreeMaxRechargeTime()) * 16);
	int FourRechargeTime = (int)(((float) SpectralPlayer.GetSpellFourRechargeTime() / SpectralPlayer.GetSpellFourMaxRechargeTime()) * 16);
	
	switch (SpectralPlayer.GetNumberOfSpells()){ //this gets how many spells they have
	
	case 1: //if they have 1 spell this runs
		if (SpectralPlayer.GetSpellOneRechargeTime() != 0){ //this fills in the hotbar with the amount of time left to get the spell active
			this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 0, 0, 16, OneRechargeTime);
		}
		if (SpectralPlayer.GetSpellTwoRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 16, 0, 16, TwoRechargeTime);
		}
		if (SpectralPlayer.GetSpellThreeRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 8, TopScreen + 3, 32, 0, 16, ThreeRechargeTime);
		}
		break;
		
	case 2:  //this runs if they have 2 spells
		if (SpectralPlayer.GetSpellOneRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 0, 0, 16, OneRechargeTime);
		}
		if (SpectralPlayer.GetSpell1Level() >= 1 && SpectralPlayer.GetSpellTwoRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 16, 0, 16, TwoRechargeTime);
		}
		if (SpectralPlayer.GetSpell3Level() >= 1 && SpectralPlayer.GetSpellTwoRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 19, TopScreen + 3, 16, 0, 16, TwoRechargeTime);
		}
		if (SpectralPlayer.GetSpellThreeRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 + 2, TopScreen + 3, 32, 0, 16, ThreeRechargeTime);
		}
		break;
		
	case 3: //this runs if they have 3 spells
		if (SpectralPlayer.GetSpellOneRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 30, TopScreen + 3, 0, 0, 16, OneRechargeTime);
		}
		
		if (SpectralPlayer.GetSpellTwoRechargeTime() != 0 && (SpectralPlayer.GetSpell1Level() >=1 
			&& SpectralPlayer.GetSpell3Level() >=1) || (SpectralPlayer.GetSpell1Level() >=1 
			&& SpectralPlayer.GetMasterSpell() != 0)){
			this.drawTexturedModalRect(xPos/2 -9, TopScreen + 3, 16, 0, 16, TwoRechargeTime);
		} 
		if (SpectralPlayer.GetSpellTwoRechargeTime() != 0 && (SpectralPlayer.GetSpell3Level() >= 1)
				&& (SpectralPlayer.GetMasterSpell() != 0)){
			this.drawTexturedModalRect(xPos/2 -30, TopScreen + 3, 16, 0, 16, TwoRechargeTime);
		}
		
		if (SpectralPlayer.GetSpellThreeRechargeTime() != 0 && (SpectralPlayer.GetSpell2Level() >= 1)
				&& (SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpell1Level() >= 1)
				&& (SpectralPlayer.GetMasterSpell() != 0)) {
			this.drawTexturedModalRect(xPos/2 - 9, TopScreen + 3, 32, 0, 16, ThreeRechargeTime);
			
		} 
		if (SpectralPlayer.GetSpellThreeRechargeTime() != 0 && (SpectralPlayer.GetSpell1Level() >= 1)
				&& (SpectralPlayer.GetSpell2Level() >= 1)){
			this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 16, 0, 16, ThreeRechargeTime);
		}
		
		if (SpectralPlayer.GetSpellFourRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 + 12, TopScreen + 3, 48, 0, 16, FourRechargeTime);
		}
		
		break;
	
	case 4:  //if runs if they have 4 spells
		if (SpectralPlayer.GetSpellOneRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 41, TopScreen + 3, 0, 0, OneRechargeTime, 16);
		}
		if (SpectralPlayer.GetSpellTwoRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 - 20, TopScreen + 3, 16, 0, TwoRechargeTime, 16);
		}
		if (SpectralPlayer.GetSpellThreeRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 + 1, TopScreen + 3, 32, 0, ThreeRechargeTime, 16);
		}
		if (SpectralPlayer.GetSpellFourRechargeTime() != 0){
			this.drawTexturedModalRect(xPos/2 + 22, TopScreen + 3, 48, 0, FourRechargeTime, 16);
		}
		break;
	}

	if (SpectralPlayer.GetActiveClass() != 0 && SpectralPlayer.GetNumberOfSpells() != 0){ //if they have started the mod it draws the magic level
		if (SpectralPlayer.GetSpectralLevel() < 10){ //if its a single digit unmber for their level it draws it in this position
			this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetSpectralLevel()), xPos/2 - 2, TopScreen + 29, -10);
		} else { //if they have a double digit number as their level it moes it to the left slightly and draws it.
			this.drawString(this.mc.fontRendererObj , Integer.toString(SpectralPlayer.GetSpectralLevel()), xPos/2 - 5, TopScreen + 29, -10);
		}
	}
	}
}