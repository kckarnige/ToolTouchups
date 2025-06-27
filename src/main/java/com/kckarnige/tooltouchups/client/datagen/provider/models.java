package com.kckarnige.tooltouchups.client.datagen.provider;

import com.kckarnige.tooltouchups.ItemRegister;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class models extends FabricModelProvider {

    public models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemRegister.DIAMOND_INGOT, Models.GENERATED);
        // Tools
        itemModelGenerator.register(ItemRegister.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.COPPER_HOE, Models.HANDHELD);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }
}
