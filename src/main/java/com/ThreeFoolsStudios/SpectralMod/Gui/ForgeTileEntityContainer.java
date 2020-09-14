package com.ThreeFoolsStudios.SpectralMod.Gui;

import com.ThreeFoolsStudios.SpectralMod.TileEntity.ShardForgeTileEntity;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ForgeTileEntityContainer extends Container{

	private ShardForgeTileEntity te;
	
	public ForgeTileEntityContainer(IInventory playerInv, ShardForgeTileEntity te) {
	    this.te = te;

	    // Tile Entity, Slot 0-3, Slot IDs 0-3
	            this.addSlotToContainer(new Slot(te, 0, 81, 8));
	            this.addSlotToContainer(new Slot(te, 1, 56, 52));
	            this.addSlotToContainer(new Slot(te, 2, 105, 52));
	            this.addSlotToContainer(new Slot(te, 3, 81, 33));

	    // Player Inventory, Slot 4-30, Slot IDs 4-30
	    for (int y = 0; y < 3; ++y) {
	        for (int x = 0; x < 9; ++x) {
	            this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 0-3, Slot IDs 31-40
	    for (int x = 0; x < 9; ++x) {
	        this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
	    }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
        return this.te.isUseableByPlayer(playerIn);
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < 4) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 4, 41, true))
	                return null;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, 4, false))
	                return null;
	        }

	        if (current.stackSize == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.stackSize == previous.stackSize)
	            return null;
	        slot.onPickupFromSlot(playerIn, current);
	    }
	    return previous;
	}
	
}

