package de.epiceric.shopchest.language.enchantment;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface EnchantmentNameManager {

    @Nullable
    String getEnchantmentName(@Nullable Enchantment enchantment, int level);

    @Nullable
    String getEnchantmentName(@Nullable Map<Enchantment, Integer> enchantmentMap);

}
