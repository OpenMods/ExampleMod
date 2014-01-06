package examplemod.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import examplemod.Config;
import examplemod.ExampleModBlock;

public class BlockWith24Rotations extends ExampleModBlock {

	public static class Icons {
		public static Icon top;
		public static Icon bottom;
		public static Icon front;
		public static Icon back;
		public static Icon left;
		public static Icon right;
	}

	public BlockWith24Rotations() {
		super(Config.block24RotationsId, Material.ground);

		setPlacementMode(BlockPlacementMode.SURFACE);
		setRotationMode(BlockRotationMode.TWENTYFOUR_DIRECTIONS);
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