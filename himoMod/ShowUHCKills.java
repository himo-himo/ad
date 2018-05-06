package com.himo.himoMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ShowUHCKills {

	static String[] uhcKiller = new String [120];
	static int[] uhcKills = new int [120];

	public static void uhckillshyouzi(String arg) {//UHCで相手の名前が出たらそいつのkill数を表示
		for(int i=0; i< 120; i++){
    		if (arg.equals(uhcKiller[i])) {
    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg + "/は" + uhcKills[i] + "Killしています"));
    			break;
    		}
    	}
	}

	public static void kirusuupurasu(String arg) {//殺した人を配列から探しその番号を擬似2次元に入れる
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg + "/に+"));
		for(int i=0; i< 120; i++){
    		if (arg.equals(uhcKiller[i])) {
    			uhcKills[i] = uhcKills[i] + 1;
    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + i + "/に+"));
    			break;
    		}
    	}
	}

	public static void allnamesakusei(String[] arg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("" + arg[0] + arg[1] + arg[2]));
		System.out.println("" + arg.length);
		//受け渡された値が1つだったら
		if (arg.length == 1) {
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[0];
	    			break;
	    		}
	    	}
		}
		//受け渡された配列が2つあったら
		if (arg.length == 2) {
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[0];
	    			break;
	    		}
	    	}
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[1];
	    			break;
	    		}
	    	}
		}
		//受け渡された値が3つだったら
		if (arg.length == 3) {
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[0];
	    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg[0] + "/を配列に追加"));
	    			break;
	    		}
	    	}
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[1];
	    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg[1] + "/を配列に追加"));
	    			break;
	    		}
	    	}
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[2];
	    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg[2] + "/を配列に追加"));
	    			break;
	    		}
	    	}
		}
	}
}
