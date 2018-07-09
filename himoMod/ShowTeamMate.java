package com.himo.himoMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ShowTeamMate {

    static String[][] uhcteam = new String [40][3];

    public static void TeamListcreate(String[] namaehairetu) {//配列に名前を保存
    	for(int i=0; i< 40; i++){//チームの最大数の40回 回す
    		if (uhcteam[i][0] == null) {//iの0がnullだったら
    			for (int u=0; u< 3; u++) {//チームの最大人数の3回 回す
    				uhcteam[i][u] = namaehairetu[u];//受け取った配列をその列の配列に保存
    			}
    			break;
    		}
    	}
    }

    public static void playShowTeamMate(String arg) {//配列にその名前があればその配列をチャットに送信
    	for(int i=0; i< 40; i++){//チームの最大数の40回 回す
    		if (arg.equals(uhcteam[i][0]) || arg.equals(uhcteam[i][1]) || arg.equals(uhcteam[i][2])) {//多次元の中にどれか1つでも引数の文字があったら
    			if (uhcteam[i][1] == null) {//nullを""に
    				uhcteam[i][1] = "";
    			}
    			if (uhcteam[i][2] == null) {//nullを""に
    				uhcteam[i][2] = "";
    			}
    			/*チャットに送信*/Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("• (§r§a" + uhcteam[i][0] + "§r, §a" + uhcteam[i][1] + "§r, §a" + uhcteam[i][2] + "§r)"));
    			break;
    		}
    	}
    }

    public static void removeTeamMate(String arg) {//配列にその名前があればその配列に死んだことをしらすことができるカラーコード挿入
    	for(int i=0; i< 40; i++){//チームの最大数の40回 回す
    		if (arg.equals(uhcteam[i][0]) || arg.equals(uhcteam[i][1]) || arg.equals(uhcteam[i][2])) {//多次元の中にどれか1つでも引数の文字があったら
    			for (int u=0; u< 3; u++) {//チームの最大人数の3回 回す
    				if (uhcteam[i][u].equals(arg)) {//何番目にそいつが入ってるか特定するif
    				uhcteam[i][u] = "§r§7§n" + uhcteam[i][u];//特定したやつの文字の最初に死んだことを知らせるカラーコード挿入する
    				}
    			}
    			break;
    		}
    	}
    }
}