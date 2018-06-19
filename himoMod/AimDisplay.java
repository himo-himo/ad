package com.himo.himoMod;

import java.util.Timer;
import java.util.TimerTask;

import com.himo.himoMod.GUIS.AimDisplayGUI;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AimDisplay extends GuiScreen {

	public static int AimDisplayOF;
	public static int topcenter;
	public static float x;
	public static float y;
	public static double scale;

	public static int tesutei = 0;
	public static int hyouzitesutei = 0;
	public static String byougamozi = "";
	public static String karakodo1 = "";
	public static void taima1() throws ParseException {
		final Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
		int caunto = 0;
			@Override
			public void run() {
				caunto++;
				if (caunto == 2) {
					taima2();
					pluskaunnto();
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 0, 10);
	}
	public static void taima2() throws ParseException {
		final Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
		int caunto = 0;
			@Override
			public void run() {
				caunto++;
				if (caunto == 2) {
				taima1();
				pluskaunnto();
				//System.out.println("taima2");
				timer.cancel();
				}
			}
		};
		timer.schedule(task, 0, 10);
	}
	public static void pluskaunnto() {
		if (Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().objectMouseOver == null) return;
		 MovingObjectPosition mop = Minecraft.getMinecraft().objectMouseOver;
		 if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY) {
			 if (tesutei < 100) tesutei = tesutei + 1;
		 } else {
			 if (tesutei > 0) tesutei = tesutei - 1;
		 }
	}

	public static void kousinn1() throws ParseException {
		final Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
		int caunto = 0;
			@Override
			public void run() {
				caunto++;
				if (caunto == 2) {
					kousinn2();
					karakodokousinn();
					System.out.println("kousinn1");
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 0, 200);
	}
	public static void kousinn2() throws ParseException {
		final Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
		int caunto = 0;
			@Override
			public void run() {
				caunto++;
				if (caunto == 2) {
					kousinn1();
					karakodokousinn();
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 0, 200);
	}

	public static void karakodokousinn() {
		if (tesutei >= 40) karakodo1 = "§a";
		else if (tesutei >= 20) karakodo1 = "§e";
		else if (tesutei > 0) karakodo1 = "§c";
		else if (tesutei == 0) karakodo1 = "";
		hyouzitesutei = tesutei;
	}

	public static void drawRect1() {
		if (Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().objectMouseOver == null) return;
		if (AimDisplay.AimDisplayOF == 0) return;
		if (!AimDisplayGUI.aguiopen) byougamozi = tesutei + "";
		String textsaizu = "";
		if (AimDisplayGUI.aguiopen) textsaizu = byougamozi + "%";
		if (!AimDisplayGUI.aguiopen) textsaizu = hyouzitesutei + "%";

		if (topcenter == 1) AimDisplay.x = (float) (new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth()/2 /AimDisplay.scale);

		double x1 = x * AimDisplay.scale - Minecraft.getMinecraft().fontRendererObj.getStringWidth(textsaizu)/2 * AimDisplay.scale- 2;
		double x2 = x1 + Minecraft.getMinecraft().fontRendererObj.getStringWidth(textsaizu) * AimDisplay.scale + 4;
		double y1 = y * AimDisplay.scale;
		double y2 = y1 + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT * AimDisplay.scale;

		GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();

        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(0.0F, 0.0F, 0.0F, 0.38F);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos(x1, y2, 0.0D).endVertex();
        worldrenderer.pos(x2, y2, 0.0D).endVertex();
        worldrenderer.pos(x2, y1, 0.0D).endVertex();
        worldrenderer.pos(x1, y1, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.color(1, 1, 1, 1);

        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();

        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();

        if (AimDisplay.AimDisplayOF == 0) return;

		if (AimDisplayGUI.aguiopen) {
			GlStateManager.enableBlend();
			GlStateManager.scale(AimDisplay.scale, AimDisplay.scale, AimDisplay.scale);
			Minecraft.getMinecraft().fontRendererObj.drawString(AimDisplay.byougamozi + "%", AimDisplay.x - Minecraft.getMinecraft().fontRendererObj.getStringWidth(AimDisplay.byougamozi + "%") / 2, AimDisplay.y, 0xffffffff, true);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
		}

		if (!AimDisplayGUI.aguiopen) {
			GlStateManager.enableBlend();
			GlStateManager.scale(AimDisplay.scale, AimDisplay.scale, AimDisplay.scale);
			Minecraft.getMinecraft().fontRendererObj.drawString(karakodo1 + hyouzitesutei + "%", AimDisplay.x - Minecraft.getMinecraft().fontRendererObj.getStringWidth(hyouzitesutei + "%") / 2, AimDisplay.y, 0xffffffff, true);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
		}
    }
}
