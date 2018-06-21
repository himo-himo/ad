package com.himo.himoMod;

import com.himo.himoMod.AllSettings.ShowHPSet;

import net.minecraft.client.Minecraft;

public class ShowHP {
	public static int ShowHPOF;//ShowHPがONかOFFか
	public static int HPbigsmall;//ShowHPが大きいほうか小さい方か
	public static int HPleftright;//ShowHPを左にずらすのか右にずらすのか
	public static int HPspesu;//どれだけ真ん中からずらすのか(int)
	public static String HPColour;//HPの数値によってカラーコードを変える←
	public static String supesu;//supesuhairetuの空白が入る
	//↓すべてのパターンを配列に入れることで前はできなかった + - での空白調整を可能にした
	public static String[] supesuhairetu = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    ", "                     ", "                      ", "                       ", "                        ", "                         ", "                              ", "                                   ", "                                        ", "                                             ", "                                                  ", "                                                       ", "                                                            ", "                                                                 ", "                                                                      ", "                                                                           ", "                                                                                ", "                                                                                     ", "                                                                                          ", "                                                                                               ", "                                                                                               ", "                                                                                                    "};

	public static void playShowHP(float health, String healths) {//関数起動(healthは数値を比較するためfloat healthsは比較しないのでString)
		if (ShowHPOF == ShowHPSet.OFF) {
		} else if (ShowHPOF == ShowHPSet.ON) {
			switch(HPbigsmall) {//ShowHPが大きいほうか小さい方か
			case ShowHPSet.HPbig://大きかったら
				switch(HPleftright) {//右か左か
				case ShowHPSet.HPleft://左だったら
					playShowHPbigleft(health, healths);
				break;
				case ShowHPSet.HPright://右だったら
					playShowHPbigright(health, healths);
				break;
				}
			break;
			case ShowHPSet.HPsmall://小さかったら
				switch(HPleftright) {//ShowHPを左にずらすのか右にずらすのか
				case ShowHPSet.HPleft://左だったら
					playShowHPsmallleft(health, healths);
				break;
				case ShowHPSet.HPright://右だったら
					playShowHPsmallright(health, healths);
				break;
				}
			break;
		}

		}
	}

	public static void playShowHPGUI(float health, String healths) {//同上 * GUIで起動される方
			switch(HPbigsmall) {
			case ShowHPSet.HPbig:
				switch(HPleftright) {
				case ShowHPSet.HPleft:
					playShowHPbigleft(health, healths);
				break;
				case ShowHPSet.HPright:
					playShowHPbigright(health, healths);
				break;
				}
			break;
			case ShowHPSet.HPsmall:
				switch(HPleftright) {
				case ShowHPSet.HPleft:
					playShowHPsmallleft(health, healths);
				break;
				case ShowHPSet.HPright:
					playShowHPsmallright(health, healths);
				break;
				}
			break;
		}
	}

	public static void HPColourSet(float health) {//受け取ったhealthを比較しカラーコードをつける
		if (health <= 15) {
			HPColour = "§r§c";
		} else if (health <= 25){
			HPColour = "§r§e";
		} else {
			HPColour = "§r§a";
		}
		supesu = supesuhairetu[HPspesu];//Stringのsupesuにsupesuhairetuの配列のAssistspesuの番号
	}

	public static void playShowHPbigleft(float health, String healths) {
		HPColourSet(health);
		Minecraft.getMinecraft().ingameGUI.displayTitle(HPColour + healths + supesu, null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowHPbigright(float health, String healths) {
		HPColourSet(health);
		Minecraft.getMinecraft().ingameGUI.displayTitle(supesu + HPColour + healths, null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, "", 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowHPsmallleft(float health, String healths) {
		HPColourSet(health);
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, HPColour + healths + supesu, 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}

	public static void playShowHPsmallright(float health, String healths) {
		HPColourSet(health);
		Minecraft.getMinecraft().ingameGUI.displayTitle("", null, 0, 20, 5);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null,supesu + HPColour + healths, 0, 0, 0);
		Minecraft.getMinecraft().ingameGUI.displayTitle(null, null, 0, 20, 5);
	}
}
