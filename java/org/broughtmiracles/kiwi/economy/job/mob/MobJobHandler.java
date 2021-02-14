package org.broughtmiracles.kiwi.economy.job.mob;

import org.broughtmiracles.kiwi.economy.Economy;
import org.broughtmiracles.kiwi.store.instore.stack.database.StackDBUtil;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.sql.SQLException;

public class MobJobHandler implements Listener {



    /**
    * Здесь будет убийства мобов = получение денег
    * В зависимости от типа моба(крипер итд) можно получить разную сумму
    */
    @EventHandler
    public void mobKillEvent(EntityDeathEvent event) throws SQLException, ClassNotFoundException {
        Entity deader = event.getEntity();
        //Killer Mob
        Entity killer = event.getEntity().getKiller();
        Player player = (Player) killer;

        if (killer instanceof Player) {
            if (deader instanceof Zombie || deader instanceof PigZombie || deader instanceof Creeper) {
                Economy.killSetBalance(player, MobKillJob.getPrice(event.getEntity().getType()), deader);
            }
        }

    }

    public void initKillCost() {
        MobKillJob.setEntityCost(EntityType.ZOMBIE, 500);
        MobKillJob.setEntityCost(EntityType.CREEPER, 500);
        MobKillJob.setEntityCost(EntityType.PIG_ZOMBIE, 2500);
    }


}
