package com.kckarnige.betterthanprogression.items;

import com.kckarnige.betterthanprogression.ItemRegister;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.*;

public class KeepInventoryTotem {

    private static final Map<UUID, List<ItemStack>> savedInventories = new HashMap<>();

    public static void keepIt() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, source, damageAmount) -> {
            if (!(entity instanceof ServerPlayerEntity player)) return true;

            if (hasTotem(player)) {
                consumeTotem(player);
                savedInventories.put(player.getUuid(), copyInventory(player));
                player.getInventory().clear();
            }
            return true;
        });

        ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {
            if (!alive && savedInventories.containsKey(oldPlayer.getUuid())) {
                restoreInventory(newPlayer, savedInventories.remove(oldPlayer.getUuid()));
            }
        });
    }

    private static boolean hasTotem(ServerPlayerEntity player) {
        for (ItemStack stack : player.getInventory().main) {
            if (stack.isOf(ItemRegister.TOTEM_OF_SAFEKEEPING)) return true;
        }
        for (ItemStack stack : player.getInventory().offHand) {
            if (stack.isOf(ItemRegister.TOTEM_OF_SAFEKEEPING)) return true;
        }
        return false;
    }

    private static List<ItemStack> copyInventory(ServerPlayerEntity player) {
        List<ItemStack> fullInventory = new ArrayList<>();
        fullInventory.addAll(player.getInventory().main.stream().map(ItemStack::copy).toList());
        fullInventory.addAll(player.getInventory().armor.stream().map(ItemStack::copy).toList());
        fullInventory.addAll(player.getInventory().offHand.stream().map(ItemStack::copy).toList());
        return fullInventory;
    }

    private static void consumeTotem(ServerPlayerEntity player) {
        for (int i = 0; i < player.getInventory().main.size(); i++) {
            ItemStack stack = player.getInventory().main.get(i);
            if (stack.isOf(ItemRegister.TOTEM_OF_SAFEKEEPING)) {
                stack.decrement(1);
                return;
            }
        }
        for (int i = 0; i < player.getInventory().offHand.size(); i++) {
            ItemStack stack = player.getInventory().offHand.get(i);
            if (stack.isOf(ItemRegister.TOTEM_OF_SAFEKEEPING)) {
                stack.decrement(1);
                return;
            }
        }
    }

    private static void restoreInventory(ServerPlayerEntity player, List<ItemStack> saved) {
        if (saved.size() != 41) return;

        for (int i = 0; i < 36; i++) {
            player.getInventory().main.set(i, saved.get(i));
        }
        for (int i = 0; i < 4; i++) {
            player.getInventory().armor.set(i, saved.get(36 + i));
        }
        player.getInventory().offHand.set(0, saved.get(40));
    }
}
