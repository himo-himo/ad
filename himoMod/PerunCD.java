package com.himo.himoMod;

import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class PerunCD {
	public static int PerunCDOF;
	public static String text = "";
	public static String textGO = "";
	public static float x;
	public static float y;
	public static double scale;
	public static boolean perun1 = true;
	public static boolean perun2 = true;

	public static void playPerunCD() {
		GlStateManager.enableBlend();
		GlStateManager.scale(PerunCD.scale, PerunCD.scale, PerunCD.scale);
		Minecraft.getMinecraft().fontRendererObj.drawString(PerunCD.text, PerunCD.x, PerunCD.y, 0xffffffff, true);
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
	}
		public static void playstartPerunCD() throws ParseException {
			if (!perun1) return;
			if (PerunCDOF != 1) return;
			perun1= false;
			final Timer timer = new Timer(false);
			TimerTask task = new TimerTask() {
			String karakodo = "";
				int cnt=7;

				@Override
				public void run() {
					cnt--;
					if (cnt == 6 || cnt == 5) {
						karakodo = "§f";
						Minecraft.getMinecraft().thePlayer.playSound("random.orb", 100, 1);
					} else if (cnt == 4 || cnt == 3) {
						karakodo = "§a";
						Minecraft.getMinecraft().thePlayer.playSound("random.orb", 100, 1);
					} else if (cnt == 2 || cnt == 1) {
						karakodo = "§c";
						Minecraft.getMinecraft().thePlayer.playSound("random.orb", 100, 1);
					}
					PerunCD.text = karakodo + cnt;
					System.out.println(cnt);
					//5回実行で停止
					if ( cnt <= 0 ) {
						PerunCD.text = "";
						timer.cancel();
						perun1= true;
					}
				}
			};
			timer.schedule(task, 0, 1000);
		}

		public static void playPerunCDGO() {
			GlStateManager.enableBlend();
			GlStateManager.scale(PerunCD.scale, PerunCD.scale, PerunCD.scale);
			Minecraft.getMinecraft().fontRendererObj.drawString(PerunCD.textGO, PerunCD.x, PerunCD.y, 0xffffffff, true);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
		}

		public static void playstartPerunCDGO() throws ParseException {
			if (!perun2) return;
			if (PerunCDOF != 1) return;
			perun2 = false;
			final Timer timer = new Timer(false);
			TimerTask task = new TimerTask() {
			String karakodo = "";
				int cnt=8;

				@Override
				public void run() {
					cnt--;
					if (cnt == 1) {
						karakodo = "§e";
						PerunCD.textGO = karakodo + "GO";
						Minecraft.getMinecraft().thePlayer.playSound("item.fireCharge.use", 100F, 1F);
						perun2 = true;
					}
					//5回実行で停止
					if ( cnt <= 0 ) {
						PerunCD.textGO = "";
						timer.cancel();
					}
				}
			};
			timer.schedule(task, 0, 1000);
		}
	}

