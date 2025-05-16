package com.kckarnige.betterthanprogression;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BedPart;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class BedChanges {

    private static final Map<UUID, BlockPos> spawnBeds = new HashMap<>();

    public static void registerBedUseCallback() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);

            if (!(state.getBlock() instanceof BedBlock)) {
                return ActionResult.PASS;
            }

            if (!(player instanceof ServerPlayerEntity serverPlayer)) {
                return ActionResult.PASS;
            }

            // Always get the head of the bed
            if (state.get(BedBlock.PART) != BedPart.HEAD) {
                Direction facing = state.get(BedBlock.FACING);
                pos = pos.offset(facing);
            }

            UUID playerId = serverPlayer.getUuid();
            BlockPos trackedSpawn = spawnBeds.get(playerId);

            if (pos.equals(trackedSpawn)) {
                serverPlayer.sendMessage(Text.translatable("block.betterthanprogression.already_set_spawn"), false);
            } else {
                spawnBeds.put(playerId, pos);
                serverPlayer.setSpawnPoint(world.getRegistryKey(), pos, 0.0f, true, false);
                serverPlayer.sendMessage(Text.translatable("block.minecraft.set_spawn"), false);
            }
            player.swingHand(hand, true);
            return ActionResult.SUCCESS;
        });
    }

    public static void registerBedBreakCallback() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (!(state.getBlock() instanceof BedBlock)) {
                return true;
            }

            // Get head of the bed
            if (state.get(BedBlock.PART) != BedPart.HEAD) {
                Direction facing = state.get(BedBlock.FACING);
                pos = pos.offset(facing);
            }

            // Remove spawn association for any player
            BlockPos finalPos = pos;
            spawnBeds.entrySet().removeIf(entry -> {
                if (entry.getValue().equals(finalPos)) {
                    ServerPlayerEntity serverPlayer = Objects.requireNonNull(world.getServer()).getPlayerManager().getPlayer(entry.getKey());
                    if (serverPlayer != null) {
                        serverPlayer.sendMessage(Text.translatable("block.minecraft.spawn.not_valid"), false);
                        serverPlayer.setSpawnPoint(null, null, 0.0f, false, false);
                    }
                    return true;
                }
                return false;
            });

            return true;
        });
    }
}
