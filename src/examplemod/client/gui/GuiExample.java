package examplemod.client.gui;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import openmods.gui.BaseGuiContainer;
import openmods.gui.component.GuiComponentLabel;
import openmods.gui.component.GuiComponentSlider;
import openmods.gui.component.GuiComponentTab;
import openmods.gui.component.GuiComponentTabs;
import examplemod.common.container.ContainerExample;
import examplemod.common.tileentity.TileEntityWithGui;

public class GuiExample extends BaseGuiContainer<ContainerExample> {

	private GuiComponentTabs tabs;

	private GuiComponentTab tabOne;
	private GuiComponentTab tabTwo;

	private GuiComponentSlider slider;

	private GuiComponentLabel label;

	public GuiExample(ContainerExample container) {
		super(container, 176, 175, "examplemod.gui.example");
		TileEntityWithGui tile = container.getOwner();

		tabOne = new GuiComponentTab(0xFF0000, new ItemStack(Block.anvil), 100, 100);
		tabTwo = new GuiComponentTab(0x00FF00, new ItemStack(Block.anvil), 100, 100);

		tabs = new GuiComponentTabs(xSize - 3, 4);

		slider = new GuiComponentSlider(40, 55, 100, 0, 100, tile.getSliderValueObject());

		label = new GuiComponentLabel(5, 30, 100, 100, "Hello there!");

		tabOne.addComponent(label);
		tabs.addComponent(tabOne);
		tabs.addComponent(tabTwo);
		root.addComponent(tabs);
		root.addComponent(slider);
	}

}
