package examplemod.common.tileentity;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import openmods.GenericInventory;
import openmods.IInventoryProvider;
import openmods.api.IHasGui;
import openmods.sync.ISyncableObject;
import openmods.sync.SyncableInt;
import openmods.tileentity.SyncedTileEntity;
import examplemod.client.gui.GuiExample;
import examplemod.common.container.ContainerExample;

public class TileEntityWithGui extends SyncedTileEntity implements IHasGui, IInventoryProvider {

	private SyncableInt sliderValue;

	public SyncableInt getSliderValueObject() {
		return sliderValue;
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
	protected void createSyncedFields() {
		sliderValue = new SyncableInt();
	}

	@Override
	public void onSynced(Set<ISyncableObject> changes) {}

	/*******************************************************
	 * Implemented from IInventoryProvider
	 *******************************************************/

	@Override
	public IInventory getInventory() {
		return new GenericInventory("example", true, 2);
	}
}
