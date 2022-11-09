package com.tooze.tabensions

import org.bukkit.Bukkit
import org.bukkit.World.Environment
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {
    val char: String = config.getString("dimensionChar").toString()
    val colors: Map<Environment, String> = Environment
        .values()
        .associateWith { config.getString("colors.${it.toString()}")!! }
    val ignoredWorlds: List<String> = config.getStringList("ignoredWorlds")

    override fun onEnable() {
        config.options().copyDefaults()
        saveDefaultConfig()

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") === null) {
            logger.warning("Cannot find PlaceholderAPI plugin. Disabling plugin.")

            Bukkit.getPluginManager().disablePlugin(this)
            return
        }

        TabensionsExpansion(this).register()
    }

    override fun onDisable() {
    }
}
