package examplemod.common.container;

import net.minecraft.inventory.IInventory;
import openmods.container.ContainerInventory;
import examplemod.common.tileentity.TileEntityWithGui;

public class ContainerExample extends ContainerInventory<TileEntityWithGui> {

	public ContainerExample(IInventory playerInventory, TileEntityWithGui tile) {
		super(playerInventory, tile);
		addSlotToContainer(new RestrictedSlot(tile, 0, 62, 30));
		addSlotToContainer(new RestrictedSlot(tile, 1, 100, 30));
		addPlayerInventorySlots(93);
	}

}
