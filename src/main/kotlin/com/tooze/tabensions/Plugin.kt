package com.tooze.tabensions

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {
    override fun onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") === null) {
            logger.warning("Cannot find PlaceholderAPI plugin. Disabling plugin.")

            Bukkit.getPluginManager().disablePlugin(this)
        } else {
            TabensionsExpansion(this).register()
        }

        saveDefaultConfig()
    }

    override fun onDisable() {
    }
}
