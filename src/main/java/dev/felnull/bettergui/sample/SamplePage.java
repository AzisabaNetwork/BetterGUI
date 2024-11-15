package dev.felnull.bettergui.sample;

import dev.felnull.bettergui.core.GUIPage;
import dev.felnull.bettergui.core.InventoryGUI;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class SamplePage extends GUIPage {
    public SamplePage(InventoryGUI gui){
        super(gui, ChatColor.translateAlternateColorCodes('&', "&6Sample"),9*3);
    }

    @Override
    public void setUp(){
        this.setItem(13,new SampleItem(gui));
    }
    @Override
    public void back(){
    }
    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
