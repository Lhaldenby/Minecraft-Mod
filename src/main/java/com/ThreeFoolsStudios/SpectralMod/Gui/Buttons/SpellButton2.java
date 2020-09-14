package com.ThreeFoolsStudios.SpectralMod.Gui.Buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.SpectralPlayer.ExtendedSpectralPlayer;

public class SpellButton2 extends GuiButton{
	
	private static final ResourceLocation Buttonpath1 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralButtons/BurstSpell2.png");
	private static final ResourceLocation Buttonpath2 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralButtons/BurstSpell3.png");
	
	private static final ResourceLocation Buttonpath3 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralButtons/FrostSpell2.png");
	private static final ResourceLocation Buttonpath4 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralButtons/FrostSpell3.png");
	
	private static final ResourceLocation Buttonpath5 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralButtons/ShadowSpell2.png");
	private static final ResourceLocation Buttonpath6 = new ResourceLocation(Reference.MOD_ID+":textures/Gui/SpectralButtons/ShadowSpell3.png");
	
	public SpellButton2(int buttonId, int x, int y, int widthIn, int heightIn,
			String buttonText) {
		
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.xPosition = x;
        this.yPosition = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonText;

	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
		ExtendedSpectralPlayer SpectralPlayer = ExtendedSpectralPlayer.get(mc.thePlayer);
		
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRendererObj;	
            if ((SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpectralLevel() == 2) || (SpectralPlayer.GetNumberOfSpells() == 2 
				&& SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpectralLevel() == 3) || (SpectralPlayer.GetNumberOfSpells() == 2 
				&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 1 
				&& SpectralPlayer.GetSpectralLevel() == 3) || (SpectralPlayer.GetSpectralLevel() == 4 
				&& SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 1) || (SpectralPlayer.GetSpectralLevel() == 4 
				&& SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1) || 
				(SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell3Level() == 2 
				&& SpectralPlayer.GetSpell2Level() == 1) || (SpectralPlayer.GetSpectralLevel() == 5 
				&& SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 1) || (SpectralPlayer.GetSpectralLevel() == 5 
				&& SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 2) || (SpectralPlayer.GetSpectralLevel() == 5 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1) ||
				(SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell3Level() == 3
				&& SpectralPlayer.GetSpell2Level() == 1) || (SpectralPlayer.GetSpectralLevel() == 6 
				&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpectralLevel() == 6 
				&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpectralLevel() == 6 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 1) || (SpectralPlayer.GetSpectralLevel() == 6 
				&& SpectralPlayer.GetSpell1Level() == 1 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 3) || (SpectralPlayer.GetSpectralLevel() == 6 
				&& SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 2) || (SpectralPlayer.GetSpectralLevel() == 7 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 2) || (SpectralPlayer.GetSpectralLevel() == 7 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetMasterSpell() != 0) ||
				(SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 1
				&& SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3
				&& SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpectralLevel() == 8 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 3) || (SpectralPlayer.GetSpectralLevel() == 8 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetMasterSpell() != 0) ||
				(SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 2 &&
				SpectralPlayer.GetSpell2Level() == 1 && SpectralPlayer.GetSpell3Level() == 3 &&
				SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpectralLevel() == 9 
				&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 1 
				&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetMasterSpell() != 0)){
            	
            	switch (SpectralPlayer.GetActiveClass()){
            	
            	case 1:
            		mc.getTextureManager().bindTexture(Buttonpath1);
            		break;
            		
            	case 2:
            		mc.getTextureManager().bindTexture(Buttonpath3);
            		break;
            		
            	case 3:
            		mc.getTextureManager().bindTexture(Buttonpath5);
            		break;
            		
            	}
            	
            } else if ((SpectralPlayer.GetNumberOfSpells() == 1 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpectralLevel() == 3) || (SpectralPlayer.GetSpectralLevel() == 4 
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1) ||
					(SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1) ||
					(SpectralPlayer.GetSpectralLevel() == 5 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 2) || (SpectralPlayer.GetSpectralLevel() == 5 
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2) ||
					(SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2) || (SpectralPlayer.GetSpectralLevel() == 6 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetSpell2Level() == 2) ||
					(SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1) ||
					(SpectralPlayer.GetSpectralLevel() == 6 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2) ||
					(SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 2
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 2) ||
					(SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetMasterSpell() != 0) ||
					(SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell3Level() == 3
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetMasterSpell() != 0) ||
					(SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 3 
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 1) ||
					(SpectralPlayer.GetSpectralLevel() == 7 && SpectralPlayer.GetSpell1Level() == 1
					&& SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3) ||
					(SpectralPlayer.GetSpectralLevel() == 4 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell1Level() == 1) || (SpectralPlayer.GetSpectralLevel() == 8 
					&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 2) || (SpectralPlayer.GetSpectralLevel() == 8 
					&& SpectralPlayer.GetSpell1Level() == 2 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 3) || (SpectralPlayer.GetSpectralLevel() == 8 
					&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 1 && SpectralPlayer.GetMasterSpell() != 0) ||
					(SpectralPlayer.GetSpectralLevel() == 8 && SpectralPlayer.GetSpell1Level() == 1 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpectralLevel() == 9 
					&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 3) || (SpectralPlayer.GetSpectralLevel() == 9 
					&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 2 && SpectralPlayer.GetMasterSpell() != 0) ||
					(SpectralPlayer.GetSpectralLevel() == 9 && SpectralPlayer.GetSpell1Level() == 2 &&
					SpectralPlayer.GetSpell2Level() == 2 && SpectralPlayer.GetSpell3Level() == 3 &&
					SpectralPlayer.GetMasterSpell() != 0) || (SpectralPlayer.GetSpectralLevel() == 10 
					&& SpectralPlayer.GetSpell1Level() == 3 && SpectralPlayer.GetSpell2Level() == 2 
					&& SpectralPlayer.GetSpell3Level() == 3 && SpectralPlayer.GetMasterSpell() != 0)) {
            	
            		switch (SpectralPlayer.GetActiveClass()){
            	
            		case 1:
            			mc.getTextureManager().bindTexture(Buttonpath2);
            			break;
        			
            		case 2:
            			mc.getTextureManager().bindTexture(Buttonpath4);
            			break;
        			
            		case 3:
            			mc.getTextureManager().bindTexture(Buttonpath6);
            			break;
        			
            		}
            	
            }
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int k = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            int l = 14737632;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.hovered)
            {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }
	
}
