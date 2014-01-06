package examplemod.client.gui;

import openmods.gui.BaseGuiContainer;
import examplemod.common.container.ContainerExample;
import examplemod.common.tileentity.TileEntityWithGui;

public class GuiExample extends BaseGuiContainer<ContainerExample> {

	public GuiExample(ContainerExample container) {
		super(container, 176, 175, "examplemod.gui.example");
		TileEntityWithGui tile = container.getOwner();
	}

}
