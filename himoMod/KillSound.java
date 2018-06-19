package com.himo.himoMod;

import com.himo.himoMod.AllSettings.KillSoundSet;

import net.minecraft.client.Minecraft;

public class KillSound {

	public static void playKillSound() {
		if (himoMod.killSound != KillSoundSet.ON) return;
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
			Minecraft.getMinecraft().thePlayer.playSound("dig.stone", 100F, 1.2F);
	}
}