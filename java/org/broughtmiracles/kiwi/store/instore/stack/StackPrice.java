package org.broughtmiracles.kiwi.store.instore.stack;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class StackPrice {

    @Getter
    private final Map<Material, Integer> itemPrices = new HashMap<Material, Integer>();

    public void setPrice(@NonNull Material material, int itemCost) {
        itemPrices.put(material, itemCost);
    }

    public Integer getPrice(@NonNull Material material) {
        return itemPrices.get(material);
    }


}
