package org.broughtmiracles.kiwi;

import org.broughtmiracles.kiwi.economy.job.mine.MineOreJobHandler;
import org.broughtmiracles.kiwi.economy.job.mob.MobJobHandler;
import org.broughtmiracles.kiwi.store.StoreBalance;
import org.broughtmiracles.kiwi.store.StoreEvent;
import org.broughtmiracles.kiwi.store.StoreGui;
import org.broughtmiracles.kiwi.store.instore.StoreStackEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class KiwiMain extends JavaPlugin {
    private MobJobHandler jobHandler  = new MobJobHandler();
    private MineOreJobHandler mineOreJobHandler = new MineOreJobHandler();
    @Override
    public void onEnable() {

        getLogger().info("BroughtPlugin start");

        getCommand("helpme").setExecutor(new StoreGui());
        getCommand("balance").setExecutor(new StoreBalance());

        getServer().getPluginManager().registerEvents(new StoreEvent(), this);
        getServer().getPluginManager().registerEvents(new StoreStackEvent(), this);
        getServer().getPluginManager().registerEvents(jobHandler, this);
        getServer().getPluginManager().registerEvents(mineOreJobHandler, this);

        jobHandler.initKillCost();
        mineOreJobHandler.initBlockCost();
        // VkThread.start();

        String folderName = "BroughtPlugin";
        File folder = new File("plugins/" + folderName);
        folder.mkdir();
        if(!folder.exists()) {
            folder.mkdirs();
        }else{
            // Directory already exist
        }
    }
    @Override
    public void onDisable() {
        getLogger().info("BroughtPlugin disable");
    }


}
