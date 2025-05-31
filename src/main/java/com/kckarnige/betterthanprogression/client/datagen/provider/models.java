package com.kckarnige.betterthanprogression.client.datagen.provider;

import com.kckarnige.betterthanprogression.ItemRegister;
import com.kckarnige.betterthanprogression.BlockRegister;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

import static com.kckarnige.betterthanprogression.items.SteelMaterial.Armor.STEEL_KEY;

public class models extends FabricModelProvider {

    public models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemRegister.TOTEM_OF_SAFEKEEPING, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.PILLOW, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.DIAMOND_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.TIN_NUGGET, Models.GENERATED);

        // Tools
        itemModelGenerator.register(ItemRegister.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_HOE, Models.HANDHELD);
        // Armor
        itemModelGenerator.registerArmor(ItemRegister.STEEL_HELMET, STEEL_KEY, "helmet", false);
        itemModelGenerator.registerArmor(ItemRegister.STEEL_CHESTPLATE, STEEL_KEY, "chestplate", false);
        itemModelGenerator.registerArmor(ItemRegister.STEEL_LEGGINGS, STEEL_KEY, "leggings", false);
        itemModelGenerator.registerArmor(ItemRegister.STEEL_BOOTS, STEEL_KEY, "boots", false);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.STEEL_BLOCK);
    }
}
