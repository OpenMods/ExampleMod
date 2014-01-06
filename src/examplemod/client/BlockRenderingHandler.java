package examplemod.client;

import openmods.renderer.BlockRenderingHandlerBase;
import examplemod.ExampleMod;

public class BlockRenderingHandler extends BlockRenderingHandlerBase {

	@Override
	public int getRenderId() {
		return ExampleMod.renderId;
	}

}
