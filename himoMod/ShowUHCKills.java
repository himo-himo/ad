package com.himo.himoMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ShowUHCKills {

	private static int ninn = 120;

	static String[] uhcKiller = new String [ninn];
	static int[] uhcKills = new int [ninn];

	static String[] Stringp0karap5 = {"", "", "", "", "", ""};
	static String[] intp0karap5 = {"0", "1", "2", "3", "4", "5", "6"};

	private static boolean isRender = true;
	private static int x = 20;
	private static int y = 0;
	private static int migihidarimannaka = 0;

	public static void killsrender() {
		if(!isRender) return;
		int integer = y;
		int integerx = x;
		for(int i=0; i< Stringp0karap5.length; i++){
			if (migihidarimannaka == 0) {
				integerx = x;
			}
			Minecraft.getMinecraft().fontRendererObj.drawString(Stringp0karap5[i] + " " + intp0karap5[i], integerx, integer, 0xffffffff, true);
			integer += 10;
		}
	}

	public static void uhckillshyouzi(String arg) {//UHCで相手の名前が出たらそいつのkill数を表示
		for(int i=0; i< ninn; i++){
    		if (arg.equals(uhcKiller[i])) {
    			for(int u=0; u< Stringp0karap5.length; u++){//配列の名前検索して回す
    				for(int e=0; e< Stringp0karap5.length; e++){//配列の中に同じ文字があったらそこを""にする
    					if (Stringp0karap5[u].equals(arg)) {
    						Stringp0karap5[u] = "";
    					}
    				}
    				if (Stringp0karap5[u].equals("")) {
    					Stringp0karap5[u] = arg;
    					intp0karap5[u] = String.valueOf(uhcKills[i]);
    					break;
    				}
    			}
    			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg + "/は" + uhcKills[i] + "Killしています"));
    			break;
    		}
    	}
	}

	public static void kirusuupurasu(String arg) {//殺した人を配列から探しその番号を擬似2次元に入れる
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg + "/に+"));
		for(int i=0; i< ninn; i++){
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
