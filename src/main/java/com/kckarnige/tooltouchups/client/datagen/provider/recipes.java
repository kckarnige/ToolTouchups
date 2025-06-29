package com.kckarnige.tooltouchups.client.datagen.provider;

import com.kckarnige.tooltouchups.ItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class recipes extends FabricRecipeProvider {
    public recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate (RecipeExporter exporter) {
                ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegister.DIAMOND_INGOT)
                        .input(Items.IRON_INGOT, 4)
                        .input(Items.DIAMOND, 4)
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegister.COPPER_SWORD)
                        .pattern("#")
                        .pattern("#")
                        .pattern("-")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegister.COPPER_AXE)
                        .pattern("##")
                        .pattern("#-")
                        .pattern(" -")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegister.COPPER_PICKAXE)
                        .pattern("###")
                        .pattern(" - ")
                        .pattern(" - ")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegister.COPPER_HOE)
                        .pattern("##")
                        .pattern(" -")
                        .pattern(" -")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemRegister.COPPER_SHOVEL)
                        .pattern("#")
                        .pattern("-")
                        .pattern("-")
                        .input('#', Items.COPPER_INGOT)
                        .input('-', Items.STICK)
                        .criterion(hasItem(Items.RAW_COPPER), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
    }


    @Override
    public String getName() {
        return "\"Tool Touch-Ups\" Recipes";
    }
}
