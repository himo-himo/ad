package com.himo.himoMod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.himo.himoMod.AllSettings.KillSoundSet;
import com.himo.himoMod.AllSettings.PerunCDSet;
import com.himo.himoMod.AllSettings.ShowHPSet;
import com.himo.himoMod.AllSettings.ShowKillSet;
import com.himo.himoMod.AllSettings.ShowUseHeadSet;
import com.himo.himoMod.GUIS.PerunCDGUI;
import com.himo.himoMod.GUIS.ShowHPGUI;
import com.himo.himoMod.GUIS.ShowKillGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class himoGUI extends GuiScreen {

	private GuiButton buttonKillSound;
	private GuiButton buttonShowUseHead;
	private GuiButton buttonShowTeamMate;
	private GuiButton buttonPerunCD1;
	private GuiButton buttonPerunCD2;
	private GuiButton buttonShowKill1;
	private GuiButton buttonShowKill2;
	private GuiButton buttonShowHP1;
	private GuiButton buttonShowHP2;
	private GuiButton buttonAutoKills1;
	private GuiButton buttonAutoKills2;
	private GuiButton buttonAimDisplay1;
	private GuiButton buttonAimDisplay2;


	@Override
	public void initGui() {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("adadadad"));
		buttonKillSound = new GuiButton(0, this.width / 2 - 200, this.height / 2 - 70, 120 , 20,"himo");
		buttonShowUseHead = new GuiButton(1, this.width / 2 - 60, this.height / 2 - 70, 120 , 20,"ON");
		buttonShowTeamMate = new GuiButton(2, this.width / 2 + 80, this.height / 2 - 70, 120 , 20,"ON");

		buttonPerunCD1 = new GuiButton(3, this.width / 2 - 200, this.height / 2 - 10, 59 , 20,"buttonPerunCD1");
		buttonPerunCD2 = new GuiButton(4, this.width / 2 - 139, this.height / 2 - 10, 59 , 20,"§bPosition");
		buttonShowKill1 = new GuiButton(5, this.width / 2 - 60, this.height / 2 - 10, 59 , 20,"buttonShowKill1");
		buttonShowKill2 = new GuiButton(6, this.width / 2 + 1, this.height / 2 - 10, 59 , 20,"§bPosition");
		buttonShowHP1 = new GuiButton(7, this.width / 2 + 80, this.height / 2 - 10, 59 , 20,"buttonShowHP1");
		buttonShowHP2 = new GuiButton(8, this.width / 2 + 141, this.height / 2 - 10, 59 , 20,"§bPosition");

		buttonAutoKills1 = new GuiButton(9, this.width / 2 - 200, this.height / 2 + 50, 59 , 20,"buttonAutoKills1");
		buttonAutoKills2 = new GuiButton(10, this.width / 2 - 139, this.height / 2 + 50, 59 , 20,"buttonAutoKills2");
		buttonAimDisplay1 = new GuiButton(11, this.width / 2 - 60, this.height / 2 + 50, 59 , 20,"buttonAimDisplay1");
		buttonAimDisplay2 = new GuiButton(12, this.width / 2 + 1, this.height / 2 + 50, 59 , 20,"buttonAimDisplay2");


		switch(himoMod.killSound) {
		case KillSoundSet.OFF:
			buttonKillSound.displayString = "§7OFF";
			break;
		case KillSoundSet.ON:
			buttonKillSound.displayString = "§aON";
			break;
		}
		switch(himoMod.showUseHead) {
		case ShowUseHeadSet.OFF:
			buttonShowUseHead.displayString = "§7OFF";
			break;
		case ShowUseHeadSet.ON:
			buttonShowUseHead.displayString = "§aON";
			break;
		}
		switch(ShowHP.ShowHPOF) {
		case ShowHPSet.OFF:
			buttonShowHP1.displayString = "§7OFF";
			break;
		case ShowHPSet.ON:
			buttonShowHP1.displayString = "§aON";
			break;
		}
		switch(ShowKill.ShowKillOF) {
		case ShowKillSet.OFF:
			buttonShowKill1.displayString = "§7OFF";
			break;
		case ShowKillSet.ON:
			buttonShowKill1.displayString = "§aON";
			break;
		}
		switch(PerunCD.PerunCDOF) {
		case PerunCDSet.OFF:
			buttonPerunCD1.displayString = "§7OFF";
			break;
		case PerunCDSet.ON:
			buttonPerunCD1.displayString = "§aON";
			break;
		}
		addButtons();
	}
	public void addButtons() {
		buttonList.add(buttonKillSound);
		buttonList.add(buttonShowUseHead);
		buttonList.add(buttonShowTeamMate);
		buttonList.add(buttonPerunCD1);
		buttonList.add(buttonPerunCD2);
		buttonList.add(buttonShowKill1);
		buttonList.add(buttonShowKill2);
		buttonList.add(buttonShowHP1);
		buttonList.add(buttonShowHP2);
		buttonList.add(buttonAutoKills1);
		buttonList.add(buttonAutoKills2);
		buttonList.add(buttonAimDisplay1);
		buttonList.add(buttonAimDisplay2);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawDefaultBackground();
		Minecraft.getMinecraft().fontRendererObj.drawString("KillSound", this.width / 2 - 155, this.height / 2 - 85, 0xffffffff, true);
		Minecraft.getMinecraft().fontRendererObj.drawString("ShowUseHead", this.width / 2 - 22, this.height / 2 - 85, 0xffffffff, true);
		Minecraft.getMinecraft().fontRendererObj.drawString("ShowTeamMate", this.width / 2 + 116, this.height / 2 - 85, 0xffffffff, true);

		Minecraft.getMinecraft().fontRendererObj.drawString("PerunCD", this.width / 2 - 153, this.height / 2 - 25, 0xffffffff, true);
		Minecraft.getMinecraft().fontRendererObj.drawString("ShowKill", this.width / 2 - 16, this.height / 2 - 25, 0xffffffff, true);
		Minecraft.getMinecraft().fontRendererObj.drawString("ShowHP", this.width / 2 + 128, this.height / 2 - 25, 0xffffffff, true);

		Minecraft.getMinecraft().fontRendererObj.drawString("AutoKills", this.width / 2 - 155, this.height / 2 + 35, 0xffffffff, true);
		Minecraft.getMinecraft().fontRendererObj.drawString("AimDisplay", this.width / 2 - 18, this.height / 2 + 35, 0xffffffff, true);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	public void display(){
		MinecraftForge.EVENT_BUS.register(this);
	    initGui();
	}
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event){
		MinecraftForge.EVENT_BUS.unregister(this);
		Minecraft.getMinecraft().displayGuiScreen(this);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	@Override
	public void onGuiClosed() {
		saveConfig();
		super.onGuiClosed();
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 0) {
			switch(himoMod.killSound) {
				case KillSoundSet.OFF:
					buttonKillSound.displayString = "§aON";
					himoMod.killSound = KillSoundSet.ON;
					break;
				case KillSoundSet.ON:
					buttonKillSound.displayString = "§7OFF";
					himoMod.killSound = KillSoundSet.OFF;
					break;
			}
		}
		if(button.id == 1) {
			switch(himoMod.showUseHead) {
				case ShowUseHeadSet.OFF:
					buttonShowUseHead.displayString = "§aON";
					himoMod.showUseHead = ShowUseHeadSet.ON;
					break;
				case ShowUseHeadSet.ON:
					buttonShowUseHead.displayString = "§7OFF";
					himoMod.showUseHead = ShowUseHeadSet.OFF;
					break;
			}
		}
		if(button.id == 3) {
			switch(PerunCD.PerunCDOF) {
				case PerunCDSet.OFF:
					buttonPerunCD1.displayString = "§aON";
					PerunCD.PerunCDOF = PerunCDSet.ON;
					break;
				case PerunCDSet.ON:
					buttonPerunCD1.displayString = "§7OFF";
					PerunCD.PerunCDOF = PerunCDSet.OFF;
					break;
			}
		}
		if(button.id == 4) {
			new PerunCDGUI().display();
		}
		if(button.id == 5) {
			switch(ShowKill.ShowKillOF) {
			case ShowKillSet.OFF:
				buttonShowKill1.displayString = "§aON";
				ShowKill.ShowKillOF = ShowKillSet.ON;
				break;
			case ShowKillSet.ON:
				buttonShowKill1.displayString = "§7OFF";
				ShowKill.ShowKillOF = ShowKillSet.OFF;
				break;
			}
		}
		if(button.id == 6) {
			new ShowKillGUI().display();
		}
		if(button.id == 7) {
			switch(ShowHP.ShowHPOF) {
			case ShowHPSet.OFF:
				buttonShowHP1.displayString = "§aON";
				ShowHP.ShowHPOF = ShowHPSet.ON;
				break;
			case ShowHPSet.ON:
				buttonShowHP1.displayString = "§7OFF";
				ShowHP.ShowHPOF = ShowHPSet.OFF;
				break;
			}
		}
		if(button.id == 8) {
			new ShowHPGUI().display();
		}
	}
	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	public static void saveConfig() {
		try {
			himoMod.properties.load(new FileInputStream(himoMod.propertiesFile));
			himoMod.properties.setProperty("killSound", String.valueOf(himoMod.killSound));
			himoMod.properties.setProperty("showUseHead", String.valueOf(himoMod.showUseHead));
			himoMod.properties.setProperty("ShowHPOF", String.valueOf(ShowHP.ShowHPOF));
			himoMod.properties.setProperty("HPbigsmall", String.valueOf(ShowHP.HPbigsmall));
			himoMod.properties.setProperty("HPleftright", String.valueOf(ShowHP.HPleftright));
			himoMod.properties.setProperty("HPspesu", String.valueOf(ShowHP.HPspesu));
			himoMod.properties.setProperty("ShowKillOF", String.valueOf(ShowKill.ShowKillOF));
			himoMod.properties.setProperty("Killbigsmall", String.valueOf(ShowKill.Killbigsmall));
			himoMod.properties.setProperty("Killleftright", String.valueOf(ShowKill.Killleftright));
			himoMod.properties.setProperty("Killspesu", String.valueOf(ShowKill.Killspesu));
			himoMod.properties.setProperty("ShowAssistOF", String.valueOf(ShowAssist.ShowAssistOF));
			himoMod.properties.setProperty("Assistbigsmall", String.valueOf(ShowAssist.Assistbigsmall));
			himoMod.properties.setProperty("Assistleftright", String.valueOf(ShowAssist.Assistleftright));
			himoMod.properties.setProperty("Assistspesu", String.valueOf(ShowAssist.Assistspesu));

			himoMod.properties.setProperty("PerunOF", String.valueOf(PerunCD.PerunCDOF));
			himoMod.properties.setProperty("Perunx", String.valueOf(PerunCD.x));
			himoMod.properties.setProperty("Peruny", String.valueOf(PerunCD.y));
			himoMod.properties.setProperty("Perunscale", String.valueOf(PerunCD.scale));
			himoMod.properties.store(new FileOutputStream(himoMod.propertiesFile), "Dont change it!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}



}
