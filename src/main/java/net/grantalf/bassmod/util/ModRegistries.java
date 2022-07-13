package net.grantalf.bassmod.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.grantalf.bassmod.BassMod;
import net.grantalf.bassmod.block.ModBlocks;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
        registerFlammableBlocks();
        registerFuels();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.EBONY_LOG, ModBlocks.STRIPPED_EBONY_LOG);
        StrippableBlockRegistry.register(ModBlocks.EBONY_WOOD, ModBlocks.STRIPPED_EBONY_WOOD);
    }

    private static void registerFlammableBlocks() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.EBONY_LOG, 5, 5);
        instance.add(ModBlocks.EBONY_WOOD, 5, 5);
        instance.add(ModBlocks.EBONY_PLANKS, 5, 20);
        instance.add(ModBlocks.STRIPPED_EBONY_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_EBONY_WOOD, 5, 5);
    }

    private static void registerFuels() {
        BassMod.LOGGER.info("Registering Fuels for " + BassMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBlocks.EBONY_LOG, 300);
        registry.add(ModBlocks.EBONY_WOOD, 300);
        registry.add(ModBlocks.STRIPPED_EBONY_LOG, 300);
        registry.add(ModBlocks.STRIPPED_EBONY_WOOD, 300);
        registry.add(ModBlocks.EBONY_FENCE, 300);
        registry.add(ModBlocks.EBONY_FENCE_GATE, 300);
    }

}
