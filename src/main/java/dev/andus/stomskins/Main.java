package dev.andus.stomskins;

import dev.andus.stomskins.commands.SkinCommand;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.PlayerSkin;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerSkinInitEvent;
import net.minestom.server.extensions.Extension;

public class Main extends Extension {
    @Override
    public void initialize() {
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(PlayerSkinInitEvent.class, event -> {
            PlayerSkin skin = PlayerSkin.fromUsername(event.getPlayer().getUsername());
            event.setSkin(skin);
        });
        registerCommands();
    }

    @Override
    public void terminate() {

    }

    private void registerCommands() {
        MinecraftServer.getCommandManager().register(new SkinCommand());
    }
}