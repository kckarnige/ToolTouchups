package com.kckarnige.tooltouchups;

import com.kckarnige.tooltouchups.utils.Tags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;


public class ToolMaterials implements ToolMaterial {
    public static final ToolMaterials COPPER = new ToolMaterials();


    @Override
    public int getDurability() {
        return 150;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return Tags.INCORRECT_FOR_COPPER_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }
}
