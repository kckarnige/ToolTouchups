package com.kckarnige.tooltouchups.client.datagen.provider;

import static com.kckarnige.tooltouchups.ItemRegister.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class itemTags extends FabricTagProvider.ItemTagProvider {
    public itemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Tools
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(COPPER_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(COPPER_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(COPPER_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(COPPER_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(COPPER_HOE);
        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(DIAMOND_INGOT);
    }
}
