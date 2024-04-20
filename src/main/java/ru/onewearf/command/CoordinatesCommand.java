package ru.onewearf.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import ru.onewearf.Loader;

public class CoordinatesCommand extends Command {
    private final Loader loader;

    public CoordinatesCommand(Loader loader) {
        super("coordinates", loader.getUtils().getDescription(), loader.getUtils().getUsage());
        this.loader = loader;
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
            commandSender.sendMessage(this.loader.getUtils().getInvalid() + this.usageMessage);
            return false;
        }

        if (strings[0].equalsIgnoreCase("show")) {
            commandSender.sendMessage(this.loader.getUtils().getHide());
            this.loader.getUtils().setCoordinates((Player) commandSender, true);
            return false;
        }

        if (strings[0].equalsIgnoreCase("hide")) {
            commandSender.sendMessage(this.loader.getUtils().getEnable());
            this.loader.getUtils().setCoordinates((Player) commandSender, false);
            return false;
        }

        commandSender.sendMessage(this.loader.getUtils().getInvalid() + this.usageMessage);
        return true;
    }
}