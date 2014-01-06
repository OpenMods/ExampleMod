package examplemod.common.tileentity;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import openmods.GenericInventory;
import openmods.api.IHasGui;
import openmods.sync.ISyncableObject;
import openmods.tileentity.SyncedTileEntity;
import examplemod.client.gui.GuiExample;
import examplemod.common.container.ContainerExample;

public class TileEntityWithGui extends SyncedTileEntity implements IHasGui, IInventory {

	public TileEntityWithGui() {
		setInventory(new GenericInventory("example", true, 2));
	}

	/*******************************************************
	 * Implemented from IHasGui
	 *******************************************************/

	@Override
	public Object getServerGui(EntityPlayer player) {
		return new ContainerExample(player.inventory, this);
	}

	@Override
	public Object getClientGui(EntityPlayer player) {
		return new GuiExample(new ContainerExample(player.inventory, this));
	}

	@Override
	public boolean canOpenGui(EntityPlayer player) {
		return true;
	}

	/*******************************************************
	 * Implemented from SyncedTileEntity
	 *******************************************************/

	@Override
	public void onSynced(Set<ISyncableObject> changes) {}

	@Override
	protected void createSyncedFields() {}

	/*******************************************************
	 * Implemented from IInventory
	 *******************************************************/

	@Override
	public int getSizeInventory() {
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory.getStackInSlot(i);
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return inventory.decrStackSize(i, j);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory.getStackInSlotOnClosing(i);
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory.setInventorySlotContents(i, itemstack);
	}

	@Override
	public String getInvName() {
		return inventory.getInvName();
	}

	@Override
	public boolean isInvNameLocalized() {
		return inventory.isInvNameLocalized();
	}

	@Override
	public int getInventoryStackLimit() {
		return inventory.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return inventory.isUseableByPlayer(entityplayer);
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return inventory.isItemValidForSlot(i, itemstack);
	}
}
