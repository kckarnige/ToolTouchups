package com.kckarnige.betterthanprogression.client.datagen.provider;

import com.kckarnige.betterthanprogression.ItemRegister;
import com.kckarnige.betterthanprogression.BlockRegister;
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
        itemModelGenerator.register(ItemRegister.CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.PILLOW, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.DIAMOND_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.TIN_NUGGET, Models.GENERATED);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.STEEL_BLOCK);
    }
}
