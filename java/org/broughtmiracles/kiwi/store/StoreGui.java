package org.broughtmiracles.kiwi.store;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StoreGui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Магазин");

            ItemStack food = new ItemStack(Material.BAKED_POTATO);
            ItemStack build = new ItemStack(Material.BRICK);
            ItemStack ore  = new ItemStack(Material.REDSTONE_ORE);
            ItemStack combat = new ItemStack(Material.DIAMOND_SWORD);


            ItemMeta foodMeta = food.getItemMeta();
            foodMeta.setDisplayName("Магазин еды");
            ArrayList<String> foodLore = new ArrayList<>();
            foodLore.add(ChatColor.AQUA + "Здесь вы можете купить еду");
            foodMeta.setLore(foodLore);
            food.setItemMeta(foodMeta);

            ItemMeta buildMeta = build.getItemMeta();
            buildMeta.setDisplayName("Магазин блоков");
            ArrayList<String> buildLore = new ArrayList<>();
            buildLore.add(ChatColor.AQUA + "Здесь вы можете купить строительные блоки");
            buildMeta.setLore(buildLore);
            build.setItemMeta(buildMeta);

            ItemMeta oreMeta = ore.getItemMeta();
            oreMeta.setDisplayName("Магазин руд");
            ArrayList<String> oreLore = new ArrayList<>();
            oreLore.add(ChatColor.AQUA + "Здесь вы можете купить руду");
            oreMeta.setLore(oreLore);
            ore.setItemMeta(oreMeta);

            ItemMeta combatMeta = combat.getItemMeta();
            combatMeta.setDisplayName("Магазин пвп");
            ArrayList<String> combatLore = new ArrayList<>();
            combatLore.add(ChatColor.RED + "Здесь вы можете купить материалы для пвп");
            combatMeta.setLore(combatLore);
            combat.setItemMeta(combatMeta);


            //Кладем в "инвентарь"
            ItemStack[] menu_items = {food, build, ore, combat};
            gui.setContents(menu_items);
            player.openInventory(gui);

        }


        return true;
    }
}
