package org.broughtmiracles.kiwi.store;

import org.broughtmiracles.kiwi.store.instore.stack.database.StackDBUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreBalance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            try {
                Player player = (Player) commandSender;
                int a = StackDBUtil.getBalance(player);
                player.sendMessage("Ваш баланс: " + a);
                return true;
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        return false;
    }
}
