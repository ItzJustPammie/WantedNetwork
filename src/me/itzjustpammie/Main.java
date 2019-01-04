package me.itzjustpammie;

import me.itzjustpammie.commands.*;
import me.itzjustpammie.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin implements Listener {
    public ConsoleCommandSender console;
    public FileConfiguration playerData;
    public File data;

    @Override
    public void onEnable() {

        //Register commands
        getCommand("discord").setExecutor(new DiscordCommand());




        console = Bukkit.getServer().getConsoleSender();
        createConfig();
        console.sendMessage("--+---------------+--");
        console.sendMessage("Enabling WantedNetwork...");
        console.sendMessage("Loading all files...");
        console.sendMessage("Enabled WantedNetwork!");
        console.sendMessage("Powered by CakeHosting");
        console.sendMessage("You are using version: " + Utils.Version + " !");
        console.sendMessage("--+---------------+--");
    }


    @Override
    public void onDisable() { //Disconnects the bot when the plugin reloads or server is turned off.
        console.sendMessage("--+---------------+--");
        console.sendMessage("Saving files...");
        console.sendMessage("Disabling WantedNetwork...");
        console.sendMessage("Disabling Discord Bot...");
        console.sendMessage("Disabled WantedNetwork!");
        console.sendMessage("You are using version: " + Utils.Version + " !");
        console.sendMessage("--+---------------+--");
    }

    private void createConfig() {
        saveDefaultConfig();
        data = new File(getDataFolder() + File.separator + "data.yml");
        if (!data.exists()) {
            console.sendMessage("--+---------------+--");
            console.sendMessage("Hey! Thanks for installing!");
            console.sendMessage("Creating data.yml");
            console.sendMessage("Creating messages.yml");
            console.sendMessage("Creating config.yml");
            console.sendMessage("Using config version: " + Utils.ConfigVersion);
            console.sendMessage("Succes! Enabling plugin...");
            console.sendMessage("You are using version: " + Utils.Version);
            console.sendMessage("--+---------------+--");
            this.saveResource("data.yml", false);
        }
        playerData = new YamlConfiguration();
        try {
            playerData.load(data);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void setMessage(String name, String message) {
        File f = new File(getDataFolder() + File.separator + "messages.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        if (!config.isSet(name)) {
            config.set(name, message);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}