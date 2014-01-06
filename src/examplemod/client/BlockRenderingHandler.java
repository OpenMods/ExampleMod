package examplemod.client;

import examplemod.ExampleMod;
import openmods.renderer.BlockRenderingHandlerBase;

public class BlockRenderingHandler extends BlockRenderingHandlerBase {

	@Override
	public int getRenderId() {
		return ExampleMod.renderId;
	}

}
