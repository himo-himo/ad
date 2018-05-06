package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowUseHeadSet;

import net.minecraft.client.Minecraft;

public class ShowUseHead {
	public static void playShowusehead(String arg) {//ただのHeadを使ったときの処理
		switch(himoMod.showUseHead) {
		case ShowUseHeadSet.OFF:
			break;
		case ShowUseHeadSet.ON:
			if (arg.equals("You")) {
				Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1F);
			} else {
				Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 1, 20, 5);
				Minecraft.getMinecraft().ingameGUI.displayTitle(null, arg + "§a Head", 0, 0, 0);
				Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 1, 20, 5);
			}
			break;
		}

	}

	public static void playShowuseGhead(String arg) {//Geadを使ったときの処理
		switch(himoMod.showUseHead) {
		case ShowUseHeadSet.OFF:
			break;
		case ShowUseHeadSet.ON:
			if (arg.equals("You")) {
				Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1F);
			} else {
				Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 1, 20, 5);
				Minecraft.getMinecraft().ingameGUI.displayTitle(null, arg + "§6 GHead", 0, 0, 0);
				Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 1, 20, 5);
			}
			break;
		}
	}
}
