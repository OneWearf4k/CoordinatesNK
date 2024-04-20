package ru.onewearf.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.level.GameRule;

public class CoordinatesCommand extends Command {
    public CoordinatesCommand() {
        super("coordinates", "hide or show coordinates", "/coordinates show/hide");
        this.setAliases(new String[]{"coord"});
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{new CommandParameter("set", CommandParamType.STRING, false)});
        this.commandParameters.put("byString", new CommandParameter[]{new CommandParameter("set", new String[]{"show", "hide"})});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        if (strings.length == 0) {
            commandSender.sendMessage("Invalid command. Usage: " + this.usageMessage);
            return false;
        }

        if (strings[0].equalsIgnoreCase("show")) {
            commandSender.sendMessage("You have successfully hidden the coordinates");
            ((Player) commandSender).getLevel().getGameRules().setGameRule(GameRule.SHOW_COORDINATES, true);
            return false;
        }

        if (strings[0].equalsIgnoreCase("hide")) {
            commandSender.sendMessage("You have successfully enabled the coordinates");
            ((Player) commandSender).getLevel().getGameRules().setGameRule(GameRule.SHOW_COORDINATES, false);
            return false;
        }

        commandSender.sendMessage("Invalid command. Usage: " + this.usageMessage);
        return true;
    }
}