package com.tooze.tabensions

import me.clip.placeholderapi.expansion.PlaceholderExpansion

class TabensionsExpansion : PlaceholderExpansion() {
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
