package org.broughtmiracles.kiwi.store.instore.stack;

import lombok.SneakyThrows;
import org.broughtmiracles.kiwi.store.instore.stack.StackPrice;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class StackFunction {



    private final Inventory foodInventory = Bukkit.createInventory(null, 54, ChatColor.AQUA + "Магазин еды");
    private final Inventory oreInventory = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Магазин руды");
    private final Inventory buildInventory = Bukkit.createInventory(null, 54, ChatColor.AQUA + "Магазин блоков");

    public ItemStack getItemStack(int amount, int durability, Material material, String name, String... lore) {

        ItemStack itemStack = new ItemStack(material, amount, (byte) durability);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


    public void openFoodInventory(Player player) {
        foodInventory.clear();

        Material[] foodMaterials = {

                Material.COOKED_FISH,
                Material.RAW_FISH,
                Material.RABBIT_FOOT,
                // ...
        };

        int slotCounter = 0;
        for (Material material : foodMaterials) {

            foodInventory.setItem(slotCounter, getItemStack(1, 0, material, material.name(), "Стоимость"));

            slotCounter++;
        }

        player.openInventory(foodInventory);
    }

    public void openOreInventory(Player player) {
        oreInventory.clear();
        initStacks(player);

        Material[] oreMaterials = {

                Material.COAL,
                Material.AIR,
                Material.IRON_INGOT,
                Material.AIR,
                Material.GOLD_INGOT,
                Material.AIR,
                Material.DIAMOND,
                Material.AIR,
                Material.EMERALD
                // ...
        };



        int slotCounter = 0;
        for (Material material : oreMaterials) {

            if (material.equals(Material.AIR)) {
                oreInventory.setItem(slotCounter, new ItemStack(material));
            } else {
                oreInventory.setItem(slotCounter, getItemStack(1, 0, material,
                        ChatColor.GREEN + material.name().toLowerCase().replace("_", " "),
                        "§7Стоимость: §e" + StackPrice.getPrice(material)));
            }
            slotCounter++;
        }

        player.openInventory(oreInventory);
    }

    public void openBuildInventory(Player player) {
        buildInventory.clear();


        Material[] buildMaterials = {

        };



        int slotCounter = 0;
        for (Material material : buildMaterials) {

            buildInventory.setItem(slotCounter, getItemStack(1, 0, material,
                    ChatColor.GREEN + material.name().toLowerCase().replace("_", " "),
                    "§7Стоимость: §e" + StackPrice.getPrice(material)));

            slotCounter++;
        }

        player.openInventory(buildInventory);
    }

    public void initStacks(Player player) {
        // ORE
        StackPrice.setPrice(Material.COAL, 150);
        StackPrice.setPrice(Material.IRON_INGOT, 350);
        StackPrice.setPrice(Material.GOLD_INGOT, 350);
        StackPrice.setPrice(Material.DIAMOND, 1500);
        StackPrice.setPrice(Material.EMERALD, 5000);
        //ORE
    }


}