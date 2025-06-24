package dev.felnull.bettergui.listener;

import dev.felnull.bettergui.BetterGUI;
import dev.felnull.bettergui.core.GUIItem;
import dev.felnull.bettergui.core.GUIPage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class GUIClickListener implements Listener {
    private final GUIPage page;
    private final BetterGUI plugin = BetterGUI.getInstance();

    public GUIClickListener(GUIPage page){
        this.page = page;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getView().getTopInventory() != page.inventory) return;
        GUIItem item = page.getItem(e.getSlot());
        if(item != null){
            switch (e.getClick()){
                case RIGHT:
                    item.onRightClick(e);
                    item.onClick(e);
                    break;
                case LEFT:
                    item.onLeftClick(e);
                    item.onClick(e);
                    break;
                case MIDDLE:
                    item.onMiddleClick(e);
                    break;
                case DOUBLE_CLICK:
                    item.onDoubleClick(e);
                    break;
                case SHIFT_RIGHT:
                    item.onShiftClick(e);
                    item.onShiftRightClick(e);
                    break;
                case SHIFT_LEFT:
                    item.onShiftClick(e);
                    item.onShiftLeftClick(e);
                    break;
                case DROP:
                    item.onDropClick(e);
                    break;
                case CONTROL_DROP:
                    item.onControlDropClick(e);
                    break;
                case SWAP_OFFHAND:
                    item.onOffhandClick(e);
                    break;
                case NUMBER_KEY:
                    item.onNumberClick(e);
                    break;
                case CREATIVE:
                    item.onCreativeClick(e);
                    break;
            }
        }else {
            ItemStack cursor = e.getCursor();
            page.cursorItem = (cursor != null && cursor.getType() != org.bukkit.Material.AIR) ? cursor.clone() : null;
        }

        switch (e.getClick()){
            case WINDOW_BORDER_RIGHT:
                page.onWindowBorderRightClick(e);
                break;
            case WINDOW_BORDER_LEFT:
                page.onWindowBorderLeftClick(e);
                break;
            case RIGHT:
                if(e.getSlot() == -999){
                    page.onOutsideWindowClick(e);
                    page.onOutsideWindowRightClick(e);
                }
                break;
            case LEFT:
                if(e.getSlot() == -999){
                    page.onOutsideWindowClick(e);
                    page.onOutsideWindowLeftClick(e);
                }
                break;
        }

        e.setCancelled(true);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        if(e.getView().getTopInventory() != page.inventory) return;
        page.close();
    }
}
