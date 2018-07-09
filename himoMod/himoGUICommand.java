package com.himo.himoMod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class himoGUICommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "himo";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "&cUsage: /himo <args>";
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public void processCommand(final ICommandSender sender, String[] args) throws CommandException {
		if (args.length == 0) new himoGUI().display();
		if (args.length == 1) {
			new ShowUHCKills();
			ShowUHCKills.uhckillshyouzi(args[0]);
			new ShowTeamMate();
			ShowTeamMate.playShowTeamMate(args[0]);
		}
	}
}
