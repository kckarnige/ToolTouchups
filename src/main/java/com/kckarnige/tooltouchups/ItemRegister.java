package com.kckarnige.tooltouchups;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kckarnige.tooltouchups.tooltouchups.MOD_ID;
import static com.kckarnige.tooltouchups.ToolMaterials.COPPER;

public class ItemRegister {
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item(new Item.Settings()));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(COPPER, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(COPPER, 3, -2.4F))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(COPPER, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(COPPER, 1.5F, -3.0F))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(COPPER, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(COPPER, 1.0F, -2.8F))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(COPPER, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(COPPER, 7.0F, -3.2F))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(COPPER, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(COPPER, -1.0F, -1.0F))));


    private static Item registerItem (String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, id), item);
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
