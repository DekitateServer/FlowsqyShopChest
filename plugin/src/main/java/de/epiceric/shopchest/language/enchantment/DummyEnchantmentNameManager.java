package de.epiceric.shopchest.language.enchantment;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class DummyEnchantmentNameManager implements EnchantmentNameManager {

    private final static String NOT_CONFIGURED_ENCHANTMENT_NAME = "Not configured";

    @Override
    public @Nullable String getEnchantmentName(@Nullable Enchantment enchantment, int level) {
        if (enchantment == null) {
            return null;
        }
        return NOT_CONFIGURED_ENCHANTMENT_NAME;
    }

    @Override
    public @Nullable String getEnchantmentName(@Nullable Map<Enchantment, Integer> enchantmentMap) {
        if (enchantmentMap == null) {
            return null;
        }
        return NOT_CONFIGURED_ENCHANTMENT_NAME;
    }


}