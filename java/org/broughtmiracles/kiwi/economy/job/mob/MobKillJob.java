package org.broughtmiracles.kiwi.economy.job.mob;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.EntityType;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class MobKillJob {
    @Getter
    private final Map<EntityType, Integer> entityIntegerMapDeath = new HashMap<>();

    public void setEntityCost(@NonNull EntityType entityType, int entityCost) {
        entityIntegerMapDeath.put(entityType, entityCost);
    }

    public Integer getPrice(@NonNull EntityType entityType) {
        return entityIntegerMapDeath.get(entityType);
    }

}
