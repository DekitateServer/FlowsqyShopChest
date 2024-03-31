package de.epiceric.shopchest.language;

import de.epiceric.shopchest.language.enchantment.EnchantmentNameManager;
import org.jetbrains.annotations.NotNull;

import de.epiceric.shopchest.language.item.ItemNameManager;

public class LanguageManager {

    private final MessageRegistry messageRegistry;
    private final ItemNameManager itemNameManager;
    private final EnchantmentNameManager enchantmentNameManager;

    public LanguageManager(
            @NotNull MessageRegistry messageRegistry,
            @NotNull ItemNameManager localizedItemManager,
            @NotNull EnchantmentNameManager enchantmentNameManager
    ) {
        this.messageRegistry = messageRegistry;
        this.itemNameManager = localizedItemManager;
        this.enchantmentNameManager = enchantmentNameManager;
    }

    @NotNull
    public MessageRegistry getMessageRegistry() {
        return messageRegistry;
    }

    @NotNull
    public ItemNameManager getItemNameManager() {
        return itemNameManager;
    }

    @NotNull
    public EnchantmentNameManager getEnchantmentNameManager() { return enchantmentNameManager; }

}
