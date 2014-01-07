package examplemod.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import openmods.api.IActivateAwareTile;
import openmods.api.IBreakAwareTile;
import openmods.api.INeighbourAwareTile;
import openmods.api.IPlaceAwareTile;
import openmods.tileentity.OpenTileEntity;

/**
 * Because this tile entity implements the various 'Aware' interfaces, block events
 * will be forwarded to this tile entity. This makes it easier to keep your logic
 * in a single place. This happens automatically.
 */
public class TileEntityWithEventForwarding extends OpenTileEntity implements INeighbourAwareTile, IBreakAwareTile, IPlaceAwareTile, IActivateAwareTile {

	@Override
	public void onNeighbourChanged(int blockId) {
		System.out.println("A neighbour has changed");
	}

	@Override
	public void onBlockBroken() {
		System.out.println("Block has been broken");
	}

	@Override
	public void onBlockPlacedBy(EntityPlayer player, ForgeDirection side, ItemStack stack, float hitX, float hitY, float hitZ) {
		System.out.println("Block has been placed");
	}

	@Override
	public boolean onBlockActivated(EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		System.out.println("Block has been activated");
		return true;
	}

}
