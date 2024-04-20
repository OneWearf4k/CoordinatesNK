package ru.onewearf;

import cn.nukkit.plugin.PluginBase;
import ru.onewearf.command.CoordinatesCommand;
import ru.onewearf.utils.Utils;

public class Loader extends PluginBase {

    private Utils utils;

    @Override
    public void onEnable() {
        this.utils = new Utils(this);
        this.utils.createConfig();
        getServer().getCommandMap().register("coordinates", new CoordinatesCommand(this));
    }

    public Utils getUtils(){
        return this.utils;
    }
}
