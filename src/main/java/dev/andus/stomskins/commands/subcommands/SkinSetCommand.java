package dev.andus.stomskins.commands.subcommands;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.entity.Player;
import net.minestom.server.entity.PlayerSkin;
import net.minestom.server.permission.Permission;

public class SkinSetCommand extends Command {
    public SkinSetCommand() {
        super("set");
        //setCondition((sender, commandString) -> sender.hasPermission(new Permission("stomskins.command.set")));
        var usernameplayer = ArgumentType.String("username");
        var usernameskin = ArgumentType.String("skin");
        addSyntax(((sender, context) -> {
            final String player = context.get(usernameplayer);
            final String skin = context.get(usernameskin);
            if (MinecraftServer.getConnectionManager().findPlayer(player).isOnline()) {
                final Player pl = MinecraftServer.getConnectionManager().getPlayer(player);
                pl.setSkin(PlayerSkin.fromUsername(skin));
            }
        }), usernameplayer, usernameskin);
    }
}
