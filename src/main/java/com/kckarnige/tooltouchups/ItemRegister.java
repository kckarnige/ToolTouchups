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
    public static final Item COPPER_SWORD = registerToolItem("copper_sword",
            new Item.Settings(),"sword", COPPER, 3.0F, -2.4F);
    public static final Item COPPER_SHOVEL = registerToolItem("copper_shovel",
            new Item.Settings(),"shovel", COPPER, 1.5F, -3.0F);
    public static final Item COPPER_PICKAXE = registerToolItem("copper_pickaxe",
            new Item.Settings(),"pickaxe", COPPER, 1.0F, -2.8F);
    public static final Item COPPER_AXE = registerToolItem("copper_axe",
            new Item.Settings(),"axe", COPPER, 7.0F, -3.2F);
    public static final Item COPPER_HOE = registerToolItem("copper_hoe",
            new Item.Settings(),"hoe", COPPER, -1.0F, -1.0F);

    private static Item registerItem (String id, Item.Settings item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new Item(item.registryKey(key)));
    }
    private static Item registerToolItem (String id, Item.Settings item, String ToolType, ToolMaterial material, float atkDmg, float atkSpeed) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return switch (ToolType) {
            case "sword" ->
                    Registry.register(Registries.ITEM, key, new SwordItem(material, atkDmg, atkSpeed, item.registryKey(key)));
            case "shovel" ->
                    Registry.register(Registries.ITEM, key, new ShovelItem(material, atkDmg, atkSpeed, item.registryKey(key)));
            case "pickaxe" ->
                    Registry.register(Registries.ITEM, key, new PickaxeItem(material, atkDmg, atkSpeed, item.registryKey(key)));
            case "axe" ->
                    Registry.register(Registries.ITEM, key, new AxeItem(material, atkDmg, atkSpeed, item.registryKey(key)));
            case "hoe" ->
                    Registry.register(Registries.ITEM, key, new HoeItem(material, atkDmg, atkSpeed, item.registryKey(key)));
            default ->
                    throw new IllegalStateException("Unexpected value: " + ToolType);
        };
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
