package com.himo.himoMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ShowTeamMate {

    static String[][] uhcteam = new String [40][3];

    public static void TeamListcreate(String[] namaehairetu) {//配列に名前を保存
    	for(int i=0; i< 40; i++){
    		if (uhcteam[i][0] == null) {
    			for (int u=0; u< 3; u++) {
    				uhcteam[i][u] = namaehairetu[u];
    				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("どぁだｗだどぁだｗｄｗ"));
    			}
    			break;
    		}

    	}
    }

    public static void playShowTeamMate(String arg) {//配列にその名前があればその配列をチャットに送信
    	for(int i=0; i< 40; i++){
    		if (arg.equals(uhcteam[i][0]) || arg.equals(uhcteam[i][1]) || arg.equals(uhcteam[i][2])) {
    			if (uhcteam[i][1] == null) {
    				uhcteam[i][1] = "";
    			}
    			if (uhcteam[i][2] == null) {
    				uhcteam[i][2] = "";
    			}
    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("• (§r§a" + uhcteam[i][0] + "§r, §a" + uhcteam[i][1] + "§r, §a" + uhcteam[i][2] + "§r)"));
    			break;
    		}
    	}
    }

    public static void removeTeamMate(String arg) {//配列にその名前があればその配列に死んだことをしらすことができるカラーコード挿入
    	for(int i=0; i< 40; i++){
    		if (arg.equals(uhcteam[i][0]) || arg.equals(uhcteam[i][1]) || arg.equals(uhcteam[i][2])) {
    			for (int u=0; u< 3; u++) {
    				if (uhcteam[i][u].equals(arg)) {
    				uhcteam[i][u] = "§r§7§n" + uhcteam[i][u];
    				}
    			}
    			break;
    		}
    	}
    }
}