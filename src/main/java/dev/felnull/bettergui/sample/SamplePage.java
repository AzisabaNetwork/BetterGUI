package dev.felnull.bettergui.sample;

import dev.felnull.bettergui.GUIPage;
import dev.felnull.bettergui.InventoryGUI;
import org.bukkit.ChatColor;

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
}
