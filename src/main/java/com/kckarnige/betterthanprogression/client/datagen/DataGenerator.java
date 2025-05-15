package com.kckarnige.betterthanprogression.client.datagen;

import com.kckarnige.betterthanprogression.client.datagen.provider.models;
import com.kckarnige.betterthanprogression.client.datagen.provider.blockTags;
import com.kckarnige.betterthanprogression.client.datagen.provider.recipes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(models::new);
        pack.addProvider(blockTags::new);
        pack.addProvider(recipes::new);
    }
}
