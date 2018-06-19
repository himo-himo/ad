package com.himo.himoMod.GUIS;

import java.io.IOException;

import com.himo.himoMod.ShowUHCKills;
import com.himo.himoMod.himoGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ShowUHCKillsGUI extends GuiScreen {

	private GuiButton left;
	private GuiButton right;

	public static String[] guiStringp0karap5 = {"RitzChandaU", "furamea", "DevilX", "Refely", "Takly", "himohimo"};
	public static String[] guiintp0karap5 = {"9", "7", "10", "6", "8", "2"};

	@Override
	public void initGui() {
		for(int i=0; i< guiStringp0karap5.length; i++){
			ShowUHCKills.Stringp0karap5[i] = guiStringp0karap5[i];
			ShowUHCKills.intp0karap5[i] = guiintp0karap5[i];
		}
		left = new GuiButton(2, this.width / 2 - 22, this.height / 2 - 30, 40 , 20,"Left");
		right = new GuiButton(3,this.width / 2 - 22, this.height / 2 - 10, 40 , 20,"Right");

		if (ShowUHCKills.leftorright == 0) {
			left.displayString = "§aLeft";
			right.displayString = "§7Right";
		} else if (ShowUHCKills.leftorright == 1){
			left.displayString = "§7Left";
			right.displayString = "§aRight";
		}

		addButtons();
	}

	public void addButtons() {
		buttonList.add(left);
		buttonList.add(right);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
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
		for(int i=0; i< guiStringp0karap5.length; i++){
			ShowUHCKills.Stringp0karap5[i] = "";
			ShowUHCKills.intp0karap5[i] = "";
		}
		super.onGuiClosed();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 2) {
			ShowUHCKills.leftorright = 0;
			left.displayString = "§aLeft";
			right.displayString = "§7Right";
		}
		if(button.id == 3) {
			ShowUHCKills.leftorright = 1;
			left.displayString = "§7Left";
			right.displayString = "§aRight";
		}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (this.width / 2 - 22 < mouseX && mouseX < this.width / 2 + 22 && this.height / 2 - 30 < mouseY && mouseY < this.height / 2 + 10) {
		} else {
			ShowUHCKills.x = mouseX;
			ShowUHCKills.y = mouseY;
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
