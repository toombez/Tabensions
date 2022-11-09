package com.tooze.tabensions

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer

class TabensionsExpansion(private val plugin: Plugin) : PlaceholderExpansion() {
    override fun getAuthor(): String {
        return "toombez"
    }

    override fun getIdentifier(): String {
        return "tabensions"
    }

    override fun getVersion(): String {
        return plugin.description.version
    }

    override fun onRequest(p: OfflinePlayer?, params: String): String? {
        // Dimension placeholder
        if (params.equals("dimension", true)) {
            if (p === null || p.player === null || !p.player!!.isOnline) {
                return null
            }

            // Check ignored worlds
            val world = p.player!!.world
            if (plugin.ignoredWorlds.contains(world.name)) {
                return ""
            }

            // Placeholder
            val environment = world.environment
            val char = plugin.char
            val charCode = plugin.colors[environment]!!
            return ChatColor.translateAlternateColorCodes('§', "${charCode}${char}")
        }

        return null
    }
}
