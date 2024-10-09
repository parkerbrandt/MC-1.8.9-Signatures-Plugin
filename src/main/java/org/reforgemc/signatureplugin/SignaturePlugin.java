package org.reforgemc.signatureplugin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Class for the 1.8.9 Signatures Plugin
 *
 * @author Lucentus
 */
public final class SignaturePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting Item Signatures Plugin...");

        // TODO: Need to check if the items file has already been modified
        getLogger().info("Checking items file for signature compatibility");

        try {

        } catch (Exception ex) {

        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
