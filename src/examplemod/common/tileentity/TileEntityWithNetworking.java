package examplemod.common.tileentity;

import java.util.Set;

import openmods.OpenMods;
import openmods.sync.ISyncableObject;
import openmods.sync.SyncableInt;
import openmods.tileentity.SyncedTileEntity;

/***
 * This tile entity shows how to do very basic networking using Syncable objects
 * 
 * @author mfranklin
 * 
 */
public class TileEntityWithNetworking extends SyncedTileEntity {

	private SyncableInt counter1;
	private SyncableInt counter2;

	/***
	 * First we have to create our synced fields.
	 */
	@Override
	protected void createSyncedFields() {
		counter1 = new SyncableInt();
		counter2 = new SyncableInt();
	}

	/**
	 * Whenever a tile is synced, onSynced is called with the syncable objects
	 * that were changed
	 */
	@Override
	public void onSynced(Set<ISyncableObject> changes) {
		if (worldObj.isRemote) {
			System.out.println(String.format("%s objects changed", changes.size()));
			System.out.println(String.format("%s, %s", counter1.getValue(), counter2.getValue()));
		}
	}

	/**
	 * On the server, every 50 ticks we're incrementing the counter1 by 1 and
	 * every 100 ticks we're incrementing counter1 by 1. Then syncing the values
	 * down to the client by calling sync().
	 * Note that you can call sync as much as you like, and only synced objects
	 * that have been modified will be sent down to the client.
	 * Syncing downs upstream as well as downstream.
	 */
	public void updateEntity() {
		if (!worldObj.isRemote) {
			long ticks = OpenMods.proxy.getTicks(worldObj);
			if (ticks % 50 == 0) {
				counter1.modify(1);
				if (ticks % 100 == 0) {
					counter2.modify(1);
				}
				sync();
			}
		}
	}

}
