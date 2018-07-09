package com.himo.himoMod;

import java.util.Timer;
import java.util.TimerTask;

import com.himo.himoMod.AllSettings.ShowUHCKillsSet;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ShowUHCKills {

	private static int ninn = 120;//試合に入る最大人数の数

	static String[] uhcKiller = new String [ninn];//疑似2次元配列の名前の方
	static int[] uhcKills = new int [ninn];//疑似2次元配列のキル数の方

	public static String[] Stringp0karap5 = {"aaaaaaaaaaaaaaa", "", "", "", "", ""};//描画する名前の方
	public static String[] intp0karap5 = {"0", "1", "2", "3", "4", "5"};//描画するキルの方
	public static int[] int60scount = {0, 0, 0, 0, 0, 0};//描画する名前の方

	public static int leftorright;//文字列の頂点を左上にするか右上にするかのint
	public static int ShowUHCKillsOF;//ShowUHCKillsがONかOFFか

	public static int x = 200;//x座標200は使われることはないが一応
	public static int y = 0;//y座標


	public static void renderreset(float f, float g) {//画面の文字をクリックしたときにUHCkillsの描画文字をすべて消す関数
		int yy = 0;

		for(int i=0; i< Stringp0karap5.length; i++){
			yy += 10;
			if (leftorright == 1) {
				if (x - Minecraft.getMinecraft().fontRendererObj.getStringWidth(Stringp0karap5[i] + " " + intp0karap5[i]) < f && f < x && y < g && g < y + yy) {
					for(int u=0; u< Stringp0karap5.length; u++){//テスト用にサンプルを描画
						ShowUHCKills.Stringp0karap5[u] = "";
						ShowUHCKills.intp0karap5[u] = "";
					}
				}
			}
			if (leftorright == 0) {
				if (x < f && f < x + Minecraft.getMinecraft().fontRendererObj.getStringWidth(Stringp0karap5[i] + " " + intp0karap5[i]) && y < g && g < y + yy) {
					for(int u=0; u< Stringp0karap5.length; u++){//テスト用にサンプルを描画
						ShowUHCKills.Stringp0karap5[u] = "";
						ShowUHCKills.intp0karap5[u] = "";
					}
				}
			}
		}
	}


	public static void killsrender() {//画面に描画する関数
		if (Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().objectMouseOver == null) return;
		if(ShowUHCKillsOF == ShowUHCKillsSet.OFF) return;
		int integer = y;
		int integerx = x;
		for(int i=0; i< Stringp0karap5.length; i++){//拡張for文でStringp0karap5の数だけ回す
			if (leftorright == 1) {//頂点が右上だったら
				/*x座標から文字の横の長さを引いて調節*/integerx = x - Minecraft.getMinecraft().fontRendererObj.getStringWidth(Stringp0karap5[i] + " " + intp0karap5[i]);
			}
			/*描画*/Minecraft.getMinecraft().fontRendererObj.drawString(Stringp0karap5[i] + " " + intp0karap5[i], integerx, integer, 0xffffffff, true);
			integer += 10;//毎回10+することによりLineを作ることができる
		}
	}

	public static void uhckillshyouzi(String arg) {//UHCで相手の名前が出たらそいつのkill数を表示
		for(int i=0; i< ninn; i++){//試合に入れる最大人数の数回す
    		if (arg.equals(uhcKiller[i])) {//受け取った値が配列にあるか
    			for(int u=0; u< Stringp0karap5.length; u++){//配列の名前検索して回す
    				for(int e=0; e< Stringp0karap5.length; e++){//描画してる文字列の数回して
    					if (Stringp0karap5[u].equals(arg)) {//配列の中に同じ文字があったらそこを""にする
    						Stringp0karap5[u] = "";
    						int60scount[u] = 0;
    					}
    				}
    				if (Stringp0karap5[u].equals("")) {//配列の中に空白があったら
    					Stringp0karap5[u] = arg;//その配列の位置を受け取った値にする
    					intp0karap5[u] = String.valueOf(uhcKills[i]);//疑似2次元配列なのでその同じ場所にintのキル数を入れる
    					break;
    				}
    			}
    			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg + "/は" + uhcKills[i] + "Killしています"));
    			break;
    		}
    	}
	}

	public static void kirusuupurasu(String arg) {//殺した人を配列から探しその番号を擬似2次元に入れる
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg + "/に+"));
		for(int i=0; i< ninn; i++){
    		if (arg.equals(uhcKiller[i])) {
    			uhcKills[i] = uhcKills[i] + 1;
    			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + i + "/に+"));
    			break;
    		}
    	}
	}

	/*public static void kills60s() throws ParseException {
		final Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				int60sclear();
			}
		};
		timer.schedule(task, 0, 1000);
	}*/

	public static void kills60s() throws ParseException {
		final Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				int60sclear();
			}
		};
		timer.schedule(task, 0, 1000);//1秒周期でint60sclear()
	}

	public static void int60sclear() {
		for (int i = 0 ; i < int60scount.length ; i++) {//int60scountの中に60があったらStringp0karap5とintp0karap5をその配列の部分を空白にしてカウントを0にリセット
			if (int60scount[i] >= 60) {
				Stringp0karap5[i] = "";
				intp0karap5[i] = "";
				int60scount[i] = 0;
			}
		}
		for (int i = 0 ; i < Stringp0karap5.length ; i++) {//Stringp0karap5が空白じゃなかったらint60scountのその番号に1+
			if (!Stringp0karap5[i].equals("")){
				int60scount[i]++;
			}
		}
	}

	public static void allnamesakusei(String[] arg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("" + arg[0] + arg[1] + arg[2]));
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
	    			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg[0] + "/を配列に追加"));
	    			break;
	    		}
	    	}
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[1];
	    			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg[1] + "/を配列に追加"));
	    			break;
	    		}
	    	}
			for(int i=0; i< 40; i++){
	    		if (uhcKiller[i] == null) {
	    			uhcKiller[i] = arg[2];
	    			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("/" + arg[2] + "/を配列に追加"));
	    			break;
	    		}
	    	}
		}
	}
}
