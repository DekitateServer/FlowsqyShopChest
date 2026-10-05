package de.epiceric.shopchest.nms.paper.v1_21_7;

import de.epiceric.shopchest.nms.TextComponentHelper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class TextComponentHelperImpl implements TextComponentHelper {

    @Override
    public Consumer<Player> getSendableItemInfo(String message, String itemPlaceHolder,
                                              ItemStack itemStack, String productName) {
        final LegacyComponentSerializer serializer = LegacyComponentSerializer.legacySection();
        // Paper's hover API preserves modern data components; Bungee ItemTag uses the legacy tag format.
        final Component preview = serializer.deserialize(productName)
                .hoverEvent(itemStack.asOne().asHoverEvent());
        // A replacement may become the parent of trailing template text. Scope the hover and
        // product formatting to a child so that text only inherits the template's formatting.
        final Component replacement = Component.empty().append(preview);
        // Parse the entire template so formatting continues across every placeholder.
        final Component component = serializer.deserialize(message).replaceText(builder -> builder
                .matchLiteral(itemPlaceHolder)
                .replacement(replacement));

        return player -> player.sendMessage(component);
    }

}
