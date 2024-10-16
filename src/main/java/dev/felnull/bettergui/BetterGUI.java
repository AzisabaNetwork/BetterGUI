package dev.felnull.bettergui;

import net.kunmc.lab.ikisugilogger.IkisugiLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterGUI extends JavaPlugin {

    public static BetterGUI plugin;
    @Override
    public void onEnable() {
        plugin = this;
        IkisugiLogger logger = new IkisugiLogger("BetterGUI!");
        logger.setColorType(IkisugiLogger.ColorType.RAINBOW);
        Bukkit.getLogger().info("\n" + logger.create());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(getName() + " disabled.");
    }

    public static BetterGUI getInstance (){
        return plugin;
    }
}
