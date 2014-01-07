package examplemod.proxy;

import openmods.api.IProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import examplemod.ExampleMod;
import examplemod.client.BlockRenderingHandler;
import examplemod.client.render.TileEntityWithTESRRenderer;
import examplemod.common.tileentity.TileEntityWithTESR;

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
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWithTESR.class, new TileEntityWithTESRRenderer());
	}

}