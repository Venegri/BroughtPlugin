package org.broughtmiracles.kiwi.store;

import org.broughtmiracles.kiwi.store.instore.StoreStack;
import org.broughtmiracles.kiwi.store.instore.StoreStackGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class StoreEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        //Check to see if its the GUI menu
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Магазин")){
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            switch (e.getCurrentItem().getType()) {
                case BAKED_POTATO -> new StoreStackGui().storeStackGuiCreate(new StoreStackGui().setStoreStack(StoreStack.FOOD), player);
                case BRICK -> new StoreStackGui().storeStackGuiCreate(new StoreStackGui().setStoreStack(StoreStack.BUILD), player);
                case REDSTONE_ORE -> new StoreStackGui().storeStackGuiCreate(new StoreStackGui().setStoreStack(StoreStack.ORES), player);
                case DIAMOND_SWORD -> new StoreStackGui().storeStackGuiCreate(new StoreStackGui().setStoreStack(StoreStack.COMBAT), player);
            }


            e.setCancelled(true); //So they cant take the items
        }
    }
}
