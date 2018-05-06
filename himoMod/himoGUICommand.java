package com.himo.himoMod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class himoGUICommand extends CommandBase {

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	/*@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}*/

	@Override
	public String getCommandName() {
		return "himo";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/himo";
	}

	@Override
	public void processCommand(final ICommandSender sender, String[] args) throws CommandException {
		new himoGUI().display();
	}
}
