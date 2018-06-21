package com.himo.himoMod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.himo.himoMod.AllSettings.AimDisplaySet;
import com.himo.himoMod.AllSettings.KillSoundSet;
import com.himo.himoMod.AllSettings.PerunCDSet;
import com.himo.himoMod.AllSettings.ShowHPSet;
import com.himo.himoMod.AllSettings.ShowKillSet;
import com.himo.himoMod.AllSettings.ShowTeamMateSet;
import com.himo.himoMod.AllSettings.ShowUHCKillsSet;
import com.himo.himoMod.AllSettings.ShowUseHeadSet;
import com.himo.himoMod.GUIS.AimDisplayGUI;
import com.himo.himoMod.GUIS.PerunCDGUI;
import com.himo.himoMod.GUIS.ShowHPGUI;
import com.himo.himoMod.GUIS.ShowKillGUI;
import com.himo.himoMod.GUIS.ShowUHCKillsGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class himoGUI extends GuiScreen {

	private GuiButton buttonKillSound;//KILLサウンドのボタン
	private GuiButton buttonShowUseHead;//ShowUseHeadのボタン
	private GuiButton buttonShowTeamMate;//ShowTeamMateのボタン
	private GuiButton buttonPerunCD1;//PerunCDのONOFFのボタン
	private GuiButton buttonPerunCD2;//PerunCDのPositionのボタン
	private GuiButton buttonShowKill1;//ShowKilのONOFFのボタン
	private GuiButton buttonShowKill2;//ShowKilのPositionのボタン
	private GuiButton buttonShowHP1;//ShowHPのONOFFのボタン
	private GuiButton buttonShowHP2;//ShowHPのPositionのボタン
	private GuiButton buttonAutoKills1;//AutoKillsのONOFFのボタン
	private GuiButton buttonAutoKills2;//AutoKillsのPositionのボタン
	private GuiButton buttonAimDisplay1;//AimDisplayのONOFFのボタン
	private GuiButton buttonAimDisplay2;//AimDisplayのPositionのボタン


	@Override
	public void initGui() {
		buttonKillSound = new GuiButton(0, this.width / 2 - 200, this.height / 2 - 70, 120 , 20,"buttonKillSound");
		buttonShowUseHead = new GuiButton(1, this.width / 2 - 60, this.height / 2 - 70, 120 , 20,"buttonShowUseHead");
		buttonShowTeamMate = new GuiButton(2, this.width / 2 + 80, this.height / 2 - 70, 120 , 20,"buttonShowTeamMate");

		buttonPerunCD1 = new GuiButton(3, this.width / 2 - 200, this.height / 2 - 10, 59 , 20,"buttonPerunCD1");
		buttonPerunCD2 = new GuiButton(4, this.width / 2 - 139, this.height / 2 - 10, 59 , 20,"§bPosition");
		buttonShowKill1 = new GuiButton(5, this.width / 2 - 60, this.height / 2 - 10, 59 , 20,"buttonShowKill1");
		buttonShowKill2 = new GuiButton(6, this.width / 2 + 1, this.height / 2 - 10, 59 , 20,"§bPosition");
		buttonShowHP1 = new GuiButton(7, this.width / 2 + 80, this.height / 2 - 10, 59 , 20,"buttonShowHP1");
		buttonShowHP2 = new GuiButton(8, this.width / 2 + 141, this.height / 2 - 10, 59 , 20,"§bPosition");

		buttonAutoKills1 = new GuiButton(9, this.width / 2 - 200, this.height / 2 + 50, 59 , 20,"buttonAutoKills1");
		buttonAutoKills2 = new GuiButton(10, this.width / 2 - 139, this.height / 2 + 50, 59 , 20,"§bPosition");
		buttonAimDisplay1 = new GuiButton(11, this.width / 2 - 60, this.height / 2 + 50, 59 , 20,"buttonAimDisplay1");
		buttonAimDisplay2 = new GuiButton(12, this.width / 2 + 1, this.height / 2 + 50, 59 , 20,"§bPosition");


		switch(himoMod.killSound) {//killSoundがONだったらONの文字
		case KillSoundSet.OFF:
			buttonKillSound.displayString = "§7OFF";
			break;
		case KillSoundSet.ON:
			buttonKillSound.displayString = "§aON";
			break;
		}

		switch(himoMod.showUseHead) {//showUseHeadがONだったらONの文字
		case ShowUseHeadSet.OFF:
			buttonShowUseHead.displayString = "§7OFF";
			break;
		case ShowUseHeadSet.ON:
			buttonShowUseHead.displayString = "§aON";
			break;
		}
		switch(himoMod.ShowTeamMateOF) {//ShowTeamMateOFがONだったらONの文字
		case ShowTeamMateSet.OFF:
			buttonShowTeamMate.displayString = "§7OFF";
			break;
		case ShowTeamMateSet.ON:
			buttonShowTeamMate.displayString = "§aON";
			break;
		}
		switch(ShowHP.ShowHPOF) {//ShowHPOFがONだったらONの文字
		case ShowHPSet.OFF:
			buttonShowHP1.displayString = "§7OFF";
			break;
		case ShowHPSet.ON:
			buttonShowHP1.displayString = "§aON";
			break;
		}
		switch(ShowKill.ShowKillOF) {//ShowKillOFがONだったらONの文字
		case ShowKillSet.OFF:
			buttonShowKill1.displayString = "§7OFF";
			break;
		case ShowKillSet.ON:
			buttonShowKill1.displayString = "§aON";
			break;
		}
		switch(PerunCD.PerunCDOF) {//PerunCDOFがONだったらONの文字
		case PerunCDSet.OFF:
			buttonPerunCD1.displayString = "§7OFF";
			break;
		case PerunCDSet.ON:
			buttonPerunCD1.displayString = "§aON";
			break;
		}
		switch(ShowUHCKills.ShowUHCKillsOF) {//ShowUHCKillsOFがONだったらONの文字
		case ShowUHCKillsSet.OFF:
			buttonAimDisplay1.displayString = "§7OFF";
			break;
		case ShowUHCKillsSet.ON:
			buttonAimDisplay1.displayString = "§aON";
			break;
		}
		switch(AimDisplay.AimDisplayOF) {//AimDisplayOFがONだったらONの文字
		case AimDisplaySet.OFF:
			buttonAutoKills1.displayString = "§7OFF";
			break;
		case AimDisplaySet.ON:
			buttonAutoKills1.displayString = "§aON";
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
		//ONだったらOFF、OFFだったらON
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
		if(button.id == 2) {
			switch(himoMod.ShowTeamMateOF) {
				case ShowTeamMateSet.OFF:
					buttonShowTeamMate.displayString = "§aON";
					himoMod.ShowTeamMateOF = ShowTeamMateSet.ON;
					break;
				case ShowTeamMateSet.ON:
					buttonShowTeamMate.displayString = "§7OFF";
					himoMod.ShowTeamMateOF = ShowTeamMateSet.OFF;
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
		if(button.id == 9) {
			switch(ShowUHCKills.ShowUHCKillsOF) {
			case ShowUHCKillsSet.OFF:
				buttonAutoKills1.displayString = "§aON";
				ShowUHCKills.ShowUHCKillsOF = ShowUHCKillsSet.ON;
				break;
			case ShowUHCKillsSet.ON:
				buttonAutoKills1.displayString = "§7OFF";
				ShowUHCKills.ShowUHCKillsOF = ShowUHCKillsSet.OFF;
				break;
			}
		}
		if(button.id == 10) {
			new ShowUHCKillsGUI().display();
		}
		if(button.id == 11) {
			switch(AimDisplay.AimDisplayOF) {
			case AimDisplaySet.OFF:
				buttonAimDisplay1.displayString = "§aON";
				AimDisplay.AimDisplayOF = AimDisplaySet.ON;
				break;
			case AimDisplaySet.ON:
				buttonAimDisplay1.displayString = "§7OFF";
				AimDisplay.AimDisplayOF = AimDisplaySet.OFF;
				break;
			}
		}
		if(button.id == 12) {
			new AimDisplayGUI().display();
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
			himoMod.properties.setProperty("ShowTeamMateOF", String.valueOf(himoMod.ShowTeamMateOF));
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

			himoMod.properties.setProperty("AimOF", String.valueOf(AimDisplay.AimDisplayOF));
			himoMod.properties.setProperty("Aimtopc", String.valueOf(AimDisplay.topcenter));
			himoMod.properties.setProperty("Aimx", String.valueOf(AimDisplay.x));
			himoMod.properties.setProperty("Aimy", String.valueOf(AimDisplay.y));
			himoMod.properties.setProperty("Aimscale", String.valueOf(AimDisplay.scale));

			himoMod.properties.setProperty("uhckillsOF", String.valueOf(ShowUHCKills.ShowUHCKillsOF));
			himoMod.properties.setProperty("uhckillsx", String.valueOf(ShowUHCKills.x));
			himoMod.properties.setProperty("uhckillsy", String.valueOf(ShowUHCKills.y));
			himoMod.properties.setProperty("uhckillslr", String.valueOf(ShowUHCKills.leftorright));

			himoMod.properties.store(new FileOutputStream(himoMod.propertiesFile), "Dont change it!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}



}
