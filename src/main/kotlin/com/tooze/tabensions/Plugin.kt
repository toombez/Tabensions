package com.tooze.tabensions

import org.bukkit.Bukkit
import org.bukkit.World.Environment
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {
    public val char: String
        get() = config.getString("dimensionChar").toString()
    val colors: MutableMap<Environment, String>
        get() {
            val map: MutableMap<Environment, String> = mutableMapOf()

            for (environment in Environment.values()) {
                val colorCode = config.getString("colors.${environment}")!!
                map[environment] = colorCode

                logger.warning(colorCode)
            }

            return map
        }

    private val ignoredWorlds: MutableList<String>
        get() {
            val list = mutableListOf<String>()

            for (worldName in config.getStringList("ignoredWorlds")) {
                list += worldName

                logger.warning(worldName)
            }

            return list
        }

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
