package com.kckarnige.betterthanprogression;

import com.kckarnige.betterthanprogression.blocks.BedChanges;
import com.kckarnige.betterthanprogression.items.KeepInventoryTotem;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Betterthanprogression implements ModInitializer {

    public static final String MOD_ID = "betterthanprogression";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better Than Progression");

    @Override
    public void onInitialize() {
        ItemRegister.registerModItems();
        BlockRegister.registerModBlocks();
        KeepInventoryTotem.keepIt();
        BedChanges.registerBedUseCallback();
        BedChanges.registerBedBreakCallback();
    }
}
