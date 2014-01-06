package examplemod.common.block;

import examplemod.Config;
import examplemod.ExampleModBlock;
import net.minecraft.block.material.Material;

public class BlockWith4Rotations extends ExampleModBlock {

	public BlockWith4Rotations() {
		super(Config.block4RotationsId, Material.ground);

		setPlacementMode(BlockPlacementMode.ENTITY_ANGLE);
		setRotationMode(BlockRotationMode.FOUR_DIRECTIONS);
	}

}