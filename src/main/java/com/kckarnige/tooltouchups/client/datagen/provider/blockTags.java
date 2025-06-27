package com.kckarnige.tooltouchups.client.datagen.provider;

import com.kckarnige.tooltouchups.utils.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class blockTags extends FabricTagProvider.BlockTagProvider {
    public blockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(Identifier.ofVanilla("iron_ore"))
                .add(Identifier.ofVanilla("deepslate_iron_ore"));

        getOrCreateTagBuilder(Tags.NEEDS_COPPER_TOOL)
                .add(Identifier.ofVanilla("iron_ore"))
                .add(Identifier.ofVanilla("deepslate_iron_ore"));
    }
}
