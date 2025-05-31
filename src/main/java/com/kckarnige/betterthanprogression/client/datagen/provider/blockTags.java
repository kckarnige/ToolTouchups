package com.kckarnige.betterthanprogression.client.datagen.provider;

import com.kckarnige.betterthanprogression.utils.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static com.kckarnige.betterthanprogression.BlockRegister.STEEL_BLOCK;

public class blockTags extends FabricTagProvider.BlockTagProvider {
    public blockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(Identifier.ofVanilla("diamond_ore"))
                .add(Identifier.ofVanilla("deepslate_diamond_ore"));
        getOrCreateTagBuilder(Tags.NEEDS_STEEL_TOOL)
                .add(Identifier.ofVanilla("diamond_ore"))
                .add(Identifier.ofVanilla("deepslate_diamond_ore"));
        getOrCreateTagBuilder(Tags.INCORRECT_FOR_STEEL_TOOL)
                .add(Identifier.ofVanilla("ancient_debris"));
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Identifier.ofVanilla("diamond_ore"))
                .add(Identifier.ofVanilla("deepslate_diamond_ore"));
    }
}
