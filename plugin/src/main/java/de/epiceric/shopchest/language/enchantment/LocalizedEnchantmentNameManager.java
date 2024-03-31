package de.epiceric.shopchest.language.enchantment;

import de.epiceric.shopchest.ShopChest;
import de.epiceric.shopchest.language.EnchantmentName;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;

public class LocalizedEnchantmentNameManager implements EnchantmentNameManager {

    private final static String ERROR_ENCHANTMENT_NAME = "ERROR";

    private final Map<String, String> enchantmentTranslations;

    public LocalizedEnchantmentNameManager(@NotNull Map<String, String> enchantmentTranslations) {
        this.enchantmentTranslations = enchantmentTranslations;
    }

    @Override
    @Nullable
    public String getEnchantmentName(@Nullable Enchantment enchantment, int level) {
        if (enchantment == null) {
            return null;
        }
        String levelString = getCached("enchantment.level." + level);
        String enchantmentString = getCached("enchantment.minecraft." + enchantment.getKey().getKey());

        return enchantmentString + " " + levelString;
    }

    @Override
    @Nullable
    public String getEnchantmentName(@Nullable Map<Enchantment, Integer> enchantmentMap) {
        if (enchantmentMap == null) {
            return null;
        }

        StringJoiner joiner = new StringJoiner(", ");

        for (Enchantment enchantment: enchantmentMap.keySet()) {
            joiner.add(getEnchantmentName(enchantment, enchantmentMap.get(enchantment)));
        }
        return joiner.toString();
    }

    @NotNull
    private String getCached(@NotNull String namespacedKey) {
        final String cachedTranslation = enchantmentTranslations.get(namespacedKey);
        if (cachedTranslation == null) {
            // Keep this behavior to ensure quick fixes
            throw new RuntimeException("Could not get the translation for '" + namespacedKey + "'. Report it to github");
        }
        return cachedTranslation;
    }

}
