package com.kckarnige.betterthanprogression.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import static com.kckarnige.betterthanprogression.Betterthanprogression.MOD_ID;
public class Tags {

    public static final TagKey<Block> NEEDS_STEEL_TOOL = createBlockTag("needs_steel_tool");
    public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createBlockTag("incorrect_for_steel_tool");
    public static final TagKey<Item> STEEL_ITEM_REPAIR = createItemTag("steel_tool_repair");


    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
    }
    private static TagKey<Item> createItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
    }
}
