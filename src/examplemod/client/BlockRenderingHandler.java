package examplemod.client;

import openmods.renderer.BlockRenderingHandlerBase;
import examplemod.ExampleMod;
import examplemod.ExampleMod.Blocks;
import examplemod.client.render.CustomBlockRendererExample;

public class BlockRenderingHandler extends BlockRenderingHandlerBase {

	public BlockRenderingHandler() {
		blockRenderers.put(Blocks.blockWithCustomBlockRenderer, new CustomBlockRendererExample());
	}

	@Override
	public int getRenderId() {
		return ExampleMod.renderId;
	}

}
