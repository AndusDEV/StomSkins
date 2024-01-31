package dev.andus.stomskins.commands;

import dev.andus.stomskins.commands.subcommands.SkinSetCommand;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.permission.Permission;

public class SkinCommand extends Command {
    public SkinCommand() {
        super("skin",  "stomskins");
        //setCondition((sender, commandString) -> sender.hasPermission(new Permission("stomskins.command")));
        addSubcommand(new SkinSetCommand());
    }
}
