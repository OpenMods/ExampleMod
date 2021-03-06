package examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import openmods.OpenMods;
import openmods.api.IProxy;
import openmods.config.RegisterBlock;

import org.apache.commons.lang3.ObjectUtils;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import examplemod.common.block.BlockWith24Rotations;
import examplemod.common.block.BlockWith4Rotations;
import examplemod.common.block.BlockWith6Rotations;
import examplemod.common.block.BlockWithCustomBlockRenderer;
import examplemod.common.block.BlockWithEventForwarding;
import examplemod.common.block.BlockWithGui;
import examplemod.common.block.BlockWithNetworking;
import examplemod.common.block.BlockWithTESRenderer;
import examplemod.common.tileentity.TileEntityWith24Rotations;
import examplemod.common.tileentity.TileEntityWithEventForwarding;
import examplemod.common.tileentity.TileEntityWithGui;
import examplemod.common.tileentity.TileEntityWithNetworking;
import examplemod.common.tileentity.TileEntityWithTESR;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = ModInfo.DEPENDENCIES)
@NetworkMod(serverSideRequired = true, clientSideRequired = true, channels = { ModInfo.ID })
public class ExampleMod {

	@Instance(value = "ExampleMod")
	public static ExampleMod instance;

	@SidedProxy(clientSide = ModInfo.PROXY_CLIENT, serverSide = ModInfo.PROXY_SERVER)
	public static IProxy proxy;

	public static int renderId;

	/**
	 * This inner class holds static references to all of our blocks.
	 * Each block has to be annotated with @RegisterBlock, and if the block uses
	 * a TileEntity
	 * it should be defined here. You can also register any custom ItemBlocks
	 * here for your
	 * block
	 */
	public static class Blocks {

		@RegisterBlock(name = "block4rotations")
		public static BlockWith4Rotations block4Rotations;

		@RegisterBlock(name = "block6rotations")
		public static BlockWith6Rotations block6Rotations;

		@RegisterBlock(name = "block24rotations", tileEntity = TileEntityWith24Rotations.class)
		public static BlockWith24Rotations block24Rotations;

		@RegisterBlock(name = "blockgui", tileEntity = TileEntityWithGui.class)
		public static BlockWithGui blockWithGui;

		@RegisterBlock(name = "blockcustomrenderer")
		public static BlockWithCustomBlockRenderer blockWithCustomBlockRenderer;

		@RegisterBlock(name = "blockwithnetworking", tileEntity = TileEntityWithNetworking.class)
		public static BlockWithNetworking blockWithNetworking;

		@RegisterBlock(name = "blockwitheventforwarding", tileEntity = TileEntityWithEventForwarding.class)
		public static BlockWithEventForwarding blockWithEventForwarding;
		
		@RegisterBlock(name = "blockwithtesr", tileEntity = TileEntityWithTESR.class)
		public static BlockWithTESRenderer blockWithTESR;

	}

	/**
	 * This inner class holds static references to all of our items.
	 * Each item has to be annotated with @RegisterItem
	 */
	public static class Items {

	}

	/**
	 * Initialise a creative tab for our mod
	 */
	public static CreativeTabs tabExampleMod = new CreativeTabs("tabExampleMod") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(ObjectUtils.firstNonNull(Item.appleGold, Item.fishRaw), 1, 0);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		Configuration configFile = new Configuration(evt.getSuggestedConfigurationFile());
		Config.readConfig(configFile);
		if (configFile.hasChanged()) {
			configFile.save();
		}
		Config.register();

		NetworkRegistry.instance().registerGuiHandler(instance, OpenMods.proxy.wrapHandler(null));

		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		proxy.init();
		proxy.registerRenderInformation();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}
}