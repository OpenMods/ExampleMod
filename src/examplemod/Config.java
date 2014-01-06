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
import examplemod.common.block.BlockWithGui;

public class Config {

	@BlockId(description = "The id of the block with 4 rotations")
	public static int block4RotationsId = 1920;

	@BlockId(description = "The id of the block with 6 rotations")
	public static int block6RotationsId = 1921;

	@BlockId(description = "The id of the block with 24 rotations")
	public static int block24RotationsId = 1922;

	@BlockId(description = "The id of the block with a gui")
	public static int blockWithGuiId = 1923;

	public static void readConfig(Configuration configFile) {
		ConfigProcessing.processAnnotations(configFile, Config.class);
	}

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

		ConfigProcessing.registerItems(ExampleMod.Items.class, ModInfo.ID);
		ConfigProcessing.registerBlocks(ExampleMod.Blocks.class, ModInfo.ID);

	}
}