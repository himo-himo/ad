package com.himo.himoMod.GUIS;

import java.io.IOException;

import com.himo.himoMod.PerunCD;
import com.himo.himoMod.himoGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PerunCDGUI extends GuiScreen {

	private GuiButton purasu;
	private GuiButton mainasu;
	private GuiButton GO;
	private GuiButton roku;
	private static String draw = "§eGO";
	private static boolean pguiopen = false;

	@Override
	public void initGui() {
		mainasu = new GuiButton(0, this.width / 2 - 22, this.height / 2 - 10, 20 , 20,"-");
		purasu = new GuiButton(1, this.width / 2 + 2, this.height / 2 - 10, 20 , 20,"+");
		GO = new GuiButton(2, this.width / 2 - 22, this.height / 2 - 30, 20 , 20,"§eGO");
		roku = new GuiButton(3, this.width / 2 + 2, this.height / 2 - 30, 20 , 20,"§f6");
		pguiopen = true;
		addButtons();
	}

	public static void testPerunCD() {
		if (pguiopen) {
			GlStateManager.enableBlend();
			GlStateManager.scale(PerunCD.scale, PerunCD.scale, PerunCD.scale);
			Minecraft.getMinecraft().fontRendererObj.drawString(draw, PerunCD.x, PerunCD.y, 0xffffffff, true);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
		}
	}

	public void addButtons() {
		buttonList.add(purasu);
		buttonList.add(mainasu);
		buttonList.add(GO);
		buttonList.add(roku);
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
		pguiopen = false;
		super.onGuiClosed();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 0) PerunCD.scale = PerunCD.scale - 0.1;
		if(button.id == 1) PerunCD.scale = PerunCD.scale + 0.1;
		if(button.id == 2) draw = "§eGO";
		if(button.id == 3) draw = "§f6";
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (this.width / 2 - 22 < mouseX && mouseX < this.width / 2 + 22 && this.height / 2 - 30 < mouseY && mouseY < this.height / 2 + 10) {
		} else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("座標OK"));
			PerunCD.x = (float) (mouseX / PerunCD.scale - 2);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X" + mouseX));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X" + PerunCD.x));
			PerunCD.y = (float) (mouseY / PerunCD.scale - 4);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Y" + mouseY));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Y" + PerunCD.y));
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
