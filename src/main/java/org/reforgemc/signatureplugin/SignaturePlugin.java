package org.reforgemc.signatureplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * Main Class for the 1.8.9 Signatures Plugin
 *
 * @author Lucentus
 */
public final class SignaturePlugin extends JavaPlugin {

    // Class Properties
    private static final ArrayList<Material> VALID_SIGN_TOOLS = new ArrayList<>(
            Arrays.asList(
                    Material.DIAMOND_SWORD,
                    Material.DIAMOND_PICKAXE,
                    Material.DIAMOND_AXE,
                    Material.DIAMOND_SPADE,
                    Material.IRON_SWORD,
                    Material.IRON_PICKAXE,
                    Material.IRON_AXE,
                    Material.IRON_SPADE,
                    Material.GOLD_SWORD,
                    Material.GOLD_PICKAXE,
                    Material.GOLD_AXE,
                    Material.GOLD_SPADE,
                    Material.STONE_SWORD,
                    Material.STONE_PICKAXE,
                    Material.STONE_AXE,
                    Material.STONE_SPADE,
                    Material.WOOD_SWORD,
                    Material.WOOD_PICKAXE,
                    Material.WOOD_AXE,
                    Material.WOOD_SPADE
            ));

    private static final ArrayList<Material> VALID_SIGN_ARMOR = new ArrayList<>(
            Arrays.asList(
                    Material.DIAMOND_HELMET,
                    Material.DIAMOND_CHESTPLATE,
                    Material.DIAMOND_LEGGINGS,
                    Material.DIAMOND_BOOTS,
                    Material.IRON_HELMET,
                    Material.IRON_CHESTPLATE,
                    Material.IRON_LEGGINGS,
                    Material.IRON_BOOTS,
                    Material.GOLD_HELMET,
                    Material.GOLD_CHESTPLATE,
                    Material.GOLD_LEGGINGS,
                    Material.GOLD_BOOTS,
                    Material.CHAINMAIL_HELMET,
                    Material.CHAINMAIL_CHESTPLATE,
                    Material.CHAINMAIL_LEGGINGS,
                    Material.CHAINMAIL_BOOTS,
                    Material.LEATHER_HELMET,
                    Material.LEATHER_CHESTPLATE,
                    Material.LEATHER_LEGGINGS,
                    Material.LEATHER_BOOTS
            ));

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting Item Signatures Plugin...");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // Check if the user did '/signature'
        if (command.getName().equalsIgnoreCase("signature")) {

            // Get the item that the commandSender is hovering over
            Player player = (Player) commandSender;
            PlayerInventory inv = player.getInventory();
            ItemStack item = inv.getItemInHand();


            // Check what item the player is holding and if it is valid
            if (VALID_SIGN_TOOLS.contains(item.getType()) || VALID_SIGN_ARMOR.contains(item.getType())) {
                // Held item is valid
                // Check if the item has already been signed (lore exists on the item)
                ItemMeta meta = item.getItemMeta();
                if (!meta.hasLore()) {
                    // Can sign the item
                    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                    ArrayList<String> signature = new ArrayList<>(Arrays.asList(player.getDisplayName(), date));
                    meta.setLore(signature);
                } else {
                    return false;
                }

            } else {
                // Held item is invalid
                return false;
            }

            return true;
        }

        return false;
    }
}
