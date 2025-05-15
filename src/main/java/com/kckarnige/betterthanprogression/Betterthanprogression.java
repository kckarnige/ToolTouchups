package com.kckarnige.betterthanprogression;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Betterthanprogression implements ModInitializer {

    public static final String MOD_ID = "betterthanprogression";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better Than Progression");

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() instanceof BedBlock) {
                if (!world.isClient) {
                    if (player instanceof ServerPlayerEntity serverPlayer) {
                        serverPlayer.setSpawnPoint(world.getRegistryKey(), pos, 0, true, true);
                        player.swingHand(hand);
                        return ActionResult.SUCCESS;
                    }
                }
            }
            return ActionResult.PASS;
        });
        ItemRegister.registerModItems();
        BlockRegister.registerModBlocks();
    }
}
