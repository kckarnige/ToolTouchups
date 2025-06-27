package com.kckarnige.tooltouchups.client.datagen.provider;

import com.kckarnige.tooltouchups.ItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.DyeColor;

import java.util.concurrent.CompletableFuture;

public class recipes extends FabricRecipeProvider {
    public recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShapeless(RecipeCategory.MISC, ItemRegister.DIAMOND_INGOT)
                        .input(Items.IRON_INGOT, 4)
                        .input(Items.DIAMOND, 4)
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.COPPER_SWORD)
                        .pattern("#")
                        .pattern("#")
                        .pattern("-")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.COPPER_AXE)
                        .pattern("##")
                        .pattern("#-")
                        .pattern(" -")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.COPPER_PICKAXE)
                        .pattern("###")
                        .pattern(" - ")
                        .pattern(" - ")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.COPPER_HOE)
                        .pattern("##")
                        .pattern(" -")
                        .pattern(" -")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.COPPER_SHOVEL)
                        .pattern("#")
                        .pattern("-")
                        .pattern("-")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
            }
        };
    }


    @Override
    public String getName() {
        return "\"Tool Touch-Ups\" Recipes";
    }
}
