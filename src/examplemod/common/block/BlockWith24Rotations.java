package examplemod.common.block;

import examplemod.Config;
import examplemod.ExampleModBlock;
import net.minecraft.block.material.Material;

public class BlockWith24Rotations extends ExampleModBlock {

	public BlockWith24Rotations() {
		super(Config.block6RotationsId, Material.ground);

		setPlacementMode(BlockPlacementMode.SURFACE);
		setRotationMode(BlockRotationMode.TWENTYFOUR_DIRECTIONS);
	}

}