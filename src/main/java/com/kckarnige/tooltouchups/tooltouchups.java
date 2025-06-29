package com.kckarnige.tooltouchups;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class tooltouchups implements ModInitializer {

    public static final String MOD_ID = "tooltouchups";
    public static final Logger LOGGER = LoggerFactory.getLogger("KiCK's Tool Touch-Ups");

    @Override
    public void onInitialize() {
        ItemRegister.registerModItems();
    }
}
