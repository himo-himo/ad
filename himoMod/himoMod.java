package com.himo.himoMod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.himo.himoMod.AllSettings.AimDisplaySet;
import com.himo.himoMod.AllSettings.KillSoundSet;
import com.himo.himoMod.AllSettings.PerunCDSet;
import com.himo.himoMod.AllSettings.ShowAssistSet;
import com.himo.himoMod.AllSettings.ShowHPSet;
import com.himo.himoMod.AllSettings.ShowKillSet;
import com.himo.himoMod.AllSettings.ShowTeamMateSet;
import com.himo.himoMod.AllSettings.ShowUHCKillsSet;
import com.himo.himoMod.AllSettings.ShowUseHeadSet;
import com.himo.himoMod.GUIS.PerunCDGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = himoMod.MOD_ID, version = himoMod.MOD_VERSION)
public class himoMod {
	public static final String MOD_ID = "himomod";
	public static final String MOD_VERSION = "1.0";

	public static int killSound;//killSoundがONかONじゃないかのintが入る
	public static int showUseHead;//showUseHeadがONかONじゃないかのintが入る
	public static int ShowTeamMateOF;//ShowTeamMateOFがONかONじゃないかのintが入る

	public static Properties properties= new Properties();
	public static File propertiesFile = new File("./himoCT.properties");

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		AimDisplay.taima1();//aimdisplayの%の起動
		AimDisplay.kousinn1();//aimdisplayの文字更新の起動
		ClientCommandHandler.instance.registerCommand(new himoGUICommand());
		if(!propertiesFile.exists()) {//フォルダがなかったら
			try {
				propertiesFile.createNewFile();//生成
				properties.setProperty("killSound", String.valueOf(KillSoundSet.ON));//killSoundという値にKillSoundSetのONという値を入れる
				properties.setProperty("showUseHead", String.valueOf(ShowUseHeadSet.ON));//showUseHeadという値にShowUseHeadSetのONという値を入れる
				properties.setProperty("ShowTeamMateOF", String.valueOf(ShowTeamMateSet.ON));
				properties.setProperty("ShowHPOF", String.valueOf(ShowHPSet.ON));
				properties.setProperty("HPbigsmall", String.valueOf(ShowHPSet.HPsmall));//showUseHeadという値にShowUseHeadSetのONという値を入れる
				properties.setProperty("HPleftright", String.valueOf(ShowHPSet.HPright));//HPleftrightという値にShowHPSetのHPrightという値を入れる
				properties.setProperty("HPspesu", String.valueOf(ShowHPSet.HPspesu));//HPrightsという値にShowHPSetのHPrightsという値を入れる
				properties.setProperty("ShowKillOF", String.valueOf(ShowKillSet.ON));
				properties.setProperty("Killbigsmall", String.valueOf(ShowKillSet.Killsmall));//showUseHeadという値にShowUseHeadSetのONという値を入れる
				properties.setProperty("Killleftright", String.valueOf(ShowKillSet.Killright));//HPleftrightという値にShowHPSetのHPrightという値を入れる
				properties.setProperty("Killspesu", String.valueOf(ShowKillSet.Killspesu));//HPrightsという値にShowHPSetのHPrightsという値を入れる
				properties.setProperty("ShowAssistOF", String.valueOf(ShowAssistSet.ON));
				properties.setProperty("Assistbigsmall", String.valueOf(ShowAssistSet.Assistsmall));//showUseHeadという値にShowUseHeadSetのONという値を入れる
				properties.setProperty("Assistleftright", String.valueOf(ShowAssistSet.Assistright));//HPleftrightという値にShowHPSetのHPrightという値を入れる
				properties.setProperty("Assistspesu", String.valueOf(ShowAssistSet.Assistspesu));

				properties.setProperty("PerunOF", String.valueOf(PerunCDSet.ON));
				properties.setProperty("Perunx", String.valueOf(PerunCDSet.x));
				properties.setProperty("Peruny", String.valueOf(PerunCDSet.y));
				properties.setProperty("Perunscale", String.valueOf(PerunCDSet.scale));

				properties.setProperty("AimOF", String.valueOf(AimDisplaySet.ON));
				properties.setProperty("Aimtopc", String.valueOf(AimDisplaySet.topcON));
				properties.setProperty("Aimx", String.valueOf(AimDisplaySet.x));
				properties.setProperty("Aimy", String.valueOf(AimDisplaySet.y));
				properties.setProperty("Aimscale", String.valueOf(AimDisplaySet.scale));

				properties.setProperty("uhckillsOF", String.valueOf(ShowUHCKillsSet.ON));
				properties.setProperty("uhckillsx", String.valueOf(ShowUHCKillsSet.x));
				properties.setProperty("uhckillsy", String.valueOf(ShowUHCKillsSet.y));
				properties.setProperty("uhckillslr", String.valueOf(ShowUHCKillsSet.lr));


				properties.store(new FileOutputStream(propertiesFile), "Dont change it!");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			properties.load(new FileInputStream(propertiesFile));
			killSound = Integer.valueOf(properties.getProperty("killSound","0"));
			showUseHead = Integer.valueOf(properties.getProperty("showUseHead","0"));
			ShowTeamMateOF = Integer.valueOf(properties.getProperty("ShowTeamMateOF","0"));
			ShowHP.ShowHPOF = Integer.valueOf(properties.getProperty("ShowHPOF","0"));
			ShowHP.HPbigsmall = Integer.valueOf(properties.getProperty("HPbigsmall","0"));
			ShowHP.HPleftright = Integer.valueOf(properties.getProperty("HPleftright","0"));
			ShowHP.HPspesu = Integer.valueOf(properties.getProperty("HPspesu","0"));
			ShowKill.ShowKillOF = Integer.valueOf(properties.getProperty("ShowKillOF","0"));
			ShowKill.Killbigsmall = Integer.valueOf(properties.getProperty("Killbigsmall","0"));
			ShowKill.Killleftright = Integer.valueOf(properties.getProperty("Killleftright","0"));
			ShowKill.Killspesu = Integer.valueOf(properties.getProperty("Killspesu","0"));
			ShowAssist.ShowAssistOF = Integer.valueOf(properties.getProperty("ShowAssistOF","0"));
			ShowAssist.Assistbigsmall = Integer.valueOf(properties.getProperty("Assistbigsmall","0"));
			ShowAssist.Assistleftright = Integer.valueOf(properties.getProperty("Assistleftright","0"));
			ShowAssist.Assistspesu = Integer.valueOf(properties.getProperty("Assistspesu","0"));

			PerunCD.PerunCDOF = Integer.valueOf(properties.getProperty("PerunOF","0"));
			PerunCD.x = Float.parseFloat(properties.getProperty("Perunx","0"));
			PerunCD.y = Float.parseFloat(properties.getProperty("Peruny","0"));
			PerunCD.scale = Double.parseDouble(properties.getProperty("Perunscale","0"));

			AimDisplay.AimDisplayOF = Integer.valueOf(properties.getProperty("AimOF","0"));
			AimDisplay.topcenter = Integer.valueOf(properties.getProperty("Aimtopc","0"));
			AimDisplay.scale = Double.parseDouble(properties.getProperty("Aimscale","0"));
			AimDisplay.x = Float.parseFloat(properties.getProperty("Aimx","0"));
			AimDisplay.y = Float.parseFloat(properties.getProperty("Aimy","0"));

			ShowUHCKills.ShowUHCKillsOF = Integer.valueOf(properties.getProperty("uhckillsOF","0"));
			ShowUHCKills.x = Integer.valueOf(properties.getProperty("uhckillsx","0"));
			ShowUHCKills.y = Integer.valueOf(properties.getProperty("uhckillsy","0"));
			ShowUHCKills.leftorright = Integer.valueOf(properties.getProperty("uhckillslr","0"));

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String removeColorCode(final String text) {//受け取ったchatにカラーコードはいらないのであったら消す関数
		return text.replaceAll("§0", "").replaceAll("§1", "").replaceAll("§2", "").replaceAll("§3", "").replaceAll("§4", "").replaceAll("§5", "").replaceAll("§6", "").replaceAll("§7", "").replaceAll("§8", "").replaceAll("§9", "").replaceAll("§a", "").replaceAll("§b", "").replaceAll("§c", "").replaceAll("§d", "").replaceAll("§e", "").replaceAll("§f", "").replaceAll("§k", "").replaceAll("§l", "").replaceAll("§m", "").replaceAll("§n", "").replaceAll("§o", "").replaceAll("§r", "");
	}

	@SubscribeEvent
	public void onChat(ClientChatReceivedEvent event) {//Chatを受け取ったらその文字すべてが引数として渡されてる
		String[] uhckorosareta = {" was slain", " was shot", " was blown up", " was knocked off a cliff", " tried to swim in lava", " suffocated in a wall", " burned to death", " fell to their death"};
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§7 hi"));
		String message = removeColorCode(event.message.getUnformattedText());
		if(message.contains("coins! Kill")) {//playKillSoundを起動
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§7 hi合ってるよ"));
			KillSound.playKillSound();
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("" + killSound));
			ShowKill.playShowKill();
		}
		if(message.contains("You have assisted killing ")) {//playKillSoundを起動
			ShowAssist.playShowAssist();
		}
		if(message.contains(" ate a player head and you gained 7 seconds of Regeneration II!")) {//Head使ったときの文字が含まれているか
			//playShowuseheadに誰が使ったかを受け渡す
			String darenanoka = message.replace(" ate a player head and you gained 7 seconds of Regeneration II!", "");
			ShowUseHead.playShowusehead(darenanoka);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(darenanoka));
		}
		if(message.contains(" ate a Golden Head and you gained 4 seconds of Regeneration III and 2 minutes of Absorption!")) {//GHead使ったときの文字が含まれているか
			//playShowuseGheadに誰が使ったかを受け渡す
			String darenanoka = message.replace(" ate a Golden Head and you gained 4 seconds of Regeneration III and 2 minutes of Absorption!", "");
			ShowUseHead.playShowuseGhead(darenanoka);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(darenanoka));
		}
		if(message.contains(" is on ")) {//HPをShowHPにintで受け渡す
			if(message.contains(" HP!")) {
				String[] HPnukidasi = message.split(" ", 0);
				float health = Float.parseFloat(HPnukidasi[3]);
				String healths = HPnukidasi[3];
				ShowHP.playShowHP(health, healths);
			}
		}
		if(message.contains(" is on ")) {//名前をStringでplayShowTeamMateに受け渡す
			if(message.contains(" HP!")) {
				String[] Namenukidasi = message.split(" ", 0);
				String namae = Namenukidasi[0];
				ShowTeamMate.playShowTeamMate(namae);
			}
		}
		if(message.contains("• (")) {//チームをTeamListcreateに受け渡す
			String teamnomi = message.replace(" ", "");
			teamnomi = teamnomi.replace("•", "");
			teamnomi = teamnomi.replace("(", "");
			teamnomi = teamnomi.replace(")", "");
			String[] namaehairetu = teamnomi.split(",");
			ShowUHCKills.allnamesakusei(namaehairetu);
			ShowTeamMate.TeamListcreate(namaehairetu);
		}
		for(String korosaretaa : uhckorosareta) {//UHCのKillLogが流れたらその殺された人の名前を抜き出してremoveTeamMateに受け渡す
			if(message.contains(korosaretaa)) {
				String[] Namenukidasi = message.split(" ");
				String namae = Namenukidasi[0];
				ShowTeamMate.removeTeamMate(namae);
			}
		}
		if(message.contains(" was shot by ") || message.contains(" was slain by ")) {//UHCキルしたやつの名前抜き出し1
			String[] Namenukidasi = message.split(" ", 0);
			String namae = Namenukidasi[4];
			ShowUHCKills.kirusuupurasu(namae);
		}
		if(message.contains(" was blown up by ")) {//UHCキルしたやつの名前抜き出し2
			String[] Namenukidasi = message.split(" ", 0);
			String namae = Namenukidasi[5];
			ShowUHCKills.kirusuupurasu(namae);
		}
		if(message.contains(" was knocked off a cliff by ")) {//UHCキルしたやつの名前抜き出し3
			String message2 = message.replace("!", "");
			String[] Namenukidasi = message2.split(" ", 0);
			String namae = Namenukidasi[7];
			ShowUHCKills.kirusuupurasu(namae);
		}
		if(message.contains(" is on ")) {//名前をStringでuhckillshyouziに受け渡す
			if(message.contains(" HP!")) {
				String[] Namenukidasi = message.split(" ", 0);
				String namae = Namenukidasi[0];
				ShowUHCKills.uhckillshyouzi(namae);
			}
		}
	}

	@SubscribeEvent
    public void onSoundPlay(PlaySoundEvent event) {//ゲーム内で音がなったら起動
		String soundname = event.name;
		if (soundname.equals("ambient.weather.thunder")) {//その音が雷なのか
			String itemnamae = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getDisplayName();
			String itemnamaerem = removeColorCode(itemnamae);//カラーコード消す
			if (itemnamaerem.equals("Axe of Perun")) {//その文字がAxe of Perunか
				PerunCD.playstartPerunCD();//5.4.3.2.1
				PerunCD.playstartPerunCDGO();//GO
			}
		}
    }

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onRenderTick(TickEvent.RenderTickEvent event) {//マイクラのtick 1s=20
		AimDisplay.drawRect1();//AimDisplayのバックの半透明の四角
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {//マイクラのFPSと同時に実行される 253 = 253回更新
		PerunCD.playPerunCD();//ペルンの5.4.3.2.1
		PerunCD.playPerunCDGO();//ペルンのGO
		PerunCDGUI.testPerunCD();//ペルンのGUI
		ShowUHCKills.killsrender();//autokillsの文字列の描画
	}
}