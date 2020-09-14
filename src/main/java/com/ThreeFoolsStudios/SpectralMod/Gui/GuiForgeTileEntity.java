package com.ThreeFoolsStudios.SpectralMod.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.ThreeFoolsStudios.SpectralMod.Reference;
import com.ThreeFoolsStudios.SpectralMod.TileEntity.ShardForgeTileEntity;

public class GuiForgeTileEntity extends GuiContainer{

	private IInventory playerInv;
	private ShardForgeTileEntity te;
	
	public GuiForgeTileEntity(IInventory playerInv, ShardForgeTileEntity te) {
	    super(new ForgeTileEntityContainer(playerInv, te));

	    this.playerInv = playerInv;
	    this.te = te;

	    this.xSize = 176;
	    this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	    int k = (this.width - this.xSize) /2;
	    int l = (this.height - this.ySize)/ 2 ;
	    this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/Gui/ForgeScreen.png"));
	    this.drawTexturedModalRect( k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	    String s = this.te.getDisplayName().getUnformattedText();
	    this.fontRendererObj.drawString(s, this.fontRendererObj.getStringWidth(s) / 5, 6, 4210752);           
	    this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      
	}
}
