package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowKillSet;

import net.minecraft.client.Minecraft;

public class ShowKill {
	public static int ShowKillOF;
	public static int Killbigsmall;
	public static int Killleftright;
	public static int Killspesu;
	public static String supesu;
	public static String[] supesuhairetu = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    ", "                     ", "                      ", "                       ", "                        ", "                         ", "                              ", "                                   ", "                                        ", "                                             ", "                                                  ", "                                                       ", "                                                            ", "                                                                 ", "                                                                      ", "                                                                           ", "                                                                                ", "                                                                                     ", "                                                                                          ", "                                                                                               ", "                                                                                               ", "                                                                                                    "};

	public static void playShowKill() {
		if (ShowKillOF == ShowKillSet.OFF) {
		} else if (ShowKillOF == ShowKillSet.ON) {
			switch(Killbigsmall) {
			case ShowKillSet.Killbig:
				switch(Killleftright) {
				case ShowKillSet.Killleft:
					playShowKillbigleft();
				break;
				case ShowKillSet.Killright:
					playShowKillbigright();
				break;
				}
			break;
			case ShowKillSet.Killsmall:
				switch(Killleftright) {
				case ShowKillSet.Killleft:
					playShowKillsmallleft();
				break;
				case ShowKillSet.Killright:
					playShowKillsmallright();
				break;
				}
			break;
		}

		}
	}

	public static void playShowKillGUI() {
			switch(Killbigsmall) {
			case ShowKillSet.Killbig:
				switch(Killleftright) {
				case ShowKillSet.Killleft:
					playShowKillbigleft();
				break;
				case ShowKillSet.Killright:
					playShowKillbigright();
				break;
				}
			break;
			case ShowKillSet.Killsmall:
				switch(Killleftright) {
				case ShowKillSet.Killleft:
					playShowKillsmallleft();
				break;
				case ShowKillSet.Killright:
					playShowKillsmallright();
				break;
				}
			break;
		}
	}

	public static void supesutukuri() {
		supesu = supesuhairetu[Killspesu];
	}


	public static void playShowKillbigleft() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle("§aKill" + supesu, null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowKillbigright() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle(supesu + "§aKill", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowKillsmallleft() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "§aKill" + supesu, 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowKillsmallright() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null,supesu + "§aKill", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

}
