package examplemod.common.container;

import net.minecraft.inventory.IInventory;
import openmods.container.ContainerInventory;
import examplemod.common.tileentity.TileEntityWithGui;

public class ContainerExample extends ContainerInventory<TileEntityWithGui> {

	public ContainerExample(IInventory playerInventory, TileEntityWithGui tile) {
		super(playerInventory, tile);
		addSlotToContainer(new RestrictedSlot(tile, 0, 14, 40));
		addSlotToContainer(new RestrictedSlot(tile, 1, 56, 40));
		addPlayerInventorySlots(93);
	}

}
