package com.himo.himoMod.GUIS;

import java.io.IOException;

import com.himo.himoMod.ShowHP;
import com.himo.himoMod.himoGUI;
import com.himo.himoMod.AllSettings.ShowHPSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ShowHPGUI extends GuiScreen {

	private GuiButton left_right1;
	private GuiButton left_right2;
	private GuiButton big_small1;
	private GuiButton big_small2;
	private GuiButton spesu1;
	private GuiButton spesu2;

	@Override
	public void initGui() {
		big_small1 = new GuiButton(0, this.width / 2 - 200, this.height / 2 + 70, 60 , 20,"BIG");
		big_small2 = new GuiButton(1, this.width / 2 - 140, this.height / 2 + 70, 60 , 20,"SMALL");
		left_right1 = new GuiButton(2, this.width / 2 - 60, this.height / 2 + 70, 60 , 20,"LEFT");
		left_right2 = new GuiButton(3, this.width / 2, this.height / 2 + 70, 60 , 20,"RIGHT");
		spesu1 = new GuiButton(4, this.width / 2 + 80, this.height / 2 + 70, 60 , 20,"-");
		spesu2 = new GuiButton(5, this.width / 2 + 140, this.height / 2 + 70, 60 , 20,"+");

		switch(ShowHP.HPbigsmall) {
		case ShowHPSet.HPbig:
			big_small1.displayString = "§l§n§aBIG";
			big_small2.displayString = "§7SMALL";
			break;
		case ShowHPSet.HPsmall:
			big_small1.displayString = "§7BIG";
			big_small2.displayString = "§l§n§aSMALL";
			break;
		}
		switch(ShowHP.HPleftright) {
		case ShowHPSet.HPleft:
			left_right1.displayString = "§l§n§aLEFT";
			left_right2.displayString = "§7SRIGHT";
			break;
		case ShowHPSet.HPright:
			left_right1.displayString = "§7LEFT";
			left_right2.displayString = "§l§n§aSRIGHT";
			break;
		}



		addButtons();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Minecraft.getMinecraft().fontRendererObj.drawString("" + ShowHP.HPspesu, this.width / 2 - 155, this.height / 2 - 85, 0xffffffff, true);
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
			ShowHP.HPbigsmall = ShowHPSet.HPbig;
			big_small1.displayString = "§l§n§aBIG";
			big_small2.displayString = "§7SMALL";
			ShowHP.playShowHP(19, "19");
		}
		if(button.id == 1) {
			ShowHP.HPbigsmall = ShowHPSet.HPsmall;
			big_small1.displayString = "§7BIG";
			big_small2.displayString = "§l§n§aSMALL";
			ShowHP.playShowHP(19, "19");
		}
		if(button.id == 2) {
			ShowHP.HPleftright = ShowHPSet.HPleft;
			left_right1.displayString = "§l§n§aLEFT";
			left_right2.displayString = "§7SRIGHT";
			ShowHP.playShowHP(19, "19");
		}
		if(button.id == 3) {
			ShowHP.HPleftright = ShowHPSet.HPright;
			left_right1.displayString = "§7LEFT";
			left_right2.displayString = "§l§n§aSRIGHT";
			ShowHP.playShowHP(19, "19");
		}
		if(button.id == 4) {
			if (ShowHP.HPspesu != 0) {
			ShowHP.HPspesu = ShowHP.HPspesu - 1;
			}
			ShowHP.playShowHP(19, "19");
		}
		if(button.id == 5) {
			if (ShowHP.HPspesu != 40) {
			ShowHP.HPspesu = ShowHP.HPspesu + 1;
			}
			ShowHP.playShowHP(19, "19");
		}
	}

	public void addButtons() {
		buttonList.add(big_small1);
		buttonList.add(big_small2);
		buttonList.add(left_right1);
		buttonList.add(left_right2);
		buttonList.add(spesu1);
		buttonList.add(spesu2);
	}
	@Override
	public void updateScreen() {
		super.updateScreen();
	}
}
