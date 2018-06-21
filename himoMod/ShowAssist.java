package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowAssistSet;

import net.minecraft.client.Minecraft;

public class ShowAssist {
	public static int ShowAssistOF;//ShowAssistがONかOFFか
	public static int Assistbigsmall;//ShowAssistが大きいほうか小さい方か
	public static int Assistleftright;//ShowAssistを左にずらすのか右にずらすのか
	public static int Assistspesu;//どれだけ真ん中からずらすのか(int)
	public static String supesu;//supesuhairetuの空白が入る
	//↓すべてのパターンを配列に入れることで前はできなかった + - での空白調整を可能にした
	public static String[] supesuhairetu = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    ", "                     ", "                      ", "                       ", "                        ", "                         ", "                              ", "                                   ", "                                        ", "                                             ", "                                                  ", "                                                       ", "                                                            ", "                                                                 ", "                                                                      ", "                                                                           ", "                                                                                ", "                                                                                     ", "                                                                                          ", "                                                                                               ", "                                                                                               ", "                                                                                                    "};

	public static void playShowAssist() {
		if (ShowAssistOF == ShowAssistSet.OFF) {
		} else if (ShowAssistOF == ShowAssistSet.ON) {
			switch(Assistbigsmall) {//ShowAssistが大きいほうか小さい方か
			case ShowAssistSet.Assistbig://大きかったら
				switch(Assistleftright) {//右か左か
				case ShowAssistSet.Assistleft://左だったら
					playShowAssistbigleft();
				break;
				case ShowAssistSet.Assistright://右だったら
					playShowAssistbigright();
				break;
				}
			break;
			case ShowAssistSet.Assistsmall://小さかったら
				switch(Assistleftright) {//ShowAssistを左にずらすのか右にずらすのか
				case ShowAssistSet.Assistleft://左だったら
					playShowAssistsmallleft();
				break;
				case ShowAssistSet.Assistright://右だったら
					playShowAssistsmallright();
				break;
				}
			break;
		}

		}
	}

	public static void playShowAssistGUI() {//同上 * GUIで起動される方
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
		supesu = supesuhairetu[Assistspesu];//Stringのsupesuにsupesuhairetuの配列のAssistspesuの番号
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
