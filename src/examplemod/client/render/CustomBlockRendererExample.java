package examplemod.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import openmods.renderer.IBlockRenderer;
import openmods.utils.render.RenderUtils;

import org.lwjgl.opengl.GL11;

public class CustomBlockRendererExample implements IBlockRenderer {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		// override this with your own custom rendering
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		renderer.setRenderBoundsFromBlock(block);
		RenderUtils.renderInventoryBlock(renderer, block, ForgeDirection.EAST);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		// override this with your own custom rendering
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		return true;
	}

}
