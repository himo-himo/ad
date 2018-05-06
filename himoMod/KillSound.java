package com.himo.himoMod;

import com.himo.himoMod.AllSettings.KillSoundSet;

import net.minecraft.client.Minecraft;

public class KillSound {

	public static void playKillSound() {
		switch(himoMod.killSound) {
		case KillSoundSet.OFF:
			break;
		case KillSoundSet.ON:
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			break;
		}
	}
}