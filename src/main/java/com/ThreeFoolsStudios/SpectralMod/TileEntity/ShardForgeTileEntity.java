package com.ThreeFoolsStudios.SpectralMod.TileEntity;

import com.ThreeFoolsStudios.SpectralMod.Gui.ForgeTileEntityContainer;
import com.ThreeFoolsStudios.SpectralMod.init.SpectralItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ShardForgeTileEntity extends TileEntity implements IInventory
, IUpdatePlayerListBox {
	
	private int Ticks;
	private ItemStack[] inventory;
    private String customName;

    public ShardForgeTileEntity() {
        this.inventory = new ItemStack[this.getSizeInventory()];
    }

    public String getCustomName() {
        return this.customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.Spectral_Shard_Forge";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public IChatComponent getDisplayName() {
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
	    if (index < 0 || index >= this.getSizeInventory())
	        return null;
	    return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
	    if (this.getStackInSlot(index) != null) {
	        ItemStack itemstack;

	        if (this.getStackInSlot(index).stackSize <= count) {
	            itemstack = this.getStackInSlot(index);
	            this.setInventorySlotContents(index, null);
	            this.markDirty();
	            return itemstack;
	        } else {
	            itemstack = this.getStackInSlot(index).splitStack(count);

	            if (this.getStackInSlot(index).stackSize <= 0) {
	                this.setInventorySlotContents(index, null);
	            } else {
	                //Just to show that changes happened
	                this.setInventorySlotContents(index, this.getStackInSlot(index));
	            }

	            this.markDirty();
	            return itemstack;
	        }
	    } else {
	        return null;
	    }
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
	    ItemStack stack = this.getStackInSlot(index);
	    this.setInventorySlotContents(index, null);
	    return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
	    if (index < 0 || index >= this.getSizeInventory())
	        return;

	    if (stack != null && stack.stackSize > this.getInventoryStackLimit())
	        stack.stackSize = this.getInventoryStackLimit();
	        
	    if (stack != null && stack.stackSize == 0)
	        stack = null;

	    this.inventory[index] = stack;
	    this.markDirty();
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
	    return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		//leave blank
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		//leave blank
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.getSizeInventory(); i++)
	        this.setInventorySlotContents(i, null);
	}
  
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
	    super.writeToNBT(nbt);

	    NBTTagList list = new NBTTagList();
	    for (int i = 0; i < this.getSizeInventory(); ++i) {
	        if (this.getStackInSlot(i) != null) {
	            NBTTagCompound stackTag = new NBTTagCompound();
	            stackTag.setByte("Slot", (byte) i);
	            this.getStackInSlot(i).writeToNBT(stackTag);
	            list.appendTag(stackTag);
	        }
	    }
	    nbt.setTag("Items", list);

	    if (this.hasCustomName()) {
	        nbt.setString("CustomName", this.getCustomName());
	    }
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	    super.readFromNBT(nbt);

	    NBTTagList list = nbt.getTagList("Items", 10);
	    for (int i = 0; i < list.tagCount(); ++i) {
	        NBTTagCompound stackTag = list.getCompoundTagAt(i);
	        int slot = stackTag.getByte("Slot") & 255;
	        this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
	    }

	    if (nbt.hasKey("CustomName", 8)) {
	        this.setCustomName(nbt.getString("CustomName"));
	    }
	}
	
	@Override
	public void update(){
		if(!this.worldObj.isRemote ){
			this.Ticks++;
			if (this.getStackInSlot(0) != null &&
				this.getStackInSlot(1) != null &&
				this.getStackInSlot(2) != null &&
				(this.Ticks % 40) == 0){
				this.Ticks = 0;
				int stack0 = this.getStackInSlot(0).stackSize;
				int stack1 = this.getStackInSlot(1).stackSize;
				int stack2 = this.getStackInSlot(2).stackSize;
				int stack3;
				if (this.getStackInSlot(3) == null){
					stack3 = 1;
				}
				else {
					stack3 = this.getStackInSlot(3).stackSize + 1;
				}
				ItemStack TopArcaneShard = new ItemStack(SpectralItems.Arcane_Shard, stack0);
				ItemStack LeftArcaneShard = new ItemStack(SpectralItems.Arcane_Shard, stack1);
				ItemStack RightArcaneShard = new ItemStack(SpectralItems.Arcane_Shard, stack2);
				ItemStack TopElementalShard = new ItemStack(SpectralItems.Elemental_Shard, stack0);
				ItemStack LeftElementalShard = new ItemStack(SpectralItems.Elemental_Shard, stack1);
				ItemStack RightElementalShard = new ItemStack(SpectralItems.Elemental_Shard, stack2);
				ItemStack TopNecromanticShard = new ItemStack(SpectralItems.Necromantic_Shard, stack0);
				ItemStack LeftNecromanticShard = new ItemStack(SpectralItems.Necromantic_Shard, stack1);
				ItemStack RightNecromanticShard = new ItemStack(SpectralItems.Necromantic_Shard, stack2);
				ItemStack LeftArcaneGem = new ItemStack(SpectralItems.Arcane_Gem, stack1);
				ItemStack RightArcaneGem = new ItemStack(SpectralItems.Arcane_Gem, stack2);
				ItemStack ElementalGem = new ItemStack(SpectralItems.Elemental_Gem, 1);
				ItemStack NecromanticGem = new ItemStack(SpectralItems.Necromantic_Gem, 1);
				ItemStack Paper = new ItemStack(Items.paper, stack0);
				ItemStack Helmet = new ItemStack(Items.leather_helmet, stack0);
				ItemStack ChestPlate = new ItemStack(Items.leather_chestplate, stack0);
				ItemStack Leggings = new ItemStack(Items.leather_leggings, stack0);
				ItemStack Boots = new ItemStack(Items.leather_boots, stack0);

				if (this.getStackInSlot(0).getIsItemStackEqual(TopArcaneShard) == true &&
					this.getStackInSlot(1).getIsItemStackEqual(LeftArcaneShard) == true &&
					this.getStackInSlot(2).getIsItemStackEqual(RightArcaneShard) == true ){
						this.setInventorySlotContents(0, new ItemStack(SpectralItems.Arcane_Shard, stack0 - 1));
						this.setInventorySlotContents(1, new ItemStack(SpectralItems.Arcane_Shard, stack1 - 1));
						this.setInventorySlotContents(2, new ItemStack(SpectralItems.Arcane_Shard, stack2 - 1));
						this.setInventorySlotContents(3, new ItemStack(SpectralItems.Arcane_Gem, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(TopElementalShard) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftElementalShard) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightElementalShard) == true ){
						this.setInventorySlotContents(0, new ItemStack(SpectralItems.Elemental_Shard, stack0 - 1));
						this.setInventorySlotContents(1, new ItemStack(SpectralItems.Elemental_Shard, stack1 - 1));
						this.setInventorySlotContents(2, new ItemStack(SpectralItems.Elemental_Shard, stack2 - 1));
						this.setInventorySlotContents(3, new ItemStack(SpectralItems.Elemental_Gem, stack3));
				}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(TopNecromanticShard) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftNecromanticShard) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightNecromanticShard) == true ){
							this.setInventorySlotContents(0, new ItemStack(SpectralItems.Necromantic_Shard, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Necromantic_Shard, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Necromantic_Shard, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Necromantic_Gem, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Paper) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftArcaneGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightArcaneGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.paper, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Arcane_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Arcane_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Arcane_Parchment, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Paper) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.paper, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Elemental_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Elemental_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Elemental_Parchment, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Paper) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.paper, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Necromantic_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Necromantic_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Necromantic_Parchment, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Helmet) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftArcaneGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightArcaneGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_helmet, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Arcane_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Arcane_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Arcane_Helmet, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Helmet) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_helmet, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Elemental_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Elemental_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Elemental_Helmet, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Helmet) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_helmet, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Necromantic_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Necromantic_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Necromantic_Helmet, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(ChestPlate) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftArcaneGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightArcaneGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_chestplate, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Arcane_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Arcane_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Arcane_ChestPlate, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(ChestPlate) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_chestplate, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Elemental_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Elemental_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Elemental_ChestPlate, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(ChestPlate) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_chestplate, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Necromantic_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Necromantic_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Necromantic_ChestPlate, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Leggings) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftArcaneGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightArcaneGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_leggings, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Arcane_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Arcane_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Arcane_Leggings, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Leggings) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_leggings, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Elemental_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Elemental_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Elemental_Leggings, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Leggings) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_leggings, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Necromantic_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Necromantic_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Necromantic_Leggings, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Boots) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(LeftArcaneGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(RightArcaneGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_boots, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Arcane_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Arcane_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Arcane_Boots, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Boots) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(ElementalGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_boots, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Elemental_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Elemental_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Elemental_Boots, stack3));
					}
				
				else if (this.getStackInSlot(0).getIsItemStackEqual(Boots) == true &&
						this.getStackInSlot(1).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(2).getIsItemStackEqual(NecromanticGem) == true &&
						this.getStackInSlot(3) == null){
							this.setInventorySlotContents(0, new ItemStack(Items.leather_boots, stack0 - 1));
							this.setInventorySlotContents(1, new ItemStack(SpectralItems.Necromantic_Gem, stack1 - 1));
							this.setInventorySlotContents(2, new ItemStack(SpectralItems.Necromantic_Gem, stack2 - 1));
							this.setInventorySlotContents(3, new ItemStack(SpectralItems.Necromantic_Boots, stack3));
					} 
				
			}
		}
	}
	
}
