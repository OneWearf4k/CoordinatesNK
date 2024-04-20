package ru.onewearf;

import cn.nukkit.plugin.PluginBase;
import ru.onewearf.command.CoordinatesCommand;

public class Loader extends PluginBase {

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("coordinates", new CoordinatesCommand());
    }
}
