package dev.felnull.bettergui.core;

import dev.felnull.bettergui.BetterGUI;
import dev.felnull.bettergui.listener.GUIClickListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class GUIPage {
    private final BetterGUI plugin = BetterGUI.getInstance();
    public InventoryGUI gui;
    public Inventory inventory;
    public GUIClickListener listener;
    private HashMap<Integer, GUIItem> items = new HashMap<>();

    public GUIPage(InventoryGUI gui, String name, int size) {
        inventory = Bukkit.createInventory(null, size, name);
        this.gui = gui;
        listener = new GUIClickListener(this);
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    public abstract void setUp();

    public abstract void back();

    public void setItem(int slot, GUIItem item) {
        items.put(slot, item);
        inventory.setItem(slot, item.itemStack);
    }

    public void setItem(int slot, ItemStack item) {
        inventory.setItem(slot, item);
    }

    public GUIItem getItem(int slot) {
        return items.get(slot);
    }

    public ItemStack getItemStack(int slot){
        return items.get(slot).itemStack;
    }

    public void close(){
        HandlerList.unregisterAll(listener);
    }
}
