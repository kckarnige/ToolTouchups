package com.kckarnige.betterthanprogression;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.kckarnige.betterthanprogression.Betterthanprogression.MOD_ID;

public class ItemRegister {

    public static final Item CLOTH = registerItem("cloth", new Item.Settings());
    public static final Item PILLOW = registerItem("pillow", new Item.Settings());
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item.Settings());
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item.Settings());
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item.Settings());
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item.Settings());

    private static Item registerItem (String id, Item.Settings item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new Item(item.registryKey(key)));
    }

    public static void registerModItems () {
        Betterthanprogression.LOGGER.info("Setting the crafting table...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.STRING,
                    CLOTH,
                    PILLOW
            );
            content.addBefore(Items.IRON_INGOT,
                    STEEL_NUGGET,
                    TIN_NUGGET,
                    STEEL_INGOT,
                    DIAMOND_INGOT
            );
        });
    }
}
