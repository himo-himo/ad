package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowKillSet;

import net.minecraft.client.Minecraft;

public class ShowKill {
	public static int ShowKillOF;//ONかOFFか
	public static int Killbigsmall;//大きいほうか小さい方か
	public static int Killleftright;//左にずらすのか右にずらすのか
	public static int Killspesu;//どれだけ真ん中からずらすのか(int)
	public static String supesu;//supesuhairetuの空白が入る
	//↓すべてのパターンを配列に入れることで前はできなかった + - での空白調整を可能にした
	public static String[] supesuhairetu = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    ", "                     ", "                      ", "                       ", "                        ", "                         ", "                              ", "                                   ", "                                        ", "                                             ", "                                                  ", "                                                       ", "                                                            ", "                                                                 ", "                                                                      ", "                                                                           ", "                                                                                ", "                                                                                     ", "                                                                                          ", "                                                                                               ", "                                                                                               ", "                                                                                                    "};

	public static void playShowKill() {
		if (ShowKillOF == ShowKillSet.OFF) {
		} else if (ShowKillOF == ShowKillSet.ON) {
			switch(Killbigsmall) {//大きいほうか小さい方か
			case ShowKillSet.Killbig://大きかったら
				switch(Killleftright) {//右か左か
				case ShowKillSet.Killleft://左だったら
					playShowKillbigleft();
				break;
				case ShowKillSet.Killright://右だったら
					playShowKillbigright();
				break;
				}
			break;
			case ShowKillSet.Killsmall://小さかったら
				switch(Killleftright) {//左にずらすのか右にずらすのか
				case ShowKillSet.Killleft://左だったら
					playShowKillsmallleft();
				break;
				case ShowKillSet.Killright://右だったら
					playShowKillsmallright();
				break;
				}
			break;
		}

		}
	}

	public static void playShowKillGUI() {//同上 * GUIで起動される方
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
		supesu = supesuhairetu[Killspesu];//Stringのsupesuにsupesuhairetuの配列のAssistspesuの番号
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
