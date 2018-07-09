package com.himo.himoMod;

import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class PerunCD {
	public static int PerunCDOF;//PerunCDがONかOFFか
	public static String text = "";//関数によって5.4.3.2.1が入る
	public static String textGO = "";//関数によってGOが入る
	public static float x;//x座標
	public static float y;//y座標
	public static double scale;//文字の大きさ
	public static boolean perun1 = true;//関数起動中にその関数を呼ばれないようにする
	public static boolean perun2 = true;//関数起動中にその関数を呼ばれないようにする

	public static void playPerunCD() {//5.4.3.2.1の方
		GlStateManager.enableBlend();
		GlStateManager.scale(PerunCD.scale, PerunCD.scale, PerunCD.scale);
		Minecraft.getMinecraft().fontRendererObj.drawString(PerunCD.text, PerunCD.x, PerunCD.y, 0xffffffff, true);
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
	}
		public static void playstartPerunCD() throws ParseException {//カウントダウンする関数(5.4.3.2.1)
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

		public static void playPerunCDGO() {//GOの方
			GlStateManager.enableBlend();
			GlStateManager.scale(PerunCD.scale, PerunCD.scale, PerunCD.scale);
			Minecraft.getMinecraft().fontRendererObj.drawString(PerunCD.textGO, PerunCD.x, PerunCD.y, 0xffffffff, true);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
		}

		public static void playstartPerunCDGO() throws ParseException {//GOに変える関数
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
						if (Minecraft.getMinecraft().thePlayer != null || Minecraft.getMinecraft().theWorld != null || Minecraft.getMinecraft().objectMouseOver != null) {
						PerunCD.textGO = karakodo + "GO";
						Minecraft.getMinecraft().thePlayer.playSound("item.fireCharge.use", 100F, 1F);
						}
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

