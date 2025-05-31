package com.kckarnige.betterthanprogression.blocks;

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

    // Maps: Bed position -> Owner UUID
    private static final Map<BlockPos, UUID> bedOwners = new HashMap<>();
    // Maps: Player UUID -> Their bed spawn position
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
            UUID currentOwner = bedOwners.get(pos);

            // Prevent other players from using this bed
            if (currentOwner != null && !currentOwner.equals(playerId)) {
                serverPlayer.sendMessage(Text.translatable("block.minecraft.bed.occupied"), true);
                return ActionResult.FAIL;
            }

            // If already set
            if (pos.equals(spawnBeds.get(playerId))) {
                serverPlayer.sendMessage(Text.translatable("block.betterthanprogression.already_set_spawn"), true);
            } else {
                // Remove previous spawn ownership if exists
                BlockPos oldBed = spawnBeds.get(playerId);
                if (oldBed != null) {
                    bedOwners.remove(oldBed);
                }

                // Set new ownership and spawnpoint
                spawnBeds.put(playerId, pos);
                bedOwners.put(pos, playerId);

                serverPlayer.setSpawnPoint(world.getRegistryKey(), pos, 0.0f, true, false);
                serverPlayer.sendMessage(Text.translatable("block.minecraft.set_spawn"), true);
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

            // Always get the head of the bed
            if (state.get(BedBlock.PART) != BedPart.HEAD) {
                Direction facing = state.get(BedBlock.FACING);
                pos = pos.offset(facing);
            }

            UUID owner = bedOwners.remove(pos);
            if (owner != null) {
                spawnBeds.remove(owner);
                ServerPlayerEntity ownerPlayer = Objects.requireNonNull(world.getServer()).getPlayerManager().getPlayer(owner);
                if (ownerPlayer != null) {
                    ownerPlayer.sendMessage(Text.translatable("block.minecraft.spawn.not_valid"), false);
                    ownerPlayer.setSpawnPoint(null, null, 0.0f, false, false);
                }
            }

            return true;
        });
    }
}