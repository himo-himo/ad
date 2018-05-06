package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowHPSet;

import net.minecraft.client.Minecraft;

public class ShowHP {
	public static int HPbigsmall;
	public static int HPleftright;
	public static int HPspesu;
	public static String HPColour;
	public static String supesu;
	public static String[] supesuhairetu = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    ", "                     ", "                      ", "                       ", "                        ", "                         ", "                              ", "                                   ", "                                        ", "                                             ", "                                                  ", "                                                       ", "                                                            ", "                                                                 ", "                                                                      ", "                                                                           ", "                                                                                ", "                                                                                     ", "                                                                                          ", "                                                                                               ", "                                                                                               ", "                                                                                                    "};

	public static void playShowHP(float helth, String helths) {
		switch(HPbigsmall) {
			case ShowHPSet.HPbig:
				switch(HPleftright) {
				case ShowHPSet.HPleft:
					playShowHPbigleft(helth, helths);
				break;
				case ShowHPSet.HPright:
					playShowHPbigright(helth, helths);
				break;
				}
			break;
			case ShowHPSet.HPsmall:
				switch(HPleftright) {
				case ShowHPSet.HPleft:
					playShowHPsmallleft(helth, helths);
				break;
				case ShowHPSet.HPright:
					playShowHPsmallright(helth, helths);
				break;
				}
			break;
		}
	}

	public static void HPColourSet(float helth) {
		if (helth <= 15) {
			HPColour = "§r§c";
		} else if (helth <= 25){
			HPColour = "§r§e";
		} else {
			HPColour = "§r§a";
		}
		supesu = supesuhairetu[HPspesu];
	}

	public static void playShowHPbigleft(float helth, String helths) {
		HPColourSet(helth);
		Minecraft.getMinecraft().ingameGUI.displayTitle(HPColour + helths + supesu, null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowHPbigright(float helth, String helths) {
		HPColourSet(helth);
		Minecraft.getMinecraft().ingameGUI.displayTitle(supesu + HPColour + helths, null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowHPsmallleft(float helth, String helths) {
		HPColourSet(helth);
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, HPColour + helths + supesu, 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowHPsmallright(float helth, String helths) {
		HPColourSet(helth);
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null,supesu + HPColour + helths, 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}
}
