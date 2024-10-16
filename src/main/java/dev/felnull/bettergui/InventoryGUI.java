package dev.felnull.bettergui;

import org.bukkit.entity.Player;

public class InventoryGUI {

    public final Player player;
    public GUIPage currentPage;

    public InventoryGUI(Player player){
        this.player = player;
    }

    public void openPage(GUIPage page){
        this.player.closeInventory();
        page.setUp();
        this.player.openInventory(page.inventory);
        this.currentPage = page;
    }

    public void back(){
        this.currentPage.back();
    }
}
