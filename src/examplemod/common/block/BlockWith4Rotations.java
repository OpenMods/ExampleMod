package examplemod.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.ForgeDirection;
import examplemod.Config;
import examplemod.ExampleModBlock;
import examplemod.common.block.BlockWith24Rotations.Icons;

public class BlockWith4Rotations extends ExampleModBlock {

	public BlockWith4Rotations() {
		super(Config.block4RotationsId, Material.ground);

		setPlacementMode(BlockPlacementMode.ENTITY_ANGLE);
		setRotationMode(BlockRotationMode.FOUR_DIRECTIONS);
	}

	@Override
	public void registerIcons(IconRegister registry) {
		Icons.top = registry.registerIcon("examplemod:top");
		Icons.bottom = registry.registerIcon("examplemod:bottom");
		Icons.front = registry.registerIcon("examplemod:front");
		Icons.back = registry.registerIcon("examplemod:back");
		Icons.left = registry.registerIcon("examplemod:left");
		Icons.right = registry.registerIcon("examplemod:right");

		setTexture(ForgeDirection.EAST, Icons.left);
		setTexture(ForgeDirection.WEST, Icons.right);
		setTexture(ForgeDirection.SOUTH, Icons.front);
		setTexture(ForgeDirection.NORTH, Icons.back);
		setTexture(ForgeDirection.UP, Icons.top);
		setTexture(ForgeDirection.DOWN, Icons.bottom);
		setDefaultTexture(Icons.front);
	}

}