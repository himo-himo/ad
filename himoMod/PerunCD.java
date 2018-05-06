package com.himo.himoMod;

import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class PerunCD {
	public static String text = "";
	public static String textGO = "";
	public static int x = 5;
	public static int y = 5;
	public static int scale = 5;

	public static void playPerunCD() {
		GlStateManager.enableBlend();
		GlStateManager.scale(PerunCD.scale, PerunCD.scale, PerunCD.scale);
		Minecraft.getMinecraft().fontRendererObj.drawString(PerunCD.text, PerunCD.x, PerunCD.y, 0xffffffff, true);
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
	}
		public static void playstartPerunCD() throws ParseException {
			final Timer timer = new Timer(false);
			TimerTask task = new TimerTask() {
			String karakodo = "";
				int cnt=7;

				@Override
				public void run() {
					cnt--;
					if (cnt == 6 || cnt == 5) {
						karakodo = "§f";
						Minecraft.getMinecraft().thePlayer.playSound("random.orb", 100F, 1F);
					} else if (cnt == 4 || cnt == 3) {
						karakodo = "§a";
						Minecraft.getMinecraft().thePlayer.playSound("random.orb", 100F, 1F);
					} else if (cnt == 2 || cnt == 1) {
						karakodo = "§c";
						Minecraft.getMinecraft().thePlayer.playSound("random.orb", 100F, 1F);
					}
					PerunCD.text = karakodo + cnt;
					System.out.println(cnt);
					//5回実行で停止
					if ( cnt <= 0 ) {
						PerunCD.text = "";
						timer.cancel();
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

