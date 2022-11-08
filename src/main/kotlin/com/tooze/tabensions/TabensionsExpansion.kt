package com.tooze.tabensions

import me.clip.placeholderapi.expansion.PlaceholderExpansion

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
}
