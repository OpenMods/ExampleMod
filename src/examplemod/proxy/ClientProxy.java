package examplemod.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import examplemod.ExampleMod;
import examplemod.client.BlockRenderingHandler;
import openmods.api.IProxy;

public class ClientProxy implements IProxy {

	@Override
	public void preInit() {}

	@Override
	public void init() {}

	@Override
	public void postInit() {}

	@Override
	public void registerRenderInformation() {
		ExampleMod.renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRenderingHandler());
	}

}