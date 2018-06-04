package com.himo.himoMod;

import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition;

public class AimDisplay {
	static int tesutei = 0;
	static int hyouzitesutei = 0;
	static String karakodo1 = "";
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
					System.out.println("taima1");
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
				System.out.println("taima2");
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
		hyouzitesutei = tesutei;
		if (tesutei >= 40) karakodo1 = "§a";
		else if (tesutei >= 20) karakodo1 = "§e";
		else if (tesutei > 0) karakodo1 = "§c";
		else if (tesutei == 0) karakodo1 = "";
	}

	public static void playkaunnto() {
		Minecraft.getMinecraft().fontRendererObj.drawString(karakodo1 + hyouzitesutei, 200, 5, 0xffffffff, true);
	}
}
