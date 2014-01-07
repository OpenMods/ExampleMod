package examplemod.common.block;

import openmods.block.OpenBlock.BlockPlacementMode;
import openmods.block.OpenBlock.BlockRotationMode;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.ForgeDirection;
import examplemod.Config;
import examplemod.ExampleModBlock;
import examplemod.common.block.BlockWith24Rotations.Icons;

public class BlockWithTESRenderer extends ExampleModBlock {

	public BlockWithTESRenderer() {
		super(Config.blockWithTESRId, Material.ground);

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
	
	/**
	 * If this is set to true, minecraft will use both the BlockRenderer
	 * and the TESR. Set it to false to only use the TESR
	 */
	@Override
	public boolean shouldRenderBlock() {
		return true;
	}
}