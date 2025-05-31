package com.kckarnige.betterthanprogression;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static com.kckarnige.betterthanprogression.Betterthanprogression.MOD_ID;
import static com.kckarnige.betterthanprogression.items.SteelMaterial.Armor.STEEL_ARMOR_MATERIAL;
import static com.kckarnige.betterthanprogression.items.SteelMaterial.Tools.STEEL;

public class ItemRegister {

    public static final Item TOTEM_OF_SAFEKEEPING = registerItem("totem_of_safekeeping", new Item.Settings().maxCount(1).rarity(Rarity.RARE));
    public static final Item CLOTH = registerItem("cloth", new Item.Settings());
    public static final Item PILLOW = registerItem("pillow", new Item.Settings());
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item.Settings());
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item.Settings());
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item.Settings());
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item.Settings());


    public static final Item STEEL_HELMET = registerArmorItem("steel_helmet",
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(26)), STEEL_ARMOR_MATERIAL, EquipmentType.HELMET);
    public static final Item STEEL_CHESTPLATE = registerArmorItem("steel_chestplate",
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(26)), STEEL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE);
    public static final Item STEEL_LEGGINGS = registerArmorItem("steel_leggings",
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(26)), STEEL_ARMOR_MATERIAL, EquipmentType.LEGGINGS);
    public static final Item STEEL_BOOTS = registerArmorItem("steel_boots",
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(26)), STEEL_ARMOR_MATERIAL, EquipmentType.BOOTS);

    public static final Item STEEL_SWORD = registerSwordItem("steel_sword",
            new Item.Settings(), STEEL, 3, -2.8F);
    public static final Item STEEL_SHOVEL = registerShovelItem("steel_shovel",
            new Item.Settings(), STEEL, 1.5F, -3.2F);
    public static final Item STEEL_PICKAXE = registerPickaxeItem("steel_pickaxe",
            new Item.Settings(), STEEL, 1.0F, -3.0F);
    public static final Item STEEL_AXE = registerAxeItem("steel_axe",
            new Item.Settings(), STEEL, 5.0F, -3.4F);
    public static final Item STEEL_HOE = registerHoeItem("steel_hoe",
            new Item.Settings(), STEEL, -3.0F, -1.0F);


    private static Item registerItem (String id, Item.Settings item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new Item(item.registryKey(key)));
    }
    private static Item registerArmorItem (String id, Item.Settings item, ArmorMaterial material, EquipmentType type) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new ArmorItem(material, type, item.registryKey(key)));
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {

            content.addBefore(Items.TOTEM_OF_UNDYING,
                    TOTEM_OF_SAFEKEEPING
            );
            content.addBefore(Items.GOLDEN_SWORD,
                    STEEL_SWORD
            );
            content.addBefore(Items.GOLDEN_AXE,
                    STEEL_AXE
            );
            content.addBefore(Items.GOLDEN_HELMET,
                    STEEL_HELMET,
                    STEEL_CHESTPLATE,
                    STEEL_LEGGINGS,
                    STEEL_BOOTS
            );
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addBefore(Items.GOLDEN_SHOVEL,
                    STEEL_SHOVEL,
                    STEEL_PICKAXE,
                    STEEL_AXE,
                    STEEL_HOE);
        });
    }
}
