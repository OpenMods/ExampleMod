package examplemod.common.block;

import examplemod.Config;
import examplemod.ExampleModBlock;
import net.minecraft.block.material.Material;

public class BlockWith6Rotations extends ExampleModBlock {

	public BlockWith6Rotations() {
		super(Config.block6RotationsId, Material.ground);

		setPlacementMode(BlockPlacementMode.ENTITY_ANGLE);
		setRotationMode(BlockRotationMode.SIX_DIRECTIONS);
	}

}