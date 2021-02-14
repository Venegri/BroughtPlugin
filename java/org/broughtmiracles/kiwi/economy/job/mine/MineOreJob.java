package org.broughtmiracles.kiwi.economy.job.mine;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class MineOreJob {
    @Getter
    private final Map<Material, Integer> blockIntegerMapDeath = new HashMap<>();

    public void setOreCost(@NonNull Material material, int blockCost) {
        blockIntegerMapDeath.put(material, blockCost);
    }

    public Integer getPrice(@NonNull Material material) {
        return blockIntegerMapDeath.get(material);
    }


}
