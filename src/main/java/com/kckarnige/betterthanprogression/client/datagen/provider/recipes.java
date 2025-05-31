package com.kckarnige.betterthanprogression.client.datagen.provider;

import com.kckarnige.betterthanprogression.BlockRegister;
import com.kckarnige.betterthanprogression.ItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class recipes extends FabricRecipeProvider {
    public recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static ItemConvertible getWoolForColor(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_WOOL;
            case ORANGE -> Blocks.ORANGE_WOOL;
            case MAGENTA -> Blocks.MAGENTA_WOOL;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL;
            case YELLOW -> Blocks.YELLOW_WOOL;
            case LIME -> Blocks.LIME_WOOL;
            case PINK -> Blocks.PINK_WOOL;
            case GRAY -> Blocks.GRAY_WOOL;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL;
            case CYAN -> Blocks.CYAN_WOOL;
            case PURPLE -> Blocks.PURPLE_WOOL;
            case BLUE -> Blocks.BLUE_WOOL;
            case BROWN -> Blocks.BROWN_WOOL;
            case GREEN -> Blocks.GREEN_WOOL;
            case RED -> Blocks.RED_WOOL;
            case BLACK -> Blocks.BLACK_WOOL;
        };
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                // ===== Bed Stuff ===== //

                createShaped(RecipeCategory.MISC, ItemRegister.CLOTH)
                        .pattern("###")
                        .pattern("###")
                        .input('#', Items.STRING)
                        .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.PILLOW)
                        .pattern("===")
                        .pattern("-#-")
                        .pattern("===")
                        .input('-', Items.FEATHER)
                        .input('#', Items.WHITE_WOOL)
                        .input('=', ItemRegister.CLOTH)
                        .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                        .offerTo(exporter);

                for (DyeColor color : DyeColor.values()) {
                    ItemConvertible result = Registries.ITEM.get(Identifier.ofVanilla(color.getName() + "_bed")); // Your own logic
                    ItemConvertible wool = getWoolForColor(color);

                    createShaped(RecipeCategory.BUILDING_BLOCKS, result)
                            .pattern("#==")
                            .pattern("www")
                            .pattern("---")
                            .input('w', wool)
                            .input('-', ItemTags.PLANKS)
                            .input('=', ItemRegister.CLOTH)
                            .input('#', ItemRegister.PILLOW)
                            .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                            .offerTo(exporter, color.getName() + "_bed_left_sided");

                    createShaped(RecipeCategory.BUILDING_BLOCKS, result)
                            .pattern("==#")
                            .pattern("www")
                            .pattern("---")
                            .input('w', wool)
                            .input('-', ItemTags.PLANKS)
                            .input('=', ItemRegister.CLOTH)
                            .input('#', ItemRegister.PILLOW)
                            .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                            .offerTo(exporter, color.getName() + "_bed_right_sided");
                }

                // ===== Material Stuff ===== //

                createShapeless(RecipeCategory.MISC, ItemRegister.DIAMOND_INGOT)
                        .input(ItemRegister.STEEL_INGOT, 4)
                        .input(Items.DIAMOND, 4)
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, BlockRegister.STEEL_BLOCK)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ItemRegister.STEEL_INGOT)
                        .criterion(hasItem(ItemRegister.STEEL_INGOT), conditionsFromItem(ItemRegister.STEEL_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ItemRegister.STEEL_INGOT)
                        .input(Items.IRON_INGOT, 4)
                        .input(ItemTags.COALS)
                        .input(ItemTags.COALS)
                        .input(ItemTags.COALS)
                        .input(ItemTags.COALS)
                        .criterion(hasItem(Items.RAW_IRON), conditionsFromItem(Items.RAW_IRON))
                        .offerTo(exporter, "steel_ingot");

                createShaped(RecipeCategory.MISC, ItemRegister.STEEL_INGOT)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ItemRegister.STEEL_NUGGET)
                        .criterion(hasItem(ItemRegister.STEEL_INGOT), conditionsFromItem(ItemRegister.STEEL_INGOT))
                        .offerTo(exporter, "steel_ingot_from_nuggets");

                createShaped(RecipeCategory.MISC, ItemRegister.TOTEM_OF_SAFEKEEPING)
                        .pattern("#C#")
                        .pattern("#T#")
                        .pattern("###")
                        .input('C', Blocks.CHEST)
                        .input('#', ItemRegister.DIAMOND_INGOT)
                        .input('T', ItemRegister.TOTEM_OF_SAFEKEEPING)
                        .criterion(hasItem(ItemRegister.TOTEM_OF_SAFEKEEPING), conditionsFromItem(ItemRegister.TOTEM_OF_SAFEKEEPING))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ItemRegister.STEEL_INGOT, 9)
                        .input(BlockRegister.STEEL_BLOCK)
                        .criterion(hasItem(ItemRegister.STEEL_INGOT), conditionsFromItem(ItemRegister.STEEL_INGOT))
                        .offerTo(exporter, "steel_ingot_from_block");
            }
        };
    }


    @Override
    public String getName() {
        return "\"Better Than Progression\" Recipes";
    }
}
