package examplemod.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.ForgeDirection;
import examplemod.Config;
import examplemod.ExampleModBlock;
import examplemod.common.block.BlockWith24Rotations.Icons;

public class BlockWithCustomBlockRenderer extends ExampleModBlock {

	public BlockWithCustomBlockRenderer() {
		super(Config.blockWithCustomBlockRendererId, Material.ground);
		setBlockBounds(0f, 0f, 0f, 1f, 0.4f, 1f);
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