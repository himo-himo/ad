package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowAssistSet;

import net.minecraft.client.Minecraft;

public class ShowAssist {
	public static int ShowAssistOF;
	public static int Assistbigsmall;
	public static int Assistleftright;
	public static int Assistspesu;
	public static String supesu;
	public static String[] supesuhairetu = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    ", "                     ", "                      ", "                       ", "                        ", "                         ", "                              ", "                                   ", "                                        ", "                                             ", "                                                  ", "                                                       ", "                                                            ", "                                                                 ", "                                                                      ", "                                                                           ", "                                                                                ", "                                                                                     ", "                                                                                          ", "                                                                                               ", "                                                                                               ", "                                                                                                    "};

	public static void playShowAssist() {
		if (ShowAssistOF == ShowAssistSet.OFF) {
		} else if (ShowAssistOF == ShowAssistSet.ON) {
			switch(Assistbigsmall) {
			case ShowAssistSet.Assistbig:
				switch(Assistleftright) {
				case ShowAssistSet.Assistleft:
					playShowAssistbigleft();
				break;
				case ShowAssistSet.Assistright:
					playShowAssistbigright();
				break;
				}
			break;
			case ShowAssistSet.Assistsmall:
				switch(Assistleftright) {
				case ShowAssistSet.Assistleft:
					playShowAssistsmallleft();
				break;
				case ShowAssistSet.Assistright:
					playShowAssistsmallright();
				break;
				}
			break;
		}

		}
	}

	public static void playShowAssistGUI() {
			switch(Assistbigsmall) {
			case ShowAssistSet.Assistbig:
				switch(Assistleftright) {
				case ShowAssistSet.Assistleft:
					playShowAssistbigleft();
				break;
				case ShowAssistSet.Assistright:
					playShowAssistbigright();
				break;
				}
			break;
			case ShowAssistSet.Assistsmall:
				switch(Assistleftright) {
				case ShowAssistSet.Assistleft:
					playShowAssistsmallleft();
				break;
				case ShowAssistSet.Assistright:
					playShowAssistsmallright();
				break;
				}
			break;
		}
	}

	public static void supesutukuri() {
		supesu = supesuhairetu[Assistspesu];
	}


	public static void playShowAssistbigleft() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle("§7Assist" + supesu, null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowAssistbigright() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle(supesu + "§7Assist", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowAssistsmallleft() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "§7Assist" + supesu, 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowAssistsmallright() {
		supesutukuri();
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null,supesu + "§7Assist", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

}
