package com.ThreeFoolsStudios.SpectralMod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.ThreeFoolsStudios.SpectralMod.Reference;

public class GuiBook extends GuiScreen {
	
	    private final int bookImageHeight = 192;
	    private final int bookImageWidth = 192;
	    private int currPage = 0;
	    private static final int bookTotalPages = 18;
	    private static ResourceLocation[] bookPageTextures = 
	          new ResourceLocation[bookTotalPages];
	    private static String[] stringPageText = new String[bookTotalPages];
	    private GuiButton buttonDone;
	    private NextPageButton buttonNextPage;
	    private NextPageButton buttonPreviousPage;
	    
	    public GuiBook()
	    {
	        bookPageTextures[0] = new ResourceLocation(
	              Reference.MOD_ID+":textures/Gui/Book_First_Page.png");
	        bookPageTextures[1] = new ResourceLocation(
	        	  Reference.MOD_ID+":textures/Gui/Book_Inside_Ores.png");
	        bookPageTextures[2] = new ResourceLocation(
	    	      Reference.MOD_ID+":textures/Gui/Book_Inside_Shard_Refiner_Page.png");
	        bookPageTextures[3] = new ResourceLocation(
	              Reference.MOD_ID+":textures/Gui/Book_Inside_Page_Gem.png");
	        bookPageTextures[4] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Inside_Page_Spell_Parchment.png");
	        bookPageTextures[5] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Inside_Page_Spectral_Stone.png");
	        bookPageTextures[6] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Inside_Page_Gem_block.png");
	        bookPageTextures[7] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Inside_Altar_Page.png");
	        bookPageTextures[8] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Side_View_Base.png");
	        bookPageTextures[9] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Top_View_Base.png");
	        bookPageTextures[10] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Inside_Page_Armour.png");
		    bookPageTextures[11] = new ResourceLocation(
				      Reference.MOD_ID+":textures/Gui/Book_Inside_Class_Ritual_Page.png");
	        bookPageTextures[12] = new ResourceLocation(
		              Reference.MOD_ID+":textures/Gui/Book_Inside_Page_Base.png");
	        stringPageText[0] = "";
	        stringPageText[1] = "Ores                                                                                   Arcane Ore, Elemental Stone and Necromantic Crystal are the starting blocks of the mod and need to be mined and refined to make shards. These blocks can be found under the ground and will illuminate the area around them.";
	        stringPageText[2] = "Shards               Once the Ores, Stones and Crystals have been mined, you can get hold of shards from these rocks using primative methods such as smelting.";
	        stringPageText[3] = "                                                                                                             Spectral Forge       To create the Spectral Forge you require 1 Shard from any of the magic classes and 8 stone.";
	        stringPageText[4] = "                                                                                                                                                                                    Gems                     Using 3 of the same classes shards in a Spectral Forge will create a spectral gem for that class to use to create items to increase that classes           power.";
	        stringPageText[5] = "Classes                Elemental power grants you power over the elements and lets you bend them to your will. Arcane power grants a vary of powers that lets you bend and control the world around you. Necromantic power grants power over darkness and death itself.";
	        stringPageText[6] = "                                                                                                                                                                                                             Spell Parchment          This can be used to put the knowledge you know about new spells, to pratice in the world around you.";
	        stringPageText[7] = "                                                                                                                 Spectral Altar           This Altar is infused with spectral magic energy and is the first block required to make the full altar multiblock structure.";
	        stringPageText[8] = "                                                                                                                 Spectral Stone           This stone contains the magic from the Gem Block and there are 16 of these required to make the full altar multiblock structure.";
	        stringPageText[9] = "Gem                      Block                                                                                   Gem Blocks can be made using any 9 of the same type of gem in a crafting table. A gem block contains alot more power than just gems, so this can be used to craft more powerful items.";
	        stringPageText[10] = "Spectral Structure    This spectral structure is required to be built so that you can choose your magic class and get access to your first spell. Once you have your first spell come back to this structure to choose new spells when you level up.";
	        stringPageText[11] = "                                                                                                                                                                                                                                                                              The structures spectral stone ring is one block below the altar, but the pillars are the same level.";
	        stringPageText[12] = "                                                                                                                                                                                                                                                                                                           The structure has the Altar in the middle surronded by a ring of Spectral Stone.";
	        stringPageText[13] = "Staffs                   Staffs can be crafted using wooden sticks and then each type of gem can be added for each class. Once the staff is class specific then the other classes can not hold it and its power and ability is determined by the class that has control over the staff.";
	        stringPageText[14] = "                                                                                                                                                      Armour                Class armour is crafted using the Spectral Forge, in the forge you require a peice of leather armour and class gems to make the class armour.";
	        stringPageText[15]= "Class Ritual           The class ritual is required if you wish to change your magic class, you must have completed the class spell tree to do the ritual. The ritual will let you choose a new class and let you keep three magic levels. To do the ritual you must build the structure on the next page.";
	        stringPageText[16]="                                                                                                                                                                                                                                                                                                           The ritual must be activated by right clicking with your spell parchment.";
	        stringPageText[17] = "                                                                                                                                                                                                                                                                                                                                                 Mod created          by Lewis Haldenby";
	    }

	    /**
	     * Adds the buttons (and other controls) to the screen in question.
	     */
	    @Override
	    public void initGui() 
	    {
	     // DEBUG
	        buttonList.clear();
	        Keyboard.enableRepeatEvents(true);

	        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight, 
	              98, 20, I18n.format("gui.done", new Object[0]));
	  
	        buttonList.add(buttonDone);
	        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
	        buttonList.add(buttonNextPage = new NextPageButton(1, 
	              offsetFromScreenLeft + 120, 156, true));
	        buttonList.add(buttonPreviousPage = new NextPageButton(2, 
	              offsetFromScreenLeft + 38, 156, false));
	    }

	    /**
	     * Called from the main game loop to update the screen.
	     */
	    @Override
	    public void updateScreen() 
	    {
	        buttonDone.visible = (currPage == bookTotalPages - 1);
	        buttonNextPage.visible = (currPage < bookTotalPages - 1);
	        buttonPreviousPage.visible = currPage > 0;
	    }
	 
	    /**
	     * Draws the screen and all the components in it.
	     */
	    @Override
	    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
	    {
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        if(currPage == 0){
	        	mc.getTextureManager().bindTexture(bookPageTextures[0]);
	        }
	        else if (currPage == 1)
	        {
	        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
	        }
	        else if (currPage == 3)
	        {
	            mc.getTextureManager().bindTexture(bookPageTextures[2]);
	        }
	        else if (currPage == 4)
	        {
	        	mc.getTextureManager().bindTexture(bookPageTextures[3]);
	        }
	        else if (currPage == 6)
	        {
	        	mc.getTextureManager().bindTexture(bookPageTextures[4]);
	        }
	        else if (currPage == 7){
	        	mc.getTextureManager().bindTexture(bookPageTextures[7]);
	        }
	        else if (currPage == 8){
	        	mc.getTextureManager().bindTexture(bookPageTextures[5]);
	        }
	        else if (currPage == 9){
	        	mc.getTextureManager().bindTexture(bookPageTextures[6]);
	        }
	        else if (currPage == 11){
	        	mc.getTextureManager().bindTexture(bookPageTextures[8]);
	        }
	        else if (currPage == 12){
	        	mc.getTextureManager().bindTexture(bookPageTextures[9]);
	        }
	        else if (currPage == 14){
	        	mc.getTextureManager().bindTexture(bookPageTextures[10]);
	        }
             else if (currPage == 16){
        	    mc.getTextureManager().bindTexture(bookPageTextures[11]);
            }
             else if (currPage == 17){
         	    mc.getTextureManager().bindTexture(bookPageTextures[0]);
             }
	        else
	        {
	        	mc.getTextureManager().bindTexture(bookPageTextures[12]);
	        }
	        
	        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
	        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, 
	              bookImageHeight);
	        int widthOfString;
	        String stringPageIndicator = I18n.format("book.pageIndicator", 
	              new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
	        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
	        
	        if ((currPage != 0) && (currPage != 11) && (currPage != 12)&& (currPage != 16)){
	        fontRendererObj.drawString(stringPageIndicator, 
	              offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 
	              18, 0);
	        }
	        
	        fontRendererObj.drawSplitString(stringPageText[currPage], 
	              offsetFromScreenLeft + 36, 34, 116, 0);
	        super.drawScreen(parWidth, parHeight, p_73863_3_);
	    }

	    /**
	     * Called when a mouse button is pressed and the mouse is moved around. 
	     * Parameters are : mouseX, mouseY, lastButtonClicked & 
	     * timeSinceMouseClick.
	     */
	    @Override
	    protected void mouseClickMove(int parMouseX, int parMouseY, 
	          int parLastButtonClicked, long parTimeSinceMouseClick) 
	    {
	     
	    }

	    @Override
	    protected void actionPerformed(GuiButton parButton) 
	    {
	     if (parButton == buttonDone)
	     {
	         // You can send a packet to server here if you need server to do 
	         // something
	         mc.displayGuiScreen((GuiScreen)null);
	     }
	        else if (parButton == buttonNextPage)
	        {
	            if (currPage < bookTotalPages - 1)
	            {
	                ++currPage;
	            }
	        }
	        else if (parButton == buttonPreviousPage)
	        {
	            if (currPage > 0)
	            {
	                --currPage;
	            }
	        }
	   }

	    /**
	     * Called when the screen is unloaded. Used to disable keyboard repeat 
	     * events
	     */
	    @Override
	    public void onGuiClosed() 
	    {
	     
	    }

	    /**
	     * Returns true if this GUI should pause the game when it is displayed in 
	     * single-player
	     */
	    @Override
	    public boolean doesGuiPauseGame()
	    {
	        return false;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    static class NextPageButton extends GuiButton
	    {
	        private final boolean isNextButton;

	        public NextPageButton(int parButtonId, int parPosX, int parPosY, 
	              boolean parIsNextButton)
	        {
	            super(parButtonId, parPosX, parPosY, 23, 13, "");
	            isNextButton = parIsNextButton;
	        }

	        /**
	         * Draws this button to the screen.
	         */
	        @Override
	        public void drawButton(Minecraft mc, int parX, int parY)
	        {
	            if (visible)
	            {
	                boolean isButtonPressed = (parX >= xPosition 
	                      && parY >= yPosition 
	                      && parX < xPosition + width 
	                      && parY < yPosition + height);
	                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	                mc.getTextureManager().bindTexture(bookPageTextures[1]);
	                int textureX = 0;
	                int textureY = 192;

	                if (isButtonPressed)
	                {
	                    textureX += 23;
	                }

	                if (!isNextButton)
	                {
	                    textureY += 13;
	                }

	                drawTexturedModalRect(xPosition, yPosition, 
	                      textureX, textureY, 
	                      23, 13);
	            }
	        }
	    }
	}
