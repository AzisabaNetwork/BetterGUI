package dev.felnull.bettergui.sample;

import dev.felnull.bettergui.core.GUIItem;
import dev.felnull.bettergui.core.InventoryGUI;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SampleItem extends GUIItem {
    int clicknumber = 0;
    public SampleItem(InventoryGUI gui) {
        super(gui, new ItemStack(Material.DIRT));
        this.setDisplayName("アイテムの名前を指定"+clicknumber);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Loreも変更可能"));
        this.setLore(lore);
    }

    @Override
    public void onClick(InventoryClickEvent e){
        clicknumber++;
        this.setDisplayName("アイテムの名前を指定"+clicknumber);
        gui.currentPage.setItem(e.getSlot(), this);
    }

}
