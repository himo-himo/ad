package com.himo.himoMod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.himo.himoMod.AllSettings.KillSoundSet;
import com.himo.himoMod.AllSettings.ShowHPSet;
import com.himo.himoMod.AllSettings.ShowUseHeadSet;

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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = himoMod.MOD_ID, version = himoMod.MOD_VERSION)
public class himoMod {
	public static final String MOD_ID = "himomod";
	public static final String MOD_VERSION = "1.0";

	public static int killSound;
	public static int showUseHead;

	public static Properties properties= new Properties();
	public static File propertiesFile = new File("./himoCT.properties");

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("himodesu");
		MinecraftForge.EVENT_BUS.register(this);
		ClientCommandHandler.instance.registerCommand(new himoGUICommand());
		if(!propertiesFile.exists()) {//フォルダがなかったら
			try {
				propertiesFile.createNewFile();//生成
				properties.setProperty("killSound", String.valueOf(KillSoundSet.ON));//killSoundという値にKillSoundSetのONという値を入れる
				properties.setProperty("showUseHead", String.valueOf(ShowUseHeadSet.ON));//showUseHeadという値にShowUseHeadSetのONという値を入れる
				properties.setProperty("HPbigsmall", String.valueOf(ShowHPSet.HPsmall));//showUseHeadという値にShowUseHeadSetのONという値を入れる
				properties.setProperty("HPleftright", String.valueOf(ShowHPSet.HPright));//HPleftrightという値にShowHPSetのHPrightという値を入れる
				properties.setProperty("HPspesu", String.valueOf(ShowHPSet.HPspesu));//HPrightsという値にShowHPSetのHPrightsという値を入れる
				properties.store(new FileOutputStream(propertiesFile), "Dont change it!");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			properties.load(new FileInputStream(propertiesFile));
			killSound = Integer.valueOf(properties.getProperty("killSound","0"));//killSoundにpropertiesのkillSoundの値を導入
			showUseHead = Integer.valueOf(properties.getProperty("showUseHead","0"));//showUseHeadにpropertiesのshowUseHeadの値を導入
			ShowHP.HPbigsmall = Integer.valueOf(properties.getProperty("HPbigsmall","0"));
			ShowHP.HPleftright = Integer.valueOf(properties.getProperty("HPleftright","0"));
			ShowHP.HPspesu = Integer.valueOf(properties.getProperty("HPspesu","0"));//ShowHP.HPleftrightにpropertiesのHPleftrightの値を導入
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String removeColorCode(final String text) {
		return text.replaceAll("§0", "").replaceAll("§1", "").replaceAll("§2", "").replaceAll("§3", "").replaceAll("§4", "").replaceAll("§5", "").replaceAll("§6", "").replaceAll("§7", "").replaceAll("§8", "").replaceAll("§9", "").replaceAll("§a", "").replaceAll("§b", "").replaceAll("§c", "").replaceAll("§d", "").replaceAll("§e", "").replaceAll("§f", "").replaceAll("§k", "").replaceAll("§l", "").replaceAll("§m", "").replaceAll("§n", "").replaceAll("§o", "").replaceAll("§r", "");
	}

	@SubscribeEvent
	public void onChat(ClientChatReceivedEvent event) {
		String[] uhckorosareta = {" was slain", " was shot", " was blown up", " was knocked off a cliff", " tried to swim in lava", " suffocated in a wall", " burned to death", " fell to their death"};
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§7 hi"));
		String message = removeColorCode(event.message.getUnformattedText());
		if(message.contains("coins! Kill")) {//playKillSoundを起動
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§7 hi合ってるよ"));
			KillSound.playKillSound();
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("" + killSound));
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
				float helth = Float.parseFloat(HPnukidasi[3]);
				String helths = HPnukidasi[3];
				ShowHP.playShowHP(helth, helths);
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
    public void onSoundPlay(PlaySoundEvent event) {
		//System.out.println(event.name);
		String soundname = event.name;
		if (soundname.equals("ambient.weather.thunder")) {
			String itemnamae = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getDisplayName();
			String itemnamaerem = removeColorCode(itemnamae);
			System.out.println(itemnamae);
			if (itemnamaerem.equals("Axe of Perun")) {
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(itemnamaerem));
				PerunCD.playstartPerunCD();
				PerunCD.playstartPerunCDGO();
			}

		}
    }

	@SubscribeEvent
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		PerunCD.playPerunCD();
		PerunCD.playPerunCDGO();
	}
}