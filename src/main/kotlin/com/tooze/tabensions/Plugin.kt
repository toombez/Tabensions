package com.tooze.tabensions

import org.bukkit.Bukkit
import org.bukkit.World.Environment
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {
    private lateinit var char: String
    private val colors: MutableMap<Environment, String> = mutableMapOf()
    private val ignoredWorlds: MutableList<String> = mutableListOf()

    override fun onEnable() {
        config.options().copyDefaults()
        saveDefaultConfig()

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") === null) {
            logger.warning("Cannot find PlaceholderAPI plugin. Disabling plugin.")

            Bukkit.getPluginManager().disablePlugin(this)
            return
        }

        loadConfig()

        TabensionsExpansion(this).register()
    }

    override fun onDisable() {
    }

    private fun loadConfig() {
        // Saving char
        char = config.getString("dimensionChar").toString()

        logger.warning(char)

        // Saving colors
        for (environment in Environment.values()) {
            val colorCode = config.getString("colors.${environment}")!!
            colors[environment] = colorCode

            logger.warning(colorCode)
        }

        // Saving ignored worlds
        for (worldName in config.getStringList("ignoredWorlds")) {
            ignoredWorlds += worldName

            logger.warning(worldName)
        }
    }
}
