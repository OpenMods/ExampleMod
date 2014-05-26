package examplemod.common.container;

import net.minecraft.inventory.IInventory;
import openmods.container.ContainerInventoryProvider;
import examplemod.common.tileentity.TileEntityWithGui;

public class ContainerExample extends ContainerInventoryProvider<TileEntityWithGui> {

	public ContainerExample(IInventory playerInventory, TileEntityWithGui tile) {
		super(playerInventory, tile);
		addSlotToContainer(new RestrictedSlot(tile.getInventory(), 0, 62, 30));
		addSlotToContainer(new RestrictedSlot(tile.getInventory(), 1, 100, 30));
		addPlayerInventorySlots(93);
	}

}
