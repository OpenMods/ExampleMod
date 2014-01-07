package examplemod;

import java.util.List;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.Configuration;
import openmods.config.BlockId;
import openmods.config.ConfigProcessing;
import examplemod.ExampleMod.Blocks;
import examplemod.common.block.BlockWith24Rotations;
import examplemod.common.block.BlockWith4Rotations;
import examplemod.common.block.BlockWith6Rotations;
import examplemod.common.block.BlockWithCustomBlockRenderer;
import examplemod.common.block.BlockWithEventForwarding;
import examplemod.common.block.BlockWithGui;
import examplemod.common.block.BlockWithNetworking;

/***
 * The Config class is responsible for defining anything that's specified in the
 * config files,
 * as well as initializing new instances of the blocks and items if the config
 * allows.
 * 
 * @author mfranklin
 * 
 */
public class Config {

	/**
	 * The default ID for the blocks, along with the description of the config
	 * values
	 */
	@BlockId(description = "The id of the block with 4 rotations")
	public static int block4RotationsId = 1920;

	@BlockId(description = "The id of the block with 6 rotations")
	public static int block6RotationsId = 1921;

	@BlockId(description = "The id of the block with 24 rotations")
	public static int block24RotationsId = 1922;

	@BlockId(description = "The id of the block with a gui")
	public static int blockWithGuiId = 1923;

	@BlockId(description = "The id of the block with a custom renderer")
	public static int blockWithCustomBlockRendererId = 1924;

	@BlockId(description = "The id of the block with networking")
	public static int blockWithNetworkingId = 1925;

	@BlockId(description = "The id of the block with event forwarding")
	public static int blockWithEventForwardingId = 1926;

	public static void readConfig(Configuration configFile) {
		ConfigProcessing.processAnnotations(configFile, Config.class);
	}

	/***
	 * This is where we register all of the new blocks, and add recipes to the
	 * recipes list.
	 * canRegisterBlock checks to see if the ID is higher than 0 and checks that
	 * the block ID
	 * isn't already taken by another block
	 */
	public static void register() {

		@SuppressWarnings("unchecked")
		final List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();

		if (ConfigProcessing.canRegisterBlock(block4RotationsId)) {
			Blocks.block4Rotations = new BlockWith4Rotations();
		}

		if (ConfigProcessing.canRegisterBlock(block6RotationsId)) {
			Blocks.block6Rotations = new BlockWith6Rotations();
		}

		if (ConfigProcessing.canRegisterBlock(block24RotationsId)) {
			Blocks.block24Rotations = new BlockWith24Rotations();
		}

		if (ConfigProcessing.canRegisterBlock(blockWithGuiId)) {
			Blocks.blockWithGui = new BlockWithGui();
		}

		if (ConfigProcessing.canRegisterBlock(blockWithCustomBlockRendererId)) {
			Blocks.blockWithCustomBlockRenderer = new BlockWithCustomBlockRenderer();
		}

		if (ConfigProcessing.canRegisterBlock(blockWithNetworkingId)) {
			Blocks.blockWithNetworking = new BlockWithNetworking();
		}

		if (ConfigProcessing.canRegisterBlock(blockWithEventForwardingId)) {
			Blocks.blockWithEventForwarding = new BlockWithEventForwarding();
		}

		/**
		 * Finally we have to register the blocks and items with forge/fml
		 * This will automatically register tile entities, too
		 */
		ConfigProcessing.registerItems(ExampleMod.Items.class, ModInfo.ID);
		ConfigProcessing.registerBlocks(ExampleMod.Blocks.class, ModInfo.ID);

	}
}