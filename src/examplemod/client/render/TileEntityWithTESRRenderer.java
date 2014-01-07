package examplemod.client.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import openmods.utils.BlockUtils;

import org.lwjgl.opengl.GL11;

import examplemod.common.tileentity.TileEntityWithTESR;

public class TileEntityWithTESRRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		GL11.glPushMatrix();
		GL11.glDisable(2896);
		Tessellator t = Tessellator.instance;

		TileEntityWithTESR tile = (TileEntityWithTESR)tileentity;

		ForgeDirection rotation = tile.getRotation();

		GL11.glRotatef(-BlockUtils.getRotationFromDirection(tile.getRotation()), 0, 1, 0);

		// custom drawing code here

		GL11.glEnable(2896);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
