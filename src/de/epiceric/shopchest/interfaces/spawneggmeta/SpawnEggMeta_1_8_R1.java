package de.epiceric.shopchest.interfaces.spawneggmeta;


import de.epiceric.shopchest.interfaces.SpawnEggMeta;
import net.minecraft.server.v1_8_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class SpawnEggMeta_1_8_R1 extends SpawnEggMeta {

    private ItemStack stack;

    public SpawnEggMeta_1_8_R1(ItemStack stack) {
        this.stack = stack;
    }

    public String getNBTEntityID() {
        net.minecraft.server.v1_8_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(stack);

        NBTTagCompound tag = nmsStack.getTag();

        return tag == null ? null : tag.getCompound("EntityTag").getString("id");
    }
}