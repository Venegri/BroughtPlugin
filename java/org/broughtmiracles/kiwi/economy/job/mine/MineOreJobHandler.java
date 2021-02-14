package org.broughtmiracles.kiwi.economy.job.mine;


import lombok.experimental.UtilityClass;
import org.broughtmiracles.kiwi.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.sql.SQLException;
import java.util.Arrays;


public class MineOreJobHandler implements Listener {
    @EventHandler
    public void mineEvent(BlockBreakEvent blockBreakEvent) throws SQLException, ClassNotFoundException {
        Material material = blockBreakEvent.getBlock().getType();
        Player player = blockBreakEvent.getPlayer();
        switch (material) {
            case COAL_ORE,
                    REDSTONE_ORE,
                    GOLD_ORE,
                    LAPIS_ORE,
                    DIAMOND_ORE,
                    IRON_ORE,
                    EMERALD_ORE,
                    QUARTZ_ORE,
                    GLOWING_REDSTONE_ORE -> {
                Economy.setBalance(player, Economy.getBalance(player) + MineOreJob.getPrice(material));
                player.sendMessage("Вы вскопали: " + material.name().replace("_", " ")
                        + " и получили за это: "
                        + MineOreJob.getPrice(material)
                + "\nВаш баланс: " + Economy.getBalance(player));

            }

        }
    }

    public void initBlockCost() {
        MineOreJob.setOreCost(Material.COAL_ORE, 150);
        MineOreJob.setOreCost(Material.REDSTONE_ORE, 250);
        MineOreJob.setOreCost(Material.GOLD_ORE, 50);
        MineOreJob.setOreCost(Material.LAPIS_ORE, 350);
        MineOreJob.setOreCost(Material.DIAMOND_ORE, 750);
        MineOreJob.setOreCost(Material.IRON_ORE, 450);
        MineOreJob.setOreCost(Material.EMERALD_ORE, 5000);
        MineOreJob.setOreCost(Material.QUARTZ_ORE, 500);
        MineOreJob.setOreCost(Material.GLOWING_REDSTONE_ORE, 550);
    }
}
