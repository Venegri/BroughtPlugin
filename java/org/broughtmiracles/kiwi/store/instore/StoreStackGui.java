package org.broughtmiracles.kiwi.store.instore;


import org.broughtmiracles.kiwi.store.instore.stack.StackFunction;
import org.bukkit.entity.Player;

public class StoreStackGui {

    public StoreStack storeStack;

    public StoreStack getStoreStack() {
        return storeStack;
    }

    public StoreStack setStoreStack(StoreStack storeStack) {
        this.storeStack = storeStack;
        return storeStack;
    }


    public void storeStackGuiCreate(StoreStack storeStack, Player player) {
        switch (storeStack) {
            case FOOD -> new StackFunction().openFoodInventory(player);
            case ORES -> new StackFunction().openOreInventory(player);
            case BUILD -> new StackFunction().openBuildInventory(player);

        }

    }


}
