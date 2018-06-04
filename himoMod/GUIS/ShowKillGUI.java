package com.himo.himoMod.GUIS;

import java.io.IOException;

import com.himo.himoMod.ShowKill;
import com.himo.himoMod.himoGUI;
import com.himo.himoMod.AllSettings.ShowKillSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ShowKillGUI extends GuiScreen {

	private GuiButton left_right1;
	private GuiButton left_right2;
	private GuiButton big_small1;
	private GuiButton big_small2;
	private GuiButton spesu1;
	private GuiButton spesu2;
	private GuiButton AssistKill;

	@Override
	public void initGui() {
		big_small1 = new GuiButton(0, this.width / 2 - 200, this.height / 2 + 70, 60 , 20,"BIG");
		big_small2 = new GuiButton(1, this.width / 2 - 140, this.height / 2 + 70, 60 , 20,"SMALL");
		left_right1 = new GuiButton(2, this.width / 2 - 60, this.height / 2 + 70, 60 , 20,"LEFT");
		left_right2 = new GuiButton(3, this.width / 2, this.height / 2 + 70, 60 , 20,"RIGHT");
		spesu1 = new GuiButton(4, this.width / 2 + 80, this.height / 2 + 70, 60 , 20,"-");
		spesu2 = new GuiButton(5, this.width / 2 + 140, this.height / 2 + 70, 60 , 20,"+");
		AssistKill = new GuiButton(6, this.width / 2, this.height / 2 + 50, 60 , 20,"ShowAssistGUI");

		switch(ShowKill.Killbigsmall) {
		case ShowKillSet.Killbig:
			big_small1.displayString = "§l§n§aBIG";
			big_small2.displayString = "§7SMALL";
			break;
		case ShowKillSet.Killsmall:
			big_small1.displayString = "§7BIG";
			big_small2.displayString = "§l§n§aSMALL";
			break;
		}
		switch(ShowKill.Killleftright) {
		case ShowKillSet.Killleft:
			left_right1.displayString = "§l§n§aLEFT";
			left_right2.displayString = "§7SRIGHT";
			break;
		case ShowKillSet.Killright:
			left_right1.displayString = "§7LEFT";
			left_right2.displayString = "§l§n§aSRIGHT";
			break;
		}

		addButtons();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Minecraft.getMinecraft().fontRendererObj.drawString("" + ShowKill.Killspesu, this.width / 2 - 155, this.height / 2 - 85, 0xffffffff, true);
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
		himoGUI.saveConfig();
		super.onGuiClosed();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 0) {
			ShowKill.Killbigsmall = ShowKillSet.Killbig;
			big_small1.displayString = "§l§n§aBIG";
			big_small2.displayString = "§7SMALL";
			ShowKill.playShowKillGUI();
		}
		if(button.id == 1) {
			ShowKill.Killbigsmall = ShowKillSet.Killsmall;
			big_small1.displayString = "§7BIG";
			big_small2.displayString = "§l§n§aSMALL";
			ShowKill.playShowKillGUI();
		}
		if(button.id == 2) {
			ShowKill.Killleftright = ShowKillSet.Killleft;
			left_right1.displayString = "§l§n§aLEFT";
			left_right2.displayString = "§7SRIGHT";
			ShowKill.playShowKillGUI();
		}
		if(button.id == 3) {
			ShowKill.Killleftright = ShowKillSet.Killright;
			left_right1.displayString = "§7LEFT";
			left_right2.displayString = "§l§n§aSRIGHT";
			ShowKill.playShowKillGUI();
		}
		if(button.id == 4) {
			if (ShowKill.Killspesu != 0) {
			ShowKill.Killspesu = ShowKill.Killspesu - 1;
			}
			ShowKill.playShowKillGUI();
		}
		if(button.id == 5) {
			if (ShowKill.Killspesu != 40) {
			ShowKill.Killspesu = ShowKill.Killspesu + 1;
			}
			ShowKill.playShowKillGUI();
		}
		if(button.id == 6) {
			new ShowAssistGUI().display();
		}
	}

	public void addButtons() {
		buttonList.add(big_small1);
		buttonList.add(big_small2);
		buttonList.add(left_right1);
		buttonList.add(left_right2);
		buttonList.add(spesu1);
		buttonList.add(spesu2);
		buttonList.add(AssistKill);
	}
	@Override
	public void updateScreen() {
		super.updateScreen();
	}
}
