package com.himo.himoMod.GUIS;

import java.io.IOException;

import com.himo.himoMod.AimDisplay;
import com.himo.himoMod.himoGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AimDisplayGUI extends GuiScreen {
	private GuiButton purasu;
	private GuiButton mainasu;
	private GuiButton hyaku;
	private GuiButton zero;
	private GuiButton top;
	public static boolean aguiopen = false;

	@Override
	public void initGui() {
		mainasu = new GuiButton(0, this.width / 2 - 22, this.height / 2 + 10, 20 , 20,"-");
		purasu = new GuiButton(1, this.width / 2 + 2, this.height / 2 + 10, 20 , 20,"+");
		hyaku = new GuiButton(2, this.width / 2 - 22, this.height / 2 - 10, 20 , 20,"§e100");
		zero = new GuiButton(3, this.width / 2 + 2, this.height / 2 - 10, 20 , 20,"§f0");
		top = new GuiButton(4, this.width / 2 - 22, this.height / 2 - 30, 44 , 20,"Top center");
		aguiopen = true;
		addButtons();
	}

	public void addButtons() {
		buttonList.add(purasu);
		buttonList.add(mainasu);
		buttonList.add(hyaku);
		buttonList.add(zero);
		buttonList.add(top);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Minecraft.getMinecraft().fontRendererObj.drawString("", this.width / 2 - 155, this.height / 2 - 85, 0xffffffff, true);
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
		aguiopen = false;
		super.onGuiClosed();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 0) AimDisplay.scale = AimDisplay.scale - 0.1;
		if(button.id == 1) AimDisplay.scale = AimDisplay.scale + 0.1;
		if(button.id == 2) AimDisplay.byougamozi = "100";
		if(button.id == 3) AimDisplay.byougamozi = "0";
		if(button.id == 4) {
			AimDisplay.topcenter = 1;
			AimDisplay.y = 0;
		}

	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (this.width / 2 - 22 < mouseX && mouseX < this.width / 2 + 22 && this.height / 2 - 30 < mouseY && mouseY < this.height / 2 + 30) {//クリックした位置がボタンにかぶってなかったら
		} else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("座標OK"));
			AimDisplay.topcenter = 0;
			AimDisplay.x = (float) (mouseX / AimDisplay.scale);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X" + mouseX));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X" + AimDisplay.x));
			AimDisplay.y = (float) (mouseY / AimDisplay.scale - 4);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Y" + mouseY));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Y" + AimDisplay.y));
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
