package com.kckarnige.tooltouchups.mixin;

import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

import static com.kckarnige.tooltouchups.ItemRegister.DIAMOND_INGOT;

@Mixin(ToolMaterials.class)
public class VanillaToolChanges {

    @Mutable
    @Final
    @Shadow private Supplier<Ingredient> repairIngredient;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyDiamondMaterial(CallbackInfo ci) {
        replaceDiamondMaterial();
    }

    @Unique
    private static void replaceDiamondMaterial() {
        ToolMaterials diamondMaterial = ToolMaterials.DIAMOND;

        ((VanillaToolChanges) (Object) diamondMaterial).repairIngredient = () -> Ingredient.ofStacks(DIAMOND_INGOT.getDefaultStack());
    }
}