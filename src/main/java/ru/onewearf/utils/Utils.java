package ru.onewearf.utils;

import cn.nukkit.Player;
import cn.nukkit.level.GameRule;
import cn.nukkit.level.GameRules;
import cn.nukkit.network.protocol.GameRulesChangedPacket;
import cn.nukkit.utils.Config;
import ru.onewearf.Loader;

import java.io.File;

public class Utils {

    private final Loader loader;
    private final Config config;

    public Utils(Loader loader){
        this.loader = loader;
        this.config = new Config(new File(this.loader.getDataFolder(), "/resources/message.yml"), Config.YAML);
    }

    public void createConfig(){
        this.add("command.message.description", "hide or show coordinates");
        this.add("command.message.usage", "/coordinates show/hide");
        this.add("command.message.invalid", "Invalid command. Usage: ");
        this.add("command.message.hide", "You have successfully hidden the coordinates");
        this.add("command.message.enable", "You have successfully enabled the coordinates");
    }

    public String getDescription(){
        return this.config.getString("command.message.description");
    }

    public String getUsage(){
        return this.config.getString("command.message.usage");
    }

    public String getInvalid(){
        return this.config.getString("command.message.invalid");
    }

    public String getHide(){
        return this.config.getString("command.message.hide");
    }

    public String getEnable(){
        return this.config.getString("command.message.enable");
    }

    public void add(String config, Object object) {
        if (this.config.get(config) == null) {
            this.config.set(config, object);
            this.config.save();
        }
    }

    public void setCoordinates(Player player, boolean enable) {
        GameRulesChangedPacket packet = new GameRulesChangedPacket();

        GameRules levelGameRules = player.getLevel().getGameRules();
        GameRules gameRules = GameRules.getDefault();
        gameRules.readNBT(levelGameRules.writeNBT());
        gameRules.setGameRule(GameRule.SHOW_COORDINATES, enable);
        packet.gameRules = gameRules;

        player.dataPacket(packet);
    }
}
