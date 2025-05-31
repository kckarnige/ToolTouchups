package com.kckarnige.betterthanprogression.items.SteelMaterial;

import com.kckarnige.betterthanprogression.utils.Tags;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

import static com.kckarnige.betterthanprogression.Betterthanprogression.MOD_ID;

public class Armor {
    public static EquipmentModel STEEL = EquipmentModel.builder().addHumanoidLayers(Identifier.of(MOD_ID,"steel")).build();

    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> STEEL_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MOD_ID, "steel"));

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 7);
    }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,1.0f,0.0f, Tags.STEEL_ITEM_REPAIR, STEEL_KEY);
}
