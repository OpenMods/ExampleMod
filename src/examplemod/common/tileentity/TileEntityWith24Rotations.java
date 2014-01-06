package examplemod.common.tileentity;

import java.util.Set;

import openmods.sync.ISyncableObject;
import openmods.tileentity.SyncedTileEntity;

/**
 * This is a supporting tile entity for the block with 24 rotations.
 * A 24-rotation block requires a SyncedTileEntity as it transfers
 * some of the rotation data via the tile entities synced objects
 * 
 * @author Mikee
 * 
 */
public class TileEntityWith24Rotations extends SyncedTileEntity {

	@Override
	public void onSynced(Set<ISyncableObject> changes) {}

	@Override
	protected void createSyncedFields() {}

}
