package examplemod.common.tileentity;

import java.util.Set;

import openmods.sync.ISyncableObject;
import openmods.tileentity.SyncedTileEntity;

public class TileEntityWith24Rotations extends SyncedTileEntity {

	@Override
	public void onSynced(Set<ISyncableObject> changes) {}

	@Override
	protected void createSyncedFields() {}

}
