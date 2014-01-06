package examplemod;

import net.minecraft.block.material.Material;
import openmods.block.OpenBlock;

public class ExampleModBlock extends OpenBlock {

	protected ExampleModBlock(int id, Material material) {
		super(id, material);
		setCreativeTab(ExampleMod.tabExampleMod);
	}

	@Override
	public boolean shouldRenderBlock() {
		return true;
	}

	@Override
	protected Object getModInstance() {
		return ExampleMod.instance;
	}

}