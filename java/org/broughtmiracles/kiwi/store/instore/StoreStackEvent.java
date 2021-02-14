package org.broughtmiracles.kiwi.store.instore;

import org.broughtmiracles.kiwi.store.instore.stack.StackFunction;
import org.broughtmiracles.kiwi.store.instore.stack.StackPrice;
import org.broughtmiracles.kiwi.store.instore.stack.database.StackDBUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.SQLException;

import static org.bukkit.Material.EMERALD;

public class StoreStackEvent implements Listener {




    @EventHandler
    public void clickEvent(InventoryClickEvent e) throws SQLException, ClassNotFoundException {
        Player player = (Player) e.getWhoClicked();



        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Магазин руды")) {
            switch (e.getCurrentItem().getType()) {
                case COAL -> calculate(player, Material.COAL);
                case IRON_INGOT -> calculate(player, Material.IRON_INGOT);
                case GOLD_INGOT -> calculate(player, Material.GOLD_INGOT);
                case DIAMOND -> calculate(player, Material.DIAMOND);
                case EMERALD -> calculate(player, EMERALD);
            }

            e.setCancelled(true);
        }
    }
    public void calculate(Player player, Material material) throws SQLException, ClassNotFoundException {
        int amount = StackDBUtil.getBalance(player) - StackPrice.getPrice(material);
        StackDBUtil.buy(player, amount, material);
    }
}
