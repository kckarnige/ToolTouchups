package com.kckarnige.tooltouchups;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.kckarnige.tooltouchups.tooltouchups.MOD_ID;
import static com.kckarnige.tooltouchups.ToolMaterials.COPPER;

public class ItemRegister {
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item.Settings());
    public static final Item COPPER_SWORD = registerSwordItem("copper_sword",
            new Item.Settings(), COPPER, 3.0F, -2.4F);
    public static final Item COPPER_SHOVEL = registerShovelItem("copper_shovel",
            new Item.Settings(), COPPER, 1.0F, -3.0F);
    public static final Item COPPER_PICKAXE = registerPickaxeItem("copper_pickaxe",
            new Item.Settings(), COPPER, 1.0F, -2.8F);
    public static final Item COPPER_AXE = registerAxeItem("copper_axe",
            new Item.Settings(), COPPER, 5.0F, -3.2F);
    public static final Item COPPER_HOE = registerHoeItem("copper_hoe",
            new Item.Settings(), COPPER, -1.0F, -1.0F);

    private static Item registerItem (String id, Item.Settings item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new Item(item.registryKey(key)));
    }
    private static Item registerSwordItem (String id, Item.Settings item, ToolMaterial material, float atkDmg, float atkSpeed) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new SwordItem(material, atkDmg, atkSpeed, item.registryKey(key)));
    }
    private static Item registerShovelItem (String id, Item.Settings item, ToolMaterial material, float atkDmg, float atkSpeed) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new ShovelItem(material, atkDmg, atkSpeed, item.registryKey(key)));
    }
    private static Item registerPickaxeItem (String id, Item.Settings item, ToolMaterial material, float atkDmg, float atkSpeed) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new PickaxeItem(material, atkDmg, atkSpeed, item.registryKey(key)));
    }
    private static Item registerAxeItem (String id, Item.Settings item, ToolMaterial material, float atkDmg, float atkSpeed) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new AxeItem(material, atkDmg, atkSpeed, item.registryKey(key)));
    }
    private static Item registerHoeItem (String id, Item.Settings item, ToolMaterial material, float atkDmg, float atkSpeed) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new HoeItem(material, atkDmg, atkSpeed, item.registryKey(key)));
    }


    public static void registerModItems () {
        tooltouchups.LOGGER.info("Setting the crafting table...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addBefore(Items.NETHERITE_SCRAP,
                    DIAMOND_INGOT
            );
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.STONE_SWORD,
                    COPPER_SWORD
            );
            content.addAfter(Items.STONE_AXE,
                    COPPER_AXE
            );
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.STONE_HOE,
                    COPPER_SHOVEL,
                    COPPER_PICKAXE,
                    COPPER_AXE,
                    COPPER_HOE
            );
        });
    }
}
